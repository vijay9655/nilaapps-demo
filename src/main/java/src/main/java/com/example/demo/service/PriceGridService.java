package src.main.java.com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import src.main.java.com.example.demo.model.PriceGridmodal;
import src.main.java.com.example.demo.repositiry.PriceGridRepository;


@Service
public class PriceGridService {
	 private final PriceGridRepository repository;

	    public PriceGridService(PriceGridRepository repository) {
	        this.repository = repository;
	    }

	    public List<PriceGridmodal> getAllPrices() {
	        return repository.findAll();
	    }

	    public List<PriceGridmodal> getPricesByHeight(int heightTo) {
	        return repository.findByHeightTo(heightTo);
	    }

	    public PriceGridmodal addPrice(PriceGridmodal priceGrid) {
	        return repository.save(priceGrid);
	    }
}
