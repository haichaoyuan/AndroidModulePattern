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
    always {
        mail to:"1830560854@qq.com", subject: "打包邮件-$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!"
    }

  }
}