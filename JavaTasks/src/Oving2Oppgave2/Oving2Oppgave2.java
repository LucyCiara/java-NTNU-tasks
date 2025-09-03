package Oving2Oppgave2;

import javax.swing.Spring;

public class Oving2Oppgave2 {
    public static void main(String[] args) throws Exception {
        Product groundMeatA = new Product(450, 35.9, "Ground Meat A");
        Product groundMeatB = new Product(500, 39.5, "Ground Meat B");
        if (groundMeatA.price/groundMeatA.weight < groundMeatB.price/groundMeatB.weight) {
            System.out.printf("%s is cheaper per kilo than %s, since %s's price per kilo is %.2f, while %s's price per kilo is %.2f%n", groundMeatA.name, groundMeatB.name, groundMeatA.name, groundMeatA.price/(groundMeatA.weight/1000), groundMeatB.name, groundMeatB.price/(groundMeatB.weight/1000));
        }else{
            System.out.printf("%s is cheaper per kilo than %s, since %s's price per kilo is %.2f, while %s's price per kilo is %.2f%n", groundMeatB.name, groundMeatA.name, groundMeatB.name, groundMeatB.price/(groundMeatB.weight/1000), groundMeatA.name, groundMeatA.price/(groundMeatA.weight/1000));
        }
    }
}


