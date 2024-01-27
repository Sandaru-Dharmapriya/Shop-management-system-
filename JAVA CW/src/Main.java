import java.util.*;

public class Main {

    // Create a Scanner object for user input
    private static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        String choice = "";
        do {
            Main OBJ = new Main();
            OBJ.Menu();
            choice = userInput.nextLine();
            switch (choice) {
                case "1":
                    user();
                    break;
                case "2":
                    manager();
                    break;
                default:
                    System.out.println("Please enter 1 , 2 or 3");
            }

        } while (!choice.equals("3"));
    }

    private static void user() {
        UserInterface UI = new UserInterface();
        UI.userInterface();
    }

    private static void manager() {
        ShoppingManager managerOBJ = new WestminsterShoppingManager();
        String managerchoice = "";
        do {
            managerMenu();
            managerchoice = userInput.nextLine();

            switch (managerchoice) {

                case "1":
                    managerOBJ.addNewProduct();
                    break;
                case "2":
                    managerOBJ.removeProduct();
                    break;
                case "3":
                    managerOBJ.printProductList();
                    break;
                case "4":
                    managerOBJ.saveToAFile();
                    break;
                case"5":
                    user();
                    break;
                case"6":
                    mainMenu();
                    break;
                case"7":
                    managerOBJ.loadDataFromSaveFile();
            }
        } while (!managerchoice.equals("8"));
    }

    private static void Menu() {
        System.out.println("\n\t***************************");
        System.out.println("\t* ONLINE SHOPPING SYSTEM *");
        System.out.println("\t**************************");

        System.out.println("\n\t1 : User Mode");
        System.out.println("\t2 : Manager Mode");
        System.out.println("\t3 : EXIT");
        System.out.print("\n\tEnter your choice :  ");
    }

    private static void managerMenu() {
        System.out.println("\n\t*************************************");
        System.out.println("\t* ONLINE SHOPPING SYSTEM MANAGEMNET *");
        System.out.println("\t*************************************");

        System.out.println("\n\t1 : Add new products");
        System.out.println("\t2 : Remove products");
        System.out.println("\t3 : Print product list");
        System.out.println("\t4 : Save to a file");
        System.out.println("\t5 : User mode");
        System.out.println("\t6 : Previous Menu");
        System.out.println("\t7 : Load saved data");
        System.out.println("\t8: EXIT");

        System.out.print("\n\t\tEnter your choice :  ");
    }
}

