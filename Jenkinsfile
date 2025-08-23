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
						echo 'Running in parallel mode for the master branch.'
                    	// Run tests in parallel for the master branch
                   		bat 'mvn test -Dtest=LifeCycleRunner -Dparallel=4 -Dlogging=false'
					}
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