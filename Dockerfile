FROM openjdk:8-jdk-alpine
RUN mkdir -p /spring-boot-service
ADD target/* /spring-boot-service/
WORKDIR /spring-boot-service
RUN ls -l
EXPOSE 8080
RUN pwd
ENTRYPOINT ["java","-jar","gs-rest-service-0.1.0.jar"]