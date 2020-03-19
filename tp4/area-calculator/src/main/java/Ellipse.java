public class Ellipse implements Shape{
    private double xradius;
    private double yradius;

    public Ellipse(double xradius, double yradius){
        this.xradius = xradius;
        this.yradius = yradius;
    }
    public double getXradius() {
        return xradius;
    }

    public void setXradius(Integer xradius) {
        this.xradius = xradius;
    }

    public double getYradius() {
        return yradius;
    }

    public void setYradius(Integer yradius) {
        this.yradius = yradius;
    }

    public double getArea(){
        return xradius * yradius * Math.PI;
    }

    public void draw() {
        System.out.println(this.getClass().getName());
    }
}
