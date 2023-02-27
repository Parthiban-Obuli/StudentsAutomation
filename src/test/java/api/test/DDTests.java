package api.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.StudentEndPoints;
import api.payload.Student;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests 
{
	int ID;
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostStudent(String Name, String Location, String Phone)
	{
		Student studentpayload= new Student();
		studentpayload.setName(Name);
		studentpayload.setLocation(Location);
		studentpayload.setPhone(Phone);
		String coursesArr[]= {"Course1","Course2"};
		studentpayload.setCourses(coursesArr);
		
		Response response=StudentEndPoints.createStudent(studentpayload);
		//JSONObject obj=new JSONObject(response.asString());
		//ID=obj.getInt("id");
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 201);
	}
	//@Test(priority=2)
	public void testDeleteStudent()
	{
		Response response=StudentEndPoints.deleteStudent(ID);
		response.then().log().all();
	}
}
