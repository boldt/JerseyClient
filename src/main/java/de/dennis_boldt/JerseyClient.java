package de.dennis_boldt;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class JerseyClient {

	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:11111/helloworld");
		String textPlain = webResource.accept(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(textPlain);

		String textHtml = webResource.accept(MediaType.TEXT_HTML).get(String.class);
		System.out.println(textHtml);
	}
}
