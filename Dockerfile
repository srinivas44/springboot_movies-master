FROM openjdk:8-jdk-alpine
VOLUME /tmp
# Fetch the .jar file to create docker image 
COPY target/movies-0.0.1-SNAPSHOT.jar movies-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/movies-0.0.1-SNAPSHOT.jar"]

