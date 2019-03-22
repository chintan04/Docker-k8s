pipeline {
  agent any
  stages {
    stage('myStage'){
      steps {
        sh 'ls -la' 
      }
    }
    stage('Build') {
       ansiblePlaybook( 
        playbook: 'ansible/k8s-dockerFile.yaml'    )
    }
  }
}