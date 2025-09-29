package Oving9;

public class StudentTestProgram {
    public static void main(String[] args) {
        Student Carl = new Student("Carl");
        Student Josephine = new Student("Josephine", 3);

        System.out.println(Carl.getName());
        System.out.println(Carl);
        System.out.println(Carl.getTaskCompletion());
        Carl.incrementTaskCompletion(3);
        System.out.println(Carl.getTaskCompletion());
        System.out.println(Josephine.getName());
        System.out.println(Josephine);
        System.out.println(Josephine.getTaskCompletion());
        Josephine.incrementTaskCompletion(300);
        System.out.println(Josephine.getTaskCompletion());
    }
}
