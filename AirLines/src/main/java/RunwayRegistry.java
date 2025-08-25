import java.util.ArrayList;
import java.util.HashMap;

public class RunwayRegistry {

    public static HashMap<String, ArrayList<Runway>> register = new HashMap<>();
    public static void registerRunway(Runway runway){
        if(!register.containsKey(runway.planeType)){
            register.put(runway.planeType, new ArrayList<>());
        }
        register.get(runway.planeType).add(runway);
    }
}
