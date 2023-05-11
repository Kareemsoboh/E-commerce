package com.example.database;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Queries {
    private static String dbURL;
    private static String dbUsername = "root";
    private static String dbPassword = "karimbo";
    private static String URL = "127.0.0.1";
    private static String port = "3306";
    private static String dbName = "ecommerce";
    private static Connection con;

    public static void connectDB() throws ClassNotFoundException, SQLException {

        dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
        Properties p = new Properties();
        p.setProperty("user", dbUsername);
        p.setProperty("password", dbPassword);
        p.setProperty("useSSL", "false");
        p.setProperty("autoReconnect", "true");
        Class.forName("com.example.database.Driver");
        con = DriverManager.getConnection(dbURL, p);


    }

    public static void ExecuteStatement(String SQL) throws SQLException {

        try {
            System.out.println(SQL);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            stmt.close();

        } catch (SQLException s) {
            System.out.println(s);
            AlertBox.display("SQL statement is not executed!");

        }

    }

    public static ObservableList<Customer> getCustomers() throws ClassNotFoundException, SQLException, ParseException {
        ObservableList<Customer> customersOb = FXCollections.observableArrayList();
        String SQL;

        connectDB();

        SQL = "select cid,Fname,Lname,Bdate,Email,Password from Customer order by cid";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {


            // Date date1= (Date) new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString(4));
            Customer customer = new Customer(rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(1)),
                    rs.getString(4), rs.getString(5), rs.getString(6)
            );

            customersOb.add(customer);

        }
        rs.close();
        stmt.close();

        con.close();
        return customersOb;

    }

    public static ObservableList<Product> getProducts() throws ClassNotFoundException, SQLException {
        ObservableList<Product> ProductsOb = FXCollections.observableArrayList();
        String SQL;

        connectDB();

        SQL = "select * from product;";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            int id = Integer.parseInt(rs.getString(1));
            int teacherId = Integer.parseInt(rs.getString(4));
            Product e = new Product(id, rs.getString(2), rs.getString(7), rs.getString(8), Integer.parseInt(rs.getString(4)),
                    Float.parseFloat(rs.getString(3)), Integer.parseInt(rs.getString(6)), Integer.parseInt(rs.getString(5)));

            ProductsOb.add(e);

        }
        rs.close();
        stmt.close();

        con.close();
        return ProductsOb;

    }

    public static ObservableList<Order> getOrders() throws ClassNotFoundException, SQLException, ParseException {
        ObservableList<Order> OrdersOb = FXCollections.observableArrayList();
        String SQL;

        connectDB();

        SQL = "select * from eorder;";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            int id = Integer.parseInt(rs.getString(1));
            //Date date1= (Date) new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString(2));

            Order e = new Order(id, rs.getString(2), Integer.parseInt(rs.getString(3)), Integer.parseInt(rs.getString(5)), Integer.parseInt(rs.getString(4)), Float.parseFloat(rs.getString(6)));
            OrdersOb.add(e);

        }
        rs.close();
        stmt.close();

        con.close();
        return OrdersOb;

    }

    public static ObservableList<Employee> getEmployees() throws ClassNotFoundException, SQLException {
        ObservableList<Employee> EmployeeOb = FXCollections.observableArrayList();
        String SQL;

        connectDB();

        SQL = "select * from Employee;";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            int id = Integer.parseInt(rs.getString(1));
            Employee e = new Employee(id, rs.getString(2), rs.getString(3));

            EmployeeOb.add(e);

        }
        rs.close();
        stmt.close();

        con.close();
        return EmployeeOb;

    }

    public static ObservableList<Address> getAddress() throws ClassNotFoundException, SQLException {
        ObservableList<Address> Address = FXCollections.observableArrayList();
        String SQL;

        connectDB();

        SQL = "select * from Address;";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            int id = Integer.parseInt(rs.getString(1));
            Address e = new Address(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

            Address.add(e);

        }
        rs.close();
        stmt.close();

        con.close();
        return Address;

    }

    public static ObservableList<Cash> getCash() throws ClassNotFoundException, SQLException {
        ObservableList<Cash> cash = FXCollections.observableArrayList();
        String SQL;

        connectDB();

        SQL = "select * from cash;";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            int id = Integer.parseInt(rs.getString(1));
            Float amount = Float.parseFloat(rs.getString(2));

            Cash e = new Cash(id, amount);

            cash.add(e);

        }
        rs.close();
        stmt.close();

        con.close();
        return cash;

    }

    public static ObservableList<CreditCard> getCreditCard() throws ClassNotFoundException, SQLException {
        ObservableList<CreditCard> creditcard = FXCollections.observableArrayList();
        String SQL;

        connectDB();

        SQL = "select * from creditcard;";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            int id = Integer.parseInt(rs.getString(1));
            Float amount = Float.parseFloat(rs.getString(2));

            CreditCard e = new CreditCard(id, Integer.parseInt(rs.getString(3)), rs.getString(4), Integer.parseInt(rs.getString(5)), amount);

            creditcard.add(e);

        }
        rs.close();
        stmt.close();

        con.close();
        return creditcard;

    }

    public static ObservableList<Payment> getPayment() throws ClassNotFoundException, SQLException {
        ObservableList<Payment> payments = FXCollections.observableArrayList();
        String SQL;

        connectDB();

        SQL = "select * from payment;";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            int id = Integer.parseInt(rs.getString(1));
            Float amount = Float.parseFloat(rs.getString(2));

            Payment e = new Payment(id, amount);
            payments.add(e);

        }
        rs.close();
        stmt.close();

        con.close();
        return payments;

    }

    public static ObservableList<orderproduct> getCart() throws ClassNotFoundException, SQLException {
        ObservableList<orderproduct> ProductsOb = FXCollections.observableArrayList();
        String SQL;

        connectDB();

        SQL = "select * from cart";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            System.out.println(rs.getString(4));
            int id = Integer.parseInt(rs.getString(1));
            int id1 = Integer.parseInt(rs.getString(2));
            orderproduct e = new orderproduct(id, id1, rs.getString(3), Float.parseFloat(rs.getString(4)));

            ProductsOb.add(e);

        }
        rs.close();
        stmt.close();

        con.close();
        return ProductsOb;

    }

    public static void insertCustomer(Customer customer) {
        try {
            connectDB();

            ExecuteStatement("Insert into customer (Fname,Lname,Bdate,Email,Password) values(" + "'"
                    + customer.getFirstName() + "','" + customer.getLastName() + "','" + customer.getBirthDate() + "','" + customer.getEmail()
                    + "','" + customer.getPassword() + "');");

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            AlertBox.display("SQL statement is not executed!");
        }
    }

    public static void insertProduct(Product product) {
      /*  try{
            connectDB();
        }catch(ClassNotFoundException | SQLException e) {
                System.out.println("hhh");
        };*/

        try {
            connectDB();

            ExecuteStatement("Insert into Product (pname,price,quantity,category_id,empid,size,colour) values('"
                    + product.getProductName() + "'," + product.getPrice() + "," + product.getQuantity()
                    + "," + product.getCategoryID() + "," + product.getEmployeeID() + ",'" + product.getSize() + "','" + product.getColour() + "'" + ");");

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public static void insertEmployee(Employee employee) {
        try {
            connectDB();

            ExecuteStatement("Insert into employee (user_name,password) values(" + "'"
                    + employee.getUserName() + "','" + employee.getPassword() + "');");

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            AlertBox.display("SQL statement is not executed!");
        }
    }

    public static void updateCustomerPassword(Customer customer) throws SQLException, ClassNotFoundException {
        connectDB();
        ExecuteStatement("UPDATE customer set Fname = '" + customer.getFirstName() + "',Lname = '" + customer.getLastName() +
                "', Bdate = '" + customer.getBirthDate() + "',Email = '" + customer.getEmail() + "'," +
                "Password = '" + customer.getPassword() + "' where cid = " + customer.getCustomerID());
        con.close();
    }

    public static void updateProductQuantity(String pname, int quantity, String size, String colour, float price) throws SQLException, ClassNotFoundException {
        connectDB();
        ExecuteStatement("UPDATE product set quantity = " + quantity + ",size = '" + size + "',colour = '" + colour + "',price = " + price + " where pname = '" + pname + "'");
        con.close();
    }

    public static void updateProductPrice(String name, int quantity) throws SQLException, ClassNotFoundException {
        connectDB();
        ExecuteStatement("UPDATE product set quantity = " + quantity + " where pname = '" + name + "'");
        con.close();
    }

    public static void updateEmployeePassword(int employeeId, String newPassword) throws SQLException, ClassNotFoundException {
        connectDB();
        ExecuteStatement("UPDATE Employee set password = '" + newPassword + "' where empid = " + employeeId);
        con.close();
    }

    public static void DeleteCustomer(int customerId) throws SQLException, ClassNotFoundException {
        connectDB();
        ExecuteStatement("DELETE From customer where cid = " + customerId);
        con.close();
    }

    public static void DeleteProduct(String name) throws SQLException, ClassNotFoundException {
        connectDB();
        ExecuteStatement("DELETE From product where pname = '" + name + "'");
        con.close();
    }

    public static void DeleteEmployee(int EmployeeId) throws SQLException, ClassNotFoundException {
        connectDB();
        ExecuteStatement("DELETE From employee where empid = " + EmployeeId);
        con.close();
    }

    public static void DeleteOrder(int oid) throws SQLException, ClassNotFoundException {
        connectDB();
        ExecuteStatement("DELETE From order where oid = " + oid);
        con.close();
    }

    public static void insertAddress(Address address) {
        try {
            connectDB();

            ExecuteStatement("Insert into Address (city,village,street,phone) values(" + "'"
                    + address.getCity() + "','" + address.getVillage() + "','" + address.getStreet()
                    + "','" + address.getPhone() + "');");

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            AlertBox.display("SQL statement is not executed!");
        }
    }

    public static void insertCash(Cash cash) {
        try {
            connectDB();

            ExecuteStatement("Insert into payment (amount) values(" + cash.getAmount() + ");");
            ObservableList<Payment> list = getPayment();
            connectDB();
            int id = list.get(list.size() - 1).getPaymentID();
            ExecuteStatement("Insert into cash (payment_id,amount) values(" + id + "," + cash.getAmount() + ");");
            cash.setPaymentID(id);
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            AlertBox.display("SQL statement is not executed!");
        }
    }

    public static void insertCreditCard(CreditCard creditCard) {
        try {
            connectDB();

            ExecuteStatement("Insert into payment (amount) values(" + creditCard.getAmount() + ");");
            ObservableList<Payment> list = getPayment();
            connectDB();
            int id = list.get(list.size() - 1).getPaymentID();
            ExecuteStatement("Insert into creditcard (payment_id,amount,number,date,cvv) values(" + id + "," + creditCard.getAmount() + ",'" + creditCard.getNumber() +
                    "','" + creditCard.getCardDate() + "','" + creditCard.getCvvCode() + "');");
            creditCard.setPaymentID(id);
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            AlertBox.display("SQL statement is not executed!");
        }
    }

    public static void insertOrder(Order order) {
        try {
            connectDB();

            ExecuteStatement("Insert into eorder (odate,Aid,cid,payment_id,amount) values('"
                    + order.getOrderDate() + "'," + order.getAddressID() + "," + order.getCustomerID() + "," +
                    order.getPaymentID() + "," + order.getAmount() + ");");

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            AlertBox.display("SQL statement is not executed!");
        }
    }

    public static void insertCart(int oid, int pid, String description, Float amount) {
        try {
            connectDB();

            ExecuteStatement("Insert into cart (oid,pid,pdescription,amount) values(" + oid + "," + pid + ",'" + description +
                    "'," + amount + ");");

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            AlertBox.display("SQL statement is not executed!");
        }
    }


}
