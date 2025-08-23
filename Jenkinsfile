pipeline {
    agent any

    environment {
        // Set environment variables here
        MAVEN_OPTS = '-Xms512m -Xmx1024m'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code...'
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Building and running tests...'
                script {
                    def branchName = env.BRANCH_NAME
                    if (branchName == 'master') {
                        echo 'Running in parallel mode for the master branch.'
                        // Run tests in parallel for the master branch
                        bat 'mvn clean install -Dsurefire.test=LifeCycleRunner -Dparallel=4 -Dlogging=false'
                    } else {
                        echo "Running in sequential mode for branch: ${branchName}"
                        // For other branches (like dev), run tests sequentially with logs
                        bat 'mvn clean install -Dsurefire.test=LifeCycleRunner -Dparallel=1 -Dlogging=true'
                    }
                }
            }
        }

        stage('Reporting') {
            steps {
                echo 'Archiving test reports...'
                junit 'target/surefire-reports/**/*.xml'
            }
        }
    }

    post {
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed. See the console output for details.'
        }
    }
}