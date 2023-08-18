pipeline {
    agent none

    stages {
        stage('Test') {
            agent { docker 'openjdk/openjdk:17-alpine' }
            steps {
                sh './mvnw clean'
            }
        }
        stage('Build') {
            agent { docker 'openjdk/openjdk:17-alpine' }
            steps {
                sh './mvnw install'
            }
        }
        stage('Store') {
            agent any
            steps {
                echo 'Armazenando...'
            }
        }
        stage('Deploy') {
            agent any
            steps {
                echo 'Implantando...'
            }
        }
    }
}