package com.raymondjcox.challenges;

import com.raymondjcox.utils.FileUtils;

import java.util.HashMap;

public class Challenge2 {
    public static void main(String[] args) throws Exception {
        String lines[] = FileUtils.readFile("input2.txt");
        System.out.println(Part1(lines));
        System.out.println(Part2(lines));
    }


    public static int Part1(String lines[]) {
        int numThrees = 0;
        int numTwos = 0;
        for (String line : lines) {
            HashMap<Character, Integer> charCounts = new HashMap<>();
            for (char c : line.toCharArray()) {
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            }
            boolean hasThree = false;
            boolean hasTwo = false;

            for (char key : charCounts.keySet()) {
                if (charCounts.get(key) == 3) {
                    hasThree = true;
                }
                if (charCounts.get(key) == 2) {
                    hasTwo = true;
                }
            }
            if (hasThree) {
                numThrees += 1;
            }
            if (hasTwo) {
                numTwos += 1;
            }
        }

        return numThrees * numTwos;
    }


    public static String Part2(String lines[]) {
        for (int i = 0; i < lines.length; i++) {
            char[] original = lines[i].toCharArray();
            for (int j = i + 1; j < lines.length; j++) {
                char[] test = lines[j].toCharArray();
                int numDifferences = 0;
                StringBuffer sb = new StringBuffer();
                for (int a = 0; a < original.length && numDifferences < 2; a++) {
                    if (original[a] != test[a]) {
                        numDifferences += 1;
                        continue;
                    }
                    sb.append(original[a]);
                }
                if (numDifferences == 1) {
                    return sb.toString();
                }
            }
        }
        return null;
    }
}
