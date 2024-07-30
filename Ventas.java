public class Ventas{
    private Comprador comprador;
    private Ubicacion ubicacion;
    private String ticket;

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

    public void setTicket(int fecha, int noCliente) {
        this.ticket = String.valueOf(fecha) + String.valueOf(noCliente);
    }
}