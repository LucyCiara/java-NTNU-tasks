package Oving10Oppgave1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception{
        ArrangementRegister arrangements = new ArrangementRegister();
        boolean run = true;
        Scanner inputScanner = new Scanner(System.in);
        while(run){
            printArray(new String[]{"Choose operation:", "(0) Register a new arrangement", "(1) Show arrangements", "(q) Quit"});
            String input1 = inputScanner.nextLine();
            System.out.println("");
            if(input1.toLowerCase().equals("q")){
                run = false;
            }else if(input1.equals("0")){
                boolean run2 = true;
                String input2 = "";
                while(run2){
                    System.out.println("Write the name of the client making the arrangement:");
                    input2 = inputScanner.nextLine();
                    System.out.println("");
                    if(input2.length() > 0){
                        run2 = false;
                    }
                }

                run2 = true;
                String input3 = "";
                while(run2){
                    System.out.println("Write the location of the restaurant:");
                    input3 = inputScanner.nextLine();
                    System.out.println("");
                    if(input2.length() > 0){
                        run2 = false;
                    }
                }

                run2 = true;
                String input4 = "";
                while(run2){
                    System.out.println("Write the organizer of the arrangement:");
                    input4 = inputScanner.nextLine();
                    System.out.println("");
                    if(input2.length() > 0){
                        run2 = false;
                    }
                }

                run2 = true;
                String input5 = "";
                while(run2){
                    System.out.println("Write the arrangement type:");
                    input5 = inputScanner.nextLine();
                    System.out.println("");
                    if(input2.length() > 0){
                        run2 = false;
                    }
                }

                run2 = true;
                String input6 = "";
                while(run2){
                    System.out.println("Write the date of the arrangement in the format dd.MM.yyyy:");
                    input6 = inputScanner.nextLine();
                    System.out.println("");
                    if(input6.length() == 10 && input6.split("\\.").length == 3){
                        run2 = false;
                    }else{
                        printArray(new String[]{"Your input was not accepted", "Please write a date in the format dd.MM.yyyy", ""});
                    }
                }

                run2 = true;
                String input7 = "";
                while(run2){
                    System.out.println("Write the time of the arrangement in the format hh:mm:");
                    input7 = inputScanner.nextLine();
                    System.out.println("");
                    if(input7.length() == 5 && input7.split(":").length == 2){
                        run2 = false;
                    }else{
                        printArray(new String[]{"Your input was not accepted", "Please write a time in the format hh:mm", ""});
                    }
                }

                String[] dateArray = input6.split("\\.");
                Arrays.toString(dateArray);
                String[] timeArray = input7.split(":");
                String timeString = "";
                for(int i = dateArray.length-1; i >= 0; i--){
                    timeString += dateArray[i];
                }
                timeString += timeArray[0] + timeArray[1];
                Long timeLong = Long.parseLong(timeString);
                arrangements.addArrangement(input2, input3, input4, input5, timeLong);
                printArray(new String[]{"Arrangement added", ""});

            }else if(input1.equals("1")){
                boolean run2 = true;
                while(run2){
                    printArray(new String[]{"Choose what methods to show:", "(0) Sorted by Time", "(1) Sorted by Location", "(2) Sorted by Type", "(3) Show arrangements of a Specific Location", "(4) Show arrangements of a Specific Date", "(5) Show arrangements of a Specific Date Interval", "(q) Back"});
                    String input2 = inputScanner.nextLine();
                    String timeLen = "12"; String numLen = "7"; String namesLen = "-26"; String localLen = "-16";
                    String[] tableStringsFields = new String[6];
                    ArrayList<String[]> tableStringContents = new ArrayList<String[]>();
                    String[] tableStringLens = new String[6];
                    if(input2.toLowerCase().equals("q")){
                        run2 = false;
                    }else if(input2.equals("0") || input2.equals("1") || input2.equals("2") || input2.equals("3") || input2.equals("4") || input2.equals("5")){
                        if(input2.equals("0")){
                            addAll(tableStringsFields, new String[]{"Booking Time", "Number", "Client Name", "Location Name", "Organizer Name", "Arrangement Type"});
                            addAll(tableStringLens, new String[]{timeLen, numLen, namesLen, localLen, namesLen, namesLen});
                            tableStringContents.add(tableStringsFields);
                            for(Arrangement arrangement : arrangements.getSortedArrangementsBookingTime()){
                                tableStringContents.add(new String[]{arrangement.getBookingTime() + "", String.format("%" + numLen + "s", arrangement.getArrangementNumber() + "").replace(" ", "0"), arrangement.getName(), arrangement.getLocation(), arrangement.getOrganizer(), arrangement.getArrangementType()});
                            }                 
                        }else if(input2.equals("1")){
                            addAll(tableStringsFields, new String[]{"Location Name", "Number", "Booking Time", "Client Name", "Organizer Name", "Arrangement Type"});
                            addAll(tableStringLens, new String[]{localLen, numLen, timeLen, namesLen, namesLen, namesLen});
                            tableStringContents.add(tableStringsFields);
                            for(Arrangement arrangement : arrangements.getSortedArrangementsLocation()){
                                tableStringContents.add(new String[]{arrangement.getLocation(), String.format("%" + numLen + "s", arrangement.getArrangementNumber() + "").replace(" ", "0"), arrangement.getBookingTime() + "", arrangement.getName(), arrangement.getOrganizer(), arrangement.getArrangementType()});
                            }
                        }else if(input2.equals("2")){
                            addAll(tableStringsFields, new String[]{"Arrangement Type", "Number", "Booking Time", "Client Name", "Location Name", "Organizer Name"});
                            addAll(tableStringLens, new String[]{namesLen, numLen, timeLen, namesLen, localLen, namesLen});
                            tableStringContents.add(tableStringsFields);
                            for(Arrangement arrangement : arrangements.getSortedArrangementsType()){
                                tableStringContents.add(new String[]{arrangement.getArrangementType(), String.format("%" + numLen + "s", arrangement.getArrangementNumber() + "").replace(" ", "0"), arrangement.getBookingTime() + "", arrangement.getName(), arrangement.getLocation(), arrangement.getOrganizer()});
                            }
                        }else if (input2.equals("3")){
                            addAll(tableStringsFields, new String[]{"Number", "Booking Time", "Client Name", "Location Name", "Organizer Name", "Arrangement Type"});
                            addAll(tableStringLens, new String[]{numLen, timeLen, namesLen, localLen, namesLen, namesLen});
                            System.out.println("Input the location:");
                            String input3 = inputScanner.nextLine();
                            System.out.println();
                            tableStringContents.add(tableStringsFields);
                            for(Arrangement arrangement : arrangements.getLocationArrangements(input3)){
                                tableStringContents.add(new String[]{String.format("%" + numLen + "s", arrangement.getArrangementNumber() + "").replace(" ", "0"), arrangement.getBookingTime() + "", arrangement.getName(), arrangement.getLocation(), arrangement.getOrganizer(), arrangement.getArrangementType()});
                            }
                        }else if (input2.equals("4")){
                            addAll(tableStringsFields, new String[]{"Number", "Booking Time", "Client Name", "Location Name", "Organizer Name", "Arrangement Type"});
                            addAll(tableStringLens, new String[]{numLen, timeLen, namesLen, localLen, namesLen, namesLen});
                            String input3 = "";
                            boolean run3 = true;
                            while(run3){
                                System.out.println("Input date in the format dd.MM.yyyy:");
                                input3 = inputScanner.nextLine();
                                System.out.println();
                                if(input3.length() == 10 && input3.split("\\.").length == 3){
                                    run3 = false;
                                }else{
                                    printArray(new String[]{"Your input was not accepted", "Please write a date in the format dd.MM.yyyy", ""});
                                }
                            }
                            String[] input3Array = input3.split("\\.");
                            tableStringContents.add(tableStringsFields);
                            for(Arrangement arrangement : arrangements.getTimeArrangements(Long.parseLong(input3Array[2] + input3Array[1] + input3Array[0]))){
                                tableStringContents.add(new String[]{String.format("%" + numLen + "s", arrangement.getArrangementNumber() + "").replace(" ", "0"), arrangement.getBookingTime() + "", arrangement.getName(), arrangement.getLocation(), arrangement.getOrganizer(), arrangement.getArrangementType()});
                            }
                        }else if (input2.equals("5")){
                            addAll(tableStringsFields, new String[]{"Number", "Booking Time", "Client Name", "Location Name", "Organizer Name", "Arrangement Type"});
                            addAll(tableStringLens, new String[]{numLen, timeLen, namesLen, localLen, namesLen, namesLen});
                            String input3 = "";
                            boolean run3 = true;
                            while(run3){
                                System.out.println("Input the start time in the format hh:mm dd.MM.yyyy:");
                                input3 = inputScanner.nextLine();
                                System.out.println();
                                if(input3.length() == 16 && input3.split("[\\. :]").length == 5){
                                    run3 = false;
                                }else{
                                    printArray(new String[]{"Your input was not accepted", "Please write a time in the format hh:mm dd.MM.yyyy", ""});
                                }
                            }
                            String[] input3Array = input3.split("[\\. :]");

                            String input4 = "";
                            run3 = true;
                            while(run3){
                                System.out.println("Input the end time in the format hh:mm dd.MM.yyyy:");
                                input4 = inputScanner.nextLine();
                                System.out.println();
                                if(input4.length() == 16 && input3.split("[\\. :]").length == 5){
                                    run3 = false;
                                }else{
                                    printArray(new String[]{"Your input was not accepted", "Please write a time in the format hh:mm dd.MM.yyyy", ""});
                                }
                            }
                            String[] input4Array = input4.split("[\\. :]");
                            tableStringContents.add(tableStringsFields);
                            for(Arrangement arrangement : arrangements.getTimePeriodArrangements(Long.parseLong(input3Array[4] + input3Array[3] + input3Array[2] + input3Array[0] + input3Array[1]), Long.parseLong(input4Array[4] + input4Array[3] + input4Array[2] + input4Array[0] + input4Array[1]))){
                                tableStringContents.add(new String[]{String.format("%" + numLen + "s", arrangement.getArrangementNumber() + "").replace(" ", "0"), arrangement.getBookingTime() + "", arrangement.getName(), arrangement.getLocation(), arrangement.getOrganizer(), arrangement.getArrangementType()});
                            }
                        }
                        for(String[] line : tableStringContents){
                            String formatLine = "|";
                            for(int i = 0; i < line.length; i++){
                                formatLine += String.format("%" + tableStringLens[i] + "s", line[i]) + "|";
                            }
                            System.out.println(formatLine);
                        }
                    }else{
                        printArray(new String[]{"Your input was not accepted", "Please input one of the given numbers, or q to go back", ""});
                    }

                }
            }else{
                printArray(new String[]{"Your input was not accepted", "Please input one of the given numbers, or q to quit", ""});
            }
        }
        inputScanner.close();
    }

    public static void printArray(String[] inputArray){
        for(String s : inputArray){
            System.out.println(s);
        }
    }

    public static void addAll(Object array1[], Object array2[]){
        if(array1.length != array2.length){
            throw new IllegalArgumentException("The arrays need to be the same length");
        }
        for(int i = 0; i < array1.length; i++){
            array1[i] = array2[i];
        }
    }
}
