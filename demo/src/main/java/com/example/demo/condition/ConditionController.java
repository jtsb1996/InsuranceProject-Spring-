package com.example.demo.condition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ConditionController {
	
	private final ConditionService conditionService;
	
	@Autowired
	public ConditionController(ConditionService conditionService) {
		this.conditionService = conditionService;
	}
	
	public List<String> getUniqueConditionName() {
		return conditionService.getUniqueConditionName();
	}
	
	public List<Integer> checkCondition(String conditionName) {
		List<Integer> list = new ArrayList<>();
		list = conditionService.checkCondition(conditionName);
		
		return list;
	} 

}
