package actividad1;

import controller.MedicamentoController;
import modelo.ModeloMedicamento;
import vista.Frame;

/**
 *
 * @author USER
 */
public class Actividad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Frame vista = new Frame();
        ModeloMedicamento modelo = new ModeloMedicamento();
        MedicamentoController controlador=new MedicamentoController(modelo, vista);
        controlador.inicioControl();
    }
    
}
