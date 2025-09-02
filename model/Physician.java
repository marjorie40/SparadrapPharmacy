package model;

import exception.MyException;

import java.util.ArrayList;

public class Physician extends People {
    private String rpps;
    private String REGEX_RPPS = "^[0-9]{12}$";

    public static ArrayList<Physician> listPhysicians = new ArrayList<Physician>();

    public Physician(String lastName, String firstName,  String email, String phoneNumber, String address,
                    String city, String postCode,String rpps) throws MyException {
        super(lastName,firstName, email,phoneNumber, address, city, postCode);
        this.setRpps(rpps);
    }


    public String getRpps() {
        return rpps;
    }
    public void setRpps(String rpps) throws MyException {
        if(rpps==null || !rpps.matches(REGEX_RPPS) || rpps.isEmpty()){
            throw new MyException("Le numéro RPPS est invalide, veuillez recommencer la saisie, merci. ");
        } else {
            this.rpps = rpps;
        }
    }

    public void readPhysicians() throws MyException {
        if(listPhysicians.isEmpty()){
            throw new MyException("La liste des médecins est vide, veuillez créer un nouveau médecin.");
        } else {
        for (int i = 0; i < listPhysicians.size(); i++) {
            System.out.println(listPhysicians);
            }
        }
    }
}
