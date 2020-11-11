public class Line implements BasicShape{
    private double length;

    public Line(double length){
        this.length = length;
    }

    public void draw() {
        System.out.println(this.getClass().getName());
    }
}
