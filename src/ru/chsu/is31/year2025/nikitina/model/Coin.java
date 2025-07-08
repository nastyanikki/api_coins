package ru.chsu.is31.year2025.nikitina.model;

import java.util.List;

public class Coin {
    private String uuid;
    private String symbol;
    private String name;
    private String color;
    private String iconUrl;
    private String Volume24h;
    private String marketCap;
    private String price;
    private String btcPrice;
    private Integer listedAt;
    private String change;
    private Integer rank;
    private List<String> sparkline;
    private String coinrankingUrl;
    private Boolean isWrappedTrustless;
    private String wrappedTo;

    public Coin(String uuid, String symbol, String name, String color, String iconUrl, String volume24h, String marketCap, String price, String btcPrice, Integer listedAt, String change, Integer rank, List<String> sparkline, String coinrankingUrl, Boolean isWrappedTrustless, String wrappedTo) {
        this.uuid = uuid;
        this.symbol = symbol;
        this.name = name;
        this.color = color;
        this.iconUrl = iconUrl;
        Volume24h = volume24h;
        this.marketCap = marketCap;
        this.price = price;
        this.btcPrice = btcPrice;
        this.listedAt = listedAt;
        this.change = change;
        this.rank = rank;
        this.sparkline = sparkline;
        this.coinrankingUrl = coinrankingUrl;
        this.isWrappedTrustless = isWrappedTrustless;
        this.wrappedTo = wrappedTo;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getVolume24h() {
        return Volume24h;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public String getPrice() {
        return price;
    }

    public String getBtcPrice() {
        return btcPrice;
    }

    public Integer getListedAt() {
        return listedAt;
    }

    public String getChange() {
        return change;
    }

    public Integer getRank() {
        return rank;
    }

    public List<String> getSparkline() {
        return sparkline;
    }

    public String getCoinrankingUrl() {
        return coinrankingUrl;
    }

    public Boolean getWrappedTrustless() {
        return isWrappedTrustless;
    }

    public String getWrappedTo() {
        return wrappedTo;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "uuid='" + uuid + '\'' +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", Volume24h='" + Volume24h + '\'' +
                ", marketCap='" + marketCap + '\'' +
                ", price='" + price + '\'' +
                ", btcPrice='" + btcPrice + '\'' +
                ", listedAt=" + listedAt +
                ", change='" + change + '\'' +
                ", rank=" + rank +
                ", sparkline=" + sparkline +
                ", coinrankingUrl='" + coinrankingUrl + '\'' +
                ", isWrappedTrustless=" + isWrappedTrustless +
                ", wrappedTo='" + wrappedTo + '\'' +
                '}';
    }
}

