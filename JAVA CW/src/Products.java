public abstract class Products {
    // Declare private instance variables
    private String ProductId;
    private String ProductName;
    private int AvailableItems;
    private int Price;

    // Parameterized constructor
    public Products(String ProductId, String ProductName, int AvailableItems, double Price) {
        // Initialize the attributes
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.AvailableItems = AvailableItems;
        this.Price = (int) Price;
    }

    // Default constructor
    public Products() {}


    public String getProductId() {
        return this.ProductId;
    }

    public String getProductName() {
        return this.ProductName;
    }

    public int getProductPrice() {
        return (int) this.Price;
    }


    public int getAvailableItems() {
        return this.AvailableItems;
    }


    public void setAvailableItems(int availableItems) {
        this.AvailableItems = availableItems;
    }


    public double getPrice() {
        return this.Price;
    }


    public void setPrice(double price) {
        this.Price = (int) price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "ProductId='" + ProductId + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", AvailableItems=" + AvailableItems +
                ", Price=" + Price +
                '}';
    }
}