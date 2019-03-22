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
        withCredentials([file(credentialsId: '' )]){
          ansiblePlaybook playbook: 'ansible/k8s-dockerFile.yaml'
          }
      }
    }
  }
}