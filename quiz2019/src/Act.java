public abstract class Act {
    private String name;
    private String country;

    public Act(String name, String country){
        this.name = name;
        this.country = country;
    }

    public String getName() { return name; }
    public String getCountry() {return country; }

    @Override
    public boolean equals(Object object){
        if (object == null || object.getClass() != getClass()) return false;
        Act act = (Act) object;
        return name.equals(act.getName()) && country.equals(act.getCountry());
    }
}
