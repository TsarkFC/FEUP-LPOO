public class Speaker extends Person {
    public Speaker(String name) {
        super(name);
    }

    public Speaker(String name, int age) {
        super(name, age);
    }

    public int getFee(){
        return 0;
    }

    public String toString(){
        return "Speaker " + getName() + " has a fee value of " + getFee() + ".";
    }

    @Override
    public int compareTo(Person person) {
        return 0;
    }
}
