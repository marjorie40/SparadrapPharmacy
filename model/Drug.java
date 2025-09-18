package model;

import exception.MyException;

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


    /**
     * CONSTRUCTOR FOR DRUG
     * @param name
     * @param category
     * @param price
     * @param quantity
     * @param startDate
     * @throws MyException
     */
    public Drug(String name, String category,double price, int quantity,LocalDate startDate) throws MyException{
    this.setName(name);
    this.setCategory(category);
    this.setPrice(price);
    this.setQuantity(quantity);
    this.setStartDate(startDate);
}

    /**
     * RETURN THE NAME OF THE DRUG
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * DEFINE THE NAME OF THE DRUG
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * RETURN THE CATEGORY
     * @return
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * DEFINE THE CATEGORY OF THE DRUG
     * @param category
     * @throws MyException null
     */
    public void setCategory(String category) throws MyException {
        if (category == null) {
            throw new MyException("La catégorie n'est pas valide.");
        } else {
            this.category = category;
        }
    }

    /**
     * RETURN THE PRICE OF THE DRUG
     * @return
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * DEFINE THE PRICE OF THE DRUG
     * @param price
     * @throws MyException
     */
    public void setPrice(double price) throws MyException {
        if (price < 0.00) {
            throw new MyException("Le prix est invalide.");
        } else {
            this.price = price;
        }
    }

    /**
     * RETURN THE QUANTITY OF THE DRUG
     * @return
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * DEFINE THE QUANTITY OF THE DRUG
     * @param quantity
     * @throws MyException
     */
    public void setQuantity(int quantity) throws MyException {
        if (quantity < 0) {
            throw new MyException("Impossible, la quantité est négative. ");
        } else {
            this.quantity = quantity;
        }
    }

    /**
     * RETURN THE START DATE OF THE DRUG
     * @return startDate
     */
    public LocalDate getStartDate() {
        return this.startDate;
    }

    /**
     * SET THE START DATE OF THE DRUG
     * @param startDate
     * @throws MyException
     */
    public void setStartDate(LocalDate startDate)  throws MyException {
        if (startDate == null) {
            throw new MyException("La date est inexistante.");
        } else {
            this.startDate = startDate;
        }
    }

    /**
     * RETURN THE DRUG LIST
     * @return drugsList
     */
    public ArrayList <Drug> getDrugs() {
        return drugsList;
        }

    /**
     * DEFINE THE DRUG LIST
     * @param drugsList
     */
    public void setDrugsList(ArrayList<Drug> drugsList) {
        this.drugsList = drugsList;
        }

    /**
     * RETURN THE DRUG LIST FOR PRESCRIPTION
     * @return drugsForPrescription
     */
    public static ArrayList<Drug> getDrugsForPrescription() {
        return drugsForPrescription;
    }

    /**
     * DEFINE THE DRUG LIST FOR PRESCRIPTION
     * @param drugsForPrescription
     */
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
     * * ADD DRUG , RUN WELL ONE TIME, NEED DEBUGG IN MAIN
     * @param Drug
     */
    public static void addDrug(Drug Drug) {
        drugsList.add(Drug);
        System.out.println("Le nouveau médicament est ajouté : " + Drug.toString());
    }

    /**
     * REMOVE A DRUG
     * @param Drug
     */
    public static void removeDrug(Drug Drug) {
        drugsList.remove(Drug);
    }

    /**
     * UPDATE DRUG
     * @param Drug
     */
    public static void updatePhysician(Drug Drug) {
        drugsList.add(Drug);
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




