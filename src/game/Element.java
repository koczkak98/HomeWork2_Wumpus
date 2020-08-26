package game;

public class Element {


    private Experience experience;


    public Element(Experience experience) {
        this.experience = experience;
    }


    public Experience getExperience() {
        return experience;
    }


    public void setExperience(Experience experience) {
        this.experience = experience;
    }


    public String getElementName()
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
        else if (experience == Experience.EMPTY)
        {
            returnValueName = "E";
        }

        return returnValueName;
    }
}
