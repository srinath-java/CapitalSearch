package services;

import java.io.IOException;
import java.util.Scanner;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import com.google.gson.Gson;
import model.Country;
import util.Helper;


public class CapitalService {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in); 
		System.out.println("Enter CODE or NAME to get capital .Enter EXIT/exit to terimmate this program.....");
		String input = myObj.nextLine();  
		String capital=null;
		CapitalService service=new CapitalService();
		while (!input.equalsIgnoreCase("exit") ){
			try {
				capital=service.getCapitalByName(input);
			} catch (Exception e) {
				//System.out.println("Error checking with name ...");
			}


			try {
				if(capital!=null) {
					capital=service.getCapitalByCode(input);
				}

			} catch (Exception e) {
				//System.out.println("Error checking with code ...");
			}


			if(capital==null) {
				System.out.println("Sorry .capital not found for the search.");
			}else {
				System.out.println("-------------------------------------------------------------");
				System.out.println(capital +" is capital for input country "+input);
				System.out.println("-------------------------------------------------------------");
			}

			System.out.println("Enter CODE or NAME to get capital .Enter EXIT/exit to terimmate this program.....");
			input = myObj.nextLine();
			capital=null;

		}
		
		System.out.println("----------Thanks for using our service --------------");
		System.out.println("         Stay home and stay safe (COVID-19)!!!    ");

	}

	//search by name
	public String getCapitalByName(String name) throws Exception {

		if(name==null || name.isEmpty()) {
			throw new Exception("Name can't be null or empty.");
		}

		Client client = ClientBuilder.newClient( new ClientConfig() );//.register( LoggingFilter.class )
		WebTarget webTargetWithName = client.target(Helper.getRestURLforCaptialByName()).path(name);

		Invocation.Builder invocationBuilder =  webTargetWithName.request(MediaType.APPLICATION_JSON_TYPE);
		Response response = invocationBuilder.get();

		if(response.getStatus()==404) {
			throw new Exception("Not found");
		}
		//System.out.println(response.getStatus());
		//System.out.println(response.readEntity(String.class));
		Country[]   country=new Gson().fromJson(response.readEntity(String.class), Country[].class);
		//System.out.println(country.getName()+"--->"+country.getCapital());
		return country[0].getCapital();

	}


	//search by code
	public String getCapitalByCode(String code) throws Exception {

		if(code==null || code.isEmpty()) {
			throw new Exception("Code can't be null or empty.");
		}


		Client client = ClientBuilder.newClient( new ClientConfig() );//.register( LoggingFilter.class )
		WebTarget webTargetWithName = client.target(Helper.getRestURLforCaptialByCode()).path(code);

		Invocation.Builder invocationBuilder =  webTargetWithName.request(MediaType.APPLICATION_JSON_TYPE);
		Response response = invocationBuilder.get();

		if(response.getStatus()==400) {
			throw new Exception("Not found");
		}
		//System.out.println(response.getStatus());
		//System.out.println(response.readEntity(String.class));
		Country   country=new Gson().fromJson(response.readEntity(String.class), Country.class);
		//System.out.println(country.getName()+"--->"+country.getCapital());
		return country.getCapital();

	}



}
