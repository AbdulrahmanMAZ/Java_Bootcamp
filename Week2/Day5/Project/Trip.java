package Project;


import java.time.LocalTime;

public abstract class Trip {

    private String tripNumber;
    private double distance;
    private double speed;
    private String startTime;

    private int stops = 0;
    private int stopDurationInMinutes = 0;


    public Trip() {
    }

    public Trip(String tripNumber, double distance, double speed, String startTime) {
        this.tripNumber = tripNumber;
        this.distance = distance;
        this.speed = speed;
        this.startTime = startTime;
    }

    public Trip(String tripNumber, double distance, double speed, String startTime, int stops, int stopDurationInMinutes) {
        this.tripNumber = tripNumber;
        this.distance = distance;
        this.speed = speed;
        this.startTime = startTime;
        this.stops = stops;
        this.stopDurationInMinutes = stopDurationInMinutes;
    }

    public String getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(String tripNumber) {
        this.tripNumber = tripNumber;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public abstract int calculateDuration();

    public Time convertMinToHour(int min){
        Time time = new Time(min/60,min%60);

        return time;
    }

    public Time convertHourToMin(double hour){
        Time time = new Time(0, (int)(60*hour));

        return time;
    }

    public  String calculateArrivalTime(){
        LocalTime currentTime = LocalTime.parse(this.startTime);

        double timeNeeded = calculateTimeNeeded();

//        timeNeeded = hasForecast ? timeNeeded*1.1 : timeNeeded;


        Time converted = convertHourToMin(timeNeeded);


        currentTime = currentTime.plusMinutes(converted.minutes);

        return currentTime.toString();
    }

    public double calculateTimeNeeded(){

        double timeNeededInHours = distance/speed;

        if (stops != 0){
            timeNeededInHours += (stops*(stopDurationInMinutes/60.0));
        }

        return timeNeededInHours;
    }

    public void display(){

        System.out.println("The trip starts at: "+ startTime);
        System.out.println("We will be moving at a speed of: "+speed+" km/h");
        System.out.println("The whole distance is: "+ distance+" km");
        System.out.println("We will be arriving at: "+ calculateArrivalTime());
    }



}
