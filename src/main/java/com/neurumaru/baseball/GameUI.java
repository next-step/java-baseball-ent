package com.neurumaru.baseball;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameUI {
    private final Scanner scanner;
    private final PrintStream printStream;
    private final Map<String, String> stringMap;

    public GameUI(InputStream inputStream, PrintStream printStream) {
        this(inputStream, printStream, new HashMap<>());
    }

    public GameUI(InputStream inputStream, PrintStream printStream, Map<String, String> stringMap) {
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
        this.stringMap = stringMap;
    }

    public String getString(String tag) {
        return stringMap.get(tag);
    }

    public String mapString(String string, Map<String, String> map) {
        for (String key : map.keySet()) {
            string = string.replace(key, map.get(key));
        }
        return string;
    }
}
