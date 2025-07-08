package ru.chsu.is31.year2025.nikitina.view;

import ru.chsu.is31.year2025.nikitina.model.Coin;
import ru.chsu.is31.year2025.nikitina.model.coinranking.CoinsParse;
import ru.chsu.is31.year2025.nikitina.model.coinranking.Coins_Api;
import ru.chsu.is31.year2025.nikitina.model.coinranking.Request;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleUser {
    public static void main(String[] args) {
        try {
            Coins_Api client = new Coins_Api(
                    "https",
                    "api.coinranking.com",
                    "coinranking23d62881f86a7aace223cf2645dd4f2dc3f5704be7bff3f9");

            InputStream input = client.getCoins();

            if (client.getErrorMessage() != null) {
                System.out.println("Произошла ошибка: " + client.getErrorMessage());
                return;
            }

            Request request = CoinsParse.parse_coins(input);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите название монеты (например, Bitcoin): ");
            String inputName = scanner.nextLine();

            Coin foundCoin = request.findCoinByName(inputName);

            if (foundCoin != null) {
                System.out.println("Найдена монета:\n" + foundCoin);
            } else {
                System.out.println("Монета с таким названием не найдена.");
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
