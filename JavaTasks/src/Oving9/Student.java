package Oving9;

public class Student {
    private String name;
    private int taskCompletion;

    // Constructors and toString methods
    public Student(String name){
        this(name, 0);
    }
    public Student(String name, int taskCompletion){
        this.name = name;
        this.taskCompletion = taskCompletion;
    }
    @Override
    public String toString() {
        return this.name;
    }

    // Get methods
    public String getName(){
        return this.name;
    }
    public int getTaskCompletion(){
        return this.taskCompletion;
    }

    // Other public methods
    public void incrementTaskCompletion(int increase){
        this.taskCompletion += increase;
    }

}
