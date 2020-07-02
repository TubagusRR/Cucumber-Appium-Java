pipeline {
    agent any

    stages {
        stage ("Compile Stage"){

            steps {
                withMaven(maven : 'maven') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage("Testing Stage"){
            parallel {
                stage('Test on Android'){
                     steps {
                        withMaven(maven : 'maven'){
                            bat 'mvn test'
                            }
                    }
                }

                stage('Test on Iphone'){
                    steps {
                        withMaven(maven : 'maven'){
                             echo "Iphone Test"
                            }
                       }
                  }
             }
         }

        stage("Deployment Stage"){

            steps{
                withMaven(maven : 'maven'){
                    bat 'echo "This is Deployed"'
                }
            }
        }
    }
}