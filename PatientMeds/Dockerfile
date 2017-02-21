FROM java:8
VOLUME /tmp
ADD PatientMeds.jar PatientMeds.jar
EXPOSE 8080
RUN bash -c 'touch /PatientMeds.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/micros", "-Djava.security.egd=file:/dev/./urandom","-jar","/PatientMeds.jar"]
