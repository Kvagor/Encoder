package org.example;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;

public class Bruteforce {

    private static final int MAX_LENGTH_WORD = 28;

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
                Files.writeString(dest, decrypt);
                Util.writeMessage("Содержимое расшифровано, ключ расшифровки равен " + i);
                break;
            }
        }
    }

    private boolean isValidate(String text) {
        boolean isValidate = false;
        String[] array = text.split(" ");
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > MAX_LENGTH_WORD) {
                return false;
            }
        }
        if (text.contains(". ") || text.contains(", ") || text.contains("? ") || text.contains("! ")) {
            isValidate = true;
        }
        while (isValidate) {
            Util.writeMessage(text);
            Util.writeMessage("Вы подтверждаете, что это корректный текст? Да/Нет");
            String answer = Util.readString();
            if (answer.equalsIgnoreCase("Да")) {
                return true;
            } else if (answer.equalsIgnoreCase("Нет")) {
                isValidate = false;
            } else {
                Util.writeMessage("Проверьте правильность ввода.");
            }
        }
        return false;
    }
}















