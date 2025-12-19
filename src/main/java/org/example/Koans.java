package org.example;
import java.util.HashSet;
import java.util.function.*;

public class Koans {

    public static void mapArray(int[] array, UnaryOperator<Integer> f){
        for(int i=0;i<array.length;i++){
            array[i] = f.apply(array[i]);
        }
    }

    public static double[] fillArray(int length, Supplier<Double> s){
        double[] array = new double[length];
        for(int i=0;i<length;i++){
            array[i] = s.get();
        }
        return array;
    }

    public static int[] iterateFunction(int length, int first, IntUnaryOperator f){
        int[] array = new int[length];
        array[0] = first;

        for(int i = 1; i<length; i++){
            array[i] = f.applyAsInt(array[i - 1]);
        }
        return array;
    }

    public static DoubleUnaryOperator createMultiplier(double d){
        return x -> x*d;
    }

    public static void forEachArray(String[] strings, Consumer<String> c){
        for(int i=0;i<strings.length;i++){
            c.accept(strings[i]);
        }
    }

    public static <T> Predicate<T> duplicateChecker(){
        HashSet<T> set = new HashSet<>();
        return set::add;
    }
}