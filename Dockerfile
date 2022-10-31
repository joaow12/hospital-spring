FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
ADD ./target/${JAR_FILE} app.jar
USER spring:spring
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]