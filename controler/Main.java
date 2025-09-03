package controler;

import exception.MyException;
import model.Patient;
import model.Physician;
import view.PharmaSee;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import static model.Physician.getPhysicians;
import static model.Physician.listPhysicians;


public class Main {




    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws MyException {
        datasInside();
        System.out.println("Hello and welcome to the Sparadrap Pharmacy Management System :)");
        PharmaSee.afficheMessage("***********  Bienvenue  **********", 1);



        PharmaSee.displayListPhysician(listPhysicians);
        PharmaSee.createPhysician();
        try {
            Physician physician = new Physician (PharmaSee.getLastName(),PharmaSee.getFirstName(),
                    PharmaSee.getEmail(), PharmaSee.getPhoneNumber(),
                    PharmaSee.getAddress(), PharmaSee.getPostCode(), PharmaSee.getCity(),
                    PharmaSee.getRpps());

            Physician.listPhysicians.add(physician);


        } catch (MyException e) {
            PharmaSee.afficheMessage("Une erreur est survenue !! " + e.getMessage(), 1);
        }

        PharmaSee.displayListPhysician(listPhysicians);


//ok        PharmaSee.init("non");
    }

        /**
         * LIBRARY INSIDE THE APP WITH PHYSICIANS, PATIENTS, DRUGS,PRESCRIPTIONS, MUTUALS,
         */
        public static void datasInside() throws MyException {

            Physician physician1 = new Physician("Whos", "John","john@whos.dr",
                    "0383232521","1 allée fleurie","54000","Nancy", "321564587956");
            Physician physician2 = new Physician("That", "John","john@that.dr",
                    "0383232521","2 allée fleurie","54000","Nancy", "321564587021");
            Physician physician3 = new Physician("Girl", "John","john@girl.dr",
                    "0383232521","3 allée fleurie","54000","Nancy", "321564584517");

            Physician.listPhysicians.add(physician1);
            Physician.listPhysicians.add(physician2);
            Physician.listPhysicians.add(physician3);









            }
        }


//        Physician physician;
//        try {
//            physician = new Physician("Doe", "John", "john@doe.fr",
//                    "0383032020", "4 rue de rien,", "54000","Nancy", "541525653285");
//        } catch (MyException e) {
//            throw new RuntimeException(e);
//        }

