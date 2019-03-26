podTemplate(label: 'mypod', containers: [
    containerTemplate(name: 'docker', image: 'docker', ttyEnabled: true, command: 'cat'),
    containerTemplate(name: 'maven', image: 'maven:3.3.9-jdk-8-alpine', ttyEnabled: true, command: 'cat'),
    containerTemplate(name: 'kubectl', image: 'lachlanevenson/k8s-kubectl:v1.8.0', command: 'cat', ttyEnabled: true),
    containerTemplate(name: 'helm', image: 'lachlanevenson/k8s-helm:latest', command: 'cat', ttyEnabled: true)
  ],
  volumes: [
    hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock'),
  ]) {
  node('mypod') {
      stage('Get a Maven project') {
          checkout scm
          container('maven') {
              stage('Build a Maven project') {
                  sh 'cd webapp && mvn clean package'
              }
          }
      }
      stage('Init') {
          container('docker') {
              sh "ls -al"
              sh "docker build ./webapp -t 338969645766.dkr.ecr.us-east-1.amazonaws.com/csye7374:latest"
              docker.withRegistry('https://338969645766.dkr.ecr.us-east-1.amazonaws.com/csye7374', 'ecr:us-east-1:awsid') {
                  docker.image('338969645766.dkr.ecr.us-east-1.amazonaws.com/csye7374').push('latest')
              }
          }
      }
      stage('Update Kubernetes') {
          container('kubectl') {
              sh "kubectl rolling-update csye7374-rc --image-pull-policy Always --image 338969645766.dkr.ecr.us-east-1.amazonaws.com/csye7374:latest"
          }
      }
  }
  }
