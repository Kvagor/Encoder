package org.example;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Выберите действие введя его номер
                    1.- Зашифровать текст
                    2.- Расшифровать текст
                    3.- Подобрать ключ через брутфорс
                    4.- Расшифровать текст методом синтаксического перебора
                    5.- Выход из программы""");

            switch (scanner.nextLine()) {
                case "1" -> System.out.println();
                case "2" -> System.out.println();
                case "3" -> System.out.println();
                case "4" -> System.out.println();
                case "5" -> {
                    return;
                }
            }
        }
    }
}