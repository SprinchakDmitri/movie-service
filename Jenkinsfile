pipeline {
    agent any
    stages {
        stage('Checkout & Clone') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'master', url: 'https://github.com/SprinchakDmitri/movie-service.git'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }
        stage('Test') {
            steps {
                 sh './mvnw test'   
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                    
                                        emailext attachLog: true,
                    body: 'Please go to ${BUILD_URL} and verify the build',
                    compressLog: true,
                    recipientProviders: [upstreamDevelopers(), requestor()],
                    subject: 'Job \'${JOB_NAME}\' (${BUILD_NUMBER}) is waiting for input',
                }
            }
         }  

    }
}