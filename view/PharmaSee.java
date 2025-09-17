package view;

import exception.MyException;
import model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


import static model.Drug.drugsForPrescription;
import static model.Drug.drugsList;
import static model.Mutual.mutualList;
import static model.Physician.listPhysicians;
import static model.Prescription.prescriptionList;
import static model.Purchase.purchaseList;
import static model.PurchaseHistory.purchaseHistoryList;
import static model.Patient.listPatients;
import model.Prescription;


public class PharmaSee {

    String identification;
    String password;
    private String REGEX_POSTCODE = "^(\\d{5})?$";


    public static Scanner sc = new Scanner(System.in);

    private static String lastName;
    private static String firstName;
    private static String email;
    private static String phoneNumber;
    private static String address;
    private static String city;
    private static String postCode;
    private static String rpps;
    private static Physician physician;
    private static String socialSecurityNumber;
    private static LocalDate dateOfBirth;
    private static Mutual mutual;
    private static String referingPhysician;
    private static Drug drugName;
    private static String drug ;
    private static LocalDate purchaseDate;
    private static LocalDateTime dateOfPurchase;
    private static double price;
    private static int quantity;
    private static Prescription prescription;
    private static PurchaseHistory purchaseHistory;
    private static LocalDate purchasesByDay;
    private static LocalDate startDate;
    private static LocalDate endDate;

    /**
     * RETURN THE LAST NAME OF PEOPLE
     *
     * @return lastName
     */
    public static String getLastName() {
        return lastName;
    }

    /**
     * RETURN THE FIRST NAME OF PEOPLE
     *
     * @return firstName
     */
    public static String getFirstName() {
        return firstName;
    }

    /**
     * RETURN THE EMAIL OF PEOPLE
     *
     * @return email
     */
    public static String getEmail() {
        return email;
    }

    /**
     * RETURN THE PHONE NUMBER OF PEOPLE
     *
     * @return phoneNumber
     */
    public static String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * RETURN THE STREET ADDRESS OF PEOPLE
     *
     * @return address
     */
    public static String getAddress() {
        return address;
    }

    /**
     * RETURN THE CITY ADDRESS OF PEOPLE
     *
     * @return city
     */
    public static String getCity() {
        return city;
    }

    /**
     * RETURN THE POST CODE ADDRESS OF PEOPLE
     *
     * @return postCode
     */
    public static String getPostCode() {
        return postCode;
    }

    /**
     * RETURN THE RPPS NUMBER (12 DIGITS) OF PHYSICIAN
     *
     * @return rpps
     */
    public static String getRpps() {
        return rpps;
    }

    /**
     * RETURN THE PHYSICIAN
     *
     * @return physician
     */
    public static Physician getPhysician() {
        return physician;
    }

    /**
     * RETURN THE MUTUAL OF PATIENT
     *
     * @return mutual
     */
    public static Mutual getMutual() {
        return mutual;
    }

    /**
     * RETURN THE BIRTH DATE OF PATIENT
     *
     * @return dateOfBirth
     */
    public static LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * RETURN THE SOCIAL SECURITY NUMBER OF THE PATIENT
     *
     * @return socialSecurityNumber
     */
    public static String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * RETURN THE DURG NAME
     *
     * @return drugName
     */
    public static Drug getDrugName() {
        return drugName;
    }

    public static String getDrug(String drug) {
        return drug;
    }

    /**
     * RETURN THE DATE OF THE PURCHASE
     *
     * @return purchaseDate
     */
    public static LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * RETURN THE QUANTITY FOR PURCHASES
     * @return
     */
    public static int getQuantity() {
        return quantity;
    }

    /**
     * RETURN THE PRICE OF THE PURCHASE
     * @return
     */
    public static double  getPrice() {
        return price;
    }

    /**
     * RETURN THE DATE AND TIME (HOUR-MINUTES) OF THE PURCHASE
     * @return
     */
    public static LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    /**
     * RETURN THE PRESCRIPTION
     * @return prescription
     */
    public static Prescription getPrescription() {
        return prescription;
    }

    /**
     * RETURN THE PURCHASE LIST OF THE DAY
     * @return purchasesByDay
     */
    public static LocalDate getPurchasesByDay() {
        return purchasesByDay;
    }

