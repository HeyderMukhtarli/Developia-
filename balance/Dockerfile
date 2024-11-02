
FROM openjdk:21-jdk-slim

ARG JAR_FILE=target/*.jar

# Copy the JAR file to the container
COPY target/balance-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]
