package in.ineuron.runner;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;
import in.ineuron.service.IPhoneMgmtService;

@Component
public class AssociationRunner implements CommandLineRunner {
	
	@Autowired
	private IPhoneMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		//Parent save
//		Person person=new Person("divs","eriyur");
//		
//		PhoneNumber p1=new PhoneNumber(9998887776L,"airtel","office");
//		PhoneNumber p2=new PhoneNumber(9998887777L,"jio","home");
//		
//		p1.setPerson(person);
//		p2.setPerson(person);
//		
//		//link child to parent
//		person.setContactList(Set.of(p1,p2));
//       String status=service.savePerson(person);
//       System.out.println(status);
//		
//		//child save
//		
//		PhoneNumber p1=new PhoneNumber(9998883476L,"airtel","office");
//		PhoneNumber p2=new PhoneNumber(9998882377L,"jio","home");
//		
//		Person person=new Person("priya","kalleri");
//		
//		p1.setPerson(person);
//		p2.setPerson(person);
//		
//		person.setContactList(Set.of(p1,p2));
//		
//		String status=service.savePerson(person);
//		System.out.println(status);
		
		// Create a parent object
//				Person person = new Person("hyder", "RCB");
//
//				// Create a child object
//				PhoneNumber p1 = new PhoneNumber(9998887775L, "airtel", "office");
//				PhoneNumber p2 = new PhoneNumber(8889997775L, "jio", "residence");
//
//				//link parent to child
//				p1.setPerson(person);
//				p2.setPerson(person);
//
//				Set<PhoneNumber> contactDetails = Set.of(p1, p2);
//
//				//link child to parent
//				person.setContactList(contactDetails);
//
//				String status = service.savePerson(person);
//				System.out.println(status);
		
//		service.getAllPerson().forEach(person->{
//			System.out.println(person);
//			System.out.println();
//			person.getContactList().forEach(contact->{
//				System.out.println(contact);
//			});
//			
//		});
//		
//		System.out.println("************");
//		
//		service.getAllPhoneNumbers().forEach(phone->{
//			System.out.println(phone);
//			System.out.println();
//			System.out.print(phone.getPerson());
//		});
		
		//service.deleteByPerson(2);
		
		System.out.println(service.deleteAllPhoneOfPerson(4));
		
		
	}

}
