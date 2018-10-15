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
      archiveArtifacts(artifacts: 'module_app/build/outputs/apk/release/*.apk', fingerprint: true)
      junit 'build/reports/**/*.xml'

    }

  }
}
