package com.example.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.databene.benerator.anno.Source;
import org.databene.feed4testng.FeedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends FeedTest {
  	@Test(dataProvider="feeder")
  	@Source("./data/add.csv")
  	public void doGet(String a,String b,String expected) throws Exception{
  		CloseableHttpClient  client = HttpClients.createDefault();
  		java.net.URI uri = new URIBuilder()
  				.setScheme("http")
  				.setHost("192.168.44.130")
  				.setPort(8080)
  				.setPath("/project158/FormServlet")
  				.setParameter("a",a)
  				.setParameter("b",b)
  				.build();		
  		HttpGet request = new HttpGet(uri);	
  		CloseableHttpResponse  response = client.execute(request);
  		HttpEntity  responseEntity = response.getEntity();
  		String result = EntityUtils.toString(responseEntity);
  		System.out.println(result);
  		Assert.assertEquals(result, expected);
  		}
  			
  		
  	}



    

