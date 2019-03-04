import java.util.Scanner;
import java.util.InputMismatchException;

public class Garage {
  
  static Scanner scan = new Scanner(System.in);
  static boolean quit = false;
  static String escape = "a";

  static String mainInfo = "\nSTATUS: [FULLT]\nBOMMAR: [UPPE/NERE]";
  static String mainMenu1 = "1. Admin";
  static String mainMenu2 = "2. Kund";
  static String mainMenu3 = "3. Avsluta";
  static String[] mainMenuText = {mainInfo, mainMenu1, mainMenu2, mainMenu3};

  static String adminInfo = "\nDATUM: ..\nTID: .. \nPRIS:..";
  static String adminMenu1 = "1. Sätt tid";
  static String adminMenu2 = "2. Ta bort fordon";
  static String adminMenu3 = "3. Status";
  static String adminMenu4 = "4. Prissättning";
  static String adminMenu5 = "5. Logg och statistik";
  static String adminMenu6 = "6. Tillbaka";
  static String[] adminMenuText = {adminInfo, adminMenu1, adminMenu2, adminMenu3, 
				   adminMenu4, adminMenu5, adminMenu6};

  static String statusMenu1 = "1. Lista incheckade fordon";
  static String statusMenu2 = "2. Lista övertrasserade fordon";
  static String statusMenu3 = "3. Tillbaka";
  static String[] statusMenuText = {statusMenu1, statusMenu2, statusMenu3};

  static String priceMenu1 = "1. Ändra tidsenhet";
  static String priceMenu2 = "2. Ändra taxa";
  static String priceMenu3 = "3. Tillbaka";
  static String[] priceMenuText = {priceMenu1, priceMenu2, priceMenu3};

  static String logMenu1 = "1. Logg";
  static String logMenu2 = "2. Totalt antal parkeringar";
  static String logMenu3 = "3. Totala intäkter";
  static String logMenu4 = "4. Genomsnittlig parkeringstid";
  static String logMenu5 = "5. Parkerad mediantid";
  static String logMenu6 = "6. Tillbaka";
  static String[] logMenuText = {logMenu1, logMenu2, logMenu3, logMenu4, logMenu5, logMenu6};

  static String customerInfo = "\nDATUM: ..\nTID: .. \nPRIS:..";
  static String customerMenu1 = "1. Påbörja parkering";
  static String customerMenu2 = "2. Avsluta parkering";
  static String[] customerMenuText = {customerInfo, customerMenu1, customerMenu2};

  static String[] menuText = mainMenuText;
  static String menuName = "mainMenu";

  public static int takeInt() {
    int input;
    while(true) {
      try {
        input = scan.nextInt();
        break;
      } 
      catch (InputMismatchException e) {
        System.out.println("Du måste välja en siffra");
        scan.next();
      }
    }
    return input;
  }

  public static void menu() {
    for (String s : menuText) {
      System.out.println(s);
    }
    int input = takeInt();
    handleInput(input);
  }

