node {
  stage('Init') {
    checkout scm
          sh 'ls -al'
          sh 'pwd'
          sh 'cd ansible'
          sh 'pwd'
  }
}

  node {
          ansiblePlaybook( 
                  installation: 'ansible',
        playbook: 'ansible/k8s-dockerFile.yaml',
          inventory: 'ansible')
        
}
