package model;

import exception.MyException;
import model.Category;

import java.time.LocalDate;
import java.util.ArrayList;

public class Drug {
    private String name;
    private String category;
    private double price;
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

    public  String getName() {
        return this.name;
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
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) throws MyException {
        if (price < 0.00) {
            throw new MyException("Le prix est invalide.");
        } else {
            this.price = price;
        }
    }

    public int getQuantity() {
        return this.quantity;
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

    /**
     * RESEARCH DRUG BY NAME
     * @param getName
     * @return
     * @throws MyException
     */
    public static Drug searchDrug(String getName) throws MyException {
        if (getName == null) {
            throw new MyException("Le nom du médicament est n'existe pas. ");
        } else {
            for (int i = 0; i < drugsList.size(); i++){
                if (drugsList.get(i).getName().equals(getName.trim().toLowerCase())) ;
                return drugsList.get(i);
            }
        }
        return null;
    }

    /**
     * TO STRING METHODE
     * @return
     */

    @Override
    public String toString() {
        return "Médicament {" +
                "Nom :'" + getName() + '\'' +
                ", catégorie :'" + getCategory() + '\'' +
                ", Tarif unitaire = €" + getPrice() +
                ", quantité =" + getQuantity() +
                //", Date de mise en service : " + getStartDate() +
                '}';
    }
}




