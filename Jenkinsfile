pipeline {
  agent any
  stages {
    stage('Build') {
      steps {  // no container directive is needed as the maven container is the default
        sh '''
            ls
            mvn clean package
        '''
      }
    }
  }
  post {
      always {
          archiveArtifacts artifacts: 'target/ExamplePlugin-1.0-SNAPSHOT.jar', fingerprint: true
          cleanWs(cleanWhenNotBuilt: false,
                    deleteDirs: true,
                    disableDeferredWipeout: true,
                    notFailBuild: true,
                    patterns: [[pattern: '.gitignore', type: 'INCLUDE'],
                               [pattern: '.propsfile', type: 'EXCLUDE']])
        }
    }
}
