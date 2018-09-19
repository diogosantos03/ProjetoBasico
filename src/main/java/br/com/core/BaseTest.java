package br.com.core;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import br.com.pages.LoginPage;



public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	private LoginPage page = new LoginPage();
	
	@Before
	public void inicializa() {
		//System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		System.setProperty("webdriver.gecko.driver", "C:/eclipse/geckodriver/geckodriver.exe");
		
		page.acessarTelaInicial();
		page.setEmail("diogo@hotmail.com");
		page.setSenha("1234");
		
		page.entrar();
	}
	
	
	@After
	public void finaliza() throws IOException {
		
		//TakesScreenshot takeScreenShot = (TakesScreenshot) DriverFactory.getDriver();
		//File arq = takeScreenShot.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(arq, new File("/home/diogo/eclipse-workspace/Testes-Selenium-Webdriver/target/screenshots/"+testName.getMethodName()+".png"));
		if(Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver();
		}
		
	}
}
