package controler;

import exception.MyException;
import model.*;
import view.PharmaSee;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.awt.*;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Scanner;

import static model.Drug.drugsForPrescription;
import static model.Mutual.mutualList;
import static model.Patient.listPatients;
import static model.Drug.drugsList;
import static model.Physician.*;
import static model.Purchase.addPurchase;
import static model.Purchase.purchaseList;
import static model.PurchaseHistory.purchaseHistoryList;


public class Main {


    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws MyException {
        datasInside();
        System.out.println("!!! Hello and welcome to the Sparadrap Pharmacy Management System :)");

        PharmaSee.afficheMessage("***********  Bienvenue  **********", 1);


        //PharmaSee.createPurchase();

        //Mutual.displayMutual();


//        PharmaSee.createPatient(); // ops besoin try catch
//        Patient newPatient = new Patient (PharmaSee.getLastName(),PharmaSee.getFirstName(),
//                PharmaSee.getDateOfBirth(),PharmaSee.getEmail(), // date de naissance voir Patient vs PharmaSee createPatient
//                PharmaSee.getPhoneNumber(),PharmaSee.getAddress(),
//                PharmaSee.getPostCode(),PharmaSee.getCity(),
//                PharmaSee.getSocialSecurityNumber(),
//                Physician.getPhysicians().getLast(), mutualList.getLast());
//        Patient.listPatients.add(newPatient);
//        System.out.println(""+newPatient.toString());




//        PharmaSee.displayListPhysicianName(listPhysicians);
//        PharmaSee.choicePhysician(3);
//
//
//        PharmaSee.displayListPatientsName(listPatients);
//        PharmaSee.choicePatient(2);
//
        //PharmaSee.askCreatePurchase();



        //PharmaSee.init("oui");

        //PharmaSee.processPurchase();


//        // Afficher la liste des médecins par noms
//        PharmaSee.displayListPhysicianName(listPhysicians);
//        //choix du médecin
//        //afficher en détail
//        Physician physician = PharmaSee.choicePhysician(1);



//        char approval = 'z';
//        switch (approval) {
//            case 'o':
//                System.out.println(" Voici les détails concernant ce médecin : ");
//        }

        /**
         * MAIN MENU MANAGE BY SWITCH, BOOLEAN
         * @throws Exception
         */

        boolean end = false;
        do {
            int userChoice = PharmaSee.displayMenu();
            switch (userChoice) {
                case 1: //achat
                    boolean erreur = true;
                    do {
                        PharmaSee.createPurchase();

                        try {
                            Purchase thePurchase = new Purchase(PharmaSee.getPurchaseDate(), PharmaSee.getPrescription(),
                                    1, 0.00);
                            purchaseList.add(thePurchase);
                        } catch (Exception e) {
                            PharmaSee.afficheMessage("Une erreur est survenue !! " + e.getMessage(), 1);
                        } finally {
                            // afficher la nouvelle liste OK jusque la
                            PharmaSee.displayPurchaseList(purchaseList);
                        }
                    } while(erreur);
                    PharmaSee.afficheMessage("L'achat à bien été ajouté à la liste.",0);

                    break;


                case 2://historique d'achat
                    //Afficher l'historique d'achat
                    PharmaSee.displayPurchaseHistoryList();
                    boolean failure = true;
                    do {
                        PharmaSee.askResearchHistoryPurchase();

                        //rechercher un achats par date
                        PharmaSee.searchPurchaseByDate();
                        // recherche achats du jour
                        PharmaSee.searchPurchaseToday();
                        //recherche achats par période
                        PharmaSee.searchPurchaseByPeriod();

                    } while (failure);




                case 3://consulter les médecins

                     // Afficher la liste des médecins par noms
                    PharmaSee.displayListPhysicianName(listPhysicians);
                    //choix du médecin pour afficher en détail
                    PharmaSee.choicePhysician(1);
                    break;

                case 4: //consulter les patients
                    //Afficher la liste des patient (clients)
                    PharmaSee.displayListPatientsName(listPatients);
                    //choix du patient pour afficher en détail
                    PharmaSee.choicePatient(1);
                    break;


                case 0:
                    PharmaSee.afficheMessage(" Merci et à bientôt ", 1);
                    end = true;
                    break;

                    default:
                        PharmaSee.afficheMessage(" Erreur de saisie ! Veuillez recommencer. ", 0);
                        break;
            }
        } while (!end);
    } //manque un }


//        // affichage de la liste des médicaments OK
//        PharmaSee.displayDrugsList(drugsList);

