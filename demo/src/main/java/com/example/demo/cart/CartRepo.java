package com.example.demo.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<CartClass, Integer> {
	
	@Query(value = "Select * from cart_class cc where cc.uid = ?1 AND cc.i_paid is null", nativeQuery = true)
	List<CartClass> findByUserId(int id);
	
}
