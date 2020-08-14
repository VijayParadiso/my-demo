package ind.vijay.lambda.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

public class RunMain {
    public static void main(String[] args) {
//        对数组/列表每个元素乘以2
        // range 半开区间，包头不包尾
        int[] ia = range(1, 10).map(i -> i*2).toArray();
        List<Integer> result = range(1, 10).map(i -> i*2).boxed().collect(Collectors.toList());

        Arrays.stream(ia).forEach(item -> {
            System.out.println(item);
        });

        result.stream().forEach(item -> {
            System.out.println(item);
        });


//        计算集合/数组中的数字之和
        System.out.println(range(1, 1000).sum());
        System.out.println(range(1, 1000).reduce(0, Integer::sum));
        System.out.println(Stream.iterate(0, i->i+1).limit(1000).reduce(0, Integer::sum));
        System.out.println(IntStream.iterate(0, i->i+1).limit(1000).reduce(0, Integer::sum));


//        验证字符串中是否包含集合中的某一字符串
        final List<String> keywords = Arrays.asList("brown", "fox", "dog", "pangram");
        final String tweet = "The quick brown fox jumps over a lazy dog. #pangram http://www.rinkworks.com/words/pangrams.shtml";
        final String fakeNews = "哈哈，你让我笑死了，好继承我财产吗？ oh, yes, it this!";

        System.out.println(keywords.stream().anyMatch(tweet::contains));    // true
        System.out.println(keywords.stream().anyMatch(fakeNews::contains));    // false
        System.out.println(keywords.stream().reduce(false, (b, keyword) -> b || tweet.contains(keyword), (l, r) -> l || r));    // true

    }
}
