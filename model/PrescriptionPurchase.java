package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PrescriptionPurchase extends DirectPurchase {

    private Patient patient;
    private ArrayList<Prescription> prescriptionsList;
    public PrescriptionPurchase(LocalDateTime purchaseDate, Drug drug, int quantity, double price,
                                Patient patient, ArrayList<Prescription> prescriptionsList) throws Exception {
        super(purchaseDate,drug, quantity,price);
        this.setPatient (patient);
    }

    /**
     * DEFINE THE PATIENT
     * @param patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * RETURN THE PATIENT
     * @return
     */
    public Patient getPatient() {
        return this.patient;
    }

    /**
     * DEFINE THE LISTE OF PRESCRIPTIONS
     * @param prescriptionsList
     */
    public void setPrescriptions(ArrayList<Prescription> prescriptionsList) {
        this.prescriptionsList = prescriptionsList;
    }

    /**
     * RETURN THE PRESCRIPTIONS PRESCRIPTIONSLIST
     * @return
     */
    public ArrayList<Prescription> getPrescriptionsList() {
        return this.prescriptionsList;
    }

    @Override
    public String toString() {
        return " L'achat avec ordonnance : " +this.getPurchaseDate() + this.getDrug()+
                ",quantité : "+getQuantity()   + " prix : " + getPrice() +
                " -->le patient : M. ou Mme " + getPatient().getLastName() + getPatient().getFirstName() +
                " { Médecin : Dr " +getPatient().getPhysician().getLastName() +
                ", prescriptionsList=" + prescriptionsList +
                '}';
    }
}
