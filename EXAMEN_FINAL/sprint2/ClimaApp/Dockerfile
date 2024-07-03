# Etapa de construcción
FROM gradle:7.4.2-jdk17 AS build
WORKDIR /app
COPY . /app
RUN gradle build --no-daemon

# Etapa de ejecución
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/build/libs /app/libs
CMD ["java", "-cp", "/app/libs/*", "org.example.Main"]
