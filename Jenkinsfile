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

       stage('Run Projects') {
                   steps {
                       script {
                           parallel (
                               "Project A": { buildProject('project-a') },
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