
<b>start/ssh vagrant server</b>


<b>start spring studio suite</b>


<b>start mongodb using docker image:</b>

	sudo docker run -P -d --name mongodb mongo
	sudo docker exec -it mongodb sh
	# mongo (test then exit, exit)


<b>(optional) if you want to remove containers and start fresh:</b>

	sudo docker stop $(docker ps -a -q)
	sudo docker rm $(docker ps -a -q)
	sudo docker run -P -d --name mongodb mongo
	sudo docker exec -it mongodb sh


<b>check mongo (you will need the port number):</b>

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
		
