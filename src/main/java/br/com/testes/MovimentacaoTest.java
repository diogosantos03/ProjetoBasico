package br.com.testes;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.MenuPage;
import br.com.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movimentaPage = new MovimentacaoPage();
	
	@Test
	public void testInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movimentaPage.setDataMovimentacao("01/09/2017");
		movimentaPage.setDataPagamento("02/09/2017");
		movimentaPage.setDescricao("Descrição qualquer");
		movimentaPage.setInteressado("Diogo");
		movimentaPage.setValor("50000");
		movimentaPage.setConta("Conta1");
		movimentaPage.setStatusPago();
		
		movimentaPage.clicarBotaoPorTexto("Salvar");
		
		assertEquals("Movimentação adicionada com sucesso!",movimentaPage.obterMsgSucesso());
	}
	
}
