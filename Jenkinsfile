pipeline {
    agent any

    environment {
        // Set environment variables here
        MAVEN_OPTS = '-Xms512m -Xmx1024m'
    }

    stages {
        stage('Checkout') {
            steps {
                // The pipeline automatically checks out the code from the Git repository
                // that you configure in Jenkins.
                echo 'Checking out code...'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                // The 'clean install' command will download dependencies and compile the code.
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running automation tests...'
                // Get the current branch name
                script {
                    def branchName = env.BRANCH_NAME
                    if (branchName == 'master') {
                        // Run tests in parallel for the master branch
                        bat 'mvn test -Dtest=LifeCycleRunner -Dparallel=4 -Dlogging=false'
                    } else {
                        // For other branches (like dev), run tests sequentially with logs
                        bat 'mvn test -Dtest=LifeCycleRunner -Dparallel=1 -Dlogging=true'
                    }
                }
            }
        }
    }

    post {
        always {
            // This block runs regardless of whether the pipeline succeeded or failed.
            echo 'Archiving test reports...'
            junit 'target/surefire-reports/**/*.xml'
        }
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed. See the test results for details.'
        }
    }
}