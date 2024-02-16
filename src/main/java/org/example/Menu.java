package org.example;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Util.writeMessage("""
                    Выберите действие введя его номер
                    1.- Зашифровать текст
                    2.- Расшифровать текст
                    3.- Подобрать ключ через брутфорс
                    4.- Расшифровать текст методом синтаксического перебора
                    5.- Выход из программы""");
            switch (sc.nextLine()) {
                case "1" -> new EncryptedDecrypted().encryptedDecrypted(true);
                case "2" -> new EncryptedDecrypted().encryptedDecrypted(false);
                case "3" -> new Bruteforce().bruteforce();
                case "4" -> new Parsing().parse();
                case "5" -> {
                    return;
                }
            }
        }
    }
}