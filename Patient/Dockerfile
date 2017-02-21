FROM java:8
VOLUME /tmp
ADD Patient.jar Patient.jar
EXPOSE 8080
RUN bash -c 'touch /Patient.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/micros", "-Djava.security.egd=file:/dev/./urandom","-jar","/Patient.jar"]
