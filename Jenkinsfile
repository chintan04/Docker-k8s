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
node {

    /* The first stage clones our code repository */
    stage('Clone repository') {
        checkout scm
    }

    /* The second stage runs Maven to package the app */
    stage('Package') {
        sh 'mvn package'
    }

    /* The final stage runs Maven to deploy the JAR into a repository */
    stage('Deploy') {
        sh 'mvn deploy'
    }

}
