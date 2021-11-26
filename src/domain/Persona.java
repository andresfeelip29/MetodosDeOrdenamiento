
package domain;


public class Persona {
    
    private String nombre;
    private Integer id;
    private String direccion;
    private Integer edad;

    public Persona(String nombre, Integer id, String direccion, Integer edad) {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
        this.edad = edad;
    }
    
    public Persona(){
    //
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona [ ");
        sb.append("| Nombre:  ").append(this.nombre);
        sb.append("| Identificacion: ").append(this.id);
        sb.append("| Edad:  ").append(this.edad);
        sb.append("| Direccion: ").append(this.direccion);
        sb.append(" ] ");
        sb.append("\n");
        return sb.toString();
    }
    
}
