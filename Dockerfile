#use open jdk version 17
FROM openjdk:22-jdk-slim

#set the working directory
WORKDIR /app

#copy spring boot jar to container jar
COPY target/findajob-0.0.1-SNAPSHOT.jar /app/findajob-v1.jar

#Expose port - 8080
EXPOSE 8080

#command to run the application
ENTRYPOINT ["java", "-jar", "/app/findajob-v1.jar"]