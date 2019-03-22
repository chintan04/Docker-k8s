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
        dir("/ansible") {
                   sh ansible-playbook k8s-dockerFile.yaml
                     }
      }
    }
  }
}

 