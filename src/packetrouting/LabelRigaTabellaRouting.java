/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packetrouting;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author Alessandro
 */
public class LabelRigaTabellaRouting extends JLabel{
  
    
public static PanelLinkConfigure plc;   
  public PanelLinkConfigure panelLinkConfigure;
  Router rs;
  Router rd;
  

  
  LabelRigaTabellaRouting(String s,Router r1,Router r2,int al){
      
     panelLinkConfigure = new PanelLinkConfigure(r1,r2,al);
        
        
      super.setText(s);
      Router rs=r1;
      Router rd=r2;
      
      this.addMouseListener(new MouseListener(){

          @Override
          public void mouseClicked(MouseEvent me) {
              
             try{
                 plc.setVisible(false);
                 }
             catch(Exception e){}
             
             
              
              plc=panelLinkConfigure;
              panelLinkConfigure.aggiorna();
              panelLinkConfigure.setVisible(true);
              
              
              
              
          }

          @Override
          public void mousePressed(MouseEvent me) {
             
          }

          @Override
          public void mouseReleased(MouseEvent me) {
             
          }

          @Override
          public void mouseEntered(MouseEvent me) {
            
          }

          @Override
          public void mouseExited(MouseEvent me) {
            
          }
      });
      
      
      
      
      
  }
  
}
