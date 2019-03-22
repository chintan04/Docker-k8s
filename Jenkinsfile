pipeline {
  agent any
  stages {
    stage('myStage'){
      steps {
        sh 'ls -la' 
      }
    }
    ansiColor('xterm') {
       ansiblePlaybook( 
        playbook: 'ansible/k8s-dockerFile.yaml'    )
    }
  }
}