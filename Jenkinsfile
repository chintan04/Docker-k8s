// pipeline {
//   agent any
//   stages {
//     stage('myStage'){
//       steps {
//         sh 'ls -la' 
//       }
//     }
//     stage('Ansible Init') {
//             steps {
//                 node {
//           ansiblePlaybook( 
//         playbook: 'path/to/playbook.yml',
//         inventory: 'path/to/inventory.ini', 
//         credentialsId: 'ansible')
        
//             }
//             }
//         }
        
//   }
// }
      

//node {
//  stage('Init') {
//    checkout scm
//          sh 'ls -al'
//          sh 'pwd'
//          sh 'cd ansible'
//          sh 'pwd'
//  }
//}

  //node {
    //      ansiblePlaybook( 
     //             installation: 'ansible',
      //  playbook: 'ansible/k8s-dockerFile.yaml',
       //   inventory: 'ansible')
        
      //      }
//=====================================================
/*pipeline {
    agent any
    tools { 
         maven 'Maven' 
         org.jenkinsci.plugins.docker.commons.tools.DockerTool 'Docker'
            
    }
    stages {
        stage ('Initialize') {
            steps {
                    checkout scm
                    sh 'ls -al'
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    cd webapp && mvn clean package
                ''' 
            }
        }

        stage ('Build') {
            steps {
                    sh 'docker build --no-cache -t csye7374'
                echo 'This is a minimal pipeline.'
            }
        }
    }
}*/
//============================================================================================

podTemplate(label: 'mypod', containers: [
    containerTemplate(name: 'docker', image: 'docker', ttyEnabled: true, command: 'cat'),
        containerTemplate(name: 'maven', image: 'maven:3.3.9-jdk-8-alpine', ttyEnabled: true, command: 'cat'),
    containerTemplate(name: 'kubectl', image: 'lachlanevenson/k8s-kubectl:v1.8.0', command: 'cat', ttyEnabled: true),
    containerTemplate(name: 'helm', image: 'lachlanevenson/k8s-helm:latest', command: 'cat', ttyEnabled: true)
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
       container('docker') {
            //git credentialsId: 'git', url: 'https://github.com/chintan04/csye7374-spring2019'
            sh "ls -al"
            sh "cd webapp && ls -al"
            
           // sh "aws ecr get-login --no-include-email --region us-east-1"
            sh "docker build ./webapp -t 557502683643.dkr.ecr.us-east-1.amazonaws.com/csye7374:latest"
              docker.withRegistry('https://557502683643.dkr.ecr.us-east-1.amazonaws.com/csye7374', 'ecr:us-east-1:ecr-credentials') {
                         docker.image('557502683643.dkr.ecr.us-east-1.amazonaws.com/csye7374').push('latest')
                 }
//               sh "docker push 757638245294.dkr.ecr.us-east-1.amazonaws.com/csye7374:latest "
         // sh 'ansible-playbook ansible/k8s-dockerFile.yaml'
        // ansiblePlaybook playbook: 'ansible/k8s-dockerFile.yaml',
       }
          
  }
          stage('Update Kubernetes') {
            container('kubectl') {
                sh "kubectl rolling-update csye7374-rc --image 557502683643.dkr.ecr.us-east-1.amazonaws.com/csye7374:latest"
            }
}
}
}
   


