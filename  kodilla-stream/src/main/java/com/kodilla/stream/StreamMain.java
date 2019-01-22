package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Tekst do upiekszenia", s -> "***" + s + "***");
        poemBeautifier.beautify("Tekst do upiekszenia", s -> s.toUpperCase());
        poemBeautifier.beautify("   Tekst do upiekszenia    ", s -> s.trim());
        poemBeautifier.beautifySpace("Tekst do upiekszenia", "---", (s, t) -> s);
        poemBeautifier.beautifyDoubleSide("Tekst do upiekszenia", "AAA", "BBB", (s, l, r) -> l + s + r);
    }
}