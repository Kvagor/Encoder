package org.example;

public class CaesarCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,\":!? +-*/\\@#$%^&(){}[];'|`~=_©«»—" + "0123456789"+(char)10+(char)13;

    public String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();
        for (char aChar : message.toCharArray()) {
            int index = ALPHABET.indexOf(aChar);
            if (index >= 0) {
                int newIndex = (index + key) % ALPHABET.length();
                char newChar = ALPHABET.charAt(newIndex + (newIndex < 0 ? ALPHABET.length() : 0));
                builder.append(newChar);
            }
        }
        return builder.toString();
    }

    public String decrypt(String message, int key) {
        return encrypt(message,-key);
    }
    public int alphabetLength(){
        return ALPHABET.length();
    }

    public String getALPHABET() {
        return ALPHABET;
    }
}
