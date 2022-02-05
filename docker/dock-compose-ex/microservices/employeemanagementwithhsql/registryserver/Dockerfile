FROM openjdk:11


# Copy the jar to the production image from the builder stage.
COPY  target/registryserver-0.0.1-SNAPSHOT.war /registry.war

# expose container port for outer world
EXPOSE 8761

# Run the web service on container startup.
CMD java  -jar /registry.war

