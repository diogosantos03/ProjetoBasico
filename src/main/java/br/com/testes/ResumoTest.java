package br.com.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.MenuPage;
import br.com.pages.ResumoPage;

public class ResumoTest extends BaseTest{
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void testExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		resumoPage.excluirMovimentacao();
		
		assertEquals("Movimentação removida com sucesso!",resumoPage.obterMsgSucesso());
	}
}
