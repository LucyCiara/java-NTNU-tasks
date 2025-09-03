package Oving2Oppgave2;

public class Oving2Oppgave2 {
    public static void main(String[] args) throws Exception {
        // Initiates 2 objects to represent the different ground meat brands.
        Product groundMeatA = new Product(450, 35.9, "Ground Meat A");
        Product groundMeatB = new Product(500, 39.5, "Ground Meat B");

        // Checks which ground meat has the best price for its weight.
        if (groundMeatA.price/groundMeatA.weight < groundMeatB.price/groundMeatB.weight) {
            System.out.printf("%s is cheaper per kilo than %s, since %s's price per kilo is %.2f, while %s's price per kilo is %.2f%n", groundMeatA.name, groundMeatB.name, groundMeatA.name, groundMeatA.price/(groundMeatA.weight/1000), groundMeatB.name, groundMeatB.price/(groundMeatB.weight/1000));
        }else{
            System.out.printf("%s is cheaper per kilo than %s, since %s's price per kilo is %.2f, while %s's price per kilo is %.2f%n", groundMeatB.name, groundMeatA.name, groundMeatB.name, groundMeatB.price/(groundMeatB.weight/1000), groundMeatA.name, groundMeatA.price/(groundMeatA.weight/1000));
        }
    }
}


