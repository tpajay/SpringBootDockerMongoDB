
start/ssh vagrant server

start spring studio suite

<b>start mongodb using docker image:</b>

	sudo docker run -P -d --name mongodb mongo
	sudo docker exec -it mongodb sh
	# mongo (test then exit, exit)


(optional) if you want to remove containers and start fresh:

	sudo docker stop $(docker ps -a -q)
	sudo docker rm $(docker ps -a -q)
	sudo docker run -P -d --name mongodb mongo
	sudo docker exec -it mongodb sh


check mongo:

	docker ps (get port number)
	curl 192.168.0.249:32768 (check port above)


create project:

	open Spring Tool Suite
	import gradle file, choose Build Model to create project


build project/jar:

	go to project directory, run "gradle build"


start Spring/REST application:

	java -Dspring.data.mongodb.uri=mongodb://192.168.0.249:32768/micros -jar build/libs/Patient.jar


test with Postman:

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
		
