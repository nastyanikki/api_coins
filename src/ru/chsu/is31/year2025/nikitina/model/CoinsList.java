package ru.chsu.is31.year2025.nikitina.model;

import java.util.ArrayList;
import java.util.List;

public class CoinsList {

    private static List<Coin> crip_coins = new ArrayList<>();

    public static List<Coin> getCrip_coins() {
        return crip_coins;
    }

    public static Coin findByName(String name) {
        if (name == null || crip_coins == null) return null;
        String trimmedName = name.trim().toLowerCase();

        for (Coin coin : crip_coins) {
            if (coin.getName() != null && coin.getName().trim().toLowerCase().equals(trimmedName)) {
                return coin;
            }
        }

        return null;
    }

    public static Coin findBySymbol(String symbol) {
        if (symbol == null || crip_coins == null) return null;
        String trimmedSymbol = symbol.trim().toLowerCase();

        for (Coin coin : crip_coins) {
            if (coin.getSymbol() != null && coin.getSymbol().trim().toLowerCase().equals(trimmedSymbol)) {
                return coin;
            }
        }

        return null;
    }
}
