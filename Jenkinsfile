pipeline {
  agent any
  stages {
    stage('myStage'){
      steps {
        sh 'ls -la' 
      }
    }
    stage('Build') {
      steps {
        // withCredentials([file(credentialsId: 'github4')]){
          ansiblePlaybook playbook: 'ansible/k8s-dockerFile.yaml',
          hostKeyChecking: false,
          // extras: "--vault-password-file ''"
          // }
      }
    }
  }
}

node{
    stage('Init'){
            checkout scm

          sh "apt-get update -y"  
          sh 'apt install maven -y'
          sh 'mvn -f webapp/ install'

          }
}

podTemplate(label: 'mypod', containers: [
    containerTemplate(name: 'docker', image: 'docker', ttyEnabled: true, command: 'cat'),
    containerTemplate(name: 'kubectl', image: 'lachlanevenson/k8s-kubectl:v1.8.0', command: 'cat', ttyEnabled: true),
    containerTemplate(name: 'helm', image: 'lachlanevenson/k8s-helm:latest', command: 'cat', ttyEnabled: true)
  ],
  volumes: [
    hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock'),
  ]) {
    node('mypod') {
        withCredentials([[$class: 'UsernamePasswordMultiBinding', 
                            credentialsId: 'dockerhub',
                            usernameVariable: 'DOCKER_HUB_USER', 
                            passwordVariable: 'DOCKER_HUB_PASSWORD']]){
        stage('Build Docker Image') {
            container('docker') {
                    git credentialsId: 'github2', url: 'https://github.com/HirenShah03/csye7374-spring2019.git'
                    sh "ls -al"
                    sh "docker build ./webapp -t ${env.DOCKER_HUB_USER}/csye7374:${env.BUILD_NUMBER} "
                    sh "docker login -u ${env.DOCKER_HUB_USER} -p ${env.DOCKER_HUB_PASSWORD} "
                    sh "docker push ${env.DOCKER_HUB_USER}/csye7374:${env.BUILD_NUMBER} "
            }
        }
        stage('Update Kubernetes') {
            container('kubectl') {
                sh "kubectl rolling-update csye7374-app-rc --image ${env.DOCKER_HUB_USER}/csye7374:${env.BUILD_NUMBER}"
            }
        }
        }
    }
}