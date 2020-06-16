public class TGV extends Comboio {
    public TGV(String nome) {
        super(nome);
        servicoABordo = new ServicoPrioritario();
    }
}
