package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class ResumoPage extends BasePage{

	public void excluirMovimentacao() {
		clicar(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
		//Movimentação removida com sucesso!
		
	}
	
	public String obterMsgSucesso() {
		return getTexto(By.xpath("//div[@class='alert alert-success']"));
	}
}
