package br.com.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.core.Propriedades.TipoExecucao;

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
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			switch (Propriedades.BROWSERS) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				driver = new ChromeDriver();
				break;
				
				//driver.manage().window().setPosition(new Point(100, 100));
				//driver.manage().window().setSize(new Dimension(700, 700));
			}
		}
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			DesiredCapabilities cap = null;
			switch (Propriedades.BROWSERS) {
			case FIREFOX:
				cap = DesiredCapabilities.firefox();
				break;
			case CHROME:
				cap = DesiredCapabilities.chrome();
				break;
			}
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.out.println("Falha na conexão com grid!");
				e.printStackTrace();
			}
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
