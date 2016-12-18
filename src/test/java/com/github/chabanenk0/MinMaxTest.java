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
public class MinMaxTest
{
    private List<Integer> getList()
    {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(array));

        return list;
    }
    @Test
    public void maxTest()
    {
        List<Integer> list = this.getList();
        int result = CollectionUtils.max(list, (x, y) -> x - y).orElse(-1);
        assertEquals(8, result);
    }
    @Test
    public void minTest()
    {
        List<Integer> list = this.getList();
        int result = CollectionUtils.min(list, (x, y) -> x - y).orElse(-1);
        assertEquals(1, result);
    }
}
