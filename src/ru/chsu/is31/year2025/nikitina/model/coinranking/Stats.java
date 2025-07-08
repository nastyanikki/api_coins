package ru.chsu.is31.year2025.nikitina.model.coinranking;

public class Stats {
    private Integer total;
    private Integer totalCoins;
    private Integer totalMarkets;
    private Integer totalExchanges;
    private  String totalMarketCap;
    private String total24hVolume;

    public Stats(Integer total, Integer totalCoins, Integer totalMarkets, Integer totalExchanges, String totalMarketCap, String total24hVolume) {
        this.total = total;
        this.totalCoins = totalCoins;
        this.totalMarkets = totalMarkets;
        this.totalExchanges = totalExchanges;
        this.totalMarketCap = totalMarketCap;
        this.total24hVolume = total24hVolume;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotalCoins() {
        return totalCoins;
    }

    public Integer getTotalMarkets() {
        return totalMarkets;
    }

    public Integer getTotalExchanges() {
        return totalExchanges;
    }

    public String getTotalMarketCap() {
        return totalMarketCap;
    }

    public String getTotal24hVolume() {
        return total24hVolume;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "total=" + total +
                ", totalCoins=" + totalCoins +
                ", totalMarkets=" + totalMarkets +
                ", totalExchanges=" + totalExchanges +
                ", totalMarketCap='" + totalMarketCap + '\'' +
                ", total24hVolume='" + total24hVolume + '\'' +
                '}';
    }
}
