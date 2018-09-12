package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("application.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 1000, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        root.requestFocus();
        Random random = new Random();
        for(int i = 0; i < 20; i++){
            System.out.println(random.nextInt(4));
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
