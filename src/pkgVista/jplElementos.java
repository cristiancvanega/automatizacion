/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgVista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author user
 */
public class jplElementos extends javax.swing.JPanel {
    //tanke
    int x = 100, y = 100,  ancho= 120, alto= 180;
    //temperatura
    int x1 = 300, y1 = 90, ancho1 = 30, alto1 = 100;
    private double nivelEntanque;
    private double temperatura;
    private double nivel;
    private double caudalQ1;
    private double caudalQ2;
    private double presionEnQ1;    
    private double llama;
    private double volumenTanque;
    private double diametroAgujeroQ2;//en metros
    //CONSTANTES
    private double PI = 3.141592654;
    private double DIAMETROTANQUE = 1.20 ;
    
    //nivel
    int x2 = x1+ancho1+20, y2 = 90;
    //caudal    Q1
    int x3 = x2+ancho1+20, y3 = 90;
    //caudal    Q2
    int x4 = x3+ancho1+20, y4 = 90;
    //Valvula    Q1
    int ancho2 = 100, alto2 = 10;
    int x5 = x-ancho2+15, y5 = y1-10;
    //Valvula    Q2
    int ancho3 = 100;
    int x6 = x+ancho, y6 = y+alto-10;
    //llama
    int ancho4 = 120, alto4 = 15;
    int x7= x, y7= y+alto+30;
    
    
    
        
    /**
     * Creates new form jplElementos
     */
    public jplElementos(double nivel, double temperatura, double caudalQ1, double diametroAgujeroQ2, double llama) {
        initComponents();
        setBounds(100, 100, 600, 900);         
       
        nivel(nivel);   
        caudalEntrante(caudalQ1);        
        caudalSaliente(diametroAgujeroQ2);
        setTemperatura(temperatura);      
        setLlama(llama);
        
        
        
        
    }
    
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        //tanke        
        g2.drawRect(x, y, ancho, alto);
        g2.setColor(Color.blue);
        g2.fillRect(x, y+alto-(int)getNivelEntanque(), ancho, (int)getNivelEntanque());
        //temperatura        
        g2.setColor(Color.black);
        g2.drawString("T°", x1+4, y1-2);
        g2.drawRect(x1, y1, ancho1, alto1);
        g2.setColor(Color.red);
        g2.fillRect(x1, y1+alto1-(int)getTemperatura(), ancho1, (int)getTemperatura());
        //nivelEntanque        
        g2.setColor(Color.black);
        g2.drawString("L", x2+4, y2-2);
        g2.drawRect(x2, y2, ancho1, alto1);
        g2.setColor(Color.red);
        g2.fillRect(x2, y2+alto1-(int)getNivel(), ancho1, (int)getNivel());
        //Caudal Q1        
        g2.setColor(Color.black);
        g2.drawString("Caudal", x3+((x4-x3)/2)-5, y3-13);
        g2.drawString("Q1", x3+4, y3-2);
        g2.drawRect(x3, y3, ancho1, alto1);
        g2.setColor(Color.red);
        g2.fillRect(x3, y3+alto1-(int)getCaudalQ1(), ancho1, (int)getCaudalQ1());
        //Caudal Q2
        g2.setColor(Color.black);
        g2.drawString("Q2", x4+4, y4-2);
        g2.drawRect(x4, y4, ancho1, alto1);
        g2.setColor(Color.red);
        g2.fillRect(x4, y4+alto1-(int)getCaudalQ2(), ancho1, (int)getCaudalQ2());
        //Valvula  Q1
        g2.setColor(Color.black);
        g2.drawString("Q1", x5+ancho2-10, y5-2);
        g2.drawRect(x5, y5, ancho2, alto2);
        g2.setColor(Color.blue);
        g2.fillRect(x5, y5+alto2-(int)getPresionEnQ1(), ancho2, (int)getPresionEnQ1());
        //Valvula  Q2
        g2.setColor(Color.black);
        g2.drawString("Q2", x6+2, y6-2);
        g2.drawRect(x6, y6, ancho3, alto2);
        g2.setColor(Color.blue);
        g2.fillRect(x6, y6+alto2-(int)getDiametroAgujeroQ2(), ancho3, (int)getDiametroAgujeroQ2());
        //sensor Nivel :)
        g2.setColor(Color.black);
        g2.fillRect(x+ancho, y+(alto/3), 20, 60);
        g2.drawString("Sensor Nivel(L)", x+ancho+20, y+(alto/3)+55);
        //sensor temperatura :)
        g2.fillRect(x, y+(alto/3), 10, 30);
        g2.drawLine(x, y+(alto/3)+15, x-10, y+(alto/3)+15);
        g2.drawString("Sensor Temp°", 10, y+(alto/3)+15);
        //LLama
        g2.setColor(Color.black);
        g2.drawRect(x7, y7, ancho4, alto4);
        g2.setColor(Color.red);
        g2.fillRect(x7, y7+alto4-(int)getLlama(), ancho4, (int)getLlama());
        
        
        
        
    }
    
    public void nivel(double nivel){
        setNivelEntanque(nivel);
        setNivel(nivel);
        setVolumenTanque(nivel);
       
        
    }
    
    public void caudalEntrante(double caudalQ1 ){
        setCaudalQ1(caudalQ1);
        setPresionEnQ1(caudalQ1);
    }
    
    public void caudalSaliente(double diametroAgujeroQ2){
        setCaudalQ2(diametroAgujeroQ2);        
        setDiametroAgujeroQ2(diametroAgujeroQ2);
        
    }
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    /**
     * @return the nivelEntanque
     */
    public double getNivelEntanque() {
        return nivelEntanque;
    }

    /**
     * @param nivelEntanque the nivelEntanque to set
     */
    public void setNivelEntanque(double nivel) {        
        this.nivelEntanque = alto*(nivel/100);  
        
    }

    /**
     * @return the temperatura
     */
    public double getTemperatura() {
        return temperatura;
    }

    /**
     * @param temperatura the temperatura to set
     */
    public void setTemperatura(double temperatura) {
        this.temperatura = (alto1*(temperatura/100));
    }

    /**
     * @return the nivel
     */
    public double getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(double nivel) {       
        this.nivel = (alto1*(nivel/100)); 
    }

    /**
     * @return the caudalQ1
     */
    public double getCaudalQ1() {
        return caudalQ1;
    }

    /**
     * @param caudalQ1 the caudalQ1 to set
     */
    public void setCaudalQ1(double caudalQ1) {
       this.caudalQ1 = (alto1*(caudalQ1/100))*10;
    }

    /**
     * @return the caudalQ2
     */
    public double getCaudalQ2() {
        return caudalQ2;
    }

    /**
     * @param caudalQ2 the caudalQ2 to set
     */
    public void setCaudalQ2(double caudalQ2) {
        this.caudalQ2 = (alto1*(caudalQ2*10));
    }

    /**
     * @return the presionEnQ1
     */
    public double getPresionEnQ1() {
        return presionEnQ1;
    }

    /**
     * @param presionEnQ1 the presionEnQ1 to set
     */
    public void setPresionEnQ1(double caudalQ1) {
        //this.presionEnQ1 = (alto2*(caudalQ1/100));
        this.presionEnQ1 = caudalQ1;
    }

    

    /**
     * @return the llama
     */
    public double getLlama() {
        return llama;
    }

    /**
     * @param llama the llama to set
     */
    public void setLlama(double llama) {
        this.llama = (alto4*(llama/100));
    }

    /**
     * @return the volumenTanque
     */
    public double getVolumenTanque() {
        return volumenTanque;
    }

    /**
     * @param volumenTanque the volumenTanque to set
     */
    public void setVolumenTanque(double nivel) {
        System.out.println(nivel);
        //nivel, viene en pocentaje
        //nivelReal es en metros
        double nivelReal = (((double)alto/100)*nivel)/100;//ALTO SE DIVIDE PARA OBTENER VALOR REAL EN METROS   
        
        this.volumenTanque = PI*((DIAMETROTANQUE*DIAMETROTANQUE)/4)*(nivelReal-getDiametroAgujeroQ2()) ;
        
    }

    /**
     * @return the diametroAgujero
     */
    public double getDiametroAgujeroQ2() {
        return diametroAgujeroQ2;
    }

    /**
     * @param diametroAgujero the diametroAgujero to set
     */
    public void setDiametroAgujeroQ2(double diametroAgujeroQ2) {
        this.diametroAgujeroQ2 = (alto2*(diametroAgujeroQ2*1))*10;
        
    }
}
