pipeline {
  agent any
  stages {
    stage('echoHello') {
      steps {
        sh 'echo \'hello\''
      }
    }
  }
  post {
    always {
      archiveArtifacts(artifacts: 'app/build/outputs/apk/release/*.apk', fingerprint: true)
      junit 'build/reports/**/*.xml'

    }

  }
}