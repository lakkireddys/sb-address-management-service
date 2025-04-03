FROM eclipse-temurin:17.0.14_7-jdk-alpine-3.21@sha256:b16e661d76d3af0d226d0585063dbcafe7fb8a4ef31cfcaaec71d39c41269420
LABEL authors="lakki"
WORKDIR /usr/app
COPY target/*.jar app.jar
RUN addgroup -S app && \
    adduser -S -D -h /usr/app/jar app app && \
    chown -R app:app /usr/app \
USER app
EXPOSE 9094
ENTRYPOINT ["java", "-jar", "app.jar"]