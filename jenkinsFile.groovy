pipeline {
  agent any
  tools {
        maven 'Maven 3.9.2'
    }
  stages {
    stage('Test Execution') {
      steps {
        script {
             try {
                sh ("mvn test -DskipFailures=false -Dkarate.options='--tags @apiTest'")      
                  }
              finally
                {
                publishHTML (target: [allowMissing: false, keepAll: true,  reportDir: 'target/cucumber-html-reports/',reportFiles: 'overview-features.html',reportName: 'KarateDemo Report'])
           }    
        }    
      }
    }
  }
}