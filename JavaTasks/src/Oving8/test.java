package Oving8;

import java.util.Calendar;

public class test {
    public static void main(String[] args) {
            Calendar presentTime = Calendar.getInstance();
            System.out.println(presentTime.get(Calendar.HOUR_OF_DAY));
            System.out.println(presentTime.get(Calendar.MINUTE));
            System.out.println(presentTime.get(Calendar.DAY_OF_MONTH));
            System.out.println(presentTime.get(Calendar.MONTH));
            System.out.println(presentTime.get(Calendar.YEAR));
    }
}
