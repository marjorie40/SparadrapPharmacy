package controler;

import exception.MyException;
import model.Drug;
import model.Mutual;
import model.Patient;
import model.Physician;
import view.PharmaSee;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import static model.Mutual.mutualList;
import static model.Patient.listPatients;
import static model.Drug.drugsList;
import static model.Physician.*;


public class Main {




    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws MyException {
        datasInside();
        System.out.println("Hello and welcome to the Sparadrap Pharmacy Management System :)");
        PharmaSee.afficheMessage("***********  Bienvenue  **********", 1);




//        // affichage de la liste des médicaments OK
//         PharmaSee.displayDrugsList(drugsList);
//
//        // affichage de la liste des patients OK
//        PharmaSee.displayListPatients(listPatients);

    //test approval ok à compléter ou modifier
        // PharmaSee.approval();
//
//        // Afficher la liste des médecins
//        PharmaSee.displayListPhysician(listPhysicians);
//        //Créer un médecin en console avec Exception, Ajout du nouveau medecin a la liste puis afficher la nouvelle liste
//        PharmaSee.createPhysician();
//        try {
//            Physician physician = new Physician (PharmaSee.getLastName(),PharmaSee.getFirstName(),
//                    PharmaSee.getEmail(), PharmaSee.getPhoneNumber(),
//                    PharmaSee.getAddress(), PharmaSee.getPostCode(), PharmaSee.getCity(),
//                    PharmaSee.getRpps());
//
//            Physician.listPhysicians.add(physician);
//
//
//        } catch (MyException e) {
//            PharmaSee.afficheMessage("Une erreur est survenue !! " + e.getMessage(), 1);
//        }
//        // afficher la nouvelle liste OK jusque la
//        PharmaSee.displayListPhysician(listPhysicians);



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
         */
        public static void datasInside() throws MyException {

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
                    "54","0383908200","contact@almutra.fr",0.3);
            Mutual mutual2 = new Mutual("MCA-Mutuelle Complémentaire d'Alsace", "6 route de Rouffach",
                    "68027", "Colmar", "68", "0389208200", "info@mca.fr",
                    0.7);

            mutualList.add(mutual1);
            mutualList.add(mutual2);


            Patient patient1 = new Patient("Daw", "Jack",LocalDate.of(2001,12,03),
                    "jo@ji.fr", "0321415212","1 boulevard de tout", "54120",
                    "Allain", "1458596523548", "Girl",mutual1 );
            Patient patient2 = new Patient("Son", "Flu",LocalDate.of(1977, 01,19),
                    "son@gli.fr","0356655885","102 avenue haute", "54200", "Toul",
                    "3256987412546", "Whos", mutual2);

            listPatients.add(patient1);
            listPatients.add(patient2);

            Drug drug1 = new Drug("Paracétamol 500mg", "Analgésique",7.50,35,
                    LocalDate.of(1963,11, 15));
            Drug drug2 = new Drug ("Lamaline","Analgésique", 15.90, 66,
                    LocalDate.of(1999,9,20));
            Drug drug3 = new Drug("Amoxiciline", "Antibiotique", 20.90, 12,
                    LocalDate.of(1995,12,12));
            Drug drug4 = new Drug("Bepanthen","Dermatologie", 19.20, 30,
                    LocalDate.of(1988,12,1));

            drugsList.add(drug1);
            drugsList.add(drug2);
            drugsList.add(drug3);
            drugsList.add(drug4);


        }
}

