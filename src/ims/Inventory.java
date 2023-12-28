package ims;

import java.util.Date;

public class Inventory {

    private int id;
    private String name;
    private String type;
    private int quantity;
    private String location;
    private Date purchaseDate;

    // Constructors (including one with all fields)
    public Inventory(int id, String name, String type, int quantity, String location, Date purchaseDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.location = location;
        this.purchaseDate = purchaseDate;
    }

    // Getters and setters for all fields
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getLocation() {
        return location;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    // toString() method for meaningful representation
    @Override
    public String toString() {
        return "InventoryItem{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", type='" + type + '\''
                + ", quantity=" + quantity
                + ", location='" + location + '\''
                + ", purchaseDate=" + purchaseDate
                + '}';
    }
}
