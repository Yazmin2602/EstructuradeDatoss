package sample.Ventas;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.Fila.Fila;
import sample.Models.Conexion;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class Ventas {
    @FXML private JFXTextField txtname;
    @FXML private JFXTextField txtdescripcion;
    @FXML private JFXTextField txtprice;
    @FXML private JFXTextField txtamount;
    @FXML private Button btnAñadir;

    Conexion conexion;

    TableColumn colId=new TableColumn("id");
    TableColumn colname=new TableColumn("Name");
    TableColumn coldescripcion=new TableColumn("Description");
    TableColumn colprice=new TableColumn("Price");
    TableColumn colAmount=new TableColumn("Amount");
    TableColumn coltotal=new TableColumn("Total");
    TableColumn colEliminar=new TableColumn("  ");
    TableColumn colEditar=new TableColumn("  ");
    Fila filaEditar;
    @FXML TableView Abarrotes;
    ObservableList<Fila> datosTabla= FXCollections.observableArrayList();
    Callback<TableColumn<Fila,String>, TableCell<Fila,String>> celdaEliminar=new Callback<TableColumn<Fila, String>, TableCell<Fila, String>>() {
        @Override
        public TableCell<Fila, String> call(TableColumn<Fila, String> filaStringTableColumn) {
            TableCell<Fila, String> cell = new TableCell<Fila, String>() {
                Button btnEliminar = new Button("Eliminar");

                @Override
                protected void updateItem(String item, boolean empty) {
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btnEliminar.getStyleClass().add("btnEliminar");
                        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Eliminar Registro");
                                alert.setContentText("¿Desea eliminar el registro?");
                                Optional<ButtonType> resultado = alert.showAndWait();
                                if (resultado.get() == ButtonType.OK) {
                                    Fila fila = getTableView().getItems().get(getIndex());
                                    conexion.insmodel("delete from products where id= " + fila.getId());
                                    try {
                                        recargar();
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });

                        setGraphic(btnEliminar);
                        setText(null);
                    }
                }
            };
            return cell;
        }
    };
    Callback<TableColumn<Fila,String>, TableCell<Fila,String>> celdaEditar=new Callback<TableColumn<Fila, String>, TableCell<Fila, String>>() {
        @Override
        public TableCell<Fila, String> call(TableColumn<Fila, String> filaStringTableColumn) {
            TableCell<Fila,String> cell = new TableCell<Fila,String>(){
                Button btnEditar=new Button("Editar");
                @Override
                protected void updateItem(String item, boolean empty) {
                    if(empty){
                        setGraphic(null);
                        setText(null);
                    }else{
                        btnEditar.getStyleClass().add("btnEditar");
                        btnEditar.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                filaEditar=getTableView().getItems().get(getIndex());
                                txtname.setText((filaEditar.getName()));
                                txtdescripcion.setText((filaEditar.getDescription()));
                                txtprice.setText((filaEditar.getPrice()));
                                txtamount.setText((filaEditar.getAmount()));
                                btnAñadir.setText("ACTUALIZAR");
                            }
                        });
                        setGraphic(btnEditar);
                        setText(null);
                    }
                }
            };
            return cell;
        }
    };
        @FXML
        void initialize() throws SQLException {
            conexion = new Conexion();


            colId.setCellValueFactory(new PropertyValueFactory<Fila, String>("id"));
            colname.setCellValueFactory(new PropertyValueFactory<Fila, String>("Name"));
            coldescripcion.setCellValueFactory(new PropertyValueFactory<Fila, String>("Description"));
            colprice.setCellValueFactory(new PropertyValueFactory<Fila, String>("Price"));
            colAmount.setCellValueFactory(new PropertyValueFactory<Fila, String>("Amount"));
            coltotal.setCellValueFactory(new PropertyValueFactory<Fila, String>("Total"));
            colEliminar.setCellFactory(celdaEliminar);
            colEditar.setCellFactory(celdaEditar);
            Abarrotes.getColumns().addAll(colId, colname, coldescripcion, colprice, colAmount, coltotal,colEditar,colEliminar);
            recargar();
            Abarrotes.setItems(datosTabla);

        }

        public void recargar() throws SQLException {
            ResultSet res = conexion.consultar("SELECT * FROM `products` order by id DESC ");
            datosTabla.clear();
            if (res != null) {
                while (res.next()) {
                    datosTabla.addAll(new Fila(res.getObject("id").toString(),
                            res.getObject("Name").toString(),
                            res.getObject("Description").toString(),
                            res.getObject("Price").toString(),
                            res.getObject("Amount").toString(),
                            res.getObject("Total").toString()));
                }
            }
        }

        public void añadir() throws SQLException {
            if(btnAñadir.getText().equals("ACTUALIZAR")){
                String name= txtname.getText();
                String desc=txtdescripcion.getText();
                Double price=Double.parseDouble(txtprice.getText());
                String amou=txtamount.getText();
                conexion.insmodel( "UPDATE `products` SET `Name`='"+name+"',`Description`='"+desc+"',`Price`="+price+",`Amount`="+amou+" WHERE id="+filaEditar.getId());

                btnAñadir.setText("INSERTAR");
                txtname.setText(""); txtdescripcion.setText("");  txtprice.setText("");  txtamount.setText("");
                recargar();
            }else{
                if (!txtname.getText().trim().equals("") && !txtdescripcion.getText().trim().equals("") && !txtprice.getText().trim().equals("") && !txtamount.getText().trim().equals("")) {
                    String nombre = txtname.getText();
                    String descripcion = txtdescripcion.getText();
                    Double precio = Double.parseDouble(txtprice.getText());
                    Double cantidad = Double.parseDouble(txtamount.getText());
                    Double total = precio * cantidad;

                    conexion.insmodel("INSERT INTO `products`(`Name`, `Description`, `Price`, `Amount`, `Total`) VALUES ('" + nombre + "','" + descripcion + "'," + precio + "," + cantidad + "," + total + ")");
                    System.out.println("INSERT INTO products(Name,Description,Price,Amount,Total) VALUES ('" + nombre + "','" + descripcion + "'," + precio + "," + cantidad + "," + total + ")");
                    txtname.setText("");
                    txtdescripcion.setText("");
                    txtprice.setText("");
                    txtamount.setText("");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Alerta");
                    alert.setContentText("Registro insertado correctamente");
                    alert.show();
                    recargar();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Favor de llenar todos los campos");
                    alert.show();
                }
            }

        }

    }


