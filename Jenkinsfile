pipeline {
  agent any
  stages {
    stage('echoHello') {
      steps {
        sh 'echo \'hello\''
      }
    }
    stage('cleanBuid') {
      steps {
        sh './gradlew clean build'
      }
    }
  }
  post {
    always {
      archiveArtifacts(artifacts: 'module_app/build/outputs/apk/release/*.apk', fingerprint: true)
    }

  }
}
