package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "SHOPPING TASK";
    public static final String PAINTING_TASK = "PAINTING TASK";
    public static final String DRIVING_TASK = "DRIVING TASK";

    public final Task createTask(final String task) {
        switch (task) {
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping", "Bicycle", 1);
            case PAINTING_TASK:
                return new PaintingTask("Painting", "Red", "Wall");
            case DRIVING_TASK:
                return new DrivingTask("Driving", "Sopot", "Car");
            default:
                return null;

        }
    }
}
