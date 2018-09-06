package br.com.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.HomePage;

public class SaldoTest extends BaseTest {
	HomePage home = new HomePage();
	
	@Test
	public void testVerificarSaldo() {
		assertEquals("800.00", home.getSaldoConta("Conta2"));
			
	}
	
}
