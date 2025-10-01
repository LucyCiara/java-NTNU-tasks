package Oving9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaskOverview {
    private ArrayList<Student> Students = new ArrayList<Student>();
    private int studentNumber = 0;

    // Constructors and toString methods
    public TaskOverview(){
        this(new Student[0]);
    }
    public TaskOverview(Student[] students){
        this(new ArrayList<Student>(Arrays.asList(students)));
    }
    public TaskOverview(ArrayList<Student> students){
        this.studentNumber = students.size();
        this.Students = students;
    }
    @Override
    public String toString(){
        Map<String, Integer> outputMap = new HashMap<String, Integer>();
        for(Student student : this.Students){
            outputMap.put(student.getName(), student.getTaskCompletion());
        }
        return outputMap.toString();
    }

    // Private methods
    private Student getStudent(String name){
        for (Student student : this.Students){
            if(student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }

    // Get methods
    public int getNumberOfStudents(){
        return this.studentNumber;
    }
    public int getStudentTaskCompletion(String name){
        return this.getStudent(name).getTaskCompletion();
    }

    // Other public methods
    public void addStudent(Student student){
        this.Students.add(student);
        this.studentNumber++;
    }
    public void incrementStudentTaskCompletion(String name, int increase){
        this.getStudent(name).incrementTaskCompletion(increase);
    }
}
