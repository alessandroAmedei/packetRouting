/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packetrouting;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static packetrouting.LinkRouter.p1;

/**
 *
 * @author Alessandro
 */
public class PanelLinkConfigure extends JPanel {
    
    public JTextField tfLunghezza = new JTextField();
    public JComboBox lmtu=new JComboBox();
    public JTextField tfCosto=new JTextField();
    
    Router rs;
    Router rd;
    int riga2;
    
    int indexType=4;
    
    PanelLinkConfigure(Router r,Router r2,int riga){
        
        
        rs=r;
        rd=r2;
        riga2=riga;
               
        
        
        
        this.setSize(300,300);
        this.setLocation(980,630);
        this.setLayout(null);
        this.setBackground(new Color(200,180,200));
        this.setVisible(false);
        Main.WAN.add(this);
        
        
        JLabel title=new JLabel("<html><font size='4', color='red'>Configurazione collegamento " + r.name +" -> " + r2.name );
        JLabel lunghezza = new JLabel("Lunghezza");
        JLabel mtu = new JLabel("Banda");
        JLabel costo= new JLabel("Costo");
        JLabel pesoCalcolato= new JLabel("Peso Calcolato");
        JLabel pesoEffettivo=new JLabel(String.valueOf(r.RigaTabellaRouting[riga].PesoTratta));
        
        
        
        
        title.setSize(300,20);
        title.setLocation(4,1);
        title.setVisible(true);
        title.setLayout(null);
        this.add(title);
        
        
         lunghezza.setSize(100,30);
        lunghezza.setLocation(1,30);
        lunghezza.setVisible(true);
        lunghezza.setLayout(null);
        this.add(lunghezza);
        
        mtu.setSize(100,30);
        mtu.setLocation(1,60);
        mtu.setVisible(true);
        mtu.setLayout(null);
        this.add(mtu);
        
         costo.setSize(100,30);
        costo.setLocation(1,90);
        costo.setVisible(true);
        costo.setLayout(null);
        this.add(costo);
        
        pesoCalcolato.setSize(100,30);
        pesoCalcolato.setLocation(1,120);
        pesoCalcolato.setVisible(true);
        pesoCalcolato.setLayout(null);
        this.add(pesoCalcolato);
        
        pesoEffettivo.setSize(50,30);
        pesoEffettivo.setLocation(200,120);
        pesoEffettivo.setVisible(true);
        pesoEffettivo.setLayout(null);
        this.add(pesoEffettivo);
        
        
        
        tfLunghezza.setSize(50,20);
        tfLunghezza.setLocation(200,30);
        tfLunghezza.setVisible(true);
        tfLunghezza.setLayout(null);
        this.add(tfLunghezza);
        
        lmtu.setSize(149,25);
        lmtu.setLocation(150,60);
        lmtu.setVisible(true);
        lmtu.setLayout(null);
        this.add(lmtu);
        
        tfCosto.setSize(50,20);
        tfCosto.setLocation(200,90);
        tfCosto.setVisible(true);
        tfCosto.setLayout(null);
        this.add(tfCosto);
        
        
        
         tfLunghezza.setText( String.valueOf((int) Math.sqrt(     Math.pow(r2.getLocation().x-r.getLocation().x,2)+ Math.pow(r2.getLocation().y-r.getLocation().y,2))  )       );
         tfCosto.setText("40");
         
         lmtu.addItem("Fibra MTU 1Gb/s");
         lmtu.addItem("Ethernet MTU 150Mb/s");
         lmtu.addItem("Wi-Fi 5.0GHz MTU 128Mb/s");
         lmtu.addItem("Wi-Fi 2.4GHz MTU 64Mb/s");
         lmtu.addItem("Doppino MTU 127Kb/s");
         //lmtu.setSelectedIndex(2);
         lmtu.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent ie) {
              tfCosto.setText(String.valueOf(100-((lmtu.getSelectedIndex()+1)*20)));
              indexType=lmtu.getSelectedIndex();
              
              switch(indexType){
                  
                  case 0:r.RigaTabellaRouting[riga].colorLink=new Color(230,145,0); break;  //colore giallo cromo per maggiore visibilità (caso FibraOttica)
                  case 1:  r.RigaTabellaRouting[riga].colorLink=Color.RED; break;
                  case 2: r.RigaTabellaRouting[riga].colorLink=Color.BLUE; break;
                  case 3: r.RigaTabellaRouting[riga].colorLink=Color.GREEN; break;
                  case 4: r.RigaTabellaRouting[riga].colorLink=Color.BLACK; break;
                          
              }
              
                     
           
                        r.RigaTabellaRouting[riga].IndirizzoDestinatario.RigaTabellaRouting[r.RigaTabellaRouting[riga].rigaDestinatario].colorLink=r.RigaTabellaRouting[riga].colorLink;
           
               
             
            
             
           
       
        
        
                  
                                   
                          
           }
        });

         
         JButton calcola = new JButton("Calcola");
         calcola.setSize(100,20);
        calcola.setLocation(199,200);
        calcola.setVisible(true);
       calcola.setLayout(null);
       
       calcola.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
            
                int peso=(int) (lmtu.getSelectedIndex()+1)*Integer.valueOf(tfLunghezza.getText() )/2 + Integer.valueOf(tfCosto.getText()) ;
                
              pesoEffettivo.setText(String.valueOf(peso));
              r.RigaTabellaRouting[riga].PesoTratta=peso;
              
              
              
              
              
              
              int nl=Main.WAN.nMaxLink;
        
        
        //aggiorno anche l'altro router
        for(int i=0;i<nl;i++){
            try{
           if(r.RigaTabellaRouting[riga].IndirizzoSorgente==r.RigaTabellaRouting[riga].IndirizzoDestinatario.RigaTabellaRouting[i].IndirizzoDestinatario && r.RigaTabellaRouting[riga].IndirizzoDestinatario==r.RigaTabellaRouting[riga].IndirizzoDestinatario.RigaTabellaRouting[i].IndirizzoSorgente){
               
           
           
               
               r.RigaTabellaRouting[riga].IndirizzoDestinatario.RigaTabellaRouting[i].PesoTratta=peso;
            
                i=nl;
               
           
        }}
           catch(Exception e){}
        }
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              try{
            
            p1.setVisible(false);
            
        }
        catch(Exception e){}
        

        r.RigaTabellaRouting[riga].IndirizzoDestinatario.pannelloTabellaDiRouting.aggiorna(r.RigaTabellaRouting[riga].IndirizzoDestinatario);
         r.pannelloTabellaDiRouting.aggiorna(r);
         r.pannelloTabellaDiRouting.setVisible(true);
         //si rende visibile da solo
         p1=r.pannelloTabellaDiRouting;
                
            }
        });
       
        this.add(calcola);
         
        
    }
    
    
    
    public void aggiorna(){
        tfLunghezza.setText( String.valueOf((int) Math.sqrt(     Math.pow(rd.getLocation().x-rs.getLocation().x,2)+ Math.pow(rd.getLocation().y-rs.getLocation().y,2))  )       );
        lmtu.setSelectedIndex(indexType);
        
    }
    

    
    
}
