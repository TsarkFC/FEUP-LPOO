public class Square implements Shape{
    private double side;

    public Square(double side){
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
