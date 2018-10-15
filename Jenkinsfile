pipeline {
  agent any
  stages {
    stage('build') {
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
}