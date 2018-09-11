package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class ContasPage extends BasePage {
	public void setNome(String nome) {
		escrever("nome", nome);
	}
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	public String obterMsgSucesso() {
		return getTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	public void alterarConta(String string) {
		 obterCelula("Conta", string, "Ações", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
		
	}
	public String obterMsgErro() {
		return getTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public void clicarExcluirConta(String string) {
		 obterCelula("Conta", string, "Ações", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
	
}
