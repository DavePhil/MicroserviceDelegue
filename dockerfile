FROM openjdk:8
WORKDIR /app

COPY target/microdelegue.jar /app
CMD ["java","-jar","microdelegue.jar"]