package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Estructura.Pedido;
import sample.Estructura.Pedidos;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ControllerCobrar {
    @FXML ComboBox comboJeans, comboSueter;
    @FXML TableView tabla;
    @FXML TextField txtCantJeans,txtCantSueter,txtCliente;
    LinkedList<String> listaJeans=new LinkedList<>();
    LinkedList<String> listaSueter=new LinkedList<>();
    TableColumn columnJeans=new TableColumn("JEANS");
    TableColumn columnCantidadJeans=new TableColumn("CANTIDAD");
    TableColumn columnSueter=new TableColumn("SUETER");
    TableColumn columnCantidadSueter=new TableColumn("CANTIDAD");
    TableColumn columnTotal=new TableColumn("TOTAL");
    ObservableList<Pedidos> listaPedidos= FXCollections.observableArrayList();
    Queue<Pedido> cola= new LinkedList<>();
    @FXML protected void initialize(){
        columnJeans.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("Jeans"));
        columnCantidadJeans.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("CantJeans"));
        columnSueter.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("Sueter"));
        columnCantidadSueter.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("CantSueter"));
        columnTotal.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("total"));
        tabla.getColumns().addAll(columnJeans,columnCantidadJeans,columnSueter,columnCantidadSueter,columnTotal);
        tabla.setItems(listaPedidos);
        listaJeans.add("Jeans Negro");
        listaJeans.add("Jeans Roto");
        listaJeans.add("Jeans Roto Rodillas");
        listaJeans.add("Jeans Blanco");
        listaSueter.add("Sueter Amarillo");
        listaSueter.add("Sueter Cafe");
        listaSueter.add("Sueter Rosa");
        listaSueter.add("Sueter Verde");

        for(int x=0;x<listaSueter.size();x++) comboSueter.getItems().add(listaSueter.get(x));
        for(int x=0;x<listaJeans.size();x++) comboJeans.getItems().add(listaJeans.get(x));
        //comboJeans.getItems().add()
    }
public void meterPedido(ActionEvent event){
        String j=comboJeans.getSelectionModel().getSelectedItem().toString();
        String s=comboSueter.getSelectionModel().getSelectedItem().toString();
        String cantj= txtCantJeans.getText();
        String cantS=txtCantSueter.getText();
        int cJ=Integer.parseInt(cantj);
        int cS=Integer.parseInt(cantS);
        int subTJ=cJ*500;
        String TJ=Integer.toString(subTJ);
        int subTS=cS*300;
        String TS=Integer.toString(subTS);
        String total=Integer.toString(subTJ+subTS);
    listaPedidos.add(new Pedidos(j,s,cantj,cantS,TJ,TS,total));
}
public void GuardarPedido(ActionEvent event){
        String[][] items=new String[listaPedidos.size()][4];
        for(int x=0;x<items.length;x++){
            items[x][0]=listaPedidos.get(x).getJeans();
            items[x][1]=listaPedidos.get(x).getCantJeans();
            items[x][2]=listaPedidos.get(x).getSueter();
            items[x][3]=listaPedidos.get(x).getCantSueter();
        }
        Pedido pedid=new Pedido(items,txtCliente.getText());
        cola.add(pedid);
        listaPedidos.clear();
        txtCliente.setText("");


        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("BOUTIQUE");
        alert.setContentText("Pedido finalizado, gracias por su compra, vuelva pronto!! ");
        alert.show();
    }
    public void Ventas(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PantallaVentas.fxml"));
            Scene scene=new Scene(root);
            Main.stage.setScene(scene);
            Main.stage.setMaximized(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
