package aplicacion;

import java.util.*;

public class Sistema {
    private ArrayList<Troncal> troncales;
    private HashMap<String,Estacion> estaciones;
    private ArrayList<Ruta> rutas;
    public int tiempoEsperaEstacion(String estacion){
        return estaciones.get(estacion).getNivelOcupacion();
    }
    public ArrayList<String> nombreEstaciones(String nombre){
        ArrayList<String> estacionesOrdenadas = new ArrayList<String>();
        for(String i: estaciones.keySet()){
            estacionesOrdenadas.add(i);
        }
        Collections.sort(estacionesOrdenadas);
        return estacionesOrdenadas;
    }
    public int numeroParadasConRuta(String nomRuta, String nomEstacion1, String nomEstacion2){
        Ruta ruta = getRuta(nomRuta);
        return ruta.getParadas(nomRuta,nomEstacion1, nomEstacion2);
    }
    public Ruta getRuta(String ruta){
        Ruta solicitada = null;
        for (Ruta i: rutas){
            if (i.getNombre().equals(ruta)) solicitada = i;
        }
        return solicitada;
    }
    public boolean desplazarSinTransbordos(String nomEstacion1, String nomEstacion2){
        return false;
    }
    public boolean desplazarConTransbordos(String nomEstacion1, String nomEstacion2){
        return  false;
    }
    public String[][] tiempoPlanRuta(){
        return null;
    }
    public ArrayList<Estacion> mejorPlanDesplazamiento(String nomEstacion1,String nomEstacion2){
        return null;
    }
}
