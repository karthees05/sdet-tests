package com.test.qa;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class DuplicateFromOnaArray {
    @Test
    public void test1() {
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 2};
        System.out.printf(String.valueOf(findDuplicates(arr1)));
        assertThat(findDuplicates(arr1), hasItem(2));
    }

    public List<Integer> findDuplicates(Integer[] arr1) {

        List<Integer> list1 = Arrays.asList(arr1);

        return list1.stream()
                .collect(Collectors.groupingBy(Integer::intValue))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
