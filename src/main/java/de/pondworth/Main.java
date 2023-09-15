package de.mhengstmann;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ItemCatalog itemCatalog = new ItemCatalog();

        Field fieldGame = new Field(itemCatalog);
        fieldGame.buildField();

        Player player1 = new Player(fieldGame);
        fieldGame.printField();

        String decision;
        int temp = 0;

        Scanner sc = new Scanner(System.in);

        while(temp == 0) {
            System.out.println("It is your turn (g = go forward, l = turn left, r = turn right, q = quit): ");
            decision = sc.next();

            switch(decision) {
                case "g": player1.goForward(fieldGame); break;
                case "l": player1.rotateLeft(fieldGame); break;
                case "r": player1.rotateRight(fieldGame); break;
                case "q": temp = 1; System.out.println("The Program quits"); break;
                default: System.out.println("Du hast eine falsche Taste gedrückt!"); break;
            }
            if(player1.foundTreasure()){
                temp = 1;
            }
        }



    }

}