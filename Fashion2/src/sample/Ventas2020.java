package sample;

import javafx.beans.property.SimpleStringProperty;

public class Ventas2020 {
    SimpleStringProperty Cantidad;

    public Ventas2020(String Cantidad) {
        this.Cantidad=new SimpleStringProperty(Cantidad);
    }

    public String getCantidad() {
        return Cantidad.get();
    }

    public SimpleStringProperty cantidadProperty() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        this.Cantidad.set(cantidad);
    }
}
