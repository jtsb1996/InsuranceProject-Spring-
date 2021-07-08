package com.example.demo.insurance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.condition.ConditionController;

@Controller
public class InsuranceController {
	private final InsuranceService insuranceService;
	
	@Autowired
	ConditionController conditionController;
	
	@Autowired
	public InsuranceController(InsuranceService insuranceService) {
		this.insuranceService = insuranceService;
	}

	public List<InsuranceClass> getInsurance(){
		return insuranceService.getInsurance();
	}
	
	public List<InsuranceClass> getInsuranceByType(String type) {
		return insuranceService.getInsuranceByType(type);
	}
	
	public List<InsuranceClass> getInsuranceByCompany(String company) {
		return insuranceService.getInsuranceByCompany(company);
	}
	
	public List<InsuranceClass> getInsuranceBy(String type, String company, int age) {
		return insuranceService.getInsuranceBy(type, company, age);
	}
	
	public List<InsuranceClass> getInsuranceByAll(String type, String company, String age, String conditionName) {
		List<Integer> insuranceIdList = new ArrayList<>();
		if (conditionName != null) {
			insuranceIdList = conditionController.checkCondition(conditionName);
		}
		return insuranceService.getInsuranceByAll(type, company, age, insuranceIdList);
	}
	
	public InsuranceClass getInsuranceById(int id) {
		return insuranceService.getInsuranceById(id);
	}

	public List<String> getUniqueType() {
		return insuranceService.getUniqueType();
	}
	
	public List<String> getUniqueCompany() {
		return insuranceService.getUniqueCompany();
	}
}
