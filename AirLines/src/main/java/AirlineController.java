import java.util.ArrayList;

public class AirlineController {
    ArrayList<Runway> availableRunways;

    private void computeAvailableRunways(String plainType){
        ArrayList<Runway> allRunways = RunwayRegistry.register.get(plainType);
        availableRunways = new ArrayList<>();
        for(Runway r : allRunways){
            if(r.getAvailability()){
                availableRunways.add(r);
            }
        }
    }
    public Runway getNearestRunway(double cordX, double cordy, String plainType){
        computeAvailableRunways(plainType);
        double nearest = Double.MAX_VALUE;
        Runway toBeAssigned = null;
        for(Runway r : availableRunways){
            double distance = Math.sqrt(Math.pow(cordX-r.x, 2) + Math.pow(cordy-r.y, 2));
            if(nearest>distance){
                nearest = distance;
                toBeAssigned = r;
            }
        }
        toBeAssigned.bookRunway(plainType);
        return toBeAssigned;
    }
    public void unassignRunway(Runway r){
        r.unbookRunway();
    }
}
