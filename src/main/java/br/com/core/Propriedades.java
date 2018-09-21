package br.com.core;

public class Propriedades {
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers BROWSERS = Browsers.FIREFOX;
	
	public static String NOME_CONTA_ALTERADA = "Conta Alterada "+ System.nanoTime();
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.GRID;
	
	public enum Browsers{
		CHROME,
		FIREFOX,
	}
	
	public enum TipoExecucao{
		LOCAL,
		GRID
	}
}
