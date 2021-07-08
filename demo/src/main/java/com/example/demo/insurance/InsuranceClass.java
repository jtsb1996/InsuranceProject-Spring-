package com.example.demo.insurance;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InsuranceClass {
	@Id
	private int iID;
	private String iName;
	private String iType;
	private String iCompany;
	private int iPrice;
	private int iMaxAge;
	
	
	public InsuranceClass() {
		System.out.println("Insurance Object Created");
	}
	
	public InsuranceClass(String iName, String iType, String iCompany, int iPrice) {
		super();	
		this.iName = iName;
		this.iType = iType;
		this.iCompany = iCompany;
		this.iPrice = iPrice;
	}

	public InsuranceClass(int iID, String iName, String iType, String iCompany, int iPrice) {
		super();
		this.iID = iID;
		this.iName = iName;
		this.iType = iType;
		this.iCompany = iCompany;
		this.iPrice = iPrice;
	}
	public int getiID() {
		return iID;
	}
	public void setiID(int iID) {
		this.iID = iID;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public String getiType() {
		return iType;
	}
	public void setiType(String iType) {
		this.iType = iType;
	}
	public String getiCompany() {
		return iCompany;
	}
	public void setiCompany(String iCompany) {
		this.iCompany = iCompany;
	}

	public int getiPrice() {
		return iPrice;
	}

	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}

	public int getiMaxAge() {
		return iMaxAge;
	}

	public void setiMaxAge(int iMaxAge) {
		this.iMaxAge = iMaxAge;
	}

	@Override
	public String toString() {
		return "InsuranceClass [iID=" + iID + ", iName=" + iName + ", iType=" + iType + ", iCompany=" + iCompany
				+ ", iPrice=" + iPrice + "]";
	}
	
}
