node {
  stage('Init') {
    checkout scm
          sh 'bash'  
          sh 'apt-get install ansible'
          sh 'which ansible'
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
