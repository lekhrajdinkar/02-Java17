-- Customers Table
CREATE TABLE IF NOT EXISTS retailapp.Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(255) NOT NULL,
    ContactName VARCHAR(255),
    Country VARCHAR(255),
    Address VARCHAR(255),
    City VARCHAR(255),
    PostalCode VARCHAR(20)
);

-- Categories Table
CREATE TABLE IF NOT EXISTS retailapp.Categories (
    CategoryID INT PRIMARY KEY,
    CategoryName VARCHAR(255) NOT NULL,
    Description TEXT
);

-- Employees Table
CREATE TABLE IF NOT EXISTS retailapp.Employees (
    EmployeeID INT PRIMARY KEY,
    LastName VARCHAR(255) NOT NULL,
    FirstName VARCHAR(255) NOT NULL,
    BirthDate DATE,
    Photo VARCHAR(255),
    Notes TEXT
);

-- Suppliers Table
CREATE TABLE IF NOT EXISTS retailapp.Suppliers (
    SupplierID INT PRIMARY KEY,
    SupplierName VARCHAR(255) NOT NULL,
    ContactName VARCHAR(255),
    Country VARCHAR(255),
    Address VARCHAR(255),
    City VARCHAR(255),
    PostalCode VARCHAR(20)
);

-- Shippers Table
CREATE TABLE IF NOT EXISTS retailapp.Shippers (
    ShipperID INT PRIMARY KEY,
    ShipperName VARCHAR(255) NOT NULL,
    Phone VARCHAR(255)
);

-- Products Table
CREATE TABLE IF NOT EXISTS retailapp.Products (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(255) NOT NULL,
    SupplierID INT,
    CategoryID INT,
    Unit VARCHAR(255),
    Price DECIMAL(10, 2),
    FOREIGN KEY (SupplierID) REFERENCES retailapp.Suppliers(SupplierID),
    FOREIGN KEY (CategoryID) REFERENCES retailapp.Categories(CategoryID)
);

-- Orders Table
CREATE TABLE IF NOT EXISTS retailapp.Orders (
    OrderID INT PRIMARY KEY,
    CustomerID INT,
    EmployeeID INT,
    OrderDate DATE,
    ShipperID INT,
    FOREIGN KEY (CustomerID) REFERENCES retailapp.Customers(CustomerID),
    FOREIGN KEY (EmployeeID) REFERENCES retailapp.Employees(EmployeeID),
    FOREIGN KEY (ShipperID) REFERENCES retailapp.Shippers(ShipperID)
);

-- OrderDetails Table
CREATE TABLE IF NOT EXISTS retailapp.OrderDetails (
    OrderDetailID INT PRIMARY KEY,
    OrderID INT,
    ProductID INT,
    Quantity INT,
    FOREIGN KEY (OrderID) REFERENCES retailapp.Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES retailapp.Products(ProductID)
);

-- SHOP Table
CREATE TABLE IF NOT EXISTS retailapp.Shop (
    ShopID INT PRIMARY KEY,
    ShopName VARCHAR(255) NOT NULL,
    Address VARCHAR(255),
    City VARCHAR(255),
    PostalCode VARCHAR(20),
    Country VARCHAR(255)
);

-- CART Table
CREATE TABLE IF NOT EXISTS retailapp.Cart (
    CartID INT PRIMARY KEY,
    CustomerID INT,
    ProductID INT,
    Quantity INT,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (CustomerID) REFERENCES retailapp.Customers(CustomerID),
    FOREIGN KEY (ProductID) REFERENCES retailapp.Products(ProductID)
);

-- Inserting data into Customers table
INSERT INTO retailapp.Customers (CustomerID, CustomerName, ContactName, Country, Address, City, PostalCode) VALUES
(1, 'Alfreds Futterkiste', 'Maria Anders', 'Germany', 'Obere Str. 57', 'Berlin', '12209'),
(2, 'Ana Trujillo Emparedados y helados', 'Ana Trujillo', 'Mexico', 'Avda. de la Constitución 2222', 'México D.F.', '05021'),
(3, 'Antonio Moreno Taquería', 'Antonio Moreno', 'Mexico', 'Mataderos 2312', 'México D.F.', '05023'),
(4, 'Around the Horn', 'Thomas Hardy', 'UK', '120 Hanover Sq.', 'London', 'WA1 1DP'),
(5, 'Berglunds snabbköp', 'Christina Berglund', 'Sweden', 'Berguvsvägen 8', 'Luleå', 'S-958 22'),
(6, 'Blauer See Delikatessen', 'Hanna Moos', 'Germany', 'Forsterstr. 57', 'Mannheim', '68306'),
(7, 'Blondel père et fils', 'Frédérique Citeaux', 'France', '24, place Kléber', 'Strasbourg', '67000'),
(8, 'Bólido Comidas preparadas', 'Martín Sommer', 'Spain', 'C/ Araquil, 67', 'Madrid', '28023'),
(9, 'Bon app', 'Laurence Lebihans', 'France', '12, rue des Bouchers', 'Marseille', '13008'),
(10, 'Bottom-Dollar Marketse', 'Elizabeth Lincoln', 'Canada', '23 Tsawassen Blvd.', 'Tsawassen', 'T2F 8M4');


