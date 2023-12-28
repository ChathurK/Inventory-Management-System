package ims;

import java.sql.*;
import java.util.List;

public class InventoryTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Create an InventoryManager instance
        InventoryManager inventoryManager = new InventoryManager();
        
        // Create a new inventory item
//        Inventory item = new Inventory(13,"Table", "", 1, "Office b", new Date(2022, 6, 10));
        
        // Attempt to add the item, handling potential SQL errors
//        try {
//            inventoryManager.createItem(item); // Call the createItem() method
//        } catch (SQLException e) {
//            System.err.println("Error adding item: " + e.getMessage());
//        }
        
        // Create an item for updating an existing record
//        Inventory upitem = new Inventory(33,"Table", "Lecture hall 1", 5, "Office c", new Date(2021, 1, 13));
//        inventoryManager.updateItem(upitem);

        // Delete an item by its ID     
//        inventoryManager.deleteItem(23);

        // Retrieve all items from the inventory       
        List<Inventory> viewItems = inventoryManager.readItems();
        
        for (Inventory items : viewItems) {
            System.out.println(items); // Print each item to the console
        }
        
        inventoryManager.closeConnection(); // Close the database connection
    }
}
