package in.ineuron.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Product;

/**
 * Hello world!
 *
 */
public class CustomerController 
{
    public static void main( String[] args )
    {
    	ObjectMapper obj= new ObjectMapper();
    	Product p=new Product();
    	p=getProductData(p);
    	System.out.println("Java object::"+p);
    	
    	try {
    		String jsonObject = obj.writeValueAsString(p);
    		System.out.println("JSON obj is::"+jsonObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

	private static Product getProductData(Product p) {
		p.setPid(10);
		p.setPName("cetaphil");
		p.setPCost(10.4f);
		p.setTechies(new String[] {"java","spring"});
		return p;
	}
}
