package com.github.chabanenk0;

import com.github.chabanenk0.Utils.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dmitry on 08.12.16.
 */
public class Main
{
    public static void main(String[] args) {
        System.out.println("Filter testing");
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(array));
        try {
            List<Integer> filteredList = CollectionUtils.filter(list, x -> x < 0);
            System.out.println("Filtered (only even): " + filteredList.toString());
            System.out.println("Any match (any even number): " + CollectionUtils.anyMatch(list, x -> x % 2 == 0));
            System.out.println("Any match (any negative): " + CollectionUtils.anyMatch(list, x -> x < 0));
            System.out.println("All match (all positive): " + CollectionUtils.allMatch(list, x -> x > 0));
            System.out.println("All match (all even): " + CollectionUtils.allMatch(list, x -> x % 2 == 0));
            System.out.println("map (divide by 2): " + CollectionUtils.map(list, (x) -> (double) x / 2));
            System.out.println("max: " + CollectionUtils.max(list, (x, y) -> x - y));
            System.out.println("min: " + CollectionUtils.min(list, (x, y) -> x - y));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
