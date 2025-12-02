package org.example;
import java.util.function.*;

import java.util.function.BiConsumer;

public class Koans {

    public static void mapArray(int[] array, UnaryOperator<Integer> f){
        for(int i=0;i<array.length;i++){
            array[i] = f.apply(array[i]);
        };
    }

    public static double[] fillArray(int length, Supplier<Double> s){
        double[] array = new double[length];
        for(int i=0;i<length;i++){
            array[i] = s.get();
        }
        return array;
    }
}