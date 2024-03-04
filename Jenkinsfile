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
                build './project-a/Jenkinsfile'
            }
        }
        stage('Build project B') {
            when {
                changeset "project-b/**"
            }
            steps {
                build 'project-b'
            }
        }
    }
}