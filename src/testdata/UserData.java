package testdata;

import utils.Reader;

public class UserData {

    private String firstName;
    private String lastName;
    private String zipCode;
    private String cardDetails;

    public UserData(String fileName) {
        this.firstName = Reader.json(fileName).get("firstName").toString();
        this.lastName = Reader.json(fileName).get("lastName").toString();
        this.zipCode = Reader.json(fileName).get("zipCode").toString();
        this.cardDetails = Reader.json(fileName).get("cardDetails").toString();
    }

    //GETTERS
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getZipCode() {
        return zipCode;
    }
    public String getCreditCard() {
        return cardDetails;
    }

    //SETTERS
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public void setCreditCard(String creditCard) {
        this.cardDetails = creditCard;
    }
}
