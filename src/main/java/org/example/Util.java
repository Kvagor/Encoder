package org.example;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Util {
    private static final BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String line;
        try {
            line = CONSOLE.readLine();
        } catch (IOException e) {
            writeMessage("Произошла ошибка при вводе текста, попробуйте еще раз.");
            line = readString();
        }
        return line;
    }

    public static int readInt() {
        int number;
        try {
            number = CONSOLE.read();
        } catch (IOException e) {
            writeMessage("Произошла ошибка при вводе числа, попробуйте еще раз.");
            number = readInt();
        }
        return number;
    }

    public static Path buildFileName(String path, String suffix) {
        Path filePath = Path.of(path);
        String name = filePath.getFileName().toString();
        String newFileName;
        if (name.contains(".")) {
            String filename = name.substring(0, name.indexOf('.'));
            newFileName = filename + suffix + name.substring(name.indexOf('.'));
        }else {
            newFileName = name + suffix;
        }
        return filePath.getParent().resolve(newFileName);
    }
}
