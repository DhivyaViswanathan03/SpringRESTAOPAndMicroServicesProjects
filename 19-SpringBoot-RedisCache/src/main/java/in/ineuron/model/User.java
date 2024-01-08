package in.ineuron.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private Long salary;
}
