package controler;

import exception.MyException;
import model.*;
import view.PharmaSee;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import static model.Drug.*;
import static model.Mutual.mutualList;
import static model.Patient.listPatients;
import static model.Physician.*;
import static model.Prescription.prescriptionList;
import static model.Purchase.purchaseList;
import static model.PurchaseHistory.purchaseHistoryList;


public class Main {


    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws MyException {
        datasInside();
        System.out.println("!!! Hello and welcome to the Sparadrap Pharmacy Management System :)");

        PharmaSee.afficheMessage("          ***********  Bienvenue  **********", 1);

//        // STEP 1 - Entrer dans le programme ou le quitter
        PharmaSee.init("oui");

        /**
         * MAIN MENU MANAGE BY SWITCH, BOOLEAN - STEP 2
         * @throws Exception
         */
        boolean end = false;

            menu:

        do {
            int userChoice = PharmaSee.displayMenu();
            switch (userChoice) {
                case 1: //achat

                    PharmaSee.displaySelectPurchase("OUI");

                    boolean erreur = true;
                    do {
                        PharmaSee.createPurchase();

                        try {
                            Purchase thePurchase = new Purchase(PharmaSee.getPurchaseDate(), PharmaSee.getPrescription(),
                                    1, 0.00);
                            purchaseList.add(thePurchase);
                        } catch (Exception e) {
                            PharmaSee.afficheMessage("Une erreur est survenue !! " + e.getMessage(), 0);
                        } finally {
                            // afficher la nouvelle liste OK jusque la
                            PharmaSee.displayPurchaseList(purchaseList);
                        }
                    } while (erreur);
                    PharmaSee.afficheMessage("L'achat à bien été ajouté à la liste.", 0);

                    break;
                case 2://historique d'achat
                    //Afficher l'historique d'achat
                    PharmaSee.displayPurchaseHistoryList();
                    boolean failure = true;
                    do {
                        int reply=0;
                        PharmaSee.askResearchHistoryPurchase(reply);
                        if (reply==2){
                            //rechercher un achats par date
                            PharmaSee.searchPurchaseByDate();
                            PharmaSee.endProgram();
                            break;
                        } else if (reply==1) {
                            // recherche achats du jour
                            PharmaSee.searchPurchaseToday();
                            break;
                        } else {
                            if (reply == 3)
                                //recherche achats par période
                                PharmaSee.searchPurchaseByPeriod();
                                PharmaSee.endProgram();
                            continue;
                        }
                    } while (failure);


                case 3://consulter les médecins
                    boolean fail = false;

                    do {
                        // Afficher la liste des médecins par noms
                        PharmaSee.displayListPhysicianName(listPhysicians);
                        //choix du médecin pour afficher en détail
                        PharmaSee.choicePhysician(1);
                        PharmaSee.endProgram();

                    } while(fail);
                    break;


                case 4: // page patient (client)
                    boolean pb = true;

                    int choice = PharmaSee.displayPatientPage(); ;

                    if (choice ==4) {
                        PharmaSee.createPatient();

                            try {
                                Patient newPatient = new Patient(PharmaSee.getLastName(), PharmaSee.getFirstName(),
                                        PharmaSee.getDateOfBirth(), PharmaSee.getEmail(), // date de naissance voir Patient vs PharmaSee createPatient
                                        PharmaSee.getPhoneNumber(), PharmaSee.getAddress(),
                                        PharmaSee.getPostCode(), PharmaSee.getCity(),
                                        PharmaSee.getSocialSecurityNumber(),
                                        Physician.getPhysicians().getLast(), mutualList.getLast());
                                System.out.println(" Nouveau " + newPatient.toString());

                                Patient.listPatients.add(newPatient);
                                pb = false;
                            } catch (Exception e) {
                                PharmaSee.afficheMessage("Une ERREUR est survenue !! " + e.getMessage(), 1);
                            }

                        PharmaSee.afficheMessage("Votre NOUVEAU PATIENT a bien été créé",0);
                                break;

                            } else if  (choice==1) {
                        //consulter les patients
                        boolean mistake = false;
                        do {
                            //Afficher la liste des patients (clients)
                            PharmaSee.displayListPatientsName(listPatients);
                            //choix du patient pour afficher en détail
                            PharmaSee.choicePatient(1);
                            PharmaSee.endProgram();

                        } while (mistake);
                        break;

                            } else if  (choice==2) {
                        Patient.searchPatient("Whos");
                        //modifier données patient
                            } else if (choice==3) {
                    //supprimer les données du patient
                            PharmaSee.displayListPatientsName(listPatients);
                            PharmaSee.afficheMessage("Le patient "+ PharmaSee.removePatient(choice) +" a été supprimé", 0);
                            } else {
                                if (choice==0);
                                System.out.println("Vous allez retourner au menu");
                                break menu;

                }


                case 0: //quitter le programme
                    PharmaSee.afficheMessage(" Merci et à bientôt ", 1);
                    end = true;
                    break;

                default:
                    PharmaSee.afficheMessage(" Erreur de saisie ! Veuillez recommencer. ", 0);
                    break;
                }
            } while (!end);
    }

