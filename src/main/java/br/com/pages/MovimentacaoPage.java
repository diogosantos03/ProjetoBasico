package br.com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.core.BasePage;
import br.com.core.DriverFactory;

public class MovimentacaoPage extends BasePage{
	
	public void setDataMovimentacao(String data) {
		escrever("data_transacao", data);
	}
	
	public void setDataPagamento(String data) {
		escrever("data_pagamento", data);
	}
	
	public void setDescricao(String des) {
		escrever("descricao", des);
	}
	
	public void setInteressado(String nome) {
		escrever("interessado", nome);
	}
	
	public void setValor(String valor) {
		escrever("valor", valor);
	}
	
	public void setConta(String conta) {
		selecionarCombo("conta", conta);
	}
	public void setStatusPago() {
		clicar("conta");
	}
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMsgSucesso() {
		return getTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public List<String> obterErros(){
		//List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@class='alert alert-success']"));
		List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> itensRetorno = new ArrayList<String>();
		for(WebElement e: erros) {
			itensRetorno.add(e.getText());
		}
		return itensRetorno;
	}

}
