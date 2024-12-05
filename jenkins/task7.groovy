pipeline{

  agent any

  stages{

    stage('image_build'){
      steps {
        sh '''
           cd ${WORKSPACE}/jenkins/
           docker image build -t image1 -f dockerfile.task7 . 
           

        '''
      }
    }
    stage('image_tag'){
      steps {
        sh '''
           docker image tag image1:latest  vishnugonela/image1:latest
        '''
      }
    }
    stage('image_push'){
      steps{
        sh '''
            docker login -username vishnugonela -password 123456
            docker image push vishnugonela/image1:latest

            echo "Clean up local images"
            docker image rm image1 vishnugonela/image1
        '''
      }
    }
    stage('verify_pull_image_repo'){
      steps{
      sh '''
          docker image pull vishnugonela/image1:latest

      '''
      }
    }
    stage('deploy_app'){
      steps{
      sh '''
          echo "Deploying app"

          docker container run -d --name ${BUILD_ID} vishnugonela/image1:latest 
      '''
      }
    }
    stage('verify_app_runtime'){
      steps{
        sh '''
            echo "Verify app run time"
            docker container logs ${BUILD_ID} | grep "app is running"
            

        '''
      }
    }



  }
  
}
