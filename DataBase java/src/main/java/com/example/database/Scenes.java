package com.example.database;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;


public class Scenes {

    static String resultOrder = "";
    static float FinalCost = 0;
    static Address address1;
    public static int IDEmp;

    public static Scene Login(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1370, 700);

        try {
            GridPane pane = new GridPane();
            Font font2 = new Font("Comic Sans Ms", 25);

            Button login = new Button("Log In");
            login.setTextFill(Color.BLACK);
            login.setStyle("-fx-background-color:gray");
            login.setFont(new Font("bold", 20));
            login.setPrefWidth(200);
            login.setPrefHeight(50);
            login.setFont(font2);


            Label log = new Label("Log in");
            log.setTextFill(Color.BLACK);
            log.setPrefWidth(200);
            log.setPrefHeight(100);
            log.setFont(font2);

            Label user = new Label("User Name: ");
            user.setTextFill(Color.BLACK);
            user.setPrefWidth(150);
            user.setPrefHeight(20);
            user.setFont(font2);

            Label pass = new Label("Password: ");
            pass.setTextFill(Color.BLACK);
            pass.setPrefWidth(150);
            pass.setPrefHeight(20);
            pass.setFont(font2);

            Label welcome = new Label("       Welcome to our Shopping System    ");
            welcome.setFont(font2);
            welcome.setTextFill(Color.BLACK);
            welcome.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            welcome.setMaxHeight(600);
            welcome.setMaxWidth(600);

            Button exit = new Button("exit");
            exit.setMaxHeight(200);
            exit.setMaxWidth(100);
            exit.setTextFill(Color.BLACK);
            exit.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            exit.setFont(font2);

            TextField name = new TextField();
            name.setMaxHeight(40);
            name.setMaxWidth(200);

            TextField password = new TextField();
            password.setMaxHeight(40);
            password.setMaxWidth(200);

            HBox customer = new HBox(user, name);
            customer.setSpacing(15);
            customer.setPadding(new Insets(25));
            customer.setAlignment(Pos.CENTER_LEFT);

            HBox customer1 = new HBox(pass, password);
            customer1.setSpacing(15);
            customer1.setPadding(new Insets(25));
            customer1.setAlignment(Pos.CENTER_LEFT);
            login.setOnAction(e -> {
                try {
                    ObservableList<Customer> customers = Queries.getCustomers();
                    ObservableList<Employee> employees = Queries.getEmployees();
                    String user1 = name.getText();
                    String password1 = password.getText();
                    for (int i = 0; i < customers.size(); i++) {
                        if (customers.get(i).getEmail().equals(user1)) {
                            if (customers.get(i).getPassword().equals(password1)) {
                                primaryStage.setScene(product(primaryStage));
                                resultOrder += customers.get(i).getCustomerID() + ",";
                                break;
                            }

                        }
                    }
                    for (int i = 0; i < employees.size(); i++) {
                        if (employees.get(i).getUserName().equals(user1)) {
                            if (employees.get(i).getPassword().equals(password1)) {
                                IDEmp = employees.get(i).getEmployeeID();
                                primaryStage.setScene(Main.Main(primaryStage));
                                break;
                            }

                        }
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

            });
            Label sign = new Label("   Need An account ?   ");
            sign.setFont(font2);
            sign.setTextFill(Color.GRAY);
            sign.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:black;");
            sign.setMaxHeight(400);
            sign.setMaxWidth(400);

            Button signup = new Button("Sign Up");
            signup.setMaxHeight(20);
            signup.setMaxWidth(150);
            signup.setTextFill(Color.GRAY);
            signup.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:black;");
            signup.setFont(font2);

            signup.setOnAction(e -> {
                primaryStage.setScene(SignUp(primaryStage));
            });

            pane.add(log, 0, 0);
            pane.add(customer, 0, 2);
            pane.add(customer1, 0, 3);
            pane.add(login, 0, 5);
            pane.add(sign, 0, 6);
            pane.add(signup, 0, 7);
            pane.add(exit, 0, 8);

            pane.setAlignment(Pos.CENTER);
            pane.setHgap(5);
            pane.setVgap(5);
            root.setTop(welcome);
            root.setAlignment(welcome, Pos.TOP_CENTER);
            pane.setPadding(new Insets(150, 150, 150, 150));
            root.setCenter(pane);
            root.setAlignment(pane, Pos.CENTER);

            exit.setOnAction(e -> {
                primaryStage.hide();
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }

    public static Scene TShirt(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1370, 700);

        try {
            GridPane pane = new GridPane();
            Font font2 = new Font("Comic Sans Ms", 25);

            Button back = new Button("Back");
            back.setTextFill(Color.BLACK);
            back.setStyle("-fx-background-color:gray");
            back.setFont(new Font("bold", 20));
            back.setPrefWidth(200);
            back.setPrefHeight(50);
            back.setFont(font2);

            back.setOnAction(e -> {
                primaryStage.setScene(product(primaryStage));
            });

            Button buy = new Button("Buy now");
            buy.setTextFill(Color.BLACK);
            buy.setStyle("-fx-background-color:gray");
            buy.setFont(new Font("bold", 20));
            buy.setPrefWidth(200);
            buy.setPrefHeight(50);
            buy.setFont(font2);


            Label Tlable = new Label("T - Shirt");
            Tlable.setTextFill(Color.BLACK);
            Tlable.setPrefWidth(200);
            Tlable.setPrefHeight(100);
            Tlable.setFont(font2);

            Label size = new Label("Size : ");
            size.setTextFill(Color.BLACK);
            size.setPrefWidth(100);
            size.setPrefHeight(100);
            size.setFont(font2);

            RadioButton m = new RadioButton("M");
            RadioButton l = new RadioButton("L");
            RadioButton xl = new RadioButton("XL");

            ToggleGroup toggle = new ToggleGroup();

            m.setToggleGroup(toggle);
            m.setFont(font2);
            m.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            m.setTextFill(Color.BLACK);
            m.setMaxHeight(400);
            m.setMaxWidth(400);
            l.setToggleGroup(toggle);
            l.setFont(font2);
            l.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            l.setTextFill(Color.BLACK);
            l.setMaxHeight(400);
            l.setMaxWidth(400);
            xl.setToggleGroup(toggle);
            xl.setFont(font2);
            xl.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            xl.setTextFill(Color.BLACK);
            xl.setMaxHeight(400);
            xl.setMaxWidth(400);

            HBox shirt = new HBox(m, l, xl);
            shirt.setSpacing(15);
            shirt.setPadding(new Insets(25));
            shirt.setAlignment(Pos.CENTER_LEFT);


            Label color = new Label("Color: ");
            color.setTextFill(Color.BLACK);
            color.setPrefWidth(150);
            color.setPrefHeight(20);
            color.setFont(font2);

            RadioButton black = new RadioButton("Black");
            RadioButton white = new RadioButton("White");
            RadioButton blue = new RadioButton("Blue");
            RadioButton green = new RadioButton("Green");

            ToggleGroup toggle1 = new ToggleGroup();

            black.setToggleGroup(toggle1);
            black.setFont(font2);
            black.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            black.setTextFill(Color.BLACK);
            black.setMaxHeight(400);
            black.setMaxWidth(400);
            white.setToggleGroup(toggle1);
            white.setFont(font2);
            white.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            white.setTextFill(Color.BLACK);
            white.setMaxHeight(400);
            white.setMaxWidth(400);
            blue.setToggleGroup(toggle1);
            blue.setFont(font2);
            blue.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            blue.setTextFill(Color.BLACK);
            blue.setMaxHeight(400);
            blue.setMaxWidth(400);
            green.setToggleGroup(toggle1);
            green.setFont(font2);
            green.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            green.setTextFill(Color.BLACK);
            green.setMaxHeight(400);
            green.setMaxWidth(400);

            HBox colors = new HBox(black, white, blue, green);
            colors.setSpacing(15);
            colors.setPadding(new Insets(25));
            colors.setAlignment(Pos.CENTER_LEFT);

            Label T = new Label("   T - Shirt   ");
            T.setFont(font2);
            T.setTextFill(Color.BLACK);
            T.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            T.setMaxHeight(150);
            T.setMaxWidth(150);


            TextField quantity = new TextField();
            quantity.setMaxHeight(40);
            quantity.setMaxWidth(200);

            Label price = new Label("50");
            price.setTextFill(Color.BLACK);
            price.setPrefWidth(150);
            price.setPrefHeight(20);
            price.setFont(font2);

            Label quantityy = new Label("quantity: ");
            quantityy.setTextFill(Color.BLACK);
            quantityy.setPrefWidth(150);
            quantityy.setPrefHeight(20);
            quantityy.setFont(font2);

            Label pricee = new Label("Price: ");
            pricee.setTextFill(Color.BLACK);
            pricee.setPrefWidth(150);
            pricee.setPrefHeight(20);
            pricee.setFont(font2);

            Button plus = new Button("+");
            plus.setTextFill(Color.BLACK);
            plus.setStyle("-fx-background-color:gray");
            plus.setFont(new Font("bold", 20));
            plus.setPrefWidth(40);
            plus.setPrefHeight(5);
            plus.setFont(font2);

            Button minus = new Button("-");
            minus.setTextFill(Color.BLACK);
            minus.setStyle("-fx-background-color:gray");
            minus.setFont(new Font("bold", 20));
            minus.setPrefWidth(40);
            minus.setPrefHeight(5);
            minus.setFont(font2);

            HBox shirt1 = new HBox(quantityy, quantity, plus, minus);
            shirt1.setSpacing(15);
            shirt1.setPadding(new Insets(25));
            shirt1.setAlignment(Pos.CENTER_LEFT);

            quantity.setText("1");

            int quantity1 = 0;
            black.setDisable(true);
            white.setDisable(true);
            green.setDisable(true);
            blue.setDisable(true);
            l.setDisable(true);
            m.setDisable(true);
            xl.setDisable(true);

            ObservableList<Product> products = Queries.getProducts();
            for (int i = 0; i < products.size(); i++) {
                if ("Tshirt".equals(products.get(i).getProductName())) {
                    String size1 = products.get(i).getSize();
                    String colour = products.get(i).getColour();
                    quantity1 = products.get(i).getQuantity();
                    String[] arr1 = colour.split(",");
                    String size2[] = size1.split(",");

                    for (int j = 0; j < arr1.length; j++) {
                        if (arr1[j].equals("Black"))
                            black.setDisable(false);
                        else if (arr1[j].equals("Green"))
                            green.setDisable(false);
                        else if (arr1[j].equals("White"))
                            white.setDisable(false);
                        else if (arr1[j].equals("Blue"))
                            blue.setDisable(false);

                    }
                    for (int j = 0; j < size2.length; j++) {
                        if (size2[j].equals("M")) {
                            m.setDisable(false);
                        } else if (size2[j].equals("L")) {
                            l.setDisable(false);
                        } else if (size2[j].equals("XL")) {
                            xl.setDisable(false);
                        }
                    }
                    price.setText(String.valueOf(products.get(i).getPrice()));
                    if (quantity.getText().equals(Integer.toString(quantity1)))
                        plus.setDisable(true);
                }
            }
            int finalQuantity = quantity1;
            plus.setOnAction(e -> {
                if (Integer.parseInt(quantity.getText()) == finalQuantity) {

                } else
                    quantity.setText(Integer.parseInt(quantity.getText()) + 1 + "");
            });

            minus.setOnAction(e -> {
                if (Integer.parseInt(quantity.getText()) == 1) {
                    quantity.setText("1");
                } else {
                    quantity.setText(Integer.parseInt(quantity.getText()) - 1 + "");
                }
            });

            Label finalPrice = price;

            buy.setOnAction(e -> {
                FinalCost = Float.parseFloat(price.getText()) * Float.parseFloat(quantity.getText());
                resultOrder += "Tshirt," + quantity.getText() + "," + finalPrice.getText() + ",";

                if (black.isSelected())
                    resultOrder += "black,";
                else if (blue.isSelected())
                    resultOrder += "blue,";
                else if (white.isSelected())
                    resultOrder += "white,";
                else if (green.isSelected())
                    resultOrder += "green,";

                if (m.isSelected())
                    resultOrder += "M,";
                else if (l.isSelected())
                    resultOrder += "L,";
                else if (xl.isSelected())
                    resultOrder += "XL,";


                if (toggle1.getSelectedToggle() == (null))
                    AlertBox.display("Choice All");
                else
                    primaryStage.setScene(Pay(primaryStage));
            });


            HBox shirt2 = new HBox(pricee, price);
            shirt2.setSpacing(15);
            shirt2.setPadding(new Insets(25));
            shirt2.setAlignment(Pos.CENTER_LEFT);

            HBox button = new HBox(back, buy);
            button.setSpacing(15);
            button.setPadding(new Insets(25));
            button.setAlignment(Pos.CENTER_LEFT);

            Image image = new Image("file:photo.jpg");
            ImageView imag = new ImageView(image);
            imag.setFitHeight(400);
            imag.setFitWidth(400);

            pane.add(Tlable, 0, 0);
            pane.add(size, 0, 1);
            pane.add(shirt, 0, 2);
            pane.add(color, 0, 3);
            pane.add(colors, 0, 4);
            pane.add(shirt1, 0, 5);
            pane.add(shirt2, 0, 6);
            pane.add(button, 0, 7);

            pane.setAlignment(Pos.CENTER);
            root.setTop(T);
            root.setAlignment(T, Pos.TOP_CENTER);
            root.setCenter(pane);
            root.setAlignment(pane, Pos.CENTER);
            root.setRight(imag);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }

    public static Scene Boot(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1370, 700);

        try {
            GridPane pane = new GridPane();
            Font font2 = new Font("Comic Sans Ms", 25);

            Button back = new Button("Back");
            back.setTextFill(Color.BLACK);
            back.setStyle("-fx-background-color:gray");
            back.setFont(new Font("bold", 20));
            back.setPrefWidth(200);
            back.setPrefHeight(50);
            back.setFont(font2);

            back.setOnAction(e -> {
                primaryStage.setScene(product(primaryStage));
            });

            Button buy = new Button("Buy now");
            buy.setTextFill(Color.BLACK);
            buy.setStyle("-fx-background-color:gray");
            buy.setFont(new Font("bold", 20));
            buy.setPrefWidth(200);
            buy.setPrefHeight(50);
            buy.setFont(font2);


            Label boot = new Label("Boot");
            boot.setTextFill(Color.BLACK);
            boot.setPrefWidth(200);
            boot.setPrefHeight(100);
            boot.setFont(font2);

            Label size = new Label("Size : ");
            size.setTextFill(Color.BLACK);
            size.setPrefWidth(100);
            size.setPrefHeight(100);
            size.setFont(font2);

            RadioButton size1 = new RadioButton("38");
            RadioButton size2 = new RadioButton("39");
            RadioButton size3 = new RadioButton("40");
            RadioButton size4 = new RadioButton("41");
            RadioButton size5 = new RadioButton("42");


            ToggleGroup toggle = new ToggleGroup();

            size1.setToggleGroup(toggle);
            size1.setFont(font2);
            size1.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            size1.setTextFill(Color.BLACK);
            size1.setMaxHeight(400);
            size1.setMaxWidth(400);
            size2.setToggleGroup(toggle);
            size2.setFont(font2);
            size2.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            size2.setTextFill(Color.BLACK);
            size2.setMaxHeight(400);
            size2.setMaxWidth(400);
            size3.setToggleGroup(toggle);
            size3.setFont(font2);
            size3.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            size3.setTextFill(Color.BLACK);
            size3.setMaxHeight(400);
            size3.setMaxWidth(400);
            size4.setToggleGroup(toggle);
            size4.setFont(font2);
            size4.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            size4.setTextFill(Color.BLACK);
            size4.setMaxHeight(400);
            size4.setMaxWidth(400);
            size5.setToggleGroup(toggle);
            size5.setFont(font2);
            size5.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            size5.setTextFill(Color.BLACK);
            size5.setMaxHeight(400);
            size5.setMaxWidth(400);

            HBox bootsize = new HBox(size1, size2, size3, size4, size5);
            bootsize.setSpacing(15);
            bootsize.setPadding(new Insets(25));
            bootsize.setAlignment(Pos.CENTER_LEFT);


            Label color = new Label("Color: ");
            color.setTextFill(Color.BLACK);
            color.setPrefWidth(150);
            color.setPrefHeight(20);
            color.setFont(font2);

            RadioButton black = new RadioButton("Black");
            RadioButton white = new RadioButton("White");
            RadioButton blue = new RadioButton("Blue");
            RadioButton green = new RadioButton("Green");

            ToggleGroup toggle1 = new ToggleGroup();

            black.setToggleGroup(toggle1);
            black.setFont(font2);
            black.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            black.setTextFill(Color.BLACK);
            black.setMaxHeight(400);
            black.setMaxWidth(400);
            white.setToggleGroup(toggle1);
            white.setFont(font2);
            white.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            white.setTextFill(Color.BLACK);
            white.setMaxHeight(400);
            white.setMaxWidth(400);
            blue.setToggleGroup(toggle1);
            blue.setFont(font2);
            blue.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            blue.setTextFill(Color.BLACK);
            blue.setMaxHeight(400);
            blue.setMaxWidth(400);
            green.setToggleGroup(toggle1);
            green.setFont(font2);
            green.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            green.setTextFill(Color.BLACK);
            green.setMaxHeight(400);
            green.setMaxWidth(400);

            HBox colors = new HBox(black, white, blue, green);
            colors.setSpacing(15);
            colors.setPadding(new Insets(25));
            colors.setAlignment(Pos.CENTER_LEFT);

            Label b = new Label("   Boot   ");
            b.setFont(font2);
            b.setTextFill(Color.BLACK);
            b.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            b.setMaxHeight(150);
            b.setMaxWidth(150);


            TextField quantity = new TextField();
            quantity.setMaxHeight(40);
            quantity.setMaxWidth(200);

            Label price = new Label("50");
            price.setTextFill(Color.BLACK);
            price.setPrefWidth(150);
            price.setPrefHeight(20);
            price.setFont(font2);

            Label quantityy = new Label("quantity: ");
            quantityy.setTextFill(Color.BLACK);
            quantityy.setPrefWidth(150);
            quantityy.setPrefHeight(20);
            quantityy.setFont(font2);

            Label pricee = new Label("Price: ");
            pricee.setTextFill(Color.BLACK);
            pricee.setPrefWidth(150);
            pricee.setPrefHeight(20);
            pricee.setFont(font2);

            Button plus = new Button("+");
            plus.setTextFill(Color.BLACK);
            plus.setStyle("-fx-background-color:gray");
            plus.setFont(new Font("bold", 20));
            plus.setPrefWidth(40);
            plus.setPrefHeight(5);
            plus.setFont(font2);

            Button minus = new Button("-");
            minus.setTextFill(Color.BLACK);
            minus.setStyle("-fx-background-color:gray");
            minus.setFont(new Font("bold", 20));
            minus.setPrefWidth(40);
            minus.setPrefHeight(5);
            minus.setFont(font2);

            HBox boot1 = new HBox(quantityy, quantity, plus, minus);
            boot1.setSpacing(15);
            boot1.setPadding(new Insets(25));
            boot1.setAlignment(Pos.CENTER_LEFT);

            quantity.setText("1");

            int quantity1 = 0;
            black.setDisable(true);
            white.setDisable(true);
            green.setDisable(true);
            blue.setDisable(true);
            size1.setDisable(true);
            size2.setDisable(true);
            size3.setDisable(true);
            size4.setDisable(true);
            size5.setDisable(true);

            ObservableList<Product> products = Queries.getProducts();
            for (int i = 0; i < products.size(); i++) {
                if ("Boot".equals(products.get(i).getProductName())) {
                    String size6 = products.get(i).getSize();
                    String colour = products.get(i).getColour();
                    quantity1 = products.get(i).getQuantity();
                    String[] arr1 = colour.split(",");
                    String size7[] = size6.split(",");

                    for (int j = 0; j < arr1.length; j++) {
                        if (arr1[j].equals("Black"))
                            black.setDisable(false);
                        else if (arr1[j].equals("Green"))
                            green.setDisable(false);
                        else if (arr1[j].equals("White"))
                            white.setDisable(false);
                        else if (arr1[j].equals("Blue"))
                            blue.setDisable(false);

                    }
                    for (int j = 0; j < size7.length; j++) {
                        if (size7[j].equals("38")) {
                            size1.setDisable(false);
                        } else if (size7[j].equals("39")) {
                            size2.setDisable(false);
                        } else if (size7[j].equals("40")) {
                            size3.setDisable(false);
                        } else if (size7[j].equals("41")) {
                            size4.setDisable(false);
                        } else if (size7[j].equals("42")) {
                            size5.setDisable(false);
                        }
                    }
                    price.setText(String.valueOf(products.get(i).getPrice()));
                    if (quantity.getText().equals(Integer.toString(quantity1)))
                        plus.setDisable(true);
                }
            }
            int finalQuantity = quantity1;
            plus.setOnAction(e -> {
                if (Integer.parseInt(quantity.getText()) == finalQuantity) {

                } else
                    quantity.setText(Integer.parseInt(quantity.getText()) + 1 + "");
            });

            minus.setOnAction(e -> {
                if (Integer.parseInt(quantity.getText()) == 1) {
                    quantity.setText("1");
                } else {
                    quantity.setText(Integer.parseInt(quantity.getText()) - 1 + "");
                }
            });

            Label finalPrice = price;
            buy.setOnAction(e -> {
                FinalCost = Float.parseFloat(price.getText()) * Float.parseFloat(quantity.getText());
                resultOrder += "Boot," + quantity.getText() + "," + finalPrice.getText() + ",";


                if (black.isSelected())
                    resultOrder += "black,";
                else if (blue.isSelected())
                    resultOrder += "blue,";
                else if (white.isSelected())
                    resultOrder += "white,";
                else if (green.isSelected())
                    resultOrder += "green,";

                if (size1.isSelected())
                    resultOrder += "38,";
                else if (size2.isSelected())
                    resultOrder += "39,";
                else if (size3.isSelected())
                    resultOrder += "40,";
                else if (size4.isSelected())
                    resultOrder += "41,";
                else if (size5.isSelected())
                    resultOrder += "42,";

                if (toggle1.getSelectedToggle() == (null))
                    AlertBox.display("Choice All");
                else
                    primaryStage.setScene(Pay(primaryStage));
            });

            HBox boot2 = new HBox(pricee, price);
            boot2.setSpacing(15);
            boot2.setPadding(new Insets(25));
            boot2.setAlignment(Pos.CENTER_LEFT);

            HBox button = new HBox(back, buy);
            button.setSpacing(15);
            button.setPadding(new Insets(25));
            button.setAlignment(Pos.CENTER_LEFT);

            Image image = new Image("file:boot2.jpg");
            ImageView imag = new ImageView(image);
            imag.setFitHeight(400);
            imag.setFitWidth(400);

            pane.add(boot, 0, 0);
            pane.add(size, 0, 1);
            pane.add(bootsize, 0, 2);
            pane.add(color, 0, 3);
            pane.add(colors, 0, 4);
            pane.add(boot1, 0, 5);
            pane.add(boot2, 0, 6);
            pane.add(button, 0, 7);

            pane.setAlignment(Pos.CENTER);
            root.setTop(b);
            root.setAlignment(b, Pos.TOP_CENTER);
            root.setCenter(pane);
            root.setAlignment(pane, Pos.CENTER);
            root.setRight(imag);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }

    public static Scene WristWatch(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1370, 700);

        try {
            GridPane pane = new GridPane();
            Font font2 = new Font("Comic Sans Ms", 25);

            Button back = new Button("Back");
            back.setTextFill(Color.BLACK);
            back.setStyle("-fx-background-color:gray");
            back.setFont(new Font("bold", 20));
            back.setPrefWidth(200);
            back.setPrefHeight(50);
            back.setFont(font2);

            Button buy = new Button("Buy now");
            buy.setTextFill(Color.BLACK);
            buy.setStyle("-fx-background-color:gray");
            buy.setFont(new Font("bold", 20));
            buy.setPrefWidth(200);
            buy.setPrefHeight(50);
            buy.setFont(font2);


            Label wristwatch = new Label("Wrist Watch");
            wristwatch.setTextFill(Color.BLACK);
            wristwatch.setPrefWidth(200);
            wristwatch.setPrefHeight(100);
            wristwatch.setFont(font2);

            Label color = new Label("Color: ");
            color.setTextFill(Color.BLACK);
            color.setPrefWidth(150);
            color.setPrefHeight(20);
            color.setFont(font2);

            RadioButton black = new RadioButton("Black");
            RadioButton white = new RadioButton("White");
            RadioButton silver = new RadioButton("Silver");
            RadioButton golden = new RadioButton("Golden");

            ToggleGroup toggle1 = new ToggleGroup();

            black.setToggleGroup(toggle1);
            black.setFont(font2);
            black.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            black.setTextFill(Color.BLACK);
            black.setMaxHeight(400);
            black.setMaxWidth(400);
            white.setToggleGroup(toggle1);
            white.setFont(font2);
            white.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            white.setTextFill(Color.BLACK);
            white.setMaxHeight(400);
            white.setMaxWidth(400);
            silver.setToggleGroup(toggle1);
            silver.setFont(font2);
            silver.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            silver.setTextFill(Color.BLACK);
            silver.setMaxHeight(400);
            silver.setMaxWidth(400);
            golden.setToggleGroup(toggle1);
            golden.setFont(font2);
            golden.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            golden.setTextFill(Color.BLACK);
            golden.setMaxHeight(400);
            golden.setMaxWidth(400);

            HBox colors = new HBox(black, white, silver, golden);
            colors.setSpacing(15);
            colors.setPadding(new Insets(25));
            colors.setAlignment(Pos.CENTER_LEFT);

            Label b = new Label("        Wrist Watch      ");
            b.setFont(font2);
            b.setTextFill(Color.BLACK);
            b.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            b.setMaxHeight(300);
            b.setMaxWidth(300);


            TextField quantity = new TextField();
            quantity.setMaxHeight(40);
            quantity.setMaxWidth(200);

            Label price = new Label("50");
            price.setTextFill(Color.BLACK);
            price.setPrefWidth(150);
            price.setPrefHeight(20);
            price.setFont(font2);

            Label quantityy = new Label("quantity: ");
            quantityy.setTextFill(Color.BLACK);
            quantityy.setPrefWidth(150);
            quantityy.setPrefHeight(20);
            quantityy.setFont(font2);

            Label pricee = new Label("Price: ");
            pricee.setTextFill(Color.BLACK);
            pricee.setPrefWidth(150);
            pricee.setPrefHeight(20);
            pricee.setFont(font2);

            Button plus = new Button("+");
            plus.setTextFill(Color.BLACK);
            plus.setStyle("-fx-background-color:gray");
            plus.setFont(new Font("bold", 20));
            plus.setPrefWidth(40);
            plus.setPrefHeight(5);
            plus.setFont(font2);

            Button minus = new Button("-");
            minus.setTextFill(Color.BLACK);
            minus.setStyle("-fx-background-color:gray");
            minus.setFont(new Font("bold", 20));
            minus.setPrefWidth(40);
            minus.setPrefHeight(5);
            minus.setFont(font2);

            HBox wristwatch1 = new HBox(quantityy, quantity, plus, minus);
            wristwatch1.setSpacing(15);
            wristwatch1.setPadding(new Insets(25));
            wristwatch1.setAlignment(Pos.CENTER_LEFT);
            quantity.setText("1");

            int quantity1 = 0;
            black.setDisable(true);
            white.setDisable(true);
            silver.setDisable(true);
            golden.setDisable(true);

            ObservableList<Product> products = Queries.getProducts();
            for (int i = 0; i < products.size(); i++) {
                if ("wristwatch".equals(products.get(i).getProductName())) {
                    String size = products.get(i).getSize();
                    String colour = products.get(i).getColour();
                    quantity1 = products.get(i).getQuantity();
                    String[] arr1 = colour.split(",");
                    for (int j = 0; j < arr1.length; j++) {
                        if (arr1[j].equals("black"))
                            black.setDisable(false);
                        else if (arr1[j].equals("silver"))
                            silver.setDisable(false);
                        else if (arr1[j].equals("white"))
                            white.setDisable(false);
                        else if (arr1[j].equals("golden"))
                            golden.setDisable(false);
                        price.setText(String.valueOf(products.get(i).getPrice()));
                    }
                    if (quantity.getText().equals(Integer.toString(quantity1)))
                        plus.setDisable(true);
                }
            }
            int finalQuantity = quantity1;
            plus.setOnAction(e -> {
                if (Integer.parseInt(quantity.getText()) == finalQuantity) {

                } else
                    quantity.setText(Integer.parseInt(quantity.getText()) + 1 + "");
            });

            minus.setOnAction(e -> {
                if (Integer.parseInt(quantity.getText()) == 1) {
                    quantity.setText("1");
                } else {
                    quantity.setText(Integer.parseInt(quantity.getText()) - 1 + "");
                }
            });

            HBox wristwatch2 = new HBox(pricee, price);
            wristwatch2.setSpacing(15);
            wristwatch2.setPadding(new Insets(25));
            wristwatch2.setAlignment(Pos.CENTER_LEFT);

            HBox button = new HBox(back, buy);
            button.setSpacing(15);
            button.setPadding(new Insets(25));
            button.setAlignment(Pos.CENTER_LEFT);

            back.setOnAction(e -> {
                primaryStage.setScene(product(primaryStage));
            });


            Label finalPrice = price;
            buy.setOnAction(e -> {
                FinalCost = Float.parseFloat(price.getText()) * Float.parseFloat(quantity.getText());
                resultOrder += "wristwatch," + quantity.getText() + "," + finalPrice.getText() + ",";
                if (black.isSelected())
                    resultOrder += "black,";
                else if (golden.isSelected())
                    resultOrder += "golden,";
                else if (white.isSelected())
                    resultOrder += "white,";
                else if (silver.isSelected())
                    resultOrder += "silver,";
                if (toggle1.getSelectedToggle() == (null))
                    AlertBox.display("Choice All");
                else
                    primaryStage.setScene(Pay(primaryStage));
            });

            Image image = new Image("file:photoo.jpg");
            ImageView imag = new ImageView(image);
            imag.setFitHeight(400);
            imag.setFitWidth(400);

            pane.add(wristwatch, 0, 0);
            pane.add(color, 0, 1);
            pane.add(colors, 0, 2);
            pane.add(wristwatch1, 0, 3);
            pane.add(wristwatch2, 0, 4);
            pane.add(button, 0, 5);

            pane.setAlignment(Pos.CENTER);
            root.setTop(b);
            root.setAlignment(b, Pos.TOP_CENTER);
            root.setCenter(pane);
            root.setAlignment(pane, Pos.CENTER);
            root.setRight(imag);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }

    public static Scene Hat(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1370, 700);

        try {

            GridPane pane = new GridPane();
            Font font2 = new Font("Comic Sans Ms", 25);

            Button back = new Button("Back");
            back.setTextFill(Color.BLACK);
            back.setStyle("-fx-background-color:gray");
            back.setFont(new Font("bold", 20));
            back.setPrefWidth(200);
            back.setPrefHeight(50);
            back.setFont(font2);

            back.setOnAction(e -> {
                primaryStage.setScene(product(primaryStage));
            });

            Button buy = new Button("Buy now");
            buy.setTextFill(Color.BLACK);
            buy.setStyle("-fx-background-color:gray");
            buy.setFont(new Font("bold", 20));
            buy.setPrefWidth(200);
            buy.setPrefHeight(50);
            buy.setFont(font2);


            Label hat = new Label("Hat");
            hat.setTextFill(Color.BLACK);
            hat.setPrefWidth(200);
            hat.setPrefHeight(100);
            hat.setFont(font2);

            Label color = new Label("Color: ");
            color.setTextFill(Color.BLACK);
            color.setPrefWidth(150);
            color.setPrefHeight(20);
            color.setFont(font2);

            RadioButton black = new RadioButton("Black");
            RadioButton white = new RadioButton("White");
            RadioButton red = new RadioButton("Green");
            RadioButton blue = new RadioButton("Blue");

            ToggleGroup toggle1 = new ToggleGroup();

            black.setToggleGroup(toggle1);
            black.setFont(font2);
            black.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            black.setTextFill(Color.BLACK);
            black.setMaxHeight(400);
            black.setMaxWidth(400);
            white.setToggleGroup(toggle1);
            white.setFont(font2);
            white.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            white.setTextFill(Color.BLACK);
            white.setMaxHeight(400);
            white.setMaxWidth(400);
            blue.setToggleGroup(toggle1);
            blue.setFont(font2);
            blue.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            blue.setTextFill(Color.BLACK);
            blue.setMaxHeight(400);
            blue.setMaxWidth(400);
            red.setToggleGroup(toggle1);
            red.setFont(font2);
            red.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            red.setTextFill(Color.BLACK);
            red.setMaxHeight(400);
            red.setMaxWidth(400);

            HBox colors = new HBox(black, white, blue, red);
            colors.setSpacing(15);
            colors.setPadding(new Insets(25));
            colors.setAlignment(Pos.CENTER_LEFT);

            Label b = new Label("    Hat   ");
            b.setFont(font2);
            b.setTextFill(Color.BLACK);
            b.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            b.setMaxHeight(150);
            b.setMaxWidth(150);

            TextField quantity = new TextField();
            quantity.setMaxHeight(40);
            quantity.setMaxWidth(200);

            Label price = new Label("");
            price.setTextFill(Color.BLACK);
            price.setPrefWidth(150);
            price.setPrefHeight(20);
            price.setFont(font2);

            Label quantityy = new Label("quantity: ");
            quantityy.setTextFill(Color.BLACK);
            quantityy.setPrefWidth(150);
            quantityy.setPrefHeight(20);
            quantityy.setFont(font2);

            Label pricee = new Label("Price: ");
            pricee.setTextFill(Color.BLACK);
            pricee.setPrefWidth(150);
            pricee.setPrefHeight(20);
            pricee.setFont(font2);

            Button plus = new Button("+");
            plus.setTextFill(Color.BLACK);
            plus.setStyle("-fx-background-color:gray");
            plus.setFont(new Font("bold", 20));
            plus.setPrefWidth(40);
            plus.setPrefHeight(5);
            plus.setFont(font2);

            Button minus = new Button("-");
            minus.setTextFill(Color.BLACK);
            minus.setStyle("-fx-background-color:gray");
            minus.setFont(new Font("bold", 20));
            minus.setPrefWidth(40);
            minus.setPrefHeight(5);
            minus.setFont(font2);

            HBox hat1 = new HBox(quantityy, quantity, plus, minus);
            hat1.setSpacing(15);
            hat1.setPadding(new Insets(25));
            hat1.setAlignment(Pos.CENTER_LEFT);

            quantity.setText("1");
            int quantity1 = 0;
            black.setDisable(true);
            white.setDisable(true);
            red.setDisable(true);
            blue.setDisable(true);

            ObservableList<Product> products = Queries.getProducts();
            for (int i = 0; i < products.size(); i++) {

                if ("Hat".equals(products.get(i).getProductName())) {
                    String size = products.get(i).getSize();
                    String colour = products.get(i).getColour();
                    quantity1 = products.get(i).getQuantity();
                    String[] arr1 = colour.split(",");
                    for (int j = 0; j < arr1.length; j++) {
                        if (arr1[j].equals("Black"))
                            black.setDisable(false);
                        else if (arr1[j].equals("Green"))
                            red.setDisable(false);
                        else if (arr1[j].equals("White"))
                            white.setDisable(false);
                        else if (arr1[j].equals("Blue"))
                            blue.setDisable(false);
                        price.setText(String.valueOf(products.get(i).getPrice()));
                    }
                    if (quantity.getText().equals(Integer.toString(quantity1)))
                        plus.setDisable(true);
                }
            }
            int finalQuantity = quantity1;
            plus.setOnAction(e -> {
                if (Integer.parseInt(quantity.getText()) == finalQuantity) {

                } else
                    quantity.setText(Integer.parseInt(quantity.getText()) + 1 + "");
            });

            minus.setOnAction(e -> {
                if (Integer.parseInt(quantity.getText()) == 1) {
                    quantity.setText("1");
                } else {
                    quantity.setText(Integer.parseInt(quantity.getText()) - 1 + "");
                }
            });


            HBox hat2 = new HBox(pricee, price);
            hat1.setSpacing(15);
            hat1.setPadding(new Insets(25));
            hat1.setAlignment(Pos.CENTER_LEFT);

            HBox button = new HBox(back, buy);
            button.setSpacing(15);
            button.setPadding(new Insets(25));
            button.setAlignment(Pos.CENTER_LEFT);

            Image image = new Image("file:hat.jpg");
            ImageView imag = new ImageView(image);
            imag.setFitHeight(400);
            imag.setFitWidth(400);

            pane.add(hat, 0, 0);
            pane.add(color, 0, 1);
            pane.add(colors, 0, 2);
            pane.add(hat1, 0, 3);
            pane.add(hat2, 0, 4);
            pane.add(button, 0, 5);

            pane.setAlignment(Pos.CENTER);
            root.setTop(b);
            root.setAlignment(b, Pos.TOP_CENTER);
            root.setCenter(pane);
            root.setAlignment(pane, Pos.CENTER);
            root.setRight(imag);

            Label finalPrice = price;
            buy.setOnAction(e -> {
                FinalCost = Float.parseFloat(price.getText()) * Float.parseFloat(quantity.getText());
                resultOrder += "Hat," + quantity.getText() + "," + finalPrice.getText() + ",";
                if (black.isSelected())
                    resultOrder += "black,";
                else if (blue.isSelected())
                    resultOrder += "blue,";
                else if (white.isSelected())
                    resultOrder += "white,";
                else if (red.isSelected())
                    resultOrder += "Green,";
                if (toggle1.getSelectedToggle() == (null))
                    AlertBox.display("Choice All");
                else
                    primaryStage.setScene(Pay(primaryStage));
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }

    public static Scene SignUp(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1370, 700);

        try {
            GridPane pane = new GridPane();
            Font font2 = new Font("Comic Sans Ms", 25);

            Button signup = new Button("Sign Up");
            signup.setTextFill(Color.BLACK);
            signup.setStyle("-fx-background-color:gray");
            signup.setFont(new Font("bold", 20));
            signup.setPrefWidth(200);
            signup.setPrefHeight(50);
            signup.setFont(font2);


            Button back = new Button("Back");
            back.setTextFill(Color.BLACK);
            back.setStyle("-fx-background-color:gray");
            back.setFont(new Font("bold", 20));
            back.setPrefWidth(200);
            back.setPrefHeight(50);
            back.setFont(font2);

            back.setOnAction(e -> {
                primaryStage.setScene(product(primaryStage));
            });

            Label log = new Label("Sign Up");
            log.setTextFill(Color.BLACK);
            log.setPrefWidth(200);
            log.setPrefHeight(100);
            log.setFont(font2);

            Label user = new Label("First Name: ");
            user.setTextFill(Color.BLACK);
            user.setPrefWidth(150);
            user.setPrefHeight(20);
            user.setFont(font2);

            Label user1 = new Label("Last: ");
            user1.setTextFill(Color.BLACK);
            user1.setPrefWidth(100);
            user1.setPrefHeight(20);
            user1.setFont(font2);

            TextField name = new TextField();
            name.setMaxHeight(40);
            name.setMaxWidth(200);

            TextField name1 = new TextField();
            name1.setMaxHeight(40);
            name1.setMaxWidth(200);

            HBox customer = new HBox(user, name, user1, name1);
            customer.setSpacing(15);
            customer.setPadding(new Insets(25));
            customer.setAlignment(Pos.CENTER_LEFT);


            Label bd = new Label("Birth Date:");
            bd.setTextFill(Color.BLACK);
            bd.setPrefWidth(150);
            bd.setPrefHeight(20);
            bd.setFont(font2);


            TextField Bd = new TextField();
            Bd.setMaxHeight(40);
            Bd.setMaxWidth(200);

            Label email = new Label("Email: ");
            email.setTextFill(Color.BLACK);
            email.setPrefWidth(150);
            email.setPrefHeight(20);
            email.setFont(font2);


            TextField Email = new TextField();
            Email.setMaxHeight(40);
            Email.setMaxWidth(200);


            HBox birth = new HBox(bd, Bd);
            birth.setSpacing(15);
            birth.setPadding(new Insets(25));
            birth.setAlignment(Pos.CENTER_LEFT);


            HBox emaill = new HBox(email, Email);
            emaill.setSpacing(15);
            emaill.setPadding(new Insets(25));
            emaill.setAlignment(Pos.CENTER_LEFT);


            Label pass = new Label("Password: ");
            pass.setTextFill(Color.BLACK);
            pass.setPrefWidth(150);
            pass.setPrefHeight(20);
            pass.setFont(font2);


            TextField password = new TextField();
            password.setMaxHeight(40);
            password.setMaxWidth(200);


            HBox customer1 = new HBox(pass, password);
            customer1.setSpacing(15);
            customer1.setPadding(new Insets(25));
            customer1.setAlignment(Pos.CENTER_LEFT);


            Button signup1 = new Button("Sign Up");
            signup1.setMaxHeight(20);
            signup1.setMaxWidth(150);
            signup1.setTextFill(Color.GRAY);
            signup1.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:black;");
            signup1.setFont(font2);

            signup1.setOnAction(e -> {
                String fname = name.getText();
                String lname = name1.getText();
                String mail = Email.getText();
                String password1 = password.getText();
                String date = Bd.getText();
                if (fname.equals("") || lname.equals("") || mail.equals("") || password1.equals("") || date.equals("")) {
                    AlertBox.display("Error input");
                } else {
                    boolean bool = false;
                    try {
                        ObservableList<Customer> list = Queries.getCustomers();
                        for (int i = 0; i < list.size(); i++) {
                            if (mail.equals(list.get(i).getEmail())) {
                                AlertBox.display("Email is already used");
                                bool = true;
                            }
                        }
                        if (!bool) {
                            Customer customer2 = new Customer(fname, lname, date, mail, password1);
                            Queries.insertCustomer(customer2);
                            AlertBox.display("Customer has been added successfully");

                        }
                    } catch (ClassNotFoundException s) {
                        s.printStackTrace();
                    } catch (SQLException s) {
                        s.printStackTrace();
                    } catch (ParseException s) {
                        s.printStackTrace();
                    }
                    if (!bool)
                        primaryStage.setScene(Scenes.Login(primaryStage));

                }
            });

            pane.add(log, 0, 0);
            pane.add(customer, 0, 1);
            pane.add(birth, 0, 2);
            pane.add(emaill, 0, 3);
            pane.add(customer1, 0, 4);
            pane.add(signup1, 0, 6);
            pane.setAlignment(Pos.CENTER);
            pane.setHgap(5);
            pane.setVgap(5);
            pane.setPadding(new Insets(150, 150, 150, 150));


            root.setLeft(pane);
            root.setAlignment(pane, Pos.CENTER);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }

    public static Scene product(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1370, 700);

        try {

            Image image = new Image("file:hat.jpg");
            ImageView imag = new ImageView(image);
            imag.setFitHeight(200);
            imag.setFitWidth(200);

            Image image1 = new Image("file:boot2.jpg");
            ImageView imag1 = new ImageView(image1);
            imag1.setFitHeight(200);
            imag1.setFitWidth(200);

            Image image2 = new Image("file:photo.jpg");
            ImageView imag2 = new ImageView(image2);
            imag2.setFitHeight(200);
            imag2.setFitWidth(200);

            Image image3 = new Image("file:photoo.jpg");
            ImageView imag3 = new ImageView(image3);
            imag3.setFitHeight(200);
            imag3.setFitWidth(200);

            Image image4 = new Image("file:bntalon.jpg");
            ImageView imag4 = new ImageView(image4);
            imag4.setFitHeight(200);
            imag4.setFitWidth(200);

            Image image5 = new Image("file:qames.jpg");
            ImageView imag5 = new ImageView(image5);
            imag5.setFitHeight(200);
            imag5.setFitWidth(200);

            Font font2 = new Font("Comic Sans Ms", 25);


            Button trouser = new Button("Trouser");
            trouser.setMaxHeight(20);
            trouser.setMaxWidth(150);
            trouser.setTextFill(Color.BLACK);
            trouser.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            trouser.setFont(font2);

            trouser.setOnAction(e -> {
                primaryStage.setScene(Trouser(primaryStage));
            });

            Button qames = new Button("Shirt");
            qames.setMaxHeight(20);
            qames.setMaxWidth(150);
            qames.setTextFill(Color.BLACK);
            qames.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            qames.setFont(font2);

            qames.setOnAction(e -> {
                primaryStage.setScene(Shirt(primaryStage));
            });

            Button hat = new Button("Hat");
            hat.setMaxHeight(20);
            hat.setMaxWidth(150);
            hat.setTextFill(Color.BLACK);
            hat.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            hat.setFont(font2);

            hat.setOnAction(e -> {
                primaryStage.setScene(Hat(primaryStage));
            });

            Button boot = new Button("Boot");
            boot.setMaxHeight(20);
            boot.setMaxWidth(150);
            boot.setTextFill(Color.BLACK);
            boot.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            boot.setFont(font2);

            boot.setOnAction(e -> {
                primaryStage.setScene(Boot(primaryStage));
            });

            Button wristwatch = new Button("Wrist Watch");
            wristwatch.setMaxHeight(20);
            wristwatch.setMaxWidth(200);
            wristwatch.setTextFill(Color.BLACK);
            wristwatch.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            wristwatch.setFont(font2);

            wristwatch.setOnAction(e -> {
                primaryStage.setScene(WristWatch(primaryStage));
            });

            Button tshirt = new Button("T-shirt");
            tshirt.setMaxHeight(20);
            tshirt.setMaxWidth(200);
            tshirt.setTextFill(Color.BLACK);
            tshirt.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            tshirt.setFont(font2);

            tshirt.setOnAction(e -> {
                primaryStage.setScene(TShirt(primaryStage));
            });

            VBox first = new VBox(imag, hat);
            VBox second = new VBox(imag1, boot);
            VBox third = new VBox(imag2, tshirt);
            VBox fourth = new VBox(imag3, wristwatch);
            VBox five = new VBox(imag4, trouser);
            VBox six = new VBox(imag5, qames);

            Label b = new Label("                Our Products   ");
            b.setFont(font2);
            b.setTextFill(Color.BLACK);
            b.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            b.setMaxHeight(400);
            b.setMaxWidth(400);

            Button exit = new Button("exit");
            exit.setMaxHeight(200);
            exit.setMaxWidth(100);
            exit.setTextFill(Color.BLACK);
            exit.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            exit.setFont(font2);

            GridPane pane = new GridPane();

            pane.add(first, 0, 0);
            pane.add(second, 0, 1);
            pane.add(third, 4, 0);
            pane.add(fourth, 4, 1);
            pane.add(five, 2, 0);
            pane.add(six, 2, 1);
            pane.add(exit, 2, 2);

            pane.setAlignment(Pos.CENTER);
            pane.setHgap(10);
            pane.setVgap(10);

            root.setCenter(pane);
            root.setAlignment(pane, Pos.CENTER);
            root.setTop(b);
            root.setAlignment(b, Pos.TOP_CENTER);

            exit.setOnAction(e -> {
                primaryStage.hide();
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }

    public static Scene Pay(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1370, 700);

        try {
// address

            GridPane pane2 = new GridPane();
            Font font2 = new Font("Comic Sans Ms", 25);

            Label address = new Label("Address");
            address.setTextFill(Color.BLACK);
            address.setPrefWidth(200);
            address.setPrefHeight(100);
            address.setFont(font2);

            Label city = new Label("City Name: ");
            city.setTextFill(Color.BLACK);
            city.setPrefWidth(150);
            city.setPrefHeight(20);
            city.setFont(font2);

            Label village = new Label("Village: ");
            village.setTextFill(Color.BLACK);
            village.setPrefWidth(150);
            village.setPrefHeight(20);
            village.setFont(font2);

            Label street = new Label("Street: ");
            street.setTextFill(Color.BLACK);
            street.setPrefWidth(150);
            street.setPrefHeight(20);
            street.setFont(font2);

            Label phon = new Label("Phone Number: ");
            phon.setTextFill(Color.BLACK);
            phon.setPrefWidth(150);
            phon.setPrefHeight(20);
            phon.setFont(font2);

            TextField city2 = new TextField();
            city2.setMaxHeight(40);
            city2.setMaxWidth(200);

            TextField village2 = new TextField();
            village2.setMaxHeight(40);
            village2.setMaxWidth(200);

            TextField street2 = new TextField();
            street2.setMaxHeight(40);
            street2.setMaxWidth(200);

            TextField phon2 = new TextField();
            phon2.setMaxHeight(40);
            phon2.setMaxWidth(200);

            HBox city3 = new HBox(city, city2);
            city3.setSpacing(15);
            city3.setPadding(new Insets(25));
            city3.setAlignment(Pos.CENTER_LEFT);

            HBox village3 = new HBox(village, village2);
            village3.setSpacing(15);
            village3.setPadding(new Insets(25));
            village3.setAlignment(Pos.CENTER_LEFT);

            HBox street3 = new HBox(street, street2);
            street3.setSpacing(15);
            street3.setPadding(new Insets(25));
            street3.setAlignment(Pos.CENTER_LEFT);

            HBox phon3 = new HBox(phon, phon2);
            phon3.setSpacing(15);
            phon3.setPadding(new Insets(25));
            phon3.setAlignment(Pos.CENTER_LEFT);


            pane2.add(address, 0, 0);
            pane2.add(city3, 0, 1);
            pane2.add(village3, 0, 2);
            pane2.add(street3, 0, 3);
            pane2.add(phon3, 0, 4);
            pane2.setAlignment(Pos.CENTER);


            Font font3 = new Font("Comic Sans Ms", 20);

            Button cash = new Button("Cash");
            cash.setMaxHeight(20);
            cash.setMaxWidth(200);
            cash.setTextFill(Color.BLACK);
            cash.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            cash.setFont(font2);
            cash.setOnAction(actionEvent -> {

                String arr[] = resultOrder.split(",");

                address1 = new Address(city2.getText(), village2.getText(), street2.getText(), phon2.getText());
                Queries.insertAddress(address1);

                Cash cash1 = new Cash(FinalCost);
                Queries.insertCash(cash1);
                String currentDay = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "/" + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" + Calendar.getInstance().get(Calendar.YEAR));
                int id = 0;
                try {
                    id = Queries.getAddress().get(Queries.getAddress().size() - 1).getAddressID();
                } catch (ClassNotFoundException e) {

                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Order order = new Order(currentDay, id, cash1.getPaymentID(), Integer.parseInt(arr[0]), cash1.getAmount());
                Queries.insertOrder(order);

                try {
                    int id1 = 0;
                    ObservableList<Product> list = Queries.getProducts();
                    System.out.println(arr);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getProductName().equals(arr[1])) {
                            id1 = list.get(i).getProductID();
                        }
                    }
                    String descriprion = "Colour :" + arr[4] + ",";
                    if (arr[5] != null)
                        descriprion += "Size :" + arr[5];

                    Queries.insertCart(Queries.getOrders().get(Queries.getOrders().size() - 1).getOrderID(), id1, descriprion, cash1.getAmount());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    ObservableList<Product> list = Queries.getProducts();
                    for (int i = 0; i < list.size(); i++) {
                        if (arr[1].equals(list.get(i).getProductName())) {
                            list.get(i).setQuantity(list.get(i).getQuantity() - Integer.parseInt(arr[2]));
                            Queries.updateProductPrice(list.get(i).getProductName(), list.get(i).getQuantity());
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                AlertBox.display("payment successfully");
                primaryStage.setScene(Scenes.product(primaryStage));

            });
            Button card = new Button("Credit Card");
            card.setMaxHeight(20);
            card.setMaxWidth(200);
            card.setTextFill(Color.BLACK);
            card.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            card.setFont(font2);

            card.setOnAction(e -> {
                address1 = new Address(city2.getText(), village2.getText(), street2.getText(), phon2.getText());
                Queries.insertAddress(address1);
                primaryStage.setScene(CreditCard(primaryStage));
            });

            Button back = new Button("Back");
            back.setMaxHeight(20);
            back.setMaxWidth(200);
            back.setTextFill(Color.BLACK);
            back.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            back.setFont(font2);

            back.setOnAction(e -> {
                primaryStage.setScene(product(primaryStage));
            });

            Label b = new Label("     Payment Ways    ");
            b.setTextFill(Color.BLACK);
            b.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            b.setMaxHeight(400);
            b.setMaxWidth(400);
            b.setFont(font2);

            Label label = new Label("Total Cost: " + String.valueOf(FinalCost));
            label.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:lightblue;");
            label.setPrefWidth(200);
            label.setPrefHeight(50);
            label.setAlignment(Pos.CENTER);
            label.setFont(font3);

            GridPane pane = new GridPane();

            pane.add(label, 0, 1);
            pane.add(cash, 0, 3);
            pane.add(card, 0, 5);
            pane.add(back, 0, 7);

            pane.setAlignment(Pos.CENTER);
            pane.setHgap(10);
            pane.setVgap(10);

            root.setRight(pane2);

            root.setCenter(pane);

            root.setAlignment(pane, Pos.CENTER);
            root.setTop(b);
            root.setAlignment(b, Pos.TOP_CENTER);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }

    public static Scene CreditCard(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1370, 700);

        try {

            Font font2 = new Font("Comic Sans Ms", 25);

            Label card = new Label("Credit Card Number");
            card.setTextFill(Color.BLACK);
            card.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            card.setMaxHeight(400);
            card.setMaxWidth(400);
            card.setFont(font2);

            TextField num = new TextField();
            num.setMaxHeight(400);
            num.setMaxWidth(400);

            Button pay = new Button("Pay");
            pay.setMaxHeight(20);
            pay.setMaxWidth(150);
            pay.setTextFill(Color.BLACK);
            pay.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            pay.setFont(font2);


            Button back = new Button("Back");
            back.setMaxHeight(20);
            back.setMaxWidth(200);
            back.setTextFill(Color.BLACK);
            back.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            back.setFont(font2);

            back.setOnAction(e -> {
                primaryStage.setScene(product(primaryStage));
            });

            Label b = new Label("   Credit Card  ");
            b.setTextFill(Color.BLACK);
            b.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            b.setMaxHeight(400);
            b.setMaxWidth(400);
            b.setFont(font2);

            Label year1 = new Label("  Year  ");
            year1.setTextFill(Color.BLACK);
            year1.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            year1.setMaxHeight(400);
            year1.setMaxWidth(400);
            year1.setFont(font2);
            year1.setAlignment(Pos.CENTER);

            Label month1 = new Label("  Month  ");
            month1.setTextFill(Color.BLACK);
            month1.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            month1.setMaxHeight(400);
            month1.setMaxWidth(400);
            month1.setFont(font2);
            month1.setAlignment(Pos.CENTER);

            Label cvv1 = new Label("  Cvv  ");
            cvv1.setTextFill(Color.BLACK);
            cvv1.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            cvv1.setMaxHeight(400);
            cvv1.setMaxWidth(400);
            cvv1.setFont(font2);
            cvv1.setAlignment(Pos.CENTER);

            TextField year2 = new TextField();
            year2.setMaxHeight(40);
            year2.setMaxWidth(200);

            TextField month2 = new TextField();
            month2.setMaxHeight(40);
            month2.setMaxWidth(200);

            TextField cvv2 = new TextField();
            cvv2.setMaxHeight(40);
            cvv2.setMaxWidth(200);
            pay.setOnAction(actionEvent -> {
                String arr[] = resultOrder.split(",");

                //Queries.insertAddress(address1);
                int number = Integer.parseInt(num.getText());
                String date = month2.getText() + "/" + year2.getText();
                int cvv = Integer.parseInt(cvv2.getText());
                CreditCard creditCard = new CreditCard(number, date, cvv, FinalCost);
                Queries.insertCreditCard(creditCard);
                String currentDay = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "/" + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" + Calendar.getInstance().get(Calendar.YEAR));
                int id = 0;
                try {
                    id = Queries.getAddress().get(Queries.getAddress().size() - 1).getAddressID();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Order order = new Order(currentDay, id, creditCard.getPaymentID(), Integer.parseInt(arr[0]), creditCard.getAmount());
                Queries.insertOrder(order);
                try {
                    int id1 = 0;
                    ObservableList<Product> list = Queries.getProducts();
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getProductName().equals(arr[1])) {
                            id1 = list.get(i).getProductID();
                        }
                    }
                    String descriprion = "Colour :" + arr[4] + ",";
                    if (arr[5] != null)
                        descriprion += "Size :" + arr[5];

                    Queries.insertCart(Queries.getOrders().get(Queries.getOrders().size() - 1).getOrderID(), id1, descriprion, creditCard.getAmount());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    ObservableList<Product> list = Queries.getProducts();
                    for (int i = 0; i < list.size(); i++) {
                        if (arr[1].equals(list.get(i).getProductName())) {
                            list.get(i).setQuantity(list.get(i).getQuantity() - Integer.parseInt(arr[2]));
                            Queries.updateProductPrice(list.get(i).getProductName(), list.get(i).getQuantity());
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                AlertBox.display("payment successfully");
                primaryStage.setScene(Scenes.product(primaryStage));

            });

            GridPane pane = new GridPane();

            pane.add(card, 0, 1);
            pane.add(num, 01, 1);

            pane.add(year1, 0, 4);
            pane.add(year2, 1, 4);
            pane.add(month1, 2, 4);
            pane.add(month2, 3, 4);
            pane.add(cvv1, 4, 4);
            pane.add(cvv2, 5, 4);

            pane.add(pay, 0, 5);
            pane.add(back, 0, 6);

            pane.setAlignment(Pos.CENTER);
            pane.setHgap(10);
            pane.setVgap(10);

            root.setCenter(pane);
            root.setAlignment(pane, Pos.CENTER);
            root.setTop(b);
            root.setAlignment(b, Pos.TOP_CENTER);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }

    public static Scene Shirt(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1370, 700);

        try {
            GridPane pane = new GridPane();
            Font font2 = new Font("Comic Sans Ms", 25);

            Button back = new Button("Back");
            back.setTextFill(Color.BLACK);
            back.setStyle("-fx-background-color:gray");
            back.setFont(new Font("bold", 20));
            back.setPrefWidth(200);
            back.setPrefHeight(50);
            back.setFont(font2);

            back.setOnAction(e -> {
                primaryStage.setScene(product(primaryStage));
            });

            Button buy = new Button("Buy now");
            buy.setTextFill(Color.BLACK);
            buy.setStyle("-fx-background-color:gray");
            buy.setFont(new Font("bold", 20));
            buy.setPrefWidth(200);
            buy.setPrefHeight(50);
            buy.setFont(font2);


            Label qames = new Label("Shirt");
            qames.setTextFill(Color.BLACK);
            qames.setPrefWidth(200);
            qames.setPrefHeight(100);
            qames.setFont(font2);

            Label size = new Label("Size : ");
            size.setTextFill(Color.BLACK);
            size.setPrefWidth(100);
            size.setPrefHeight(100);
            size.setFont(font2);

            RadioButton m = new RadioButton("M");
            RadioButton l = new RadioButton("L");
            RadioButton xl = new RadioButton("XL");

            ToggleGroup toggle = new ToggleGroup();

            m.setToggleGroup(toggle);
            m.setFont(font2);
            m.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            m.setTextFill(Color.BLACK);
            m.setMaxHeight(400);
            m.setMaxWidth(400);
            l.setToggleGroup(toggle);
            l.setFont(font2);
            l.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            l.setTextFill(Color.BLACK);
            l.setMaxHeight(400);
            l.setMaxWidth(400);
            xl.setToggleGroup(toggle);
            xl.setFont(font2);
            xl.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            xl.setTextFill(Color.BLACK);
            xl.setMaxHeight(400);
            xl.setMaxWidth(400);

            HBox shirt = new HBox(m, l, xl);
            shirt.setSpacing(15);
            shirt.setPadding(new Insets(25));
            shirt.setAlignment(Pos.CENTER_LEFT);

            HBox qamessize = new HBox(m, l, xl);
            qamessize.setSpacing(15);
            qamessize.setPadding(new Insets(25));
            qamessize.setAlignment(Pos.CENTER_LEFT);


            Label color = new Label("Color: ");
            color.setTextFill(Color.BLACK);
            color.setPrefWidth(150);
            color.setPrefHeight(20);
            color.setFont(font2);

            RadioButton black = new RadioButton("Black");
            RadioButton white = new RadioButton("White");
            RadioButton blue = new RadioButton("Blue");
            RadioButton green = new RadioButton("Green");

            ToggleGroup toggle1 = new ToggleGroup();

            black.setToggleGroup(toggle1);
            black.setFont(font2);
            black.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            black.setTextFill(Color.BLACK);
            black.setMaxHeight(400);
            black.setMaxWidth(400);
            white.setToggleGroup(toggle1);
            white.setFont(font2);
            white.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            white.setTextFill(Color.BLACK);
            white.setMaxHeight(400);
            white.setMaxWidth(400);
            blue.setToggleGroup(toggle1);
            blue.setFont(font2);
            blue.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            blue.setTextFill(Color.BLACK);
            blue.setMaxHeight(400);
            blue.setMaxWidth(400);
            green.setToggleGroup(toggle1);
            green.setFont(font2);
            green.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            green.setTextFill(Color.BLACK);
            green.setMaxHeight(400);
            green.setMaxWidth(400);

            HBox colors = new HBox(black, white, blue, green);
            colors.setSpacing(15);
            colors.setPadding(new Insets(25));
            colors.setAlignment(Pos.CENTER_LEFT);

            Label b = new Label("   Shirt   ");
            b.setFont(font2);
            b.setTextFill(Color.BLACK);
            b.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            b.setMaxHeight(150);
            b.setMaxWidth(150);


            TextField quantity = new TextField();
            quantity.setMaxHeight(40);
            quantity.setMaxWidth(200);

            Label price = new Label("50");
            price.setTextFill(Color.BLACK);
            price.setPrefWidth(150);
            price.setPrefHeight(20);
            price.setFont(font2);

            Label quantityy = new Label("quantity: ");
            quantityy.setTextFill(Color.BLACK);
            quantityy.setPrefWidth(150);
            quantityy.setPrefHeight(20);
            quantityy.setFont(font2);

            Label pricee = new Label("Price: ");
            pricee.setTextFill(Color.BLACK);
            pricee.setPrefWidth(150);
            pricee.setPrefHeight(20);
            pricee.setFont(font2);

            Button plus = new Button("+");
            plus.setTextFill(Color.BLACK);
            plus.setStyle("-fx-background-color:gray");
            plus.setFont(new Font("bold", 20));
            plus.setPrefWidth(40);
            plus.setPrefHeight(5);
            plus.setFont(font2);

            Button minus = new Button("-");
            minus.setTextFill(Color.BLACK);
            minus.setStyle("-fx-background-color:gray");
            minus.setFont(new Font("bold", 20));
            minus.setPrefWidth(40);
            minus.setPrefHeight(5);
            minus.setFont(font2);

            HBox qames1 = new HBox(quantityy, quantity, plus, minus);
            qames1.setSpacing(15);
            qames1.setPadding(new Insets(25));
            qames1.setAlignment(Pos.CENTER_LEFT);

            quantity.setText("1");

            int quantity1 = 0;
            black.setDisable(true);
            white.setDisable(true);
            green.setDisable(true);
            blue.setDisable(true);
            l.setDisable(true);
            m.setDisable(true);
            xl.setDisable(true);

            ObservableList<Product> products = Queries.getProducts();
            for (int i = 0; i < products.size(); i++) {
                if ("shirt".equals(products.get(i).getProductName())) {
                    String size1 = products.get(i).getSize();
                    String colour = products.get(i).getColour();
                    quantity1 = products.get(i).getQuantity();
                    String[] arr1 = colour.split(",");
                    String size2[] = size1.split(",");

                    for (int j = 0; j < arr1.length; j++) {
                        if (arr1[j].equals("black"))
                            black.setDisable(false);
                        else if (arr1[j].equals("green"))
                            green.setDisable(false);
                        else if (arr1[j].equals("white"))
                            white.setDisable(false);
                        else if (arr1[j].equals("blue"))
                            blue.setDisable(false);

                    }
                    for (int j = 0; j < size2.length; j++) {
                        if (size2[j].equals("M")) {
                            m.setDisable(false);
                        } else if (size2[j].equals("L")) {
                            l.setDisable(false);
                        } else if (size2[j].equals("XL")) {
                            xl.setDisable(false);
                        }
                    }
                    price.setText(String.valueOf(products.get(i).getPrice()));
                    if (quantity.getText().equals(Integer.toString(quantity1)))
                        plus.setDisable(true);
                }
            }
            int finalQuantity = quantity1;
            plus.setOnAction(e -> {
                if (Integer.parseInt(quantity.getText()) == finalQuantity) {

                } else
                    quantity.setText(Integer.parseInt(quantity.getText()) + 1 + "");
            });

            minus.setOnAction(e -> {
                if (Integer.parseInt(quantity.getText()) == 1) {
                    quantity.setText("1");
                } else {
                    quantity.setText(Integer.parseInt(quantity.getText()) - 1 + "");
                }
            });

            Label finalPrice = price;
            buy.setOnAction(e -> {
                FinalCost = Float.parseFloat(price.getText()) * Float.parseFloat(quantity.getText());
                resultOrder += "shirt," + quantity.getText() + "," + finalPrice.getText() + ",";


                if (black.isSelected())
                    resultOrder += "black,";
                else if (blue.isSelected())
                    resultOrder += "blue,";
                else if (white.isSelected())
                    resultOrder += "white,";
                else if (green.isSelected())
                    resultOrder += "green,";

                if (m.isSelected())
                    resultOrder += "M,";
                else if (l.isSelected())
                    resultOrder += "L,";
                else if (xl.isSelected())
                    resultOrder += "XL,";

                if (toggle1.getSelectedToggle() == (null))
                    AlertBox.display("Choice All");
                else
                    primaryStage.setScene(Pay(primaryStage));
            });

            HBox qames2 = new HBox(pricee, price);
            qames2.setSpacing(15);
            qames2.setPadding(new Insets(25));
            qames2.setAlignment(Pos.CENTER_LEFT);

            HBox button = new HBox(back, buy);
            button.setSpacing(15);
            button.setPadding(new Insets(25));
            button.setAlignment(Pos.CENTER_LEFT);

            Image image = new Image("file:qames.jpg");
            ImageView imag = new ImageView(image);
            imag.setFitHeight(400);
            imag.setFitWidth(400);

            pane.add(qames, 0, 0);
            pane.add(size, 0, 1);
            pane.add(qamessize, 0, 2);
            pane.add(color, 0, 3);
            pane.add(colors, 0, 4);
            pane.add(qames1, 0, 5);
            pane.add(qames2, 0, 6);
            pane.add(button, 0, 7);

            pane.setAlignment(Pos.CENTER);
            root.setTop(b);
            root.setAlignment(b, Pos.TOP_CENTER);
            root.setCenter(pane);
            root.setAlignment(pane, Pos.CENTER);
            root.setRight(imag);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }

    public static Scene Trouser(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1370, 700);

        try {
            GridPane pane = new GridPane();
            Font font2 = new Font("Comic Sans Ms", 25);

            Button back = new Button("Back");
            back.setTextFill(Color.BLACK);
            back.setStyle("-fx-background-color:gray");
            back.setFont(new Font("bold", 20));
            back.setPrefWidth(200);
            back.setPrefHeight(50);
            back.setFont(font2);

            back.setOnAction(e -> {
                primaryStage.setScene(product(primaryStage));
            });

            Button buy = new Button("Buy now");
            buy.setTextFill(Color.BLACK);
            buy.setStyle("-fx-background-color:gray");
            buy.setFont(new Font("bold", 20));
            buy.setPrefWidth(200);
            buy.setPrefHeight(50);
            buy.setFont(font2);

            buy.setOnAction(e -> {
                primaryStage.setScene(Pay(primaryStage));
            });

            Label trouser = new Label("Trouser");
            trouser.setTextFill(Color.BLACK);
            trouser.setPrefWidth(200);
            trouser.setPrefHeight(100);
            trouser.setFont(font2);

            Label size = new Label("Size : ");
            size.setTextFill(Color.BLACK);
            size.setPrefWidth(100);
            size.setPrefHeight(100);
            size.setFont(font2);

            RadioButton size1 = new RadioButton("38");
            RadioButton size2 = new RadioButton("39");
            RadioButton size3 = new RadioButton("40");
            RadioButton size4 = new RadioButton("41");
            RadioButton size5 = new RadioButton("42");


            ToggleGroup toggle = new ToggleGroup();

            size1.setToggleGroup(toggle);
            size1.setFont(font2);
            size1.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            size1.setTextFill(Color.BLACK);
            size1.setMaxHeight(400);
            size1.setMaxWidth(400);
            size2.setToggleGroup(toggle);
            size2.setFont(font2);
            size2.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            size2.setTextFill(Color.BLACK);
            size2.setMaxHeight(400);
            size2.setMaxWidth(400);
            size3.setToggleGroup(toggle);
            size3.setFont(font2);
            size3.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            size3.setTextFill(Color.BLACK);
            size3.setMaxHeight(400);
            size3.setMaxWidth(400);
            size4.setToggleGroup(toggle);
            size4.setFont(font2);
            size4.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            size4.setTextFill(Color.BLACK);
            size4.setMaxHeight(400);
            size4.setMaxWidth(400);
            size5.setToggleGroup(toggle);
            size5.setFont(font2);
            size5.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            size5.setTextFill(Color.BLACK);
            size5.setMaxHeight(400);
            size5.setMaxWidth(400);

            HBox trousersize = new HBox(size1, size2, size3, size4, size5);
            trousersize.setSpacing(15);
            trousersize.setPadding(new Insets(25));
            trousersize.setAlignment(Pos.CENTER_LEFT);


            Label color = new Label("Color: ");
            color.setTextFill(Color.BLACK);
            color.setPrefWidth(150);
            color.setPrefHeight(20);
            color.setFont(font2);

            RadioButton black = new RadioButton("Black");
            RadioButton white = new RadioButton("White");
            RadioButton blue = new RadioButton("Blue");
            RadioButton green = new RadioButton("Green");

            ToggleGroup toggle1 = new ToggleGroup();

            black.setToggleGroup(toggle1);
            black.setFont(font2);
            black.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            black.setTextFill(Color.BLACK);
            black.setMaxHeight(400);
            black.setMaxWidth(400);
            white.setToggleGroup(toggle1);
            white.setFont(font2);
            white.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            white.setTextFill(Color.BLACK);
            white.setMaxHeight(400);
            white.setMaxWidth(400);
            blue.setToggleGroup(toggle1);
            blue.setFont(font2);
            blue.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            blue.setTextFill(Color.BLACK);
            blue.setMaxHeight(400);
            blue.setMaxWidth(400);
            green.setToggleGroup(toggle1);
            green.setFont(font2);
            green.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            green.setTextFill(Color.BLACK);
            green.setMaxHeight(400);
            green.setMaxWidth(400);

            HBox colors = new HBox(black, white, blue, green);
            colors.setSpacing(15);
            colors.setPadding(new Insets(25));
            colors.setAlignment(Pos.CENTER_LEFT);

            Label b = new Label("   Trousers  ");
            b.setFont(font2);
            b.setTextFill(Color.BLACK);
            b.setStyle("-fx-background-radius:10,10,10,10;-fx-background-color:gray;");
            b.setMaxHeight(150);
            b.setMaxWidth(150);


            TextField quantity = new TextField();
            quantity.setMaxHeight(40);
            quantity.setMaxWidth(200);

            Label price = new Label("50");
            price.setTextFill(Color.BLACK);
            price.setPrefWidth(150);
            price.setPrefHeight(20);
            price.setFont(font2);

            Label quantityy = new Label("quantity: ");
            quantityy.setTextFill(Color.BLACK);
            quantityy.setPrefWidth(150);
            quantityy.setPrefHeight(20);
            quantityy.setFont(font2);

            Label pricee = new Label("Price: ");
            pricee.setTextFill(Color.BLACK);
            pricee.setPrefWidth(150);
            pricee.setPrefHeight(20);
            pricee.setFont(font2);

            Button plus = new Button("+");
            plus.setTextFill(Color.BLACK);
            plus.setStyle("-fx-background-color:gray");
            plus.setFont(new Font("bold", 20));
            plus.setPrefWidth(40);
            plus.setPrefHeight(5);
            plus.setFont(font2);

            Button minus = new Button("-");
            minus.setTextFill(Color.BLACK);
            minus.setStyle("-fx-background-color:gray");
            minus.setFont(new Font("bold", 20));
            minus.setPrefWidth(40);
            minus.setPrefHeight(5);
            minus.setFont(font2);

            HBox trouser1 = new HBox(quantityy, quantity, plus, minus);
            trouser1.setSpacing(15);
            trouser1.setPadding(new Insets(25));
            trouser1.setAlignment(Pos.CENTER_LEFT);

            quantity.setText("1");

            int quantity1 = 0;
            black.setDisable(true);
            white.setDisable(true);
            green.setDisable(true);
            blue.setDisable(true);
            size1.setDisable(true);
            size2.setDisable(true);
            size3.setDisable(true);
            size4.setDisable(true);
            size5.setDisable(true);

            ObservableList<Product> products = Queries.getProducts();
            for (int i = 0; i < products.size(); i++) {
                if ("trouser".equals(products.get(i).getProductName())) {
                    String size6 = products.get(i).getSize();
                    String colour = products.get(i).getColour();
                    quantity1 = products.get(i).getQuantity();
                    String[] arr1 = colour.split(",");
                    String size7[] = size6.split(",");

                    for (int j = 0; j < arr1.length; j++) {
                        if (arr1[j].equals("Black"))
                            black.setDisable(false);
                        else if (arr1[j].equals("Green"))
                            green.setDisable(false);
                        else if (arr1[j].equals("White"))
                            white.setDisable(false);
                        else if (arr1[j].equals("Blue"))
                            blue.setDisable(false);

                    }
                    for (int j = 0; j < size7.length; j++) {
                        if (size7[j].equals("38")) {
                            size1.setDisable(false);
                        } else if (size7[j].equals("39")) {
                            size2.setDisable(false);
                        } else if (size7[j].equals("40")) {
                            size3.setDisable(false);
                        } else if (size7[j].equals("41")) {
                            size4.setDisable(false);
                        } else if (size7[j].equals("42")) {
                            size5.setDisable(false);
                        }
                    }
                    price.setText(String.valueOf(products.get(i).getPrice()));
                    if (quantity.getText().equals(Integer.toString(quantity1)))
                        plus.setDisable(true);
                }
            }
            int finalQuantity = quantity1;
            plus.setOnAction(e -> {
                if (Integer.parseInt(quantity.getText()) == finalQuantity) {

                } else
                    quantity.setText(Integer.parseInt(quantity.getText()) + 1 + "");
            });

            minus.setOnAction(e -> {
                if (Integer.parseInt(quantity.getText()) == 1) {
                    quantity.setText("1");
                } else {
                    quantity.setText(Integer.parseInt(quantity.getText()) - 1 + "");
                }
            });

            Label finalPrice = price;
            buy.setOnAction(e -> {
                FinalCost = Float.parseFloat(price.getText()) * Float.parseFloat(quantity.getText());
                resultOrder += "trouser," + quantity.getText() + "," + finalPrice.getText() + ",";


                if (black.isSelected())
                    resultOrder += "black,";
                else if (blue.isSelected())
                    resultOrder += "blue,";
                else if (white.isSelected())
                    resultOrder += "white,";
                else if (green.isSelected())
                    resultOrder += "green,";

                if (size1.isSelected())
                    resultOrder += "38,";
                else if (size2.isSelected())
                    resultOrder += "39,";
                else if (size3.isSelected())
                    resultOrder += "40,";
                else if (size4.isSelected())
                    resultOrder += "41,";
                else if (size5.isSelected())
                    resultOrder += "42,";


                if (toggle1.getSelectedToggle() == (null))
                    AlertBox.display("Choice All");
                else
                    primaryStage.setScene(Pay(primaryStage));
            });


            HBox trouser2 = new HBox(pricee, price);
            trouser2.setSpacing(15);
            trouser2.setPadding(new Insets(25));
            trouser2.setAlignment(Pos.CENTER_LEFT);

            HBox button = new HBox(back, buy);
            button.setSpacing(15);
            button.setPadding(new Insets(25));
            button.setAlignment(Pos.CENTER_LEFT);

            Image image = new Image("file:bntalon.jpg");
            ImageView imag = new ImageView(image);
            imag.setFitHeight(400);
            imag.setFitWidth(400);

            pane.add(trouser, 0, 0);
            pane.add(size, 0, 1);
            pane.add(trousersize, 0, 2);
            pane.add(color, 0, 3);
            pane.add(colors, 0, 4);
            pane.add(trouser1, 0, 5);
            pane.add(trouser2, 0, 6);
            pane.add(button, 0, 7);

            pane.setAlignment(Pos.CENTER);
            root.setTop(b);
            root.setAlignment(b, Pos.TOP_CENTER);
            root.setCenter(pane);
            root.setAlignment(pane, Pos.CENTER);
            root.setRight(imag);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }

}

