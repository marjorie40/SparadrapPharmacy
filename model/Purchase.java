package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Purchase {

    private LocalDate dateOfPurchase =  LocalDate.now();
    private Prescription prescription;
    private int quantity;
    private double sum ; // = sum of drugs prices
    private double total = 0; // = sum - (sum * coef mutuelle)

    public ArrayList<Purchase> purchaseList = new ArrayList<>();

    public LocalDate getDateOfPurchase() {
        return this.dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = LocalDate.now();
    }

    public Prescription getPrescription() {
        return this.prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public double getSum() {
        return this.sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Purchase> getPurchaseList() {
        return this.purchaseList;
    }

    public void setPurchaseList(ArrayList<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public Purchase(LocalDate dateOfPurchase, Prescription prescription, double sum, double total ) {
        this.dateOfPurchase = LocalDate.now();
        this.setPrescription (prescription);
        this.setSum(sum);
        this.setTotal(total);


    }
}
