package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StudentEndPoints;
import api.payload.Student;
import io.restassured.response.Response;

public class StudentTests 
{
	Faker faker=new Faker();
	Student studentpayload=new Student();
	int ID;
	public Logger logger;
	@BeforeClass
	public void setupData()
	{
		studentpayload.setName(faker.name().fullName());
		studentpayload.setLocation(faker.address().city());
		studentpayload.setPhone(faker.phoneNumber().cellPhone());
		String coursesArr[]= {"REST ASSURED", "AUTOMATION"};
		studentpayload.setCourses(coursesArr);	
		
		//Log4j2
		logger=LogManager.getLogger(this.getClass());
	}
	@Test(priority=1)
	public void testCreateStudent()
	{
		logger.info("***** Creating Student ******");
		Response response=StudentEndPoints.createStudent(studentpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 201);
		JSONObject obj1=new JSONObject(response.asString());
		ID=obj1.getInt("id");
		System.out.println("ID is:"+" "+ID);
		logger.info("***** Student is Created ******");
	}
	@Test(priority=2)
	public void testGetStudentByID()
	{
		logger.info("***** Reading Student ******");
		Response response=StudentEndPoints.readStudent(ID);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("***** Got the Student Details ******");
	}
	@Test(priority=3)
	public void testUpdateStudentByID()
	{
		logger.info("***** Updating Student ******");
		studentpayload.setName(faker.name().fullName());
		studentpayload.setLocation(faker.address().city());
		studentpayload.setPhone(faker.phoneNumber().cellPhone());
		String courseArr[]= {"updated REST ASSURED","updated AUTOMATION"};
		studentpayload.setCourses(courseArr);
		Response response=StudentEndPoints.updateStudent(ID, studentpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("***** Updated Student ******");
	}
	@Test(priority=4)
	public void testDeleteStudentByID()
	{
		logger.info("***** Deleting Student ******");
		Response response=StudentEndPoints.deleteStudent(ID);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("***** Deleted Student ******");
	}	
}
