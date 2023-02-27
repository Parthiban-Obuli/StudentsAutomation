package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StudentEndPoints2;
import api.payload.Student;
import io.restassured.response.Response;

public class StudentTests2 
{	
	Faker faker=new Faker();
	Student studentpayload=new Student();
	int ID;
	public Logger logger;
	@BeforeClass
	public void setdata()
	{
		studentpayload.setName(faker.name().fullName());
		studentpayload.setLocation(faker.address().city());
		studentpayload.setPhone(faker.phoneNumber().cellPhone());
		String coursesArr[]= {"Data Science","Big Data"};
		studentpayload.setCourses(coursesArr);
		logger=LogManager.getLogger(this.getClass());
	}
	@Test(priority=1)
	public void testCreateStudent()
	{
		logger.info("----- Creating a New Student ------");
		Response response=StudentEndPoints2.createStudent(studentpayload);
		response.then().log().all();	
		Assert.assertEquals(response.statusCode(), 201);
		
		JSONObject obj=new JSONObject(response.asString());
		ID=obj.getInt("id");
		logger.info("----- Created a New Student ------");
	}
	@Test(priority=2)
	public void testGetStudent()
	{
		logger.info("----- Getting the Details of a New Student ------");
		Response response=StudentEndPoints2.readStudent(ID);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("----- Got the Details of a New Student ------");
	}
	@Test(priority=3)
	public void testUpdateStudent()
	{
		logger.info("----- Updating the Details of a New Student ------");
		studentpayload.setName(faker.name().fullName());
		studentpayload.setLocation(faker.address().city());
		studentpayload.setPhone(faker.phoneNumber().cellPhone());
		String coursesArr[]= {"Updated Data Science", "Updated Big Data"};
		studentpayload.setCourses(coursesArr);
		Response response=StudentEndPoints2.updateStudent(ID, studentpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);		
		logger.info("----- Updated the Details of a New Student ------");
	}
	@Test(priority=4)
	public void testDeleteStudent()
	{
		logger.info("----- Deleting the New Student ------");
		Response response=StudentEndPoints2.deleteStudent(ID);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("----- Deleted the New Student ------");
	}
	
}
