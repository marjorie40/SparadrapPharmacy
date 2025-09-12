package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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


    public ArrayList<Prescription> prescriptionList =  new ArrayList<Prescription> ();

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

    @Override
    public String toString() {
        return "Ordonnance n° : " + getNumber() +
                "date d'émission : " + getToday() +
                ", médecin prescripteur : " + getPhysician() +
                ", patient = " + getPatient() +
                ", Médicament(s) = " + getDrugForPrescription() +
                '}';
    }
}





