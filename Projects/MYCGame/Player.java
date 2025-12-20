
/**
 * This class contains the attributes relating to the User's character.
 */

public class Player 
{
    private int currentLocationIndex;
    // Array of booleans to track found clues
    private boolean[] cluesFound; 
    private boolean didTriggerClue;       // This is the basic clue required to open up the rest of the clue.
    private boolean hasSecurityKey;       // Player need this to access Security Room.    
    private boolean hasRm224Keycard;      // Player need this to access Room 224.
    private boolean hasPenthouseKeycard;  // Player need this to access Penthouse Suite.
    private boolean hasJungleAccess;      // Player need this to enter the Jungle near the beach.
    private boolean hasSeenSecurity;      // True if player already went to visit LOCKED the Security Room.
    private boolean hasSeenRm224;         // True if player already went to visit LOCKED Room 224.
    private boolean hasSeenJungle;        // True if player already went to visit LOCKED the jungle.

    /**
     * The Player method contains the attributes of the Player, including whether they should have access
     * to restricted locations and how many clues they've discovered.
     */
    
    public Player(int startLocationIndex) 
    {
        this.currentLocationIndex = startLocationIndex;
        this.cluesFound = new boolean[HotelMysteryGame.NUM_CLUES];
        this.didTriggerClue = false;
        this.hasSecurityKey = false;
        this.hasRm224Keycard = false;
        this.hasPenthouseKeycard = true;
        this.hasJungleAccess = false;
        this.hasSeenSecurity = false;
        this.hasSeenRm224 = false;
        this.hasSeenJungle = false;
        // Initialize all clues to false
        for (int i = 0; i < HotelMysteryGame.NUM_CLUES; i++) 
        {
            this.cluesFound[i] = false;
        }
    }
    
    /**
     * The getCurrentLocationIndex method identifies the location where the User currently is and returns the int value
     * assigned to it.
     */
    
    public int getCurrentLocationIndex() 
    { 
    	return currentLocationIndex;
    }

    /**
     * the setCurrentLocationIndex method works with the getCurrentLocationIndex to set the current location from the int value in the parameter.
     */
    
    public void setCurrentLocationIndex(int currentLocationIndex) 
    {
        this.currentLocationIndex = currentLocationIndex;
    }
    
    /**
     * The hasClue method checks if the player has obtained a certain clue and returns a boolean value of true if the user has found it or
     * false if the user didn't find it.
     */

    public boolean hasClue(int index) 
    {    
        if (index >= 0 && index < HotelMysteryGame.NUM_CLUES) 
        {
            return cluesFound[index];
        }
        return false;
    }
    
    /**
     * The getClueCount method counts how many clues have been found and returns an int value of how many were found.
     */
    
    public int getClueCount() {                       
    	int result = 0;
    	for (int index = 0; index < HotelMysteryGame.NUM_CLUES; index++) 
    	{
    		if (cluesFound[index]) 
    		{ 
    			result++; 
    		}
    	}
    	return result;
    }
    
    /**
     * The setClueFound method activates when the Player/User finds a method and labels the clue as found to count it
     * as a found clue.
     */

    public void setClueFound(int index, boolean found) 
    {
        if (index >= 0 && index < HotelMysteryGame.NUM_CLUES) 
        {
            this.cluesFound[index] = found;
        }
    }

    /**
     * The hasFoundAllClue method activates when the User has found all clues and returns a boolean value that represents it.
     */
    
    public boolean hasFoundAllClues() 
    {
        for (int i = 0; i < HotelMysteryGame.NUM_CLUES; i++) 
        {
            if (!cluesFound[i]) 
            { 
            	return false; 
            }
        }
        return true;
    }
    
    /**
     * The getNumCluesFound method identifies how many clues were found and returns that value.
     */
    
    public int getNumCluesFound() 
    {
    	int countCluesFound = 0;
    	for (int i = 0; i < HotelMysteryGame.NUM_CLUES; i++) {
    		if (cluesFound[i]) 
    		{ 
    			countCluesFound++;
    		}
    	}
    	return countCluesFound;
    }
    
    /**
     * These other variables relate to different restricted locations the player can gain access to and checks if they have the requirements
     * to visit these locations.
     */
    
    
    public boolean didTriggerClue() 
    { 
    	return didTriggerClue;
    }                                         
    public void setDidTriggerClue(boolean didClue) 
    { 
    	this.didTriggerClue = didClue;
    }                 
    
    public boolean hasSecurityKey() 
    { 
    	return hasSecurityKey; 
    }                                         
    public void setHasSecurityKey(boolean hasKey) 
    { 
    	this.hasSecurityKey = hasKey;
    }                   
    public boolean hasSeenSecurity() 
    { 
    	return hasSeenSecurity; 
    }
    public void setHasSeenSecurity(boolean hasSeen) 
    { 
    	this.hasSeenSecurity = hasSeen;
    }
    
    public boolean hasRm224Keycard() 
    { 
    	return hasRm224Keycard;
    }                                   
    public void setHasRm224Keycard(boolean hasKeycard) 
    { 
    	this.hasRm224Keycard = hasKeycard;
    }          
    public boolean hasSeenRm224() 
    { 
    	return hasSeenRm224;
    }
    public void setHasSeenRm224(boolean hasSeen) 
    { 
    	this.hasSeenRm224 = hasSeen;
    }
    
    public boolean hasPenthouseKeycard() 
    { 
    	return hasPenthouseKeycard;
    }                               
    public void setHasPenthouseKeycard(boolean hasKeycard) 
    { 
    	this.hasPenthouseKeycard = hasKeycard;
    } 
    
    public boolean hasJungleAccess() 
    { 
    	return hasJungleAccess;
    }                                      
    public void setHasJungleAccess(boolean hasAccess) 
    { 
    	this.hasJungleAccess = hasAccess;
    }           
    public boolean hasSeenJungle() 
    { 
    	return hasSeenJungle;
    }
    public void setHasSeenJungle(boolean hasSeen) 
    { 
    	this.hasSeenJungle = hasSeen;
    }
}
