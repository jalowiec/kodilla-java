package com.kodilla.testing.shape;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.*;

import java.util.List;

public class ShapeTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @After
    public void afterEveryTest() {
        System.out.println("Finishing to execute test #" + testCounter);
    }


    @Test
    public void testFigureName() {
        //Given
        Square square = new Square();
        Triangle triangle = new Triangle();
        Circle circle = new Circle();

        //When
        String expectedSquareName = square.getShapeName();
        String expectedTriangleName = triangle.getShapeName();
        String expectedCircleName = circle.getShapeName();

        //Then
        Assert.assertEquals("Shape Square", expectedSquareName);
        Assert.assertEquals("Shape Triangle", expectedTriangleName);
        Assert.assertEquals("Shape Circle", expectedCircleName);
    }

    @Test
    public void testField() {
        //Given
        Square square = new Square(3.3);
        Triangle triangle = new Triangle(1.1, 4.4);
        Circle circle = new Circle(6.6);

        //When
        double squareField = square.getField();
        double triangleField = triangle.getField();
        double circleField = circle.getField();

        //Then
        Assert.assertEquals(10.89, squareField, 0.01);
        Assert.assertEquals(2.42, triangleField, 0.01);
        Assert.assertEquals(136.8477, circleField, 0.01);
    }


}
