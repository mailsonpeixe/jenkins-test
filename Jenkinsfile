@Library('WorkflowCiSharedLib') _

def URL

def buildProject(projectDir) {
                // withDockerRegistry([credentialsId: "dockerhub", url: ""]) {
                    script {
                        dir(projectDir) {
                            sh './build.sh'
                        }
                    }
                // }

    }

pipeline {

  agent any

  options {
    ansiColor('xterm')
  }

  stages {
      stage('Prepare') {
        steps {
          script {
            commentJiraPr()
          }
        }
      }
      stage('Run Project Mirror') {
          when {
              changeset "clamav/mirror/**"
          }
         steps {
           buildProject('/clamav/mirror')
           }
      }
      stage('Run Project Service') {
         when {
             changeset "clamav/service/**"
         }
         steps {
           buildProject('/clamav/service')
           }
      }
      stage('Run Project Scheduler') {
         when {
             changeset "clamav/scheduler/**"
         }
         steps {
           buildProject('/clamav/scheduler')
           }
      }

  }
}