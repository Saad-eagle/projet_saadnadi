pipeline {
    agent any

    tools {
        maven 'Maven_3.9.4'  // Nom de l'outil Maven dans Jenkins (à ajuster selon ta config)
    }

    environment {
        IMAGE_NAME = 'projet-saadnadi'
        DOCKERHUB_USERNAME = 'votre_nom_dockerhub' // à personnaliser
    }

    stages {
        stage('Cloner le dépôt') {
            steps {
                git 'https://github.com/Saad-eagle/projet_saadnadi.git'
            }
        }

        stage('Build Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Push DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker tag $IMAGE_NAME $DOCKER_USER/$IMAGE_NAME
                        docker push $DOCKER_USER/$IMAGE_NAME
                    '''
                }
            }
        }
    }
}
