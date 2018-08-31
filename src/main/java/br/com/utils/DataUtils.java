package br.com.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {
	public static Date obterDataComDiferencasDias(int dias) {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DAY_OF_MONTH, dias);
		return ca.getTime();
	}
	public static String obterDataFormatada(Date date) {
		DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		return format.format(date); 
	}
}
