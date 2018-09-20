package br.com.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.ContasPage;
import br.com.pages.MenuPage;

public class RemoverMovimentacaoTest extends BaseTest{
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	@Test
	public void excluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta("Conta com movimentacao");
		assertEquals("Conta em uso na movimentações",contasPage.obterMsgErro());
	}
}
