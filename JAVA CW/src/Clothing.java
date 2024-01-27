public class Clothing extends Products {
    // Declare instance variables
    private String size;
    private String color;

    // Constructor for creating a Clothing object
    public Clothing(String productId, String productName, int availableItems, double price, String size, String color) {
        // Call the constructor of the superclass
        super(productId, productName, availableItems, price);
        // Initialize the other attributes
        this.size = size;
        this.color = color;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Clothing{" +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}