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
               bat "mvn clean install -Dsurefire.suiteXmlFiles=src/test/resource/HomePageTest.xml"
               
               
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
            echo("The current workspace is: ${env.WORKSPACE}")
         }
      }
      
   //   stage('Sanity Automation Test') {
     //    steps {
       //     catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
         //      git 'https://github.com/mohangoudGit/MyThirdRepository.git'
           //    bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resource/HomePageTest.xml"
               
           // }
        // }
     // }
      
     
      
      
      
      stage("Deploy to PROD") {
         steps {
            echo("deploy to PROD")
         }
      }
      
     
     
      
  } 
    
    post {
        always {
            // Send email when the pipeline finishes, no matter if it passed or failed
             mail to: 'jenkins.frameworkdemo@gmail.com',
                 subject: "Status of Job: ${env.JOB_NAME} - Build #${env.BUILD_NUMBER}",
                 body: "The build completed with status: ${currentBuild.currentResult}.\nView log details here: ${env.BUILD_URL}"
            
        }
   
   
   
   
  
 
  
    
    
   }
   
   }
   
   









