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
        withCredentials(){
            ansiblePlaybook playbook: 'ansible/k8s-dockerFile.yaml'
        }
          
    }
      }
       
  }
}