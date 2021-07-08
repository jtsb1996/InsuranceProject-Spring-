package com.example.demo.insurance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InsuranceRepo extends JpaRepository<InsuranceClass,Integer>{

	@Query(value="Select distinct i_type from insurance_class" , nativeQuery = true)
	public List<String> getUniqueType();
	
	@Query(value = "Select distinct i_company from insurance_class", nativeQuery = true)
	public List<String> getUniqueCompany();
	
	@Query(value = "Select * from insurance_class uu where uu.i_type = ?1 AND uu.i_company = ?2 AND uu.i_max_age < ?3", nativeQuery = true)
	public List<InsuranceClass> getInsuranceBy(String type, String company, int age);
	
	@Query(value = "Select * from insurance_class uu where uu.i_type = ?1", nativeQuery = true)
	public List<InsuranceClass> getInsuranceByType(String type);
	
	@Query(value = "Select * from insurance_class uu where uu.i_company = ?1", nativeQuery = true)
	public List<InsuranceClass> getInsuranceByCompany(String company);
	
	
}
