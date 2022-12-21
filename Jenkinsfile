pipeline {
    agent any
    tools {
        maven 'Maven 3.8.6'
        jdk 'jdk17'
    }
    stages {


        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install'
            }

        }
    }
}