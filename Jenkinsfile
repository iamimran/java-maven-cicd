def gv
pipeline {
    agent any

    tools {
        maven "maven-3.8.6"
    }

    stages {

        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    gv.buildJarFile()
                }
            }
        }

        stage("build docker image") {
            steps {
                script {
                    gv.buildAndPushDockerImage()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
