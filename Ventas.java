public class Ventas{
    //Atributos 
    private Comprador comprador;
    private Ubicacion ubicacion;
    private String ticket;

    //Constructor 
    public Ventas(Comprador comprador, Ubicacion ubicacion, String ticket){
        this.comprador = comprador;
        this.ubicacion = ubicacion;
        this.ticket = ticket;
    }
    //Setters & Getters

    public Comprador getComprador() {
        return this.comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTicket() {
        return this.ticket;
    }
    // Methods

    public void setTicket(String fecha, int noCliente) { //Función para generar el número de ticket
        this.ticket = fecha + String.valueOf(noCliente);
    }
}