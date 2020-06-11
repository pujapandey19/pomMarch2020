pipeline {
  agent any
  stages {
    stage('Test Run On Dev') {
    stage('Build Dev') {
      parallel {
        stage('Test Run On Dev') {
        stage('Build Dev') {
          steps {
            sh 'mvn clean install -Denv="dev"'
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('Test QA') {
        stage('chrome') {
          steps {
            sh 'mvn clean install -Denv="qa"'
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

        stage('Test Stage') {
      }
    }

    stage('Build QA') {
      parallel {
        stage('Build QA') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn clean install -Denv="stage"'
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

        stage('Test PROD') {
        stage('chrome') {
          steps {
            sh 'mvn clean install'
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

      }
    }

    stage('') {
      steps {
        sh 'echo "test execution is done"'
    stage('Build Stage') {
      parallel {
        stage('Build Stage') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

      }
    }


    stage('Publish reports') {
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



  }
  tools {
    maven 'M3'
  }
} 