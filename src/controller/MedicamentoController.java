package controller;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modelo.ModeloMedicamento;
import static modelo.ModeloMedicamento.listmed;
import vista.Frame;

/**
 *
 * @author USER
 */
public class MedicamentoController {
    private ModeloMedicamento modelo;
    private Frame vista;

    public MedicamentoController(ModeloMedicamento modelo, Frame vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
    public void inicioControl(){
        vista.getBtnCancelar().addActionListener(l -> cerrar());
        vista.getBtnOk().addActionListener(l -> abrir());
        vista.getBtnEnviar().addActionListener(l -> crear());
        
        vista.getTxtNombre().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent ev) {
                if(!(Character.isLetter(ev.getKeyChar()))){
                    ev.consume();
                }
            }
        });
        
        vista.getTxtCantidad().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                int key = evt.getKeyChar();
                boolean numero = key>=48 && key<=57;
                
                if(!numero){
                    evt.consume();
                }
                if(vista.getTxtCantidad().getText().trim().length()==4){
                    evt.consume();
                }
            }
        });
    }

    public boolean validar(){
        boolean valido=true;
        
        if(vista.getTxtNombre().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite el nombre","ERROR_MESSAGE" ,JOptionPane.ERROR_MESSAGE);
            valido=false;
        }
        
        if(vista.getCmbTipo().getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Seleccione un tipo","ERROR_MESSAGE" ,JOptionPane.ERROR_MESSAGE);
            valido=false;
        }
        
        if(vista.getTxtCantidad().getText().isEmpty() || vista.getTxtCantidad().equals(0)){
            JOptionPane.showMessageDialog(null, "Digite la cantidad","ERROR_MESSAGE" ,JOptionPane.ERROR_MESSAGE);
            valido=false;
        }
        
        if(vista.getRbtCemefar().isSelected()==false && vista.getRbtCofarma().isSelected()==false && vista.getRbtEmpsephar().isSelected()==false){
          JOptionPane.showMessageDialog(null, "Elija una distribuidora","ERROR_MESSAGE" ,JOptionPane.ERROR_MESSAGE);
            valido=false;  
        }
        
        if(vista.getCheckPrincipal().isSelected()==false && vista.getCheckSucursal().isSelected()==false){
            JOptionPane.showMessageDialog(null, "Elija una sucursal","ERROR_MESSAGE" ,JOptionPane.ERROR_MESSAGE);
            valido=false; 
        }
        
        return valido;
    }
    
    
    private void abrir() {
        if (validar()==true) {
            //limpiarDatos();
            JOptionPane.showMessageDialog(null, "Campos validos","INFORMATION_MESSAGE" ,JOptionPane.INFORMATION_MESSAGE);
            String titulo;
            if(vista.getRbtCemefar().isSelected()){
                titulo="Cemefar";
            }else if(vista.getRbtCofarma().isSelected()){
                titulo="Coforma";
            }else{
                titulo="Empsephar";
            }
            vista.getTxtNpedidos().setText(listmed.size()+"");
            String tit = "Pedido";
            vista.getDlgPedido().setName("P");
            vista.getjLabel7().setText(tit);
            vista.getDlgPedido().setVisible(true);
            vista.getDlgPedido().setTitle("Pedido al Distribuidor "+titulo);
            vista.getDlgPedido().setSize(500, 400);
            vista.getDlgPedido().setLocationRelativeTo(vista);
            
            EnviarDatos();
            
            //limpiarDatos();

        } else {
            JOptionPane.showMessageDialog(null, "Campos incorectos o invalidos","ERROR_MESSAGE" ,JOptionPane.ERROR_MESSAGE);
            }
        }
    
    public void cerrar(){
        limpiarDatos();
        vista.getDlgPedido().dispose();
        //vista.dispose();
    }
    
    private void limpiarDatos(){
        vista.getTxtNombre().setText("");
        vista.getCmbTipo().setSelectedIndex(0);
        vista.getTxtCantidad().setText("");
        vista.getButtonGroup1().clearSelection();
        vista.getCheckPrincipal().setSelected(false);
        vista.getCheckSucursal().setSelected(false);
    }   
    
    public void EnviarDatos(){

            String nombre = vista.getTxtNombre().getText();
            String tipo = vista.getCmbTipo().getSelectedItem().toString();
            String cantidad = vista.getTxtCantidad().getText();
//            String distri;
//            if(vista.getRbtCemefar().isSelected()){
//                distri="Cemefar";
//            }else if(vista.getRbtCofarma().isSelected()){
//                distri="Coforma";
//            }else{
//                distri="Empsephar";
//            }
            
            String sucursal = "";
            if(vista.getCheckPrincipal().isSelected()){
                sucursal="Calle de la Rosa n. 28";
                
            } 
            if(vista.getCheckSucursal().isSelected()){
                sucursal ="Calle Alcazabilla n. 3";
            }

            
            vista.getLblUnidades().setText(cantidad);
            vista.getLblTipo().setText(tipo);
            vista.getLblMedicamento().setText(nombre);
            vista.getLblDireccion().setText(sucursal);
        }

    public void crear(){
        String nombre = vista.getTxtNombre().getText();
        String tipo = vista.getCmbTipo().getSelectedItem().toString();
        String cantidad = vista.getTxtCantidad().getText();
        String distri;
        if(vista.getRbtCemefar().isSelected()){
            distri="Cemefar";
        }else if(vista.getRbtCofarma().isSelected()){
            distri="Coforma";
        }else{
            distri="Empsephar";
        }

        String sucursal = "";
        if(vista.getCheckPrincipal().isSelected()&& vista.getCheckSucursal().isSelected()){
            sucursal = "Calle de la Rosa n. 28 y Calle Alcazabilla n. 3";

        }else if(vista.getCheckPrincipal().isSelected()){
            sucursal="Calle de la Rosa n. 28";

        }else if(vista.getCheckSucursal().isSelected()){
            sucursal ="Calle Alcazabilla n. 3";
        }
        
        
        ModeloMedicamento med = new ModeloMedicamento();
        
        med.setNombre(nombre);
        med.setTipo_medicamento(tipo);
        int cant = Integer.parseInt(cantidad);
        med.setCantidad(cant);
        med.setDistribuidor(distri);
        med.setSucursal(sucursal);
        
        try {
            med.setMed(nombre, tipo, cant, distri, sucursal);
            JOptionPane.showMessageDialog(null, "Pedido Enviado");
            limpiarDatos();
            cerrar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
   
    }
}
   
    
