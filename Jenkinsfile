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
}
