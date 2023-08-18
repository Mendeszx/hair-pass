pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clonar o repositório Git
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Construir o projeto Spring Boot usando o Maven
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Executar os testes do projeto Spring Boot
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Construir a imagem Docker do projeto
                sh 'docker build -t meu-projeto-spring .'

                // Executar um container Docker com a imagem
                sh 'docker run -d -p 8080:8080 meu-projeto-spring'
            }
        }
    }
}