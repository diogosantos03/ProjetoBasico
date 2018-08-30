package br.com.testes;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.MenuPage;
import br.com.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void testInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao("01/09/2017");
		movPage.setDataPagamento("02/09/2017");
		movPage.setDescricao("Descrição qualquer");
		movPage.setInteressado("Diogo");
		movPage.setValor("50000");
		movPage.setConta("Conta1");
		movPage.setStatusPago();
		
		movPage.clicarBotaoPorTexto("Salvar");
		
		assertEquals("Movimentação adicionada com sucesso!",movPage.obterMsgSucesso());
	}
	
	@Test
	public void testCamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.clicarBotaoPorTexto("Salvar");
		List<String> erros = movPage.obterErros();
		
		assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número"
				)));
		assertEquals(6,erros.size());
	}
	
<<<<<<< HEAD
	@Test
	public void testInserirMovimentaoFutura(){
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao("01/09/2017");
		movPage.setDataPagamento("01/09/2017");
		movPage.setDescricao("Descrição qualquer");
		movPage.setInteressado("Diogo");
		movPage.setValor("50000");
		movPage.setConta("Conta1");
		movPage.setStatusPago();
		
		movPage.clicarBotaoPorTexto("Salvar");
		List<String> erros = movPage.obterErros();
		//assertTrue(erros.contains("Movimentação adicionada com sucesso!"));
		System.out.println(erros.toString());
		assertEquals(1,erros.size());
	}
	
=======
>>>>>>> ba7ff3ca4acad6832b0edaf6c8b6d86175ad1c72
}
