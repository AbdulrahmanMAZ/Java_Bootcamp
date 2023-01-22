package Project;

public class Car extends Trip {


    public Car() {
    }

    public Car(String tripNumber, double distance, double speed, String startTime) {
        super(tripNumber, distance, speed, startTime);
    }

    public Car(String tripNumber, double distance, double speed, String startTime, int stops, int stopDurationInMinutes) {
        super(tripNumber, distance, speed, startTime, stops, stopDurationInMinutes);
    }

    @Override
    public int calculateDuration() {
        double hours = this.calculateTimeNeeded();
        Time time =  convertHourToMin(hours);
        int minutes = time.minutes;
        return minutes;
    }
}
