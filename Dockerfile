FROM gradle:8-jdk21 AS build

WORKDIR /home/gradle

CMD ["./gradlew", "clean", "bootJar"]
COPY demo/build/libs/*.jar app.jar


EXPOSE 8080

FROM eclipse-temurin:21-alpine
RUN addgroup -g 1000 app
RUN adduser -G app -D -u 1000 -h /app app

USER app
WORKDIR /app
COPY --from=build --chown=1000:1000 /home/gradle/app.jar .



ENTRYPOINT ["java", "-jar", "app.jar"]