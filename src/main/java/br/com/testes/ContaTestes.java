package br.com.testes;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.core.BaseTest;
import br.com.pages.ContasPage;
import br.com.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTestes extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void test1_InserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta1");
		contasPage.salvar();
		
		assertEquals("Conta adicionada com sucesso!", contasPage.obterMsgSucesso());
	}
	
	@Test
	public void test2_AlterarConta() {
		menuPage.acessarTelaListarConta();
		contasPage.alterarConta("Conta para alterar");
		contasPage.setNome("Conta alterada");
		contasPage.salvar();
		assertEquals("Conta alterada com sucesso!", contasPage.obterMsgSucesso());
	}
	@Test
	public void test3_InserirContaComMesmoNome() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta mesmo nome");
		contasPage.salvar();
		assertEquals("Já existe uma conta com esse nome!",contasPage.obterMsgErro());
	}
	

}
