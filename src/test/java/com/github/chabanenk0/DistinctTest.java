package com.github.chabanenk0;

import com.github.chabanenk0.Utils.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dmitry on 18.12.16.
 */
public class DistinctTest
{
    private List<Integer> getList()
    {
        Integer[] array = new Integer[]{1, 1, 2, 2, 2, 3, 4, 4};
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(array));

        return list;
    }
    @Test
    public void distinctTest()
    {
        try {
            List<Integer> list = this.getList();
            List<Integer> filteredList = CollectionUtils.distinct(list);
            assertEquals(4, filteredList.size());
            assertEquals(8, list.size());
            assertTrue(filteredList.contains(1));
            assertTrue(filteredList.contains(2));
            assertTrue(filteredList.contains(3));
            assertTrue(filteredList.contains(4));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
