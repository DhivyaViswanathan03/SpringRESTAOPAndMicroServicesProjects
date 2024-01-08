package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;

public interface IPhoneMgmtService {
	
	public String savePerson(Person person);
	public String savePhoneNumber(List<PhoneNumber> phoneNumbers);
	
	public Iterable<Person> getAllPerson();
	
	public Iterable<PhoneNumber> getAllPhoneNumbers();
	
	public String deleteByPerson(Integer id);
	
	public String deleteAllPhoneOfPerson(Integer id);
}
