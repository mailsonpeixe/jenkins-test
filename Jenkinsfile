
def buildServiceImage(serviceDir) {
  script {
      dir(serviceDir) {
        sh './build.sh'
      }
  }
}

pipeline {
  agent any

  stages {
    stage('Build and Push Clamav Mirror Docker Image') {
      when {
        allOf {
          expression { BRANCH_NAME ==~ /(production|develop)/ }
          changeset 'images/clamav/mirror/build.sh'
        }
      }
      steps {
        buildServiceImage('./images/clamav/mirror')
      }
    }
    stage('Build and Push Clamav Service Docker Image') {
      when {
        allOf {
          expression { BRANCH_NAME ==~ /(production|develop)/ }
          changeset 'images/clamav/service/build.sh'
        }
      }
      steps {
        buildServiceImage('./images/clamav/service')
      }
    }
    stage('Build and Push Clamav Scheduler Docker Image') {
      when {
        allOf {
          expression { BRANCH_NAME ==~ /(production|develop)/ }
          changeset 'images/clamav/scheduler/build.sh'
        }
      }
      steps {
        buildServiceImage('./images/clamav/scheduler')
      }
    }
  }
}
