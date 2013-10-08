package de.dennis_boldt;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class JerseyClient {

	public JerseyClient(String[] args) {
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);

		WebResource webResource = client.resource("http://localhost:3333/helloworld");

		// GET as plain text
		String textPlain = webResource.accept(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(textPlain);

		// GET as html
		String textHtml = webResource.accept(MediaType.TEXT_HTML).get(String.class);
		System.out.println(textHtml);

		// GET as html
		List<String> textJson = webResource.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<String>>() {});
		for (String s : textJson) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		new JerseyClient(args);
	}

}
