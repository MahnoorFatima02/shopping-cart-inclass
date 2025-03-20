// pipeline {
//     agent any
//      environment {
//              MAVEN_HOME = '/opt/homebrew/Cellar/maven/3.9.9/libexec'
//              PATH = "/opt/homebrew/bin:${MAVEN_HOME}/bin:${env.PATH}"
//              DOCKERHUB_CREDENTIALS_ID = 'Docker_hub'
//              DOCKERHUB_REPO = 'shopping-cart'
//              DOCKER_IMAGE_TAG = 'v1'
//              DOCKERHUB_USER = 'mahnoor95'
//         }
//     stages {
//         stage('Checkout') {
//               steps {
//                   git branch: 'main', url: 'git@github.com:MahnoorFatima02/shopping-cart-inclass.git'
//               }
//         }
//         stage('Build') {
//             steps {
//                 sh 'mvn clean install'
//             }
//         }
//         stage('Test') {
//             steps {
//                 sh 'mvn test'
//             }
//         }
//         stage('Code Coverage') {
//             steps {
//                 sh 'mvn jacoco:report'
//             }
//         }
//         stage('Publish Test Results') {
//             steps {
//                 junit '**/target/surefire-reports/*.xml'
//             }
//         }
//         stage('Publish Coverage Report') {
//             steps {
//                 jacoco()
//             }
//         }
//
//          stage('Build Docker Image') {
//                     steps {
//                         // Build Docker image
//                         script {
//                             docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
//                         }
//                     }
//                 }
// //                 stage('Push Docker Image to Docker Hub') {
// //                     steps {
// //                         // Push Docker image to Docker Hub
// //                         script {
// //                         withCredentials([usernamePassword(credentialsId: DOCKERHUB_CREDENTIALS_ID, usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
// //                         // Log in to Docker Hub
// //                         sh "/usr/local/bin/docker login -u ${DOCKERHUB_USER} -p ${DOCKERHUB_PASSWORD}"
// //
// //                         sh "docker push "${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}"
// //                             }
// //                         }
// //                     }
// //                 }
//     stage('Push Docker Image to Docker Hub') {
//                 steps {
//                     script {
//                         withCredentials([usernamePassword(credentialsId: DOCKERHUB_CREDENTIALS_ID, usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
//                             // Log in to Docker Hub
//                             sh "echo ${DOCKERHUB_PASSWORD} | docker login -u ${DOCKERHUB_USER} --password-stdin"
//
//                             // Push Docker images to Docker Hub
//                             sh "docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}"
//                         }
//                     }
//                 }
//             }
//
//
//     }
// }

pipeline {
    agent any

    environment {
         MAVEN_HOME = '/opt/homebrew/Cellar/maven/3.9.9/libexec'
         PATH = "/opt/homebrew/bin:${MAVEN_HOME}/bin:${env.PATH}"
        DOCKERHUB_CREDENTIALS_ID = 'Docker_hub'
        DOCKERHUB_REPO = 'mahnoor95/shopping-cart'
        DOCKER_IMAGE_TAG = 'latest_v2'
        DOCKERHUB_USER = 'mahnoor95'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'git@github.com:MahnoorFatima02/shopping-cart-inclass.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Code Coverage') {
            steps {
                sh 'mvn jacoco:report'
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
        stage('Verify Docker Installation') {
            steps {
                sh 'docker --version'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: DOCKERHUB_CREDENTIALS_ID, usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
                        // Log in to Docker Hub
                        sh "echo ${DOCKERHUB_PASSWORD} | docker login -u ${DOCKERHUB_USER} --password-stdin"

                        // Push Docker images to Docker Hub
                        sh "docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}"
                    }
                }
            }
        }
    }
}