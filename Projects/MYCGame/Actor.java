
/**
 * This class contains the attributes relating to the various actors in the Hotel Mystery Game.
 */

public class Actor 
{
	private int currentLocationIndex;  // Integer value of current location of the actor.
	private int actorID;               // Integer value of the actor ID for quick reference and easy management.
	private String labelID;            // String value of the actor ID or label for quick reference.
	private String alias;              // String value of the actor's nickname.
	private String name;               // String value of full name of actor.
	private String occupation;         // String value of actor's occupation/profession.
	private String description;        // String value of description of an actor.
	private boolean hasMet;            // Returns the boolean value if this actor met the player.
	private String[] attribute;	       // String array list of actor's attribute. 
	private int attributeCount;        // Integer value of total attributes count.
	private int[] seenAtLocation;      // Integer value of where the actor can be seen.
	private int locationCount;         // Integer value of total location count.
	private String[] dialog;           // String value of actor's dialog.
	private int dialogCount;           // Integer value of total dialog the actor have.
	private String alibi;              // String value of actor's alibi why their not the culprit.
	private boolean isCulprit;         // Boolean to identify if this actor is the culprit.
	private static final int MAX_ATTRIBUTES = 5;  // Fixed-size arrays to manage attributes.
	private static final int MAX_LOCATIONS = 3;   // Fixed-size arrays to manage locations.
	
	/**
	 * The Actor method contains the various attributes for the actors including where they can be found, how much dialog they have,
	 * whether the user has met with them, and etc. There's also a bunch of if statements to identify the role/occupation of the actor.
	 */
	
	Actor(int numID, String alias, String name, String occupation, String description) 
	{
		this.currentLocationIndex = 0;
		this.actorID = numID;
		this.alias = alias;
		this.name = name;
		this.occupation = occupation;
		this.description = description;
		this.hasMet = false;
		this.attribute = new String[MAX_ATTRIBUTES];
		this.attributeCount = 0;
		this.seenAtLocation = new int[MAX_LOCATIONS];
		this.locationCount = 0;
		this.dialog = new String[MAX_ATTRIBUTES];
		this.dialogCount = 0;
		this.alibi = null;
		this.isCulprit = false;
		if (numID == 0) 
		{ 
			this.labelID = "the_manager";
		}
		else if (numID == 1) 
		{ 
		this.labelID = "the_actor";
		}
		else if (numID == 2) 
		{ 
			this.labelID = "the_military";
		}
		else if (numID == 3) 
		{ 
			this.labelID = "the_gambler";
		}
		else if (numID == 4) 
		{
			this.labelID = "the_scientist";
		}
		else if (numID == 5) 
		{
			this.labelID = "the_priest";
		}
		else if (numID == 6) 
		{ 
			this.labelID = "the_pyschic";
		}
		else if (numID == 7) 
		{ 
			this.labelID = "the_chef";
		}
		else if (numID == 8) 
		{ 
			this.labelID = "the_bartender";
		}
		else if (numID == 9) 
		{ 
			this.labelID = "the_professor";
		}
		else if (numID == 10) 
		{
			this.labelID = "the_athlete";
		}
		else if (numID == 11) 
		{ 
			this.labelID = "the_blogger";
		}
		else if (numID == 12) 
		{ 
			this.labelID = "the_politician";
		}
		else if (numID == 13) 
		{
			this.labelID = "the_businessman";
		}
		else if (numID == 14) 
		{ 
			this.labelID = "the_Doctor";
		}
		else 
		{ 
			this.labelID = "johndoe"; 
		}
	}
	
	/**
	 * This method adds any attribute to an Actor and prevents an actor from getting too many attributes.
	 */
	
	public void addAttribute(String newAttribute) 
	{
        if (attributeCount < MAX_ATTRIBUTES) 
        {
            attribute[attributeCount] = newAttribute;
            attributeCount++;
        } 
        else 
        {
            System.out.println("Error: Maximum attributes reached for " + this.name);
        }
    }
	
	/**
	 * This method adds the attribute for where an actor can be found. There's also a code that prevents an actor from being placed into
	 * too many locations.
	 */
	
	public void addLocation(int locationID) 
	{     
        if (locationCount < MAX_LOCATIONS) 
        {
            seenAtLocation[locationCount] = locationID;
            locationCount++;
        } 
        else 
        {
            System.out.println("Error: Maximum location reached for " + this.name);
        }
    }
	
	/**
	 * This method adds dialog events for the actor. It also prevents an actor from getting too much dialog.
	 */
	
	public void addDialog(String newDialog) 
	{         
		if (dialogCount < MAX_LOCATIONS) 
		{
			dialog[dialogCount] = newDialog;
			dialogCount++;
		} 
		else 
		{
			System.out.println("Error: Maximum dialog reached for " + this.name);
		}
	}

	/**
	 * These three methods are setters for the actors for if the User has met them, if they are the culprit, and where they can be found.
	 */
	
    public void setCurrentLocationIndex(int currentLocationIndex) 
    {        // Set the current location from the Integer value in the parameter.
        this.currentLocationIndex = currentLocationIndex;
    }
	public void setIsCulprit(boolean isTheCulprit) 
	{ 
		this.isCulprit = isTheCulprit; 
	}
	public void setHasMeet(boolean hasMet) 
	{
		this.hasMet = hasMet;
	}
	
	/**
	 * The rest of these methods are getters, obtaining certain attributes of the actors and returning the value of the attribute.
	 */
	
	public int getCurrentLocationIndex() 
	{ 
		return currentLocationIndex; 
	}  // Returns Integer value of where the actor's current location.
    public int getActorID() 
    { 
    	return actorID;
    }
	public String getLabelID() 
	{ 
		return labelID;
	}
	public String getAlias() 
	{ 
		return alias;
	}
	public String getName() 
	{ 
		return name;
	}	
	public String getDescription() 
	{ 
		return description;
	}
	public String getOccupation() 
	{ 
		return occupation;
	}
	public String getAttribute(int index) 
	{ 
		return attribute[index];
	}
	public String getGender() 
	{ 
		return attribute[1];
	}
	public String getHairColor() 
	{ 
		return attribute[2];
	}
	public String getOdor() 
	{ 
		return attribute[3];
	}
	public String getBodyFrame() 
	{ 
		return attribute[4];
	}
	public int getLocation(int index) 
	{ 
		return seenAtLocation[index]; 
	}
	public String getDialog(int index) 
	{ 
		return dialog[index]; 
	}
	public boolean getIsCulprit() 
	{ 
		return isCulprit; 
	}
	public String getAlibi() 
	{ 
		return alibi;
	}
	public boolean getHasMeet() 
	{ 
		return hasMet;
	}
}
