package Project;

public class Train extends Trip {

    public Train(String tripNumber, double distance, double speed, String startTime) {
        super(tripNumber, distance, speed, startTime);
    }

    public int calculateDuration() {
        double hours = this.calculateTimeNeeded();
        Time time =  convertHourToMin(hours);
        int minutes = time.minutes;
        return minutes;
    }
}
