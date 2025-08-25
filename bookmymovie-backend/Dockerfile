# Use OpenJDK 17
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for caching dependencies)
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Download dependencies (cache)
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build the project
RUN ./mvnw package -DskipTests

# Expose port
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "target/bookmyshow-0.0.1-SNAPSHOT.jar"]
