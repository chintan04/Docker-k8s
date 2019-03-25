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
pipeline {
    agent any
    tools { 
         maven 'Maven' 
            
    }
    stages {
        stage ('Initialize') {
            steps {
                    checkout scm
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    sh 'cd webapp && mvn clean package'
                ''' 
            }
        }

        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
            }
        }
    }
}
