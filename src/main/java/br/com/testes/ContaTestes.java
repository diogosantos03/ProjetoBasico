package br.com.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.ContasPage;
import br.com.pages.MenuPage;

public class ContaTestes extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testInserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta 12");
		contasPage.salvar();
		
		assertEquals("Conta adicionada com sucesso!", contasPage.obterMsgSucesso());
	}
	
	@Test
	public void testAlterarConta() {
		menuPage.acessarTelaListarConta();
		contasPage.alterarConta("Conta1");
		contasPage.setNome("Conta1 alterada");
		contasPage.salvar();
		assertEquals("Conta alterada com sucesso!", contasPage.obterMsgSucesso());
	}
	@Test
	public void testInserirContaComMesmoNome() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta1");
		contasPage.salvar();
		assertEquals("Já existe uma conta com esse nome!",contasPage.obterMsgErro());
	}

}
