pipeline {
  agent any
  stages {
    stage('myStage'){
      steps {
        sh 'ls -la' 
      }
    }
    ansiblePlaybook( 
        playbook: 'ansible/k8s-dockerFile.yaml'    )
  }
}