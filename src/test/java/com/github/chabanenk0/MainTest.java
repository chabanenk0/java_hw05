package com.github.chabanenk0;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by dmitry on 08.12.16.
 */
public class MainTest
{
    @Test
    public void mainTest()
    {
        String [] args = {};
        try {
            Main.main(args);
        } catch (Exception e) {
            assertTrue(false);
        }
        assertTrue(true);
    }
}
