/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packetrouting;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import java.awt.event.ActionEvent;


import java.util.Random;




import javax.swing.JButton;

import javax.swing.JPanel;



class WAN extends JPanel {
   public static int name=65; //65
   public static boolean link=false;
   public static boolean send=false;
   public static DraggedRouter DRL=new DraggedRouter(); 
      public static LinkRouter LLR=new LinkRouter();
         public static ActionRouter ARL=new ActionRouter(); 
      public static JButton linkB=new JButton("link");
      public static JButton sendB=new JButton("apo");
      public static JButton deleteB=new JButton("X");
      public static int nMaxLink=100;
      
    WAN(){
        
        
        
        this.setSize(1300,1000);
        this.setVisible(true);
        this.setLayout(null);
        this.setBackground(new Color(245, 245, 220));
     
        
        
      
        
       
        
        
        
        
        linkB.setSize(100,50);
        linkB.setLocation(700,850);
        linkB.setVisible(true);
        linkB.setLayout(null);
        linkB.setBackground(Color.green);
        linkB.addActionListener((ActionEvent ae) -> {
            if(!Main.WAN.link){
                Main.WAN.link=true;
                Main.WAN.linkB.setBackground(Color.red);}
        });
        this.add(linkB); 
        
        sendB.setSize(100,50);
        sendB.setLocation(200,850);
       sendB.setVisible(true);
        sendB.setLayout(null);
        sendB.setBackground(Color.green);
        sendB.addActionListener((ActionEvent ae) -> {
            if(!Main.WAN.send){
                Main.WAN.send=true;
                Main.WAN.sendB.setBackground(Color.red);
                Main.WAN.sendB.setText("send");}
                
            
        });
        
        deleteB.setSize(50,50);
        deleteB.setLocation(150,850);
       deleteB.setVisible(false);
        deleteB.setLayout(null);
        deleteB.setBackground(Color.green);
        deleteB.addActionListener((ActionEvent ae) -> {
            
            Main.WAN.percorsoMinore=new Router[50];
        Main.WAN.percorsoMinore2=new Router[50];
        Main.WAN.percorsoMinore3=new Router[50];

        Main.WAN.h=0;
        Main.WAN.h2=0;
        Main.WAN.h3=0;    
        
        LinkRouter.pannelloDijkstra.setVisible(false);
        deleteB.setVisible(false);
        
        
                
            
        });
        
        
        
        
        this.add(sendB);  
        this.add(deleteB);
        this.setFocusable(true);
        
        this.addKeyListener(new SendLinkListener());
        
    }
    
 
   public static int nR=0;
   
