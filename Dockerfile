FROM openjdk:13-alpine3.10
EXPOSE 8080
ADD target/demo-0.0.1-SNAPSHOT.jar myApp.jar
ENTRYPOINT ["java", "-jar", "/myApp.jar"]

