/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packetrouting;

import javax.swing.JFrame;

/**
 *
 * @author Alessandro
 */
public class Main {

public static JFrame f1;
public static WAN WAN;
    public static void main(String[] args) {
        
         WAN=new WAN();
         WAN.openField();
         f1=new JFrame("PacketRouting, developed by Alessandro Amedei in Italy, v2.0 ");
         
         f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
         f1.setSize(1300,1000);
         f1.setVisible(true);
         f1.setLayout(null);
         f1.add(WAN);
         f1.addKeyListener(new SendLinkListener());
    }

  
    
}
//xAlessandro Amedei 27/04/2015 23.16 Il programma inizia a prendere forma. Dijkstra funzionante; Eliminazione collegamento da guardare
          // Eliminazione router da fare. Possibilità di inserire peso manualmente da fare.. alessandroAmedei x


//xAlessandro Amedei 28/04/2015 17.16 Perfetto il programma funziona completamente. Implementare la visualizzazione del peso del percorso minore etc.etc. x

//xAlessandro Amedei 29/04/2015 13.01 Il programma va.. Mi sono accorto che i 3 percorsi gli trova male perchè uno sovrappone l'altro. Da gegisre in WAN.Dijkstra il percorso migliore,il terzo e così via..

//29-04-2015 2..

// xAlessandro Amedei 02/05/2015 Ok.. Da migliorare.. Se rieseguo il click sul router mi deve aggiornare la tabella non ricrearmela! Perdo tutte le informazioni

//xAlessandro Amedei 03/05/2015 Ok.. Aggiunta la possibilità di salvare le informazioni dei collegamenti.... NON FUNZIONA IL CANCELLAMENTO DEL LINK! RIPETE L'ACTION LISTENER TRE VOLTE! (DELETE LINK.CLASS)

//xAlessandro Amedei 05/05/2015 Allora..Piccolo problema che dopo aver inviato un pacchetto, a volte, premo su un router e o non mi fa visualizzare la sua tabella oppure me ne visualizza un'altra.. 
                          //Presumo che ci siano problemi di gestione con il linkP1 ovvero il gestore del pannello visibile. Sempre il problema dell'actionlistener che lo ripete due volte.. Risolto "momentaneamente" (?) CON
                             // un TRY CATCH.. x


//xAlessandro Amedei 12/05/2015.. Può essere considerato programma FINALE. AGG A 1.0 no Beta.. RIsolto il problema della visualizzazione pannello di routing (mettevo a setvisible sia pannello destinatario che sorgente in configurazione LINK).. Aggiunto pulsante per cancellare l'algoritmo e il pannello di dikstra visualizzatox.vivalavida
