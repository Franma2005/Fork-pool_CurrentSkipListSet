import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Kitchen is a class who management
 */
public class Kitchen {
    private String kitchenName;
    private Queue<Client> colaClientes;

    /**
     * Default constructor
     */
    public Kitchen() {
        colaClientes = new ConcurrentLinkedQueue<>();
    }

    /**
     * Main constructor
     * @param kitchenName
     */
    public Kitchen(String kitchenName) {
        this.kitchenName = kitchenName;
        colaClientes = new ConcurrentLinkedQueue<>();
    }

    /**
     * Method which allow us to add client to the queue
     * @param client
     */
    public void addCliente(Client client) {
        colaClientes.add(client);
    }

    /**
     * Method which allow us to obtain the first client in the queue
     */
    public Client attendCliente() {
        return colaClientes.poll();
    }

    /**
     * Getter of kitchenName
     * @return kitchenName
     */
    public String getKitchenName() {
        return kitchenName;
    }

    /**
     * Setter of kitchenName
     * @param kitchenName
     */
    public void setKitchenName(String kitchenName) {
        this.kitchenName = kitchenName;
    }

}
