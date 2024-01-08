package in.ineuron.model;

import lombok.Data;

@Data
public class Product {
	
	private Integer pid;
	private String pName;
	private Float pCost;
	private String[] techies;

}
