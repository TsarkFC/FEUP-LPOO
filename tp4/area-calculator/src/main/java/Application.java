public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();
        aggregator.addShape(new Circle(1));
        aggregator.addShape(new Circle(2));
        aggregator.addShape(new Square(2));
        aggregator.addShape(new Ellipse(2, 3));
        aggregator.addShape(new Rectangle(2, 4));
        aggregator.addShape(new Triangle(2, 4));
        aggregator.addShape(new House(100));

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
        
        City city = new City();

        city.addHouse(new House(50));
        city.addHouse(new House(150));

        AreaStringOutputter cityOutputter = new AreaStringOutputter(city);
        AreaXMLOutputter cityXMLOutputter = new AreaXMLOutputter(city);

        System.out.println(cityOutputter.output());
        System.out.println(cityXMLOutputter.output());
    }
}
