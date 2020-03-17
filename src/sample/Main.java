package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Optional;


public class Main extends Application {

    private Cell[][] board = new Cell[3][3];
    private GridPane gridPane = new GridPane();
    private BorderPane borderPane = new BorderPane();
    private Button infoButton = new Button("Info");
    private Button startButton = new Button("Start");
    private Button stopButton = new Button("Exit");

    @Override
    public void start(Stage primaryStage) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridPane.add(board[i][j] = new Cell(), i, j);
            }
        }
        startButton.setPrefSize(70, 50);
        startButton.setOnAction(e -> {
            System.out.println("Start");

        });

        infoButton.setOnAction(event -> {
            Dialog<ButtonType> dialog = new Dialog<>();
            ButtonType okButton = ButtonType.OK;
            dialog.getDialogPane().getButtonTypes().add(okButton);
            dialog.setTitle("Info");
            dialog.setContentText("The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner. When all 9 squares are full, the game is over.");
            dialog.getDialogPane().setPrefHeight(200);
            dialog.getDialogPane().setPrefWidth(200);
            Platform.runLater(()->{
                Optional<ButtonType> response = dialog.showAndWait();
                response.ifPresent(System.out::println);
            });
        });

        Tooltip tooltip = new Tooltip("The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner. When all 9 squares are full, the game is over.");
        infoButton.setPrefSize(70, 50);
        infoButton.setTooltip(tooltip);


        stopButton.setPrefSize(70, 50);
        stopButton.setOnAction(e -> {
                    System.out.println("Exit");
                    Platform.exit();
        });
        ToolBar toolBar = new ToolBar();
        toolBar.getItems().addAll(startButton,infoButton, stopButton);
        BorderPane.setAlignment(gridPane, Pos.CENTER);
        BorderPane.setMargin(gridPane, new Insets(50,50,50,50));
        borderPane.setCenter(gridPane);

        borderPane.setTop(toolBar);

        //BorderPane.setAlignment(startButton,Pos.CENTER);
        //borderPane.setTop(startButton);
        //BorderPane.setAlignment(stopButton,Pos.BOTTOM_CENTER);
        //borderPane.setBottom(stopButton);

        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();



    }


    public class Cell extends Pane {
        public Cell() {
            setStyle("-fx-border-color: black");
            setPrefSize(100, 100);
           // setOnMouseClicked(e -> mouseClicked());
        }
    }




        public static void main(String[] args) {
            launch(args);
        }
    }

