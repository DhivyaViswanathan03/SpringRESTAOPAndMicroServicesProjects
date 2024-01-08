package in.ineuron.controller;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Customer;

/**
 * Hello world!
 *
 */
public class CustomerController 
{
    public static void main( String[] args )
    {
    	ObjectMapper obj= new ObjectMapper();
    	
    	try {
//			Customer customer=obj.readValue(new File("data/sample-lite.json"), Customer.class);
//			System.out.println(customer);
			Customer customer=obj.readValue(new File("data/sample-lite.json"), Customer.class);
			System.out.println(customer.getId());
			System.out.println(customer.getFirstName());
			System.out.println(customer.getLastName());
			System.out.println(customer.isActive());
			System.out.println(customer.getAddress());
			
			for(String language:customer.getLanguages()) {
				System.out.println(language);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
}
