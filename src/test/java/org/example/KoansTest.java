package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.Random;

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
}
