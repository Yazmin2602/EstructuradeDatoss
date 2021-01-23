package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Estructura.Pedidos;

public class ControllerVentas {
    @FXML TableView tabla2;
    TableColumn columna=new TableColumn("JEANS y SUETER");
    String cantidad;
    int siguiente;
     ObservableList<Ventas2020> CantidadVentas= FXCollections.observableArrayList();
     @FXML ComboBox combo1,combo2;
    @FXML protected void initialize(){
        columna.setCellValueFactory(new PropertyValueFactory<Ventas2020,String>("Cantidad"));
        tabla2.getColumns().addAll(columna);
        CantidadVentas.add(new Ventas2020("5"));
        CantidadVentas.add(new Ventas2020("7"));
        CantidadVentas.add(new Ventas2020("23"));
        CantidadVentas.add(new Ventas2020("8"));
        CantidadVentas.add(new Ventas2020("14"));
        CantidadVentas.add(new Ventas2020("26"));
        CantidadVentas.add(new Ventas2020("2"));
        tabla2.setItems(CantidadVentas);
        combo1.getItems().add("5");
        combo1.getItems().add("7");
        combo1.getItems().add("23");
        combo1.getItems().add("8");
        combo1.getItems().add("14");
        combo1.getItems().add("26");
        combo1.getItems().add("2");
        combo2.getItems().add("5");
        combo2.getItems().add("7");
        combo2.getItems().add("23");
        combo2.getItems().add("8");
        combo2.getItems().add("14");
        combo2.getItems().add("26");
        combo2.getItems().add("2");
    }
    public void burbuja(ActionEvent event){
        for (int x=0;x<CantidadVentas.size()-1;x++){
            for (int j=0;j<CantidadVentas.size()-1;j++){
                siguiente=j+1;
                if(Integer.parseInt(CantidadVentas.get(j).getCantidad())>Integer.parseInt(CantidadVentas.get(siguiente).getCantidad())){
                    cantidad=CantidadVentas.get(j).getCantidad();
                    CantidadVentas.get(j).setCantidad(CantidadVentas.get(siguiente).getCantidad());
                    CantidadVentas.get(siguiente).setCantidad(cantidad);
                }
            }
        }
        tabla2.refresh();
    }
    public void insercion(ActionEvent event){
        int posicion;
        String cantidad;
        for(int y=0;y<7;y++){
            posicion=y;
            cantidad=CantidadVentas.get(y).getCantidad();
            while((posicion>0) && Integer.parseInt(CantidadVentas.get(posicion-1).getCantidad())>Integer.parseInt(cantidad)){
                CantidadVentas.get(posicion).setCantidad(CantidadVentas.get(posicion-1).getCantidad());
                posicion--;
            }
            CantidadVentas.get(posicion).setCantidad(cantidad);
        }
        tabla2.refresh();
    }
    public void buscarS(ActionEvent event){
        String num;
        num=combo1.getSelectionModel().getSelectedItem().toString();
        for (int x=0;x<CantidadVentas.size();x++){
            if (num==CantidadVentas.get(x).getCantidad()){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                String r=Integer.toString(x);
                alert.setContentText("Se encuentra en la posicion"+" "+r);
                alert.show();
                x=8;
            }
        }
     }
     public void buscar2(ActionEvent event){
        int inicio=1;
        int fin=CantidadVentas.size();
        String num=combo2.getSelectionModel().getSelectedItem().toString();
        int numbuscar=Integer.parseInt(num);
        int posicion=0;
        int resultado=0;
        while(inicio<=fin){
            posicion=(inicio+fin)/2;
            if(Integer.parseInt(CantidadVentas.get(posicion).getCantidad())==numbuscar){
                resultado=posicion;
                break;
            }
            else if(Integer.parseInt(CantidadVentas.get(posicion).getCantidad())<numbuscar){
                inicio=posicion+1;
            }
            else{
                fin=posicion-1;
            }
        }
        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        String r=Integer.toString(resultado);
        alert1.setContentText("Se encuentra en la posicion"+" "+r);
        alert1.show();
     }
}
