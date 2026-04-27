package com.parser.pars;

import java.util.ArrayList;
import java.util.List;

public class Parsar {
    public static List<Integer> bits = new ArrayList<>();
    public static String binary = "";

    public static void binaryBuilder() {
        for (int i = 0; i < bits.size(); i++) {
            binary = binary + bits.get(i);
        }
    }

    public static int parsingInt() {
        String localBinary = binary;
        binary = "";
        return Integer.parseInt(localBinary, 2);
    }

    public static String parsingString() {
        if (binary == null || binary.isEmpty()) {
            return "";
        }
        StringBuilder paddedBinary = new StringBuilder(binary);
        while (paddedBinary.length() % 8 != 0) {
            paddedBinary.append("0");
        }
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < paddedBinary.length(); i += 8) {
            String byteString = paddedBinary.substring(i, i + 8);
            int charCode = Integer.parseInt(byteString, 2);
            text.append((char) charCode);
        }

        binary = "";
        return text.toString();
    }
}