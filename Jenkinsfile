pipeline{
	agent any
	stages {
	
	
	stage('Test Run On QA') {
    
      parallel {
        stage('Test Run On QA') {
        
          steps {
            sh 'mvn clean install -Denv="qa"'
           
          }
        }
        
      stage('Test Run On DEV') {
     
      parallel {
        stage('Test Run On DEV') {
       
          steps {
            sh 'mvn clean install -Denv="dev"'
            
          }
        }
	
	stage('Test Run On PROD') {
      
      parallel {
        stage('Test Run On PROD') {
        
          steps {
            sh 'mvn clean install -Denv="prod"'
            
          }
        }
		
							
			stage('final'){
				steps{
					sh 'echo "test execution is done"'
					}
				}	
			}
		}