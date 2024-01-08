package in.ineuron.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.ineuron.model.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {
	
	//@Query("select p.pid,p.pname,p.paddress,ph.regNo,ph.phoneNumber,ph.provider,ph.type from Person p inner join p.contactList ph")
	//@Query("select p.pid,p.pname,p.paddress,ph.regNo,ph.phoneNumber,ph.provider,ph.type from Person p left join p.contactList ph")
	@Query("select p.pid,p.pname,p.paddress,ph.regNo,ph.phoneNumber,ph.provider,ph.type from Person p right join p.contactList ph")
//	@Query("select p.pid,p.pname,p.paddress,ph.regNo,ph.phoneNumber,ph.provider,ph.type from Person p full join p.contactList ph")
	public List<Object[]> fetchDataUsingJoins();

}
