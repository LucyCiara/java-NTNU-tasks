package Oving8;

import java.util.Random;
import java.util.Calendar;

public class Person {
    // Object variables
    private String firstName;
    private String lastName;
    private BirthDate birthDate;
    private Random numberGen = new Random();
    protected Calendar presentTime = Calendar.getInstance();

    // Constructors
    public Person(){
        this("","",1,1,2000);
    }
    public Person(String firstName, String lastName){
        this(firstName, lastName, 1, 1, 2000);
    }
    public Person(int birthday, int birthmonth, int birthyear){
        this("", "", birthday, birthmonth, birthyear);
    }
    public Person(String firstName, String lastName, int birthday, int birthmonth, int birthyear){
        // Blank to randomly gendered placeholder name conversion.
        if (firstName.equals("")){
            if(this.numberGen.nextBoolean()){
                this.firstName = "John";
            }else{
                this.firstName = "Jane";
            }
        }else{
            this.firstName = firstName;
        }
        if(lastName.equals("")){
            this.lastName = "Doe";
        }else{
            this.lastName = lastName;
        }

        // Exception throwing for nonsensical birthday and birthmonth value-inputs.
        if(birthday  < 1 || birthmonth < 1){
            throw new IllegalArgumentException("Negative or 0 birthdays or birthmonths are not allowed.");
        }
        if(birthday > 31 || birthmonth > 12){
            throw new IllegalArgumentException(">31 birthdays and >12 birthmonths are not allowed.");
        }

        this.birthDate = new BirthDate(birthday, birthmonth, birthyear);
    }

    // toString override
    public String toString(){
        return this.lastName + ", " + this.firstName;
    }

    // BirtDate subclass
    public final class BirthDate {
        // Object variables
        private int[] dateArray = new int[3];
        private int day;
        private int month;
        private int year;

        // Constructor
        public BirthDate(int day, int month, int year){
            this.dateArray[0] = day;
            this.dateArray[1] = month;
            this.dateArray[2] = year;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        // ToString override
        @Override
        public String toString() {
            return String.format("%d.%d.%d", this.day, this.month, this.year);
        }

        // Public methods
        public int getDay(){
            return this.day;
        }
        public int getMonth(){
            return this.month;
        }
        public int getYear(){
            return this.year;
        }
        public int[] getArray(){
            return this.dateArray;
        }
    }

    // Public methods
    // // Get methods for object variables
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public BirthDate getBirthDate(){
        return this.birthDate;
    }

    // // Get methods for non-object variables
    public int getAge(){
        if((presentTime.get(Calendar.MONTH)+1 > this.birthDate.getMonth()) || ((presentTime.get(Calendar.MONTH)+1 == this.birthDate.getMonth()) && presentTime.get(Calendar.DAY_OF_MONTH) >= this.birthDate.getDay())){
            return presentTime.get(Calendar.YEAR)-this.birthDate.getYear();
        }else{
            return presentTime.get(Calendar.YEAR)-this.birthDate.getYear()-1;
        }
    }
}
