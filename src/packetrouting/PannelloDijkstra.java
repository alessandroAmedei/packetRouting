/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packetrouting;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alessandro
 */
public class PannelloDijkstra extends JPanel {
    
    PannelloDijkstra(){
        
        this.setSize(300,300);
        this.setLayout(null);
        this.setLocation(980,320);
        this.setVisible(true);
        this.setBackground(Color.orange);
        Main.WAN.add(this);
        
        
        JLabel title = new JLabel("<html><font size='4', color='red'>"+ "Amedei's package");
        
        title.setSize(300,50);
        title.setLocation(10,10);
        title.setLayout(null);
        title.setVisible(true);
        this.add(title);
        
        
        JLabel percorsoMin=new JLabel();
        
        percorsoMin.setSize(300,50);
        percorsoMin.setLocation(1,51);
       percorsoMin.setLayout(null);
        percorsoMin.setVisible(true);
        this.add(percorsoMin);
        
        for(int a=0;a<Main.WAN.h;a++)
            percorsoMin.setText(percorsoMin.getText()+ "    " + Main.WAN.percorsoMinore[a].name);
        percorsoMin.setText(percorsoMin.getText()+"   "+ Main.WAN.pesoMinore);
        
        
        
        JLabel percorsoMin2=new JLabel();
        
        percorsoMin2.setSize(300,50);
        percorsoMin2.setLocation(1,101);
       percorsoMin2.setLayout(null);
        percorsoMin2.setVisible(true);
        this.add(percorsoMin2);
        
        for(int a=0;a<Main.WAN.h2;a++)
            percorsoMin2.setText(percorsoMin2.getText()+ "    " + Main.WAN.percorsoMinore2[a].name);
            percorsoMin2.setText(percorsoMin2.getText()+"   "+ Main.WAN.pesoMinore2);
        
        
      JLabel percorsoMin3=new JLabel();
        
        percorsoMin3.setSize(300,50);
        percorsoMin3.setLocation(1,151);
       percorsoMin3.setLayout(null);
        percorsoMin3.setVisible(true);
        this.add(percorsoMin3);
        
        for(int a=0;a<Main.WAN.h3;a++)
            percorsoMin3.setText(percorsoMin3.getText()+ "    " + Main.WAN.percorsoMinore3[a].name);  
        percorsoMin3.setText(percorsoMin3.getText()+"   " + Main.WAN.pesoMinore3);
        
        
        
        
     
       
        
        JLabel percorsiPossibili=new JLabel();
        
        percorsiPossibili.setSize(300,50);
        percorsiPossibili.setLocation(5,220);
       percorsiPossibili.setLayout(null);
        percorsiPossibili.setVisible(true);
        this.add(percorsiPossibili);
        
        try{
        percorsiPossibili.setText("Per andare da  " + Main.WAN.percorsoMinore[0].name + "  a  " + Main.WAN.percorsoMinore[Main.WAN.h-1].name + "  ci sono " + Main.WAN.nPercorsi + " strade possibili");
        }
        catch(Exception e){}
    }
    
    
    
   
    @Override
    public void paintComponent(Graphics g1){
        super.paintComponent(g1);
        
        Graphics2D g=(Graphics2D) g1;
        
        g.setStroke(new BasicStroke(0));
       g.drawLine(0,50,300,50);
       
       g.drawLine(0, 100,300 , 100);
       g.drawLine(0, 150,300 , 150);
       g.drawLine(0, 200,300 , 200);
       
       
       
       
       for(int x=0;x<=300;x=x+20)
           g.drawLine(x,50 ,x,200);
       
    /*   
       g.drawLine(0,200,0,300);
       g.drawLine(300,200,300,300);
       
       g.drawLine(100,200,100,300);
       g.drawLine(200,200,200,300);
      */ 
       
       
     setOpaque(true);
     repaint();
        
    }
    
}
