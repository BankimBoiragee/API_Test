package rest.usa.basepage;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;

public class Base_Page {
	//public static RequestSpecification httpRequest;
	//public static Response response;
	//RequestSpecification httpRequest = RestAssured.given();
	 //Response Instance, end point(query=/posts)or path parameter
	//Response response = httpRequest.request(Method.GET, domain + "/posts");
	public String empID="";
	
	public static Logger log;
	@BeforeClass
	public void setUp() {
		log=Logger.getLogger("QA Lead Bankim");
		PropertyConfigurator.configure("log4j.properties");
	}
}
