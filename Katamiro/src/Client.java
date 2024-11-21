import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * In this class we put basic information about the customer. The most important
 * thing is the time it takes for a waiter to process it
 */
public class Client  {
    private String name;
    private int attention_time;
    private boolean atendido = false;

    /**
     * Default Constructor. Maybe we remove it in future
     */
    public Client() {

    }

    /**
     * The Main Constructor
     * @param name
     */
    public Client(String name) {
        this.name = name;
        this.attention_time = ThreadLocalRandom.current().nextInt(3000, 8000 + 1);
    }

    /**
     * Getter name
     * @return name, String which contains the name of the client
     */
    public String getClientName() {
        return name;
    }

    /**
     * Setter name
     * @param
     */
    public void setAtendido(){
        this.atendido = true;
    }
    public void setClientName(String name) {
        this.name = name;
    }

    /**
     *
     * @return attention_time, the waiter is going to wait this amount of time
     */
    public int getAttention_time() {
        return attention_time;
    }

    /**
     * Setter attention_time
     * @param attention_time
     */
    public void setAttention_time(int attention_time) {
        this.attention_time = attention_time;
    }


}
