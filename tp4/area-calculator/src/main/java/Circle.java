public class Circle implements Shape {
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void draw() {
        System.out.println(this.getClass().getName());
    }
}
