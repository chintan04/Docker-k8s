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
            
node {
  stage('Init') {
    checkout scm
  }
}

  node {
          ansiblePlaybook( 
        playbook: 'ansible/k8s-dockerFile.yaml')
        
            }
