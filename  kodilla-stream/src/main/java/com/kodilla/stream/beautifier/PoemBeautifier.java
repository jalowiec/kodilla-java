package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String textToDecore, PoemDecorator poemDecorator) {
        String result = poemDecorator.decorate(textToDecore);
        System.out.println(result);
    }

    public void beautifySpace(String textToDecore, String space, PoemDecoratorSpace poemDecoratorSpace) {
        String result = "";
        for(Character character : textToDecore.toCharArray()){
          result += character + space;
    }
        System.out.println(result);

    }

    public void beautifyDoubleSide(String textToDecore, String leftDecor, String rightDecor, PoemDecoratorDoubleSide poemDecoratorDoubleSide) {
        String result = poemDecoratorDoubleSide.decorate(textToDecore, leftDecor, rightDecor);
        System.out.println(result);
    }
}


