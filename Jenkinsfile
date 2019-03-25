podTemplate(label: 'mypod', containers: [
    containerTemplate(name: 'docker', image: 'docker', ttyEnabled: true, command: 'cat'),
    containerTemplate(name: 'kubectl', image: 'lachlanevenson/k8s-kubectl:v1.8.0', command: 'cat', ttyEnabled: true),
    containerTemplate(name: 'helm', image: 'lachlanevenson/k8s-helm:latest', command: 'cat', ttyEnabled: true),
     containerTemplate(name: 'maven', image: 'maven:3.3.9-jdk-8-alpine', ttyEnabled: true, command: 'cat')
  ],
  volumes: [
    hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock'),
  ]) {
  node('mypod') {
                 stage('Get a Maven project') {
            checkout scm
            container('maven') {
                stage('Build a Maven project') {
                    sh 'cd webapp && mvn clean package'
                }
            }
}
  stage('Init') {
   // checkout scm
       //   sh "apt-get update -y"  
      //    sh 'apt-get install ansible -y'
      //    sh 'which ansible'
      //    sh 'pwd'
      //    sh 'cd ansible'
      //    sh 'pwd'
       //   sh 'su jenkins'
       //   sh 'apt install python3-pip -y'
       //   sh 'pip3 install awscli'
       //   sh 'apt update'
       //   sh 'apt install apt-transport-https ca-certificates curl gnupg2 software-properties-common -y'
       //   sh 'curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -'
       //   sh 'add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable"'
       //   sh 'apt update'
        //  sh 'apt-cache policy docker-ce'
        //  sh 'apt install docker-ce -y'
        //  sh 'apt install maven -y'
         // sh 'mvn install'
       container('docker') {
          docker.withRegistry("https://757638245294.dkr.ecr.us-east-1.amazonaws.com", 'ecr:us-east-1:aws') {
          //  git credentialsId: 'github2', url: 'https://github.com/HirenShah03/csye7374-spring2019'
            sh "ls -al"
           // sh "aws ecr get-login --no-include-email --region us-east-1"
            sh "docker build ./webapp  -t 757638245294.dkr.ecr.us-east-1.amazonaws.com/csye7374:latest "
            sh "docker push 757638245294.dkr.ecr.us-east-1.amazonaws.com/csye7374:latest"
           // sh 'ansible-playbook ansible/k8s-dockerFile.yaml'
        // ansiblePlaybook playbook: 'ansible/k8s-dockerFile.yaml',
       }
       } 
      
  }
              stage('Update Kubernetes') {
            container('kubectl') {
                sh "kubectl rolling-update csye7374-rc --image 757638245294.dkr.ecr.us-east-1.amazonaws.com/csye7374:latest"
            }
}
}
}
  node {
          ansiblePlaybook( 
                  installation: 'ansible',
        playbook: 'ansible/k8s-dockerFile.yaml',
          inventory: 'ansible')
        
}
