package model;

import exception.MyException;

public class People {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String postCode;
    private String REGEX_IDENTITE = "^[A-Za-zÀ-ÖØ-öø-ÿ]+(?:[- ][A-Za-zÀ-ÖØ-öø-ÿ]+)*$";
    private String REGEX_PHONE = "^(?:(?:\\+33|0)\\d{9})$|^(?:\\+33\\d{10})$";
    private String REGEX_EMAIL = "^[a-zA-Z0-9._+-]+[@]+[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$";
    private String REGEX_ADDRESS = "^[a-zA-Z]{2,}$";
    private String REGEX_POSTCODE = "^(\\d{5})?$";


    public People(String lastName, String firstName,  String email, String phoneNumber, String address,
                String city, String postCode) throws MyException {
        this.setLastName (lastName);
        this.setFirstName(firstName);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setAddress(address);
        this.setCity(city);
        this.setPostCode(postCode);

    }

    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) throws MyException{
        if (lastName==null || !lastName.matches(REGEX_IDENTITE) || lastName.isEmpty() ) {
            throw new MyException("La saisie du nom est invalide, veuillez recommencer, merci. ");
        } else {
        this.lastName = lastName;
        }
    }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) throws MyException{
        if (firstName==null || !firstName.matches(REGEX_IDENTITE) || firstName.isEmpty() ) {
            throw new MyException("La saisie du prénom est invalide, veuillez recommencer, merci. ");
        } else {
            this.firstName = firstName;
        }
    }


    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) throws MyException{
        if (email==null || !email.matches(REGEX_EMAIL) || email.isEmpty() ) {
            throw new MyException("La saisie du nom est invalide, veuillez recommencer, merci. ");
        } else {
            this.email = email;
        }
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) throws MyException{
        if (phoneNumber==null || !phoneNumber.matches(REGEX_PHONE) || phoneNumber.isEmpty() ) {
            throw new MyException("La saisie du numéro de téléphone est invalide, veuillez recommencer, merci. ");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) throws MyException{
        if (address==null || !address.matches(REGEX_ADDRESS) || address.isEmpty() ) {
            throw new MyException("La saisie de l'adresse est invalide, " +
                    "PENSEZ A LA VIRGULE, veuillez recommencer, merci. ");
        } else {
        this.address = address;
        }
    }

    public String getCity() {
        return this.city;
    }
    public void setCity(String city) throws MyException{
        if (city==null || !city.matches(REGEX_ADDRESS) || city.isEmpty() ) {
            throw new MyException("La saisie de la ville est invalide, veuillez recommencer, merci. ");
        } else {
            this.city = city;
        }
    }

    public String getPostCode() {
        return this.postCode;
    }
    public void setPostCode(String postCode) throws MyException{
        if (postCode==null || !postCode.matches(REGEX_POSTCODE) || postCode.isEmpty() ) {
            throw new MyException("La saisie du code postal est invalide, veuillez recommencer, merci. ");
        } else {
            this.postCode = postCode;
        }
    }

}
