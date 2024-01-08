package in.ineuron.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;
import in.ineuron.repo.IPersonRepo;
import in.ineuron.repo.IPhoneNumberRepo;

@Service
public class IPhoneMgmtServiceImpl implements IPhoneMgmtService {
	
	@Autowired
	private IPersonRepo personRepo;
	
	@Autowired
	private IPhoneNumberRepo phoneNumberRepo;

	@Override
	public String savePerson(Person person) {
		Person p = personRepo.save(person);
		return "Person saved with id:"+p.getPid();
	}


	@Override
	public String savePhoneNumber(List<PhoneNumber> phoneNumbers) {
		
		for(PhoneNumber phone:phoneNumbers) {
			phoneNumberRepo.save(phone);
		}
		return phoneNumbers.size()+" no of PhoneNumbers saved successfully";
	}


	@Override
	public Iterable<Person> getAllPerson() {
		return personRepo.findAll();
	}


	@Override
	public Iterable<PhoneNumber> getAllPhoneNumbers() {
		return phoneNumberRepo.findAll();
	}


	@Override
	public String deleteByPerson(Integer id) {
		Optional<Person> person = personRepo.findById(id);
		if(person.isPresent()) {
			personRepo.deleteById(id);
			return "Record deleted successfully";
		}
		return "Record not found";
	}


	@Override
	public String deleteAllPhoneOfPerson(Integer id) {
		Optional<Person> person = personRepo.findById(id);
		if(person.isPresent()) {
			Set<PhoneNumber> contactList = person.get().getContactList();
			contactList.forEach(contact->{
				contact.setPerson(null);
				phoneNumberRepo.deleteById(contact.getRegNo());
			});
			return contactList.size()+" no of records got deleted";
			
		}
		return "Record not found";
	}

}
