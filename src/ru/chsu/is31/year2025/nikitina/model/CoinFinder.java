package ru.chsu.is31.year2025.nikitina.model;

import java.util.List;
import java.util.stream.Collectors;

public class CoinFinder {

    public static Coin findByName(List<Coin> coins, String name) {
        if (name == null || coins == null) return null;
        String trimmedName = name.trim().toLowerCase();

        for (Coin coin : coins) {
            if (coin.getName() != null && coin.getName().trim().toLowerCase().equals(trimmedName)) {
                return coin;
            }
        }

        return null;
    }

    public static Coin findBySymbol(List<Coin> coins, String symbol) {
        if (symbol == null || coins == null) return null;
        String trimmedSymbol = symbol.trim().toLowerCase();

        for (Coin coin : coins) {
            if (coin.getSymbol() != null && coin.getSymbol().trim().toLowerCase().equals(trimmedSymbol)) {
                return coin;
            }
        }

        return null;
    }

}
