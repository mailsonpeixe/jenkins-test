#!/usr/bin/env groovy

pipeline {
    agent any
    options {
        timestamps()
    }
    stages {
        stage('Build project A') {
            when {
                changeset "project-a/**"
            }
            steps {
                load 'project-a/Jenkinsfile'
            }
        }
        stage('Build project B') {
            when {
                changeset "project-b/**"
            }
            steps {
                load 'project-b/Jenkinsfile'
            }
        }
    }
}