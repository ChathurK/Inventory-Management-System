package ims;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InventoryManager {

    // Database connection object
    private Connection connection;

    // Constructor to establish database connection
    public InventoryManager() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Define database connection credentials
            String url = "jdbc:mysql://localhost:3306/IMS";
            String username = "root";
            String password = "MYsql2023#";

            // Connect to the database
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection successful!");
        } catch (SQLException | ClassNotFoundException e) {
            // Display error message
            JOptionPane.showMessageDialog(null, "Error connecting to database: " + e.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // CRUD methods for interacting with the database
    public void createItem(Inventory item) throws SQLException {
        // Prepare SQL statement
        String sql = "INSERT INTO Inventory (ID, Name, Type, Quantity, Location, PurchaseDate) VALUES (?, ?, ?, ?, ?, ?)";

        try (
                PreparedStatement statement = connection.prepareStatement(sql)) { // Create a prepared statement
            // Set statement parameters with item values
            statement.setInt(1, item.getId());
            statement.setString(2, item.getName());
            statement.setString(3, item.getType());
            statement.setInt(4, item.getQuantity());
            statement.setString(5, item.getLocation());
            statement.setDate(6, (Date) item.getPurchaseDate());
            // Execute the statement and get the number of affected rows
            int rowsAffected = statement.executeUpdate();
            // Check if item was added successfully
            if (rowsAffected == 1) {
                System.out.println("Item '" + item.getName() + "' added successfully!");
            } else {
                System.err.println("Error adding item!");
            }
            statement.close(); // Close the prepared statement
        }
    }

    public List<Inventory> readItems() throws SQLException {
        // Prepare SQL statement
        String sql = "SELECT * FROM Inventory";

        // Create a statement object
        Statement statement = connection.createStatement();

        // Execute the statement and get the results
        ResultSet resultSet = statement.executeQuery(sql);

        // Create an empty list to store retrieved items
        List<Inventory> items = new ArrayList<>();

        // Loop through the result set and create Inventory objects
        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("Name");
            String type = resultSet.getString("Type");
            int quantity = resultSet.getInt("Quantity");
            String location = resultSet.getString("Location");
            Date purchaseDate = resultSet.getDate("PurchaseDate");

            // Create a new Inventory object with data from the result set
            Inventory item2 = new Inventory(id, name, type, quantity, location, purchaseDate);

            // Add the item to the list
            items.add(item2);
        }
        // Close the result set and statement objects
        resultSet.close();
        statement.close();

        return items; // Return the list of retrieved items
    }

    public void updateItem(Inventory item) throws SQLException {
        // Prepare SQL statement
        String sql = "UPDATE Inventory SET Name = ?, Type = ?, Quantity = ?, Location = ?, PurchaseDate = ? WHERE ID = ?";

        // Create a prepared statement
        PreparedStatement statement = connection.prepareStatement(sql);

        // Set statement parameters with item values
        statement.setString(1, item.getName());
        statement.setString(2, item.getType());
        statement.setInt(3, item.getQuantity());
        statement.setString(4, item.getLocation());
        statement.setDate(5, (Date) item.getPurchaseDate());
        statement.setInt(6, item.getId());

        // Execute the statement and check affected rows
        int rowsAffected = statement.executeUpdate();

        // Check if item was updated successfully
        switch (rowsAffected) {
            case 1:
                System.out.println("Item '" + item.getName() + "' updated successfully!");
                break;
            case 0:
                System.err.println("Item with ID " + item.getId() + " not found!");
                break;
            default:
                System.err.println("Unexpected error updating item!");
                break;
        }
        statement.close(); // Close the prepared statement
    }

    public void deleteItem(int id) throws SQLException {
        // Prepare SQL statement
        String sql = "DELETE FROM Inventory WHERE ID = ?";

        // Create a prepared statement
        PreparedStatement statement = connection.prepareStatement(sql);

        // Set statement parameter with the ID of the item to delete
        statement.setInt(1, id);

        // Execute the statement and check affected rows
        int rowsAffected = statement.executeUpdate();

        // Check if item was deleted successfully
        if (rowsAffected == 1) {
            System.out.println("Item with ID " + id + " deleted successfully!");
        } else {
            System.err.println("Item with ID " + id + " not found!");
        }
        statement.close(); // Close the prepared statement
    }

    // Method to close the database connection
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
