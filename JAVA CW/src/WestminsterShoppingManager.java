import java.util.*;
import java.io.*;

public class WestminsterShoppingManager implements ShoppingManager{
    //Scanner object user input
    private static final Scanner managerInput = new Scanner(System.in);
    //Array list to store products
    static List<Products> ProductsList = new ArrayList<>();
    //Method to get the list of products
    public List<Products> getProductList() {
        return ProductsList;
    }
    private int availableStock;
    private int maximumProductCapacity = 50;

    @Override
    public void addNewProduct() {
        if (ProductsList.size()<maximumProductCapacity) {
            System.out.print("Enter the type ('E' for electronics or 'C' for clothing): ");
            String type = managerInput.nextLine();

            if ("E".equals(type)) {
                System.out.println("*** ELECTRONICS ***");
                System.out.print("Enter the product Name : ");
                String productName = managerInput.nextLine();


                System.out.print("Enter the product ID : ");
                String productID = managerInput.nextLine();

                for (int i=0;i<ProductsList.size();i++){
                    if (ProductsList.get(i).getProductId().equals(productID)){
                        System.out.println("This productID is already exist.\n Try again.");
                        return;
                    }
                }


                System.out.print("Enter the product brand : ");
                String brand = managerInput.nextLine();
                System.out.print("Enter the warrenty period : ");
                String warrentyPeriod = managerInput.next();

                int availableItems = 0;
                int productPrice = 0;

                while (true) {
                    try {
                        System.out.println("Enter the available items : ");
                        availableItems = managerInput.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input for available items. Please enter a valid integer.");
                        managerInput.nextLine();
                    }
                }

                while (true) {
                    try {
                        System.out.print("Enter the product price : £");
                        productPrice = managerInput.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input for product price. Please enter a valid integer.");
                        managerInput.nextLine(); // Consume the invalid input
                    }
                }

                Products elecOBJ = new Electronics(productID, productName, availableItems, productPrice, brand, warrentyPeriod);
                ProductsList.add(elecOBJ);
                System.out.println("Product " + productName + " successfully added to the system.\nYou can add"+getAvailableStock()+" products to the system.");
                managerInput.nextLine();


            } else if ("C".equals(type)) {

                System.out.println("*** CLOTHING ***");
                System.out.print("Enter the product Name : ");
                String productName = managerInput.nextLine();
                System.out.print("Enter the product ID : ");
                String productID = managerInput.nextLine();
                System.out.print("Enter the Size : ");
                String Size = managerInput.nextLine();
                System.out.print("Enter the colour : ");
                String Colour = managerInput.nextLine();
                System.out.println("Enter the availavle items : ");

                int availableItems = 0;
                int productPrice = 0;

                while (true) {
                    try {
                        System.out.println("Enter the available items : ");
                        availableItems = managerInput.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input for available items. Please enter a valid integer.");
                        managerInput.nextLine();
                    }
                }

                while (true) {
                    try {
                        System.out.print("Enter the product price : £");
                        productPrice = managerInput.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input for product price. Please enter a valid integer.");
                        managerInput.nextLine();
                    }
                }

                Products clothOBJ = new Clothing(productID, productName, availableItems, productPrice, Size, Colour);
                ProductsList.add(clothOBJ);
                System.out.println("Product added to the system successfuly ! \nYou can add "+getAvailableStock()+" products to the system.");
                managerInput.nextLine();

            } else {
                System.out.println("Invalid Product !\nPlease enter 'C' for Clothing OR 'E' for Electronics.");
            }
        }else
            System.out.println("System is full !, Please remove products from the system.");
    }


    // Override method to remove a product from the system
    @Override
    public void removeProduct() {
        if (ProductsList.isEmpty()) {
            System.out.println("Product list is empty. Enter products to the system!");
        } else {
            System.out.println("Enter the product ID to remove: ");
            String removeItemID = managerInput.nextLine();

            // Variable to track whether the product was found
            boolean found = false;

            // Iterator to iterate over the ProductsList
            Iterator<Products> iterator = ProductsList.iterator();

            // Iterate over the ProductsList
            while (iterator.hasNext()) {
                // Get the next product from the iterator
                Products itr = iterator.next();


                if (removeItemID.equals(itr.getProductId())) {
                    // Remove the product from the list
                    iterator.remove();
                    System.out.println("Product removed successfully! \nYou can add"+getAvailableStock()+" products to the system.");
                    // Set found to true
                    found = true;
                    // Exit the loop since the product is found and removed
                    break;
                }
            }

            // If the product was not found, print a message
            if (!found) {
                System.out.println("No matching product ID!");
            }
        }
    }

    @Override
    public void printProductList() {
        if ( ProductsList.isEmpty()) {
            System.out.println("Product list is empty. Enter products to the system!");
        } else {
            Collections.sort(ProductsList, Comparator.comparing(Products::getProductId));

            for (Products i : ProductsList) {
                System.out.println(i.getProductId() + " - " +
                        i.getClass().getSimpleName() + " - " +
                        i.getProductName());
            }
        }

    }
    // Override method to save product data to a file
    @Override
    public void saveToAFile() {
        try {
            // Create a File object representing the file to be saved or created
            File productSaveFile = new File("ProductsList.txt");

            // Create a new file if it doesn't exist
            productSaveFile.createNewFile();

            // Sort the ProductsList based on productId before saving
            Collections.sort(ProductsList, Comparator.comparing(Products::getProductId));

            // Use try-with-resources to create a BufferedWriter for efficient writing
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(productSaveFile))) {
                // Iterate over each product in the ProductsList
                for (Products product : ProductsList) {
                    // Write product information to the file with a newline separator
                    writer.write(product.getProductId() + " - " + product.getClass() + " - " +
                            product.getProductName() + " - " +
                            product.getProductPrice() + " - " +
                            product.getAvailableItems());
                    // Move to the next line for the next product
                    writer.newLine();
                }
            }

            System.out.println("Data has been successfully saved to the file: " + productSaveFile.getAbsolutePath());
        } catch (IOException e) {
            // Handle IOException by throwing a RuntimeException
            throw new RuntimeException(e);
        }
    }
    public void loadDataFromSaveFile() {
        try {
            // Create a File object representing the file to be loaded
            File productSaveFile = new File("ProductsList.txt");

            // Check if the file exists
            if (!productSaveFile.exists()) {
                System.out.println("No saved data found.");
                return;
            }

            // Use try-with-resources to create a BufferedReader for efficient reading
            try (BufferedReader reader = new BufferedReader(new FileReader(productSaveFile))) {
                String line;

                // Read each line from the file
                while ((line = reader.readLine()) != null) {
                    // Print loaded data to the console
                    System.out.println("Loaded Data: " + line);

                }
            }


            System.out.println("Data has been successfully loaded from the file.");
        } catch (IOException e) {
            // Handle IOException by throwing a RuntimeException
            throw new RuntimeException(e);
        }
    }
    public int getAvailableStock(){
        availableStock =maximumProductCapacity - ProductsList.size();
        return availableStock;
    }

    @Override
    public String toString() {
        return "WestminsterShoppingManager{" +
                "availableStock=" + availableStock +
                ", maximumProductCapacity=" + maximumProductCapacity +
                '}';
    }
}
