package com.raymondjcox.tests;


import com.raymondjcox.challenges.Challenge2;
import com.raymondjcox.challenges.Challenge3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Challenge3Test {

    @Test
    public void part1simple() {
        String[] lines  = {"#1 @ 0,0: 20x10", "#2 @ 1,0: 5x5"};
        Assertions.assertEquals(25, Challenge3.Part1(lines));
    }

    @Test
    public void part1simple1() {
        String[] lines  = {"#1 @ 0,0: 20x10", "#2 @ 21,0: 5x5"};
        Assertions.assertEquals(0, Challenge3.Part1(lines));
    }

    @Test
    public void part1simple2() {
        String[] lines  = {"#1 @ 1,0: 5x5", "#2 @ 0,0: 20x10"};
        Assertions.assertEquals(25, Challenge3.Part1(lines));
    }

    @Test
    public void part1partial() {
        String[] lines  = {"#1 @ 0,0: 20x10", "#2 @ 18,8: 5x5"};
        Assertions.assertEquals(4, Challenge3.Part1(lines));
    }

    @Test
    public void part1partial1() {
        String[] lines  = {"#1 @ 18,8: 5x5", "#2 @ 0,0: 20x10"};
        Assertions.assertEquals(4, Challenge3.Part1(lines));
    }

    @Test
    public void part1partial2() {
        String[] lines  = {"#1 @ 0,0: 100x100", "#2 @ 20,20: 100x100", "#3 @ 20,20: 10x10"};
        Assertions.assertEquals(6400, Challenge3.Part1(lines));
    }

    @Test
    public void part2NoOverlap() {
        String[] lines  = {"#1 @ 0,0: 20x10", "#2 @ 21,0: 5x5"};
        Assertions.assertEquals("#1", Challenge3.Part2(lines));
    }

    @Test
    public void part2NoOverlap1() {
        String[] lines  = {"#1 @ 18,8: 5x5", "#2 @ 0,0: 20x10"};
        Assertions.assertEquals(null, Challenge3.Part2(lines));
    }

}
