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
    stage('Test'){
      steps{
        sh './gradlew check'
  }
  // 我也不清楚 archiveArtifact 的意思
      post {
        always {
          archiveArtifacts artifacts: 'build/outputs/apk/**/*.apk', fingerprint: true
          junit 'build/reports/**/*.xml'
      }
}
