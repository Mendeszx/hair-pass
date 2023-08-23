pipeline {
    agent any
        stages {
            stage('Clean e install') {
                steps {
                    sh 'mvn clean package -DskipTests=true'
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
                        def dockerCompose = dockerCompose(
                                                composeFile: 'docker-compose.yml',
                                                build: true,
                                                up: false,
                                                down: false
                                                )
                        dockerCompose.dockerComposeBuild()
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
}
