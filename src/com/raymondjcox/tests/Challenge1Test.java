package com.raymondjcox.tests;


import com.raymondjcox.challenges.Challenge1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Challenge1Test {

    @Test
    public void part1() {
        String[] lines = { "+1", "-1", "+2" };
        Assertions.assertEquals(2, Challenge1.Part1(lines));
    }

    @Test
    public void part2() {
        String[] lines = { "+1", "-5", "+1", "-1" };
        Assertions.assertEquals(-4, Challenge1.Part2(lines));
    }
}
