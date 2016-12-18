package com.github.chabanenk0;

import com.github.chabanenk0.Utils.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by dmitry on 18.12.16.
 */
public class FilterTest
{
    private List<Integer> getList()
    {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(array));

        return list;
    }
    @Test
    public void filterAnyEvenTest()
    {
        try {
            List<Integer> list = this.getList();
            List<Integer> filteredList = CollectionUtils.filter(list, x -> x % 2 == 0);
            assertEquals(4, filteredList.size());
            assertEquals(8, list.size());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void filterEmptyTest()
    {
        try {
            List<Integer> list = this.getList();
            List<Integer> filteredList = CollectionUtils.filter(list, x -> x < 0);
            assertEquals(0, filteredList.size());
            assertEquals(8, list.size());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void filterAllTest()
    {
        try {
            List<Integer> list = this.getList();
            List<Integer> filteredList = CollectionUtils.filter(list, x -> x >= 0);
            assertEquals(8, filteredList.size());
            assertEquals(8, list.size());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
