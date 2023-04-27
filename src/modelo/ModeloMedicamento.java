package modelo;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ModeloMedicamento extends Medicamento{
    
public static ArrayList<Medicamento> listmed = new ArrayList<>();

    public ModeloMedicamento() {
    }

    
    public ModeloMedicamento(String nombre, String tipo_medicamento, int cantidad, String distribuidor, String sucursal) {
        super(nombre, tipo_medicamento, cantidad, distribuidor, sucursal);
    }
    
    public void setMed(String nombre, String tipo_medicamento, int cantidad, String distribuidor, String sucursal){
        
        Medicamento med = new Medicamento();
        med.setNombre(nombre);
        med.setTipo_medicamento(tipo_medicamento);
        med.setCantidad(cantidad);
        med.setDistribuidor(distribuidor);
        med.setSucursal(sucursal);
        
        listmed.add(med);
    } 
}
