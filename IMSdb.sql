CREATE DATABASE IMS;
USE IMS;

CREATE TABLE Inventory (
    ID INT NOT NULL PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Type VARCHAR(30) NOT NULL,
    Quantity INT NOT NULL,
    Location VARCHAR(50) NOT NULL,
    PurchaseDate DATE NOT NULL
);

INSERT INTO Inventory (ID, Name, Type, Quantity, Location, PurchaseDate) VALUES
    (1, "Hammer", "Tool", 10, "Warehouse A", '2023-10-26'),
    (2, "Screwdriver", "Tool", 25, "Toolbox 1", '2023-09-15'),
    (3, "Paintbrush", "Painting Supplies", 50, "Storage Room", '2023-08-01'),
    (4, "Ladder", "Equipment", 2, "Garage", '2023-07-07'),
    (5, "Nails", "Hardware", 1000, "Shelf B", '2023-06-20'),
    (6, "Tape Measure", "Tool", 15, "Toolbox 2", '2023-05-12'),
    (7, "Pliers", "Tool", 8, "Workbench", '2023-04-04'),
    (8, "Level", "Tool", 3, "Toolbox 3", '2023-03-17'),
    (9, "Saw", "Tool", 1, "Shed", '2023-02-24'),
    (10, "Drill", "Tool", 1, "Workshop", '2023-01-10'),
    (11, "Pencils", "Classroom Supplies", 200, "Teacher Desk", '2023-12-15'),
	(12, "Erasers", "Classroom Supplies", 150, "Supply Closet", '2023-11-24'),
	(13, "Markers", "Classroom Supplies", 30, "Art Desk", '2023-10-19'),
	(14, "Construction Paper", "Classroom Supplies", 500, "Paper Cabinet", '2023-09-08'),
	(15, "Stapler", "Office Supplies", 5, "Desk Drawer", '2023-08-03'),
	(16, "Paper Clips", "Office Supplies", 1000, "Supply Box", '2023-07-14'),
	(17, "Printer Cartridges", "Office Supplies", 3, "Storage Shelf", '2023-06-23'),
	(18, "Whiteboard Markers", "Office Supplies", 20, "Meeting Room", '2023-05-05'),
	(19, "Desk Lamp", "Office Equipment", 2, "Executive Office", '2023-04-21'),
	(20, "Computer Monitor", "Office Equipment", 5, "IT Department", '2023-03-10');

SELECT * FROM inventory;