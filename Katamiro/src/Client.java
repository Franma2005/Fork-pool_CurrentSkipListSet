import java.util.concurrent.ThreadLocalRandom;

public class Client{
    private String name;
    private int attention_time;

    public Client() {
    }

    public Client(String name) {
        this.name = name;
        this.attention_time = ThreadLocalRandom.current().nextInt(3000, 25000 + 1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttention_time() {
        return attention_time;
    }

    public void setAttention_time(int attention_time) {
        this.attention_time = attention_time;
    }

}
