/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgVista;


import java.awt.Color;
import java.awt.Event;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import static java.lang.Thread.sleep;
import java.util.concurrent.DelayQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JSlider;

/**
 *
 * @author user
 */
public class frmVista extends javax.swing.JFrame {
    jplElementos objElementos;
    //llave Q1
    JSlider llaveQ1 = new JSlider();
    //Botones Q2
    JButton Q2Abierto = new JButton();      
     JButton Q2Medio = new JButton();
     JButton Q2Cerrado = new JButton();
     //llama
     JSlider llama = new JSlider();
     boolean stop;
     double VOLMAX = 1.52681402; 
     double VOLMIN = 1.01787601; 
     
     //botones mando
     JButton start = new JButton();
     JButton btnStop = new JButton();
     JButton btnReinicar = new JButton();
     
    /**
     * Creates new form frmVista
     */
    public frmVista() {
        initComponents();
        this.setBounds(20, 20, 900, 600);
        int candela = 50;
        int nivelInicial = 50;
        int temperaturaInicial = 50;
        double diamIniAgujeroQ1 = 0.1;        
        double diamIniAgujeroQ2 = 0.00;//en metros
        objElementos = new jplElementos(nivelInicial, temperaturaInicial, diamIniAgujeroQ1, diamIniAgujeroQ2, candela);
        
        //llave Q1        
        llaveQ1.setBounds(64, 38, 50, 50);
        llaveQ1.setMaximum(0);
        llaveQ1.setMaximum(10);
        llaveQ1.setValue(10);
        llaveQ1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                llaveQ1StateChanged(evt);
            }
        });
        
        //Botones Q2   
        Q2Abierto.addActionListener(new java.awt.event.ActionListener()
        {   @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Q2AbiertoActionPerformed(evt);
                }
        });    
        Q2Abierto.setBounds(330, 270, 80, 30);
        Q2Abierto.setText("Abierto");   
        Q2Abierto.setBackground(Color.white);
       
        Q2Medio.addActionListener(new java.awt.event.ActionListener()
        {   @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Q2MedioActionPerformed(evt);
                }
        });
        Q2Medio.setBounds(330, 310, 80, 30);
        Q2Medio.setText("Medio");  
        Q2Medio.setBackground(Color.white);
        
        Q2Cerrado.addActionListener(new java.awt.event.ActionListener()
        {   @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Q2CerradoActionPerformed(evt);
                }
        });
        Q2Cerrado.setBounds(330, 350, 80, 30);
        Q2Cerrado.setText("Cerrado");
        Q2Cerrado.setBackground(Color.red);
        
        //llama        
        llama.setBounds(130, 320, 64, 38);
        llama.setMaximum(0);
        llama.setMaximum(100);
        llama.setValue(candela);
        llama.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                llamaStateChanged(evt);
            }
        });
        
        //carga de objetos en panel        
        objElementos.add(llaveQ1);
        objElementos.add(Q2Abierto);
        objElementos.add(Q2Medio);
        objElementos.add(Q2Cerrado);
        objElementos.add(llama);
        
        this.add(objElementos);
        stop = Boolean.FALSE;  
        
        //botones mando
        start.setBounds(450, 280, 80, 30);
        start.setText("Iniciar");
        start.addActionListener(new java.awt.event.ActionListener()
        {   @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    IniciarActionPerformed(evt);
                }
        });
        objElementos.add(start);
        
        //stop
        btnStop.setBounds(450, 310, 80, 30);
        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener()
        {   @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnStopActionPerformed(evt);
                }
        });
        objElementos.add(btnStop);
        
        //reniniciar
         //stop
         btnReinicar.setBounds(450, 340, 80, 30);
         btnReinicar.setText("Reiniciar");
         btnReinicar.addActionListener(new java.awt.event.ActionListener()
        {   @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                     btnReinicarActionPerformed(evt);
                }
        });
        objElementos.add(btnReinicar);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   
    private void Q2AbiertoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        Q2Abierto.setBackground(Color.green);
        Q2Medio.setBackground(Color.white);
        Q2Cerrado.setBackground(Color.white);
        objElementos.setDiametroAgujeroQ2(0.1);
        objElementos.pullVolumenTanque(objElementos.CaudalSaliente());
        objElementos.repaint();  
        
        
        
        
    } 
    private void Q2MedioActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        Q2Medio.setBackground(Color.yellow);
        Q2Abierto.setBackground(Color.white);
        Q2Cerrado.setBackground(Color.white);
        objElementos.setDiametroAgujeroQ2(0.05);
        objElementos.pullVolumenTanque(objElementos.CaudalSaliente());
        objElementos.repaint();
        
      
    }
    private void Q2CerradoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        Q2Cerrado.setBackground(Color.red);
        Q2Abierto.setBackground(Color.white);
        Q2Medio.setBackground(Color.white);
        objElementos.setDiametroAgujeroQ2(0.00);
        objElementos.repaint();
        
    }
    private void llamaStateChanged(javax.swing.event.ChangeEvent evt) {                                      
        // TODO add your handling code here:
        objElementos.setLlama(llama.getValue());
        objElementos.repaint();
        System.out.println(llama.getValue());
        
    } 
    private void llaveQ1StateChanged(javax.swing.event.ChangeEvent evt) {                                      
        // TODO add your handling code here:
        objElementos.setDiametroAgujeroQ1((double)llaveQ1.getValue()/100);
        objElementos.repaint();
               
    }
    
     private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
         
         Thread hilo = new Thread(){
             public void run(){
        
        while(!stop){
           
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(frmVista.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(objElementos.getVolumenTanque()>= VOLMAX){
                //CERRAR VALVULa Q1
                CerrarQ1(0);
                //abrir valvula Q2
                Q2Abierto.doClick();
               
            }else{
                
                if(objElementos.getVolumenTanque()>= VOLMIN){
                    //cerrar valvula q2
                    Q2Cerrado.doClick();
                    //abrir valvula q1
                    AbrirQ1(5);
                
                }else{
                    //cerrar valvula q2
                    Q2Cerrado.doClick();
                    //abrir valvula q1
                    AbrirQ1(10);
                }                
                
            }
            
            
        
        }
           
            
    
            
    }
        };
        hilo.start();
         
             
        
         
            
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(frmVista.class.getName()).log(Level.SEVERE, null, ex);
//            }
            
            
        
             
        
        
        
           
        
        
    }
     
     private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        this.stop = Boolean.TRUE;
    }
    
      private void btnReinicarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        this.stop = Boolean.FALSE;
        objElementos.nivel(50); 
        objElementos.setDiametroAgujeroQ1(0.1);
        objElementos.setDiametroAgujeroQ2(0.00);
        objElementos.repaint();
        
    }
   
    
    public void CerrarQ1(int value){
        llaveQ1.setValue(value);
        objElementos.setDiametroAgujeroQ1((double)llaveQ1.getValue()/100);
        objElementos.repaint();
        
    }
    
    public void AbrirQ1(int value){
        llaveQ1.setValue(value);
        objElementos.setDiametroAgujeroQ1((double)llaveQ1.getValue()/100);
        objElementos.pushVolumenTanque(objElementos.CaudalEntrante());
        objElementos.repaint();
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new frmVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
