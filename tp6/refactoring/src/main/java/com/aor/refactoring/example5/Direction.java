package com.aor.refactoring.example5;

public interface Direction {
    void rotateRight(Turtle object);
    void rotateLeft(Turtle object);
    void moveForward(Turtle object);
    char getDirection();
}
