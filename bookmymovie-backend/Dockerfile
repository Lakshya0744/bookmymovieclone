FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom and source
COPY pom.xml .
COPY src src

# Build the project
RUN mvn clean package -DskipTests

# Use OpenJDK to run
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/bookmymovie-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

