def call(String imageName, String dockerHubCredId) {
    withCredentials([usernamePassword(
        credentialsId: dockerHubCredId,
        usernameVariable: 'dockerHubUser',
        passwordVariable: 'dockerHubPass'
    )]) {
        sh """
            echo \$dockerHubPass | docker login -u \$dockerHubUser --password-stdin
            docker image tag ${imageName} \$dockerHubUser/${imageName}
            docker push \$dockerHubUser/${imageName}
        """
    }
}
