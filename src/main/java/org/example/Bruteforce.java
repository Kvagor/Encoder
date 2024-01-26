package org.example;

import java.nio.file.Path;

public class Bruteforce {
    public void bruteforce(){
        Util.writeMessage("Введите путь к файлу для его расшифровки :");
        String src = Util.readString();
        Path dest = Util.buildFileName(src,"_bruteforce");
        /*
            написать метод который вернет длину (метод alphabetLength) , нужно найти ключ который сделает корректную дешифровку
            в цикле
         */
    }
}
