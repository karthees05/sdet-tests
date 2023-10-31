package com.test.qa;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class DuplicateFromTwoArrays {
    @Test
    public void test1() {
        Integer[] arr1 = {1, 2, 3, 4, 5, 6};
        Integer[] arr2 = {2, 3};
        System.out.printf(String.valueOf(findDuplicates(arr1, arr2)));
        assertThat(findDuplicates(arr1, arr2), hasItem(2));
        assertThat(findDuplicates(arr1, arr2), hasItem(3));
    }

    public List<Integer> findDuplicates(Integer[] arr1, Integer[] arr2) {

        List<Integer> list1 = Arrays.asList(arr1);
        List<Integer> list2 = Arrays.asList(arr2);

        List<Integer> dups = list1.stream()
                .filter(list2::contains)
                .toList();
        return dups;
    }

}
