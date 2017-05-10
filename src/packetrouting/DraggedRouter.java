/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packetrouting;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.MouseMotionListener;
import static packetrouting.LabelRigaTabellaRouting.plc;

/**
 *
 * @author Alessandro
 */
public class DraggedRouter implements MouseMotionListener {


    @Override
    public void mouseDragged(MouseEvent me) {
       
        
        Router r= (Router) me.getSource();
        
        r.setLocation(r.getLocation().x+me.getX(),r.getLocation().y+me.getY());
        
       /*  try{
                 
              if(plc.rs==r || plc.rd==r){
           
             
              Main.WAN.remove(plc);
              plc=r.RigaTabellaRouting[plc.riga2].dataLabel.panelLinkConfigure=new PanelLinkConfigure(plc.rs,plc.rd,plc.riga2);
              r.RigaTabellaRouting[plc.riga2].dataLabel.panelLinkConfigure.setVisible(true);
              Main.WAN.repaint();
              }
              
               }
             catch(Exception e){}
       
         */
        
        try{
        plc.aggiorna();
        }
        catch(Exception e){}
        
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
       
    }
    

    
}
