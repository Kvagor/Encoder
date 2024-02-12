package org.example;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Parsing {
    @SneakyThrows
    public void parse() {
        Util.writeMessage("Введите путь файла для его расшифровки");
        String src = Util.readString();
        Util.writeMessage("Введите путь для набора статистики");
        String srcUser = Util.readString();
        Path dest = Util.buildFileName(src, "_parsing");
        List<Map.Entry<Character, Integer>> listEncrypted = convertToList(src);
        List<Map.Entry<Character, Integer>> listStatistic = convertToList(srcUser);
        if (listEncrypted.size()<=listStatistic.size()){
            Map<Character,Character> decrypted = new HashMap<>();
            for (int i = 0; i < listEncrypted.size(); i++) {
                decrypted.put(listEncrypted.get(i).getKey(),listStatistic.get(i).getKey());
            }
            String line = Files.readString(Path.of(src));
            StringBuilder builder = new StringBuilder();
            for (char aChar : line.toCharArray()) {
                builder.append(decrypted.get(aChar));
            }
            Files.writeString(dest,builder.toString());
            Util.writeMessage("Сoдержимое файла расшифровано");

        }else {
            Util.writeMessage("Пожалуйста предоставьте файл для статистики большего обьема");
        }
    }

    @SneakyThrows
    private List<Map.Entry<Character, Integer>> convertToList(String path) {
        Map<Character, Integer> map = new HashMap<>();
        String content = Files.readString(Path.of(path));
            for (char aChar : content.toCharArray()) {
                map.merge(aChar,1, Integer::sum);
            }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);
        Comparator<Map.Entry<Character, Integer>> comparator = (o1, o2) -> o2.getValue() - o1.getValue();
        list.sort(comparator);
        return list;
    }
}
