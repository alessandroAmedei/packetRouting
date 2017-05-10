package packetrouting;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class DeleteLink implements ActionListener {

    Router r;
    int riga;
    
    @Override
    public void actionPerformed(ActionEvent ae) {
           
        Router rde=null;
     
       try{
        
        
           r.RigaTabellaRouting[riga].IndirizzoDestinatario.RigaTabellaRouting[r.RigaTabellaRouting[riga].rigaDestinatario].IndirizzoSorgente.removeActionListener(this);
           r.removeActionListener(this);
           
            r.RigaTabellaRouting[riga].IndirizzoDestinatario.alreadyLink--;  //RESETTO I VARI PARAMETRI..
       r.alreadyLink--;
        
         r.RigaTabellaRouting[riga].dataLabel.setVisible(false);
               r.RigaTabellaRouting[riga].linkDelete.setVisible(false);
               
               r.RigaTabellaRouting[riga].IndirizzoDestinatario.RigaTabellaRouting[r.RigaTabellaRouting[riga].rigaDestinatario].dataLabel.setVisible(false);
               r.RigaTabellaRouting[riga].IndirizzoDestinatario.RigaTabellaRouting[r.RigaTabellaRouting[riga].rigaDestinatario].linkDelete.setVisible(false);
               
               
                r.RigaTabellaRouting[riga].dataLabel=null;
               r.RigaTabellaRouting[riga].IndirizzoDestinatario.RigaTabellaRouting[r.RigaTabellaRouting[riga].rigaDestinatario].dataLabel=null;
            
               r.RigaTabellaRouting[riga].linkDelete=null;
               r.RigaTabellaRouting[riga].IndirizzoDestinatario.RigaTabellaRouting[r.RigaTabellaRouting[riga].rigaDestinatario].linkDelete=null;
               
                rde=r.RigaTabellaRouting[riga].IndirizzoDestinatario;
                
                 r.RigaTabellaRouting[riga].IndirizzoDestinatario.RigaTabellaRouting[r.RigaTabellaRouting[riga].rigaDestinatario]=null;
               r.RigaTabellaRouting[riga]=null;
                
                 
               LinkRouter.p1.setVisible(false);
        LinkRouter.p1=r.pannelloTabellaDiRouting;
        
        
        r.pannelloTabellaDiRouting.aggiorna(r);
        rde.pannelloTabellaDiRouting.aggiorna(rde);
        r.pannelloTabellaDiRouting.setVisible(true);
        
     }
        catch(Exception e){System.out.println("Codice 00x1.. NullPointer.. Double Listener (deletelink.class) verificato xAlessandroAMEDEI");}
         
        
        
    }          
            
        
        
public void configureButton(Router r1,int riga1){
       
       r=r1;
       riga=riga1;
   }
    
}
