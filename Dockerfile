FROM openjdk:17-jdk-slim-buster
COPY target/rot-application-0.11.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]