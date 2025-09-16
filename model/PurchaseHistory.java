package model;

import exception.MyException;

import java.time.LocalDate;
import java.util.ArrayList;

public class PurchaseHistory {


    public static ArrayList<Purchase> purchaseHistoryList = new ArrayList<>();

    /**
     * CONSTRUCTOR WITH ARRAYLIST OF PURCHASE FOR THE HISTORY
     * @param purchaseHistoryList
     * @throws MyException
     */
    public PurchaseHistory(ArrayList<Purchase> purchaseHistoryList) throws MyException {
        this.setPurchaseHistoryList (purchaseHistoryList);
    }

    /**
     * RETURN THE PURCHASE HISTORY LIST
     * @return purchaseHistoryList
     */
    public static ArrayList<Purchase> getPurchaseHistoryList() {
        return purchaseHistoryList;
    }


    /**
     * DEFINE THE PURCHASE LIST HISTORY
     * @param purchaseHistoryList
     * @throws MyException
     */
    public void setPurchaseHistoryList(ArrayList<Purchase> purchaseHistoryList) throws MyException {
        if (purchaseHistoryList == null) {
            throw new MyException("Aucune liste d'achat dans l'historique.");
        } else {
            this.purchaseHistoryList = purchaseHistoryList;
        }
    }

    /**
     * ADD A PURCHASE IN THE PURCHASE HISTORY LIST
     * @param purchase
     */
    public void addPurchaseHistory(Purchase purchase) {
        this.purchaseHistoryList.add(purchase);
    }

    /**
     * COLLECT AND DISPLAY THE LIST OF PURCHASES FOR ONE DAY
     * @param oneDay
     * @return purchaseByDay
     */
    public static ArrayList<Purchase> getPurchasesByDay(LocalDate oneDay) {
        ArrayList<Purchase> purchaseByDay = new ArrayList<>();
        for (Purchase purchase : purchaseHistoryList) {
            if ((purchase.getPurchaseDate().equals(oneDay))) {
                purchaseByDay.add(purchase);
            }
        }
        return purchaseByDay;
    }

    /**
     * COLLECT AND DISPLAY THE LIST OF TODAY'S PURCHASES
     * @param today
     * @return getPurchasesByDay for today
     */
    public ArrayList<Purchase> getPurchasesToday(LocalDate today) {
        return getPurchasesByDay(LocalDate.now());
    }

    /**
     * COLLECT AND DISPLAY THE LIST OF PURCHASES IN A PERIOD - BETWEEN A START DATE & AN END DATE
     * @param startDate
     * @param endDate
     * @return purchaseByPeriod
     */
    public static ArrayList<Purchase> getPurchasesByPeriod(LocalDate startDate,  LocalDate endDate) {
        ArrayList<Purchase> purchaseByPeriod = new ArrayList<>();
        for (Purchase purchase : purchaseHistoryList) {
            if ((purchase.getPurchaseDate().isAfter(startDate) && purchase.getPurchaseDate().isBefore(endDate))) {
                purchaseByPeriod.add(purchase);
            }
        }
        return purchaseByPeriod;
    }


}

