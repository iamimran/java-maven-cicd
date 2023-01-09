#!/usr/bin/env groovy

@Library('jenkins-shared-library')
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
                    buildJar()
                }
            }
        }

        stage("build docker image") {
            steps {
                script {
                    buildAndPushDockerImage()
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
