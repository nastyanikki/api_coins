package ru.chsu.is31.year2025.nikitina.view;

import ru.chsu.is31.year2025.nikitina.model.Coin;
import ru.chsu.is31.year2025.nikitina.model.CoinFinder;
import ru.chsu.is31.year2025.nikitina.model.coinranking.CoinsParse;
import ru.chsu.is31.year2025.nikitina.model.coinranking.Coins_Api;
import ru.chsu.is31.year2025.nikitina.model.coinranking.Request;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class ConsoleUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать!");

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
            boolean running = true;

            while (running) {
                System.out.println("\nЧто вы хотите сделать?");
                System.out.println("1. Найти монету по названию");
                System.out.println("2. Найти монету по символу");
                System.out.println("3. Показать общее количество монет");
                System.out.println("4. Выйти");
                System.out.print("Ваш выбор: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        while (true) {
                            System.out.print("Введите название монеты, например Bitcoin (или нажмите Enter для выхода): ");
                            String inputName = scanner.nextLine();
                            if (inputName.isBlank()) break;

                            Coin foundByName = CoinFinder.findByName(request.getCoins(), inputName);
                            if (foundByName != null) {
                                System.out.println("Найдена монета:\n" + foundByName);
                            } else {
                                System.out.println("Монета с таким названием не найдена.");
                            }
                        }
                        break;

                    case "2":
                        while (true) {
                            System.out.print("Введите символ монеты, например BTC (или нажмите Enter для выхода): ");
                            String inputSymbol = scanner.nextLine();
                            if (inputSymbol.isBlank()) break;

                            Coin foundBySymbol = CoinFinder.findBySymbol(request.getCoins(), inputSymbol);
                            if (foundBySymbol != null) {
                                System.out.println("Найдена монета:\n" + foundBySymbol);
                            } else {
                                System.out.println("Монета с таким символом не найдена.");
                            }
                        }
                        break;

                    case "3":
                        System.out.println("Всего монет: " + request.getCoins().size());
                        break;

                    case "4":
                        running = false;
                        System.out.println("До свидания!");
                        break;

                    default:
                        System.out.println("Неверный выбор. Пожалуйста, введите число от 1 до 4.");
                }
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
