package com.aor.refactoring.example5;

public class North implements Direction{
    public void rotateRight(Turtle object){
        object.setDirection(new East());
    }
    public void rotateLeft(Turtle object){
        object.setDirection(new West());
    }
    public void moveForward(Turtle object){
        object.setRow(object.getRow()-1);
    }
    public char getDirection(){
        return 'N';
    }
}
