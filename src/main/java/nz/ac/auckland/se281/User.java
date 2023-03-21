package nz.ac.auckland.se281;

public class User {
    private String userName;
    private int age;

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return this.userName;
    }

    public Integer getAge() {
        return this.age;
    }
}
