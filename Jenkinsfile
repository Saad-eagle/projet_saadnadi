pipeline {
    agent any

    environment {
        IMAGE_NAME = 'jakartaee-students'
        IMAGE_TAG = 'latest'
        CONTAINER_NAME = 'jakartaee-container'
        PORTS = '8085:8080'
    }

    stages {
        stage('📦 Cloner le dépôt') {
            steps {
                git url: 'https://github.com/Saad-eagle/projet_saadnadi.git'
            }
        }

        stage('🔨 Compiler avec Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('🐳 Construire l\'image Docker') {
            steps {
                sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
            }
        }

        stage('🧹 Supprimer ancien conteneur') {
            steps {
                sh '''
                docker stop $CONTAINER_NAME || true
                docker rm $CONTAINER_NAME || true
                '''
            }
        }

        stage('🚀 Lancer nouveau conteneur') {
            steps {
                sh '''
                docker run -d --name $CONTAINER_NAME -p $PORTS $IMAGE_NAME:$IMAGE_TAG
                '''
            }
        }
    }

    post {
        failure {
            echo '❌ Le pipeline a échoué.'
        }
        success {
            echo '✅ Le pipeline a terminé avec succès !'
        }
    }
}
