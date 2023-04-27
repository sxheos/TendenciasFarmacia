package modelo;

/**
 *
 * @author USER
 */
public class Medicamento {
    //private String id;
    private String nombre;
    private String tipo_medicamento;
    private int cantidad;
    private String distribuidor;
    private String sucursal;

    //Contructor
    
    public Medicamento() {
    }

    public Medicamento(String nombre, String tipo_medicamento, int cantidad, String distribuidor, String sucursal) {
        //this.id = id;
        this.nombre = nombre;
        this.tipo_medicamento = tipo_medicamento;
        this.cantidad = cantidad;
        this.distribuidor = distribuidor;
        this.sucursal = sucursal;
    }

    
    //Getter and Setter
    /*public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_medicamento() {
        return tipo_medicamento;
    }

    public void setTipo_medicamento(String tipo_medicamento) {
        this.tipo_medicamento = tipo_medicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    
}
