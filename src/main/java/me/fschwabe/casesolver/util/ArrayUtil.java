package me.fschwabe.casesolver.util;

public class ArrayUtil {

    private ArrayUtil() {

    }

    public static void swap(boolean[] array, int a, int b) {
        boolean tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

}
