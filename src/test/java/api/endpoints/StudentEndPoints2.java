package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.Student;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class StudentEndPoints2 
{
	public static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	public static Response createStudent(Student payload)
	{
		String post_url=getURL().getString("post_url");
		Response response=given()
			.contentType(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_url);
		return response;			
	}
	public static Response readStudent(int studentID)
	{
		String get_url=getURL().getString("get_url");
		Response response=given()
			.pathParam("studentid", studentID)
		.when()
			.get(get_url);
		return response;
	}
	public static Response updateStudent(int studentID, Student payload)
	{
		String put_url=getURL().getString("put_url");
		Response response=given()
			.contentType(ContentType.JSON)
			.pathParam("studentid", studentID)
			.body(payload)
		.when()
			.put(put_url);
		return response;
	}
	public static Response deleteStudent(int studentID)
	{
		String delete_url=getURL().getString("delete_url");
		Response response=given()
			.pathParam("studentid", studentID)
		.when()
			.delete(delete_url);
		return response;
	}
}
