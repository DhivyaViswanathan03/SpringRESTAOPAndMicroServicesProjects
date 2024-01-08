package in.ineuron.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private Integer cno;
	private String cname;
	private Float billamount;
	
	private String[] techs;
	private List<String> countries;
	private Set<Long> phonenumbers;
	private Map<String,Object> idDetails;

}
