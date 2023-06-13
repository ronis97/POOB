import java.time.LocalDateTime;
public class Message {
    private int id;
    private String text;
    private LocalDateTime date;
    private boolean read;
    private User sender;
    private File file;
    public int getId(){
        return id;
    }
    public boolean getRead(){
        return read;
    }
    public boolean deleteMessage(){
        file = null;
        if (!this.read) return true;
        return false;
    }
}
