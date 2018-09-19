package br.com.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
//	private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	public DriverFactory() {
		
	}
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	public static WebDriver initDriver() {
		WebDriver driver = null;
		switch (Propriedades.browsers) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			driver = new ChromeDriver();
			break;
			
			//driver.manage().window().setPosition(new Point(100, 100));
			//driver.manage().window().setSize(new Dimension(700, 700));
		}
		return driver;
	}
	public static void killDriver() {
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}
}
