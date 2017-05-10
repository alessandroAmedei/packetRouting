/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packetrouting;

import java.awt.Color;
import javax.swing.JButton;



/**
 *
 * @author Alessandro
 */
public class RigaTabellaDiRouting {
    public String NomeSorgente;
    public Router IndirizzoSorgente;
    public Router IndirizzoDestinatario;
    public int PesoTratta;
    public JButton linkDelete;
  LabelRigaTabellaRouting dataLabel;
 Color colorLink=Color.BLACK;
 int rigaDestinatario;
    
    
    RigaTabellaDiRouting(String ns,Router s,Router d,int p){
        
        NomeSorgente=ns;
        IndirizzoSorgente=s;
        IndirizzoDestinatario=d;
        PesoTratta=p;
        
        linkDelete=new JButton("x");
        linkDelete.setSize(20,20);
        linkDelete.setLayout(null);
        linkDelete.setVisible(true);
        
        
        
        
    }



 

}