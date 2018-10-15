pipeline {
  agent any
  stages {
    stage('echoHello') {
      steps {
        sh 'echo \'hello\''
      }
    }
    stage('cleanBuild') {
      steps {
        sh './gradlew clean build'
      }
    }
  }
  post {
    always {
      archiveArtifacts(artifacts: 'output/*.apk', fingerprint: true)

    }

  }
}