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
    stage('Test') {
      steps {
        sh './gradlew check'
      }
    }
  }
  post {
    always {
      archiveArtifacts(artifacts: 'build/outputs/apk/**/*.apk', fingerprint: true)
      junit 'build/reports/**/*.xml'

    }

  }
}