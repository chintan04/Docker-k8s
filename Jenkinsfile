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
          ansiblePlaybook('ansible/k8s-dockerFile.yaml')
    }
      }
       
  }
}