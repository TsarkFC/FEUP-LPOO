public class User {
    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object){
        if (object.getClass() != getClass())
            return false;
        User user = (User) object;
        return user.getName() == name;
    }
}
