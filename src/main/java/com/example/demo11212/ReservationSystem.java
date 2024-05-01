package com.example.demo11212;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class ReservationSystem extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();


        // StackPane to hold the rectangle and other content

        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setPadding(new Insets(11.5));
        gridPane.setVgap(5.4);
        gridPane.setHgap(5.3);
        gridPane.add(new Label("Enter Your Email:"),0,0);
        TextField email =new TextField();
        gridPane.add(email,0,1);
        gridPane.add(new Label("Enter your category if first time:"),0,2);
        TextField category =new TextField();
        gridPane.add(category,0,3);
        Button button = new Button("Login");
        button.setMaxWidth(Double.MAX_VALUE);
        gridPane.add(button,0,4,3,3);
        button.setOnAction(e -> {
            if (category.getText().equals("Admin")) {
                Button viewAllReservations = new Button("View reservations");
                gridPane.add(viewAllReservations, 0, 7);


            }
            else{
                Button viewRooms =new Button("View rooms");
                gridPane.add(viewRooms, 0, 7);
                Button viewEvents =new Button("View events");
                gridPane.add(viewEvents, 0, 8);
                Button viewMyRes =new Button("View my reservation");
                gridPane.add(viewMyRes, 0, 9);



            }

        });


        Scene scene = new Scene(gridPane,600,600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Reservation System");
        Image icon =new Image("C:\\Users\\mribr\\IdeaProjects\\demo11212\\src\\main\\java\\com\\example\\demo11212\\icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setOnCloseRequest(event -> {
            if (!confirmExit()) {
                event.consume(); // Prevent the window from closing
                primaryStage.show();
            }
        });
//        primaryStage.setFullScreen(true);
        BackgroundFill backgroundFill = new BackgroundFill(Color.gray(0.75), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        Background background = new Background(backgroundFill);
        setBackground(background);

        primaryStage.show();
    }

    private void setBackground(Background background) {
    }

    private boolean confirmExit() {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Are you sure you want to exit?");
        confirmationAlert.setContentText("Click OK to exit or Cancel to continue using the application.");

        return confirmationAlert.showAndWait().filter(response -> response == ButtonType.OK).isPresent();
    }

}
