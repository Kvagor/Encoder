package org.example;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Bruteforce {
    @SneakyThrows
    public void bruteforce() {
        Util.writeMessage("Введите путь к файлу для его расшифровки :");
        String src = Util.readString();
        Path dest = Util.buildFileName(src, "_bruteforce");

        CaesarCipher caesarCipher = new CaesarCipher();
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = Files.newBufferedReader(Path.of(src));
        BufferedWriter writer = Files.newBufferedWriter(dest)){
            while(reader.ready()){
                String line = reader.readLine();
                sb.append(line);
            }
            for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
                String decrypt = caesarCipher.decrypt(sb.toString(), i);
                if (isValidate(decrypt)){
                    writer.write(decrypt);
                    Util.writeMessage("Содержимое расшифровано, ключ расшифровки равен "+ i);
                    break;
                }
            }
        }
    }
    private boolean isValidate(String text){
        return false;
    }
}
















