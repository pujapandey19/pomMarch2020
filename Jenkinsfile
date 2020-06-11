pipeline{
	agent any
	stages {
	
	
	stage('Test Run On QA') {
    stage('Build QA') {
      parallel {
        stage('Test Run On QA') {
        stage('Build QA') {
          steps {
            sh 'mvn clean install -Denv="qa"'
            sh 'mvn clean install -DskipTests=true'
          }
        }
        
      stage('Test Run On DEV') {
      stage('Build DEV') {
      parallel {
        stage('Test Run On DEV') {
        stage('Build DEV') {
          steps {
            sh 'mvn clean install -Denv="dev"'
            sh 'mvn clean install -DskipTests=true'
          }
        }
	
	stage('Test Run On PROD') {
      stage('Build PROD') {
      parallel {
        stage('Test Run On PROD') {
        stage('Build DEV') {
          steps {
            sh 'mvn clean install -Denv="prod"'
            sh 'mvn clean install -DskipTests=true'
          }
        }
		
							
			stage('final'){
				steps{
					sh 'echo "test execution is done"'
					}
				}	
			}
		}