    /**
     * START OF THE APP CHOICE NOT SECURE
     * @param response of the user
     * @return response
     */
    public static String init(String response) throws MyException {

        System.out.println("Souhaitez vous entrer dans le menu ? \n     >> Pour ENTRER tapez oui, pour SORTIR tapez non. ");
        response = sc.nextLine();
        if (!response.equalsIgnoreCase("oui")&& !response.equalsIgnoreCase("non")) {
            throw new MyException("Veuillez taper oui ou non, vous êtes en erreur : relancez le programme !!");
        }else if (response.equalsIgnoreCase("non")) {
            System.out.println(" Merci et à bientôt !");
            System.exit(0);
        } else {
            response.equalsIgnoreCase("oui");
        }
        return response;
    }


    /**
     * DISPLAY MAIN MENU AND READ USER CHOICE
     * @return user choice
     */
    public static int displayMenu() throws  MyException {

        System.out.println("***********************************************************");
        System.out.println("*****   Bienvenue dans le menu Pharmacie SPARADRAP    *****");
        System.out.println("***********************************************************");
        System.out.println("1 - Effectuer un achat");
        System.out.println("2 - Consulter l'historique des achats");
        System.out.println("3 - Consulter la liste des médecins");
        System.out.println("4 - Consulter la page Patient.e.s (clients)");
        //System.out.println("5 - Rechercher : un patient, un médecin, un médicament, une mutuelle, ") ; // en attente de validation chef projet,
        // visuel card pour filtrer la zone de recherche puis champs de saisie pour la recherche (orienté par la selection précedente)
        //System.out.println("6 - Afficher les prêts") ;
        System.out.println("0 - Quitter");

        System.out.println(" Merci de taper votre choix ? [0-4] ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice < 0 || choice > 4) {
            throw new MyException("Choix invalide ! Veuillez saisir un nombre entre 0 et 4. ");
        } else {
            return choice;
        }
    }


    /**
     * DISPLAY PHYSICIAN'S LIST
     * @param physicians ArrayList
     */
    public static void displayListPhysician(ArrayList physicians) {

        System.out.println("******** Affichage des médecins : ********");
        for (int i = 0; i < listPhysicians.size(); i++) {

            System.out.println(listPhysicians.get(i).toString());
        }
    }

    /**
     * DISPLAY PHYSICIAN'S LASTNAME AND FIRSTNAME LIST
     *
     * @param physiciansName ArrayList
     */
    public static void displayListPhysicianName(ArrayList physiciansName) {
        System.out.println("******** Affichage des noms des médecins : ********");
        for (int i = 0; i < listPhysicians.size(); i++) {

            System.out.print((i + 1) + " - " + "Dr " + listPhysicians.get(i).getLastName().toUpperCase());
            System.out.println(" " + listPhysicians.get(i).getLastName());
        }
    }

    /**
     * DISPLAY PURCHASES' LIST
     * @param purchases ArrayList
     */
    public static void displayPurchaseList(ArrayList purchases) {

        System.out.println("******** Affichage des achats : ********");
        for (int i = 0; i < purchaseList.size(); i++) {

            System.out.println(purchaseList.get(i).toString());
        }
    }

    /**
     * DISPLAY MUTUALS' NAMES LIST
     * @param mutualsName ArrayList
     */
    public static void displayMutualListName(ArrayList mutualsName) {
        System.out.println("******** Affichage des noms des mutuelles : ********");
        for (int i = 0; i < mutualList.size(); i++) {

            System.out.println((i + 1) + " - " + "Assurance Santé :  " + mutualList.get(i).getName().toUpperCase());

        }
    }

    /**
     * USER CHOICE FOR PHYSICIAN
     * @param choice
     * @throws MyException choice > 0 && choice < size list
     */

    public static Physician choicePhysician(int choice) throws MyException { //retourne p pour créer une methode affichage détail
        System.out.println("Veuillez entrer votre choix : ");
        choice = sc.nextInt();
        if (choice < 0 || choice > listPhysicians.size()) {
            throw new MyException("Votre choix est invalide !");
        } else {
            //approval();
            Physician p = listPhysicians.get(choice - 1);
            afficheMessage("Vous avez choisi le médecin : Dr " + p.getLastName().toUpperCase() + " " + p.getFirstName(),1);

            afficheMessage("Voici ses données complètes : " + p.toString(),1);
            return p;
        }
    }


    /**
     * USER CHOICE FOR MUTUAL
     * @param choice
     * @throws MyException choice > 0 && choice < size list
     */

