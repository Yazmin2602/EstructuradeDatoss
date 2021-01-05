package sample.Estructura;

public class Pedido {
    String [][] datos;
    String nombreCliente;

    public Pedido(String[][] datos, String nombreCliente) {
        this.datos = datos;
        this.nombreCliente = nombreCliente;
    }

    public String[][] getDatos() {
        return datos;
    }

    public void setDatos(String[][] datos) {
        this.datos = datos;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
