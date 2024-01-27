import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class UserInterface extends JFrame implements ActionListener {
    // Declare private instance variables for GUI components
    private JButton cartButton;
    private JComboBox<String> combo;
    private JTable table01;
    private JFrame frame01;
    private JLabel lable01;
    private JPanel panel01;
    private JPanel panel02;
    WestminsterShoppingManager westminsterShoppingManagerOBJ = new WestminsterShoppingManager();

    // Define an array for the JComboBox
    String[] comboItems = {"Clothing", "Electronics", "All"};

    public void userInterface() {
        panel01 = new JPanel();
        panel02 = new JPanel();

        // Initialize components
        cartButton = new JButton("Shopping Cart");
        combo = new JComboBox<>(comboItems);
        lable01 = new JLabel("Select Product Category");

        // Initialize table components
        Object[][] table01Data = {};
        String[] table01ColumnNames = {"Product ID", "Name", "Category", "Price (£)", "Info"};
        DefaultTableModel table01Model = new DefaultTableModel(table01Data, table01ColumnNames);
        table01 = new JTable(table01Model);
        JScrollPane table01Scroll = new JScrollPane(table01);

        // Initialize the main frame
        frame01 = new JFrame();
        frame01.setTitle("Westminster Shopping Center");
        frame01.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame01.setResizable(false);
        frame01.setSize(550, 600);
        frame01.setLayout(null);

        // Set bounds for GUI components
        cartButton.setBounds(400, 10, 120, 30);
        combo.setBounds(200, 58, 120, 30);
        table01Scroll.setBounds(50, 100, 400, 200);
        lable01.setBounds(50, 58, 150, 30);

        // Add components to the frame
        frame01.add(cartButton);
        frame01.add(combo);
        frame01.add(table01Scroll);
        frame01.add(lable01);

        // Customize appearance of components
        cartButton.setBackground(Color.lightGray);
        cartButton.setFont(new Font("Sans-serif", Font.PLAIN, 12));
        combo.setBackground(Color.lightGray);
        combo.setFont(new Font("Sans-serif", Font.PLAIN, 12));

        // Add action listeners for button and combo box
        cartButton.addActionListener(this);
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) combo.getSelectedItem();
                if (selectedType.equals("All"))
                    updateTableWithAllTypes();

                if (selectedType.equals("Electronics"))
                    updateTableWithElectronicsTypes();

                if (selectedType.equals("Clothing"))
                    updateTableWithClothingTypes();
            }
        });

        // Set an image icon for the frame
        ImageIcon img = new ImageIcon("Logo.png");
        frame01.setIconImage(img.getImage());

        // Make the frame visible
        frame01.setVisible(true);
    }

    // ActionListener method for handling button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cartButton) {
            shoppingCartWindow();
        }
    }

    // Method display the shopping cart window
    public void shoppingCartWindow() {
        JFrame frame02 = new JFrame();

        frame02.setTitle("Shopping Cart");
        frame02.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame02.setResizable(false);
        frame02.setSize(550, 550);
        frame02.setVisible(true);
        frame02.setLayout(null);
    }

    // Method to update the table with all types of products
    private void updateTableWithAllTypes() {
        DefaultTableModel tableModel = (DefaultTableModel) table01.getModel();
        List<Products> productsList = westminsterShoppingManagerOBJ.getProductList();
        tableModel.setRowCount(0);

        Collections.sort(productsList, Comparator.comparing(Products::getProductId));

        for (Products i : productsList) {
            tableModel.addRow(new Object[]{
                    i.getProductId(),
                    i.getProductName(),
                    i.getClass().getSimpleName(),
                    i.getProductPrice(),
                    "Additional Info"
            });
        }
    }

    // Method to update the table with electronics types of products
    private void updateTableWithElectronicsTypes() {
        DefaultTableModel tableModel = (DefaultTableModel) table01.getModel();
        List<Products> productsList = westminsterShoppingManagerOBJ.getProductList();
        tableModel.setRowCount(0);

        Collections.sort(productsList, Comparator.comparing(Products::getProductId));

        for (Products i : productsList) {
            if (i.getClass().getSimpleName().equals("Electronics"))
                tableModel.addRow(new Object[]{
                        i.getProductId(),
                        i.getProductName(),
                        i.getClass().getSimpleName(),
                        i.getProductPrice(),
                        "Additional Info"
                });
        }
    }

    // Method to update the table with clothing types of products
    private void updateTableWithClothingTypes() {
        DefaultTableModel tableModel = (DefaultTableModel) table01.getModel();
        List<Products> productsList = westminsterShoppingManagerOBJ.getProductList();
        tableModel.setRowCount(0);

        Collections.sort(productsList, Comparator.comparing(Products::getProductId));

        for (Products i : productsList) {
            if (i.getClass().getSimpleName().equals("Clothing")) {
                tableModel.addRow(new Object[]{
                        i.getProductId(),
                        i.getProductName(),
                        i.getClass().getSimpleName(),
                        i.getProductPrice(),
                         "Additional Info"
                });
            }
        }
    }

}






