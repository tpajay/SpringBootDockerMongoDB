FROM java:8
VOLUME /tmp
ADD PatientAppts.jar PatientAppts.jar
EXPOSE 8080
RUN bash -c 'touch /PatientAppts.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/micros", "-Djava.security.egd=file:/dev/./urandom","-jar","/PatientAppts.jar"]
