package src.main.java.com.example.demo.repositiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import src.main.java.com.example.demo.model.PriceGridmodal;



public interface PriceGridRepository extends JpaRepository<PriceGridmodal, Long> {
    List<PriceGridmodal> findByHeightTo(int heightTo);
}
