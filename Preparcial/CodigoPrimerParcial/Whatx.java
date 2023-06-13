import java.util.*;
/**
 * Invariante del metodo
 * El arrayList de chats no puede estar vacio
 * 
 */
public class Whatx {
    private ArrayList<Chat> chats;
    private User owner;
    private Socket socket;
    public boolean deleteMessage(String chatName, int msgId){
        Chat chat = findChat(chatName);
        if (chat != null){
            boolean deleted = chat.deleteMessage(msgId);
            if (deleted){
                ArrayList<User> members = chat.getMembers();
                for (User i: members){
                    String toPhone = i.getPhone();
                    socket.deleteMessage(toPhone, chatName, msgId);
                }
                return true;
            }
        }
        return false;
    }
    /**
     * Encuentra el chat dado el nombre
     * @param String chatName el nombre del chat
     * @return Chat el objeto Chat, este es nulo si no encontro el chat
     */
    public Chat findChat(String chatName){
        for (Chat i: chats){
            if (i.getName().equals(chatName)) return i;
        }
        return null;
    }
}
/**
 * Conceptos
 * Principios SOLID
 * S (Principio de unica responsabilidad) En la cual le asignamos a una clase una unica razon para
 * cambiar. En nuestro cada clase conoce sus propios metodos y observamos que diferimos la responsabilidad
 * del metodo grande a otros metodos en las otras clases. 
 * 
 * El modificador de acceso puede ser public, protected, private o default, se utiliza para restringir
 * los alcances de clases, metodos o variables. Esto es para proteger informacion de su uso en otros alcances.
 * 
 * El modificador de mutabilidad es final, y este se usa para determinar si un metodo o variable
 * es modificable dentro de la ejecucion del codigo
 * 
 * 
 * 
 * 
 */
