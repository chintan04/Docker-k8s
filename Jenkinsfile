pipeline {
  agent any
  stages {
    stage('build and push'){
      steps {
        ansible-playbook ansible/k8s-dockerFile.yaml
      }
    }
  }
}