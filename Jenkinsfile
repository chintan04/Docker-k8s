node {
  stage('Init') {
    checkout scm
          sh 'apt-get update'  
          sh 'apt-get install ansible'
          sh 'which ansible'
          sh 'pwd'
          sh 'cd ansible'
          sh 'pwd'
          sh 'su jenkins'
          sh 'apt install python3-pip -y'
          sh 'pip3 install awscli'
          sh 'ansible-playbook ansible/k8s-dockerFile.yaml'
        // ansiblePlaybook playbook: 'ansible/k8s-dockerFile.yaml',

          
  }
}

  node {
          ansiblePlaybook( 
                  installation: 'ansible',
        playbook: 'ansible/k8s-dockerFile.yaml',
          inventory: 'ansible')
        
}
