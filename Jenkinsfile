pipeline {
    agent any
    environment {
        REGISTRY = "k8s-vga-worker1:5000"
        IMAGE_NAME = "group1-team2-springboot-app"
        IMAGE_TAG = "latest"
        NAMESPACE = "group1-team2"
        JAVA_HOME = "/jdk-21.0.5"
        PATH = "${JAVA_HOME}/bin:$PATH"
    }
    stages {
        stage('Check java version') {
            steps {
                sh 'java -version'
            }
        }
        stage('Checkout') {
            steps {
                // Git 저장소에서 소스 코드 체크아웃 (branch 지정 : 본인 repository의 branch 이름으로 설정)
                git branch: 'main', url: 'https://github.com/newtein80/lecture.git'
            }
        }
        stage('Build with Gradle') {
            steps {
                script {
                    // Gradle 실행권한
                    sh 'chmod +x ./gradle'
                    // Gradle 빌드 실행
                    sh '''
                        java -version
                        ./gradlew clean build
                    '''
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${REGISTRY}/${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }
        stage('Push Docker Image') {
            steps {
                sh "docker push ${REGISTRY}/${IMAGE_NAME}:${IMAGE_TAG}"
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                sh "kubectl apply -f ./spring-deployment.yaml -n ${NAMESPACE}"
            }
        }
        stage('Service to Kubernetes') {
            steps {
                sh "kubectl apply -f ./spring-service.yaml -n ${NAMESPACE}"
            }
        }
        stage('Deployment Image to Update') {
            steps {
                sh "kubectl set image deployment/springboot-app-team2 group1-team2-app=${REGISTRY}/${IMAGE_NAME}:${IMAGE_TAG} --namespace=${NAMESPACE}"
            }
        }
    }
}
