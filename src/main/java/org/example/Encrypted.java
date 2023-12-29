package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Encrypted {
    public void encrypted() throws IOException {
        /*
        Запросить путь к файлу,запросить ключ шифрования, запросить путь куда записывать результат
        через ресурсы открыть чтение, открыть ресурс для чтения , зашифровать Цезаря, результат записать в файл
        для записи, создать класс Decrypted и все в обратном порядке
         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу для чтения данных: ");
        Path path1 = Path.of(scanner.nextLine());
        System.out.print("Введите путь к файлу для записи зашифрованных данных: ");
        Path path2 = Path.of(scanner.nextLine());
        System.out.print("Введите ключ шифрования: ");
        int key = scanner.nextInt();
        try (BufferedReader bufferedReader = Files.newBufferedReader(path1);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path2.toFile()))){
            String line;
            CaesarCipher cs = new CaesarCipher();
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(cs.encrypt(line,key));
            }
        }
    }

    public static void main(String[] args) throws IOException{
        Encrypted en = new Encrypted();
        en.encrypted();
    }
}
