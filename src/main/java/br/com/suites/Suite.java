package br.com.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.com.core.DriverFactory;
import br.com.pages.LoginPage;
import br.com.testes.ContaTestes;
import br.com.testes.MovimentacaoTest;
import br.com.testes.RemoverMovimentacaoTest;
import br.com.testes.ResumoTest;
import br.com.testes.SaldoTest;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({
	ContaTestes.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoTest.class,
	SaldoTest.class,
	ResumoTest.class
})

public class Suite {
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:/eclipse/geckodriver/geckodriver.exe");
		page.acessarTelaInicial();
		page.setEmail("diogo@hotmail.com");
		page.setSenha("1234");
		
		page.entrar();
	}
	
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}
}
