package Oving10Oppgave2;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuRegister {
    // Object variables
    private ArrayList<Menu> MenuRegisterAL;
    private ArrayList<Course> courses;

    // Methods
    public MenuRegister(){
        this(new Menu[]{});
    }
    public MenuRegister(Menu menu){
        this(new Menu[]{menu});
    }
    public MenuRegister(Menu[] menus){
        this(menus, new Course[]{});
    }
    public MenuRegister(Course course){
        this(new Course[]{course});
    }
    public MenuRegister(Course[] courses){
        this(new Menu[]{}, courses);
    }
    public MenuRegister(Menu[] menus, Course[] courses){
        this.MenuRegisterAL = new ArrayList<Menu>(Arrays.asList(menus));
        this.courses = new ArrayList<Course>(Arrays.asList(courses));
    }

    // Get methods
    public ArrayList<Menu> getMenuRegister(){
        return this.MenuRegisterAL;
    }
    public ArrayList<Course> getCourses(){
        return this.courses;
    }
    public Course getCourse(String name){
        for(Course course : this.courses){
            if(course.getName() == name){
                return course;
            }
        }
        return new Course(name, "n.a", "n.a", 0);
    }
    public ArrayList<Course> getCoursesOfType(String type){
        ArrayList<Course> coursesOfType = new ArrayList<Course>();
        for(Course course : this.courses){
            if(course.getType().equals(type)){
                coursesOfType.add(course);
            }
        }
        return coursesOfType;
    }
    public ArrayList<Menu> getMenusOfValueRange(double start, double end){
        ArrayList<Menu> menusInRange = new ArrayList<Menu>();
        for(Menu menu : this.MenuRegisterAL){
            double sum = 0;
            for(Course course : menu.getMenuArrayList()){
                sum += course.getPrice();
            }
            if(sum > start && sum < end){
                menusInRange.add(menu);
            }
        }
        return menusInRange;
    }

    // Add methods
    public void addMenu(Menu menu){
        this.MenuRegisterAL.add(menu);
    }
    public void addCourse(Course course){
        this.courses.add(course);
    }
}
