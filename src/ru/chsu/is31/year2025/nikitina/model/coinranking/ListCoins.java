package ru.chsu.is31.year2025.nikitina.model.coinranking;

import ru.chsu.is31.year2025.nikitina.model.Coin;

import java.util.ArrayList;
import java.util.List;

public class ListCoins {

    private static List<Coin> crip_coins = new ArrayList<>();

    public static List<Coin> getCrip_coins() {
        return crip_coins;
    }
}
