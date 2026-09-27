package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void printName(String name) {
        System.out.println("name:"+name);
    }

    Function<Integer, Integer> function = new Function<Integer,Integer>() {
        public Integer apply(Integer n) {
            return n*2;
        }
    };

    Predicate<Integer> predicate = new Predicate<Integer>() {
        public boolean test(Integer n) {
            return n%2==0;
        }
    };

    public void streamTutorial() {
        List<Integer> nums = Arrays.asList(5,4,3,2,1,12,15);
        Stream<Integer> numsStream = nums.stream();
        Stream<Integer> sortedStream = numsStream
                                        .filter(n -> n%2==1)
                                        // .map(n->n*2) //use this if you want to use lambda function
                                        .map(function)
                                        .sorted();
        List<Integer> sortedNumsList = sortedStream.collect(Collectors.toList());
        // sortedNumsList.forEach(n->System.out.println(n));   
    }

    public List<Integer> filterEvenIntegers(List<Integer> numsList) {
        Stream<Integer> numsStream = numsList.stream();
        List<Integer> evenNums = numsStream
                                        .filter(n -> n%2 == 0)
                                    .collect(Collectors.toList());
        evenNums.add(10);
        return evenNums;
    }

    public void findFirstDistinct(String str) {
        String output = str.chars().mapToObj(c -> (char)c).map(Character::toLowerCase).distinct().map(String::valueOf).skip(2).collect(Collectors.joining());
        System.out.println(output);
    }

    public void findDistinctStrings(List<String> strList) {
        List<String> unique = strList.stream().distinct().collect(Collectors.toList());
        unique.forEach(System.out::println);
    }

    /**
     * Given a sentence, convert it to camelCase string. The given sentence will have space, tabs, line breaks
     * Eg: input - "HeLlO      WoRLD     "
     * Result - #HelloWorld
     */
    public void convertToHashTagString(String str) {
        String result = "#";
        result = result+Arrays.asList(str.trim().split("\\s+")) //trim the white space at the beginning and end and split with white space
            .stream()
            .map(s -> 
                s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase() //for each word, convert the first letter to upper case and the rest of th letters in the word to lower case and concatenate them
            )
            .collect(Collectors.joining());
        System.out.println(result);
    }

    /**
     * Given a sentence, convert it to camelCase string. The given sentence will have space, tabs, line breaks
     * Eg: input - "HeLlO      WoRLD     "
     * Result - helloWorld
     */
    public void camelCaseString(String str) {
        String[] strArr = str.trim().split("\\s+");
        String output = IntStream.range(0, strArr.length)
            .mapToObj(i -> {
                if(i==0) {
                    return strArr[i].toLowerCase();
                } else{
                    return strArr[i].substring(0,1).toUpperCase()+strArr[i].substring(1).toLowerCase();
                }
            })
            .collect(Collectors.joining());
        System.out.println(output);
    }

}
