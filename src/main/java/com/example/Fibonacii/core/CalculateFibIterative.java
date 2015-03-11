package com.example.Fibonacii.core;

import java.util.ArrayList;

/**
 * Created by kuldeep.ashok on 07/03/15.
 */
public class CalculateFibIterative {
    public static Long Fib(int n) throws Exception {
        ArrayList<Long> a = new ArrayList<Long>();
        try {

            a.add(0, 0L);
            a.add(1, 1L);
            for (int i = 2; i <= n; i++) {
                a.add(i, a.get(i - 1) + a.get(i - 2));
            }
            return a.get(n);
        }
        catch(Exception e) {
            throw new Exception();
        }
        finally {
            a=null;
        }
    }
}
