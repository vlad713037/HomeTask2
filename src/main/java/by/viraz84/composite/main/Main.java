package by.viraz84.composite.main;

import by.viraz84.composite.methods.TextParser;
import by.viraz84.composite.methods.WordReplace;
import by.viraz84.composite.entity.Composite;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String path = "text.txt";
        TextParser textParser = new TextParser();
        Composite wholeText = textParser.parse(path);
        wholeText.parse();
        System.out.println();


        ArrayList<String> textRepl = WordReplace.swapFirstLast(wholeText);
        System.out.println("*********Begin********");
        for (String item : textRepl) {
            System.out.println(item);
        }
        System.out.println("* * * * * End * * * * *");


    }

}
