package testdata;

import utils.RandomGenerator;
import utils.Reader;

public class User {

    private String username;
    private String password;

    public User(String fileName) {
        this.username = Reader.json(fileName).get("username").toString();
        this.password = Reader.json(fileName).get("password").toString();
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRandomUsername() {
        return username = getUsername() + RandomGenerator.integerValue(9) + RandomGenerator.stringValue(3);
    }
}
