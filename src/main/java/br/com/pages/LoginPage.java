package br.com.pages;

import br.com.core.BasePage;
import br.com.core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
<<<<<<< HEAD
		DriverFactory.getDriver().get("http://seubarriga.wcaquino.me/login");
=======
		DriverFactory.getDriver().get("https://srbarriga.herokuapp.com");
>>>>>>> ba7ff3ca4acad6832b0edaf6c8b6d86175ad1c72
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
