package br.com.pages;

import br.com.core.BasePage;

public class HomePage extends BasePage{
	
	public String getSaldoConta(String nome) {
		return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
	}
	
}
