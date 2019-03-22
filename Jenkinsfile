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
        withCredentials([file(credentialsId: 'chintan04' )]){
          ansiblePlaybook playbook: 'ansible/k8s-dockerFile.yaml'
          }
      }
    }
  }
}