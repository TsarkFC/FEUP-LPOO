public abstract class Person extends User implements Comparable<Person>{
    private String name;
    private int age = 0;

    public Person(String name){
        super(name, "");
        this.name = name;
    }

    public Person(String name, int age){
        super(name, String.valueOf(age));
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
