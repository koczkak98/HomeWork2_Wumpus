package programing;

import game.Element;
import game.Experience;

import java.util.Random;

public class WumpusPlay {

    /** THAT WILL BE THE TRACK WITH EXPERIENCE */
    private Element[][] gameTrack;

    public WumpusPlay() {
        this.gameTrack = new Element[8][8];

        /** Empty */
        createEmpty();

        /** Hero */
        createHero();

        /** Wumpus */
        createWumpus ();

        /** Treasure */
        createTreasure ();


        /** Step */

        draw();
    }





    /** Discovery */
    public boolean discovery (int rowStep, int columnStep)
    {
        boolean succes = false;
        /** ROW */
        int stepAboveRow = 0;
        int stepDownRow = 0;

        /** COLUMN */
        int stepLeftColumn = 0;
        int stepRightColumn = 0;

        /** ROW */
        if(rowStep == 0)
        {
            /** FIRST ROW */
            stepAboveRow = 0;
            stepDownRow = 1;
        }
        else if(rowStep == (this.gameTrack.length -1))
        {
            /** LAST ROW */
            stepAboveRow = (this.gameTrack.length - 2);
            stepDownRow = (this.gameTrack.length - 1);
        }
        else
        {
            /** MID */
            stepAboveRow = (rowStep - 1);
            stepDownRow = (rowStep + 1);
        }

        /** COLUMN */
        if(columnStep == 0)
        {
            /** FIRST COLUMN */
            stepLeftColumn = 0;
            stepRightColumn = 1;
        }
        else if(columnStep == (this.gameTrack.length -1))
        {
            /** LAST COLUMN */
            stepLeftColumn = (this.gameTrack.length - 2);
            stepRightColumn = (this.gameTrack.length - 1);
        }
        else
        {
            /** MID */
            stepLeftColumn = (columnStep - 1);
            stepRightColumn = (columnStep + 1);
        }

        for (int checkRow = stepAboveRow; checkRow <= stepDownRow; checkRow++) {

            for (int checkColumn = stepLeftColumn; checkColumn <= stepRightColumn; checkColumn++) {

                if(this.gameTrack[checkRow][checkColumn].getDiscover() == true)
                {
                    succes = true;
                    break;
                }
            }
        }
        return succes;
    }


    public void setDiscovered(int row, int column)
    {
        this.gameTrack[row][column].setDiscover();
    }


    public boolean finishedGame (int row, int column)
    {
        boolean finished = false;

        if (this.gameTrack[row][column].getElementName().equals("W") ||
                this.gameTrack[row][column].getElementName().equals("T"))
        {
            finished = true;
        }

        return finished;
    }


    public String finishedMessage (int row, int column)
    {
        String message = "";

        if (this.gameTrack[row][column].getElementName().equals("W"))
        {
            message = "DEAD!";
        }
        else if (this.gameTrack[row][column].getElementName().equals("T"))
        {
            message = "WON";
        }

        return message;
    }


    /**
     *
     *
     *
     *
     */


    public String getCellContent(int row, int column)
    {
        return (this.gameTrack[row][column].getElementName());
    }


    /** Put the "empty" in the game */
    public void createEmpty ()
    {
        for(int row = 0; row < this.gameTrack.length; row ++)
        {
            for(int column = 0; column < this.gameTrack.length; column++)
            {
                this.gameTrack[row][column] = new Element(Experience.EMPTY, false);
            }
        }
    }


    /** Put the "hero" in the game */
    public void createHero ()
    {
        this.gameTrack[0][0] = new Element(Experience.HERO, true);
    }


    /** Put the "treasure" in the game */
    public void createTreasure ()
    {
        int treasureRow = 0;
        int treasureColumn = 0;

        do {

            treasureRow = (new Random().nextInt(6) + 2);
            treasureColumn = (new Random().nextInt(6) + 2);

        } while (this.gameTrack[treasureRow][treasureColumn].getExperience() != Experience.EMPTY);

            this.gameTrack[treasureRow][treasureColumn] = new Element(Experience.TREASURE, false);

    }


    /** Put the "Wumpus" in the game */
    public void createWumpus ()
    {
        int count = 0;
        while (count < 3)
        {
            int wumpusRow = 0;
            int wumpusColumn = 0;

            do {

                wumpusRow = (new Random().nextInt(6) + 2);
                wumpusColumn = (new Random().nextInt(6) + 2);

            } while (this.gameTrack[wumpusRow][wumpusColumn].getExperience() != Experience.EMPTY);

            this.gameTrack[wumpusRow][wumpusColumn] = new Element(Experience.WUMPUS, false);
            createNoise (wumpusRow, wumpusColumn);
            count ++;
        }
    }


    public void createNoise (int wumpusRow, int wumpusColumn)
    {
        /** Row */
        int noiseAboveRow = 0;
        int noiseDownRow = 0;

        /** Column */
        int noiseLeftColumn = 0;
        int noiseRightColumn = 0;

        if (wumpusRow == 0)
        {
            noiseAboveRow = 0;
            noiseDownRow = 1;
        }
        else if (wumpusRow == ((this.gameTrack.length)-1))
        {
            noiseAboveRow = ((this.gameTrack.length)-2);
            noiseDownRow = ((this.gameTrack.length)-1);
        }
        else
        {
            noiseAboveRow = wumpusRow -1;
            noiseDownRow = wumpusRow +1;
        }

        if (wumpusColumn == 0)
        {
            noiseLeftColumn = 0;
            noiseRightColumn = 1;
        }
        else if (wumpusColumn == ((this.gameTrack.length)-1))
        {
            noiseLeftColumn = ((this.gameTrack.length)-2);
            noiseRightColumn = ((this.gameTrack.length)-1);
        }
        else
        {
            noiseLeftColumn = wumpusColumn-1;
            noiseRightColumn = wumpusColumn+1;
        }

        for (int row = noiseAboveRow; row <= noiseDownRow; row++)
        {
            for(int column = noiseLeftColumn; column <= noiseRightColumn; column++)
            {
                if (this.gameTrack[row][column].getExperience() == Experience.EMPTY)
                {
                    this.gameTrack[row][column] = new Element(Experience.NOISE, false);
                }
            }
        }

    }


    public void draw ()
    {
        for(int row = 0; row < this.gameTrack.length; row ++)
        {
            for(int column = 0; column < this.gameTrack.length; column++)
            {
                System.out.print(this.gameTrack[row][column].getElementName() + "  ");
            }
            System.out.println();
        }
    }






}
