package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Tourist;

public interface ITouristService {
	public String registerTourist(Tourist tourist);
	
	public List<Tourist> fetchAllTourist();
	
	public Tourist fetchTouristById(Integer id);
	
	public String updateTouristDetails(Tourist tourist);
	
	public String updateTouristBudgetById(Integer id,Float hike);
	
	public String deleteTouristById(Integer id);

}
