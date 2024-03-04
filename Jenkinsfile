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
                build job: 'project-a', wait: true
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