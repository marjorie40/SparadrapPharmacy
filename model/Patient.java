package model;

import exception.MyException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Patient extends People {
    private String socialSecurityNumber;
    private LocalDate dateOfBirth = LocalDate.now();
    private Mutual mutual;
    private String referingPhysician;
    private String REGEX_SOCIALNUM = "^[0-9]{13}$";
    private String REGEX_IDENTITE = "^[A-Za-zÀ-ÖØ-öø-ÿ]+(?:[- ][A-Za-zÀ-ÖØ-öø-ÿ]+)*$";

    public static ArrayList<Patient> listPatients = new ArrayList<Patient>();

    public Patient (String lastName, String firstName, LocalDate dateOfBirth, String email,
                    String phoneNumber, String address, String postCode, String city,
                    String socialSecurityNumber, String referingPhysician, Mutual mutual ) throws MyException {
        super(lastName, firstName, email, phoneNumber, address, postCode, city);
        this.setDateOfBirth(dateOfBirth);
        this.setSocialSecurityNumber (socialSecurityNumber);
        this.setReferingPhysician (referingPhysician);
        this.setMutual(mutual);
    }

    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }
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

    public String getReferingPhysician() {
        return this.referingPhysician;
    }
    public void setReferingPhysician(String referingPhysician) throws MyException {
        if (referingPhysician == null || referingPhysician.isEmpty() || !referingPhysician.matches(REGEX_IDENTITE)) {
            throw new MyException("La saisie de l'identité du médecin est invalide, veuiller réessayer. ");
        }
        this.referingPhysician = referingPhysician;
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


    @Override
    public String toString() {
        return "Patient{ "+ this.getLastName()+" " + this.getFirstName()+
                ", adresse " + this.getAddress() + ", " + this.getPostCode() + " " + this.getCity() +
                ", date de naissance : " + this.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", Email : " + this.getEmail() +
                ", Téléphone : " +  this.getPhoneNumber() +
                " N° Sécurité Social = " + this.getSocialSecurityNumber() + '\'' +
                ", Mutuelle : " + this.getMutual() +
                ", Médecin Traitant : Dr " + this.getReferingPhysician() + '\'' +
                '}';
    }
}
