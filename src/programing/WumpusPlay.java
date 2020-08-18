package programing;

import java.util.Random;

public class WumpusPlay {

    private int index;
    private String[][] gameTrack;
    private int count;

    public WumpusPlay() {
        this.index = 0;
        this.gameTrack = new String[8][8];
        this.count = 0;
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


    public String trackDiscovery (int row, int column)
    {
        String returnValue = "";

        /** THE HERO STARTS FROM THE UPPER CORNER OF LEFT */
        if (row == 0 && column == 0)
        {
            this.gameTrack[row][column] = getName(Experience.HERO);
            returnValue = getName(Experience.HERO);
        }


        /** DISCOVERY */
        for (int rowTmb = 1; rowTmb < (gameTrack.length-1); rowTmb ++)
        {
            for (int columnTmb = 1; columnTmb < (gameTrack.length-1); columnTmb ++)
            {
                if ((this.gameTrack[rowTmb][columnTmb] == null))
                {
                    /** Aktuális sor előtt után, aktuális oszlop előtt után */
                    if ((this.gameTrack[rowTmb-1][columnTmb] != null) || (this.gameTrack[rowTmb+1][columnTmb] != null)
                        || (this.gameTrack[rowTmb][columnTmb - 1] != null) || (this.gameTrack[rowTmb][columnTmb +1] != null))
                    {
                        gameTrack[row][column] = getName(Experience.HERO);

                        returnValue = getName(Experience.HERO);
                    }
                }
            }
        }

        return returnValue;


    }


}
