/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packetrouting;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import static packetrouting.WAN.link;
import static packetrouting.WAN.send;

/**
 *
 * @author Alessandro
 */
public class LinkRouter implements ActionListener {

        
    public static int count=0;
   public static Router r1;
    public static Router r2;
   public static PannelloTabellaDiRouting p1;
   public static PannelloDijkstra pannelloDijkstra;
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        Router r= (Router) ae.getSource();
        
         if(link==true || send==true){           
        
        
        if(count==0){
            r1=r;
        count=1;
        return;
        }
        
        else if(count==1){
        if(r1==r)
            return;
        
        if(link)
        Main.WAN.Link(r1, r,6);
        
        else if(send){
            
            
        
            
        Main.WAN.percorsoMinore=new Router[50];
        Main.WAN.percorsoMinore2=new Router[50];
        Main.WAN.percorsoMinore3=new Router[50];

        Main.WAN.h=0;
        Main.WAN.h2=0;
        Main.WAN.h3=0;    
            
        
    
           r2=r;
        Main.WAN.Dijkstra(r1, r);
    Main.WAN.deleteB.setVisible(true);
        
        try{
            
            pannelloDijkstra.setVisible(false);
        }
        catch(Exception e){}
        
         pannelloDijkstra = new PannelloDijkstra();
        /*
        System.out.println(" "); 
        System.out.println(" "); 
        System.out.print("Percorso Minore  ");
        
        for(int a=0;a<Main.WAN.h;a++)
        System.out.print((Main.WAN.percorsoMinore[a].name + " "));
        System.out.println(Main.WAN.pesoMinore);
        System.out.println(" ");
        System.out.print("Secondo Percorso Minore  ");
        for(int a=0;a<Main.WAN.h2;a++)
        System.out.print((Main.WAN.percorsoMinore2[a].name + " "));
        System.out.println(Main.WAN.pesoMinore2);
        System.out.println(" ");
        System.out.print("Terzo Percorso Minore  ");
        for(int a=0;a<Main.WAN.h3;a++)
        System.out.print((Main.WAN.percorsoMinore3[a].name + " "));
        System.out.println(Main.WAN.pesoMinore3);
        
        
        
        
        System.out.println(" ");
        System.out.println("Numero perorsi " + Main.WAN.nPercorsi);
        */
Main.WAN.pesoMinore=2147483647;
Main.WAN.pesoMinore2=2147483647;
Main.WAN.pesoMinore3=2147483647;


Main.WAN.pesoLink=0;
Main.WAN.pesoPercorso=0;
Main.WAN.nSalto=-1;
Main.WAN.nPercorsi=0;


        


        }
        
        
        Main.WAN.repaint();
        
        Main.WAN.linkB.setBackground(Color.green);
        Main.WAN.sendB.setBackground(Color.green);
        link=false;
        send=false;
        count=0;
        r1=null;
        r2=null;
        
        
    }
         }
         
         else{
    
  
        

           
        
        
        
        
         
  
         }
         try{
            
           p1.setVisible(false);
           
       
        }
        catch(Exception e){}
        
        r.pannelloTabellaDiRouting.aggiorna(r);
        r.pannelloTabellaDiRouting.setVisible(true);
        p1=r.pannelloTabellaDiRouting; 
        }
}