
# Étape 1 : image de base avec Maven et JDK 17
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copie tous les fichiers du projet vers le conteneur
COPY . .

# Compile le projet (sans les tests)
RUN mvn clean package -DskipTests

# Étape 2 : image finale (facultatif si tu veux exécuter dans un conteneur Tomcat par exemple)
# FROM tomcat:10.1.13-jdk17-temurin
# COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/


