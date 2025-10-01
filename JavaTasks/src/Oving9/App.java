package Oving9;


public class App {
    public static void main(String[] args) throws Exception{
        TaskOverview students = new TaskOverview(new Student[]{new Student("Carl"), new Student("Josephine")});
        System.out.println(students);
        System.out.println(students.getNumberOfStudents());
        System.out.println(students.getStudentTaskCompletion("Carl"));
        students.addStudent(new Student("John"));
        System.out.println(students);
        students.incrementStudentTaskCompletion("John", 3);
        System.out.println(students);
    }
}
