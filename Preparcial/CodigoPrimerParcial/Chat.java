import java.util.ArrayList; 

public class Chat {
    private String name;
    private String description;
    private ArrayList<User> members;
    private ArrayList<Message> messages;
    public String getName(){
        return name;
    }
    /**
     * Borra el mensaje solicitado
     * @param int msgId el ID del mensaje que se va a eliminar
     * @return boolean si el mensaje ha sido borrado o no
     */
    public boolean deleteMessage(int msgId){
        Message msg = findMessage(msgId);
        if (msg != null && !msg.getRead())
        {
            name = "Este mensaje se ha eliminado";
            description = "Este mensaje se ha eliminado";
            return true;
        }
        return false;
    }
    /**
     * Encuentra el mensaje dado el ID
     * @param String int el ID del mensaje
     * @return Chat el objeto Message, este es nulo si no encontro el mensaje
     */
    public Message findMessage(int msgId){
        for(Message i: messages){
            if (i.getId() == msgId) return i;
        }
        return null;
    }
    public ArrayList<User> getMembers(){
        return members;
    }
}
