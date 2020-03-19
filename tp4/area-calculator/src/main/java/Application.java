public class Application {
    public static void main(String[] args) {
        Circle cir1 = new Circle(1);
        Circle cir2 = new Circle(2);
        Square square = new Square(2);
        Ellipse ellipse = new Ellipse(2, 3);
        Rectangle rectangle = new Rectangle(2, 4);
        Triangle triangle = new Triangle(2, 4);

        AreaAggregator aggregator = new AreaAggregator();
        aggregator.addShape(cir1);
        aggregator.addShape(cir2);
        aggregator.addShape(square);
        aggregator.addShape(ellipse);
        aggregator.addShape(rectangle);
        aggregator.addShape(triangle);

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
    }
}
