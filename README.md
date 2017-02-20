<h3>Quickly build/deploy REST microservice using Spring Boot, Docker, MongoDB</h3>



<b>start/ssh vagrant server</b>


<b>start spring studio suite</b>


<b>install/start mongodb using docker image:</b>

	sudo docker run -P -d --name mongodb mongo


<b>RE-start mongodb:</b>

	docker ps -a (list all, get container id)
	(stop)  docker stop container_id
	(start) docker start container_id
	
	
<b>Remove all containers, start fresh:</b>

	sudo docker stop $(docker ps -a -q)
	sudo docker rm $(docker ps -a -q)
	sudo docker run -P -d --name mongodb mongo
	sudo docker exec -it mongodb sh


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


<b>start Spring/REST application:</b>

	java -Dspring.data.mongodb.uri=mongodb://192.168.0.249:32768/micros -jar build/libs/Patient.jar


<b>test with Postman:</b>

	POST: http://localhost:8080/patient
	Content-Type = application/json
	Payload example:
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
		http://localhost:8080/patient/0001
		

<b>Spring Boot application to Docker Container as a microservice:</b>

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
		192.168.0.249:32776/patient
		* same content-type, payload setup above
		* run docker ps to get patient port number
	GET:
		192.168.0.249:32776/patient/0002

	
	
	
	
	