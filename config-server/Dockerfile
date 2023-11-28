# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/config-server-0.0.1-SNAPSHOT.jar /app/config-server.jar

# Expose the port that the application will run on
EXPOSE 8888

# Define the command to run your application
CMD ["java", "-jar", "config-server.jar"]


# Use a lightweight base image with OpenJDK 17
#FROM openjdk:17-jdk-slim

# Set a volume for temporary storage (if needed)
#VOLUME /tmp

# Expose the port your Spring Boot application uses (change if needed)
#EXPOSE 9901

# Define an argument for the JAR file
#ARG JAR_FILE=target/Account-Service-0.0.1-SNAPSHOT.jar

# Copy the JAR file into the container as "app.jar"
#ADD ${JAR_FILE} app.jar

# Specify the entry point for running the application
#ENTRYPOINT ["java", "-jar", "/app.jar"]