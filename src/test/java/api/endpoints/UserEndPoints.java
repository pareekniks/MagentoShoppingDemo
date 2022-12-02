package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import io.restassured.response.Response;

public class UserEndPoints {
	
	//method to read the properties file
	static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("routes");
		return routes;
	}
	

	public static Response generateUser(String nationlity) {

		Response response = given().queryParam("nat", nationlity).when().get(getURL().getString("get_url"));

		return response;
	}

}
