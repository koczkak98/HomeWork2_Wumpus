package game;

public class Element {


    private Experience experience;
    private boolean discover;


    public Element(Experience experience, boolean discover) {
        this.experience = experience;
        this.discover = discover;
    }


    public Experience getExperience() {
        return experience;
    }


    public void setExperience(Experience experience) {
        this.experience = experience;
    }


    public boolean getDiscover() {
        return discover;
    }


    public void setDiscover() {
        this.discover = true;
    }


    public String getElementName()
    {
        String returnValueName = "";

        if (this.discover == true)
        {
            if (experience == Experience.WUMPUS) {
                returnValueName = "W";
            } else if (experience == Experience.NOISE) {
                returnValueName = "N";
            } else if (experience == Experience.TREASURE) {
                returnValueName = "T";
            } else if (experience == Experience.HERO) {
                returnValueName = "H";
            } else if (experience == Experience.EMPTY) {
                returnValueName = "E";
            }
        }
        else
        {
            returnValueName = " ";
        }

        return returnValueName;
    }
}