-- Inserting data into Categories table
INSERT INTO retailapp.Categories (CategoryID, CategoryName, Description) VALUES
(1, 'Beverages', 'Soft drinks, coffees, teas, beers, and ales'),
(2, 'Condiments', 'Sweet and savory sauces, relishes, spreads, and seasonings'),
(3, 'Confections', 'Desserts, candies, and sweet breads'),
(4, 'Dairy Products', 'Cheeses'),
(5, 'Grains/Cereals', 'Breads, crackers, pasta, and cereal'),
(6, 'Meat/Poultry', 'Prepared meats'),
(7, 'Produce', 'Dried fruit and bean curd'),
(8, 'Seafood', 'Seaweed and fish');

-- Inserting data into Employees table
INSERT INTO retailapp.Employees (EmployeeID, LastName, FirstName, BirthDate, Photo, Notes) VALUES
(1, 'Davolio', 'Nancy', '1948-12-08', 'nancy.jpg', 'Sales Representative'),
(2, 'Fuller', 'Andrew', '1952-02-19', 'andrew.jpg', 'Vice President, Sales'),
(3, 'Leverling', 'Janet', '1963-08-30', 'janet.jpg', 'Sales Representative'),
(4, 'Peacock', 'Margaret', '1937-09-19', 'margaret.jpg', 'Sales Representative'),
(5, 'Buchanan', 'Steven', '1955-03-04', 'steven.jpg', 'Sales Manager'),
(6, 'Suyama', 'Michael', '1963-07-02', 'michael.jpg', 'Sales Representative'),
(7, 'King', 'Robert', '1960-05-29', 'robert.jpg', 'Sales Representative'),
(8, 'Callahan', 'Laura', '1958-01-09', 'laura.jpg', 'Inside Sales Coordinator'),
(9, 'Dodsworth', 'Anne', '1966-01-27', 'anne.jpg', 'Sales Representative');

-- Inserting data into Suppliers table
INSERT INTO retailapp.Suppliers (SupplierID, SupplierName, ContactName, Country, Address, City, PostalCode) VALUES
(1, 'Exotic Liquids', 'Charlotte Cooper', 'UK', '49 Gilbert St.', 'London', 'EC1 4SD'),
(2, 'New Orleans Cajun Delights', 'Shelley Burke', 'USA', 'P.O. Box 78934', 'New Orleans', '70117'),
(3, 'Grandma Kelly’s Homestead', 'Regina Murphy', 'USA', '707 Oxford Rd.', 'Ann Arbor', '48104'),
(4, 'Tokyo Traders', 'Yoshi Nagase', 'Japan', '9-8 Sekimai Musashino-shi', 'Tokyo', '100-0003'),
(5, 'Cooperativa de Quesos ‘Las Cabras’', 'Antonio del Valle Saavedra', 'Spain', 'Calle del Rosal 4', 'Oviedo', '33007'),
(6, 'Mayumi’s', 'Mayumi Ohno', 'Japan', '92 Setsuko Chuo-ku', 'Osaka', '545-0052'),
(7, 'Pavlova, Ltd.', 'Ian Devling', 'Australia', '74 Rose St. Moonie Ponds', 'Melbourne', '3058'),
(8, 'Specialty Biscuits, Ltd.', 'Peter Wilson', 'UK', '29 Kings Way', 'Manchester', 'M14 GDM'),
(9, 'PB Knäckebröd AB', 'Lars Peterson', 'Sweden', 'Kaloadagatan 13', 'Göteborg', 'S-345 67'),
(10, 'Refrescos Americanas LTDA', 'Carlos Diaz', 'Brazil', 'Av. das Americanas 12.890', 'Sao Paulo', '01310-200');

-- Inserting data into Shippers table
INSERT INTO retailapp.Shippers (ShipperID, ShipperName, Phone) VALUES
(1, 'Speedy Express', '555-2345'),
(2, 'United Package', '555-3412'),
(3, 'Federal Shipping', '555-9931');

