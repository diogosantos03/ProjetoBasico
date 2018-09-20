package br.com.suites;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

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
	@Before
	public static void reset() {
		page.acessarTelaInicial();
		
		page.setEmail("diogo@hotmail.com");
		
		page .setSenha("1234");
		
		page.entrar();
		
		page.resetar(); 
	}
}
