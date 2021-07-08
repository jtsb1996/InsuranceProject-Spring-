package com.example.demo.condition;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConditionRepo extends JpaRepository<ConditionClass, Integer>{

	@Query(value = "Select distinct condition_name from condition_class", nativeQuery = true)
	public List<String> getUniqueConditionName();
	
	@Query(value = "Select distinct iid from condition_class", nativeQuery = true)
	public List<Integer> getUniqueInsuranceId();
	
	@Query(value = "Select * from condition_class cc where cc.condition_name = ?1", nativeQuery = true)
	public List<ConditionClass> checkCondition(String conditionName);
	
	@Query(value = "Select distinct iid from condition_class cc where cc.condition_name = ?1", nativeQuery = true)
	public List<Integer> checkHealthCondition(String conditionName);
	
	@Query(value = "Select * from condition_class cc where cc.condition_name = ?1 and cc.condition > ?2", nativeQuery = true)
	public List<ConditionClass> checkCondition(String conditionName, int minAge);
}
