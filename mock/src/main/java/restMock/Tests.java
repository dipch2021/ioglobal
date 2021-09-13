package restMock;


import org.json.simple.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.testng.annotations.Test;
import org.testng.Assert;

import io.restassured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.*;
import com.jayway.jsonpath.JsonPath;


import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Tests {

	
	public Response GetResponse()
	{
		//Response response=RestAssured.get("http://metadata-server-mock.herokuapp.com/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e/properties/name");
		
		RequestSpecification httprequest =RestAssured.given();
		httprequest.baseUri("http://localhost:4441");
		
		
		Response response = httprequest.get("/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e");
		
		//System.out.println(" Response BODY : "+response.asString());
		//System.out.println("Status code : "+response.statusCode());
		
		return response;
	}
	
	@Test(priority=0)
	public void Test_RespBody()
	{
		Response resp=GetResponse();
		System.out.println(" Response BODY : "+resp.asString());
		
		Assert.assertEquals(resp.asString().contains("Coin"),true);
		
	}
	
	@Test(priority=1)
	public void Test_RespStatus()
	{
		Response resp=GetResponse();
		System.out.println(" Response Status Code: "+resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(),200);
	}
	
	@Test(priority=2)
	public void TestHeaders()
	{
		Response resp=GetResponse();
		Headers allHeaders=resp.headers();
		System.out.println(" Response Headers: "+resp.headers());
		
		for(Header header : allHeaders)
		{
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
		
		for(Header header : allHeaders)
		{
			if(header.getName()=="Content-Type") {
				Assert.assertEquals(header.getValue().equalsIgnoreCase("application/json"), true);
			}
		}
	}
	
	@Test(priority=3)
	public void TestNodes()
	{
		Response resp=GetResponse();
		//org.json.JSONObject json=new JSONObject(resp.asString());
		Object obj=new Object();
		try {
			obj = new JSONParser().parse(resp.asString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json=(JSONObject)obj;
		System.out.println((json.get("url")).toString());
		
		Map urlmap=(Map) json.get("url");
		
		System.out.println("Seq Number : "+urlmap.get("sequenceNumber"));
		System.out.println("URL value : "+urlmap.get("value"));
		
		
		
	}
	
	@Test(priority=4)
	public void TestPropertyName()
	{
		RequestSpecification httprequest =RestAssured.given();
		httprequest.baseUri("http://localhost:4441");
		
		//Response response_name=httprequest.request(Method.GET, "http://localhost:4441/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e/properties/name");
		//Response response_description=httprequest.request(Method.GET, "http://localhost:4441/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e/properties/description");
		//Response response_url=httprequest.request(Method.GET, "http://localhost:4441/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e/properties/url");
		
		Response response = httprequest.get("/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e/properties/name");
		
		System.out.println(" Response BODY : Name : "+response.asString());
	//	System.out.println("Status code : "+response.statusCode());
		
	}
	
	@Test(priority=5)
	public void TestPropertyURL()
	{
		RequestSpecification httprequest =RestAssured.given();
		httprequest.baseUri("http://localhost:4441");
		
		//Response response_name=httprequest.request(Method.GET, "http://localhost:4441/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e/properties/name");
		//Response response_description=httprequest.request(Method.GET, "http://localhost:4441/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e/properties/description");
		//Response response_url=httprequest.request(Method.GET, "http://localhost:4441/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e/properties/url");
		
		Response response = httprequest.get("/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e/properties/url");
		
		System.out.println(" Response BODY : URL: "+response.asString());
	//	System.out.println("Status code : "+response.statusCode());
		
	}
	
	@Test(priority=6)
	public void TestPropertyDescription()
	{
		RequestSpecification httprequest =RestAssured.given();
		httprequest.baseUri("http://localhost:4441");
		
		//Response response_name=httprequest.request(Method.GET, "http://localhost:4441/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e/properties/name");
		//Response response_description=httprequest.request(Method.GET, "http://localhost:4441/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e/properties/description");
		//Response response_url=httprequest.request(Method.GET, "http://localhost:4441/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e/properties/url");
		
		Response response = httprequest.get("/metadata/2048c7e09308f9138cef8f1a81733b72e601d016eea5eef759ff2933416d617a696e67436f696e/properties/description");
		
		System.out.println(" Response BODY : Description : "+response.asString());
	//	System.out.println("Status code : "+response.statusCode());
		
	}
}
