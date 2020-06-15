public class Carruagem implements Comparable<Carruagem>{
    private int numLugares;
    public Carruagem(int numLugares) {
        this.numLugares = numLugares;
    }

    public int getNumLugares() {
        return numLugares;
    }

    public int compareTo(Carruagem carruagem){
        if (carruagem.numLugares > numLugares) return -1;
        else if (numLugares > carruagem.numLugares) return 1;
        else return 0;
    }

    public boolean equals(Object o){
        if (o.getClass() != getClass()) return false;
        Carruagem c = (Carruagem) o;
        return c.numLugares == numLugares;
    }
}
