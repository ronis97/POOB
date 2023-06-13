import java.util.ArrayList; 

public class Chat extends Taggable{
    private String name;
    private String description;
    private ArrayList<User> members;
    private ArrayList<Message> messages;
    /**
     * Associate elements to business tags
     * @Param tags ArrayList of tags
     * @throws WhatxException NO_TAGS tags list is empty
     * @throws WhatxException TAGGED the user is already associated with some tag
     * @throws WhatxException INCOMPLETE_INFORMATION any tags don’t have complete information
     * @throws WhatxException NO_MEMBERS chat doesn’t have any members
     */
    public void tag(ArrayList<Tag> tags) throws WhatxException{
        if (tags.size() == 0) throw new WhatxException(WhatxException.NO_TAGS);
        if (super.verificarTag(tags)) throw new WhatxException(WhatxException.TAGGED);
        if (!super.validTag()) throw new WhatxException(WhatxException.INCOMPLETE_INFORMATION);
        if (members.size() == 0) throw new WhatxException(WhatxException.NO_MEMBERS);
        super.tag(tags);
    }
    
    public ArrayList<User> getmembers(){
        return members;
    }
}
