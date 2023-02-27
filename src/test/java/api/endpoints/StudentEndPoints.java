package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import api.payload.Student;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class StudentEndPoints 
{
	static int studentID;
	public static Response createStudent(Student payload)
	{
		Response response=given()
			.contentType(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);		
		return response;		
	}
	public static Response readStudent(int studentID)
	{
		Response response=given()
			.pathParam("studentid", studentID)
		.when()
			.get(Routes.get_url);
		return response;
	}
	public static Response updateStudent(int studentID,Student payload)
	{
		Response response=given()
			.contentType(ContentType.JSON)
			.pathParam("studentid", studentID)
			.body(payload)
		.when()
			.put(Routes.put_url);
		return response;
	}
	public static Response deleteStudent(int studentID)
	{
		Response response=given()
			.pathParam("studentid", studentID)
		.when()
			.delete(Routes.delete_url);
		return response;
	}
}
