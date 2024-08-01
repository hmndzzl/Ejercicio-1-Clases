public class Comprador{
    //Atributos
    private String nombre;
    private String correo;
    private int presupuesto;
    private int noBoletos;
    private int noCliente;

    //Constructor
    public Comprador(String nombre, String correo, int prespuesto, int noBoletos, int noCliente){
        this.nombre = nombre;
        this.correo = correo;
        this.presupuesto = prespuesto;
        this.noBoletos = noBoletos;
        this.noCliente = noCliente;
    }

    //Setters & getters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPresupuesto() {
        return this.presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getNoBoletos() {
        return this.noBoletos;
    }

    public void setNoBoletos(int noBoletos) {
        this.noBoletos = noBoletos;
    }

    public int getNoCliente() {
        return this.noCliente;
    }

    public void setNoCliente(int noCliente) {
        this.noCliente = noCliente;
    }

}