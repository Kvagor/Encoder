package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Encrypted {
    public void encrypted() throws IOException{
        /*
        Запросить путь к файлу,запросить ключ шифрования, запросить путь куда записывать результат
        через ресурсы открыть чтение, открыть ресурс для чтения , зашифровать Цезаря, результат записать в файл
        для записи, создать класс Decrypted и все в обратном порядке
         */

        Scanner scanner = new Scanner(System.in);
        Path path1 = Path.of(scanner.nextLine());
        Path path2 = Path.of(scanner.nextLine());
        try(FileReader reader = new FileReader(path1.toFile());
            FileWriter writer = new FileWriter(path2.toFile()))
        {
            char[] buffer = new char[65536];
            while (reader.ready())
            {
                int real = reader.read(buffer);
                writer.write(buffer, 0, real);
            }
        }
    }
}
