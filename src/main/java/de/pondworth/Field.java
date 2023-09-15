package de.mhengstmann;

import java.util.Random;

public class Field {

    private char[][] field;
    private char[][] itemField;
    private ItemCatalog itemCatalog;


    Field(ItemCatalog itemCatalog) {
        field = new char[10][10];
        itemField = new char[10][10];
        this.itemCatalog = itemCatalog;
    }


    // Getter / Setter
    public char[][] getField() {
        return field;
    }

    public void setField(char[][] field) {
        this.field = field;
    }



    public void buildField() {
        Random random = new Random();
        int x = random.nextInt(1,8);
        int y = random.nextInt(1,8);

        //Links und Rechts Abgrenzung
        for(int i = 0; i < field.length; i++) {
            field[i][0] = '#';
            field[i][9] = '#';

            for(int t = 1; t < (field.length - 1); t++) {
                field[i][t] = ' ';
                itemField[i][t] = itemCatalog.getRandomItem();
            }
        }

        //Begrenzung oben
        for(int i = 0; i < field[0].length; i++) {
            if(i > 0 && i < (field[0].length - 1)) {
                field[0][i] = '#';
            }
        }

        //Begrenzung unten
        for(int i = 0; i < field[9].length; i++) {
            if(i > 0 && i < (field[9].length - 1)) {
                field[9][i] = '#';
            }
        }
        itemField[x][y] = 'X';
    }

    public boolean fieldHasItem(int x, int y) {
        return itemField[x][y] != ' ';
    }

    public char getItemAtPosition(int x, int y) {
        return itemField[x][y];
    }

    //Print on Console
    public void printField() {

        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

    }

}
