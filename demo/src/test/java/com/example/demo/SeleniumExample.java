package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

public class SeleniumExample {
	@Autowired
	private SeleniumConfig config;
	private String url = "http://localhost:8080";
	
	public SeleniumExample() {
		config = new SeleniumConfig();
		config.getDriver().get(url);
	}
	
	public void closeWindow() throws InterruptedException {
		Thread.sleep(5000);
		this.config.getDriver().close();
		this.config.getDriver().quit();
	}
	
	public String getTitle() {
		return this.config.getDriver().getTitle();
	}
	
	public void getLogin() {
		url = "http://localhost:8080/displayLogin";
		this.config.getDriver().get(url);
	}
	
	public void getRegistration() {
		url = "http://localhost:8080/displayRegister";
		this.config.getDriver().get(url);
	}
	
	public void sendCredentials(String username, String password) throws InterruptedException {
		WebElement weUserName = this.config.getDriver().findElement(By.name("userName"));
		weUserName.sendKeys(username);
		WebElement wePassWord = this.config.getDriver().findElement(By.name("passWord"));
		wePassWord.sendKeys(password);
		this.config.getDriver().findElement(By.name("verifyLogin")).click();
	}
	
	public void sendCredentials(String testname, String testage, String username, String password, String answer) {
		this.config.getDriver().findElement(By.name("firstName")).sendKeys(testname);
		this.config.getDriver().findElement(By.name("age")).sendKeys(testage);
		this.config.getDriver().findElement(By.name("userName")).sendKeys(username);
		this.config.getDriver().findElement(By.name("passWord")).sendKeys(password);
		Select weSelect = new Select(this.config.getDriver().findElement(By.name("securityQ")));
		weSelect.selectByValue("dob");
		this.config.getDriver().findElement(By.name("securityA")).sendKeys(answer);
		
		
		this.config.getDriver().findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[7]/td[2]/div/button")).click();
				
	}

}
