package br.com.core;

public class Propriedades {
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers browsers = Browsers.FIREFOX;
	
	public static String NOME_CONTA_ALTERADA = "Conta Alterada "+ System.nanoTime();
	
	public enum Browsers{
		CHROME,
		FIREFOX,
	}
}
