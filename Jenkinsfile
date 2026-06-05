pipeline {
   agent any
   
   tools {
      maven 'maven'
   }
   
   stages {
      stage("Build") {
         steps {
            echo("Building is done")
         }
      }
      
      
      
      stage("Deploy to QA") {
         steps {
            echo("deploy to qa done")
         }
      }
      
      
      
      
      stage('Regression Automation Tests') {
         steps {
            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
               git 'https://github.com/mohangoudGit/MyThirdRepository.git'
               bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resource/HomePageTest.xml"
               
               
            }
         }
      }
      
      
      stage('Publish Allure Reports') {
         steps {
            script {
               allure([
               includeProperties: false,
               jdk: '',
               properties: [],
               reportBuildPolicy: 'ALWAYS',
               results: [[path: '/allure-results']]
               ])
            }
         }
      }
      
      
      
      
      
      
      stage("Deploy to Stage") {
         steps {
            echo("deploy to Stage")
         }
      }
      
      stage('Sanity Automation Test') {
         steps {
            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
               git 'https://github.com/mohangoudGit/MyThirdRepository.git'
               bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resource/HomePageTest.xml"
               
            }
         }
      }
      
      
      
      
      
      stage("Deploy to PROD") {
         steps {
            echo("deploy to PROD")
         }
      }
      
      
      
   
   }
   
   post {
        always {
            emailext (
                subject: "Jenkins Build Report: Job '${env.JOB_NAME}' [Build #${env.BUILD_NUMBER}]",
                body: '${FILE, path="target/surefire-reports/emailable-report.html"}', 
                   //       body: '${FILE, path="target/surefire-reports/ChainIndex.html"}',
                to: 'jenkins.frameworkdemo@gmail.com',
                mimeType: 'text/html',
                attachmentsPattern: 'target/surefire-reports/emailable-report.html' 
            )
        }
    }
    
    
   }
   
   
   
   









