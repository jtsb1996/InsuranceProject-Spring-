package com.example.demo.insurance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {
	
	private final InsuranceRepo insuranceRepo;
	
	@Autowired
	public InsuranceService(InsuranceRepo insuranceRepo) {
		this.insuranceRepo = insuranceRepo;
	}
	
	public InsuranceClass getInsuranceById(int id) {
		return insuranceRepo.getById(id);
	}
	
	public List<InsuranceClass> getInsuranceByType(String type) {
		return insuranceRepo.getInsuranceByType(type);
	}
	
	public List<InsuranceClass> getInsuranceByCompany(String company) {
		return insuranceRepo.getInsuranceByCompany(company);
	}
	
	public List<InsuranceClass> getInsuranceBy(String type, String company, int age) {
		return insuranceRepo.getInsuranceBy(type, company, age);
	}
	
	public List<InsuranceClass>getInsurance() {
		return insuranceRepo.findAll();
	}
	
	public List<InsuranceClass>getInsuranceByAll(String type, String company, String age, List<Integer> list) {
		List<InsuranceClass> templist = new ArrayList<>();
		List<InsuranceClass> insurancelist = new ArrayList<>();
		if (type.equals("") && company.equals("")) {
			templist = insuranceRepo.findAll();
		}
		else if (company.equals("")){
			templist = insuranceRepo.getInsuranceByType(type);
		}
			
		else if (type.equals("")){
			templist = insuranceRepo.getInsuranceByCompany(company);
		}
		
		else {
			System.out.println(age);
			templist = insuranceRepo.getInsuranceBy(type, company, Integer.parseInt(age));
		}
		if (list.size() > 0) {
			for (int i = 0; i < templist.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					if (templist.get(i).getiID() == list.get(j))
						insurancelist.add(templist.get(i));
				}
			}
		}
		else {
			for (int i = 0; i < templist.size(); i++) {
				insurancelist.add(templist.get(i));
			}
		}
		
		
		return insurancelist;
	}
	
	public List<String> getUniqueType() {
		List<String> currentList = insuranceRepo.getUniqueType();
		for (int i = 0; i < currentList.size(); i++) {
			String temp = currentList.get(i);
			Character.toUpperCase(temp.charAt(0));
		}
		
		return currentList;
	}
	
	public List<String> getUniqueCompany() {
		return insuranceRepo.getUniqueCompany();
	}

}
