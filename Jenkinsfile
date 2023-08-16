pipeline {
  agent any
  stages {
    stage('Build') {
      steps {  // no container directive is needed as the maven container is the default
        sh '''
            ls
            docker build -t exampleplugin:latest .
            docker run --name temp-container exampleplugin:latest
            docker cp temp-container:/etc/exampleplugin/target/* .
            docker rm temp-container
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
