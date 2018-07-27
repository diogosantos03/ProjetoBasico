package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class ContasPage extends BasePage {
	public void setNome(String nome) {
		escrever("nome", nome);
	}
	public void salvar() {
		clicar(By.xpath("//button[.='Salvar']"));
	}
	public String obterMsgSucesso() {
		return getTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
}
