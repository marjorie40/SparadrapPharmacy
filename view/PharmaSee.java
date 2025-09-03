package view;

import exception.MyException;
import model.Physician;

import java.util.ArrayList;
import java.util.Scanner;

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
     * CREATION OF A PHYSICIAN
     *
     */
    public static void createPhysician() {
        System.out.println("Créer et ajouter un médecin :");
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
