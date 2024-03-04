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
                    dir('project-a') {
                        echo "Running Project A"
                        load 'Jenkinsfile'
                    }
                }
            }
        }

        stage('Run Project B') {
            steps {
                script {
                    dir('project-b') {
                        echo "Running Project B"
                        load 'Jenkinsfile'
                    }
                }
            }
        }

        // Add more stages as needed
    }
}