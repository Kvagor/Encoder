package org.example;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class EncryptedDecrypted {
    private final CaesarCipher caesar = new CaesarCipher();

    @SneakyThrows
    public void encryptedDecrypted(boolean flag) {

        Util.writeMessage("Введите путь к файлу для его " + (flag ? "зашифровки" : "расшифровки"));
        String src = Util.readString();
        Util.writeMessage("Введите ключ: ");
        int key = Util.readInt();

        Path dst = Util.buildFileName(src, flag ? "_encrypted" : "_decrypted");
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(src));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
               String result = flag ? caesar.encrypt(line, key) : caesar.decrypt(line,key);
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
        }Util.writeMessage("Файл "+(flag ? "зашифрован" : "расшифрован")+" и располагается по адресу "+ dst);
    }
}
