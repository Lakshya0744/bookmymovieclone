public class Runway {
    int id;
    String planeType;
    private boolean isAvailable;
    double x;
    double y;

    public Runway(int id, String planeType, double x, double y){
        this.id = id;
        this.planeType = planeType;
        this.isAvailable = true;
        this.x = x;
        this.y = y;
    }
    public boolean bookRunway(String planeType){
        if(!planeType.equals(this.planeType)){
            return false;
        }
        if(isAvailable){
            isAvailable = false;
        }
        return !isAvailable;
    }
    public void unbookRunway(){
        isAvailable = true;
    }
    public boolean getAvailability(){
        return isAvailable;
    }
}
