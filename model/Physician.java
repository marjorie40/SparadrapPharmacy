package model;

import exception.MyException;

import java.util.ArrayList;

public class Physician extends People {
    private String rpps;
    private String REGEX_RPPS = "^[0-9]{12}$";

    public static ArrayList<Physician> listPhysicians = new ArrayList<Physician>();


    /**
     * CONSTRUCTOR PHYSICIAN extends PEOPLE
     * @param lastName
     * @param firstName
     * @param email
     * @param phoneNumber
     * @param address
     * @param postCode
     * @param city
     * @param rpps
     * @throws MyException
     */
    public Physician(String lastName, String firstName, String email, String phoneNumber, String address,
                    String postCode, String city, String rpps) throws MyException {
        super(lastName, firstName, email, phoneNumber, address, postCode, city);
        this.setRpps(rpps);
    }

    /**
     * RETURN RPPS number
     * @return
     */
    public String getRpps() {
        return rpps;
    }

    /**
     * DEFINE THE RPPS NUMBER
     * @param rpps
     * @throws MyException REGEX 13 digits mandatory , null , empty
     */
    public void setRpps(String rpps) throws MyException {
        if (rpps == null || !rpps.matches(REGEX_RPPS) || rpps.isEmpty()) {
            throw new MyException("Le numéro RPPS est invalide, veuillez recommencer la saisie, merci. ");
        } else {
            this.rpps = rpps;
        }
    }

    /**
     * RETURN LIST OF PHYSICIANS
     * @return
     */
    public static ArrayList<Physician> getPhysicians() {
        return listPhysicians;
    }



    /**
     * RESEARCH PHYSICIAN BY THE LAST NAME
     * @param getLastName
     * @return Physician
     */
    public static Physician searchPhysician(String getLastName)  {
        for (int i = 0; i < listPhysicians.size(); i++) {
            if (listPhysicians.get(i).getLastName().equals(getLastName.trim().toLowerCase())) {
                return listPhysicians.get(i);
            }
        }
        return null;
    }

    /**
     * ADD PHYSICIAN , RUN WELL ONE TIME, NEED DEBUGG IN MAIN
     * @param Physician
     */
    public static void addPhysician(Physician Physician) {
        listPhysicians.add(Physician);

        System.out.println(" Médecin ajouté : " + Physician.toString());
    }


    /**
     * REMOVE A PHYSICIAN
     * @param Physician
     */
    public static void removePhysician(Physician Physician) {
        listPhysicians.remove(Physician);
    }

    /**
     * UPDATE Physician
     * @param Physician
     */
    public static void updatePhysician(Physician Physician) {
        listPhysicians.add(Physician);
    }


    @Override
    public String toString() {
        return "Docteur {" + this.getLastName() +" "+ this.getFirstName() +
                ", adresse : " + this.getAddress() + ", " + this.getPostCode() + " " + this.getCity() +
                ", Email : " + this.getEmail() +
                ", Téléphone : " + this.getPhoneNumber() +
                " // N° RPPS = " + this.getRpps() + "}";
    }
}
