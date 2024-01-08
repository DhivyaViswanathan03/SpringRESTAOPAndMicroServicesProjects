package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.entity.StockPrice;
import in.ineuron.exception.StockNotFoundException;
import in.ineuron.repository.IStockPriceRepository;

@Service
public class StockPriceServiceImpl implements IStockPriceService {
	
	@Autowired
	private IStockPriceRepository repo;

	@Override
	public Double findByCompanyName(String companyName) {
		StockPrice stockPrice=repo.findByCompanyName(companyName);
		if(stockPrice==null) {
			throw new StockNotFoundException("Company not available");
		}
		return stockPrice.getCompanyPrice();
	}

}
