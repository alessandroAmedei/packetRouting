/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packetrouting;

import javax.swing.JButton;

/**
 *
 * @author Alessandro
 */
public class Router extends JButton {
public int alreadyLink=0;
public final RigaTabellaDiRouting[] RigaTabellaRouting=new RigaTabellaDiRouting[Main.WAN.nMaxLink]; 
public String name="";
public PannelloTabellaDiRouting pannelloTabellaDiRouting;

Router(String n){
    name=n;
super.setText(n);

this.addKeyListener(new SendLinkListener());

pannelloTabellaDiRouting=new PannelloTabellaDiRouting(this);

}







}
  
 
    

