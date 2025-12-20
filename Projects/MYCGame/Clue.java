
/**
 * The clue class contains the attributes for clues as well as locations.
 */

public class Clue 
{
	
	private String label;
	private String clueDesc;
	private boolean found;
	private static final int MAX_LOCATIONS = 5;
	private int[] location;
	private String[] locDesc;
	private int locationCount;
	
	/**
	 * The Clue method identifies the attributes of a given clue. This includes the name of the clue, its description,
	 * if it was found and its location.
	 */
	
	public Clue(String name, String description) 
	{
		this.label = name;
		this.clueDesc = description;
		this.found = false;
		this.location = new int[MAX_LOCATIONS];
		this.locDesc = new String[MAX_LOCATIONS];
		this.locationCount = 0;
	}
	
	/**
	 * The addLocation method assigns locations to the clues and prevents the clues from being
	 * placed in too many locations.
	 */
	
	public void addLocation(int locationID, String str) 
	{
        if (locationCount < MAX_LOCATIONS) 
        {
            location[locationCount] = locationID;
            locDesc[locationCount] = str;
            locationCount++;
        } 
        else 
        {
            System.out.println("Error: Maximum locations reached for this clue... " + this.label);
        }
    }
	
	/**
	 * These last 4 methods simply return the value of certain attributes of the clues.
	 */
	
	public String getLabel() 
	{ 
		return label;
	}
	public String getClueDesc() 
	{ 
		return clueDesc; 
	}
	public boolean found() 
	{ 
		return found; 
	}
    public String getLocDesc(int index) 
    {
    	return locDesc[index];
    }
 
}
