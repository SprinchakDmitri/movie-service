pipeline {
  environment {
    PROJECT = "movie-project-311511"
    APP_NAME = "movie-service"
    FE_SVC_NAME = "${APP_NAME}"
    CLUSTER = "jenkins-cd"
    CLUSTER_ZONE = "us-east1-d"
    IMAGE_TAG = "gcr.io/${PROJECT}/${APP_NAME}:${IMAGE_VERSION}.${env.BUILD_NUMBER}"
    IMAGE_VERSION = "development"
    JENKINS_CRED = "${PROJECT}"
    def namespace="development"
  }
    agent {
        kubernetes {
            label 'movie-service'
            defaultContainer 'jnlp'
            yaml """
apiVersion: v1
kind: Pod
metadata:
labels:
 component: test
spec:
 containers:
 - name: golang
   image: golang:1.10
   command:
   - cat
   tty: true
 - name: gcloud
   image: gcr.io/cloud-builders/gcloud
   command:
   - cat
   tty: true
 - name: kubectl
   image: gcr.io/cloud-builders/kubectl
   command:
   - cat
   tty: true
"""
        }
    }
    stages{
        stage('Checkout') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'master', url: 'https://github.com/SprinchakDmitri/movie-service.git'
            }
        }

        stage('Build & Test') {
            steps {
                // Run Maven on a Unix agent.
                sh "chmod +x mvnw"
                sh './mvnw clean package'
              
                //sh 'true'

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }


            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        
        stage('Build Docker Image & Push to Registry') {
            steps {
             container('gcloud') {
                 
                 sh "PYTHONUNBUFFERED=1 gcloud builds submit -t ${IMAGE_TAG} ."
             }
            }
        }
        
         //Stage 3 : Deploy Application
  stage('Deploy Application') {
            steps{
                container('kubectl')  {  
                   // Create namespace if it doesn't exist
                   sh("kubectl get namespace ${namespace} || kubectl create namespace ${namespace}")
                   //Update the imagetag to the latest version
                   sh("sed -i.bak 's#gcr.io/${PROJECT}/${APP_NAME}:${IMAGE_VERSION}#${IMAGE_TAG}#' ./k8s/development/*.yaml")
                   //Create or update resources
                   sh("kubectl --namespace=${namespace} apply -f k8s/development/deployment.yaml")
                   sh("kubectl --namespace=${namespace} apply -f k8s/development/service.yaml")
                   //Grab the external Ip address of the service
                   sh("echo http://`kubectl --namespace=${namespace} get service/${FE_SVC_NAME} --output=json | jq -r '.status.loadBalancer.ingress[0].ip'` > ${FE_SVC_NAME}")
            } 
           }
       }
    }

}
