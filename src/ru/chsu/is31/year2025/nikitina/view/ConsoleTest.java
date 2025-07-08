package ru.chsu.is31.year2025.nikitina.view;

import ru.chsu.is31.year2025.nikitina.model.coinranking.Request;
import ru.chsu.is31.year2025.nikitina.model.coinranking.CoinsParse;
import ru.chsu.is31.year2025.nikitina.model.coinranking.Coins_Api;

public class ConsoleTest {
    public static void main(String[] args) {
        try {

            Coins_Api client = new Coins_Api(
                    "https",
                    "api.coinranking.com",
                    "coinranking23d62881f86a7aace223cf2645dd4f2dc3f5704be7bff3f9");

            Request coin1 = CoinsParse.parse_coins(client.getCoins());

            System.out.println(coin1.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}