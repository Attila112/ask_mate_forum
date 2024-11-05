# Stage 1: Build the application using Maven
FROM maven:3.8.5-eclipse-temurin-17 AS build

# Set the working directory in the container for the build
WORKDIR /app

# Copy pom.xml and source code to the container
COPY pom.xml .

COPY src ./src

# Build the project and create the jar file
RUN mvn clean package -DskipTests

# Stage 2: Run the application using the JAR created in the build stage
FROM openjdk:17-alpine

# Set the working directory for the runtime container
WORKDIR /app

# Copy the JAR file from the build stage to the runtime container
COPY --from=build /app/target/askmateoop-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 to allow traffic to the application
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
