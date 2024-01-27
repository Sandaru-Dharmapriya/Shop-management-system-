public class Electronics extends Products {
    // Declare private instance variables
    private String brand;
    private String warrantyPeriod;

    // Default constructor
    public Electronics() {}

    // Parameterized constructor
    public Electronics(String ProductId, String ProductName, int AvailableItems, double Price, String brand, String warrantyPeriod) {
        // Call the constructor of the superclass
        super(ProductId, ProductName, AvailableItems, Price);
        // Initialize the specific attributes for this class
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "brand='" + brand + '\'' +
                ", warrantyPeriod='" + warrantyPeriod + '\'' +
                '}';
    }
}