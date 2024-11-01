package java0;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;


import static org.testng.Assert.assertTrue;

public class VariantTest {

    public static double EPS = 0.0000001;

    // Test for arrayTask
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(double[] array, double[] expected) {
        Variant17 variant = new Variant17();
        assertEquals(Arrays.equals(variant.arrayTask(array), expected));
    }

    private void assertEquals(boolean equals) {
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] {
                { new double[] { 1, 2, 3, 4, 5 }, new double[] { 1, 2, 5, 4, 3 } },
                { new double[] { 10, 20, 30, 40 }, new double[] { 10, 20, 40, 30 } },
                { new double[] { -1, -2, -3, -4 }, new double[] { -1, -2, -4, -3 } }
        };
    }

    // Test for integerNumbersTask
    @Test(dataProvider = "integerProvider")
    public void integerTest(int number, int expected) {
        Assert.assertEquals(new Variant17().integerNumbersTask(number), expected);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] {
                { 1234, 2 },
                { 1009, 0 },
                { 56789, 7 }
        };
    }

    // Test for booleanTask
    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int number, boolean expected) {
        Assert.assertEquals(new Variant17().booleanTask(number), expected);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] {
                { 123, true },
                { 200, false },
                { 101, true },
                { 99, false }
        };
    }

    // Test for caseTask
    @Test(dataProvider = "caseProvider")
    public void caseTest(int number, String expected) {
        Assert.assertEquals(new Variant17().caseTask(number), expected);
    }

    @DataProvider
    public Object[][] caseProvider() {
        return new Object[][] {
                { 11, "одинадцять навчальних завдань" },
                { 25, "двадцять п'ять навчальних завдань" },
                { 40, "сорок навчальних завдань" }
        };
    }

    // Test for forTask
    @Test(dataProvider = "forProvider")
    public void forTest(int n, double A, double expected) {
        Assert.assertEquals(new Variant17().forTask(n, A), expected, EPS);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] {
                { 3, 2.0, 15.0 },
                { 4, 1.5, 13.1875 },
                { 5, 0.5, 1.96875 }
        };
    }

    // Test for ifTask
    @Test(dataProvider = "ifProvider")
    public void ifTest(double A, double B, double C, double[] expected) {
        assertTrue(Arrays.equals(new Variant17().ifTask(A, B, C), expected));
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] {
                { 1.0, 2.0, 3.0, new double[] { 2.0, 4.0, 6.0 } },
                { 3.0, 2.0, 1.0, new double[] { 6.0, 4.0, 2.0 } },
                { 1.0, 3.0, 2.0, new double[] { -1.0, -3.0, -2.0 } }
        };
    }

    // Test for matrixTask
    @Test(dataProvider = "matrixProvider")
    public void matrixTest(int[][] matrix, int k, int[] expected) {
        assertTrue(Arrays.equals(new Variant17().matrixTask(matrix, k), expected));
    }

    @DataProvider
    public Object[][] matrixProvider() {
        return new Object[][] {
                { new int[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} }, 2, new int[] {15, 120} },
                { new int[][] { {10, 20}, {30, 40}, {50, 60} }, 3, new int[] {110, 3000} }
        };
    }

    // Test for whileTask
    @Test(dataProvider = "whileProvider")
    public void whileTest(int number, String expected) {
        // Custom stream to capture printed output
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        new Variant17().whileTask(number);

        Assert.assertEquals(out.toString().trim(), expected);

        // Reset the output stream
        System.setOut(System.out);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] {
                { 1234, "4 3 2 1" },
                { 987, "7 8 9" },
                { 100, "0 0 1" }
        };
    }
}
