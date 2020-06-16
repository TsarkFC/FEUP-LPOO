import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comboio {
    private String nome;
    private int passageiros = 0;
    private List<Carruagem> carruagens = new ArrayList<>();
    protected ServicoABordo servicoABordo;

    public Comboio(String nome) {
        this.nome = nome;
        servicoABordo = new ServicoRegular();
    }

    public String getNome() {
        return nome;
    }

    public int getNumLugares() {
        int total = 0;
        for (Carruagem carruagem : carruagens)
            total += carruagem.getNumLugares();
        return total;
    }

    public int getNumCarruagens() {
        return carruagens.size();
    }

    public void addCarruagem(Carruagem carruagem) {
        carruagens.add(carruagem);
    }

    public Carruagem getCarruagemByOrder(int i) {
        List<Carruagem> copy = carruagens;
        Collections.sort(copy);
        return copy.get(i);
    }

    public void removeAllCarruagens(int i) {
        carruagens.removeIf(carruagem -> carruagem.getNumLugares() == i);
    }

    public int getNumPassageiros() {
        return passageiros;
    }

    public int getLugaresLivres() {
        return getNumLugares() - passageiros;
    }

    public void addPassageiros(int i) throws PassengerCapacityExceeded {
        if (i > getLugaresLivres())
            throw new PassengerCapacityExceeded();
        passageiros+=i;
    }

    public void removePassageiros(int i) {
        passageiros-=i;
    }

    public void removePassageiros() {
        passageiros = 0;
    }

    public String toString(){
        return getClass().getName() + " " + nome + ", " + carruagens() + lugares() + pass();
    }

    private String carruagens(){
        return getNumCarruagens() == 1 ? getNumCarruagens() + " carruagem, " : getNumCarruagens() + " carruagens, ";
    }

    private String lugares(){
        return getNumLugares() == 1 ? getNumLugares() + " lugar, " : getNumLugares() + " lugares, ";
    }

    private String pass(){
        return passageiros == 1 ? passageiros + " passageiro" : passageiros + " passageiros";
    }

    public boolean equals(Object o){
        if (o.getClass() != getClass()) return false;
        Comboio c = (Comboio) o;
        if (carruagens.size() != c.carruagens.size()) return false;
        for (int i = 0; i < carruagens.size(); i++)
            if (!carruagens.get(i).equals(c.carruagens.get(i))) return false;
        return c.passageiros == passageiros;
    }

    public ServicoABordo getServicoABordo() {
        return servicoABordo;
    }

    public String getDescricaoServico() {
        return servicoABordo.getDescricao();
    }

    public void setServicoABordo(ServicoABordo servicoABordo) {
        this.servicoABordo = servicoABordo;
    }
}
