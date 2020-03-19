public class AreaStringOutputter {
    private AreaAggregator areaAggregator;

    public AreaStringOutputter(AreaAggregator areaAggregator){
        this.areaAggregator = areaAggregator;
    }

    public String output(){
        return "Sum of areas: " + areaAggregator.sum();
    }
}
