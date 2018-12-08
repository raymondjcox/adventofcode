package com.raymondjcox.challenges;

import com.raymondjcox.utils.FileUtils;

import java.util.HashSet;

public class Challenge1 {

    public static void main(String[] args) throws Exception {
        String lines[] = FileUtils.readFile("input1.txt");
        System.out.println(Part1(lines));
        System.out.println(Part2(lines));
    }

    public static int Part1(String[] lines) {
        int sum = 0;
        for (String line : lines) {
            int number = Integer.parseInt(line);
            sum += number;
        }

        return sum;
    }

    public static int Part2(String[] lines) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        while(true) {
            for (String line : lines) {
                int number = Integer.parseInt(line);
                if (set.contains(sum)) {
                    return sum;
                }
                set.add(sum);
                sum += number;
            }
        }
    }
}
