package ru.chsu.is31.year2025.nikitina.model.coinranking;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class Coins_Api {

    private final String protocol, server;
    private final String apiKey;

    private String errorMessage;

    public Coins_Api(String protocol, String server, String apiKey) {
        this.protocol = protocol;
        this.server = server;
        this.apiKey = apiKey;
    }

    public InputStream getCoins() {
        errorMessage = null;

        try {
            URI uri = new URI(protocol, server, "/v2/coins", null, null);
            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("x-access-token", apiKey);
            conn.setRequestProperty("Accept", "application/json");
            conn.connect();

            int code = conn.getResponseCode();
            if (code >= 200 && code <= 300) {
                return conn.getInputStream();
            } else {
                errorMessage = "Ошибка от API: HTTP " + code;
                return conn.getErrorStream();
            }
        } catch (MalformedURLException | URISyntaxException e) {
            errorMessage = "Неверный URL/URI: " + e.getMessage();
        } catch (IOException e) {
            errorMessage = "Сетевая ошибка: " + e.getMessage();
        }

        return null;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
