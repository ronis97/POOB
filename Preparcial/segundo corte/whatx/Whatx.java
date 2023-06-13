import java.util.*;
import java.time.LocalDate;
public class Whatx {
    private ArrayList<Chat> chats;
    
    public void tag(ArrayList<Tag> tags){
        try{
            for(Chat c: chats){
                c.tag(tags);
            }
        }
        catch (Exception WhatxException){
            
        }
    }
    public ArrayList<User> findUsersByTagName(String tagName,LocalDate startDate, 
    LocalDate endDate) throws WhatxException{
        try{
        ArrayList<User> usuarios = new ArrayList<User>();
        if (startDate.compareTo(LocalDate.now()) > 0 && 
            endDate.compareTo(LocalDate.now()) > 0) 
            throw new WhatxException(WhatxException.FUTURE_DATES);
        if (startDate.compareTo(endDate) < 0) throw new WhatxException(WhatxException.START_BEFORE_END);
        for (Chat i: chats){
            if (!i.tagIntags(tagName)) throw new WhatxException(WhatxException.NO_TAG);
            else{
                ArrayList<User> added = i.getmembers();
                for (User j: added){
                    usuarios.add(j);
                }
            }
        }
        return usuarios;
    }
    catch (Exception WhatxException){
        return null;
    }
   
    }
}

/**
 * Conceptos
 * Clase abstracta: clase que declara la existencia de métodos pero no 
 * la implementacion de dichos metodos. A diferencia de las interfaces, estas clases
 * alguno de los metodos debe tener implementacion y puede contener variables no estaticas.
 * Metodo default en una interfaz son metodos que tienen implementacion en la interfaz y estos estaran
 * en las clases que implementen la interfaz sin haberlos implementado en estas.
 * Nota esperada: 3.0
 * 
 * 
 * 
 * 
 */
