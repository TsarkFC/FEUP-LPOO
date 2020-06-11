public class Rectangulo extends Figura {
    private int x, y;
    public Rectangulo(int x1, int y1, int x2, int y2) {
        this.x = x2-x1;
        this.y = y2-y1;
    }

    @Override
    public double getArea() {
        return x*y;
    }

    @Override
    public double getPerimetro() {
        return 2*x+2*y;
    }
}
