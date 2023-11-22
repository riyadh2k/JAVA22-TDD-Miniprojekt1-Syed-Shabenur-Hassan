package test;

import main.Triangle;
import main.Triangle.TYPE;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    // Valid Triangles
    @Test
    @DisplayName("Test Equilateral Triangle")
    void testEquilateralTriangle() {
        Triangle triangle = new Triangle(3, 3, 3);
        assertEquals(TYPE.EQUILATERAL, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test Isosceles Triangle")
    void testIsoscelesTriangle() {
        Triangle triangle = new Triangle(3, 3, 4);
        assertEquals(TYPE.ISOSCELES, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test Scalene Triangle")
    void testScaleneTriangle() {
        Triangle triangle = new Triangle(3, 4, 6);
        assertEquals(TYPE.SCALENE, triangle.getCurrent_type());
    }

    // Invalid Triangles
    @Test
    @DisplayName("Test Not a Triangle with Sides Violating Triangle Inequality")
    void testNotATriangleInequality() {
        Triangle triangle = new Triangle(1, 2, 3);
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test Not a Triangle with Zero Side")
    void testNotATriangleZeroSide() {
        Triangle triangle = new Triangle(0, 2, 2);
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test Not a Triangle with Negative Side")
    void testNotATriangleNegativeSide() {
        Triangle triangle = new Triangle(-1, 2, 3);
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test Not a Triangle with Two Sides Equal to Third Side")
    void testNotATriangleSidesEqualThird() {
        Triangle triangle = new Triangle(1, 1, 2);
        assertNull(triangle.getCurrent_type());
    }

    // Boundary Tests
    @Test
    @DisplayName("Test Triangle with Integer.MAX_VALUE Sides")
    void testTriangleMaxIntSides() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    @DisplayName("Test Triangle with minimum positive side lengths")
    void testTriangleWithMinSides() {
        Triangle triangle = new Triangle(1, 1, 1);
        assertEquals(TYPE.EQUILATERAL, triangle.getCurrent_type());
    }

    // Exception Test for invalid numbers
    @Test
    @DisplayName("Test Triangle with Invalid Number Format")
    void testTriangleWithInvalidNumbers() {
        Triangle triangle = new Triangle(new String[]{"2147483648", "2", "2"});
        assertNull(triangle.getCurrent_type());
    }

    // Overflow Test
    @Test
    @DisplayName("Test Triangle Side Lengths Causing Overflow")
    void testTriangleWithOverflow() {
        Triangle triangle = new Triangle(Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2);
        assertNull(triangle.getCurrent_type());
    }

    // String array constructor tests
    @Test
    @DisplayName("Test String Array Constructor with Valid Input")
    void testStringArrayConstructorValid() {
        Triangle triangle = new Triangle(new String[]{"3", "4", "5"});
        assertEquals(TYPE.SCALENE, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test String Array Constructor with Invalid Input")
    void testStringArrayConstructorInvalid() {
        Triangle triangle = new Triangle(new String[]{"a", "b", "c"});
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test String Array Constructor with Incorrect Array Length")
    void testStringArrayConstructorIncorrectLength() {
        Triangle triangle = new Triangle(new String[]{"3", "4"});
        assertNull(triangle.getCurrent_type());
    }

    // ... any other tests ...

}
