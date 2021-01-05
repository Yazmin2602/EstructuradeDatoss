package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
public static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage= primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("BIENVENIDO A BOUTIQUE -FASHION LINE-");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.getIcons().add(new Image("./sample/img/bolso.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
