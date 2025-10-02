package Oving10Oppgave2;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    // Object Variables
    private ArrayList<Course> MenuAL;
    String name;

    // Constructors and toString
    public Menu(String name){
        this(name, new Course[]{});
    }
    public Menu(String name, Course course){
        this(name, new Course[]{course});
    }
    public Menu(String name, Course course[]){
        this.MenuAL = new ArrayList<Course>(Arrays.asList(course));
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name + ": " + this.MenuAL.toString();
    }

    // Get methods
    public ArrayList<Course> getMenuArrayList(){
        return this.MenuAL;
    }
    public String getName(){
        return this.name;
    }
    
    // Add methods
    public void addCourse(Course course){
        this.MenuAL.add(course);
    }
}
