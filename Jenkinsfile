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

        stage('Run Project A') {
            steps {
                script {
                    echo "Running Project A"
                    buildProject('project-a')
                }
            }
        }

        stage('Run Project B') {
            steps {
                script {
                    echo "Running Project B"
                    buildProject('project-b')
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