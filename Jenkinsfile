#!/usr/bin/env groovy
pipeline {
    agent any

    stages {
       stage('Run Project Mirror') {
           when {
               changeset "project-a/mirror/**"
           }
          steps {
            buildProject('/project-a/mirror')
            }
       }
       stage('Run Project Service') {
          when {
              changeset "project-a/service/**"
          }
          steps {
            buildProject('/project-a/service')
            }
       }
    }
}
def buildProject(projectDir) {
                withDockerRegistry([credentialsId: "dockerhub", url: ""]) {
                    script {
                        dir(projectDir) {
                            sh './build.sh'
                        }
                    }
                }

    }
