package Oving10Oppgave2;

public class App {


    public static void main(String[] args) {
        Course pancake = new Course("Pancake", "Baked good", "One spoonful of flour, one skibidi toilet of milk, a rizzy amount of sugar, a chatGPT prompt's amount of salt, 3 BIG EGGS! EGG! EGG! EGGG!", 10.5);
        Course onionSoup = new Course("Onion soup", "Soup", "One (1) onion, and one (1) soup,", 15.3); 
        Course bread = new Course("Bread", "Baked good", "One job, 40 years of suffering, and no free time", 300.99);
        Course tomatoSoup = new Course("Tomato soup", "Soup", "10 tomatos and a meat grinder", -5.65);
        Course cheese = new Course("Cheese", "Dairy", "Spoiled milk, 10 years", 99999.9999991);

        Menu monday = new Menu("Monday", new Course[]{pancake, tomatoSoup});
        Menu tuesday = new Menu("Tuesday", new Course[]{onionSoup, bread, cheese});

        MenuRegister schoolCafeteria = new MenuRegister(new Menu[]{monday, tuesday}, new Course[]{pancake, tomatoSoup, onionSoup, bread, cheese});
        

        schoolCafeteria.addCourse(new Course("Garlic bread", "Baked good", "60ml bread + 300km³ garlic", 20));
        System.out.println(schoolCafeteria.getCourses());
        System.out.println(schoolCafeteria.getCourse("Bread").getRecipe());
        System.out.println(schoolCafeteria.getCoursesOfType("Baked good"));
        System.out.println(schoolCafeteria.getCoursesOfType("Soup"));
        System.out.println();
        System.out.println(schoolCafeteria.getMenuRegister());
        System.out.println();
        schoolCafeteria.addMenu(new Menu("Wednesday", new Course[]{bread, cheese}));
        System.out.println(schoolCafeteria.getMenuRegister());
        System.out.println();
        System.out.println(schoolCafeteria.getMenusOfValueRange(0, 300));
        System.out.println(schoolCafeteria.getMenusOfValueRange(50, 999999));

        
    }
}
