package br.com.pages;

import br.com.core.BasePage;
import br.com.core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("http://seubarriga.wcaquino.me/login");
	}
	public void setEmail(String email) {
		escrever("email", email);
	}
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	public void entrar() {
		clicarBotaoPorTexto("Entrar");
	}
}
