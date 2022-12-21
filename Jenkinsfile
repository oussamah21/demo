pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
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