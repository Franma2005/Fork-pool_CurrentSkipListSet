import java.util.ArrayList;
import java.util.Random;

public class Funciones {
    public static Kitchen getRandomList(ArrayList<Kitchen> list){
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
