def call(String imagename){
  sh "docker build -t ${imagename} . "
}
