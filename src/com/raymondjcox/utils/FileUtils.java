package com.raymondjcox.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileUtils {

    public static String[] readFile(String fileName) throws Exception {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
        }
        return lines.toArray(new String[lines.size()]);
    }
}
