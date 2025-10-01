package Oving10Oppgave1;

import java.util.Arrays;

public class Arrangement {
    private int arrangementNumber;
    private String name;
    private String location;
    private String organizer;
    private String arrangementType;
    private long bookingTime;
    // Constructor
    public Arrangement(int arrangementNumber, String name, String location, String organizer, String arrangementType, long bookingTime){
        this.arrangementNumber = arrangementNumber;
        this.name = name;
        this.location = location;
        this.organizer = organizer;
        this.arrangementType = arrangementType;
        this.bookingTime = bookingTime;
    }
    @Override
    public String toString() {
        return Arrays.toString(new Object[]{this.arrangementNumber, this.name, this.location, this.organizer, this.arrangementType, this.bookingTime});
    }

    // Get methods
    public int getArrangementNumber(){
        return this.arrangementNumber;
    }
    public String getName(){
        return this.name;
    }
    public String getLocation(){
        return this.location;
    }
    public String getOrganizer(){
        return this.organizer;
    }
    public String getArrangementType(){
        return this.arrangementType;
    }
    public long getBookingTime(){
        return this.bookingTime;
    }

    // Set methods
    public void setName(String name){
        this.name = name;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public void setOrganizer(String organizer){
        this.organizer = organizer;
    }
    public void setArrangementType(String arrangementType){
        this.arrangementType = arrangementType;
    }
    public void setBookingTime(long bookingTime){
        this.bookingTime = bookingTime;
    }
}
