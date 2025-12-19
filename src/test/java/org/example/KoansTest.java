package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.*;

public class KoansTest {
    @Test
    void testMapArrayAdd() {
        //arrange
        int[] array = {1,2,3,4};
        int[] expected = {2,3,4,5};
        //act
        Koans.mapArray(array, x->x+1);
        //assert
        Assertions.assertArrayEquals(expected,array);
    }

    @Test
    void testMapArraySquare() {
        //arrange
        int[] array = {1,2,3,4};
        int[] expected = {1,4,9,16};
        //act
        Koans.mapArray(array, x->x*x);
        //assert
        Assertions.assertArrayEquals(expected,array);
    }

    @Test
    void testFillArrayPi() {
        //arrange
        double[] expected = {Math.PI,Math.PI,Math.PI,Math.PI,Math.PI};
        //act
        double[] array = Koans.fillArray(5, () -> Math.PI);
        //assert
        Assertions.assertArrayEquals(expected,array);
    }

    @Test
    void testFillArrayRandom() {
        //arrange
        Random seeded = new Random(42);
        Random seededForExpected = new Random(42);
        //act
        double[] array = Koans.fillArray(5, seeded::nextDouble);
        double[] expected = new double[] {
                seededForExpected.nextDouble(),
                seededForExpected.nextDouble(),
                seededForExpected.nextDouble(),
                seededForExpected.nextDouble(),
                seededForExpected.nextDouble()
        };
        //assert
        Assertions.assertArrayEquals(expected,array);
    }

    @Test
    void testIterateFunction() {
        //arrange
        int[] expected = {0,1,2,3,4};
        int[] expected2 = {1,2,4,8,16};
        //act
        int[] array = Koans.iterateFunction(5, 0, x -> x+1);
        int[] array2 = Koans.iterateFunction(5, 1, x -> x*2);
        //assert
        Assertions.assertArrayEquals(expected,array);
        Assertions.assertArrayEquals(expected2,array2);
    }

    @Test
    void testCreateMultiplier(){
        //arrange
        double test = 3.141;
        double expected = 31.41;
        //act
        DoubleUnaryOperator i = Koans.createMultiplier(10);
        //assert
        assertEquals(expected, i.applyAsDouble(test));
    }

    @Test
    void testForEachArray(){
        //arrange
        StringBuilder test = new StringBuilder();
        String[] strings = {"A","B","C","D","E","F","G","H"};
        //act
        Koans.forEachArray(strings, test::append);
        //assert
        assertEquals("ABCDEFGH",test.toString());
    }

    @Test
    void testDuplicateChecker(){
        //arrange
        String a = "A";
        String b = "B";
        String a2 = "A";
        //act
        Predicate<String> i = Koans.duplicateChecker();
        //assert
        assertTrue(i.test(a));
        assertTrue(i.test(b));
        assertFalse(i.test(a2));
    }

}