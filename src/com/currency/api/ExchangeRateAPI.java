package com.currency.api;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateAPI {

    public static double getExchangeRate(String fromCurrency, String toCurrency) {

        String apiKey = System.getenv(EXCHANGE_API_KEY);
        String apiUrl = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/" + fromCurrency.replace(" ", "+");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);

            return apiResponse.getConversionRates().get(toCurrency);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a taxa de câmbio.");
        }

    }
}