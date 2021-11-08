FROM openjdk:13-alpine3.9

EXPOSE 8080

ADD target/demo-0.0.1-SNAPSHOT.jar conditional.jar

ENTRYPOINT ["java", "-jar", "conditional.jar"]
