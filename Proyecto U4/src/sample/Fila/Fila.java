package sample.Fila;

import javafx.beans.property.SimpleStringProperty;

public class Fila {
private SimpleStringProperty id;
private SimpleStringProperty Name;
private SimpleStringProperty Description;
private SimpleStringProperty Price;
private SimpleStringProperty Amount;
private SimpleStringProperty Total;

    public Fila(String id, String name, String description, String price, String amount, String total) {
        this.id =new  SimpleStringProperty(id);
        Name = new  SimpleStringProperty(name);
        Description = new  SimpleStringProperty(description);
        Price = new  SimpleStringProperty(price);
        Amount = new  SimpleStringProperty(amount);
        Total = new  SimpleStringProperty(total);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getDescription() {
        return Description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description.set(description);
    }

    public String getPrice() {
        return Price.get();
    }

    public SimpleStringProperty priceProperty() {
        return Price;
    }

    public void setPrice(String price) {
        this.Price.set(price);
    }

    public String getAmount() {
        return Amount.get();
    }

    public SimpleStringProperty amountProperty() {
        return Amount;
    }

    public void setAmount(String amount) {
        this.Amount.set(amount);
    }

    public String getTotal() {
        return Total.get();
    }

    public SimpleStringProperty totalProperty() {
        return Total;
    }

    public void setTotal(String total) {
        this.Total.set(total);
    }
}
