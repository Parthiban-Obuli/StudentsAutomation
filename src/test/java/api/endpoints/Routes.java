package api.endpoints;
/*
Base URI -> http://localhost:3000/Students

POST Request -> http://localhost:3000/Students
GET Request -> http://localhost:3000/Students/{studentid}
PUT Request -> http://localhost:3000/Students/{studentid}
Delete Request -> http://localhost:3000/Students/{studentid}
*/
public class Routes 
{
	public static String baseuri="http://localhost:3000/Students";
	
	public static String post_url=baseuri;
	public static String get_url=baseuri+"/{studentid}";
	public static String put_url=baseuri+"/{studentid}";
	public static String delete_url=baseuri+"/{studentid}";
}
