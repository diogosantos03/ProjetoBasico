package br.com.testes;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.core.BaseTest;
import br.com.pages.HomePage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaldoTest extends BaseTest {
	HomePage home = new HomePage();
	
	@Test
	public void test1_VerificarSaldo() {
		assertEquals("534.00", home.getSaldoConta("Conta para saldo"));
			
	}
	
}
