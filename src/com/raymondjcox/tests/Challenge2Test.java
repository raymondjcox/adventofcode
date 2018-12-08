package com.raymondjcox.tests;


import com.raymondjcox.challenges.Challenge2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Challenge2Test {

    @Test
    public void part1() {
        String[] lines = { "AAABB", "AAA", "BB" };
        Assertions.assertEquals(4, Challenge2.Part1(lines));
    }

    @Test
    public void part2() {
        String[] lines = { "AAAA", "AABB", "AAAB" };
        Assertions.assertEquals("AAA", Challenge2.Part2(lines));
    }
}
