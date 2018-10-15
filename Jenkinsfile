pipeline {
  agent any
  options {
          //timeout(time: 1, unit: 'HOURS') //一个小时后还没执行完，直接 abort
          //retry(3)//失败后重试
  }
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