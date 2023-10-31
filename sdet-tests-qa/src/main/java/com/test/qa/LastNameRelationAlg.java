package com.test.qa;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LastNameRelationAlg {

    public static List<String> findSimilarLastNames(String[] fullNames) {
        Map<String, List<String>> lastNameGroups = Arrays.stream(fullNames)
                .filter(name -> name.split(" ").length == 2)
                .collect(Collectors.groupingBy(name -> name.split(" ")[1]));

        return lastNameGroups.values()
                .stream()
                .filter(list -> list.size() > 1)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Test
    public void test1() {
        String[] fullNames = {"John Smith", "Jane Doe", "Alice Smith", "Bob Johnson", "Eve Doe"};
        List<String> similarFullNames = findSimilarLastNames(fullNames);


        Assert.assertTrue(similarFullNames.contains("John Smith"));

        System.out.println("Full names with similar last names:");
        similarFullNames.forEach(System.out::println);
    }
}
