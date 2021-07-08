package com.example.demo.condition;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConditionClass {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cID;
	private int iID;
	private String conditionName;
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public int getiID() {
		return iID;
	}
	public void setiID(int iID) {
		this.iID = iID;
	}
	public String getConditionName() {
		return conditionName;
	}
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
	
	public ConditionClass() {
		super();
	}
	public ConditionClass(int iID, String conditionName, String condition) {
		super();
		this.iID = iID;
		this.conditionName = conditionName;
	}
	public ConditionClass(int cID, int iID, String conditionName, String condition) {
		super();
		this.cID = cID;
		this.iID = iID;
		this.conditionName = conditionName;
	}
	
}
