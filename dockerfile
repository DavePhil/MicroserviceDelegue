FROM openjdk:8
WORKDIR /app
EXPOSE 9008
COPY target/microdelegue.jar /app
CMD ["java","-jar","microdelegue.jar"]