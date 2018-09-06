package br.com.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.pages.LoginPage;

public class BaseTest {
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		
		page.acessarTelaInicial();
		page.setEmail("diogo.santosgts@hotmail.com");
		page.setSenha("1234");
		
		page.entrar();
	}
	
	@After
	public void finaliza() throws IOException {
		
		TakesScreenshot takeScreenShot = (TakesScreenshot) DriverFactory.getDriver();
		File arq = takeScreenShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arq, new File("/home/diogo/eclipse-workspace/Testes-Selenium-Webdriver/target/screenshots/"+testName.getMethodName()+".png"));
		if(Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver();
		}
		
	}
}
