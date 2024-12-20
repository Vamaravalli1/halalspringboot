package com.Halal.Believer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dao extends JpaRepository<Product, Long>{
	
	 Optional<Product> findByBarcode(String barcode);

}
