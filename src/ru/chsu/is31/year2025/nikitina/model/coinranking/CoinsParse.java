package ru.chsu.is31.year2025.nikitina.model.coinranking;

import ru.chsu.is31.year2025.nikitina.model.Coin;
import javax.json.*;
import java.io.InputStream;
import java.text.ParseException;
import java.util.stream.Collectors;

public class CoinsParse {

    public static Request parse_coins(InputStream rawJson) throws ParseException {
        JsonReader jsread = Json.createReader(rawJson);
        JsonObject jsobj = jsread.readObject();
        jsread.close();

        if (jsobj.containsKey("message")) {
            throw new ParseException(jsobj.getString("message"), 0);
        }

        String status = jsobj.getString("status");

        JsonObject statsJson = jsobj.getJsonObject("data").getJsonObject("stats");

        Stats st = new Stats(
                statsJson.getInt("total", 0),
                statsJson.getInt("totalCoins", 0),
                statsJson.getInt("totalMarkets", 0),
                statsJson.getInt("totalExchanges", 0),
                getSafeJsonString(statsJson, "totalMarketCap"),
                getSafeJsonString(statsJson, "total24hVolume")
        );

        JsonArray coinsArray = jsobj.getJsonObject("data").getJsonArray("coins");

        for (JsonValue value : coinsArray) {
            JsonObject coinObj = value.asJsonObject();

            Coin crc = new Coin(
                    coinObj.getString("uuid", ""),
                    coinObj.getString("symbol", ""),
                    coinObj.getString("name", ""),
                    coinObj.getString("color", ""),
                    coinObj.getString("iconUrl", ""),
                    getSafeJsonNumber(coinObj, "24hVolume"),
                    getSafeJsonNumber(coinObj, "marketCap"),
                    getSafeJsonNumber(coinObj, "price"),
                    getSafeJsonNumber(coinObj, "btcPrice"),
                    coinObj.getInt("listedAt", 0),
                    coinObj.getString("change", "0"),
                    coinObj.getInt("rank", 0),
                    coinObj.getJsonArray("sparkline").stream()
                            .map(JsonValue::toString)
                            .collect(Collectors.toList()),
                    coinObj.getString("coinrankingUrl", ""),
                    coinObj.getBoolean("isWrappedTrustless", false),
                    coinObj.isNull("wrappedTo") ? null : coinObj.getString("wrappedTo", null)
            );

            ListCoins.getCrip_coins().add(crc);
        }

        return new Request(status, st,ListCoins.getCrip_coins() );
    }

    private static String getSafeJsonNumber(JsonObject obj, String key) {
        if (obj.containsKey(key) && !obj.isNull(key) && obj.get(key).getValueType() == JsonValue.ValueType.NUMBER) {
            return obj.getJsonNumber(key).toString();
        }
        return null;
    }

    private static String getSafeJsonString(JsonObject obj, String key) {
        if (obj.containsKey(key) && !obj.isNull(key) && obj.get(key).getValueType() == JsonValue.ValueType.STRING) {
            return obj.getString(key);
        }
        return null;
    }
}
