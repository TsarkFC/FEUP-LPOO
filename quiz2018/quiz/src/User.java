public class User{
    private String username;

    public User(String name, String age){
        this.username = name+age;
    }

    public String getUsername(){
        return username;
    }
}
