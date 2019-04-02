package wap.model;

public class ConfirmCheckout {

    private String firstname;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String cardname;
    private String cardnumber;
    private String expmonth;
    private String expyear;
    private String cvv;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getExpyear() {
        return expyear;
    }

    public void setExpyear(String expyear) {
        this.expyear = expyear;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpmonth() {
        return expmonth;
    }

    public void setExpmonth(String expmonth) {
        this.expmonth = expmonth;
    }

    @Override
    public String toString() {
        return "ConfirmCheckout{" +
                "firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", cardname='" + cardname + '\'' +
                ", cardnumber='" + cardnumber + '\'' +
                ", expmonth='" + expmonth + '\'' +
                ", expyear='" + expyear + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
