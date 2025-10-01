package Oving10Oppgave1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class ArrangementRegister {
    private ArrayList<Arrangement> arrangements;
    private ArrayList<Integer> arrangementNumbers;
    private Random randomGen = new Random();

    // Constructor and toString methods
    public ArrangementRegister(){
        this.arrangements  = new ArrayList<Arrangement>();
        int n = (int) Math.pow(2, 20);
        ArrayList<Integer> arrangementNumbers = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            arrangementNumbers.add(i);
        }
        this.arrangementNumbers = arrangementNumbers;
    }

    // // Private methods
    // private int indexOfArrangementNumber(int arrangementNumber){
    //     for(int i = 0; i < this.arrangements.size(); i++){
    //         if(this.arrangements.get(i).getArrangementNumber() == arrangementNumber){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    private class LocationComparator implements Comparator<Arrangement> {
        public int compare(Arrangement a1, Arrangement a2){
            return a1.getLocation().compareTo(a2.getLocation());
        }
    }

    private class TypeComparator implements Comparator<Arrangement> {
        public int compare(Arrangement a1, Arrangement a2){
            return a1.getArrangementType().compareTo(a2.getArrangementType());
        }
    }
    
    private class BookingTimeComparator implements Comparator<Arrangement> {
        public int compare(Arrangement a1, Arrangement a2){
            if(a1.getBookingTime() == a2.getBookingTime()){
                return 0;
            }else if(a1.getBookingTime() < a2.getBookingTime()){
                return -1;
            }else{
                return 1;
            }
        }
    }


    // Public set/add methods
    public void addArrangement(String name, String location, String organizer, String arrangementType, long bookingTime){
        int arrangementNumber = this.arrangementNumbers.get(this.randomGen.nextInt(arrangementNumbers.size()));
        this.arrangementNumbers.remove(arrangementNumber);
        this.arrangements.add(new Arrangement(arrangementNumber, name, location, organizer, arrangementType, bookingTime));
    }

    // Public return methods
    public ArrayList<Arrangement> getLocationArrangements(String location){
        ArrayList<Arrangement> arrangementsOfLocation = new ArrayList<Arrangement>();
        for(Arrangement arrangement : this.arrangements){
            if(arrangement.getLocation().equals(location)){
                arrangementsOfLocation.add(arrangement);
            }
        }
        return arrangementsOfLocation;
    }
    public ArrayList<Arrangement> getTimeArrangements(long bookingTime){
        ArrayList<Arrangement> arrangementsOfTime = new ArrayList<Arrangement>();
        for(Arrangement arrangement : this.arrangements){
            if(Long.parseLong((arrangement.getBookingTime() + "").substring(0, 8)) == Long.parseLong((bookingTime + ""))){
                arrangementsOfTime.add(arrangement);
            }
        }
        return arrangementsOfTime;
    }
    public ArrayList<Arrangement> getTimePeriodArrangements(long bookingTimeStart, long bookingTimeEnd){
        ArrayList<Arrangement> arrangementsOfTimePeriod = new ArrayList<Arrangement>();
        for(Arrangement arrangement : this.arrangements){
            if(arrangement.getBookingTime() >= bookingTimeStart && arrangement.getBookingTime() <= bookingTimeEnd){
                arrangementsOfTimePeriod.add(arrangement);
            }
        }
        return arrangementsOfTimePeriod;
    }
    public ArrayList<Arrangement> getSortedArrangementsLocation(){
        ArrayList<Arrangement> arrangementSorted = this.arrangements;
        // ArrayList<String> arrangementLocation = new ArrayList<String>();
        // for(Arrangement arrangement : this.arrangements){
        //     arrangementLocation.add(arrangement.getLocation())
        // }
        // arrangementLocation.sort
        Collections.sort(arrangementSorted, new LocationComparator());
        return arrangementSorted;
    }
    public ArrayList<Arrangement> getSortedArrangementsType(){
        ArrayList<Arrangement> arrangementSorted = this.arrangements;
        // ArrayList<String> arrangementLocation = new ArrayList<String>();
        // for(Arrangement arrangement : this.arrangements){
        //     arrangementLocation.add(arrangement.getLocation())
        // }
        // arrangementLocation.sort
        Collections.sort(arrangementSorted, new TypeComparator());
        return arrangementSorted;
    }
    public ArrayList<Arrangement> getSortedArrangementsBookingTime(){
        ArrayList<Arrangement> arrangementSorted = this.arrangements;
        // ArrayList<String> arrangementLocation = new ArrayList<String>();
        // for(Arrangement arrangement : this.arrangements){
        //     arrangementLocation.add(arrangement.getLocation())
        // }
        // arrangementLocation.sort
        Collections.sort(arrangementSorted, new BookingTimeComparator());
        return arrangementSorted;
    }

}
