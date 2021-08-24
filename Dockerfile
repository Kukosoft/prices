FROM openjdk:11-jre-slim-buster
LABEL org.opencontainers.image.authors="carlos.martin@kairosds.com"
COPY target/prices-1.0.jar prices.jar
ENTRYPOINT ["java","-jar","/prices.jar"]