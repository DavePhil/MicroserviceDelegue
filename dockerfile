FROM openjdk:17-alpine
WORKDIR /app
EXPOSE 9008
COPY target/microdelegue.jar /app
CMD ["java","-jar","microdelegue.jar"]