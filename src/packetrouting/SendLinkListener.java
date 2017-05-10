/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packetrouting;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Alessandro
 */
public class SendLinkListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
     if (ke.getKeyCode() == KeyEvent.VK_SHIFT) {
         if(!Main.WAN.link){
                Main.WAN.link=true;
                Main.WAN.linkB.setBackground(Color.blue);}
     }
         
     
     if (ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
         if(!Main.WAN.send){
                Main.WAN.send=true;
                Main.WAN.sendB.setBackground(Color.red);
                Main.WAN.sendB.setText("send");}
     }
}
    
    @Override
    public void keyReleased(KeyEvent ke) {
       
   
    
}
}