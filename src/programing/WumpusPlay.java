package programing;

import game.Element;
import game.Experience;

import java.util.Random;

public class WumpusPlay {

    /** THAT WILL BE THE TRACK WITH EXPERIENCE */
    private Element[][] gameTrack;
    /** THAT WILL BE THE TMB, WHICH CONTAINS PLAYGROUNDS ALREADY DISCOVERED. */
    private String[][] discoveryTmb;

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


        draw();
    }


    /** Put the "empty" in the game */
    public void createEmpty ()
    {
        for(int row = 0; row < this.gameTrack.length; row ++)
        {
            for(int column = 0; column < this.gameTrack.length; column++)
            {
                this.gameTrack[row][column] = new Element(Experience.EMPTY);
            }
        }
    }


    /** Put the "hero" in the game */
    public void createHero ()
    {
        this.gameTrack[0][0] = new Element(Experience.HERO);
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

        this.gameTrack[treasureRow][treasureColumn] = new Element(Experience.TREASURE);
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

            this.gameTrack[wumpusRow][wumpusColumn] = new Element(Experience.WUMPUS);
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
                    this.gameTrack[row][column] = new Element(Experience.NOISE);
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
