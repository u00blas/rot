FROM openjdk:17-alpine
LABEL authors="frankblass"
ARG JAR_FILE=target/*.jar
COPY ./target/rot-application-0.11.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]