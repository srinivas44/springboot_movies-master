node{
   stage('SCM Checkout from GitHub ..'){
    git 'https://github.com/srinivas44/springboot_movies-master.git'
   }
   
   stage('Compile-Package Clean Install'){
    sh 'printenv'
                withMaven(mavenSettingsConfig: 'maven-settings-global')  
    sh 'mvn clean install'
   }
}
