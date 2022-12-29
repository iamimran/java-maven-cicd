pipeline {
    agent any
    tools {
        maven "maven-3.8.6"
    }
    stages {

        stage("build jar") {
            steps {
                script {
                    echo "Building the application..."
                    sh "mvn package"
                }
            }
        }

        stage("build docker image") {
            steps {
                script {
                    echo "Building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USERNAME')]) {
                        sh 'docker build -t iamimran/java-maven-app:jma1.0 .'
                        sh "echo $PASS | docker login -u $USERNAME --pasword-stdin"
                        sh "docker push iamimran/java-maven-app:jma1.0"
                    }

                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "Deploying the application"
                }
            }
        }
    }
}
