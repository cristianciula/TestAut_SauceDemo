package testdata;

import utils.Reader;

public class UserData {

    private String firstName;
    private String lastName;
    private String zipCode;
    private String creditCard;
    private String shippingInfo;

    public UserData(String fileName) {
        this.firstName = Reader.json(fileName).get("firstName").toString();
        this.lastName = Reader.json(fileName).get("lastName").toString();
        this.zipCode = Reader.json(fileName).get("zipCode").toString();
        this.creditCard = Reader.json(fileName).get("creditCard").toString();
        this.shippingInfo = Reader.json(fileName).get("shippingInfo").toString();
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
        return creditCard;
    }
    public String getShippingInfo() {
        return shippingInfo;
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
        this.creditCard = creditCard;
    }
    public void setShippingInfo(String shipping) {
        this.shippingInfo = shipping;
    }
}
