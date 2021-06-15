package sample.Login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Main;
import sample.Models.Conexion;
import sample.Ventas.Ventas;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Login {
    @FXML private JFXTextField txtusers;
    @FXML Label lbltitulo;
    @FXML private JFXTextField txtpassword;
    @FXML private JFXButton btningresar;

    public static LinkedList<Ventas> users = new LinkedList<>();

    private Conexion conexion;
    Alert alert;

    @FXML void initialize(){

        conexion = new Conexion();

    } // initalize

    public void ingresarAction() throws IOException, SQLException {

        ResultSet resultSet = conexion.consultar("SELECT * FROM users WHERE Name = '" + txtusers.getText() + "' AND Password = '" + txtpassword.getText() + "'");

        if (resultSet != null) {
            int cont = 0;
            while (resultSet.next()) {
                cont++;
                Parent root = FXMLLoader.load(getClass().getResource("../Ventas/Ventas.fxml"));
                Main.stage.setScene(new Scene(root));
                break;
            }// while

            if (cont == 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Welcome " + txtusers.getText());
                alert.setTitle("Welcome");
                alert.show();
            }//if
            else {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Welcome " + txtusers.getText());
                alert.setTitle("Welcome");
                alert.show();
            }//else

        }// else


    }
}