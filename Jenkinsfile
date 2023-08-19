pipeline {
    agent any

        stages {
            stage('Test') {
                steps {
                    sh 'mvn clean package'
                    sh 'mvn test'
                }
            }

        stage('Build') {
            steps {
                sh 'mvn install'
            }
        }
    }
}
