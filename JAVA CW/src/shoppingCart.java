import java.util.ArrayList;
import java.util.List;

public class shoppingCart {

    // Private field to store the list of products in the shopping cart
    private List<Products> cartProducts;

    // Default constructor
    public shoppingCart() {
        cartProducts = new ArrayList<>();
    }

    public void addProduct(Products product) {
        cartProducts.add(product);
        System.out.println(product.getProductName() + " Product added to the shopping cart.");
    }

    public void removeProduct(Products product) {

        if (cartProducts.remove(product)) {
            System.out.println(product.getProductName() + " Product removed from the shopping cart.");
        } else {
            System.out.println("Product not found in the shopping cart.");
        }
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;

        for (Products i : cartProducts) {
            // Add the product's price to the total cost
            totalCost += i.getProductPrice();
        }
        return totalCost;
    }

    public void displayShoppingCart() {
        if (cartProducts.isEmpty()) {
            System.out.println("The shopping cart is empty.");
        } else {
            System.out.println("Shopping Cart Contents:");
            for (Products i : cartProducts) {
                System.out.println(i.getProductName() + " - £" + i.getProductPrice());
            }
            System.out.println("Total Cost: £" + calculateTotalCost());
        }
    }

    @Override
    public String toString() {
        return "shoppingCart{" +
                "cartProducts=" + cartProducts +
                '}';
    }
}