import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tpajay.springboot.rest.Patient;


//This test case is using REST application: https://github.com/tpajay/SpringBootDockerMongoDB
/*
 * STEPS:
 * start Vagrant server VM (vagrant up)
 * ssh to Vagrant server (vagrant ssh)
 * start all the containers/microservice (docker-compose up -d)
 * verify all running and get port numbers (docker-compose ps)
 *      e.g. vagrant_patient_1 | Up | 0.0.0.0:32775->8080/tcp
 * Use Postman to create a record (eg. POST JSON data to Patient URI)
 * Update port number and URI below (resourceUrl)
 * 
 * Any issues see the README at the GITHUB URL above.
 * 
 */
public class RestTemplateTest {
	
	public static void main(String args[]) {
		
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = "http://192.168.0.249:32790/patient";
		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl + "/0001", String.class);
		
		System.out.println(response.getStatusCode()); //returns 200, see codes below
		
		try {
			//get JSON data -- com.fasterxml.jackson.databind API
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(response.getBody());
			System.out.println("JSON [ResponseEntity.getBody]:" + response.getBody());		
			JsonNode firstName = root.path("firstName");
			JsonNode lastName = root.path("lastName");
			System.out.println("NAME: " + firstName + " " + lastName);
			//assertThat(name.asText(), notNullValue());
		} catch (Exception e) {
			
		}		
		
		System.out.println("\n---------------------------------------\n");
		
		
		//get POJO instead of JSON
		Patient patient = restTemplate.getForObject(resourceUrl + "/0001", Patient.class);
		System.out.println("PATIENT ID: " + patient.getPatientId());
		System.out.println("FIRST NAME: " + patient.getFirstName());
		System.out.println("LAST NAME: " + patient.getLastName());
		System.out.println("ADDRESS: " + patient.getAddress());
		System.out.println("CITY: " + patient.getCity());
		System.out.println("STATE: " + patient.getState());
		System.out.println("ZIPCODE: " + patient.getZipcode());
		System.out.println("MOBILE: " + patient.getPhone());
		System.out.println("EMAIL: " + patient.getEmail());
		
	}
	
}
