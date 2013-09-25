package de.dennis_boldt;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class JerseyClient {

	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:11111/helloworld");
		String result = webResource.get(String.class);
		System.out.println(result);
	}
}
