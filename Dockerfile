# The first stage of our build will extract the layers
FROM openjdk:11-jre-slim-buster as builder
WORKDIR /kairosds/prices
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} prices.jar
RUN java -Djarmode=layertools -jar prices.jar extract

# The second stage of our build will copy the extracted layers
FROM openjdk:11-jre-slim-buster
LABEL org.opencontainers.image.authors="carlos.martin@kairosds.com"
WORKDIR /kairosds/prices
COPY --from=builder /kairosds/prices/dependencies/ ./
COPY --from=builder /kairosds/prices/spring-boot-loader/ ./
COPY --from=builder /kairosds/prices/snapshot-dependencies/ ./
COPY --from=builder /kairosds/prices/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]