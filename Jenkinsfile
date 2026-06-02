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
      }
    
    
    
