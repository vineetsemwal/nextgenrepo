FROM openjdk:11


# Copy the jar to the production image from the builder stage.
COPY  target/empms-0.0.1-SNAPSHOT.war /empms.war

# expose container port for outer world
EXPOSE 8587

# Run the web service on container startup.
CMD java  -jar /empms.war

