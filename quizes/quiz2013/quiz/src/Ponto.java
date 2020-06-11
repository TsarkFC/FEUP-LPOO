public class Ponto implements Comparable<Ponto> {
    private int x, y;
    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o){
        if (o.getClass() != getClass()) return false;
        Ponto ponto = (Ponto) o;
        return ponto.x == x && ponto.y == y;
    }

    @Override
    public int compareTo(Ponto ponto) {
        if (ponto.x == x)
            return y - ponto.y;
        else
            return x - ponto.x;
    }
}
