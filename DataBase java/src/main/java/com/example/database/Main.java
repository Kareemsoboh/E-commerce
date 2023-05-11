package com.example.database;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.sql.SQLException;
import java.text.ParseException;

import static com.example.database.Scenes.IDEmp;


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        stage.setScene(Main.Main(stage));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Scene Main(Stage stage) {
        Group group1 = new Group();
        Button button1 = new Button("Product table");
        button1.setLayoutX(20);
        button1.setLayoutY(100);
        button1.setPrefSize(100, 50);
        button1.setCursor(Cursor.CLOSED_HAND);
        button1.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        button1.setOnAction(e -> {
            stage.setScene(Main.product(stage));
        });
        Button button2 = new Button("Order table");
        button2.setLayoutX(20);
        button2.setLayoutY(200);
        button2.setPrefSize(100, 50);
        button2.setOnAction(e -> {
            stage.setScene(Main.Order(stage));
        });
        button2.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button2.setCursor(Cursor.CLOSED_HAND);
        Button button3 = new Button("Customer table");

        button3.setLayoutX(20);
        button3.setLayoutY(300);
        button3.setPrefSize(100, 50);

        button3.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button3.setCursor(Cursor.CLOSED_HAND);
        button3.setOnAction(e -> {
            stage.setScene(Main.Customer(stage));
        });
        Button button4 = new Button("employee table");
        button4.setLayoutX(20);
        button4.setLayoutY(400);
        button4.setPrefSize(100, 50);

        button4.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button4.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button4.setCursor(Cursor.CLOSED_HAND);
        button4.setOnAction(e -> {
            stage.setScene(Main.Employee(stage));
        });

        Image img1 = new Image("file:online.jpg");
        ImageView Img1 = new ImageView(img1);
        Img1.setPreserveRatio(true);
        Img1.setFitHeight(420);
        Img1.setFitWidth(420);
        Img1.setLayoutX(270);
        Img1.setLayoutY(80);
        Label label1 = new Label("Shopping Online");
        label1.setFont(Font.font(16));
        label1.setPrefWidth(150);
        label1.setAlignment(Pos.CENTER);
        label1.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        label1.setLayoutX(330);
        label1.setLayoutY(440);
        group1.getChildren().addAll(button4, button1, button2, button3, Img1, label1);
        Scene scene = new Scene(group1);
        stage.setTitle("Main page");
        stage.setY(250);
        stage.setX(500);
        stage.setWidth(800);
        stage.setHeight(550);
        stage.setScene(scene);

        return scene;
    }

    public static Scene product(Stage stage) {
        Group group = new Group();
        Button button = new Button("insert");
        button.setLayoutX(20);
        button.setLayoutY(100);
        button.setPrefSize(100, 50);
        button.setCursor(Cursor.CLOSED_HAND);
        button.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        button.setOnAction(e -> {
            try {
                stage.setScene(Main.insertproduct(stage));
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });


        Button button1 = new Button("update");
        button1.setLayoutX(20);
        button1.setLayoutY(200);
        button1.setPrefSize(100, 50);

        button1.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button1.setCursor(Cursor.CLOSED_HAND);
        button1.setOnAction(e -> {
            try {
                stage.setScene(Main.updateproduct(stage));
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        Button button2 = new Button("Delete");
        button2.setLayoutX(20);
        button2.setLayoutY(300);
        button2.setPrefSize(100, 50);

        button2.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button2.setCursor(Cursor.CLOSED_HAND);

        button2.setOnAction(e -> {
            stage.setScene(Main.Deleteproduct(stage));
        });
        Button button3 = new Button("Select");
        button3.setLayoutX(20);
        button3.setLayoutY(400);
        button3.setPrefSize(100, 50);

        button3.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button3.setCursor(Cursor.CLOSED_HAND);
        button3.setOnAction(e -> {
            try {
                stage.setScene(Main.Selectproduct(stage));
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        Button button4 = new Button("Back");
        button4.setOnAction(e -> {
            stage.setScene(Main.Main(stage));
        });
        button4.setLayoutX(20);
        button4.setLayoutY(460);
        button4.setPrefSize(100, 20);
        button4.setCursor(Cursor.CLOSED_HAND);

        Image img = new Image("file:online1.jpg");
        ImageView Img = new ImageView(img);
        Img.setPreserveRatio(true);
        Img.setFitHeight(350);
        Img.setFitWidth(400);
        Img.setLayoutX(270);
        Img.setLayoutY(75);
        Label label = new Label("Shopping Online");
        label.setFont(Font.font(16));
        label.setPrefWidth(150);
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        label.setLayoutX(330);
        label.setLayoutY(440);
        group.getChildren().addAll(button, button1, button2, button3, button4, Img, label);
        Scene scene = new Scene(group);
        stage.setTitle("Main page");
        stage.setY(250);
        stage.setX(500);
        stage.setWidth(800);
        stage.setHeight(550);
        stage.setScene(scene);
        return scene;


    }

    public static Scene Order(Stage stage) {
        Group group = new Group();

        VBox vBox = new VBox(25);

        Button button2 = new Button("Delete");

        button2.setPrefSize(200, 50);

        button2.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button2.setCursor(Cursor.CLOSED_HAND);
        button2.setOnAction(actionEvent -> {
            stage.setScene(Main.Deleteorder(stage));
        });
        Button button3 = new Button("Select");

        button3.setPrefSize(200, 50);

        button3.setOnAction(actionEvent -> {
            stage.setScene(Main.Selectorder(stage));
        });


        button3.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button3.setCursor(Cursor.CLOSED_HAND);
        Button button4 = new Button("Select order with product description");
        button4.setPrefSize(200, 50);
        button4.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button4.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button4.setOnAction(e -> {
            stage.setScene(Main.SelectOrderWithProductDescription(stage));
        });
        button4.setCursor(Cursor.CLOSED_HAND);

        vBox.getChildren().addAll(button2, button3, button4);
        vBox.setPadding(new Insets(15));

        Button button = new Button("Back");
        button.setLayoutX(20);
        button.setLayoutY(440);
        button.setPrefSize(200, 40);
        button.setOnAction(e -> {
            stage.setScene(Main.Main(stage));
        });

        Label label = new Label("Shopping Online");
        label.setPrefWidth(300);
        label.setPrefHeight(40);
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        Image img = new Image("file:online1.jpg");
        ImageView Img = new ImageView(img);
        Img.setPreserveRatio(true);
        Img.setFitHeight(350);
        Img.setFitWidth(400);
        Img.setLayoutX(270);
        Img.setLayoutY(75);
        label.setLayoutX(290);
        label.setLayoutY(440);
        group.getChildren().addAll(vBox, button, Img, label);
        Scene scene = new Scene(group);
        stage.setTitle("Main page");
        stage.setY(250);
        stage.setX(500);
        stage.setWidth(800);
        stage.setHeight(550);
        stage.setScene(scene);
        return scene;


    }

    public static Scene Customer(Stage stage) {
        Group group = new Group();
        Button button = new Button("insert");
        button.setLayoutX(20);
        button.setLayoutY(100);
        button.setPrefSize(100, 50);
        button.setCursor(Cursor.CLOSED_HAND);
        button.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button.setOnAction(e -> {
            stage.setScene(Main.insertcustomer(stage));
        });

        Button button1 = new Button("update");
        button1.setLayoutX(20);
        button1.setLayoutY(200);
        button1.setPrefSize(100, 50);
        button1.setOnAction(e -> {
            stage.setScene(Main.updatecustomer(stage));
        });

        button1.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button1.setCursor(Cursor.CLOSED_HAND);

        Button button2 = new Button("Delete");
        button2.setLayoutX(20);
        button2.setLayoutY(300);
        button2.setPrefSize(100, 50);

        button2.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button2.setCursor(Cursor.CLOSED_HAND);

        button2.setOnAction(e -> {
            stage.setScene(Main.Deletecustomer(stage));
        });
        Button button3 = new Button("Select");
        button3.setLayoutX(20);
        button3.setLayoutY(400);
        button3.setPrefSize(100, 50);

        button3.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button3.setCursor(Cursor.CLOSED_HAND);
        button3.setOnAction(e -> {
            stage.setScene(Main.Selectcustomer(stage));
        });

        Image img = new Image("file:online1.jpg");
        ImageView Img = new ImageView(img);
        Img.setPreserveRatio(true);
        Img.setFitHeight(350);
        Img.setFitWidth(400);
        Img.setLayoutX(270);
        Img.setLayoutY(75);

        Button button4 = new Button("Back");
        button4.setOnAction(e -> {
            stage.setScene(Main.Main(stage));
        });
        button4.setLayoutX(20);
        button4.setLayoutY(460);
        button4.setPrefSize(100, 20);
        button4.setCursor(Cursor.CLOSED_HAND);
        Label label = new Label("Shopping Online");
        label.setFont(Font.font(16));
        label.setPrefWidth(150);
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        label.setLayoutX(330);
        label.setLayoutY(440);
        group.getChildren().addAll(button, button1, button2, button3, button4, Img, label);
        Scene scene = new Scene(group);
        stage.setTitle("Main page");
        stage.setY(250);
        stage.setX(500);
        stage.setWidth(800);
        stage.setHeight(550);
        stage.setScene(scene);
        return scene;


    }

    public static Scene Employee(Stage stage) {
        Group group = new Group();
        Button button = new Button("insert");
        button.setLayoutX(20);
        button.setLayoutY(100);
        button.setPrefSize(100, 50);
        button.setCursor(Cursor.CLOSED_HAND);
        button.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button.setOnAction(e -> {
            stage.setScene(Main.insertemployee(stage));
        });

        Button button1 = new Button("update");
        button1.setLayoutX(20);
        button1.setLayoutY(200);
        button1.setPrefSize(100, 50);

        button1.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button1.setCursor(Cursor.CLOSED_HAND);
        button1.setOnAction(e -> {
            stage.setScene(Main.updateemployee(stage));
        });

        Button button2 = new Button("Delete");
        button2.setLayoutX(20);
        button2.setLayoutY(300);
        button2.setPrefSize(100, 50);

        button2.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button2.setCursor(Cursor.CLOSED_HAND);

        button2.setOnAction(e -> {
            stage.setScene(Main.Deleteemployee(stage));
        });
        Button button3 = new Button("Select");
        button3.setLayoutX(20);
        button3.setLayoutY(400);
        button3.setPrefSize(100, 50);

        button3.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button3.setCursor(Cursor.CLOSED_HAND);
        button3.setOnAction(e -> {
            stage.setScene(Main.Selectemployee(stage));
        });

        Button button4 = new Button("Back");
        button4.setOnAction(e -> {
            stage.setScene(Main.Main(stage));
        });
        button4.setLayoutX(20);
        button4.setLayoutY(460);
        button4.setPrefSize(100, 20);
        button4.setCursor(Cursor.CLOSED_HAND);

        Image img = new Image("file:online1.jpg");
        ImageView Img = new ImageView(img);
        Img.setPreserveRatio(true);
        Img.setFitHeight(350);
        Img.setFitWidth(400);
        Img.setLayoutX(270);
        Img.setLayoutY(75);
        Label label = new Label("Shopping Online");
        label.setFont(Font.font(16));
        label.setPrefWidth(150);
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        label.setLayoutX(330);
        label.setLayoutY(440);
        group.getChildren().addAll(button, button1, button2, button3, button4, Img, label);
        Scene scene = new Scene(group);
        stage.setTitle("Main page");
        stage.setY(250);
        stage.setX(500);
        stage.setWidth(800);
        stage.setHeight(550);
        stage.setScene(scene);
        return scene;


    }

    public static Scene insertproduct(Stage stage) throws SQLException, ClassNotFoundException {
        Group group2 = new Group();
        GridPane Gridpane = new GridPane();
        HBox hbox = new HBox(10);
        HBox hbox1 = new HBox(10);
        Label Label1 = new Label("Type");
        Label Label2 = new Label("Size");
        Label Label3 = new Label("Color");
        Label Label4 = new Label("Quantity");
        Label Label5 = new Label("Price");
        TextField text = new TextField();
        TextField text1 = new TextField();
        Label1.setFont(Font.font(16));
        Label1.setPrefWidth(100);
        Label1.setAlignment(Pos.CENTER);
        Label1.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Label1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Label2.setFont(Font.font(16));
        Label2.setPrefWidth(100);
        Label2.setAlignment(Pos.CENTER);
        Label2.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Label2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        Label3.setFont(Font.font(16));
        Label3.setPrefWidth(100);
        Label3.setAlignment(Pos.CENTER);
        Label3.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Label3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        Label4.setFont(Font.font(16));
        Label4.setPrefWidth(100);
        Label4.setAlignment(Pos.CENTER);
        Label4.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Label4.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        Label5.setFont(Font.font(16));
        Label5.setPrefWidth(100);
        Label5.setAlignment(Pos.CENTER);
        Label5.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Label5.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        ComboBox<String> combobox = new ComboBox<>();
        combobox.setValue("Choose type");
        combobox.getItems().addAll("shirt", "Tshirt", "Hat", "Boot", "Wristwatch", "trouser");


        RadioButton radio = new RadioButton("M");
        RadioButton radio1 = new RadioButton("L");
        RadioButton radio2 = new RadioButton("XL");
        hbox.getChildren().addAll(radio, radio1, radio2);

        RadioButton radio3 = new RadioButton("Black");
        RadioButton radio4 = new RadioButton("White");
        RadioButton radio5 = new RadioButton("Blue");
        RadioButton radio6 = new RadioButton("Green");

        RadioButton radio7 = new RadioButton("38");
        RadioButton radio8 = new RadioButton("39");
        RadioButton radio9 = new RadioButton("40");
        RadioButton radio10 = new RadioButton("41");
        RadioButton radio11 = new RadioButton("42");

        HBox hBox = new HBox(2);
        hBox.getChildren().addAll(radio7, radio8, radio9, radio10, radio11);

        combobox.setOnAction(e -> {
            if (combobox.getValue().equals("Boot") || combobox.getValue().equals("trouser")) {
                hBox.setDisable(false);
                hbox.setDisable(true);
            } else if (combobox.getValue().equals("Wristwatch")) {
                hbox.setDisable(true);
                hBox.setDisable(true);
            } else {
                hBox.setDisable(true);
                hbox.setDisable(false);
            }
        });

        hbox1.getChildren().addAll(radio3, radio4, radio5, radio6);
        Gridpane.setPadding(new Insets(10, 0, 0, 10));
        Gridpane.add(Label1, 0, 0);
        Gridpane.add(Label2, 0, 1);
        Gridpane.add(Label3, 0, 3);
        Gridpane.add(Label4, 0, 4);
        Gridpane.add(Label5, 0, 5);
        Gridpane.add(hBox, 1, 2);
        Gridpane.add(combobox, 1, 0);
        Gridpane.add(hbox, 1, 1);
        Gridpane.add(hbox1, 1, 3);
        Gridpane.add(text, 1, 4);
        Gridpane.add(text1, 1, 5);

        Gridpane.setHgap(20);
        Gridpane.setVgap(30);

        Button Button6 = new Button("Back");
        Button6.setLayoutX(80);
        Button6.setLayoutY(350);
        Button6.setFont(Font.font(16));
        Button6.setPrefSize(70, 35);

        Button6.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button6.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Button6.setCursor(Cursor.CLOSED_HAND);
        Button6.setOnAction(e -> {
            stage.setScene(Main.product(stage));
        });
        Button Button7 = new Button("insert");
        Button7.setLayoutX(220);
        Button7.setLayoutY(350);
        Button7.setFont(Font.font(16));
        Button7.setPrefSize(70, 35);

        Button7.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button7.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Button7.setCursor(Cursor.CLOSED_HAND);
        ObservableList<Product> list = Queries.getProducts();

        for (int i = 0; i < Queries.getProducts().size(); i++) {
            if ("Tshirt".equals(list.get(i).getProductName())) {
                combobox.getItems().remove("Tshirt");
            } else if ("Hat".equals(list.get(i).getProductName())) {
                combobox.getItems().remove("Hat");
            } else if ("shirt".equals(list.get(i).getProductName())) {
                combobox.getItems().remove("shirt");
            } else if ("trouser".equals(list.get(i).getProductName())) {
                combobox.getItems().remove("trouser");
            } else if ("wristwatch".equals(list.get(i).getProductName())) {
                combobox.getItems().remove("Wristwatch");
            } else if ("boot".equals(list.get(i).getProductName())) {
                combobox.getItems().remove("Boot");
            }

        }
        Button7.setOnAction(actionEvent -> {
            try {
                String size = "";
                String colour = "";
                int quantity = Integer.parseInt(text.getText());
                float price = Float.parseFloat(text1.getText());
                if (radio.isSelected())
                    size += radio.getText() + ",";
                if (radio1.isSelected())
                    size += radio1.getText() + ",";
                if (radio2.isSelected())
                    size += radio2.getText() + ",";
                if (radio3.isSelected())
                    colour += radio3.getText() + ",";
                if (radio4.isSelected())
                    colour += radio4.getText() + ",";
                if (radio5.isSelected())
                    colour += radio5.getText() + ",";
                if (radio6.isSelected())
                    colour += radio6.getText() + ",";
                if (radio7.isSelected())
                    size += radio7.getText() + ",";
                if (radio8.isSelected())
                    size += radio8.getText() + ",";
                if (radio9.isSelected())
                    size += radio9.getText() + ",";
                if (radio10.isSelected())
                    size += radio10.getText() + ",";
                if (radio11.isSelected())
                    size += radio11.getText() + ",";
                String name = combobox.getValue();
                Product product = new Product(name, size, colour, quantity, price, IDEmp, 1);
                Queries.insertProduct(product);
            } catch (Exception e) {
                AlertBox.display("Correct properties");
            }
        });


        group2.getChildren().addAll(Gridpane, Button6, Button7);

        Scene scene = new Scene(group2);
        stage.setY(250);
        stage.setX(500);
        stage.setWidth(400);
        stage.setHeight(450);
        stage.setScene(scene);
        return scene;


    }

    public static Scene updateemployee(Stage stage) {
        Group group = new Group();
        VBox vBox = new VBox(10);

        Label l = new Label("Insert Employee");
        l.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        l.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        l.setAlignment(Pos.CENTER);
        l.setPrefWidth(300);
        l.setPrefHeight(30);


        GridPane gridPane = new GridPane();
        Label label = new Label("ID Employee");
        Label label1 = new Label("Password");

        label.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label.setAlignment(Pos.CENTER);
        label.setPrefWidth(150);
        label.setPrefHeight(25);


        label1.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label1.setAlignment(Pos.CENTER);
        label1.setPrefWidth(150);
        label1.setPrefHeight(25);


        TextField textField = new TextField();
        TextField textField1 = new TextField();


        gridPane.setVgap(15);
        gridPane.setHgap(5);

        gridPane.add(label, 0, 0);
        gridPane.add(label1, 0, 1);


        gridPane.add(textField, 1, 0);
        gridPane.add(textField1, 1, 1);

        Label label2 = new Label();
        label2.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label2.setAlignment(Pos.CENTER);
        label2.setPrefWidth(300);
        label2.setPrefHeight(30);

        HBox hBox = new HBox(5);
        Button button = new Button("Update");
        Button button1 = new Button("Back");
        button.setPrefSize(150, 20);
        button1.setPrefSize(150, 20);
        button1.setOnAction(e -> stage.setScene(Main.Employee(stage)));
        button.setOnAction(actionEvent -> {
            try {
                int id = Integer.parseInt(textField.getText());
                String password = textField1.getText();
                try {
                    Queries.updateEmployeePassword(id, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                AlertBox.display("Correct properties");
            }
        });
        hBox.getChildren().addAll(button, button1);

        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(l, gridPane, label2, hBox);

        group.getChildren().add(vBox);

        return new Scene(group);

    }

    public static Scene insertemployee(Stage stage) {
        Group group = new Group();
        VBox vBox = new VBox(10);

        Label l = new Label("Insert Employee");
        l.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        l.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        l.setAlignment(Pos.CENTER);
        l.setPrefWidth(300);
        l.setPrefHeight(30);


        GridPane gridPane = new GridPane();


        Label label2 = new Label("User name");
        Label label3 = new Label("Password");


        label2.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label2.setAlignment(Pos.CENTER);
        label2.setPrefWidth(150);
        label2.setPrefHeight(25);

        label3.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label3.setAlignment(Pos.CENTER);
        label3.setPrefWidth(150);
        label3.setPrefHeight(25);


        TextField textField2 = new TextField();
        TextField textField3 = new TextField();

        gridPane.setVgap(15);
        gridPane.setHgap(5);


        gridPane.add(label2, 0, 2);
        gridPane.add(label3, 0, 3);


        gridPane.add(textField2, 1, 2);
        gridPane.add(textField3, 1, 3);

        HBox hBox = new HBox(5);
        Button button = new Button("insert");
        Button button1 = new Button("Back");
        button.setPrefSize(150, 20);
        button1.setPrefSize(150, 20);
        button1.setOnAction(e -> stage.setScene(Main.Employee(stage)));
        button.setOnAction(actionEvent -> {
            try {
                String lname = textField2.getText();
                String password = textField3.getText();
                boolean bool = false;
                try {
                    ObservableList<Employee> list = Queries.getEmployees();
                    for (int i = 0; i < list.size(); i++) {
                        if (lname.equals(list.get(i).getUserName())) {
                            AlertBox.display("User name is already used");
                            bool = true;
                        }

                    }
                    if (!bool) {
                        Employee emp = new Employee(lname, password);
                        Queries.insertEmployee(emp);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                AlertBox.display("Correct input");
            }

        });
        hBox.getChildren().addAll(button, button1);

        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(l, gridPane, hBox);

        group.getChildren().add(vBox);

        return new Scene(group);


    }

    public static Scene Deleteproduct(Stage stage) {
        Group group = new Group();
        VBox vBox = new VBox(50);
        HBox hBox = new HBox(5);
        Label label = new Label("Product name");
        label.setFont(Font.font(16));
        label.setPrefWidth(100);
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        TextField textField = new TextField();
        hBox.getChildren().addAll(label, textField);

        Button button = new Button("Delete");

        button.setLayoutX(220);
        button.setLayoutY(350);
        button.setFont(Font.font(16));
        button.setPrefSize(70, 35);

        button.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        button.setOnAction(actionEvent -> {
            try {
                try {
                    Queries.DeleteProduct(textField.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                AlertBox.display("Correct input");
            }
        });
        button.setCursor(Cursor.CLOSED_HAND);
        Button button1 = new Button("Back");
        button1.setLayoutX(200);
        button1.setLayoutY(300);
        button1.setFont(Font.font(16));
        button1.setPrefSize(70, 35);

        button1.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button1.setCursor(Cursor.CLOSED_HAND);
        button1.setOnAction(e -> {
            stage.setScene(Main.product(stage));
        });
        HBox hBox1 = new HBox(5);

        hBox1.getChildren().addAll(button, button1);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(hBox, hBox1);
        group.getChildren().add(vBox);
        Scene scene = new Scene(group);
        stage.setY(200);
        stage.setX(500);
        stage.setWidth(300);
        stage.setHeight(300);
        stage.setScene(scene);
        return scene;

    }

    public static Scene Deleteorder(Stage stage) {
        Group group = new Group();
        VBox vBox = new VBox(50);
        HBox hBox = new HBox(5);
        Label label = new Label("order ID");
        label.setFont(Font.font(16));
        label.setPrefWidth(100);
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        TextField textField = new TextField();
        hBox.getChildren().addAll(label, textField);

        Button button = new Button("Delete");

        button.setLayoutX(220);
        button.setLayoutY(350);
        button.setFont(Font.font(16));
        button.setPrefSize(70, 35);

        button.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        button.setOnAction(actionEvent -> {
            try {
                try {
                    int id = Integer.parseInt(textField.getText());
                    ObservableList<Order> list = Queries.getOrders();
                    for (int i = 0; i < list.size(); i++) {
                        if (id == list.get(i).getOrderID())
                            Queries.DeleteOrder(id);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                AlertBox.display("Correct input");
            }
        });
        button.setCursor(Cursor.CLOSED_HAND);
        Button button1 = new Button("Back");
        button1.setLayoutX(200);
        button1.setLayoutY(300);
        button1.setFont(Font.font(16));
        button1.setPrefSize(70, 35);

        button1.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button1.setCursor(Cursor.CLOSED_HAND);
        button1.setOnAction(e -> {
            stage.setScene(Main.Order(stage));
        });
        HBox hBox1 = new HBox(5);

        hBox1.getChildren().addAll(button, button1);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(hBox, hBox1);
        group.getChildren().add(vBox);
        Scene scene = new Scene(group);
        stage.setY(200);
        stage.setX(500);
        stage.setWidth(300);
        stage.setHeight(300);
        stage.setScene(scene);
        return scene;

    }

    public static Scene Deletecustomer(Stage stage) {
        Group group = new Group();
        VBox vBox = new VBox(50);
        HBox hBox = new HBox(5);
        Label label = new Label("customer ID");
        label.setFont(Font.font(16));
        label.setPrefWidth(100);
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        TextField textField = new TextField();
        hBox.getChildren().addAll(label, textField);

        Button button = new Button("Delete");

        button.setLayoutX(220);
        button.setLayoutY(350);
        button.setFont(Font.font(16));
        button.setPrefSize(70, 35);

        button.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        button.setOnAction(actionEvent -> {
            try {
                ObservableList<Customer> list = null;
                try {
                    int id = Integer.parseInt(textField.getText());
                    list = Queries.getCustomers();
                    for (int i = 0; i < list.size(); i++) {
                        if (id == list.get(i).getCustomerID()) {
                            Queries.DeleteCustomer(id);

                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                AlertBox.display("Correct input");
            }

        });
        button.setCursor(Cursor.CLOSED_HAND);
        Button button1 = new Button("Back");
        button1.setLayoutX(200);
        button1.setLayoutY(300);
        button1.setFont(Font.font(16));
        button1.setPrefSize(70, 35);

        button1.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button1.setCursor(Cursor.CLOSED_HAND);
        button1.setOnAction(e -> {
            stage.setScene(Main.product(stage));
        });
        HBox hBox1 = new HBox(5);

        hBox1.getChildren().addAll(button, button1);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(hBox, hBox1);
        group.getChildren().add(vBox);
        Scene scene = new Scene(group);
        stage.setY(200);
        stage.setX(500);
        stage.setWidth(300);
        stage.setHeight(300);
        stage.setScene(scene);
        return scene;

    }

    public static Scene Deleteemployee(Stage stage) {
        Group group = new Group();
        VBox vBox = new VBox(50);
        HBox hBox = new HBox(5);
        Label label = new Label("employee ID");
        label.setFont(Font.font(16));
        label.setPrefWidth(100);
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        TextField textField = new TextField();
        hBox.getChildren().addAll(label, textField);

        Button button = new Button("Delete");

        button.setLayoutX(220);
        button.setLayoutY(350);
        button.setFont(Font.font(16));
        button.setPrefSize(70, 35);

        button.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        button.setOnAction(actionEvent -> {
            try {
                int id = Integer.parseInt(textField.getText());
                try {
                    Queries.DeleteEmployee(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                AlertBox.display("Correct input");
            }
        });
        button.setCursor(Cursor.CLOSED_HAND);
        Button button1 = new Button("Back");
        button1.setLayoutX(200);
        button1.setLayoutY(300);
        button1.setFont(Font.font(16));
        button1.setPrefSize(70, 35);

        button1.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        button1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        button1.setCursor(Cursor.CLOSED_HAND);
        button1.setOnAction(e -> {
            stage.setScene(Main.Employee(stage));
        });
        HBox hBox1 = new HBox(5);

        hBox1.getChildren().addAll(button, button1);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(hBox, hBox1);
        group.getChildren().add(vBox);
        Scene scene = new Scene(group);
        stage.setY(200);
        stage.setX(500);
        stage.setWidth(300);
        stage.setHeight(300);
        stage.setScene(scene);
        return scene;

    }

    public static Scene Selectproduct(Stage stage) throws SQLException, ClassNotFoundException {
        TableView<Product> tableView = new TableView();
        TableColumn<Product, String> name = new TableColumn<>("productName");
        //name.cellFactoryValueProperty(new PropertyValueFactory<Product,String>("productName"));
        tableView.setItems(Queries.getProducts());
        TableColumn<Product, String> pname = new TableColumn<Product, String>("productName");
        pname.setCellValueFactory(new PropertyValueFactory("productName"));
        TableColumn<Product, String> size = new TableColumn<Product, String>("size");
        size.setCellValueFactory(new PropertyValueFactory("size"));
        TableColumn<Product, String> colour = new TableColumn<Product, String>("colour");
        colour.setCellValueFactory(new PropertyValueFactory("colour"));
        TableColumn<Product, String> quantity = new TableColumn<Product, String>("quantity");
        quantity.setCellValueFactory(new PropertyValueFactory("quantity"));
        TableColumn<Product, String> price = new TableColumn<Product, String>("price");
        price.setCellValueFactory(new PropertyValueFactory("price"));
        TableColumn<Product, String> id = new TableColumn<Product, String>("productID");
        id.setCellValueFactory(new PropertyValueFactory("productID"));
        tableView.getColumns().addAll(id, pname, size, colour, quantity, price);
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        Button button = new Button("Back");
        button.setOnAction(e -> {
            stage.setScene(Main.product(stage));
        });

        vBox.getChildren().addAll(tableView, button);

        return new Scene(vBox);
    }

    public static Scene Selectorder(Stage stage) {
        TableView<Order> tableView = new TableView();
        TableColumn<Order, String> name = new TableColumn<>("OrderID");
        try {
            tableView.setItems(Queries.getOrders());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TableColumn<Order, String> AddressID = new TableColumn<Order, String>("AddressID");
        AddressID.setCellValueFactory(new PropertyValueFactory("AddressID"));
        TableColumn<Order, String> PaymentID = new TableColumn<Order, String>("PaymentID");
        PaymentID.setCellValueFactory(new PropertyValueFactory("PaymentID"));
        TableColumn<Order, String> CustomerID = new TableColumn<Order, String>("CustomerID");
        CustomerID.setCellValueFactory(new PropertyValueFactory("CustomerID"));
        TableColumn<Order, String> amount = new TableColumn<Order, String>("amount");
        amount.setCellValueFactory(new PropertyValueFactory("amount"));
        TableColumn<Order, String> OrderDate = new TableColumn<Order, String>("OrderDate");
        OrderDate.setCellValueFactory(new PropertyValueFactory("OrderDate"));
        TableColumn<Order, String> OrderID = new TableColumn<Order, String>("OrderID");
        OrderID.setCellValueFactory(new PropertyValueFactory("OrderID"));
        tableView.getColumns().addAll(OrderID, AddressID, PaymentID, CustomerID, amount, OrderDate);

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        Button button = new Button("Back");
        button.setOnAction(e -> {
            stage.setScene(Main.Order(stage));
        });

        vBox.getChildren().addAll(tableView, button);

        return new Scene(vBox);
    }

    public static Scene Selectcustomer(Stage stage) {
        TableView<Customer> tableView = new TableView();
        TableColumn<Customer, String> name = new TableColumn<>("customerName");
        //name.cellFactoryValueProperty(new PropertyValueFactory<Product,String>("productName"));
        try {
            tableView.setItems(Queries.getCustomers());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TableColumn<Customer, String> FirstName = new TableColumn<Customer, String>("FirstName");
        FirstName.setCellValueFactory(new PropertyValueFactory("FirstName"));
        TableColumn<Customer, String> LastName = new TableColumn<Customer, String>("LastName");
        LastName.setCellValueFactory(new PropertyValueFactory("LastName"));
        TableColumn<Customer, String> BirthDate = new TableColumn<Customer, String>("BirthDate");
        BirthDate.setCellValueFactory(new PropertyValueFactory("BirthDate"));
        TableColumn<Customer, String> Email = new TableColumn<Customer, String>("Email");
        Email.setCellValueFactory(new PropertyValueFactory("Email"));
        TableColumn<Customer, String> password = new TableColumn<Customer, String>("password");
        password.setCellValueFactory(new PropertyValueFactory("password"));
        TableColumn<Customer, String> CustomerID = new TableColumn<Customer, String>("CustomerID");
        CustomerID.setCellValueFactory(new PropertyValueFactory("CustomerID"));
        tableView.getColumns().addAll(CustomerID, FirstName, LastName, BirthDate, Email, password);

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        Button button = new Button("Back");
        button.setOnAction(e -> {
            stage.setScene(Main.Customer(stage));
        });

        vBox.getChildren().addAll(tableView, button);

        return new Scene(vBox);
    }

    public static Scene Selectemployee(Stage stage) {
        TableView<Employee> tableView = new TableView();
        TableColumn<Employee, String> name = new TableColumn<>("employeeID");
        //name.cellFactoryValueProperty(new PropertyValueFactory<Product,String>("productName"));
        try {
            tableView.setItems(Queries.getEmployees());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TableColumn<Employee, String> userName = new TableColumn<Employee, String>("userName");
        userName.setCellValueFactory(new PropertyValueFactory("userName"));
        TableColumn<Employee, String> password = new TableColumn<Employee, String>("password");
        password.setCellValueFactory(new PropertyValueFactory("password"));
        TableColumn<Employee, String> employeeID = new TableColumn<Employee, String>("employeeID");
        employeeID.setCellValueFactory(new PropertyValueFactory("employeeID"));
        tableView.getColumns().addAll(employeeID, userName, password);
        Button back = new Button("Back");
        back.setOnAction(e -> stage.setScene(Main.Employee(stage)));
        VBox box = new VBox(15);
        box.getChildren().addAll(tableView, back);
        box.setPadding(new Insets(10));
        return new Scene(box);
    }

    public static Scene updatecustomer(Stage stage) {
        Group group = new Group();
        VBox vBox = new VBox(10);

        Label l = new Label("Insert Customer");
        l.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        l.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        l.setAlignment(Pos.CENTER);
        l.setPrefWidth(300);
        l.setPrefHeight(30);


        GridPane gridPane = new GridPane();
        Label label5 = new Label("ID Customer");
        Label label = new Label("First name");
        Label label1 = new Label("Last name");
        Label label2 = new Label("E-mail");
        Label label3 = new Label("Password");
        Label label4 = new Label("BirthDate");

        label5.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label5.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label5.setAlignment(Pos.CENTER);
        label5.setPrefWidth(150);
        label5.setPrefHeight(25);

        label.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label.setAlignment(Pos.CENTER);
        label.setPrefWidth(150);
        label.setPrefHeight(25);

        label1.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label1.setAlignment(Pos.CENTER);
        label1.setPrefWidth(150);
        label1.setPrefHeight(25);


        label2.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label2.setAlignment(Pos.CENTER);
        label2.setPrefWidth(150);
        label2.setPrefHeight(25);

        label3.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label3.setAlignment(Pos.CENTER);
        label3.setPrefWidth(150);
        label3.setPrefHeight(25);

        label4.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label4.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label4.setAlignment(Pos.CENTER);
        label4.setPrefWidth(150);
        label4.setPrefHeight(25);

        TextField textField5 = new TextField();
        TextField textField = new TextField();
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();

        textField.setDisable(true);
        textField1.setDisable(true);
        textField2.setDisable(true);
        textField3.setDisable(true);
        textField4.setDisable(true);


        gridPane.setVgap(15);
        gridPane.setHgap(5);

        gridPane.add(label5, 0, 0);
        gridPane.add(label, 0, 01);
        gridPane.add(label1, 0, 2);
        gridPane.add(label2, 0, 3);
        gridPane.add(label3, 0, 4);
        gridPane.add(label4, 0, 5);

        gridPane.add(textField5, 1, 0);
        gridPane.add(textField, 1, 1);
        gridPane.add(textField1, 1, 2);
        gridPane.add(textField2, 1, 3);
        gridPane.add(textField3, 1, 4);
        gridPane.add(textField4, 1, 5);

        HBox hBox = new HBox(5);
        Button button = new Button("Update");
        Button button1 = new Button("Find");
        Button button2 = new Button("Back");
        button.setOnAction(actionEvent -> {
            try {
                String fname = textField.getText();
                String lname = textField1.getText();
                String mail = textField2.getText();
                String password = textField3.getText();
                String date = textField4.getText();
                Customer customer = new Customer(fname, lname, Integer.parseInt(textField5.getText()), date, mail, password);
                try {
                    Queries.updateCustomerPassword(customer);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                AlertBox.display("Correct input");
            }
        });
        button2.setOnAction(e -> {
            stage.setScene(Main.Customer(stage));
        });
        button.setPrefSize(100, 20);
        button1.setPrefSize(100, 20);
        button2.setPrefSize(100, 20);
        button1.setOnAction(actionEvent -> {
            try {
                int id = Integer.parseInt(textField5.getText());
                try {
                    ObservableList<Customer> list = Queries.getCustomers();
                    boolean bool = false;
                    for (int i = 0; i < list.size(); i++) {
                        if (id == list.get(i).getCustomerID()) {
                            textField.setText(list.get(i).getFirstName());
                            textField1.setText(list.get(i).getLastName());
                            textField2.setText(list.get(i).getEmail());
                            textField3.setText(list.get(i).getPassword());
                            textField4.setText(list.get(i).getBirthDate().toString());
                            textField.setDisable(false);
                            textField1.setDisable(false);
                            textField2.setDisable(false);
                            textField3.setDisable(false);
                            textField4.setDisable(false);

                            bool = true;
                        }
                    }

                    if (!bool)
                        AlertBox.display("Customer not found");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                AlertBox.display("Input incorrect");
            }


        });
        hBox.getChildren().addAll(button, button1, button2);

        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(l, gridPane, hBox);

        group.getChildren().add(vBox);

        return new Scene(group);
    }

    public static Scene insertcustomer(Stage stage) {
        Group group = new Group();
        VBox vBox = new VBox(10);

        Label l = new Label("Insert Customer");
        l.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        l.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        l.setAlignment(Pos.CENTER);
        l.setPrefWidth(300);
        l.setPrefHeight(30);


        GridPane gridPane = new GridPane();
        //Label label5 = new Label("ID Customer");
        Label label = new Label("First name");
        Label label1 = new Label("Last name");
        Label label2 = new Label("E-mail");
        Label label3 = new Label("Password");
        Label label4 = new Label("BirthDate");


        label.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label.setAlignment(Pos.CENTER);
        label.setPrefWidth(150);
        label.setPrefHeight(25);

        label1.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label1.setAlignment(Pos.CENTER);
        label1.setPrefWidth(150);
        label1.setPrefHeight(25);


        label2.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label2.setAlignment(Pos.CENTER);
        label2.setPrefWidth(150);
        label2.setPrefHeight(25);

        label3.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label3.setAlignment(Pos.CENTER);
        label3.setPrefWidth(150);
        label3.setPrefHeight(25);

        label4.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label4.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label4.setAlignment(Pos.CENTER);
        label4.setPrefWidth(150);
        label4.setPrefHeight(25);

        TextField textField5 = new TextField();
        TextField textField = new TextField();
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();

        gridPane.setVgap(15);
        gridPane.setHgap(5);

        //gridPane.add(label5,0,0);
        gridPane.add(label, 0, 01);
        gridPane.add(label1, 0, 2);
        gridPane.add(label2, 0, 3);
        gridPane.add(label3, 0, 4);
        gridPane.add(label4, 0, 5);

        //gridPane.add(textField5,1,0);
        gridPane.add(textField, 1, 1);
        gridPane.add(textField1, 1, 2);
        gridPane.add(textField2, 1, 3);
        gridPane.add(textField3, 1, 4);
        gridPane.add(textField4, 1, 5);

        HBox hBox = new HBox(5);
        Button button = new Button("insert");
        Button button1 = new Button("Back");

        button.setPrefSize(150, 20);
        button1.setPrefSize(150, 20);
        button1.setOnAction(e -> stage.setScene(Main.Customer(stage)));
        button.setOnAction(actionEvent -> {
            try {
                String fname = textField.getText();
                String lname = textField1.getText();
                String mail = textField2.getText();
                String password = textField3.getText();
                String date = textField4.getText();
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
                        Customer customer = new Customer(fname, lname, date, mail, password);
                        Queries.insertCustomer(customer);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                AlertBox.display("Correct input");
            }

        });
        hBox.getChildren().addAll(button, button1);

        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(l, gridPane, hBox);

        group.getChildren().add(vBox);

        return new Scene(group);

    }

    public static Scene updateproduct(Stage stage) throws SQLException, ClassNotFoundException {
        Group group2 = new Group();
        GridPane Gridpane = new GridPane();
        HBox hbox = new HBox(10);
        HBox hbox1 = new HBox(10);
        Label Label1 = new Label("Type");
        Label Label2 = new Label("Size");
        Label Label3 = new Label("Color");
        Label Label4 = new Label("Quantity");
        Label Label5 = new Label("Price");
        TextField text = new TextField();
        TextField text1 = new TextField();
        Label1.setFont(Font.font(16));
        Label1.setPrefWidth(100);
        Label1.setAlignment(Pos.CENTER);
        Label1.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Label1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Label2.setFont(Font.font(16));
        Label2.setPrefWidth(100);
        Label2.setAlignment(Pos.CENTER);
        Label2.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Label2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        Label3.setFont(Font.font(16));
        Label3.setPrefWidth(100);
        Label3.setAlignment(Pos.CENTER);
        Label3.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Label3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        Label4.setFont(Font.font(16));
        Label4.setPrefWidth(100);
        Label4.setAlignment(Pos.CENTER);
        Label4.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Label4.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        Label5.setFont(Font.font(16));
        Label5.setPrefWidth(100);
        Label5.setAlignment(Pos.CENTER);
        Label5.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Label5.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        ComboBox<String> combobox = new ComboBox<>();
        combobox.setValue("Choose type");


        RadioButton radio = new RadioButton("M");
        RadioButton radio1 = new RadioButton("L");
        RadioButton radio2 = new RadioButton("XL");

        hbox.getChildren().addAll(radio, radio1, radio2);

        RadioButton radio3 = new RadioButton("Black");
        RadioButton radio4 = new RadioButton("White");
        RadioButton radio5 = new RadioButton("Blue");
        RadioButton radio6 = new RadioButton("Green");


        RadioButton radio7 = new RadioButton("38");
        RadioButton radio8 = new RadioButton("39");
        RadioButton radio9 = new RadioButton("40");
        RadioButton radio10 = new RadioButton("41");
        RadioButton radio11 = new RadioButton("42");

        HBox hBox = new HBox(2);
        hBox.getChildren().addAll(radio7, radio8, radio9, radio10, radio11);

        combobox.setOnAction(e -> {
            if (combobox.getValue().equals("Boot") || combobox.getValue().equals("trouser")) {
                hBox.setDisable(false);
                hbox.setDisable(true);
            } else if (combobox.getValue().equals("Wristwatch") || combobox.getValue().equals("Hat")) {
                hbox.setDisable(true);
                hBox.setDisable(true);
            } else {
                hBox.setDisable(true);
                hbox.setDisable(false);
            }
        });

        hbox1.getChildren().addAll(radio3, radio4, radio5, radio6);
        Gridpane.setPadding(new Insets(10, 0, 0, 10));
        Gridpane.add(Label1, 0, 0);
        Gridpane.add(Label2, 0, 1);
        Gridpane.add(Label3, 0, 3);
        Gridpane.add(Label4, 0, 4);
        Gridpane.add(Label5, 0, 5);
        Gridpane.add(hBox, 1, 2);
        Gridpane.add(combobox, 1, 0);
        Gridpane.add(hbox, 1, 1);
        Gridpane.add(hbox1, 1, 3);
        Gridpane.add(text, 1, 4);
        Gridpane.add(text1, 1, 5);


        Gridpane.setHgap(20);
        Gridpane.setVgap(30);

        Button Button6 = new Button("Back");
        Button6.setLayoutX(80);
        Button6.setLayoutY(350);
        Button6.setFont(Font.font(16));
        Button6.setPrefSize(70, 35);

        Button6.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button6.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Button6.setCursor(Cursor.CLOSED_HAND);
        Button6.setOnAction(e -> {
            stage.setScene(Main.product(stage));
        });
        Button Button7 = new Button("update");
        Button7.setLayoutX(220);
        Button7.setLayoutY(350);
        Button7.setFont(Font.font(16));
        Button7.setPrefSize(70, 35);

        Button7.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button7.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Button7.setCursor(Cursor.CLOSED_HAND);
        Button7.setOnAction(actionEvent -> {
            try {
                String size = "";
                String colour = "";
                int quantity = Integer.parseInt(text.getText());
                float price = Float.parseFloat(text1.getText());
                if (radio.isSelected())
                    size += radio.getText() + ",";
                if (radio1.isSelected())
                    size += radio1.getText() + ",";
                if (radio2.isSelected())
                    size += radio2.getText() + ",";
                if (radio3.isSelected())
                    colour += radio3.getText() + ",";
                if (radio4.isSelected())
                    colour += radio4.getText() + ",";
                if (radio5.isSelected())
                    colour += radio5.getText() + ",";
                if (radio6.isSelected())
                    colour += radio6.getText() + ",";
                if (radio7.isSelected())
                    size += radio7.getText() + ",";
                if (radio8.isSelected())
                    size += radio8.getText() + ",";
                if (radio9.isSelected())
                    size += radio9.getText() + ",";
                if (radio10.isSelected())
                    size += radio10.getText() + ",";
                if (radio11.isSelected())
                    size += radio11.getText() + ",";
                String name = combobox.getValue();
                try {
                    Queries.updateProductQuantity(name, quantity, size, colour, price);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                AlertBox.display("Correct input");
            }
        });

        ObservableList<Product> list = Queries.getProducts();
        for (int i = 0; i < Queries.getProducts().size(); i++) {
            if ("Tshirt".equals(list.get(i).getProductName())) {
                combobox.getItems().add("Tshirt");
            } else if ("Hat".equals(list.get(i).getProductName())) {
                combobox.getItems().add("Hat");
            } else if ("shirt".equals(list.get(i).getProductName())) {
                combobox.getItems().add("shirt");
            } else if ("trouser".equals(list.get(i).getProductName())) {
                combobox.getItems().add("trouser");
            } else if ("wristwatch".equals(list.get(i).getProductName())) {
                combobox.getItems().add("Wristwatch");
            } else if ("boot".equals(list.get(i).getProductName())) {
                combobox.getItems().add("Boot");
            }
        }
        group2.getChildren().addAll(Gridpane, Button6, Button7);

        Scene scene = new Scene(group2);
        stage.setY(250);
        stage.setX(500);
        stage.setWidth(400);
        stage.setHeight(450);
        stage.setScene(scene);
        return scene;


    }

    public static Scene SelectOrderWithProductDescription(Stage stage) {
        TableView<orderproduct> tableView = new TableView();
        TableColumn<orderproduct, String> name = new TableColumn<>("oid");
        //name.cellFactoryValueProperty(new PropertyValueFactory<Product,String>("productName"));
        try {
            tableView.setItems(Queries.getCart());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TableColumn<orderproduct, String> oid = new TableColumn<orderproduct, String>("oid");
        oid.setCellValueFactory(new PropertyValueFactory("oid"));
        TableColumn<orderproduct, String> pid = new TableColumn<orderproduct, String>("pid");
        pid.setCellValueFactory(new PropertyValueFactory("pid"));
        TableColumn<orderproduct, String> name1 = new TableColumn<orderproduct, String>("pdescription");
        name1.setCellValueFactory(new PropertyValueFactory("pdescription"));
        TableColumn<orderproduct, String> price = new TableColumn<orderproduct, String>("price");
        price.setCellValueFactory(new PropertyValueFactory("price"));
        //tableView.getColumns().addAll(price, pid, name1);

        tableView.getColumns().addAll(oid, pid, name1, price);


        Button back = new Button("Back");
        back.setOnAction(e -> stage.setScene(Main.Order(stage)));
        VBox box = new VBox(15);
        box.getChildren().addAll(tableView, back);
        box.setPadding(new Insets(10));
        return new Scene(box);
    }

}