    public static void choiceMutual(int choice) throws MyException {
        System.out.println("Veuillez entrer votre choix : ");
        choice = sc.nextInt();
        if (choice <= 0 || choice > mutualList.size()) {
            throw new MyException("Votre choix est invalide !");
        } else {
            Mutual m = mutualList.get(choice - 1);
            afficheMessage("Vous avez choisi la mutuelle : --> " + m.getName().toUpperCase() +
                    " - Taux de remboursement (coefficient) : " + m.getRefundRate(),0);

        }
    }

    /**
     * DISPLAY MUTUAL'S LIST
     * @param mutuals ArrayList
     */
    public static void displayMutualList(ArrayList mutuals) {

        System.out.println("******** Affichage des mutuelles : ********");
        for (int i = 0; i < mutualList.size(); i++) {

            System.out.println(mutualList.get(i).toString());
        }
    }

    /**
     * DISPLAY PATIENT'S LIST
     * @param patients ArrayList
     */
    public static void displayListPatients(ArrayList patients) {

        System.out.println("******** Affichage des patients : ********");
        for (int i = 0; i < Patient.listPatients.size(); i++) {

            System.out.println(Patient.listPatients.get(i).toString());
        }
    }

    /**
     * DISPLAY PATIENT'S LASTNAME AND FIRSTNAME LIST
     * @param patientsName ArrayList
     */
    public static void displayListPatientsName(ArrayList patientsName) {
        System.out.println("******** Affichage des noms des patients : ********");


        for (int i = 0; i < Patient.listPatients.size(); i++) {

            System.out.print((i + 1) + " " + Patient.listPatients.get(i).getLastName().toUpperCase());
            System.out.println(" " + Patient.listPatients.get(i).getFirstName());
        }
    }

    /**
     * USER CHOICE FOR PATIENT
     * @param choice
     * @throws MyException choice > 0 && choice < size list
     */
    public static void choicePatient(int choice) throws MyException {
        System.out.println("Veuillez taper le numero correspondant au patient : ");
        choice = sc.nextInt();
        if (choice <= 0 || choice > Patient.listPatients.size()) {
            throw new MyException("Votre choix est invalide !");
        } else {
            //approval('o');
            Patient p = Patient.listPatients.get(choice - 1);
            System.out.println("Vous avez choisi le patient : M. ou Mme " + p.getLastName().toUpperCase());
            System.out.println("Voici ses données complètes : " + p.toString()+" \n \n ");
        }

    }

    /**
     * PATIENTS' PAGE WITH 5 CHOICES TO DEAL WITH PATIENT DATA OR TO GO BACK TO THE MAIN MENU
     * @return choice
     * @throws MyException choice
     */
    public static int displayPatientPage() throws MyException {
        System.out.println("******** Page Patient.e.s : ********");
        System.out.println("Souhaitez-vous :  ");
        System.out.println("  1 -- CONSULTER la liste des patients et lire leurs données ? Tapez 1");
        System.out.println("  2 -- MODIFIER les données du patient ? Tapez 2");
        System.out.println("  3 -- SUPPRIMER les données d'un patient ? Tapez 3");
        System.out.println("  4 -- CREER un nouveau patient ? Tapez 4");
        System.out.println("  0 -- Retourner au MENU principal ? Tapez 0");
        int choice = sc.nextInt();
        if (choice<0 && choice>4) {
            throw new MyException("Votre choix est invalide ! Veuillez taper un nombre entre 0 et 4 .");
        } else {
            return  choice;
        }
    }

