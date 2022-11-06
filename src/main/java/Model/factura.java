package Model;

public class factura {
    private String cajero;
    private int caja;
    private String fecha;
    private String hora;
    private float subtotal;
    private float total;

    public factura() {
    }

    public factura(String cajero, int caja, String fecha, String hora, float subtotal, float total) {
        this.cajero = cajero;
        this.caja = caja;
        this.fecha = fecha;
        this.hora = hora;
        this.subtotal = subtotal;
        this.total = total;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
