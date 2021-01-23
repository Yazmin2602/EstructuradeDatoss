package sample.Estructura;

import javafx.beans.property.SimpleStringProperty;

public class Pedidos {
    SimpleStringProperty Jeans;
    SimpleStringProperty Sueter;
    SimpleStringProperty CantJeans;
    SimpleStringProperty CantSueter;
    SimpleStringProperty precioJ;
    SimpleStringProperty precioS;
    SimpleStringProperty total;



    public Pedidos (String Jeans, String Sueter, String CantJeans, String CantSueter, String precioJ, String precioS, String total){
        this.Jeans= new SimpleStringProperty(Jeans);
        this.Sueter=new SimpleStringProperty(Sueter);
        this.CantJeans= new SimpleStringProperty(CantJeans);
        this.CantSueter=new SimpleStringProperty(CantSueter);
        this.precioJ=new SimpleStringProperty(precioJ);
        this.precioJ=new SimpleStringProperty(precioS);
        this.total=new SimpleStringProperty(total);
       
    }

    public String getJeans() {
        return Jeans.get();
    }

    public SimpleStringProperty jeansProperty() {
        return Jeans;
    }

    public void setJeans(String jeans) {
        this.Jeans.set(jeans);
    }

    public String getSueter() {
        return Sueter.get();
    }

    public SimpleStringProperty sueterProperty() {
        return Sueter;
    }

    public void setSueter(String sueter) {
        this.Sueter.set(sueter);
    }

    public String getCantJeans() {
        return CantJeans.get();
    }

    public SimpleStringProperty cantJeansProperty() {
        return CantJeans;
    }

    public void setCantJeans(String cantJeans) {
        this.CantJeans.set(cantJeans);
    }

    public String getCantSueter() {
        return CantSueter.get();
    }

    public SimpleStringProperty cantSueterProperty() {
        return CantSueter;
    }

    public void setCantSueter(String cantSueter) {
        this.CantSueter.set(cantSueter);
    }

    public String getTotal() {
        return total.get();
    }

    public SimpleStringProperty totalProperty() {
        return total;
    }

    public void setTotal(String total) {
        this.total.set(total);
    }

    public String getPrecioJ() {
        return precioJ.get();
    }

    public SimpleStringProperty precioJProperty() {
        return precioJ;
    }

    public void setPrecioJ(String precioJ) {
        this.precioJ.set(precioJ);
    }

    public String getPrecioS() {
        return precioS.get();
    }

    public SimpleStringProperty precioSProperty() {
        return precioS;
    }

    public void setPrecioS(String precioS) {
        this.precioS.set(precioS);
    }

}
