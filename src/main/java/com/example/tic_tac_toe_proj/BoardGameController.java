package com.example.tic_tac_toe_proj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class BoardGameController {

    private boolean isRedSelected = false;
    private boolean isBlueSelected = false;

    private String name1;
    private String name2;

    boolean isSelected = false;
    Color temp;

    @FXML
    private GridPane base_grid;

    @FXML
    private Circle circle_blue2;

    @FXML
    private Circle circle_blue4;

    @FXML
    private Circle circle_blue6;

    @FXML
    private Circle circle_blue7;

    @FXML
    private Circle circle_red1;

    @FXML
    private Circle circle_red2;

    @FXML
    private Circle circle_red3;

    @FXML
    private Circle circle_red4;

    @FXML
    private Button button_play;

    @FXML
    private Button test;

    @FXML
    private TextField first_player_text;

    @FXML
    private Text first_player_title;

    @FXML
    private TextField second_player_text;

    @FXML
    private Text second_player_title;

    @FXML
    private Text title;

    @FXML
    //kezdő beállás
    private void initialize() {
        int guard = 0;
        for (var i = 0; i < base_grid.getRowCount(); i++) {
            for (var j = 0; j < base_grid.getColumnCount(); j++) {
                var square = createSquare();

                base_grid.add(square, j, i);

                if (i == 0) {
                    var circles = createCircles();
                    square.getChildren().add(circles);
                    //square.setOnMouseClicked(this::handleMouseClick);
                    guard++;
                    if (guard % 2 == 0) {
                        circles.setFill(Color.BLUE);
                    }
                    else {
                        circles.setFill(Color.RED);
                    }
                }
                if (i == 4) {
                    var circles = createCircles();
                    square.getChildren().add(circles);
                    //square.setOnMouseClicked(this::handleMouseClick);
                    guard++;
                    if (guard % 2 != 0) {
                        circles.setFill(Color.BLUE);
                    }
                    else {
                        circles.setFill(Color.RED);
                    }
                }
            }
        }
    }


    @FXML
    //Circle kijelölés
    private void handleMouseClick (MouseEvent event){


        var square = (StackPane) event.getSource();
        var row = GridPane.getRowIndex(square);
        var col = GridPane.getColumnIndex(square);
        System.out.printf("Click on square (%d,%d)%n", row, col);
        System.out.println("KATTINTÁS!!!!!!!!!!!!");
        var piece = (Circle) square.getChildren().get(0);
        System.out.println("GET NULLLAAA!!!!!!!!!!!!");
        if (piece.getFill() == Color.RED || piece.getFill() == Color.BLUE )
        temp = (Color) piece.getFill();

        if (isSelected == false) {
        piece.setFill(Color.GREEN);
            System.out.println("isSelected = true");
        isSelected = true;
        }
        else{
        piece.setFill(temp);
            System.out.println("isSelected = false");
        isSelected = false;
        }
    }


    //négyzetek hozzáadása a gridhez
    private StackPane createSquare (){
        var square = new StackPane();

        square.setOnMouseClicked(this::handleMouseClick);
        return square;


    }

    //körök hozzáadása a gridhez
    private Circle createCircles()
    {
        var circle_piece = new Circle(45);

        return circle_piece;
    }

    //Scene váltás
    public void handleButton1() throws Exception{
        isNameMissing();


        Parent root = FXMLLoader.load(getClass().getResource("/my_ui.fxml"));
       Stage window = (Stage) button_play.getScene().getWindow();
       window.setScene(new Scene(root));

    }

    public void circlesPosition(){

        ArrayList<ArrayList<Integer>> player1 = new ArrayList<ArrayList<Integer>>();
        player1.add(new ArrayList<Integer>(Arrays.asList(GridPane.getRowIndex(circle_red1),GridPane.getColumnIndex(circle_red1))));
        player1.add(new ArrayList<Integer>(Arrays.asList(GridPane.getRowIndex(circle_red2),GridPane.getColumnIndex(circle_red2))));
        player1.add(new ArrayList<Integer>(Arrays.asList(GridPane.getRowIndex(circle_red3), GridPane.getColumnIndex(circle_red3))));
        player1.add(new ArrayList<Integer>(Arrays.asList(GridPane.getRowIndex(circle_red4), GridPane.getColumnIndex(circle_red4))));


        for (int i = 0; i < player1.size(); i++) {
           if (player1.get(i).get(0) == null){
                player1.get(i).set(0,0);
            }
            if (player1.get(i).get(1) == null){
                player1.get(i).set(1,0);
            }
        }

        ArrayList<ArrayList<Integer>> player2 = new ArrayList<ArrayList<Integer>>();
        player2.add(new ArrayList<Integer>(Arrays.asList(GridPane.getRowIndex(circle_blue2), GridPane.getColumnIndex(circle_blue2))));
        player2.add(new ArrayList<Integer>(Arrays.asList(GridPane.getRowIndex(circle_blue4), GridPane.getColumnIndex(circle_blue4))));
        player2.add(new ArrayList<Integer>(Arrays.asList(GridPane.getRowIndex(circle_blue6), GridPane.getColumnIndex(circle_blue6))));
        player2.add(new ArrayList<Integer>(Arrays.asList(GridPane.getRowIndex(circle_blue7), GridPane.getColumnIndex(circle_blue7))));

        for (int i = 0; i < player2.size(); i++) {
            if (player2.get(i).get(0) == null){
                player2.get(i).set(0,0);
            }
            if (player2.get(i).get(1) == null){
                player2.get(i).set(1,0);
            }
        }

       System.out.println("Player1 ------:" +player1);
       System.out.println("Player2 ------:" +player2);
    }

    //Név megadási error kezelés
    private String isNameMissing(){

        try {
            name1 = first_player_text.getText();
            name2 = second_player_text.getText();

            if (name1 != "" || name2 != ""){
                System.out.println("Nevek megadva");

            }
            else {
                throw  new Exception();

            }

        }catch (Exception e){
            System.out.println("Nincs név megadva");
        }
        return "";

    }


}
