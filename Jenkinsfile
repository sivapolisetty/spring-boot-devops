pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn clean org.jacoco:jacoco-maven-plugin:0.8.5:prepare-agent install org.jacoco:jacoco-maven-plugin:0.8.5:report' 
            }
        }
        
        stage('Quality') { 
            steps {
                sh '$SONNAR_SCANNER  -Dsonar.projectKey=BGSNLFM -Dsonar.host.url=http://localhost:9000/  -Dsonar.projectName=fp-api -Dsonar.sources=src/main/java -Dsonar.tests=src/test/java -Dsonar.java.binaries=target/classes -Dsonar.java.test.binaries=target/test-classes -Dsonar.junit.reportPaths=target/surefire-reports -Dsonar.jacoco.reportPaths=target/jacoco.exec' 
            }
        }
        
        stage('Prepare Artifacts') { 
            steps {
            	echo 'Prepare Artifacts'          
            }
        }
        
        stage('Transfer') {
           steps {
               echo 'Transfer'
           }
        }
        
        
    }
    
    parameters {
        string(name: 'DEPLOY_ENV', defaultValue: 'staging', description: '')
        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'A secret password')
    }
}
