package model;

import exception.MyException;

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

    public Purchase(LocalDate purchaseDate, Prescription prescription, int quantity, double sum)throws MyException {
        this.setPurchaseDate(purchaseDate);
        this.setPrescription(prescription);
        this.setQuantity(quantity);
        this.setSum(sum);
        this.setTotal(total);
    }

    public LocalDate getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate)  {

        this.purchaseDate = purchaseDate;
    }

    public Prescription getPrescription() {
        return this.prescription;
    }

    public void setPrescription(Prescription prescription) throws MyException {
        if (prescription == null) {
            throw new MyException("Il n'y a pas de prescription.");
        } else {
            this.prescription = prescription;
        }
    }

    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) throws MyException {
        if (quantity < 0) {
            throw new MyException("La quantité est négative");
        } else {
            this.quantity = quantity;
        }
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
//    public static deletePurchase() {
//
//    }


    @Override
    public String toString() {
        return "Purchase { Patient " + getPrescription().getPatient().getLastName().toUpperCase() +
                " " +  getPrescription().getPatient().getFirstName().toLowerCase() +
                " --> Date de l'achat : " + getPurchaseDate() +
                ", ordonnance du Dr " + getPrescription().getPhysician().getLastName().toUpperCase() +
                ", date de l'ordonnance : " +getPrescription().getToday() +
                ",--> Médicaments :  " +getPrescription().getDrugForPrescription()+
                ", quantity=" + getQuantity () +
                ", sum=" + getSum() +
                //", purchaseList=" + getPurchaseList().get(1) +
                '}';
    }

}
