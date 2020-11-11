public class Ferengi extends AlienClient{

    protected OrderingStrategy createOrderingStrategy() {
        return new SmartStrategy();
    }
}
