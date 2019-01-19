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
        Assert.assertEquals("Square", expectedSquareName);
        Assert.assertEquals("Triangle", expectedTriangleName);
        Assert.assertEquals("Circle", expectedCircleName);
    }

    @Test
    public void testField() {
        //Given
        Square square = new Square();
        Triangle triangle = new Triangle();
        Circle circle = new Circle();

        //When
        double squareField = square.getField(3.3);
        double triangleField = triangle.getField(1.1, 4.4);
        double circleField = circle.getField(6.6);

        //Then
        Assert.assertEquals(10.89, squareField, 0.01);
        Assert.assertEquals( 2.42, triangleField,0.01);
        Assert.assertEquals( 41.4690, circleField,0.01);
    }


}
