pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk19/jdk-19.0.1'
    }
    stages {


        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install'
            }

        }
    }
}