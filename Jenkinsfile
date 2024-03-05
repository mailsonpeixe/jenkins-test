#!/usr/bin/env groovy
pipeline {
    agent any

    stages {
       stage('Run Project Mirror') {
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
       stage('Run Project Service') {
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
