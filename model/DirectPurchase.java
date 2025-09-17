package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import exception.MyException;
import model.Drug;

public class DirectPurchase {

    private static DateTimeFormatter calendar;
    private Drug drug;
    private double price;
    private int quantity;
    private LocalDateTime purchaseDate;
    private double amount;
    public static ArrayList<DirectPurchase> directPurchaseList;



    public DirectPurchase(LocalDateTime purchaseDate, Drug drug, int quantity, double price) throws MyException {
        this.setPurchaseDate(purchaseDate);
        this.setDrug(drug);
        this.setPrice(price);
        this.setQuantity(quantity);

    }

    public Drug getDrug() {
        return this.drug;
    }

    public void setDrug(Drug drug) throws MyException {
        if (drug == null) {
            throw new MyException("Le médicament n'existe pas, veuillez entrer un médicament valide. ");
        } else {
            this.drug = drug;
        }
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setTotal(double amount) {
        this.amount = amount;
    }

    public ArrayList<DirectPurchase> getDirectPurchaseList() {
        return this.directPurchaseList;
    }

    public void setDirectPurchaseList(ArrayList<DirectPurchase> directPurchaseList) {
        this.directPurchaseList = directPurchaseList;
    }


//    /**
//     * RESEARCH DIRECT PURCHASE BY DATE
//     * @param
//     * @return DirectPurchase
//     */
//    public static DirectPurchase searchDirectPurchase(LocalDate getPurchaseDate)  {
//        for (int i = 0; i < directPurchaseList.size(); i++) {
//            if (getPurchaseDate.isEqual(LocalDate )) {
//                return directPurchaseList.get(i);
//            }
//        }
//        return null;
//    }

    /**
     * ADD DIRECT PURCHASE , RUN WELL ONE TIME, NEED DEBUGG IN MAIN
     * @param DirectPurchase
     */
    public static void addDirectPurchase(DirectPurchase DirectPurchase) {
        directPurchaseList.add(DirectPurchase);

        System.out.println(" L'achat direct suivant a été ajouté : " + DirectPurchase.toString());
    }


    @Override
    public String toString() {
        return "DirectPurchase { " +
                "drug=" + getDrug() +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", purchaseDate=" + getPurchaseDate() +
                ", directPurchaseList=" + getDirectPurchaseList() +
                '}';
    }
}




