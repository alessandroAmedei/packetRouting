/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packetrouting;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static packetrouting.LabelRigaTabellaRouting.plc;


/**
 *
 * @author Alessandro
 */
public class ActionRouter implements MouseListener{


    @Override
    public void mouseClicked(MouseEvent me) {
       
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
       
    }


    @Override
    
    public void mouseReleased(MouseEvent me) {
     
      
        Router r=(Router) me.getSource();
        
       Main.WAN.inserisci(r);
       
       
      r.removeMouseListener(this);
      
       Router r2=new Router(Character.toString((char)Main.WAN.name));
       Main.WAN.name++;
        
      
       
        
        r2.setSize(50,50);
        r2.setLocation(835,810);
        r2.setVisible(true);
        r2.setLayout(null);
        r2.addMouseMotionListener(Main.WAN.DRL);
        r2.addMouseListener(this);
        Main.WAN.add(r2);
        Main.WAN.repaint();
        

             
             
       
              
             
             
             
      
    }

    @Override
    public void mouseEntered(MouseEvent me) {
     
    }

    @Override
    public void mouseExited(MouseEvent me) {
      
    }
    
}
