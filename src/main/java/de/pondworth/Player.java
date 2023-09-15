package de.mhengstmann;

public class Player {

    private char[] playerSign;
    private int currentRow;
    private int currentColumn;
    private int counter;
    private boolean foundTreasure;

    Player(Field field) {
        playerSign = new char[4];
        playerSign[0] = '^';
        playerSign[1] = '>';
        playerSign[2] = 'v';
        playerSign[3] = '<';
        currentRow = 3;
        currentColumn = 3;
        counter = 0;
        field.getField()[currentRow][currentColumn] = playerSign[counter];

    }

    //Rotation Right
    public void rotateRight(Field field) {

        if (counter == 0) {
            counter = 1;
        } else if (counter == 1) {
            counter = 2;
        } else if (counter == 2) {
            counter = 3;
        } else if (counter == 3) {
            counter = 0;
        } else {
            System.out.println("Fehler bei der Drehung nach rechts...");
        }

        field.getField()[currentRow][currentColumn] = playerSign[counter];
        field.printField();

    }

    //Rotation Left
    public void rotateLeft(Field field) {

        if (counter == 0) {
            counter = 3;
        } else if (counter == 1) {
            counter = 0;
        } else if (counter == 2) {
            counter = 1;
        } else if (counter == 3) {
            counter = 2;
        } else {
            System.out.println("Fehler bei der Drehung nach links...");
        }

        field.getField()[currentRow][currentColumn] = playerSign[counter];
        field.printField();

    }


    public void goForward(Field field) {
        if (field.fieldHasItem(currentRow, currentColumn)) {
            char item = field.getItemAtPosition(currentRow, currentColumn);
            field.getField()[currentRow][currentColumn] = item;
        } else {
            field.getField()[currentRow][currentColumn] = ' ';
        }

        if (counter == 0 && field.getField()[currentRow - 1][currentColumn] != '#') {
            field.getField()[currentRow - 1][currentColumn] = playerSign[counter];
            currentRow -= 1;
            checkPosition(field);
        } else if (counter == 1 && field.getField()[currentRow][currentColumn + 1] != '#') {
            field.getField()[currentRow][currentColumn + 1] = playerSign[counter];
            currentColumn += 1;
            checkPosition(field);
        } else if (counter == 2 && field.getField()[currentRow + 1][currentColumn] != '#') {
            field.getField()[currentRow + 1][currentColumn] = playerSign[counter];
            currentRow += 1;
            checkPosition(field);
        } else if (counter == 3 && field.getField()[currentRow][currentColumn - 1] != '#') {
            field.getField()[currentRow][currentColumn - 1] = playerSign[counter];
            currentColumn -= 1;
            checkPosition(field);
        } else {
            System.out.println("Schritt nach vorne nicht möglich");
            field.getField()[currentRow][currentColumn] = playerSign[counter];
        }

        field.printField();
    }

    private void checkPosition(Field field) {
        if (field.fieldHasItem(currentRow, currentColumn)) {
            char item = field.getItemAtPosition(currentRow, currentColumn);
            if(item == 'J'){
                System.out.println("Juwels");
            }else if(item == 'K'){
                System.out.println("Kiste");
            }else if(item == 'F'){
                System.out.println("Fels");
            }else if(item == 'A'){
                System.out.println("Irgendwas mit A");
            }else if(item == 'X'){
                System.out.println("Du hast den ultimativen Schatz gefunden, ");
                foundTreasure = true;
            } else{
                System.out.println("geh weiter");
            }

        }
    }
    public boolean foundTreasure(){
        return foundTreasure;
    }
}

