package model;

import exception.MyException;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prescription {
    private int number;
    private LocalDate today;
    private Physician physician;
    private Patient patient;
    private Drug drug;
    private ArrayList<Drug> drugForPrescription;


    public Prescription(int number, LocalDate today, Physician physician, Patient patient,
                        Drug drug,ArrayList<Drug> drugForPrescription) {
        this.setToday(today);
        this.setPhysician(physician);
        this.setPatient(patient);
        this.setDrugForPrescription(drugForPrescription);
    }


    public static ArrayList<Prescription> prescriptionList =  new ArrayList<Prescription> ();

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getToday() {
        return this.today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public Physician getPhysician() {
        return this.physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ArrayList<Drug> getDrugForPrescription() {
        return this.drugForPrescription;
    }

    public void setDrugForPrescription(ArrayList<Drug> drugForPrescription) {
        this.drugForPrescription = drugForPrescription;
    }

    /**
     * RESEARCH PRESCRIPTION BY PATIENT // not ops
     *
     * @throws MyException
     */
    public static Prescription searchPrescriptionByPatient(String getLastName) throws MyException {
        if (getLastName.isEmpty() ) {
            throw new MyException("L'ordonnance pour ce patient n'existe pas");
        } else {
            for (int i =0 ; i<prescriptionList.size(); i++ ) {
                if (prescriptionList.get(i).getPatient().getLastName().equalsIgnoreCase(getLastName)) {
                    System.out.println(prescriptionList.get(i).getPatient().getLastName());
                }
            }
        }
        return prescriptionList.get(prescriptionList.size()-1);
    }

    /**
     * ADD PRESCRIPTION
     * @param prescription
     * @throws MyException
     */
    public static void addPrescription(Prescription prescription) throws MyException {
        if (prescription == null) {
            throw new MyException("L'ordonnance n'existe pas");
        } else {
            prescriptionList.add(prescription);
            System.out.println("Ordonnance ajoutée : " + prescription.toString());
        }
    }

    @Override
    public String toString() {
        return " n° : " + getNumber() +
                " date d'émission : " + getToday() +
                ", médecin prescripteur : " + getPhysician().getLastName().toUpperCase() + "-" +getPhysician().getFirstName().toLowerCase() +
                ", patient = " + getPatient().getLastName().toUpperCase() + " - " + getPatient().getFirstName().toLowerCase() +
                ", Médicament(s) = " + getDrugForPrescription() +
                '}';
    }
}





