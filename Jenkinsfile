pipeline {
    agent { docker 'openjdk:17-alpine' }

    stages {
        stage('Test') {
            steps {
                sh './mvnw clean'
            }
        }
        stage('Build') {
            agent { docker 'openjdk:17-alpine' }
            steps {
                sh './mvnw install'
            }
        }
        stage('Store') {
            steps {
                echo 'Armazenando...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Implantando...'
            }
        }
    }
}