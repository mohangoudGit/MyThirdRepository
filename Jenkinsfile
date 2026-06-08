import jakarta.mail.*
import jakarta.mail.internet.*

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
      
      
    stage('Send Email') {
            
            
def props = new Properties()
props.put("mail.smtp.host", "smtp.gmail.com")
props.put("mail.smtp.port", "587")
props.put("mail.smtp.auth", "true")
props.put("mail.smtp.starttls.enable", "true")

def session = Session.getInstance(props,
    new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(
                "jenkins.frameworkdemo@gmail.com",
                "wxirehjhfyugpibr"
            )
        }
    })

def message = new MimeMessage(session)
message.setFrom(new InternetAddress("jenkins.frameworkdemo@gmail.com"))
message.setRecipients(
    Message.RecipientType.TO,
    InternetAddress.parse("jenkins.frameworkdemo@gmail.com")
)
message.setSubject("Jenkins Build Status")
message.setText("Build completed successfully.")

Transport.send(message)

println("Email sent successfully!")
            
            
            // Groovy mail code here - end
        }
      
    
      
      
  } 
    
    post {
        always {
            // Send email when the pipeline finishes, no matter if it passed or failed
         //    mail to: 'jenkins.frameworkdemo@gmail.com',
           //      subject: "Status of Job: ${env.JOB_NAME} - Build #${env.BUILD_NUMBER}",
             //    body: "The build completed with status: ${currentBuild.currentResult}.\nView log details here: ${env.BUILD_URL}"
            
             emailext (
              
         //   to: 'jenkins.frameworkdemo@gmail.com',
          //  subject: "Build ${currentBuild.currentResult}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
           // body: """Status: ${currentBuild.currentResult}Check console output here: ${env.BUILD_URL}""",
            
        
            )
            
        }
        
        
    
    
    
   }
   
   
   
   









}