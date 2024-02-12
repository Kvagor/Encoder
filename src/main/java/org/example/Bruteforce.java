package org.example;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bruteforce {
    @SneakyThrows
    public void bruteforce() {
        Util.writeMessage("Введите путь к файлу для его расшифровки :");
        String src = Util.readString();
        Path dest = Util.buildFileName(src, "_bruteforce");
        String line = Files.readString(Path.of(src));

        CaesarCipher caesarCipher = new CaesarCipher();
            for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
                String decrypt = caesarCipher.decrypt(line, i);
                if (isValidate(decrypt)) {
                    Files.writeString(dest,decrypt);
                    Util.writeMessage("Содержимое расшифровано, ключ расшифровки равен " + i);
                    break;
                }
            }
    }

    private boolean isValidate(String text) {
        boolean isValidate = true;
        String[] array = text.split(" ");
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > 28) {
                return false;
            }
        }

        if (isValidate) {
            Pattern pattern = Pattern.compile("[.,:;?!-]+");
            Matcher matcher = pattern.matcher(text);
            isValidate = matcher.find() ? true : false;
            if (isValidate) {
                for (String line : array) {
                    System.out.print(line + " ");
                }
                System.out.println();
                Util.writeMessage("Вы подтверждаете, что это корректный текст?");
                String user = Util.readString();
                while (true) {
                    if (user.equals("Да")) {
                        isValidate = true;
                        break;
                    } else if (user.equals("Нет")) {
                        isValidate = false;
                        break;
                    } else {
                        Util.writeMessage("Проверьте правильность ввода.");
                        //Здесь нужен код который заново возвращается к циклу
                    }
                }
            }
        }
        return isValidate;
    }
}















