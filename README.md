<h3>
REST microservices using VirtualBox/Vagrant, Docker containers, Spring Boot, MongoDB, Spring Data MongoRepository API.
<br/>
<br/>
Currently three Microservices that will each be deployed in their own Docker container running seperately for scalability and HA:
Patient, Patient Appointments, Patient Medications
</h3>

<br/>

<hr>
<h3>STEPS</h3>
<hr>
<b>start/ssh vagrant server</b>


<b>start spring studio suite</b>


<b>install/start mongodb using docker image:</b>

	sudo docker run -P -d --name mongodb mongo


<b>(if needed)RE-start mongodb container:</b>

	docker ps -a (list all, get container id)
	(stop)  docker stop container_id
	(start) docker start container_id
	
	
<b>check mongo (you will need the port number):</b>

	sudo docker exec -it mongodb sh
	# mongo (test then exit, exit)
	docker ps (get port number)
	curl 192.168.0.249:32768 (check port above)


<b>create project:</b>

	open Spring Tool Suite
	import gradle file, choose Build Model to create project


<b>build project/jar:</b>

	go to project directory, run "gradle build"
	ftp or copy JAR to your virtual machine


<b>Create Docker image container for Spring Boot application and link to Mongo Docker container:</b>

	sudo vi Dockerfile (192.168.0.249:32768)
		FROM java:8
		VOLUME /tmp
		ADD build/libs/Patient.jar patient.jar
		EXPOSE 8080
		RUN bash -c 'touch /patient.jar'
		ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/micros", "-Djava.security.egd=file:/dev/./urandom","-jar","/patient.jar"]
	
	Build patient microservice Docker image:
		sudo docker build -t microservices/patient .
	
	Run container image, linking to "mongodb" container:
		docker run -P -d --name patient --link mongodb microservices/patient
		
	Run commands on the container:
		docker exec patient bash -c 'env' (check env vars)
		docker exec patient bash -c 'ls' (list directories)
	
	Web application now running on Vagrant VM from Docker container:
	POST:
		192.168.0.249:32776/patient (vagrant server IP : microservice exposed port)
		* run "docker ps" to get patient service port number
		Content-Type = application/json
		Payload:
			{
				"patientId": "0001",
				"firstName": "Jason",
				"lastName": "Muse",
				"address": "1212 Beach Street",
				"city": "Tampa",
				"state": "FL",
				"zipcode": "33602",
				"phone": "813-555-4444",
				"email": "email@email.com"
			}		
	GET:
		192.168.0.249:32776/patient/0001
		192.168.0.249:32776/patient  (GET all)

<br/>

<br/>

<b>Build the Patient Appointments and Medication microservices as Docker images/containers the same as with Patient MS.</b>

	sudo docker build -t microservices/patientappt .
	sudo docker build -t microservices/patientmed .
	docker run -P -d --name patientappt --link mongodb microservices/patientappt
	docker run -P -d --name patientmed --link mongodb microservices/patientmed
	
<br/>

<b>If you update the microservice code you need to rebuild the Docker image and remove the old image:</b>
	
	sudo docker stop patient
	docker rm patient
	docker run -P -d --name patient --link mongodb microservices/patient
	* same with all other microservices
	
<br/>

<b>If any issues throughout these steps you can always try a fresh start by removing ALL the Docker containers from the VM, and go over the steps again:</b>
	
	sudo docker stop $(docker ps -a -q)
	sudo docker rm $(docker ps -a -q)
	
<br/>

<b>Testing Patient Appointment and Medication Microservices [all seperate Docker containers].  First these microservices need to be build and deployed as Docker containers just like above.</b>

	Patient Appointments:
	192.168.0.249:32776/appointment (vagrant server IP : microservice exposed port), run "docker ps" to get appointment service port number
	POST:
		Content-Type = application/json
		Payload:
			{
			  "apptId": "1111",
			  "patientId": "0001",
			  "physicianId": "2222",
			  "description": "Quaterly Blood Work CBC LIPID PANEL",
			  "apptDttm": "030520171400"
			}
	GET:
		192.168.0.249:32776/appointment/1111
		192.168.0.249:32776/appointment  (GET all)
	
	
	Patient Medications:
	192.168.0.249:32776/medication (vagrant server IP : microservice exposed port), run "docker ps" to get medication service port number
	POST:		
		Content-Type = application/json
		Payload:
			{
			  "prescId": "1111",
			  "patientId": "0001",
			  "physicianId": "2222",
			  "name": "Vitamin D3",
			  "description": "Vitamin D3 supplements",
			  "dosage": "5000iu",
			  "frequency": "daily",
			  "duration": "365",
			  "startDttm": "01012017",
			  "endDttm": "01012027"
			}
	GET:
		192.168.0.249:32776/medication/1111
		192.168.0.249:32776/medication  (GET all)

		
<br/><br/>

<b>If you want to start/test your application using a CMD window before creating a Docker image use commands below.  One at a time.  Use localhost:8080/servicename as URI:</b>
	
	Patient service:
	java -Dspring.data.mongodb.uri=mongodb://192.168.0.249:32768/micros -jar build/libs/Patient.jar
	
	Patient Appointments service:
	java -Dspring.data.mongodb.uri=mongodb://192.168.0.249:32768/micros -jar build/libs/PatientAppts.jar
	
	Patient Medications service:
	java -Dspring.data.mongodb.uri=mongodb://192.168.0.249:32768/micros -jar build/libs/PatientMeds.jar

<br/>
<hr>

<h1>Docker Compose to start all of the microservices:</h1>


	Install Docker Compose:
		sudo curl -L "https://github.com/docker/compose/releases/download/1.9.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
		sudo chmod +x /usr/local/bin/docker-compose
		sudo usermod -G docker vagrant		
	
	I created a directory that has three subdirectories: patient, appointment, medication.  Each with its own Dockerfile and JAR.
	docker-compose.yml:
		patient:
		 build: patient
		 ports:
		  - "8080"
		 links:
		  - mongodb
		patientappt:
		 build: appointment
		 ports:
		  - "8080"
		 links:
		  - mongodb
		patientmed:
		 build: medication
		 ports:
		  - "8080"
		 links:
		  - mongodb
		mongodb:
		 image: mongo
		 
	Run the docker-compose YAML:
		sudo docker-compose up -d
		
	Check to see running:
		docker-compose ps
	
	If issues, you can always check container logs:
		docker logs containerid
		
	Test:
		docker-compose ps to get port numbers for each first:
		patient:     192.168.0.249:32777/patient
		patientappt: 192.168.0.249:32778/appointment
		patientmed:  192.168.0.249:32776/medication
		curl 
		
	Scale a container:
		docker-compose scale patient=5
		docker-compose scale patient=1 (scale back down)
		docker-compose scale patientappt=5
		docker-compose scale patientmed=5
 
 
 