 public static  Router[] Router =new Router[100];
    

public void inserisci(Router r){

    
   
   

 this.add(r);
 r.addActionListener(LLR);
 Router[nR]=r;
 nR++;
       
       
       
       
      
    
}

int al1=0;
int al2=0;
Random RND =new Random();

public boolean Link(Router r1,Router r2,int weight){
    if (r1.alreadyLink==nMaxLink-1 || r2.alreadyLink==nMaxLink-1)
        return false;
    
     
    
    int peso2=RND.nextInt(200);
   
    int distanzaPuntoPunto=(int) Math.sqrt(     Math.pow(r2.getLocation().x-r1.getLocation().x,2)+ Math.pow(r2.getLocation().y-r1.getLocation().y,2)); 
    int costo=100-(4+1)*20;
    
    int peso=(4+1)*(distanzaPuntoPunto/2)+costo;
    
    for(int al=0;al<nMaxLink;al++){
        
        if(r1.RigaTabellaRouting[al]==null){
        
            al1=al;

            
            
            r1.RigaTabellaRouting[al]=new RigaTabellaDiRouting(r1.name,r1,r2,peso);
            r1.RigaTabellaRouting[al].dataLabel=new LabelRigaTabellaRouting("<html> <br>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+  r1.RigaTabellaRouting[al].IndirizzoSorgente.name + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + r1.RigaTabellaRouting[al].IndirizzoDestinatario.name + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + r1.RigaTabellaRouting[al].PesoTratta, r1,r1.RigaTabellaRouting[al].IndirizzoDestinatario,al );
           
          r1.RigaTabellaRouting[al].dataLabel.setVisible(true);
          r1.RigaTabellaRouting[al].dataLabel.setLayout(null);
          r1.RigaTabellaRouting[al].dataLabel.setSize(300,30);
            
        
        al=nMaxLink;    
         r1.alreadyLink++;
        }
        
        }
    
    for(int al=0;al<nMaxLink;al++){
        if(r2.RigaTabellaRouting[al]==null){
            
           al2=al; 
           
            r2.RigaTabellaRouting[al]=new RigaTabellaDiRouting(r2.name,r2,r1,peso);
            r2.RigaTabellaRouting[al].dataLabel=new LabelRigaTabellaRouting("<html> <br>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+  r2.RigaTabellaRouting[al].IndirizzoSorgente.name + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + r2.RigaTabellaRouting[al].IndirizzoDestinatario.name + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + r2.RigaTabellaRouting[al].PesoTratta, r2,r2.RigaTabellaRouting[al].IndirizzoDestinatario,al );
            
            
            r2.RigaTabellaRouting[al].dataLabel.setVisible(true);
          r2.RigaTabellaRouting[al].dataLabel.setLayout(null);
          r2.RigaTabellaRouting[al].dataLabel.setSize(300,30);
            
            
            r2.alreadyLink++;
            
          
            al=nMaxLink; 
        }
        }
    
    
    r1.RigaTabellaRouting[al1].rigaDestinatario=al2;
    r2.RigaTabellaRouting[al2].rigaDestinatario=al1;
    
    
   try{
      LinkRouter.p1.setVisible(false);
     
      
              
   }
   catch(Exception e){}
    r1.pannelloTabellaDiRouting.aggiorna(r1);
      r1.pannelloTabellaDiRouting.setVisible(true);
      
      LinkRouter.p1=r1.pannelloTabellaDiRouting;
      
      r2.pannelloTabellaDiRouting.aggiorna(r2);
   
   
    return true;
    
  
    
}
            
Router[] percorsoMinore2=new Router[50];
Router[] percorsoMinore3=new Router[50];
int pesoMinore3=2147483647;
int pesoMinore2=2147483647;
int h2=0;
int h3=0;  //Contatore Lunghezza VETTORE per Disegnare..


Router[] percorsoMinore=new Router[50];
Router[] percorsoHop=new Router[50];

int pesoMinore=2147483647;
int pesoLink;
int pesoPercorso;
int h=0;
int nPercorsi=0;
int nSalto=-1;
 boolean check=true;
public void Dijkstra(Router R1,Router R2){ // Algoritmo del percorso minore, in realtà il nome Dijkstra è errato
   
    
    nSalto++;
    if(R1==R2){
        
      nPercorsi++;
        
        sendB.setText(String.valueOf(nPercorsi));
        System.out.println(" ");
      for(int a=0;a<nSalto;a++)
          System.out.print(percorsoHop[a].name+ " " );
          System.out.print (pesoPercorso);
         System.out.println(" ");
      
       
        if(pesoPercorso<pesoMinore){   //Trovato ipotetico percorso con peso minore
          
            
            
            for(int i=0;i<h2;i++)
            percorsoMinore3[i]=percorsoMinore2[i];   //traslo il primo indirizzo gia esistente in p2
            
            
            for(int i=0;i<h;i++)
            percorsoMinore2[i]=percorsoMinore[i];  //traslo in secondo in p3
            
            
            
            pesoMinore3=pesoMinore2;
            pesoMinore2=pesoMinore;
            h3=h2;
            h2=h;
            
            
            
            
            pesoMinore=pesoPercorso;
            h=nSalto;
            
          for(int i=0;i<nSalto;i++)
            percorsoMinore[i]=percorsoHop[i];
        
        }
       
        else if(pesoPercorso<pesoMinore2){   //come su.. traslo da p2 a p3 e inserisco ph in p2
          
            
            for(int i=0;i<h2;i++)
            percorsoMinore3[i]=percorsoMinore2[i];
            
            pesoMinore3=pesoMinore2;
            h3=h2;
            
            
            
            pesoMinore2=pesoPercorso;
            h2=nSalto;
           
        for(int i=0;i<nSalto;i++)
            percorsoMinore2[i]=percorsoHop[i];
        
        }
        
        
        
        
       
     else   if(pesoPercorso<pesoMinore3){   
            
            pesoMinore3=pesoPercorso;
            h3=nSalto;

            for(int i=0;i<nSalto;i++)
            percorsoMinore3[i]=percorsoHop[i];
            
            
        
        }
         
         
       
        
     
        
        
        
        
        
        
     Main.WAN.sendB.setText("Success!");
     return;
    }
    
    
    if(nSalto==0){
        
        
     percorsoHop[nSalto]=R1;
     nSalto++;
        
    }
    
    
    
    for(int al=0;al<R1.alreadyLink;al++){
        check=true;
        if(R1.RigaTabellaRouting[al] ==null) {
        } else {
            
          
              
              for(int a=0;a<nSalto;a++){
                  if(R1.RigaTabellaRouting[al].IndirizzoDestinatario==percorsoHop[a])
                      check=false;}
              
              if(check){
              
              pesoLink=R1.RigaTabellaRouting[al].PesoTratta;
              percorsoHop[nSalto]=R1.RigaTabellaRouting[al].IndirizzoDestinatario;
              pesoPercorso+=pesoLink;
              
              Dijkstra(percorsoHop[nSalto],R2);
              
              nSalto--;
              percorsoHop[nSalto]=null;
              pesoPercorso-=R1.RigaTabellaRouting[al].PesoTratta;
                      }}}
   
    
    
}


   @Override
    public void paintComponent(Graphics g1){
      super.paintComponent(g1);
     
      Graphics2D g=(Graphics2D) g1;
     
      g.setStroke(new BasicStroke(1));
      g.setColor(Color.green);
     
      
    g.drawLine(0,800,970,800);   //VARIE LINEE GUIDA GUI
    g.drawLine(825,800,825,1000);
    g.drawLine(970,0,970,1000);
      
  Point p1=null;
  Point p2=null;
    

g.setColor(Color.black);  //COLORE DI DEFAULT.. DOPPINO
  for(int a=0;a<nR;a++){                    //DISEGNO I COLLEGAMENTI
      for(int b=0;b<nMaxLink;b++){
          if(Router[a].RigaTabellaRouting[b]!=null){
              try{
              g.setColor(Router[a].RigaTabellaRouting[b].colorLink);
              }
              catch(Exception e){}
  p1=  Router[a].getLocation();
  p2=  Router[a].RigaTabellaRouting[b].IndirizzoDestinatario.getLocation();   
      
 

  g.drawLine(p1.x+25,p1.y+25,p2.x+25,p2.y+25);
      

}  
} 
}
  

  for(int a=0;a<h3-1;a++){   //DISEGNO IL PERCORSO MINORE  33

  p1=  percorsoMinore3[a].getLocation();
  p2=  percorsoMinore3[a+1].getLocation();
 
  
  
 
  g.setStroke(new BasicStroke(3));
  g.setColor(Color.ORANGE);
  
  g.drawLine(p1.x+32,p1.y+32,p2.x+32,p2.y+32);
  

    
}
  

 for(int a=0;a<h2-1;a++){   //DISEGNO IL PERCORSO MINORE 2

  p1=  percorsoMinore2[a].getLocation();
  p2=  percorsoMinore2[a+1].getLocation();
 
  
  
 
  g.setStroke(new BasicStroke(3));
  g.setColor(Color.blue);
  
  g.drawLine(p1.x+18,p1.y+18,p2.x+18,p2.y+18);
  

    
}
 
 
  
 
  
  
  
  for(int a=0;a<h-1;a++){   //DISEGNO IL PERCORSO MINORE 1

  p1=  percorsoMinore[a].getLocation();
  p2=  percorsoMinore[a+1].getLocation();
 
  
  
 
  g.setStroke(new BasicStroke(6));
  g.setColor(Color.RED);
  
  g.drawLine(p1.x+25,p1.y+25,p2.x+25,p2.y+25);
  

    
}
 
 
 
   setOpaque(true);
   repaint();
  
   
}
    
    public void openField(){
        Router r=new Router(Character.toString((char) name));
        name++;
         r.setSize(50,50);
        r.setLocation(835,810);
        r.setVisible(true);
        r.setLayout(null);
        r.addMouseMotionListener(DRL);
        r.addMouseListener(ARL);
        
        this.add(r);  
        
    }
 
    }