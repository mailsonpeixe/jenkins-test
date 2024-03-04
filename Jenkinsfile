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

       stage('Run Projects A') {
                   steps {
                       script {
                           parallel (
                               "Project A": { buildProject('project-a') }
                               // Add more projects as needed
                           )
                       }
                   }
       }
       stage('Run Projects') {
                   steps {
                       script {
                           parallel (
                               "Project B": { buildProject('project-b') }
                               // Add more projects as needed
                           )
                       }
                   }
       }
        // Add more stages as needed
    }
}

def buildProject(projectDir) {
    dir(projectDir) {
        load 'Jenkinsfile'
    }
}