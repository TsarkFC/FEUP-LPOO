public class Romulan extends AlienClient{
    protected OrderingStrategy createOrderingStrategy() {
        return new ImpatientStrategy();
    }
}
