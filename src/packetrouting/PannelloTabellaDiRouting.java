/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packetrouting;



import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alessandro
 */
public class PannelloTabellaDiRouting extends JPanel {
      JLabel l=new JLabel();
    JLabel l1=new JLabel();
    
    
    public Router now;
 PannelloTabellaDiRouting(Router r){
     now=r;
     
     this.setSize(300,300);
     this.setVisible(false);
     this.setLayout(null);
     this.setBackground(new Color(175,230,200));
   
     
     Main.WAN.add(this);
     
     this.setLocation(980,10);
    
  
    
    
    l.setLocation(0,0);
    l.setSize(300,300);
    l.setVisible(true);
    l.setLayout(null);
    
    l1.setLocation(5,5);
    l1.setSize(300,50);
    l1.setVisible(true);
    l1.setLayout(null);
    
    if(r.alreadyLink==0)
        l1.setText("<html><font size='4', color='red'>" + "Tabella di Instradamento Router" + " " + r.name + " "+ "</font>" + "<br>" + "Questo Router è isolato!");
                      

   /* 
    for(int al=0;al<Main.WAN.nMaxLink;al++){  //
        if(r.RigaTabellaRouting[al]!=null){
   
    r.RigaTabellaRouting[al].dataLabel  =new LabelRigaTabellaRouting("<html>"+l.getText() + "<br>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+  r.RigaTabellaRouting[al].IndirizzoSorgente.name + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + r.RigaTabellaRouting[al].IndirizzoDestinatario.name + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + r.RigaTabellaRouting[al].PesoTratta, r,r.RigaTabellaRouting[al].IndirizzoDestinatario,al );        
    
    r.RigaTabellaRouting[al].dataLabel.setLocation(0,y);
    r.RigaTabellaRouting[al].dataLabel.setSize(300,50);
    r.RigaTabellaRouting[al].dataLabel.setVisible(true);
    r.RigaTabellaRouting[al].dataLabel.setLayout(null);
    
    
    
    
     
DeleteLink DLL=new DeleteLink();     
DLL.configureButton(r, al);
    r.RigaTabellaRouting[al].linkDelete.setLocation(230,y+22);
    
    r.RigaTabellaRouting[al].linkDelete.addActionListener(DLL);
    y=y+20;
    this.add(r.RigaTabellaRouting[al].linkDelete);
    this.add(r.RigaTabellaRouting[al].dataLabel);
    }
    }
    }
    */
    
    this.add(l);
    this.add(l1);
    
     
     
 
 }

int y=50;
 public void aggiorna(Router r){
     this.setVisible(false);
     if(r.alreadyLink!=0) {
         l1.setText("<html><font size='4', color='red'>" + "Tabella di Instradamento Router " + r.name+ "</font>"
                 + "<br><br>" + "Sorgente , Destinatario , Peso");
         
         for(int al=0;al<Main.WAN.nMaxLink;al++){  //
             if(r.RigaTabellaRouting[al]!=null){
                 
                 r.RigaTabellaRouting[al].dataLabel.setText("<html> <br>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+  r.RigaTabellaRouting[al].IndirizzoSorgente.name + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + r.RigaTabellaRouting[al].IndirizzoDestinatario.name + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + r.RigaTabellaRouting[al].PesoTratta);
                 r.RigaTabellaRouting[al].dataLabel.setLocation(0,y);
                 
                 
                 
                 DeleteLink DLL=new DeleteLink();
                 DLL.configureButton(r, al);
                 r.RigaTabellaRouting[al].linkDelete.setLocation(230,y+22);
                 
                 r.RigaTabellaRouting[al].linkDelete.addActionListener(DLL);
                 y=y+20;
                 this.add(r.RigaTabellaRouting[al].linkDelete);
                 this.add(r.RigaTabellaRouting[al].dataLabel);
             }
         }
         y=50; 
     } 
     else 
         l1.setText("<html><font size='4', color='red'>" + "Tabella di Instradamento Router" + " " + r.name + " "+ "</font>" + "<br>" + "Questo Router è isolato!");
     
 }

 
    
}
