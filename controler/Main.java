package controler;

import exception.MyException;
import model.Physician;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Hello and welcome to the Sparadrap Pharmacy Management System :)");
    }
    Physician physician;

    {
        try {
            physician = new Physician("Doe", "John","john@doe.fr",
                    "0383032020","4 rue de rien", "Nancy","54000","541525653285" );
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }
}