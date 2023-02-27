package api.payload;

public class Student 
{
	String Name;
	String Location;
	String Phone;
	String Courses[];
	public String getName() 
	{
		return Name;
	}
	public void setName(String name) 
	{
		Name = name;
	}
	public String getLocation() 
	{
		return Location;
	}
	public void setLocation(String location) 
	{
		Location = location;
	}
	public String getPhone() 
	{
		return Phone;
	}
	public void setPhone(String phone) 
	{
		Phone = phone;
	}
	public String[] getCourses() 
	{
		return Courses;
	}
	public void setCourses(String[] courses) 
	{
		Courses = courses;
	}	
}
