pipeline{
	agent any
	stages {
	
	
			stage('Test run on QA'){
				steps{
					sh 'mvn clean install -Denv="qa"'
					}
				}	
				
			stage('Test run on DEV'){
				steps{
					sh 'mvn clean install -Denv="dev"'
					}
				}	
				
			
				
			stage('Test run on PROD'){
				steps{
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