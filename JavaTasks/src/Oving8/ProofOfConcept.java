package Oving8;

import java.util.Arrays;

public class ProofOfConcept {
    public static void main(String[] args) {
        Person Lucy = new Person("Lucy Ciara", "Herud-Thomassen", 16, 11, 2005);
        Employee Gorbalorb = new Employee("Gorbalorb", "Glob", 8,1,0,3000,2008,-90000000,-10);
        Employee placeholdPerson = new Employee();
        Person test = new Person(25, 9,2024);
        Person test2 = new Person(24, 9,2024);
        System.out.println(Lucy.getAge());
        System.out.println(Gorbalorb.getAge());
        System.out.println(placeholdPerson.getAge());
        System.out.println(test.getAge());
        System.out.println(test2.getAge());
        System.out.println(placeholdPerson.getYearsOfEmployment());
        System.out.println(Gorbalorb.getYearsOfEmployment());
        System.out.println(Gorbalorb.isHiredLongerThan(16));
        System.out.println(Gorbalorb.isHiredLongerThan(17));

    }
}
