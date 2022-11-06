package Model;

public class producto {
    private String descripcion;
    private float peso;
    private int cantidad;
    private float precio;
    private String plu;
    private String ean;
    private int id_Categoria;

    public producto() {
    }

    public producto(String descripcion, float peso, int cantidad, float precio, String plu, String ean, int id_Categoria) {
        this.descripcion = descripcion;
        this.peso = peso;
        this.cantidad = cantidad;
        this.precio = precio;
        this.plu = plu;
        this.ean = ean;
        this.id_Categoria = id_Categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getPlu() {
        return plu;
    }

    public void setPlu(String plu) {
        this.plu = plu;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public int getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }
}
