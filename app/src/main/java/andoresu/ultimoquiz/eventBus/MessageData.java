package andoresu.ultimoquiz.eventBus;

/**
 * Created by dell on 16/05/2016.
 */
public class MessageData {

    public final String name;
    public final String lastName;

    public MessageData(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    public String getFullname(){
        return this.name + " " + this.lastName;
    }
}
