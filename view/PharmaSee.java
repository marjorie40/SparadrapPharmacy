package view;

import exception.MyException;
import model.Mutual;
import model.Physician;
import model.Patient;
import model.Drug;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static model.Physician.addPhysician;
import static model.Physician.listPhysicians;

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
    private static String socialSecurityNumber;
    private static LocalDate dateOfBirth = LocalDate.of(1920,1,1);
    private static Mutual mutual;
    private static String referingPhysician;

    public static String getLastName() {
        return lastName;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getAddress() {
        return address;
    }

    public static String getCity() {
        return city;
    }

    public static String getPostCode() {
        return postCode;
    }

    public static String getRpps() {
        return rpps;
    }

    public static Physician getPhysician() {
        return physician;
    }

    public String getReferingPhysician() {
        return referingPhysician;
    }

    public Mutual getMutual() {
        return mutual;
    }

    public  LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    private static Physician physician;


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


    /**
     * START OF THE APP CHOICE NOT SECURE
     * @param response
     * @return response
     */
    public static String init (String response) {

        System.out.println("Souhaitez vous entrer dans le menu ? Pour entrer tapez oui, pour sortir tapez non. ");
        response = sc.nextLine();
        if (response.equalsIgnoreCase("oui")) {
            displayMenu();
        } else {
            if (response.equalsIgnoreCase("non")) {
                System.out.println(" Merci et à bientôt !");
                System.exit(0);
            }
        }
        return response;
    }

    /**
     * DISPLAY MAIN MENU AND READ USER CHOICE
     * @return user choice
     */
    public static int displayMenu() {

        System.out.println("***********************************************************");
        System.out.println("*****   Bienvenue dans le menu Pharmacie SPARADRAP     ******");
        System.out.println("***********************************************************");
        System.out.println("1 - Effectuer un achat");
        System.out.println("2 - Consulter l'historique des achats");
        System.out.println("3 - Consulter les médecins");
        System.out.println("4 - Consulter les patients (clients)");
        System.out.println("5 - Rechercher : un patient, un médecin, un médicament, une mutuelle, "); // en attente de validation chef projet,
        // visuel card pour filtrer la zone de recherche puis champs de saisie pour la recherche (orienté par la selection précedente)
        //System.out.println("6 - Afficher les prêts") ;
        System.out.println("0 - Quitter");

        System.out.println(" Merci de taper votre choix ? [0-5] ");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    /**
     * DISPLAY PHYSICIAN'S LIST
     * @param physicians ArrayList
     */
    public static void displayListPhysician(ArrayList physicians){

        System.out.println("******** Affichage des médecins : ********");
        for (int i = 0; i < Physician.listPhysicians.size(); i++) {

            System.out.println(Physician.listPhysicians.get(i).toString());
        }
    }

    /**
     * DISPLAY PHYSICIAN'S LASTNAME AND FIRSTNAME LIST
     * @param physiciansName ArrayList
     */
    public static void displayListPhysicianName(ArrayList physiciansName){

        System.out.println("******** Affichage des noms des médecins : ********");
        for (int i = 0; i < Physician.listPhysicians.size(); i++) {

            System.out.print((i+1) + " - " + "Dr " + Physician.listPhysicians.get(i).getLastName().toUpperCase());
            System.out.println(" " +Physician.listPhysicians.get(i).getFirstName());
        }
    }

    /**
     * USER CHOICE FOR PHYSICIAN
     * @param choice
     * @throws MyException choice > 0 && choice < size list
     */

    public static void choicePhysician(int choice) throws MyException {
        System.out.println("Veuillez entrer votre choix : ");
        choice = sc.nextInt();
        if (choice <= 0 || choice > Physician.listPhysicians.size()) {
            throw new MyException("Votre choix est invalide !");
        } else {
            Physician p = Physician.listPhysicians.get(choice -1);
            System.out.println("Vous avez choisi le médecin : Dr " + p.getLastName().toUpperCase() + " "+ p.getFirstName());

        }
    }

    /**
     * DISPLAY PHYSICIAN'S LIST
     * @param mutuals ArrayList
     */
    public static void displayMutualList(ArrayList mutuals){

        System.out.println("******** Affichage des mutuelles : ********");
        for (int i = 0; i < Mutual.mutualList.size(); i++) {

            System.out.println(Mutual.mutualList.get(i).toString());
        }
    }

    /**
     * DISPLAY PATIENT'S LIST
     * @param patients ArrayList
     */
    public static void displayListPatients(ArrayList patients){

        System.out.println("******** Affichage des patients : ********");
        for (int i = 0; i < Patient.listPatients.size(); i++) {

            System.out.println(Patient.listPatients.get(i).toString());
        }
    }

    /**
     * DISPLAY PATIENT'S LASTNAME AND FIRSTNAME LIST
     * @param patientsName ArrayList
     */
    public static void displayListPatientsName(ArrayList patientsName){

        System.out.println("******** Affichage des noms des patients : ********");
        for (int i = 0; i < Patient.listPatients.size(); i++) {

            System.out.print((i+1) + " " + Patient.listPatients.get(i).getLastName().toUpperCase());
            System.out.println(" " +Patient.listPatients.get(i).getFirstName());
        }
    }

    /**
     * USER CHOICE FOR PATIENT
     * @param choice
     * @throws MyException choice > 0 && choice < size list
     */
    public static void choicePatient(int choice) throws MyException {
        System.out.println("Veuillez entrer votre choix : ");
        choice = sc.nextInt();
        if (choice <= 0 || choice > Patient.listPatients.size()) {
            throw new MyException("Votre choix est invalide !");
        } else {
            Patient p = Patient.listPatients.get(choice - 1);
            System.out.println("Vous avez choisi le patient : " + p.getLastName().toUpperCase() +" " + p.getFirstName());
        }
    }

    /**
     * CREATION OF A PATIENT
     *
     */
    public static void createPatient() {
        afficheMessage(" +++++++++++  Créer et ajouter un patient : ++++++++++ ",0);
        System.out.println("Merci de saisir nom du patient. ");
        lastName = sc.nextLine();
        System.out.println("Le prénom du patient.");
        firstName  = sc.nextLine();
        System.out.println("Sa date de naissance.");
        //LocalDate dateOfBirth = sc.nextLine();
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
        displayListPhysicianName(Physician.listPhysicians);
        System.out.println("Merci d'associer une mutuelle à ce patient. ");

        sc.nextLine();// vider le buffer

    }

    /**
     * DISPLAY DRUGS' LIST
     * @param drugs ArrayList
     */
    public static void displayDrugsList(ArrayList drugs){

        System.out.println("******** Affichage des médicaments : ********");
        for (int i = 0; i < Drug.drugsList.size(); i++) {

            System.out.println(Drug.drugsList.get(i).toString());
        }
    }

    /**
     * CREATION OF A PHYSICIAN
     *
     */
    public static void createPhysician() {
        afficheMessage(" +++++++++++  Créer et ajouter un médecin : ++++++++++ ",0);

        System.out.println("Merci de saisir nom du docteur. ");
        lastName = sc.nextLine();

        System.out.println("Le prénom du docteur.");
        firstName  = sc.nextLine();

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
     * @throws MyException
     */
    public static void approval() throws MyException {
        System.out.println("Êtes vous sur de votre choix ? Pour oui, tapez o / " +
                "pour retourner à l'étape précédente, tapez r / " +
                "pour vous rendre sur le menu principal, tapez m");
        char choice = sc.nextLine().charAt(0);
        if  (choice == 'm') {
            afficheMessage("-----> Vous voici de retour dans le menu principal : ",0);
            displayMenu();
        } else if (choice == 'r') {
            afficheMessage("-----> Vous voici de retour à l'étape précédente : ",0);

        } else if (choice == 'o') {
            afficheMessage(" Très bien, poursuivons : ",1);
            //continue;
        }
    }
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
     * AFFICHAGE MESSAGE ERREUR EN ROUGE
     * @param message
     * @param type
     */
    public static void afficheMessage(String message, int type) {
        if  (type == 0) {
            System.err.println(message);
        } else {
            System.out.println(message);
        }
    }

}
