package sample;

import Pez.Pez;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML ComboBox combTipo_pez;
    @FXML TextField txtCantidad;
    @FXML ListView lisRes;
    String [][] arreglo1= new String[5][2];

    public void CombTipo_pez() {
        combTipo_pez.getItems().clear();
        combTipo_pez.getItems().addAll("Trucha","Carpa");
    }
int cont1=0;
    public void insertar(ActionEvent event){
        String pezz=txtCantidad.getText();
        String tipoo=combTipo_pez.getSelectionModel().getSelectedItem().toString();
arreglo1[cont1][1]=pezz;
        arreglo1[cont1][0]=tipoo;
        txtCantidad.setText("");
        System.out.println("["+arreglo1[cont1][0]+","+arreglo1[cont1][1]+"]");
        cont1++;
    }
int cont=0;
    public void procesar(ActionEvent event){
int cant=Integer.parseInt(arreglo1[cont][1]);
String tipo=arreglo1[cont][0];
cont++;
Pez pecesanio=new Pez(tipo,cant);
int anio=pecesanio.nacimientos_año();
lisRes.getItems().add(" Pescao " +tipo+ " nacen " +cant+ " por cria "+" y por año " +anio);
    }
}
