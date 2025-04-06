# Étape 1 : build avec Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : déploiement sur Tomcat
FROM tomcat:10.1.13-jdk17-temurin
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/
EXPOSE 8080




