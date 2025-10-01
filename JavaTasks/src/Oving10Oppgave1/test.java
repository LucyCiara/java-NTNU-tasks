package Oving10Oppgave1;

public class test {
    public static void main(String[] args) {
        ArrangementRegister testRegister = new ArrangementRegister();
        testRegister.addArrangement("Lucy","Trondhem", "CringeShit", "Consert", 202509292000L);
        testRegister.addArrangement("Lucy","Bergen", "EpicSwag", "Function", 202509291800L);
        testRegister.addArrangement("Lucy","Oslo", "Wacko", "Cool Shit", 202510291800L);
        // System.out.println(testRegister.getSortedArrangementsLocation());
        // System.out.println(testRegister.getSortedArrangementsType());
        // System.out.println(testRegister.getSortedArrangementsBookingTime());
        System.out.println(testRegister.getTimePeriodArrangements(202510000000L, 202511000000L));
    }
}
