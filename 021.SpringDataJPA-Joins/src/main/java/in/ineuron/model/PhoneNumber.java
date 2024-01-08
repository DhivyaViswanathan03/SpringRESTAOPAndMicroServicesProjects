package in.ineuron.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class PhoneNumber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer regNo;
	
	@NonNull
	private Long phoneNumber;
	@NonNull
	private String provider;
	@NonNull
	private String type;

	@ManyToOne(targetEntity = Person.class,cascade = CascadeType.ALL)
	private Person person;

	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", phoneNumber=" + phoneNumber + ", provider=" + provider + ", type="
				+ type + "]";
	}
	
	
	
	
}
