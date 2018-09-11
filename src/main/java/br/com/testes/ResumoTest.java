package br.com.testes;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.core.BaseTest;
import br.com.core.DriverFactory;
import br.com.pages.MenuPage;
import br.com.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest{
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void test1_ExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		resumoPage.excluirMovimentacao();
		
		assertEquals("Movimentação removida com sucesso!",resumoPage.obterMsgSucesso());
	}
	
	@Test
	public void test2_ResumoMensal() {
		menuPage.acessarTelaResumo();
		assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
	}
}
