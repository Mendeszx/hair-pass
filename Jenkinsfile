pipeline {
    agent any
        stages {
            stage('Clean e install') {
                steps {
                    sh 'mvn clean install -DskipTests=true'
                }
            }

            stage('Testes Unitarios') {
                steps {
                    sh 'mvn test'
                }
            }

            stage('Derrubando o container antigo') {
                steps {
                    script {
                        try {
                            sh 'docker rm -f django-todolist-dev'
                        } catch (Exception e) {
                            sh "echo $e"
                        }
                    }
                }
            }

            stage('Build da nova imagem') {
                steps {
                    script {
                        sh 'ls'

                        def projectDirectory = "/var/lib/jenkins/workspace/app-dev"

                        dir(projectDirectory) {

                        sh 'ls' // Exemplo: Listar conteúdo da pasta
                        sh 'docker-compose build' // Exemplo: Executar build do Docker Compose
                        }
                    }
                }
            }

            stage('Deploy Backend') {
                steps {
                    script {
                        try {
                            echo 'teste'
                        } catch (Exception e) {
                            sh "echo $e"
                        }
                    }
                }
            }
        }
}
