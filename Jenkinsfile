pipeline {
    agent any

    environment {
        IMAGE_NAME = 'saadnadi/projet-saadnadi'
        DOCKER_CREDENTIALS_ID = 'dockerhub-credentials' // à configurer dans Jenkins
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

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${IMAGE_NAME}")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', "${DOCKER_CREDENTIALS_ID}") {
                        docker.image("${IMAGE_NAME}").push('latest')
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline exécuté avec succès!'
        }
        failure {
            echo 'Le pipeline a échoué.'
        }
    }
}