  public static void handleInput(int input) {
  String command = menuName + input;

    switch (command) {
      case "mainMenu1":
        boolean loginSuccess = true; //lagra resultat av anrop till loginmetod
        if(loginSuccess) {
          menuText = adminMenuText;
          menuName = "adminMenu";
        } else {
          System.out.println("Inloggningen misslyckades");
          menu();
        }
        break;
      case "mainMenu2":
        menuText = customerMenuText;
        menuName = "customerMenu";
        break;
      case "mainMenu3":
        quit = true;
        break;
      case "adminMenu1":
        setTime();
        break;
      case "adminMenu2":
        removeVehicle();
        break;
      case "adminMenu3":
        menuText = statusMenuText;
        menuName = "statusMenu";
        break;
      case "adminMenu4":
        menuText = priceMenuText;
        menuName = "priceMenu";
        break;
      case "adminMenu5":
        menuText = logMenuText;
        menuName = "logMenu";
        break;
      case "adminMenu6":
        menuText = mainMenuText;
        menuName = "mainMenu";
        break;
      case "statusMenu1":
        listAll();
        menuText = adminMenuText;
        menuName = "adminMenu";
        break;
      case "statusMenu2":
        listOld();
        menuText = adminMenuText;
        menuName = "adminMenu";
        break;
      case "statusMenu3": 
        menuText = adminMenuText;
        menuName = "adminMenu";
        break;
      case "priceMenu1":
        changeTimeUnit();
        menuText = adminMenuText;
        menuName = "adminMenu";
        break;
      case "priceMenu2":
        changePrice();
        menuText = adminMenuText;
        menuName = "adminMenu";
        break;
      case "priceMenu3":
        menuText = adminMenuText;
        menuName = "adminMenu";
        break;
      case "logMenu1":
        listLog();
        menuText = adminMenuText;
        menuName = "adminMenu";
        break;
      case "logMenu2":
        showTotalNumberOfVehicles();
        menuText = adminMenuText;
        menuName = "adminMenu";
        break;
      case "logMenu3":
        showTotalIncome();
        menuText = adminMenuText;
        menuName = "adminMenu";
        break;
      case "logMenu4":
        showMeanTimeParked();
        menuText = adminMenuText;
        menuName = "adminMenu";
        break;
      case "logMenu5":
        showMedianTimeParked();
        menuText = adminMenuText;
        menuName = "adminMenu";
        break;
      case "logMenu6":
        menuText = adminMenuText;
        menuName = "adminMenu";
        break;
      case "customerMenu0":
        menuText = mainMenuText;
        menuName = "mainMenu";
        break;
      case "customerMenu1":
        checkIn();
        menuText = customerMenuText;
        menuName = "customerMenu";
        break;
      case "customerMenu2":
        checkOut();
        menuText = customerMenuText;
        menuName = "customerMenu";
        break;
      default: 
        System.out.println("Inget sådant val!");
        break;
    }
  }

  public static void setTime() {
    System.out.print("Sätt tid i sekunder: ");
    int time = takeInt();
    // use this time...
  }

  public static void removeVehicle() {
    System.out.println("Skriv in ditt registreringnummer på formen ABC123. Tryck " + 
			escape + " och enter för att avbryta");
    String regNr = scan.next();
    boolean valid = false; // call method to check if regNr exists in record
    if (valid) {
      // change data and print confirmation
      System.out.println("Confirmation. Vehicle ABC123 removed");
    } else if (!valid && !(regNr.equals(escape))) {
      System.out.println("Ogiltigt registreringsnummer. Försök igen.\n");
    }
  }

  public static void listAll() {
    System.out.println("Listar incheckade fordon");
  }

  public static void listOld() {
    System.out.println("Listar övertrasserade fordon...");
  }

  public static void changeTimeUnit() {
    System.out.print("Sätt tidsenhet i sekunder: ");
    int timeUnit = takeInt();
    // use this time unit
  }

  public static void changePrice() {
    System.out.print("Sätt pris i kronor: ");
    int price = takeInt();
    // use this price
  }

  public static void listLog() {
    System.out.println("Listar hela loggen");
  }

  public static void showTotalNumberOfVehicles() {
    System.out.println("Visar totala antalet fordon");
  }

  public static void showTotalIncome() {
    System.out.println("Visar totala intäkter");
  }

  public static void showMeanTimeParked() {
    System.out.println("Visar genomsnittlig parkeringstid per fordon");
  }

  public static void showMedianTimeParked() {
    System.out.println("Visar parkerad medeltid");
  }

  public static void checkIn() {
    System.out.println("Skriv in ditt registreringnummer på formen ABC123. Tryck " + 
			escape + " och enter för att avbryta");
    String regNr = scan.next();
    boolean correctFormat = false; // call method to check regNr is correct format
    if (correctFormat) {
      // save data and print receipt
      System.out.println("Kvitto: ...\n");
    } else if (!correctFormat && !(regNr.equals(escape))) {
      System.out.println("Felaktigt format. Försök igen.\n");
    }
  }

  public static void checkOut() {
    System.out.println("Skriv in ditt registreringnummer på formen ABC123. Tryck " + 
			escape + " och enter för att avbryta");
    String regNr = scan.next();
    boolean valid = false; // call method to check if regNr exists in record
    if (valid) {
      // change data and print receipt
      System.out.println("Kvitto: ...\n");
    } else if (!valid && !(regNr.equals(escape))) {
      System.out.println("Ogiltigt registreringsnummer. Försök igen.\n");
    }
  }

  public static void main(String[] args) {
    while(!quit) {
      // System.out.println(menuName);
      menu();
    }
  }
  
}