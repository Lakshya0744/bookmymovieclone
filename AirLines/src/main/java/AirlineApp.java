
//Design a system to manage the assignment of runways to planes for landing and takeoff at an
//        airport.
//        Requirements:
//        1. 2. 3. 4. The system should assign runways to planes based on:
//        ○
//        The plane type (e.g., commercial, cargo, private, military).
//        ○
//        The nearest available runway that supports the plane type.
//        A plane can request a runway for both landing and takeoff.
//        The system should handle multiple planes and runways simultaneously while ensuring
//        efficiency and avoiding conflicts.
//        Introduce runway maintenance schedules, ensuring planes are not assigned to closed
//        runways.
//        Bonus:
//        ●
//        ●
//        Implement a way to prioritize emergency landings, overriding standard runway
//        assignments if needed.
//        Optimize the runway allocation strategy to minimize wait times and maximize airport
//        throughput.
//        Test Cases
//        1. Basic Runway Assignment
//        Test Case: Assign a runway to a commercial plane requesting landing.
//        ●
//        ●
//        Input: Plane Type = Commercial, Available Runways = [Runway A (supports
//        Commercial, Cargo)]
//        Expected Output: Runway A assigned for landing.
//        Test Case: Assign a runway to a cargo plane requesting takeoff.
//        ●
//        ●
//        Input: Plane Type = Cargo, Available Runways = [Runway B (supports Cargo, Military)]
//        Expected Output: Runway B assigned for takeoff.
//        2. Runway Occupancy Handling
//        Test Case: Requesting a runway when all are occupied.
//        ●
//        Input: Plane Type = Commercial, Available Runways = [Runway A (Occupied), Runway
//        B (Occupied)]
//        ●
//        Expected Output: Plane placed in a waiting queue or redirected.
//        Test Case: Assigning a runway when a plane just finished using it.
//        ●
//        ●
//        Input: Plane Type = Military, Runway A becomes free after previous takeoff.
//        Expected Output: Runway A assigned to the next waiting military plane.
//        3. Maintenance Handling
//        Test Case: Runway is under maintenance and should not be assigned.
//        ●
//        ●
//        Input: Plane Type = Cargo, Available Runways = [Runway A (Under Maintenance),
//        Runway B (Supports Cargo)]
//        Expected Output: Runway B assigned, Runway A ignored.
//        4. High-Traffic Scenario
//        Test Case: Multiple planes requesting takeoff and landing at the same time.
//        ●
//        ●
//        Input: 5 planes requesting landing, 3 requesting takeoff, 3 available runways.
//        Expected Output: Efficient scheduling ensuring minimal wait time
//        Full question
//


public class AirlineApp {
    public static void main(String [] args){
        Runway r1 = new Runway(1, "Cargo", 1.0, 1.0);
        Runway r2 = new Runway(2, "Military", 1.0, 3.5);
        Runway r3 = new Runway(3, "Commercial", 6.0, 5.5);
        Runway r4 = new Runway(4, "Private", 6.0, 14);
        Runway r5 = new Runway(5, "Cargo", 3.0, 1.0);
        Runway r6 = new Runway(6, "Military", 1.0, 3.5);
        Runway r7 = new Runway(7, "Commercial", 15.0, 10.0);
        Runway r8 = new Runway(8, "Private", 25.0, 5.0);

        RunwayRegistry.registerRunway(r1);
        RunwayRegistry.registerRunway(r2);
        RunwayRegistry.registerRunway(r3);
        RunwayRegistry.registerRunway(r4);
        RunwayRegistry.registerRunway(r5);
        RunwayRegistry.registerRunway(r6);
        RunwayRegistry.registerRunway(r7);
        RunwayRegistry.registerRunway(r8);

        Plane plane1 = new Plane("Military", 1);
        Plane plane2 = new Plane("Commercial", 2);
        Plane plane3 = new Plane("Private", 3);
        Plane plane4 = new Plane("Cargo", 4);
        Plane plane50 = new Plane("Military", 50);

        AirlineController airlineController = new AirlineController();
        Runway nearestRunway = airlineController.getNearestRunway(300, 10000, plane1.planeType);
        System.out.println(nearestRunway.id);
        Runway nearestRunway2 = airlineController.getNearestRunway(700, 20000, plane1.planeType);
        System.out.println(nearestRunway2.id);

    }

}
