package ru.chsu.is31.year2025.nikitina.model.coinranking;

import ru.chsu.is31.year2025.nikitina.model.Coin;
import java.util.List;

public class Request {

    private String status;
    private Stats stats;
    private List<Coin> crip_coins;

    public Request(String status, Stats stats, List<Coin> crip_coins) {
        this.status = status;
        this.stats = stats;
        this.crip_coins = crip_coins;
    }

    public List<Coin> getCoins() {
        return crip_coins;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "status='" + status + '\'' +
                ", stats=" + stats.toString() +
                ", coin=" + crip_coins.toString() +
                '}';
    }
}
