public class FiguraComposta extends Figura implements Countable {
    private Figura[] figuras;

    public FiguraComposta(Figura[] figuras) {
        this.figuras = figuras;
    }

    @Override
    public double getArea() {
        double total = 0;
        for (int i = 0; i < figuras.length; i++)
            total += figuras[i].getArea();
        return total;
    }

    @Override
    public double getPerimetro() {
        double total = 0;
        for (int i = 0; i < figuras.length; i++)
            total += figuras[i].getPerimetro();
        return total;
    }

    @Override
    public int count() {
        return figuras.length;
    }
}
