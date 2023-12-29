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
/*
Реализовать по примеру readString(используя внутри readString)
 */
    }

    public static Path buildFileName(String path, String suffix) {
   /*
   Подсказка : resolve, отнссительный путь.
   К примеру дана строка path - "...\...\filename.txt"
   Нужно до точки перед расширением после filename вставить suffix
   нужно подумать как это сделать
    */
    }
}
