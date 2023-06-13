package aplicacion;
import java.util.*;
import java.awt.Color;

public class Artico{
    public static final int MAXIMO = 500;
    private static Artico polo = null;

    public static Artico demeArtico() {
        if (polo==null){
            polo=new Artico();
        }
        return polo;
    }

    private static void nuevoArtico() {
        polo=new Artico();
    }   

    public static void cambieArtico(Artico a) {
        polo=a;
    }       

    private ArrayList<EnArtico> elementos;
    private int poloNorteX;
    private int poloNorteY;
    private boolean enPoloNorte;
    private Esquimal aaju, alek;
    private EsquimalSordo aguu, ivanna;
    private EsquimalExplorador nanuk, sialuk;
    private EsquimalPrincipiante ronaldo, cesar;
    private Color color = Color.GREEN;
    private Iglu iglu;
    private Refugio refugio;

    public Artico() {
        elementos= new ArrayList<EnArtico>();
        poloNorteX = (int)(Math.random() * MAXIMO);
        poloNorteY = (int)(Math.random() * MAXIMO);
        enPoloNorte=false;
    }

    public void algunosEnArtico(){
        Esquimal aaju = new Esquimal(this, "aaju", 300, 300);
        Esquimal alek = new Esquimal(this, "alek", 300, 100);
        adicione(aaju);
        adicione(alek);
    }  
    
    public void algunosEnArticoSordos(){
        aguu = new EsquimalSordo(this, "aguu", 200, 400, Color.GREEN);
        ivanna = new EsquimalSordo(this, "ivanna", 200, 100, Color.GREEN);
        elementos.add(aguu);
        elementos.add(ivanna);
    } 
    
    public void algunosEnArticoExplorador(){
        nanuk = new EsquimalExplorador(this, "nanuk", 50, 300, Color.RED, elementos);
        sialuk = new EsquimalExplorador(this, "sialuk", 50, 100, Color.RED, elementos);
        elementos.add(nanuk);
        elementos.add(sialuk);
    }
    
    public void iglus(){
        iglu = new Iglu(this, "InferiorIzquierda",0, 0);
        iglu = new Iglu(this, "InferiorDerecha ",500, 0);
        iglu = new Iglu(this, "SuperiorDerecha",500, 500);
        iglu = new Iglu(this, "SuperiorIzquierda",0,500);
        elementos.add(iglu);
        elementos.add(iglu);
        elementos.add(iglu);
        elementos.add(iglu);
    }
    
    public void algunosEnArticoPrincipiante(){
        ronaldo = new EsquimalPrincipiante(this, "ronaldo", 150, 0, Color.BLUE);
        cesar = new EsquimalPrincipiante(this, "cesar", 300, 80, Color.BLUE);
        elementos.add(ronaldo);
        elementos.add(ronaldo);
    }
    
    public void refugio(){
        refugio = new Refugio(this, "refugio", 80, 60);
        elementos.add(refugio);
    }

    public EnArtico demeEnArtico(int n){
        EnArtico h=null;
        if (1<=n && n<=elementos.size()){
            h=elementos.get(n-1);
        }    
        return h; 
    }

    
    public void adicione(EnArtico e){
        elementos.add(e);
    }

    public int numeroEnArtico(){
        return elementos.size();
    }

    public boolean enPoloNorte(EnArtico e){
        boolean ok=(poloNorteX==e.getPosicionX() && poloNorteY==e.getPosicionY());
        enPoloNorte = enPoloNorte || ok;
        return enPoloNorte;
    }     
    
    public void accion(){
        for (EnArtico i: elementos){
            i.accion();
        }
    }

    public void improvisen()
    {
        for(EnArtico i : elementos)
        {
            if(i instanceof Esquimal)
            {
                i.improvise();
            }
            else
            {
                i.improvise();
            }
            
        }
    }   

    public void corten(){
        for (EnArtico i: elementos){
            i.corte();
        }
    }  
}
