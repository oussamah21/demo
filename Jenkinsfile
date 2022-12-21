pipeline {
    agent any
    tools {
        maven 'Maven 3.8.6'
        jdk 'jdk17'
      def dockerHome = tool 'docker'
              env.PATH = "${dockerHome}/bin:${env.PATH}"
    }
    stages {


        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
        }
        stage('Build image') {
              steps{
                         script {
                       dockerImage = docker.build("oussamah21/demo:latest")
                              }
                    }
                    }
    }

}