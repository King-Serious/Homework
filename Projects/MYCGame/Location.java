
/**
 * This class contains the attributes relating to the various locations in the Hotel Mystery Game.
 */

public class Location 
{

    private String name;
    private String description;
    private String placesToVisit;
    private boolean publicAccess;
    private int clueIndex = -1; // -1 means no clue in this room

    private static final int MAX_EXITS = 6;  // Fixed-size arrays to manage exits
    private int[] destinationIndexes;
    private String[] choiceDescription;
    private int exitCount;

    /**
     * The Location method contains the attributes of the Location, including the name, description, whether the User has access,
     * and its index for the location array.
     */
    
    public Location(String name, String description, String places, boolean publicAccess) 
    {
        this.name = name;
        this.description = description;
        this.placesToVisit = places;
        this.publicAccess = publicAccess;
        this.destinationIndexes = new int[MAX_EXITS];
        this.choiceDescription = new String[MAX_EXITS];
        this.exitCount = 0;
    }
    
    /**
     * The addExit method creates an exit for a certain location that can lead the player to a different location.
     */

    public void addExit(int destinationIndex, String description) 
    {
        if (exitCount < MAX_EXITS) 
        {
            destinationIndexes[exitCount] = destinationIndex;
            choiceDescription[exitCount] = description;
            exitCount++;
        } 
        else
        {
            System.out.println("Error: Maximum exits reached for room " + this.name);
        }
    }
    
    /**
     * The displayExitChoices method prints out different locations that the user can go to from their current location.
     */
    
    public void displayExitChoices(int numChoice) 
    {
        for (int i = 0; i < exitCount; i++) {
            System.out.println("[" + numChoice + "] " + choiceDescription[i]);
            numChoice++;
        }
    }

    /**
     * The rest of these methods are setters and getters for attributes of the locations.
     */
    
    public String getName() 
    { 
    	return name;
    }                      // Get name of location. [STRING]
    public String getDescription() 
    { 
    	return description;
    }        // Get description of location. [STRING]
    public String getPlacesToVisit() 
    { 
    	return placesToVisit;
    }    // Get list of places to visit. [STRING]
    public boolean isPublicAccess() 
    { 
    	return publicAccess;
    }      // Get if location needs special access. [BOOLEAN]
    public int getExitCount() 
    { 
    	return exitCount;
    }               // Get the total number of exits or places to visit. [INTEGER]
    public int getExitChoice(int numChoice, int startingIndex) 
    {  // Returns INT value of the destination index based on the user integer input/choice.
    	return destinationIndexes[numChoice - startingIndex];
    }
    public int getClueIndex() 
    { 
    	return clueIndex;
    }               // Get how many clues in the location. [INTEGER]
    public void setClueIndex(int clueIndex) 
    {
    	this.clueIndex = clueIndex;
    }
    
    public String toString() 
    {
    	return name;
    }
	
}
