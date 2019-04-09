FROM openjdk:8-jdk-alpine
COPY target /opt/dqa-boot-service
WORKDIR /opt/dqa-boot-service/target
ENTRYPOINT ["java","-jar","gs-rest-service-0.1.0.jar"]