        //test approval PLUS ok à compléter ou modifier
        // PharmaSee.approval();
//


//        //fonctionnel mais physician Girl trouvé null
//        Physician.searchPhysician("Girl");
//        PharmaSee.afficheMessage("Trouvé : " + Physician.searchPhysician("Girl"), 1 );


// ajouter un medecin a la liste medecin en recherchant par nom de famille ne fonctionne plus : to string physician null
        // Physician.addPhysician(searchPhysician("Rolph"));

//initialisation de l'app ok
//        PharmaSee.init("non");
//
//
// afficher la liste des mutuelles OK
//        PharmaSee.displayMutualList(mutualList);
    }

        /**
         * LIBRARY INSIDE THE APP WITH PHYSICIANS, PATIENTS, DRUGS,PRESCRIPTIONS, MUTUALS,
         * @throws MyException
         */
        public static void datasInside () throws MyException {

            Physician physician1 = new Physician("Whos", "John", "john@whos.dr",
                    "0383232521", "1 allée fleurie", "54000", "Nancy", "321564587956");
            Physician physician2 = new Physician("That", "John", "john@that.dr",
                    "0383232521", "2 allée fleurie", "54000", "Nancy", "321564587021");
            Physician physician3 = new Physician("Girl", "John", "john@girl.dr",
                    "0383232521", "3 allée fleurie", "54000", "Nancy", "321564584517");

            Physician.listPhysicians.add(physician1);
            Physician.listPhysicians.add(physician2);
            Physician.listPhysicians.add(physician3);


            Mutual mutual1 = new Mutual("Almutra", "5 promenade des canaux", "54000", "Nancy",
                    "54", "0383908200", "contact@almutra.fr", 0.3);
            Mutual mutual2 = new Mutual("MCA-Mutuelle Complémentaire d'Alsace", "6 route de Rouffach",
                    "68027", "Colmar", "68", "0389208200", "info@mca.fr",
                    0.7);

            mutualList.add(mutual1);
            mutualList.add(mutual2);


            Patient patient1 = new Patient("Daw", "Jack", LocalDate.of(2001, 12, 03),
                    "jo@ji.fr", "0321415212", "1 boulevard de tout", "54120",
                    "Allain", "1458596523548", physician1, mutual1);
            Patient patient2 = new Patient("Son", "Flu", LocalDate.of(1977, 01, 19),
                    "son@gli.fr", "0356655885", "102 avenue haute", "54200", "Toul",
                    "3256987412546", physician2, mutual2);

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


            Prescription prescription1 = new Prescription(1, LocalDate.of(2025,9,5),
                    physician1, patient1,drug1, drugsForPrescription);
            Prescription prescription2 = new Prescription (2, LocalDate.of(2025,8,25),
                    physician2, patient2, drug2,drugsList) ;

            Purchase purchase1 = new Purchase(LocalDate.now(),prescription1,1,25.42);
            Purchase purchase2 = new Purchase(LocalDate.now(),prescription2,1,45.30);
            purchaseList = new ArrayList<>();
            purchaseList.add(purchase1);
            purchaseList.add(purchase2);

            PurchaseHistory history = new PurchaseHistory(purchaseHistoryList);

            history.addPuchaseHistory(new Purchase(LocalDate.of(2025,9,3), prescription1,
                    2, 24.90));
            history.addPuchaseHistory(purchase1);
            history.addPuchaseHistory(purchase2);
        }


//
//        case 123://creation de patient (pas ops a 100/100)
//        PharmaSee.createPatient();
//
//                            try {
//Patient patient = new Patient(
//        PharmaSee.getLastName(),
//        PharmaSee.getFirstName(),
//        PharmaSee.getDateOfBirth(),
//        PharmaSee.getEmail(),
//        PharmaSee.getAddress(), PharmaSee.getPhoneNumber(), PharmaSee.getPostCode(), PharmaSee.getCity(),
//        PharmaSee.getSocialSecurityNumber(), PharmaSee.getPhysician(), PharmaSee.getMutual());
//
//                                Patient.listPatients.add(patient);
//                            } catch (MyException e) {
//        PharmaSee.afficheMessage("Une erreur est survenue !! " + e.getMessage(), 1);
//        } finally {
//        // afficher la nouvelle liste OK jusque la
//        PharmaSee.displayListPatients(listPatients);
//                            }
//
//                                    case 911://creation de médecin (a tester)
//                                    //Créer un médecin en console avec Exception, Ajout du nouveau medecin a la liste puis afficher la nouvelle liste
//                                    PharmaSee.createPhysician();
//                            try {
//Physician physician = new Physician(PharmaSee.getLastName(), PharmaSee.getFirstName(),
//        PharmaSee.getEmail(), PharmaSee.getPhoneNumber(),
//        PharmaSee.getAddress(), PharmaSee.getPostCode(), PharmaSee.getCity(),
//        PharmaSee.getRpps());
//
//                                Physician.listPhysicians.add(physician);
//
//                            } catch (MyException e) {
//        PharmaSee.afficheMessage("Une erreur est survenue !! " + e.getMessage(), 1);
//        } finally {
//        // afficher la nouvelle liste OK jusque la
//        PharmaSee.displayListPhysician(listPhysicians);
//                            }

