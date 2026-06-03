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
      
      
    post {
        always {
            // Archives the directory so it's permanently attached to the build
            archiveArtifacts artifacts: '**/target/chaintest/**', allowEmptyResults: true
            
            // Optional: If you use the HTML Publisher Plugin to embed it directly
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/chaintest',
                reportFiles: 'index.html', // or your main simple report HTML file
                reportName: 'ChainTest Report'
            ])
        }
    }


       
       

                
}
        
        
      
      
     
  
    
    
    
