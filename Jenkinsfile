import java.text.SimpleDateFormat
def date = new Date()
sdf = new SimpleDateFormat("MM.dd.yyyy-HH.mm.ss")
def image_id = "${BUILD_NUMBER}" + "_" + sdf.format(date)

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
              sh "echo ${image_id}"
              sh "docker build ./webapp -t 557502683643.dkr.ecr.us-east-1.amazonaws.com/csye7374:${image_id}"
              docker.withRegistry('https://557502683643.dkr.ecr.us-east-1.amazonaws.com/csye7374', 'ecr:us-east-1:awsid') {
                  docker.image('557502683643.dkr.ecr.us-east-1.amazonaws.com/csye7374:${image_id}').push()
              }
          }
      }
      stage('Update Kubernetes') {
          container('kubectl') {
              sh "kubectl set image deployments/csye7374-rc csye7374=557502683643.dkr.ecr.us-east-1.amazonaws.com/csye7374:${BUILD_NUMBER}"
              sh "kubectl rollout status deployments/csye7374-rc"
          }
      }
  }
  }
