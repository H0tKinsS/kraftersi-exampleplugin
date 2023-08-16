pipeline {
  agent any
  stages {
    stage('Build') {
      steps {  // no container directive is needed as the maven container is the default
        sh '''
            ls
        '''
      }
    }
  }
  post {
      always {
          archiveArtifacts artifacts: 'ExamplePlugin-1.0-SNAPSHOT.jar', fingerprint: true
        }
    }
}
