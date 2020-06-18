pipeline {
  agent any
  stages {
  
  
   stage('Test execute on Dev') {
       steps {
    sh 'mvn clean install -Denv="dev"'
   
       }
       
   }
   
   
   
   stage('Test execute on QA') {
       steps {
    sh 'mvn clean install -Denv="qa"'
   
       }
       
   }
   
   
   stage('Test execute on Stage') {
       steps {
    sh 'mvn clean install -Denv="stage"'
   
       }
       
   }
   
   
   stage('Test execute on Prod') {
       steps {
    sh 'mvn clean install '
   
       }
       
   }
   
   
   stage ('final'){
   
   steps{
   sh 'echo' "test execution is done"
   
   }
   
   }
   }
   
   }
   
   
   
   
   
   
   