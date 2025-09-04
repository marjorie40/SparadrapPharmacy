package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Purchase {

    boolean document = true;
    LocalDate dateOfPurchase =  LocalDate.now();
    Prescription prescription;
    private ArrayList<Drug> drugs;
    int quantity;
    double sum;




}
