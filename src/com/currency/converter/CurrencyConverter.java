package com.currency.converter;

import com.currency.api.ExchangeRateAPI;

public class CurrencyConverter {

    // Método para converter valores
    public static double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        double rate = ExchangeRateAPI.getExchangeRate(fromCurrency, toCurrency);
        return amount * rate;
    }
}
