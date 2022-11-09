package Model;

public class detalle {
    private int id;
    private int cantidad;
    private int id_Producto;
    private int id_Factura;

    public detalle() {
    }

    public detalle(int id, int cantidad, int id_Producto, int id_Factura) {
        this.id = id;
        this.cantidad = cantidad;
        this.id_Producto = id_Producto;
        this.id_Factura = id_Factura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public int getId_Factura() {
        return id_Factura;
    }

    public void setId_Factura(int id_Factura) {
        this.id_Factura = id_Factura;
    }
}

