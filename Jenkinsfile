pipeline {
    agent any

    environment {
        SONAR_HOST_URL = 'http://localhost:9000'
        SONAR_TOKEN = credentials('sonarqube-creds')
        DOCKER_IMAGE_NAME = 'ahsatout/schoolmanagement'
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean verify'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat """
                        mvn sonar:sonar ^
                          -Dsonar.projectKey=Java-Sonar-Test-Docker ^
                          -Dsonar.host.url=${SONAR_HOST_URL} ^
                          -Dsonar.login=${SONAR_TOKEN} ^
                          -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
                    """
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }

    post {
        success {
            emailext(
                subject: "Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                    The build was successful.
                    Job: ${env.JOB_NAME}
                    Build: ${env.BUILD_NUMBER}
                    Logs: ${env.BUILD_URL}
                    Docker Image: ${DOCKER_IMAGE_NAME}:${env.BUILD_NUMBER}
                """,
                to: 'hakim.satout@gmail.com'
            )
        }
        failure {
            emailext(
                subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                    The build failed.
                    Job: ${env.JOB_NAME}
                    Build: ${env.BUILD_NUMBER}
                    Logs: ${env.BUILD_URL}
                """,
                to: 'hakim.satout@gmail.com'
            )
        }
    }
}
