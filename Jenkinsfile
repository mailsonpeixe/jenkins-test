#!/usr/bin/env groovy
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    echo "Building the main project"
                    // Add your main build steps here
                }
            }
        }

       stage('Run Projects Mirror') {
                    when {
                        changeset "project-a/mirror/**"
                    }
                   steps {
                       script {
                           dir('project-a/mirror/') {
                               sh './build.sh'
                           }
                       }
                   }
       }

              stage('Run Projects Mirror') {
                           when {
                               changeset "project-a/service/**"
                           }
                          steps {
                              script {
                                  dir('project-a/service/') {
                                      sh './build.sh'
                                  }
                              }
                          }
              }

    }
}

def buildProject(projectDir) {
    dir(projectDir) {
        load 'Jenkinsfile'
    }
}