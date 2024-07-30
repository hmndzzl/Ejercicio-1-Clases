public class Ubicacion{
    //Atributos
    private String nombre;
    private int precio;
    private int boletosDisponibles;


    public Ubicacion(String nombre, int precio, int boletosDisponibles){
        this.nombre = nombre;
        this.precio = precio;
        this.boletosDisponibles = boletosDisponibles;
    }

    //Setters & getters

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getBoletosDisponibles() {
        return this.boletosDisponibles;
    }

    public void setBoletosDisponibles(int boletosDisponibles) {
        this.boletosDisponibles = boletosDisponibles;
    }
}