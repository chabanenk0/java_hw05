package com.github.chabanenk0;

import com.github.chabanenk0.Utils.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
            System.out.println("Initial list: " + list.toString());
            System.out.println("Filtered (only even): " + filteredList.toString());
            System.out.println("Any match (any even number): " + CollectionUtils.anyMatch(list, x -> x % 2 == 0));
            System.out.println("Any match (any negative): " + CollectionUtils.anyMatch(list, x -> x < 0));
            System.out.println("All match (all positive): " + CollectionUtils.allMatch(list, x -> x > 0));
            System.out.println("All match (all even): " + CollectionUtils.allMatch(list, x -> x % 2 == 0));
            System.out.println("map (divide by 2): " + CollectionUtils.map(list, (x) -> (double) x / 2));
            System.out.println("max: " + CollectionUtils.max(list, (x, y) -> x - y));
            System.out.println("min: " + CollectionUtils.min(list, (x, y) -> x - y));

            Integer[] array2 = new Integer[]{1, 1, 2, 2, 3, 3, 7, 8};
            List<Integer> list2 = new LinkedList<Integer>(Arrays.asList(array2));
            System.out.println("Initial list2: " + list2.toString());
            System.out.println("Distinct: " + CollectionUtils.distinct(list2));

            System.out.println("forEach:");
            CollectionUtils.forEach(list, x -> {
                System.out.print("element: "+  x.toString() + ", ");
            });

            System.out.println("Reduce (sum):" + CollectionUtils.reduce(list, (x, y) -> x + y));
            System.out.println("Partition test (odd or even):");
            Map<Boolean, List<Integer>> partitionResult = CollectionUtils.partitionBy(list, x -> x % 2 == 0);
            List<Integer> trueList = partitionResult.get(true);
            System.out.println("True sublist:" + trueList);
            List<Integer> falseList = partitionResult.get(false);
            System.out.println("False sublist:" + falseList);

            int classesNumber = 3;
            Map<Integer, List<Integer>> groupResultMap = CollectionUtils.groupBy(list, x -> x % classesNumber);
            System.out.println("groupByResult (congruency classes, by division by 3 reminder):");
            for(int i = 0; i < classesNumber; i++) {
                System.out.println("class " + i + ", list:");
                System.out.println(groupResultMap.get(i));
            }

            Map<Integer, Double> newMap = CollectionUtils.toMap(
                    list,
                    x -> x % classesNumber, // classes (keys for map)
                    y -> (double) y / 2, // values for map)
                    (y1, y2) -> y1 + y2 // aggregate function
            );

            System.out.println("Map Result (congruency classes, by division by 3 reminder):");
            for(int i = 0; i < classesNumber; i++) {
                System.out.println("class " + i + ", list:");
                System.out.println(newMap.get(i));
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
