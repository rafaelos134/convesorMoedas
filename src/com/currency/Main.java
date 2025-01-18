package com.currency;
import com.currency.converter.CurrencyConverter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite a moeda de origem (por exemplo, USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();


        System.out.print("Digite a moeda de destino (por exemplo, BRL): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Digite o valor a ser convertido: ");
        double amount = scanner.nextDouble();

        try {
            double convertedAmount = CurrencyConverter.convertCurrency(fromCurrency, toCurrency, amount);
            System.out.printf("O valor de %.2f %s em %s é: %.2f%n", amount, fromCurrency, toCurrency, convertedAmount);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
