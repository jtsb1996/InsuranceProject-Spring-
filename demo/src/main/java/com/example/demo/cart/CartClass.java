package com.example.demo.cart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// to be improved
public class CartClass{
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sID;
	private int uID;
	private String iName;
	private String iType;
	private String iCompany;
	private int iPrice;
	private String iPaid;
	
	public CartClass() {
		super();
	}

	public CartClass(int uID,String iName, String iType, String iCompany, int iPrice, String iPaid) {
		super();
		this.uID = uID;
		this.iName = iName;
		this.iType = iType;
		this.iCompany = iCompany;
		this.iPrice = iPrice;
		this.iPaid = iPaid;
	}

	public CartClass(int sID, int uID, String iName, String iType, String iCompany, int iPrice, String iPaid) {
		super();
		this.sID = sID;
		this.uID = uID;
		this.iName = iName;
		this.iType = iType;
		this.iCompany = iCompany;
		this.iPrice = iPrice;
		this.iPaid = iPaid;
	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
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

	public String getiPaid() {
		return iPaid;
	}

	public void setiPaid(String iPaid) {
		this.iPaid = iPaid;
	}

	
	
}
