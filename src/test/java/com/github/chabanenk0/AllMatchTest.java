package com.github.chabanenk0;

import com.github.chabanenk0.Utils.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by dmitry on 18.12.16.
 */
public class AllMatchTest {
    private List<Integer> getList()
    {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(array));

        return list;
    }
    @Test
    public void allMatchPositiveTest()
    {
        List<Integer> list = this.getList();
        boolean result = CollectionUtils.allMatch(list, x -> x > 0);
        assertEquals(true, result);
    }

    @Test
    public void allMatchNoneTest()
    {
        List<Integer> list = this.getList();
        boolean result = CollectionUtils.allMatch(list, x -> x < 5);
        assertEquals(false, result);
    }
}
