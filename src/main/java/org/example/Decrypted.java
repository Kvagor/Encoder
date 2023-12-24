package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Decrypted {
    public void decrypted() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу для чтения зашифрованных данных: ");
        Path path1 = Path.of(scanner.nextLine());
        System.out.print("Введите путь к файлу для записи расшифрованных данных: ");
        Path path2 = Path.of(scanner.nextLine());
        System.out.print("Введите ключ шифрования: ");
        int key = scanner.nextInt();
        try (FileReader reader = new FileReader(path1.toFile());
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter writer = new FileWriter(path2.toFile())) {
            String line;
            CaesarCipher cs = new CaesarCipher();
            while ((line = bufferedReader.readLine()) != null) {
                line = cs.decrypt(line, key);
                writer.write(line);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Decrypted en = new Decrypted();
        en.decrypted();
    }
}
