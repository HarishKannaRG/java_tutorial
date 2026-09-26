package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
}
