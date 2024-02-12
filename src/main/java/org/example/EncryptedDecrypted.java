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
        String content = Files.readString(Path.of(src));
        String result = flag ? caesar.encrypt(content, key) : caesar.decrypt(content, key);
        Files.writeString(dst,result);
        Util.writeMessage("Файл " + (flag ? "зашифрован" : "расшифрован") + " и располагается по адресу " + dst);
    }


}
