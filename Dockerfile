FROM eclipse-temurin:21-jdk-alpine

LABEL maintainer="shaik.shafin057@gmail.com"

WORKDIR /app

COPY target/springboot-0.0.1-SNAPSHOT.jar /app/springboot-docker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "springboot-docker.jar"]