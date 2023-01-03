def buildJarFile() {
    echo "Building the application..."
    sh "mvn package"
}

def buildAndPushDockerImage() {
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t iamimran/java-maven-app:jma1.0 .'
        sh "echo $PASS | docker login -u $USERNAME --password-stdin"
        sh "docker push iamimran/java-maven-app:jma1.0"
    }
}

def deployApp() {
    echo "Deploying the application"
}

return this
