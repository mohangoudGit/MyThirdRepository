pipeline 
{
    agent any
    
    tools{
        maven 'maven'
        }

    stages 
    {
        stage("Build"){
            steps{
                echo("Building is done")
            }
        }
        
        
        
        stage("Deploy to QA"){
            steps{
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
        
         stage('Email Results To Stakeholders') {
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
       
        
        
        stage("Deploy to Stage"){
            steps{
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
        
        
       
        
        
        stage("Deploy to PROD"){
            steps{
                echo("deploy to PROD")
            }
        }
        
      }
      
      stage("Email Report To Stake holder"){
            steps{
                echo("Email Report To Stake holder")
                
                 post {
        always {
            // First, publish results to Jenkins
            step([$class: 'Publisher', reportFilenamePattern: '**/target/surefire-reports/testng-results.xml'])
            
            // Second, email the HTML report to your team
            emailext (
                to: 'jenkins.frameworkdemo@gmail.com, jenkins.frameworkdemo@gmail.com',
                subject: "TestNG Results: Job '${env.JOB_NAME}' [Build #${env.BUILD_NUMBER}]",
                body: """<p>The build finished with status: <b>${currentBuild.currentResult}</b>.</p>
                         <p>See attached TestNG report for comprehensive execution details.</p>
                         <p>Console Logs: <a href='${env.BUILD_URL}console'>${env.BUILD_URL}console</a></p>""",
                mimeType: 'text/html',
                attachmentsPattern: '**/target/surefire-reports/emailable-report.html'
            )
        }

    }
                
                
            }
        }
        
      }
      
     
  
    
    
    
