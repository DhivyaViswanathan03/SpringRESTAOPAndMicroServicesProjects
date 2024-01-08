package in.ineuron.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import in.ineuron.customexception.TouristNotFoundException;
import in.ineuron.dao.ITouristRepo;
import in.ineuron.model.Tourist;

@Service
public class TouristServiceImpl implements ITouristService{
	
	@Autowired
	private ITouristRepo repo;

	@Override
	public String registerTourist(Tourist tourist) {
		Integer id=repo.save(tourist).getId();
		return "Tourist is registered with id ::"+id;
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		List<Tourist> tourists=repo.findAll();
		tourists.sort((t1,t2)->t1.getId().compareTo(t2.getId()));
		return tourists;
	}

	@Override
	public Tourist fetchTouristById(Integer id) {
		//Optional<Tourist> result = repo.findById(id);
//		if(result.isPresent()) {
//			return result.get();
//		}else {
//			throw new TouristNotFoundException("Tourist not found with give id is :"+id);
//		}
		return repo.findById(id).orElseThrow(()->{
			throw new TouristNotFoundException("Tourist not found with given id is :"+id);
		});
	}

	@Override
	public String updateTouristDetails(Tourist tourist) {
		Optional<Tourist> optional=repo.findById(tourist.getId());
		if(optional.isPresent()) {
			repo.save(tourist);
			return "Tourist updated for id:"+tourist.getId();
		}else {
			throw new TouristNotFoundException("Tourist record with given id is :"+tourist.getId()
			+"is not available");
		}
	}

	@Override
	public String updateTouristBudgetById(Integer id, Float hike) {
		Optional<Tourist> optional=repo.findById(id);
		if(optional.isPresent()) {
			Tourist tourist=optional.get();
			tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*hike/100));
			repo.save(tourist);
			return "Tourist hike updated for id:"+tourist.getId();
		}
		else {
			throw new TouristNotFoundException("Tourist record with given id is :"+id
			+"is not available for hike updation");
		}
	}

	@Override
	public String deleteTouristById(Integer id) {
		Optional<Tourist> optional=repo.findById(id);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return "Tourist record deleted for id:"+id;
		}
		else {
			throw new TouristNotFoundException("Tourist record with given id is :"+id
			+"is not available for deletion");
		}
	}

	


	

}
