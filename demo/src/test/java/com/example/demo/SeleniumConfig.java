package com.example.demo;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SeleniumConfig {
	private ChromeDriver driver;
	
	public SeleniumConfig() {
		Capabilities capabilities = DesiredCapabilities.chrome();
		ChromeDriverService service = new ChromeDriverService.Builder()
									.usingDriverExecutable(new File("C:\\Users\\test\\OneDrive\\Documents\\Personal Projects\\InsuranceWebsite (Spring)\\demo\\chromedriver.exe"))
									.usingAnyFreePort()
									.build();
		ChromeOptions options = new ChromeOptions();
		options.merge(capabilities);
		driver = new ChromeDriver(service,options);
		
	}

	public ChromeDriver getDriver() {
		return driver;
	}

	public void setDriver(ChromeDriver driver) {
		this.driver = driver;
	}

}	