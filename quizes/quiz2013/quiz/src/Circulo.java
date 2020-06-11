public class Circulo extends Figura{
    private Ponto centro;
    private int raio;
    public Circulo(Ponto centro, int raio) throws IllegalArgumentException {
        if (raio <= 0)
            throw new IllegalArgumentException();
        this.centro = centro;
        this.raio = raio;
    }

    public int getRaio() {
        return raio;
    }

    public Ponto getCentro() {
        return centro;
    }

    @Override
    public double getArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double getPerimetro() {
        return 2 * raio * Math.PI;
    }
}
