FROM openjdk:11-jre-slim

# Setting the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY ../build/libs/openfabric-api-1.0.0-SNAPSHOT.jar ./app.jar

EXPOSE 8080

# to run the application when the container starts
CMD ["java", "-jar", "app.jar"]
