Task 1:

The arguments i used for running docker was as follows:
docker run -p 5432:5432 ^
More? -e POSTGRES_PASSWORD=mypassword ^
More? -d --name my-postgres --rm postgres

I succesfully checked that it was working using the docker ps command:
C:\Users\morte>docker ps
CONTAINER ID   IMAGE      COMMAND                  CREATED         STATUS         PORTS                    NAMES
08698d7a0eb1   postgres   "docker-entrypoint.s…"   7 seconds ago   Up 6 seconds   0.0.0.0:5432->5432/tcp   my-postgres

When trasnitioning from the H2 databse to the postgresSQL database i hade to run the following SQL in order to grant the user we created the permissions needed. This made my Junit tests pass:
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO jpa_client;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO jpa_client;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public TO jpa_client;


Task 2

I created my dockerfile with this code:

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