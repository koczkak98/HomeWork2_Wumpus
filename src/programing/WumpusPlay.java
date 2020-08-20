package programing;

import java.util.Random;

public class WumpusPlay {

    /** THAT WILL BE THE TRACK WITH EXPERIENCE */
    private String[][] gameTrack;
    /** THAT WILL BE THE TMB, WHICH CONTAINS PLAYGROUNDS ALREADY DISCOVERED. */
    private String[][] discoveryTmb;

    public WumpusPlay() {
        this.gameTrack = new String[8][8];
        this.discoveryTmb = new String[8][8];
    }


    public String getName(Experience experience)
    {
        String returnValueName = "";

        if (experience == Experience.WUMPUS)
        {
            returnValueName = "W";
        }
        else if (experience == Experience.NOISE)
        {
            returnValueName = "N";
        }
        else if (experience == Experience.TREASURE)
        {
            returnValueName = "T";
        }
        else if (experience == Experience.HERO)
        {
            returnValueName = "H";
        }

        return returnValueName;
    }

    private int randomPlace ()
    {
        int numb = (new Random().nextInt(7)+1); // még nem találtam ki hogy a széleken hogy oldom meg a zajt

        return numb;
    }


    /** PLACES EXPERIENCE */
    private void addGameTrack()
    {
        /** THE FIRST PLACE OF HERO */
        this.gameTrack[0][0] = getName(Experience.HERO);


        /** THE 3 PLACES OF WUMPUS */
        int i = 0;

        int rowWumpusPlace = 0;
        int columnWumpusPlace = 0;

        while (i>3)
        {
            while ((this.gameTrack[rowWumpusPlace][columnWumpusPlace]) != null) {
                rowWumpusPlace = randomPlace();
                columnWumpusPlace = randomPlace();
                if (((this.gameTrack[rowWumpusPlace][columnWumpusPlace]) != null) == false) {
                    break;
                }
                this.gameTrack[rowWumpusPlace][columnWumpusPlace] = getName(Experience.WUMPUS);

                /** THE PLACES OF NOISES */
                /** Usually 1 wumpus has 8 noise */
                int rowNoisePlace1 = 0;
                int rowNoisePlace2 = 0;
                int rowNoisePlace3 = 0;

                int columnNoisePlace1 = 0;
                int columnNoisePlace2 = 0;
                int columnNoisePlace3 = 0;


                if (rowWumpusPlace != 0)
                {
                    rowNoisePlace1 = rowWumpusPlace -1;
                    rowNoisePlace2 = rowWumpusPlace +1;
                    rowNoisePlace3 = rowWumpusPlace;
                }
                if (columnWumpusPlace != 0)
                {
                    columnNoisePlace1 = columnWumpusPlace -1;
                    columnNoisePlace2 = columnWumpusPlace +1;
                    columnNoisePlace3 = columnWumpusPlace;
                }
                /** above */
                this.gameTrack[rowNoisePlace1][columnNoisePlace1] = getName(Experience.NOISE); //1
                this.gameTrack[rowNoisePlace1][columnNoisePlace3] = getName(Experience.NOISE); //2
                this.gameTrack[rowNoisePlace1][columnNoisePlace2] = getName(Experience.NOISE); //3

                /** row of Wumpus */
                this.gameTrack[rowNoisePlace3][columnNoisePlace1] = getName(Experience.NOISE); //4
                this.gameTrack[rowNoisePlace3][columnNoisePlace2] = getName(Experience.NOISE); //5

                /** under */
                this.gameTrack[rowNoisePlace2][columnNoisePlace1] = getName(Experience.NOISE); //6
                this.gameTrack[rowNoisePlace2][columnNoisePlace3] = getName(Experience.NOISE); //7
                this.gameTrack[rowNoisePlace2][columnWumpusPlace] = getName(Experience.NOISE); //8
            }

            i++;
        }


        /** THE PLACE OF TREASURE */
        int rowTreasurePlace = 0;
        int columnTreasurePlace = 0;
        while ((this.gameTrack[rowTreasurePlace][columnTreasurePlace]) != null)
        {
            rowTreasurePlace = randomPlace();
            columnTreasurePlace = randomPlace();
            if(((this.gameTrack[rowTreasurePlace][columnTreasurePlace]) != null) == false)
            {
                break;
            }
        }
        this.gameTrack[rowTreasurePlace][columnTreasurePlace] = getName(Experience.TREASURE);


        /** THE OTHER PLACES OF HERO */

        for (int row = 0; row < this.gameTrack.length; row++)
        {
            for(int column = 0; column < this.gameTrack.length; column++)
            {
                    if (this.gameTrack [row] [column] == null)
                    {
                        this.gameTrack[row] [column] = getName(Experience.HERO);
                    }
                    else
                    {
                        i++;
                    }
                }
            }
    }


    public String trackDiscovery (int row, int column)
    {
        String returnValue = "";

        return returnValue;

    }



}
