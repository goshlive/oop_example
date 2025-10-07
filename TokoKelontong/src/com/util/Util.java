package com.util;
import java.text.NumberFormat;
import java.util.Locale;

public class Util {
	public static String formatCurr(double amount) {
		Locale idLocale = Locale.of("id", "ID");
        NumberFormat idCurrencyFormatter = NumberFormat.getCurrencyInstance(idLocale);
        String idFormattedAmount = idCurrencyFormatter.format(amount);
        
        return idFormattedAmount;
	}
}
