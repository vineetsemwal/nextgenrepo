FROM openjdk:11


# Copy the jar to the production image from the builder stage.
COPY  target/projectsms-0.0.1-SNAPSHOT.war /projectms.war

# expose container port for outer world
EXPOSE 8586

# Run the web service on container startup.
CMD java  -jar /projectms.war