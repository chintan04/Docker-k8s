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
                    ansiblePlaybook([
                            inventory   : 'hosts',
                            playbook    : 'k8s-dockerFile.yaml',
                            installation: 'ansible',
                            colorized   : true
                        ])
                     }
      }
    }
  }
}

 