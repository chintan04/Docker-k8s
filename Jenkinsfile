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
        withEnv(["ARTIFACT_URL=TEST"]){
          ansiblePlaybook playbook: 'ansible/k8s-dockerFile.yaml'
          }
      }
    }
  }
}