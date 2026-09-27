import java.lang.reflect.Array;
import java.util.Arrays;

import streams.Streams;
public class Main {
    
    public static void main(String[] args) {
        Streams.printName("Harish");
        Streams s= new Streams();
        // s.streamTutorial();
        s.streamTutorial();
        // System.out.println(s.filterEvenIntegers(Arrays.asList(1,2,3,4)));
        // s.findFirstDistinct("Harish");
        // s.findDistinctStrings(Arrays.asList("Harish", "Kanna","Harish"));
        s.convertToHashTagString("Hello  WOrLD");
        s.camelCaseString("HeLlO wOrLd");
    }
}
