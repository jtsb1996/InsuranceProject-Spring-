package com.example.demo.condition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConditionService {
	
	private final ConditionRepo conditionRepo;
	
	@Autowired
	public ConditionService(ConditionRepo conditionRepo) {
		this.conditionRepo = conditionRepo;
	}
	
	public List<String> getUniqueConditionName() {
		return conditionRepo.getUniqueConditionName();
	}
	
	public List<Integer> checkCondition(String conditionName) {
		List <Integer> validList = new ArrayList<>();
		if (conditionName==null) {
			validList = conditionRepo.getUniqueInsuranceId();
			return validList;
		}
				
		validList = conditionRepo.checkHealthCondition(conditionName);
		return validList;
		
		
	}

}
