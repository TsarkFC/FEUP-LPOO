package com.aor.refactoring.example5;

public class West implements Direction{
    public void rotateRight(Turtle object){
        object.setDirection(new North());
    }
    public void rotateLeft(Turtle object){
        object.setDirection(new South());
    }
    public void moveForward(Turtle object){
        object.setColumn(object.getColumn()-1);
    }
    public char getDirection(){
        return 'W';
    }
}