-- Inserting data into Products table
INSERT INTO retailapp.Products (ProductID, ProductName, SupplierID, CategoryID, Unit, Price) VALUES
(1, 'Chai', 1, 1, '10 boxes x 20 bags', 18.00),
(2, 'Chang', 1, 1, '24 - 12 oz bottles', 19.00),
(3, 'Aniseed Syrup', 1, 2, '12 - 550 ml bottles', 10.00),
(4, 'Chef Antons Cajun Seasoning', 2, 2, '48 - 6 oz jars', 22.00),
(5, 'Chef Antons Gumbo Mix', 2, 2, '36 boxes', 21.35),
(6, 'Grandmas Boysenberry Spread', 3, 2, '12 - 8 oz jars', 25.00),
(7, 'Uncle Bobs Organic Dried Pears', 3, 7, '12 - 1 lb pkgs.', 30.00),
(8, 'Northwoods Cranberry Sauce', 3, 2, '12 - 12 oz jars', 40.00),
(9, 'Mishi Kobe Niku', 4, 6, '18 - 500 g pkgs.', 97.00),
(10, 'Ikura', 4, 8, '12 - 200 ml jars', 31.00),
(11, 'Queso Cabrales', 5, 4, '1 kg pkg.', 21.00),
(12, 'Queso Manchego La Pastora', 5, 4, '10 - 500 g pkgs.', 38.00),
(13, 'Tofu', 6, 7, '40 - 100 g pkgs.', 23.25),
(14, 'Genen Shouyu', 6, 2, '24 - 250 ml bottles', 15.50),
(15, 'Pavlova', 7, 3, '32 - 500 g boxes', 17.45);

-- Inserting data into Orders table
INSERT INTO retailapp.Orders (OrderID, CustomerID, EmployeeID, OrderDate, ShipperID) VALUES
(1, 1, 1, '2024-01-01', 1),
(2, 2, 2, '2024-01-02', 2),
(3, 3, 3, '2024-01-03', 3),
(4, 4, 4, '2024-01-04', 1),
(5, 5, 5, '2024-01-05', 2),
(6, 6, 6, '2024-01-06', 3),
(7, 7, 7, '2024-01-07', 1),
(8, 8, 8, '2024-01-08', 2),
(9, 9, 9, '2024-01-09', 3),
(10, 10, 1, '2024-01-10', 1),
(11, 1, 2, '2024-01-11', 2),
(12, 2, 3, '2024-01-12', 3),
(13, 3, 4, '2024-01-13', 1),
(14, 4, 5, '2024-01-14', 2),
(15, 5, 6, '2024-01-15', 3);

-- Inserting data into OrderDetails table
INSERT INTO retailapp.OrderDetails (OrderDetailID, OrderID, ProductID, Quantity) VALUES
(1, 1, 1, 10),
(2, 2, 2, 20),
(3, 3, 3, 15),
(4, 4, 4, 25),
(5, 5, 5, 30),
(6, 6, 6, 5),
(7, 7, 7, 10),
(8, 8, 8, 20),
(9, 9, 9, 15),
(10, 10, 10, 25),
(11, 11, 11, 30),
(12, 12, 12, 5),
(13, 13, 13, 10),
(14, 14, 14, 20),
(15, 15, 15, 15);

-- Inserting data into Shop table
INSERT INTO retailapp.Shop (ShopID, ShopName, Address, City, PostalCode, Country) VALUES
(1, 'Shop A', '123 Main St', 'New York', '10001', 'USA'),
(2, 'Shop B', '456 Maple Ave', 'Los Angeles', '90001', 'USA'),
(3, 'Shop C', '789 Elm St', 'Chicago', '60601', 'USA'),
(4, 'Shop D', '101 Oak St', 'Houston', '77001', 'USA'),
(5, 'Shop E', '202 Pine St', 'Phoenix', '85001', 'USA'),
(6, 'Shop F', '303 Cedar St', 'Philadelphia', '19101', 'USA'),
(7, 'Shop G', '404 Birch St', 'San Antonio', '78201', 'USA'),
(8, 'Shop H', '505 Walnut St', 'San Diego', '92101', 'USA'),
(9, 'Shop I', '606 Spruce St', 'Dallas', '75201', 'USA'),
(10, 'Shop J', '707 Fir St', 'San Jose', '95101', 'USA');

-- Inserting data into Cart table
INSERT INTO retailapp.Cart (CartID, CustomerID, ProductID, Quantity) VALUES
(1, 1, 1, 2),
(2, 2, 2, 1),
(3, 3, 3, 4),
(4, 4, 4, 3),
(5, 5, 5, 5),
(6, 6, 6, 2),
(7, 7, 7, 1),
(8, 8, 8, 3),
(9, 9, 9, 2),
(10, 10, 10, 4),
(11, 1, 11, 1),
(12, 2, 12, 2),
(13, 3, 13, 3),
(14, 4, 14, 1),
(15, 5, 15, 2);

commit;