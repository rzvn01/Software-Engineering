package lab5;

import java.util.Scanner;

/**Cacu Razvan GR-2023
 *Define a class called Vehicle which has as attributes the maximum number of passengers, its color and the maximum
 * speed. Extend the Vehicle class within the MotorizedVehicle class which also includes the geo-location attributes (GPS
 * coordonates – create a class for this type of object GeoLoc) and the moving speed of the vehicle. MotorizedVehicle can
 * move from point A to point B (the points are specified using a Point object which has two GeoLoc attributes) by using the
 * move(Point B) method and which returns the total duration of the trip.
 * Create a new class called Airplane which extends the MotorizedVehicle class and which add the attribute altitude to the
 * move(Point B) method. This method will return the time needed to take the trip by taking into account that the plane
 * will travel on arc of a circle specified through points A and B and the maximum altitude reached by the plane (the
 * maximum altitude is reached half-way between A and B).
 */
 class GeoLocation {
    private double latitude;
    private double longitude;

    public GeoLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}

 class Point {
    private GeoLocation start;
    private GeoLocation end;

    public Point(GeoLocation start, GeoLocation end) {
        this.start = start;
        this.end = end;
    }

    public GeoLocation getStart() {
        return start;
    }

    public GeoLocation getEnd() {
        return end;
    }
}

 class Vehicle {
    private int maxPassengers;
    private String color;
    private int maxSpeed;

    public Vehicle(int maxPassengers, String color, int maxSpeed) {
        this.maxPassengers = maxPassengers;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
}

 class MotorizedVehicle extends Vehicle {
    private GeoLocation location;
    private double movingSpeed;

    public MotorizedVehicle(int maxPassengers, String color, int maxSpeed, GeoLocation location, double movingSpeed) {
        super(maxPassengers, color, maxSpeed);
        this.location = location;
        this.movingSpeed = movingSpeed;
    }

    public double getMovingSpeed() {
        return movingSpeed;
    }

    public double move(Point destination) {
        GeoLocation start = destination.getStart();
        GeoLocation end = destination.getEnd();

        double distance = Math.sqrt(Math.pow(end.getLatitude() - start.getLatitude(), 2) + Math.pow(end.getLongitude() - start.getLongitude(), 2));
        double altitude = getMaxAltitude(start, end);
        double time = (distance / movingSpeed) + (altitude / getMaxSpeed());

        setLocation(end);

        return time;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    public double getMaxAltitude(GeoLocation start, GeoLocation end) {
        double earthRadius = 6371;
        double dLat = Math.toRadians(end.getLatitude() - start.getLatitude());
        double dLong = Math.toRadians(end.getLongitude() - start.getLongitude());
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(start.getLatitude())) * Math.cos(Math.toRadians(end.getLatitude())) *
                        Math.sin(dLong/2) * Math.sin(dLong/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = earthRadius * c;

        return (distance / 2.0) * Math.tan(Math.toRadians(45));
    }
}

 class Airplane extends MotorizedVehicle {
    private double altitude;

    public Airplane(int maxPassengers, String color, int maxSpeed, GeoLocation location, double movingSpeed, double altitude) {
        super(maxPassengers, color, maxSpeed, location, movingSpeed);
        this.altitude = altitude;
    }

     @Override
     public double move(Point destination) {
         GeoLocation start = destination.getStart();
         GeoLocation end = destination.getEnd();

         double halfwayLat = (start.getLatitude() + end.getLatitude()) / 2.0;
         double halfwayLong = (start.getLongitude() + end.getLongitude()) / 2.0;
         GeoLocation halfway = new GeoLocation(halfwayLat, halfwayLong);

         double altitude = getMaxAltitude(start, end);
         if (altitude < this.altitude) {
             this.altitude = altitude;
         }

         double time = getTravelTime(start, halfway) + getTravelTime(halfway, end);
         setLocation(end);

         return time;
     }

     private double getTravelTime(GeoLocation start, GeoLocation end) {
         double distance = Math.sqrt(Math.pow(end.getLatitude() - start.getLatitude(), 2) + Math.pow(end.getLongitude() - start.getLongitude(), 2));
         double time = distance / getMovingSpeed();

         return time;
     }

     public double getAltitude() {
         return altitude;
     }
 }

public class Lab5Prb7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting latitude:");
        double startLat = scanner.nextDouble();

        System.out.println("Starting longitude:");
        double startLong = scanner.nextDouble();

        System.out.println("Ending latitude:");
        double endLat = scanner.nextDouble();

        System.out.println("Ending longitude:");
        double endLong = scanner.nextDouble();

        GeoLocation start = new GeoLocation(startLat, startLong);
        GeoLocation end = new GeoLocation(endLat, endLong);
        Point destination = new Point(start, end);


        System.out.println("Maximum speed of the airplane:");
        int maxSpeed = scanner.nextInt();


        System.out.println("Maximum altitude of the airplane:");
        double altitude = scanner.nextDouble();

        Airplane airplane = new Airplane(123, "blue", maxSpeed, start, maxSpeed, altitude);

        double travelTime = airplane.move(destination);

        System.out.println("The travel time is " + travelTime + " hours.");
    }
}
