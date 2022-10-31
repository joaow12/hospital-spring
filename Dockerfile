FROM openjdk:11-jdk
MAINTAINER Julio Santos
WORKDIR /app
COPY target/integracao-continua-0.0.1.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]