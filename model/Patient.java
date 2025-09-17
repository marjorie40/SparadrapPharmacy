package model;

import exception.MyException;

import java.time.LocalDate;
import java.util.ArrayList;


public class Patient extends People {
    private String socialSecurityNumber;
    private LocalDate dateOfBirth;
    private Mutual mutual;
    private Physician physician;
    private Prescription prescription;
    private String REGEX_SOCIALNUM = "^[0-9]{13}$";
    private String REGEX_IDENTITE = "^[A-Za-zÀ-ÖØ-öø-ÿ]+(?:[- ][A-Za-zÀ-ÖØ-öø-ÿ]+)*$";

    public static ArrayList<Patient> listPatients = new ArrayList<Patient>();

    public Patient (String lastName, String firstName, LocalDate dateOfBirth, String email,
                    String phoneNumber, String address, String postCode, String city,
                    String socialSecurityNumber, Physician physician, Mutual mutual ) throws MyException {
        super(lastName, firstName, email, phoneNumber, address, postCode, city);
        this.setDateOfBirth(dateOfBirth);
        this.setSocialSecurityNumber (socialSecurityNumber);
        this.setPhysician (physician);
        this.setMutual(mutual);
    }

    /**
     * RETURN THE SOCIAL SECURITY NUMBER
     * @return
     */
    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    /**
     *
     * @param socialSecurityNumber
     * @throws MyException
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) throws MyException {
        if (socialSecurityNumber == null || socialSecurityNumber.isEmpty()
                || !socialSecurityNumber.matches(REGEX_SOCIALNUM)) {
            throw new MyException("Le numéro de sécurité social n'est pas valide ! Veuillez saisir un nombre à 13 chiffres");
        }
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) throws MyException {
        if (dateOfBirth == null ) {
            throw new MyException("La date de naissance n'est pas valide, veuillez saisir une date au format : AAAA-MM-JJ .");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public Mutual getMutual() {
        return this.mutual;
    }
    public void setMutual(Mutual mutual) throws MyException {
        if (mutual == null) {
            throw new MyException("La mutuelle n'est pas valide.");
        }
        this.mutual = mutual;
    }

    public Physician getPhysician() {
        return this.physician;
    }
    public void setPhysician(Physician physician) throws MyException {
        if (physician == null ) { //|| !physician.matches(REGEX_IDENTITE)
            throw new MyException("La saisie de l'identité du médecin est invalide, veuiller réessayer. ");
        }
        this.physician = physician;
    }

    public Prescription getPrescription() {
        return this.prescription;
    }

    public void setPrescription(Prescription prescription) {
            this.prescription = prescription;
        }


    public static ArrayList<Patient> getListPatients() {
        return listPatients;
    }
    public static void setListPatients(ArrayList<Patient> listPatients) throws MyException {
        if (listPatients == null) {
            throw new MyException("Il n'y a pas de patient dans la liste. Veuillez ajouter des patients. ");
        }
        Patient.listPatients = listPatients;
    }


    /**
     * ADD PATIENT , RUN WELL ONE TIME, NEED DEBUGG IN MAIN
     * @param Patient
     */
    public static void addPatient(Patient Patient) {
        listPatients.add(Patient);
        System.out.println("Le nouveau patient est ajouté : " + Patient.toString());
    }

    /**
     * RESEARCH PATIENT BY THE LAST NAME
     * @param getLastName
     * @return Physician
     */
    public static Patient searchPatient(String getLastName)  {
        for (int i = 0; i < listPatients.size(); i++) {
            if (listPatients.get(i).getLastName().equals(getLastName.trim().toLowerCase())) {
                return listPatients.get(i);
            }
        }
        return null;
    }

    public static void removePatient(Patient Patient) {
        listPatients.remove(Patient);
    }

    @Override
    public String toString() {
        return "Patient { "+ this.getLastName()+" " + this.getFirstName()+
                ", adresse " + this.getAddress() + ", " + this.getPostCode() + " " + this.getCity() +
                ", date de naissance : " + this.getDateOfBirth() +
                ", Email : " + this.getEmail() +
                ", Téléphone : " +  this.getPhoneNumber() +
                " N° Sécurité Social = " + this.getSocialSecurityNumber() + '\'' +
                ", Mutuelle : " + this.getMutual().getName() + '\'' +
                ", Médecin Traitant : Dr " + this.getPhysician() + '\'' +
                '}';
    }
}