    /**
     * LIBRARY INSIDE THE APP WITH PHYSICIANS, PATIENTS, DRUGS,PRESCRIPTIONS, MUTUALS,
     *
     * @throws MyException
     */
    public static void datasInside() throws MyException {

        Physician physician0 = new Physician ("Zero","Aucun", "physician@email.fr",
                "0000000000", "1 rue","00000","Nowhere", "000000000000");
        Physician physician1 = new Physician("Roots", "John", "john@whos.dr",
                "0383232521", "1 allée fleurie", "54000", "Nancy", "321564587956");
        Physician physician2 = new Physician("Grid", "Hanna", "hanna@that.dr",
                "0383232521", "2 allée fleurie", "54000", "Nancy", "321564587021");
        Physician physician3 = new Physician("Girl", "Meg", "meg@girl.dr",
                "0383232521", "3 allée fleurie", "54000", "Nancy", "321564584517");

        Physician.listPhysicians.add(physician0);
        Physician.listPhysicians.add(physician1);
        Physician.listPhysicians.add(physician2);
        Physician.listPhysicians.add(physician3);

        Mutual mutual0 = new Mutual("Aucun","1 rue ","00000","Nowhere",
                "54","0303030303", "sample@email.fr",1);
        Mutual mutual1 = new Mutual("Almutra", "5 promenade des canaux", "54000", "Nancy",
                "54", "0383908200", "contact@almutra.fr", 0.3);
        Mutual mutual2 = new Mutual("MCA-Mutuelle Complémentaire d'Alsace", "6 route de Rouffach",
                "68027", "Colmar", "68", "0389208200", "info@mca.fr",
                0.7);

        mutualList.add(mutual0);
        mutualList.add(mutual1);
        mutualList.add(mutual2);

        Patient patient0 = new Patient("Client", "Anonyme", LocalDate.of(1900,1,1),
                "mutuelle@email.fr", "0000000000","1 rue","00000", "Nowhere",
                "0000000000000",physician0, mutual0);
        Patient patient1 = new Patient("Toubi", "Jack", LocalDate.of(2001, 12, 03),
                "jo@ji.fr", "0321415212", "1 boulevard de tout", "54120",
                "Allain", "1458596523548", physician1, mutual1);
        Patient patient2 = new Patient("Ngulan", "Philippe", LocalDate.of(1977, 01, 19),
                "son@gli.fr", "0356655885", "102 avenue haute", "54200", "Toul",
                "3256987412546", physician2, mutual2);

        listPatients.add(patient0);
        listPatients.add(patient1);
        listPatients.add(patient2);


        Drug drug1 = new Drug("Paracétamol 500mg", "Analgésique", 7.50, 35,
                LocalDate.of(1963, 11, 15));
        Drug drug2 = new Drug("Lamaline", "Analgésique", 15.90, 66,
                LocalDate.of(1999, 9, 20));
        Drug drug3 = new Drug("Amoxiciline", "Antibiotique", 20.90, 12,
                LocalDate.of(1995, 12, 12));
        Drug drug4 = new Drug("Bepanthen", "Dermatologie", 19.20, 30,
                LocalDate.of(1988, 12, 1));

        drugsList.add(drug1);
        drugsList.add(drug2);
        drugsList.add(drug3);
        drugsList.add(drug4);

        drugsForPrescription = new ArrayList<>();
        drugsForPrescription.add(drug3);
        drugsForPrescription.add(drug1);


        Prescription prescription1 = new Prescription(1, LocalDate.of(2025, 9, 5),
                physician1, patient1, drug1, drugsForPrescription);
        Prescription prescription2 = new Prescription(2, LocalDate.of(2025, 8, 25),
                physician2, patient2, drug2, drugsList);
        prescriptionList = new ArrayList<>();
        prescriptionList.add(prescription1);
        prescriptionList.add(prescription2);

        Purchase purchase1 = new Purchase(LocalDate.of(2025,6,12), prescription1, 1, 25.42);
        Purchase purchase2 = new Purchase(LocalDate.of(2025,3,2), prescription2, 1, 45.30);
        purchaseList = new ArrayList<>();
        purchaseList.add(purchase1);
        purchaseList.add(purchase2);

        PurchaseHistory history = new PurchaseHistory(purchaseHistoryList);

        history.addPurchaseHistory(new Purchase(LocalDate.of(2025, 9, 3), prescription1,
                2, 24.90));
        history.addPurchaseHistory(new Purchase(LocalDate.of(2024,2,19),
                prescription2,1,45.52));
        history.addPurchaseHistory(new Purchase(LocalDate.of(2024,12,25),prescription2,
                4,85.22));
        history.addPurchaseHistory(new Purchase (LocalDate.now(), prescription1,
                3,56.20));

    }
}

