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
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path1.toFile()));
             FileWriter writer = new FileWriter(path2.toFile())) {
            String line;
            CaesarCipher cs = new CaesarCipher();
            while ((line = bufferedReader.readLine()) != null) {
                writer.write(cs.decrypt(line,key));
            }
        }
    }
}
