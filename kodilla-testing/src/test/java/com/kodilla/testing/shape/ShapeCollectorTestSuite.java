package com.kodilla.testing.shape;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.*;

import java.util.List;

public class ShapeCollectorTestSuite {

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
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square();
        Triangle triangle = new Triangle();
        Circle circle = new Circle();

        //When
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(circle);

        //Then
        Assert.assertEquals(3, shapeCollector.showFigures().size());
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();

        Square square = new Square();
        Triangle triangle = new Triangle();
        Circle circle = new Circle();

        shapeCollector.addFigure(square);
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(circle);

        int figuresNumber = shapeCollector.showFigures().size();

        //When
        shapeCollector.removeFigure(square);
        shapeCollector.removeFigure(triangle);

        //Then
        Assert.assertEquals(figuresNumber-2, shapeCollector.showFigures().size());
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square expectedSquare = new Square();
        Triangle expectedTriangle = new Triangle();
        Circle expectedCircle = new Circle();

        shapeCollector.addFigure(expectedSquare);
        shapeCollector.addFigure(expectedTriangle);
        shapeCollector.addFigure(expectedCircle);

        //When
        Shape receivedSquare = shapeCollector.getFigure(0);
        Shape receivedTriangle = shapeCollector.getFigure(1);
        Shape receivedCircle = shapeCollector.getFigure(2);
        Shape receivedOutOfRangeGreater = shapeCollector.getFigure(3);
        Shape receivedOutOfRangeLower = shapeCollector.getFigure(-1);


        //Then
        Assert.assertEquals(expectedSquare, receivedSquare);
        Assert.assertEquals(expectedTriangle, receivedTriangle);
        Assert.assertEquals(expectedCircle, receivedCircle);
        Assert.assertEquals(null, receivedOutOfRangeGreater);
        Assert.assertEquals(null, receivedOutOfRangeLower);

    }


    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();

        Square expectedSquare = new Square();
        Triangle expectedTriangle = new Triangle();
        Circle expectedCircle = new Circle();

        shapeCollector.addFigure(expectedSquare);
        shapeCollector.addFigure(expectedTriangle);
        shapeCollector.addFigure(expectedCircle);


        //When
        Shape retrivedSquare = shapeCollector.getFigure(0);
        Shape retrivedTriangle = shapeCollector.getFigure(1);
        Shape retrivedCircle = shapeCollector.getFigure(2);

        //Then
        Assert.assertEquals(expectedSquare, retrivedSquare);
        Assert.assertEquals(expectedTriangle, retrivedTriangle);
        Assert.assertEquals(expectedCircle, retrivedCircle);
    }

    @Test
    public void testGetEmptyList() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();

        //When
        Shape retrivedShape = shapeCollector.getFigure(0);
        List<Shape> retrivedShapesList = shapeCollector.showFigures();

        //Then
        Assert.assertEquals(null, retrivedShape);
        Assert.assertTrue(retrivedShapesList.isEmpty());

    }
}
