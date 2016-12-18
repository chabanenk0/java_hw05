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
public class MapTest {
    private List<Integer> getList()
    {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(array));

        return list;
    }
    @Test
    public void mapTest()
    {
        try {
            List<Integer> list = this.getList();
            List<Double> mappedList = CollectionUtils.map(list, (x) -> (double) x / 2);
            assertEquals(8, mappedList.size());
            Double firstItem = mappedList.iterator().next();
            assertTrue(firstItem.equals(0.5));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
