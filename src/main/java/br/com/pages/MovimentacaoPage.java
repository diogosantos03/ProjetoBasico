package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;

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

}
