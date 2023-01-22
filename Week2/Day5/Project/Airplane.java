package Project;

import Project.Time;

public class Airplane extends Trip {

    public Airplane() {
    }

    public Airplane(String tripNumber, double distance, double speed, String startTime) {
        super(tripNumber, distance, speed, startTime);
    }

    public Airplane(String tripNumber, double distance, double speed, String startTime, int stops, int stopDurationInMinutes) {
        super(tripNumber, distance, speed, startTime, stops, stopDurationInMinutes);
    }

    public int calculateDuration() {
        double hours = this.calculateTimeNeeded();
        Time time =  convertHourToMin(hours);
        int minutes = time.minutes;
        return minutes;
    }
}
