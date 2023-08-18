pipeline {
    agent none

    stages {
        stage('Test') {
            agent { docker 'openjdk:17-alpine' }
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