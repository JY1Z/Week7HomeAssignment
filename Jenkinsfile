pipeline {
    agent any
     tools {
            maven 'Maven3'
            jdk 'Java_Home'
     }
     environment {
            // Define Docker Hub credentials ID
            DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
            // Define Docker Hub repository name
            DOCKERHUB_REPO = 'jyzh770/week7home'
            // Define Docker image tag
            DOCKER_IMAGE_TAG = 'latest_v1'
        }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/JY1Z/Week7HomeAssignment.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    env.JAVA_OPTS = "-Xmx2048m"
                    env.MAVEN_OPTS = "-Xmx2048m"
                }
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Code Coverage') {
            steps {
//                 sh 'mvn jacoco:report'
                 bat 'echo Hello, Jenkins!'

            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

         stage('Build Docker Image') {
                    steps {
                        // Build Docker image
                        script {
//                             docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                            def myImage = docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                        }
                    }
                }
                stage('Push Docker Image to Docker Hub') {
                    steps {
                        // Push Docker image to Docker Hub
                        script {
                            docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
//                                 docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                                def myImage = docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                                myImage.push()
                            }
                        }
                    }
                }
    }
}