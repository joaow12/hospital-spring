FROM maven:3.8.2-jdk-8

WORKDIR /medico
COPY . .

CMD mvn spring-boot:run