package com.example.idiom_backend;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;

public class RandomTest {
    @Test
    public void test1() {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(1);
        System.out.println(hashSet);
    }
    @Test
    void test2() {
        System.out.println(new Random().nextInt(1));
    }
    @Test
    void test3() {
        StringBuilder str = new StringBuilder("ad");
        str.insert(0,"r");
        str.insert(3,"b");
        System.out.println(str);
    }
}
