package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Prescription {
    private LocalDate today = LocalDate.parse("Date d'émission : ", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    private Physician physician;
    private Patient patient;
    private ArrayList<Drug> drugs;


    public Prescription(LocalDate today, Physician physician, Patient patient, ArrayList<Drug> drugs) {
        this.setToday(today);
        this.setPhysician(physician);
        this.setPatient(patient);
        this.setDrugs(drugs);
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

    public ArrayList<Drug> getDrugs() {
        return this.drugs;
    }

    public void setDrugs(ArrayList<Drug> drugs) {
        this.drugs = drugs;
    }

    @Override
    public String toString() {
        return "Ordonnance { " +
                "date d'emission : " + getToday() +
                ", médecin prescripteur : " + getPhysician() +
                ", patient = " + getPatient() +
                ", Médicament(s) = " + getDrugs() +
                '}';
    }
}





