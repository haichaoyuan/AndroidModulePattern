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
        sh './gradlew clean sonarqube build'
      }
    }
  }
  post {
    success {
      archiveArtifacts(artifacts: 'output/*.apk', fingerprint: true)
    }
  }
}