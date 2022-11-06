package Model;

public class usuario {

    private String nombre;
    private String password;
    private String role;

    public usuario() {
    }

    public usuario(String nombre, String password, String role) {
        this.nombre = nombre;
        this.password = password;
        this.role = role;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