    /**
     * CREATION OF A PATIENT
     *Display : the communication with the user to create a patient
     */
    public static void createPatient() throws MyException {
        System.out.println(" +++++++++++  Créer et ajouter un patient : ++++++++++ ");
        sc.nextLine();

        System.out.println("Merci de saisir nom du patient. Puis appuyer sur Entrer pour accéder à la suite ");
        lastName = sc.nextLine();
        //sc.nextLine();

        System.out.println("Le prénom du patient.");
        firstName = sc.nextLine();

        System.out.println("Sa date de naissance (jj/mm/aaaa).");
        String d = sc.nextLine();
        dateOfBirth = LocalDate.parse(d, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Merci de saisir l'email du patient. ");
        email = sc.nextLine();

        System.out.println("Son numéro de téléphone. ");
        phoneNumber = sc.nextLine();

        System.out.println("Merci de saisir l'adresse avec ce format : 102 rue des malades.");
        address = sc.nextLine();

        System.out.println("Le code postal sous ce format : 54136. ");
        postCode = sc.nextLine();

        System.out.println("La ville. ");
        city = sc.nextLine();

        afficheMessage("Le numéro de sécurité social du patient.", 1);
        socialSecurityNumber = sc.nextLine();

        System.out.println("Merci d'associer un médecin à ce patient. ");
        displayListPhysicianName(listPhysicians);
        choicePhysician(1);

        System.out.println("Merci d'associer une mutuelle à ce patient. ");
        displayMutualListName(mutualList);
        choiceMutual(1);

        sc.nextLine();// vider le buffer

    }

    /**
     * REMOVE PATIENT FROM THE PATIENTLIST
     * @param choice
     * @return choice
     * @throws MyException
     */
    public static int removePatient(int choice) throws MyException {
        afficheMessage("^^^ Ci-dessus une aide pour saisir le numéro de patient à supprimer.^^^ \nSi vous souhaitez quitter, saississez un nombre négatif. ", 1);
        afficheMessage("Assurez-vous que vous supprimez LE BON PATIENT en consultant la liste suivante : \n" + listPatients, 0);
        choice = sc.nextInt();
        if ( choice > listPatients.size()) {
            throw new MyException("Le choix est invalide. Veuillez recommencer. ");
        } else if (choice < 0) {
            System.exit(0);
        }else {
            Patient.removePatient(listPatients.get(choice - 1));
        }
        return choice;
    }

//    /**
//     * ASK FOR PURCHASE WITH PRESCRIPTION
//     *
//     * @throws MyException
//     */
//    public static void askCreatePurchase() throws MyException {
//        System.out.println("************  ACHATS  *****************");
//
//        System.out.println("La date de l'ordonnance (jj/mm/aaaa).");
//        purchaseDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//
//        System.out.println("Merci de saisir le nom de l'article.");
//        drugName = sc.nextLine().toUpperCase().trim();  //plus ops a partir d'ici
//        if (drugName.isEmpty()) {
//            throw new MyException("La saisie du nom du médicament est incorrecte ou le médicament n'est pas en stock.");
//        } else {
//            drugName.equalsIgnoreCase(Drug.getDrugsForPrescription().toString());
//        }
//
//    }


    /**
     * CREATION PURCHASE
     * @throws MyException
     */
    public static void createPurchase() throws MyException {

        System.out.println(" ************  ACHATS  ***************** ");

        System.out.println("Entrer la date au format jj/mm/aaaa");
        purchaseDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Ajouter l'ordonnance");// Prescription recupération du medecin et du patient et mutuelle
        drugsForPrescription = new ArrayList<>();
        System.out.println("Entrez le numéro de l'ordonnance.");
        System.out.println(drugsForPrescription);
        getPrescription();
        int selection = sc.nextInt();
        if (selection< 0 || selection>drugsForPrescription.size()) {
            throw new MyException("La saisie est invalide.");
        } else {
            System.out.println(""+ prescriptionList.getLast());

        }
        Prescription.searchPrescriptionByPatient("Client");

        System.out.println("Chercher le produit (médicament). ");// Drug recupération du prix
        //drugName = sc.nextLine().toUpperCase().trim();
        if (drugName==null) {
            throw new MyException("La saisie du nom du médicament est incorrecte ou le médicament n'est pas en stock.");
        } else {
            if (drugName.equals(getDrugName()));
            System.out.println(drugsList.toString()); // semble OK mais comme il fait le lien ?? Il affiche 2 fois la liste



            System.out.println("La quantité");// * le prix pour amount * coef mutuelle

            System.out.println("Souhaitez vous recommencer ? "); // incrémentation avec ajout à amount
        }
    }

//    /**
//     * CREATION DIRECT PURCHASE
//     *
//     * @throws MyException
//     */
//    public static void createDirectPurchaseBis() throws MyException {
//        System.out.println("************  ACHATS  *****************");
//        //System.out.println("Entrer la date");
//        //purchaseDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        System.out.println("La date de l'achat : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
//
//        System.out.println("Chercher le produit (médicament). "); // Drug recupération du prix
//
//        System.out.println("La quantité"); // * le prix pour amount * coef mutuelle
//        System.out.println("Souhaitez vous recommencer ? "); // incrémentation avec ajout à amount
//
//    }


    /**
     * USER SELECT THE PURCHASE TYPE : IF PRESCRIPTION --> PRESCRIPTION PURCHASE / IF NO --> DIRECT PURCHASE
     * @param userChoice
     * @return userChoice
     * @throws MyException mandatory 3 choices : oui or non or menu
     */
    public static String displaySelectPurchase (String userChoice) throws MyException {

        System.out.println ("Sagit-il d'un achat avec ordonnance, pour répondre : tapez OUI ou NON. " +
                "Sinon, tapez MENU pour retourner au menu principal. ");
        userChoice = sc.nextLine().trim().toLowerCase();

        if ( !userChoice.equalsIgnoreCase("OUI") && !userChoice.equalsIgnoreCase("NON") && !userChoice.equalsIgnoreCase("MENU")) {
            throw new MyException("Saisie incorrecte, veuillez taper oui ou non pour chaoisir votre type d'achat, Merci !");
        } else {
            return userChoice;
        }
    }

    public static void createDirectPurchase (DirectPurchase directPurchase) throws MyException {  // achat besoin de LocalDate.now(); Nom; Quantite; prix unitaire  + Patient (getprescription / getphysician / get drug / getmutuelle)

        double total = 0.0;
        System.out.println("************  ACHATS DIRECTS *****************");

        System.out.println("La date de l'achat : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        LocalDateTime dateOfPurchase = LocalDateTime.now();

        System.out.println(drugsList);

        System.out.println("Merci d'entrer le nom du médicament");
        Drug.searchDrug(sc.nextLine());

        System.out.println("Merci d'entrer la quantité achetée ");
        int quantity = sc.nextInt();

        System.out.println("Merci d'entrer son prix unitaire");
        double price = sc.nextDouble();

        System.out.println("Voici le total des achats : " + drug + " " + (total = price * quantity) + " euros");

    }

        /**
         * DISPLAY HISTORY LIST OF PURCHASES
         *
         * @throws MyException
         */
        public static void displayPurchaseHistoryList () throws MyException {

            System.out.println("************  HISTORIQUE DES ACHATS  *****************");
            for (int i = 0; i < PurchaseHistory.purchaseHistoryList.size(); i++) {

                System.out.println(PurchaseHistory.purchaseHistoryList.get(i).toString()+"\n");
            }
        }

        /**
         * RESEARCH THE PURCHASE LIST OF TODAY
         *
         * @throws MyException
         */
        public static void searchPurchaseToday () throws MyException {
            System.out.println("--> Rechercher les achats du jour <-- ");
            System.out.println(PurchaseHistory.getPurchasesByDay(LocalDate.now()));
        }

        /**
         * RESEARCH THE PURCHASE LIST THROUGH ONE DATE
         *
         * @throws MyException
         */
        public static void searchPurchaseByDate () throws MyException {
            System.out.println("--> Rechercher les achats d'une journée <-- ");

            System.out.println("Entrer la date souhaitée (jj/MM/yyyy). ");
            LocalDate oneDay = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println(PurchaseHistory.getPurchasesByDay(oneDay));
        }

        /**
         * RESEARCH THE PURCHASE LIST THROUGH A PERIOD WITH START DATE & END DATE
         *
         * @throws MyException
         */
        public static void searchPurchaseByPeriod () throws MyException {
            System.out.println("--> Rechercher les achats sur une période <-- ");

            System.out.println("Entrer la date de début (jj/MM/yyyy). ");
            LocalDate startDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.println("Entrer la date de fin (jj/MM/yyyy). ");
            LocalDate endDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.println(PurchaseHistory.getPurchasesByPeriod(startDate,endDate));

        }

        /**
         * HISTORY OF PURCHASE RESEARCH BY DATE OR PERIOD
         * @throws MyException
         */
        public static int askResearchHistoryPurchase (int reply) throws MyException {


            afficheMessage("--> En quoi puis-je vous aider ?\n ",1);
            System.out.println("1 -- Vous souhaitez afficher les achats de la journée ? Tapez 1 ");
            System.out.println("2 -- Vous souhaitez afficher les achats pour une date donnée ? Tapez 2 ");
            System.out.println("3 -- Vous souhaitez afficher les achats pour une période donnée ? Tapez 3 ");
            System.out.println("0 -- Si vous souhaitez revenir au menu principal : Tapez 0 ");
            reply = sc.nextInt();

            if (reply == 1) {
                searchPurchaseToday();
            } else if (reply == 2) {
                searchPurchaseByDate();
            } else if (reply == 3) {
                searchPurchaseByPeriod();
            }
            if (reply < 0 || reply >= 3) {
                throw new MyException(" Veuillez choisir le type de recherche ou  retourner au menu en tapant [0-3] ");
            } else {
                if (reply == 0) ;
                //displayMenu();
            }
            return reply;
        }


//    /**
//     * USER CHOICE ANOTHER PURCHASE
//     * @param purchase
//     * @throws MyException
//     */
//    public static void anotherPurchase(Purchase purchase) throws MyException {
//            System.out.println("Voulez vous ajouter un achat ? Tapez o pour oui, Tapez n pour non.");
//            String reply =  sc.nextLine();
//            if (reply.isEmpty()) {
//                throw new MyException("Veuillez entrer votre réponse o pour OUI et n pour NON. ");
//            } else {
//                if (reply.equalsIgnoreCase("o")) {
//                    processPurchase();
//                } else {
//                    if(reply.equalsIgnoreCase("n")) {
//                        System.out.println("Merci de votre achat. ");
//                    }
//                }
//            }
//        }


        /**
         * DISPLAY DRUGS' LIST
         *
         * @param drugs ArrayList
         */
        public static void displayDrugsList (ArrayList drugs){

            System.out.println("******** Affichage des médicaments : ********");
            for (int i = 0; i < drugsList.size(); i++) {

                System.out.println(drugsList.get(i).toString());
            }
        }

        /**
         * CREATION OF A PHYSICIAN
         *
         */
        public static void createPhysician () {
            afficheMessage(" +++++++++++  Créer et ajouter un médecin : ++++++++++ ", 0);

            System.out.println("Merci de saisir nom du docteur. ");
            lastName = sc.nextLine();

            System.out.println("Le prénom du docteur.");
            firstName = sc.nextLine();

            System.out.println("Merci de saisir l'email du docteur. ");
            email = sc.nextLine();

            System.out.println("Son numéro de téléphone. ");
            phoneNumber = sc.nextLine();

            System.out.println("Merci de saisir l'adresse avec ce format : 5 rue de la paillette.");
            address = sc.nextLine();

            System.out.println("Le code postal sous ce format : 54136. ");
            postCode = sc.nextLine();

            System.out.println("La ville. ");
            city = sc.nextLine();

            afficheMessage("Et enfin, le numero RPPS du docteur", 1);
            rpps = sc.nextLine();

            sc.nextLine();// vider le buffer
        }

        /**
         * APPROVAL, BACK OR RETURN TO THE MENU
         *
         * @throws MyException
         */
        public static char approval ( char choice) throws MyException {

            boolean error = true;
            choice = 'o';
            do {
                System.out.println("Êtes vous sur de votre choix ? Pour OUI, tapez o / " +
                        "pour RETOURNER à l'étape précédente, tapez r / " +
                        "pour vous rendre sur le MENU principal, tapez m");
                choice = sc.nextLine().charAt(0);
                if (choice != 'm' && choice != 'o' && choice != 'r') {
                    System.err.println("Veuillez choisir o - r ou m");
                } else {
                    if (choice == 'm') {
                        afficheMessage("-----> Vous voici de retour dans le menu principal : ", 0);
                        displayMenu();
                    } else if (choice == 'r') {
                        afficheMessage("-----> Vous voici de retour à l'étape précédente : ", 0);
                        backLoop:
                        break;
                    } else if (choice == 'o') {
                        afficheMessage(" Très bien, poursuivons : ", 1);
                        break;
                    }
//
//                afficheMessage("-----> Vous voici de retour à l'étape précédente : ", 0);
//
//                afficheMessage(" Très bien, poursuivons : ", 1);
                }
            } while (error);

            return choice;
        }

        /**
         * GO BACK TO MENU OR END OF PROGRAM
         * @throws MyException
         */
        public static void endProgram () throws MyException {
            System.out.println("---> Si vous souhaitez vous retourner au menu principal, tapez 1 ");
            System.out.println("---> Si vous souhaitez quitter le programme, merci de tapez 0 .");
            int choice = sc.nextInt();
            if (choice != 1 && choice != 0) {
                throw new MyException("Votre saisie est incorrecte. Vous devez taper 1 ou 0. ");
            } else if (choice == 1) {
                afficheMessage("-----> Vous voici de retour dans le menu principal : ", 0);
            } else if (choice == 0) {
                System.exit(0);
            }
        }
        /**
         * AFFICHAGE MESSAGE ERREUR EN ROUGE
         * @param message
         * @param type
         */
        public static void afficheMessage (String message,int type){
            if (type == 0) {
                System.err.println(message);
            } else {
                System.out.println(message);
            }
        }
    }




//    /**
//     * DISPLAY USER CHOICE PHYSICIAN'S DETAILS pas ops
//     * @throws MyException
//     */
//    public static void detailPhysician(Physician p) throws MyException {
//        System.out.println("Pour afficher les données de ce médecin tapez oui, pour retourner à la liste tapez retour. ");
//        String input = sc.nextLine();  //ne demande pas la saisie passe direct aux if else
//        if (input == null){
//            throw new MyException("La saisie est invalide, veuillez taper oui ou retour");
//        } else {
//            if (input.equalsIgnoreCase("oui")) {
//                System.out.println("Voici les détails : ");
//                System.out.println(" recupération "+ get(choicePhysician(1)));
//            } else {
//                if (input.equalsIgnoreCase("retour")) {
//                    int choice = 1;
//                    choicePhysician(choice);
//                }
//            }
//        }
//    }




//    public String loggin() throws MyException {
//        System.out.println("Veuillez saisir l'identifiant à 5 chiffres. ");
//        identification = sc.nextLine();
//        if (!identification.matches(REGEX_POSTCODE)) {
//            throw new MyException("L'identifiant est incorrect, veuillez saisir un identifiant à 5 chiffres.");
//        }
//        if (identification.equals("54130")) {
//            System.out.println("Bonjour, entrez le mot de passe");
//            password = sc.nextLine();
//            if (!password.matches(REGEX_POSTCODE)) {
//                throw new MyException("Le mot de passe incorrect, recommencez l'identification");
//            } else if (password.equals("96857")) {
//                PharmaSee.displayMenu();
//            }
//        } else {
//            return identification;
//        }
//    }



//
//    /**
//     * DIALOGUE TO MAKE A PURCHASE
//     * @param
//     * @throws MyException
//     */
//    public static void processPurchase () throws MyException {
//        double sum = 0;
//        double total = 0;
//        System.out.println("Veuillez saisir le nom du médicament");
//        String drugName = sc.nextLine().toUpperCase().trim();
//        if (drugName.isEmpty()) {
//            throw new MyException("La saisie du nom du médicament est incorrecte ou le médicament n'est pas en stock.");
//        } else {
//            drugName.equalsIgnoreCase(Drug.getName().toUpperCase().toString());
//            sum += Drug.getPrice();
//            total += sum;
//        }


//    public static void approval() throws MyException {
//        System.out.println("Êtes vous sur de votre choix ? Pour oui, tapez o ;" +
//                "pour retourner à l'étape précédente, tapez r ; " +
//                "pour vous rendre sur le menu principal, tapez m.");
//        char choice = sc.nextLine().charAt(0);
//        switch (choice) {
//            case 'r':
//        }
//
//    }
//    // test de label NON FONCTIONNEL
//    public static void approvalTwo() throws MyException {
//        System.out.println("Êtes vous sur de votre choix ? Pour oui, tapez o / " +
//                "pour retourner à l'étape précédente, tapez r / " +
//                "pour vous rendre sur le menu principal, tapez m");
//        char choice = sc.nextLine().charAt(0);
//
//        stop:
//        while (choice != 'm' && choice != 'r' && choice != 'o') {
//            System.out.println("Êtes vous sur de votre choix ? Pour oui, tapez o / " +
//                    "pour retourner à l'étape précédente, tapez r / " +
//                    "pour vous rendre sur le menu principal, tapez m");
//            if (choice == 'o') {
//                afficheMessage(" Très bien, poursuivons : ", 1);
//                break stop;
//            } else {
//                afficheMessage("-----> Vous voici de retour dans le menu principal : ", 0);
//                displayMenu();
//            }
//        }
//    }


/**
 * PURCHASE PAGE
 */

//    public static void processPurchase() throws MyException {
//        afficheMessage("Bonjour, quel type d'achat souhaitez vous effectuer ?", 0);
//        System.out.println("Pour un achat direct, tapez D / pour un achat avec ordonnance, tapez P");
//        char reply = sc.nextLine().charAt(0);
//        if  (reply == 'P') {
//            approval();
//
//        }
//
//        Drug drug ;
//
//
//    }