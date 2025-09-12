package model;

import exception.MyException;
import model.Category;

import java.time.LocalDate;
import java.util.ArrayList;

public class Drug {
    private static String name;
    private String category;
    private static double price;
    private int quantity;
    private LocalDate startDate;

    public static ArrayList<Drug> drugsList = new ArrayList<>();
    public static ArrayList<Drug> drugsForPrescription = new ArrayList<>();




public Drug(String name, String category,double price, int quantity,LocalDate startDate) throws MyException{
    this.setName(name);
    this.setCategory(category);
    this.setPrice(price);
    this.setQuantity(quantity);
    this.setStartDate(startDate);

}

    public static String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }

    public String getCategory() {
    return this.category;
    }

    public void setCategory(String category) throws MyException {
        if (category == null) {
            throw new MyException("La catégorie n'est pas valide.");
        } else {
            this.category = category;
        }
    }
    public static double getPrice() {
        return price;
    }

    public void setPrice(double price) throws MyException {
        if (price < 0.00) {
            throw new MyException("Le prix est invalide.");
        } else {
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws MyException {
        if (quantity < 0) {
            throw new MyException("Impossible, la quantité est négative. ");
        } else {
            this.quantity = quantity;
        }
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate)  throws MyException {
        if (startDate == null) {
            throw new MyException("La date est inexistante.");
        } else {
            this.startDate = startDate;
        }
    }
    public ArrayList <Drug> getDrugs() {

    return drugsList;
    }

    public void setDrugsList(ArrayList<Drug> drugsList) {

    this.drugsList = drugsList;
    }

    public static ArrayList<Drug> getDrugsForPrescription() {
        return drugsForPrescription;
    }

    public static void setDrugsForPrescription(ArrayList<Drug> drugsForPrescription) {
        Drug.drugsForPrescription = drugsForPrescription;
    }

    @Override
    public String toString() {
        return "Médicament {" +
                "Nom :'" + getName() + '\'' +
                ", catégorie :'" + getCategory() + '\'' +
                ", Tarif unitaire = €" + getPrice() +
                ", quantité =" + getQuantity() +
                ", Date de mise en service : " + getStartDate() +
                '}';
    }
}




