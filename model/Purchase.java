package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Purchase {

    private boolean document = true;
    private ArrayList<Prescription> prescriptionList;
    private LocalDate purchaseDate = LocalDate.now();
    private Prescription prescription;
    private int quantity;
    private double sum; // = sum of drugs prices
    private double total = 0; // = sum - (sum * coef mutuelle)

    public static ArrayList<Purchase> purchaseList = new ArrayList<>();

    public Purchase(LocalDate purchaseDate, Prescription prescription, int quantity, double sum) {
        this.setPurchaseDate(purchaseDate);
        this.setPrescription(prescription);
        this.setSum(sum);
        this.setTotal(total);
    }

    public LocalDate getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
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


    /**
     * ADD PURCHASE
     * @param purchase
     */
    public static void addPurchase(Purchase purchase) {
        purchaseList.add(purchase);

        System.out.println(" Achat ajouté : " + purchase.toString());
    }


    /**
     * RESEARCH PURCHASE BY DATE
     * @param purchaseDate,purchaseList
     * @return purchase
     */
    public static Purchase searchPurchase(LocalDate purchaseDate, ArrayList<Purchase> purchaseList) {
        for (Purchase purchase : purchaseList) {
            if (purchaseDate.isEqual(purchase.getPurchaseDate())) {
                return purchase;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Purchase {" +
                "Date de l'achat : " + getPurchaseDate() +
                ", ordonnance =" + getPrescription() +
                ", date de l'ordonnance : " +getPrescription().getToday() +
                ", quantity=" + quantity +
                ", sum=" + getSum() +
                ", purchaseList=" + getPurchaseList() +
                '}';
    }

}
