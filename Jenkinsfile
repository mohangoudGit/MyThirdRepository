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
        success { 
        emailext (
                to: 'jenkins.frameworkdemo@gmail.com',
                subject: "Build #${env.BUILD_NUMBER} Artifacts",
                body: "Please find the requested build artifacts attached to this email.",
                // Finds all PDFs in target/outputs and a specific log file at the root
              //  attachmentsPattern: 'target/surefire-reports/emailable-report.html, index.html'
            )
  }
    }
    
    
   }
   
   
   
   









