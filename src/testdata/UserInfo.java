package testdata;

import utils.Reader;

public class UserInfo {

    private String firstName;
    private String lastName;
    private String zipCode;

    public UserInfo(String fileName) {
        this.firstName = Reader.json(fileName).get("firstName").toString();
        this.lastName = Reader.json(fileName).get("lastName").toString();
        this.zipCode = Reader.json(fileName).get("zipCode").toString();
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getZipCode() {
        return zipCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
