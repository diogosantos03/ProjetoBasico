package br.com.testes;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.core.BaseTest;
import br.com.pages.MenuPage;
import br.com.pages.MovimentacaoPage;
import br.com.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		movPage.setDescricao("Descrição qualquer");
		movPage.setInteressado("Diogo");
		movPage.setValor("50000.00");
		movPage.setConta("Conta para movimentacoes");
		movPage.setStatusPago();
		
		movPage.clicarBotaoPorTexto("Salvar");
		
		assertEquals("Movimentação adicionada com sucesso!",movPage.obterMsgSucesso());
	}
	
	@Test
	public void test2_CamposObrigatorios() {
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
	

	@Test
	public void test3_InserirMovimentaoFutura(){
		menuPage.acessarTelaInserirMovimentacao();
		
		Date datafutura = DataUtils.obterDataComDiferencasDias(5);
		
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(datafutura));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(datafutura));
		movPage.setDescricao("Descrição qualquer");
		movPage.setInteressado("Diogo");
		movPage.setValor("50000.00");
		movPage.setConta("Conta para movimentacoes");
		movPage.setStatusPago();
		
		movPage.clicarBotaoPorTexto("Salvar");
		List<String> erros = movPage.obterErros();
		//assertTrue(erros.contains("Data da MovimentaÃ§Ã£o deve ser menor ou igual Ã  data atual"));
		System.out.println(erros.toString());
		assertEquals(1,erros.size());
	}
	

}
