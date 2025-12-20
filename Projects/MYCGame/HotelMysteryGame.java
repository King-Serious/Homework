import java.util.Scanner;

/**
 * This class contains the main configuration of my Hotel Mystery Game.
 */

public class HotelMysteryGame 
{
	// These few lines set up certain mechanics for the game, including the time limit for the game.
	// The last three lines simplifies the code to turn text into styles like italics, bold, and regular text.
	public static final int maxDaysPassed = 8;     // Set the number of days before the game is terminated.
	public static final int wakeUpTime = 420;      // Set the time (in minutes) the day would start. 420 mins = 7 AM.
	public static final int sleepTime = 1440;      // Set the time (in minutes) the day would end. 1440 mins = 12 midnight.
	public static final int minCluesRequired = 5;  // Set the required number of clues the player needs to find to solve the mystery.
	public static final int maxStorylines = 2;     // Set a maximum amount of storylines available in the game.
	public static final int maxClues = 10;         // Set a maximum number of clues per storyline.
	public static final int maxTriggerClues = 6;   // Set a maximum number of trigger clues in a storyline.
	public static final int maxSuspectList = 6;    // Set a maximum number of suspects for solving the mystery. 
	public static final int maxEndings = 3;        // Set a maximum number of possible endings for both win and lose endings. So if amount is 3, total would be 6 endings.
	public static final String lineDivider = "-------------------------------------------------";  // Just a line divider.
	public static final int charPerLn = 148;         // Set the maximum characters per line allowed to print for long strings or a paragraph.
	public static final String textBold = "\033[1m";    // Set text to bold.
	public static final String textItalic = "\033[3m";    // Set text to italic.
	public static final String textNormal = "\033[0m";    // Set text to normal.
	
    // These lines contain constants for the locations in the game
	// This section assigns an easy word to remember to a location instead of using numbers.
	// This makes it easier to remember the names of the variables and their values when used for
	// Arrays.
    public static final int area_Lobby = 0;
    public static final int area_Elevator = 1;
    public static final int area_Casino = 2;
    public static final int area_Wellness = 3;
    public static final int area_Dining = 4;
    public static final int area_Beach = 5; // Starts as a restricted Area
    public static final int area_Room224 = 6;
    public static final int area_Penthouse = 7;
    public static final int area_FrontDesk = 8;
    public static final int area_Security = 9;  // Starts as a restricted Area
    public static final int area_PokerTable = 10;
    public static final int area_Spa = 11;
    public static final int area_Gym = 12;
    public static final int area_Pool = 13;
    public static final int area_Shore = 14;
    public static final int area_Jungle = 15;  // Restricted Area
    public static final int area_Cafe = 16;
    public static final int area_Steakhouse = 17;
    public static final int area_Asian = 18;
    public static final int area_Bar = 19;
    public static final int area_Clinic = 20;
    public static final int num_MainArea = 21;  // This is the total number of locations.

    // These lines contain constants for the clues in the game, which will be used in arrays.
    public static final int CLUE_JOURNAL = 0;
    public static final int CLUE_SYRINGE = 1;
    public static final int CLUE_CULT_SYMBOL = 2;
    public static final int CLUE_BROTHER_ID = 3;
    public static final int CLUE_LETTER = 4;
    public static final int NUM_CLUES = 5;
    
 // These lines contain constants for the NPCs/Actors in the game, which will be used in arrays.
    public static final int the_manager = 0;
    public static final int the_actor = 1;
    public static final int the_military = 2;
    public static final int the_gambler = 3;
    public static final int the_scientist = 4;
    public static final int the_priest = 5;
    public static final int the_psychic = 6;
    public static final int the_chef = 7;
    public static final int the_bartender = 8;
    public static final int the_professor = 9;
    public static final int the_athlete = 10;
    public static final int the_blogger = 11;
    public static final int the_politician = 12;
    public static final int the_businessman = 13;
    public static final int the_doctor = 14;
    public static final int num_TheActors = 15;  // This is the total number of actors and possibly one of them is the main suspect.
    
    // These lines contain certain attributes regarding the User's name and also provides the option to skip character creations
    // And the prologue of the game.
 	private static boolean isNewCharacter = true;         // DEBUGGING TIP: Change the value to false to skip create a character.
 	private static boolean runIntro = true;               // DEBUGGING TIP: Change the value to false to skip the long game introduction.
 	private static String firstName = "Sherlock";          // Just the first name of the player's character. Default = Sherlock
 	private static String lastName = "Holmes";             // Just the last name of the player's character. Default = Holmes
 	private static String userGender = "male";             // The gender of the player's character. Default is set to male.
 	private static String playerShortName = "Mr. Holmes";  // Default name use when hotel staff address the player.   
 	private static boolean hasSolved = false;
 	
 	// These lines contain variables that record what happens so far in a User's play through of the game.
 	static int storylineID;  // Using integer to select which storyline of the game is run.
 	static int minsPassed;   // Using integer as the total number of minutes that have passed in a day.
 	static int daysPassed;   // Using integer as the total number of days that have passed in a game.
 	static int cluesFoundCount;  // Using the integer to count how many clues found by the player.
 	static String culprintName = "";  // CURRENTLY USE FOR TESTING STAGE. May not be needed in the program.
 	static int culpritID = 0;  // CURRENTLY USE FOR TESTING STAGE. May not be needed in the program.
 	static int storyClueLoc1 = 0;  // Story Clue Location 1.
 	static int storyClueLoc2 = 0;  // Story Clue Location 2.
 	static int storyClueLoc3 = 0;  // Story Clue Location 3.
 	static int storyClueLoc4 = 0;  // Story Clue Location 4.
 	static int storyClueLoc5 = 0;
 	static int maxStoryClues = 5;
 	static int emptyLocationID1 = 0;  // CURRENTLY USE FOR TESTING STAGE. May not be needed in the program.
 	static int emptyLocationID2 = 0;  // CURRENTLY USE FOR TESTING STAGE. May not be needed in the program.
 	static int emptyLocationID3 = 0;  // CURRENTLY USE FOR TESTING STAGE. May not be needed in the program.
 	static String[] winEndingsPart1 = new String[maxEndings];   // Using String Array to contain list of Winner Story Endings (Part 1).
 	static String[] winEndingsPart2 = new String[maxEndings];   // Using String Array to contain list of Winner Story Endings (Part 2).
    static String[] failEndingsPart1 = new String[maxEndings];  // Using String Array to contain list of Loser Story Endings (Part 1).
    static String[] failEndingsPart2 = new String[maxEndings];  // Using String Array to contain list of Loser Story Endings (Part 2).
    static int winEndCount = maxEndings;   // Using Integer as the maximum number of Winner Story Endings ACTIVELY available when new game starts.
    static int failEndCount = maxEndings;  // Using Integer as the maximum number of Winner Story Endings ACTIVELY available when new game starts.
    static String culpritTrait;   // Culprit's unique trait.
	static String culpritGender;  // Culprit's gender.
	static String culpritHair;    // Culprit's hair color.
	static String culpritOdor;    // Culprit's odor/smell.
	static String culpritFrame;   // Culprit's body frame.
	static int witnessGenderID = -1;
	static int witnessColorID = -1;
	static int witnessOdorID = -1;
	static int witnessFrameID = -1;
	static boolean hasFoundGender = false;
	static boolean hasFoundColor = false;
	static boolean hasFoundOdor = false;
	static boolean hasFoundFrame = false;
 	static boolean gameOver;  // Using Boolean. TRUE or FALSE if game is over.
 	
 	static String endingMsgPart1 = "";
 	static String endingMsgPart2 = "";

	private static Clue[] storyClues;      // Using Class array to contain all the clues in a CHOSEN storyline when new game starts.	
 	private static Location[] hotelMap;  // Using Class array to contain all the location found in the game.
 	private static Actor[] allActors;    // Using Class array to contain all the actors found in the game.
 	private static Actor[] liveActors;   // Usinc Class array to contain all the actors that will be use when a new game starts.
 	private static Actor[] suspects;     // Using Class array to contain all possible suspects found in the game.
    private static Player player;        // Using Class array to contain the player (not the actor) attributes like clues found, current location.
    private static Actor mastermind;
    private static Actor witnessGender;
    private static Actor witnessColor;
    private static Actor witnessOdor;
    private static Actor witnessFrame;   
    
    private static Scanner scanner = new Scanner(System.in);

/**
 * The main method simply activates the method that begins the game and once the game is done,
 * Prompts the player with the option to play again.
 */
    public static void main(String[] args) 
    {
        initializeGame();
        gameEngine();
    }    
/**
 * The initalizeGame method sets up all the needed variables of the game such as the
 * location and actors and provides them with their attributes.
 */
    private static void initializeGame() 
    {
        hotelMap = new Location[num_MainArea];  // Identifies hotelMap as Location array
        
        // These lines initializes the different locations that can be accessed in the game and assigns them different attributes.
        hotelMap[area_Lobby] = new Location("The Grand Lobby", "A lavish, marble-floored lobby with a large check-in desk.", "Hotel Front Desk.", true);
        hotelMap[area_Elevator] = new Location("The Hotel Room Elevator", "A standard, albeit luxurious, guest room. It looks recently vacated.", "Room 224 and Penthouse Suite.", true);
        hotelMap[area_Casino] = new Location("The Casino Floor", "Rows of slot machines and poker tables, mostly empty at this hour.", "Casino Table and Security Room.", true);
        hotelMap[area_Wellness] = new Location("The Wellness Center Lobby", "Home of the famous spa and gym, and the award-winning swimming pool.", "Spa, Gym, Swimming Pool, and Hotel Clinic.", true);
        hotelMap[area_Dining] = new Location("The Hotel Dining Area", "A massive hall with crystal chandeliers.", "Steakhouse, Cafe, Noodlehouse, and The Bar.", true);
        hotelMap[area_Beach] = new Location("The Island Beach Area", "This world-class island beach boasts a breathtaking shoreline of powdery golden sand and crystal-clear turquoise waters, while just beyond a secure fence, a lush, vibrant jungle teems with exotic wildlife and natural wonders.", "Shore and Jungle.", true);
        hotelMap[area_Room224] = new Location("Room 224", "A standard Luxury room.", "Go back to the Hotel Room Elevator.", false);
        hotelMap[area_Penthouse] = new Location("The Penthouse Suite", "A luxurious suite overlooking the ocean, usually reserved for VIPs. Your missing brother stayed here.\n The hotel manager allowed you access this suite up to the third day.", "Go back to the Hotel Room Elevator.", true);
        hotelMap[area_FrontDesk] = new Location("The Front Desk", "The front desk srtretches in a graceful arc of pristine marble, adorned with fresh orchids and soft golden lighting that glimmers across its polished surface, creating an atmosphere of elegance and welcoming sophistication.", "Go back to the Grand Lobby.", true);
        hotelMap[area_Security] = new Location("The Security Room", "A fortified enclave lined with monitors displaying live feeds from every corner of the hotel & casino, illuminated by blinking control panels and the steady glow of surveillance screens.", "Go back to the Casino Floor.", false);
        hotelMap[area_PokerTable] = new Location("The Casino Table", "Sleek gambling tables, each topped with lush green felt and rimmed with polished brass, are artfully arranged beneath sparkling chandeliers, inviting guests into an atmosphere of refined excitement and high-stakes glamour.", "Go back to the Casino Floor.", true);
        hotelMap[area_Spa] = new Location("The JC's Salon & Spa", "The salon & spa exudes tranquility with plush seating, shimming chandeliers, and soothing aromas, offering a serene retreat amid refined decor.", "Go back to the Wellness Center Lobby.", true);
        hotelMap[area_Gym] = new Location("The Jesse Gym", "The gym glistens with state-of-the-art equipment, polished mirrors, and a panoramic wall of windows framing breathtaking ocean views.", "Go back to the Wellness Center Lobby.", true);
        hotelMap[area_Pool] = new Location("The Swimmming Pool", "Features an award-winning pool with crystal-clear waters, elegant infinity edges, and panoramic ocean views, with a stylish bar nearby offering guests signature cocktails and refreshments for a truly luxurious oasis.", "Tipsy Oyster Bar, or Go back to the Wellness Center Lobby.", true);
        hotelMap[area_Clinic] = new Location("The Hotel Clinic", "The small clinic is a discreet, impeccably clean sanctuary outfitted with the latest medical technology, and designed to offer guests comfort and privacy in elegeant surroundings.", "Go back to the Wellness Center Lobby.", true);
        hotelMap[area_Shore] = new Location("The Beach Shore", "Golden sands stretch along a pristine shoreline where turquoise waves gently lap, framed by swaying palms and spectacular ocean vistas, creating an unforgettable paradise for relaxation and adventure.", "Go back to the Island Beach Area.", true);
        hotelMap[area_Jungle] = new Location("The Island Jungle", "A dense, humid path. The foliage is thick, hiding most of the surroundings.", "Go back to the Island Beach Area.", false);
        hotelMap[area_Steakhouse] = new Location("The JTK Steakhouse", "A fancy restaurant known for its ribeye steak and pasta.", "Go back to the Hotel Dining Area.", true);
        hotelMap[area_Cafe] = new Location("Le Short N' Sweet Cafe", "A beautiful French Cafe overlooking the ocean.", "Go back to the Hotel Dining Area.",true);
        hotelMap[area_Asian] = new Location("The Jinya Dumplings & Noodlehouse", "This place is a foodie delight and who loves to explore Asian cuisine.", "Go back to the Hotel Dining Area.",true);
        hotelMap[area_Bar] = new Location("The Tipsy Oyster Bar", "A luxurious bar situated near the swimming pool. Bottles of rare spirits line the back wall.", "Swimming Pool, or Go back to the Hotel Dining Area.",true);
        
        // These lines help form the paths of the locations, connecting each of them with certain locations
        // So you can't necessarily go from one place to any other spot.
        // Format: (Source, Destination Index, Direction Name)
        hotelMap[area_Lobby].addExit(area_FrontDesk, "Visit the Front Desk");
        hotelMap[area_Lobby].addExit(area_Elevator, "Go to the Hotel Room Elevator");        
        hotelMap[area_Lobby].addExit(area_Casino, "Go to the Casino Floor");
        hotelMap[area_Lobby].addExit(area_Wellness, "Go to the Wellness Center Lobby");
        hotelMap[area_Lobby].addExit(area_Dining, "Go to the Hotel Dining Area");
        hotelMap[area_Lobby].addExit(area_Beach, "Go to the Island Beach area");

        hotelMap[area_Elevator].addExit(area_Lobby, "Go back to the Grand Lobby");
        hotelMap[area_Elevator].addExit(area_Room224, "Visit the Guest Room 224");  // Keycard needed
        hotelMap[area_Elevator].addExit(area_Penthouse, "Visit the Penthouse Suite");
        
        hotelMap[area_Casino].addExit(area_Lobby, "Go back to the Grand Lobby");
        hotelMap[area_Casino].addExit(area_PokerTable, "Visit the Casino Table");
        hotelMap[area_Casino].addExit(area_Security, "Visit the Security Room");  // Keycard needed
        
        hotelMap[area_Wellness].addExit(area_Lobby, "Go back to the Grand Lobby");
        hotelMap[area_Wellness].addExit(area_Spa, "Visit the JC's Salon & Spa");
        hotelMap[area_Wellness].addExit(area_Gym, "Visit the Jesse Gym");
        hotelMap[area_Wellness].addExit(area_Pool, "Visit the Swimming Pool");
        hotelMap[area_Wellness].addExit(area_Clinic, "Visit the Hotel Clinic");
        
        hotelMap[area_Dining].addExit(area_Lobby, "Go back to the Grand Lobby");
        hotelMap[area_Dining].addExit(area_Steakhouse, "Visit the JTK Steakhouse");
        hotelMap[area_Dining].addExit(area_Cafe, "Visit Le Short N' Sweet Cafe");
        hotelMap[area_Dining].addExit(area_Asian, "Visit the Jinya Dumplings & Noodlehouse");
        hotelMap[area_Dining].addExit(area_Bar, "Visit the Tipsy Oyster Bar");

        hotelMap[area_Beach].addExit(area_Lobby, "Go back to the Grand Lobby");
        hotelMap[area_Beach].addExit(area_Shore, "Visit the Beach Shore");
        hotelMap[area_Beach].addExit(area_Jungle, "Visit the Island Jungle");  // Keycard needed
        
        hotelMap[area_Room224].addExit(area_Elevator, "Go back to the Hotel Room Elevator");        
        hotelMap[area_Penthouse].addExit(area_Elevator, "Go back to the Hotel Room Elevator");
        
        hotelMap[area_FrontDesk].addExit(area_Lobby, "Go back to the Grand Lobby");
        
        hotelMap[area_Security].addExit(area_Casino, "Go back to the Casino Floor");
        hotelMap[area_PokerTable].addExit(area_Casino, "Go back to the Casino Floor");
        
        hotelMap[area_Spa].addExit(area_Wellness, "Go back to the Wellness Center Lobby");
        hotelMap[area_Gym].addExit(area_Wellness, "Go back to the Wellness Center Lobby");
        hotelMap[area_Pool].addExit(area_Wellness, "Go back to the Wellness Center Lobby");
        hotelMap[area_Pool].addExit(area_Bar, "Visit the Tipsy Oyster Bar");  // Connected to the Bar
        hotelMap[area_Clinic].addExit(area_Wellness, "Go back to the Wellness Center Lobby");
        
        hotelMap[area_Shore].addExit(area_Beach, "Go back to the Island Beach Area");
        hotelMap[area_Jungle].addExit(area_Beach, "Go back to the Island Beach Area");
        
        hotelMap[area_Steakhouse].addExit(area_Dining, "Go back to the Dining Area");
        hotelMap[area_Cafe].addExit(area_Dining, "Go back to the Dining Area");
        hotelMap[area_Asian].addExit(area_Dining, "Go back to the Dining Area");
        hotelMap[area_Bar].addExit(area_Dining, "Go back to the Dining Area");
        hotelMap[area_Bar].addExit(area_Pool, "Visit the Swimming Pool");  // Connected to the Pool

        
        // Clue indices: 0=Journal, 1=Syringe, 2=CultSymbol, 3=BrotherID
        hotelMap[area_Elevator].setClueIndex(CLUE_JOURNAL);
        hotelMap[area_Beach].setClueIndex(CLUE_SYRINGE);
        hotelMap[area_Casino].setClueIndex(CLUE_CULT_SYMBOL);
        hotelMap[area_FrontDesk].setClueIndex(CLUE_LETTER);
        
        allActors = new Actor[num_TheActors];  // Identifies allActors as Actor array
        
        // Initialize Actor(ActorID, alias, name, occupation, description).
        // And then add attributes: uniqueness, gender, hair color, odor, and body frame.
        // Assign actor's current location.
        // Add actor's dialog.
        allActors[the_manager] = new Actor(the_manager, "Mr. Sterling", "Mr. Rod Sterling", "Hotel Manager", "He is the Hotel Manager.");
        allActors[the_manager].addAttribute("His attire is consistently a flashy suit and a matching pink nectie.");  // unique attribute
        allActors[the_manager].addAttribute("male");
        allActors[the_manager].addAttribute("black");
        allActors[the_manager].addAttribute("jasmine");
        allActors[the_manager].addAttribute("medium");
        allActors[the_manager].setCurrentLocationIndex(area_FrontDesk);
        allActors[the_manager].addDialog("You say hello to the Hotel manager. He responded: Sorry, I'm too busy right now.");
        
        
        allActors[the_actor] = new Actor(the_actor, "Rihanna", "Rihanna Doit-Trang", "Hollywood actor", "A former Hollywood actor who enjoys ongoing attention.");
        allActors[the_actor].addAttribute("She always wear clothes covered in glitter.");
        allActors[the_actor].addAttribute("female");
        allActors[the_actor].addAttribute("blond");
        allActors[the_actor].addAttribute("jasmine.");
        allActors[the_actor].addAttribute("small");
        allActors[the_actor].setCurrentLocationIndex(area_Spa);
        allActors[the_actor].addDialog("You said hello to the actor. She responded: Would you like me to sign you an autograph? You replied: Nope.");
        
        allActors[the_military] = new Actor(the_military, "Gen. Guchkiszer", "Gen. Axel Guchkiszer", "Veteran General", "A veteran general who is feared by politician.");
        allActors[the_military].addAttribute("A stark, massive scar cut across his left cheek.");
        allActors[the_military].addAttribute("male");
        allActors[the_military].addAttribute("gray");
        allActors[the_military].addAttribute("musky");
        allActors[the_military].addAttribute("medium");
        allActors[the_military].setCurrentLocationIndex(area_Bar);
        allActors[the_military].addDialog("You said hello to General Gushkiszer. He responded: Do I know you? You replied: Nope.");
        
        allActors[the_gambler] = new Actor(the_gambler, "Mister James", "James Amuslichter III", "gambler", "The compulsive gamber who owns a big computer company.");
        allActors[the_gambler].addAttribute("He is always dressed in a white hoodie with a rabbit foot belt clip attached to his waist.");
        allActors[the_gambler].addAttribute("male");
        allActors[the_gambler].addAttribute("red");
        allActors[the_gambler].addAttribute("alcohol");
        allActors[the_gambler].addAttribute("large");
        allActors[the_gambler].setCurrentLocationIndex(area_PokerTable);
        allActors[the_gambler].addDialog("You said hello to Mister James. He responded: I can't talk to you right now. I got to focus to win. You left him alone.");
        
        allActors[the_scientist] = new Actor(the_scientist, "Prof. Mus", "Prof. Anon E. Mus", "scientist", "A former librarian who turned into a scientist.");
        allActors[the_scientist].addAttribute("She always wear her company ID, with a big smiley face on it.");
        allActors[the_scientist].addAttribute("female");
        allActors[the_scientist].addAttribute("brown");
        allActors[the_scientist].addAttribute("musky");
        allActors[the_scientist].addAttribute("medium");
        allActors[the_scientist].setCurrentLocationIndex(area_Jungle);
        allActors[the_scientist].addDialog("You said hello to Prof. Mus. She just ignored you and went to go on her business.");
        
        allActors[the_priest] = new Actor(the_priest, "Father Rok", "Father Roku Nana", "clergyman", "A well-known clergyman, noted particularly for his controversial past.");
        allActors[the_priest].addAttribute("He always wears a heavy gold cross pendant around his neck.");
        allActors[the_priest].addAttribute("male");
        allActors[the_priest].addAttribute("brown");
        allActors[the_priest].addAttribute("musky");
        allActors[the_priest].addAttribute("small");
        allActors[the_priest].setCurrentLocationIndex(area_Cafe);
        allActors[the_priest].addDialog("You said hello to the priest. He responded: Have you been good, lately? You replied: Nevermind.");
        
        allActors[the_psychic] = new Actor(the_psychic, "Ms. Outback", "Ms. Subaru Outback", "psychic", "Once a celebrated psychic, she was slowly discredited as her uncanny accuracy faltered, and audiences grew weary.");
        allActors[the_psychic].addAttribute("wears purple necklace");
        allActors[the_psychic].addAttribute("female");
        allActors[the_psychic].addAttribute("black");
        allActors[the_psychic].addAttribute("alcohol");
        allActors[the_psychic].addAttribute("small");
        allActors[the_psychic].setCurrentLocationIndex(area_Asian);
        allActors[the_psychic].addDialog("You were about to say hello to the psychic but she interrupted you and said: I know what you're going to say to me and the answer is no. And the psychic went away.");
        
        allActors[the_chef] = new Actor(the_chef, "Chef Slabe", "Chef Iona Slabe", "chef/owner", "She is both the chef and owner of a barbecue restaurant whose fame ended abruptly when the scandal began.");
        allActors[the_chef].addAttribute("She always wears her signature dark glasses, even after the sun goes down.");
        allActors[the_chef].addAttribute("female");
        allActors[the_chef].addAttribute("gray");
        allActors[the_chef].addAttribute("alcohol");
        allActors[the_chef].addAttribute("large");
        allActors[the_chef].setCurrentLocationIndex(area_Steakhouse);
        allActors[the_chef].addDialog("You said hello to Chef Slabe. She responded: If you want to eat better food, go to my restaurant. You left her.");
        
        allActors[the_bartender] = new Actor(the_bartender, "Jay-Dee", "Ms. Jay Daquiri", "bartender", "She's the type of bartender who tell tall tales, leaving patrons to wonder what's true and what's invented.");
        allActors[the_bartender].addAttribute("A vibrant red streak cuts through her black hair");
        allActors[the_bartender].addAttribute("female");
        allActors[the_bartender].addAttribute("black");
        allActors[the_bartender].addAttribute("jasmine");
        allActors[the_bartender].addAttribute("medium");
        allActors[the_bartender].setCurrentLocationIndex(area_Bar);
        allActors[the_bartender].addDialog("You said hello to the bartender. She responded: What can I get you? You replied: Umm, Not today.");
        
    	allActors[the_professor] = new Actor(the_professor, "Prof. Knight", "Prof. White Knight", "university professor", "A strikingly masculine and highly respected math professor at a well-known university, he carries a shadow of scandal from his past.");
    	allActors[the_professor].addAttribute("He always sports a fedora and carries a Big Gulp cup.");
    	allActors[the_professor].addAttribute("male");
    	allActors[the_professor].addAttribute("blond");
    	allActors[the_professor].addAttribute("jasmine");
    	allActors[the_professor].addAttribute("large");
    	allActors[the_professor].setCurrentLocationIndex(area_Gym);
    	allActors[the_professor].addDialog("You said hello to Prof. Knight. He just mumbled some gibberish words and went away.");
    	
    	allActors[the_athlete] = new Actor(the_athlete, "Angle The Queen", "Mrs. Angle Release", "professional basketball player", "She is a boastful professional basketball player whose on-court performance, particularly her struggles with simple layups, does not much match her bold claims, including her assertion that she can defeat LeBron James.");
    	allActors[the_athlete].addAttribute("She has aggressively long eyelashes and is always wearing her golden athletic shoes.");
    	allActors[the_athlete].addAttribute("female");
    	allActors[the_athlete].addAttribute("red");
    	allActors[the_athlete].addAttribute("musky");
    	allActors[the_athlete].addAttribute("large");
    	allActors[the_athlete].setCurrentLocationIndex(area_Gym);
    	allActors[the_athlete].addDialog("You said hello to Mrs. Release. She angrily responded: Don't yah call me that! I'm the Queen. She then left you.");
    	
    	allActors[the_blogger] = new Actor(the_blogger, "Ms. Brianna", "Brianna Fan", "food blogger", "She is a famous food blogger whose reputation was damaged following a recent controversial incident.");
    	allActors[the_blogger].addAttribute("Her eyes are enhanced by gray contacts, and she speaks with a high-pitched, dynamic voice.");
    	allActors[the_blogger].addAttribute("female");
    	allActors[the_blogger].addAttribute("brown");
    	allActors[the_blogger].addAttribute("jasmine");
    	allActors[the_blogger].addAttribute("small");
    	allActors[the_blogger].setCurrentLocationIndex(area_Asian);
    	allActors[the_blogger].addDialog("You said hello to Ms.Brianna. She responded: Are you a follower of mine? If not, I don't have to chat with you. You replied: I don't know you that much.");
    	
    	allActors[the_politician] = new Actor(the_politician, "Congressman Klank", "Dr. Charles Klank", "politician", "Like many unscrupulous politicians, he has been plagued by numerous scandals; he still plans to run for the next election.");
    	allActors[the_politician].addAttribute("He greets everyone with an artificial smile, a facade matched only by the campaign badge pin he wears at all times.");
    	allActors[the_politician].addAttribute("male");
    	allActors[the_politician].addAttribute("gray");
    	allActors[the_politician].addAttribute("jasmine");
    	allActors[the_politician].addAttribute("medium");
    	allActors[the_politician].setCurrentLocationIndex(area_Cafe);
    	allActors[the_politician].addDialog("You said hello to Dr.Klank. He replied: Don't believe in fake news about me. Vote for me in the next election. And he gave you his campaign pin but you refused.");
    	
    	allActors[the_businessman] = new Actor(the_businessman, "Mr. Yogumi", "Mr. Heavy Yogumi", "businessman", "He is a high profile businessman of a large company whose successful career was overshadowed by controversy and private turmoil.");
    	allActors[the_businessman].addAttribute("He maintains a flawless poker face but possesses a twisted mind, a trait perhaps related to the set of three matching, elegant golden smartphones he always carries.");
    	allActors[the_businessman].addAttribute("male");
    	allActors[the_businessman].addAttribute("red");
    	allActors[the_businessman].addAttribute("musky");
    	allActors[the_businessman].addAttribute("medium");
    	allActors[the_businessman].setCurrentLocationIndex(area_PokerTable);
    	allActors[the_businessman].addDialog("You said hello to Mr. Yogumi. He said: I don't have time to talk to you. Please go away!");
    	
    	allActors[the_doctor] = new Actor(the_doctor, "Dr. Pekka", "Dr. Anitta Pekka", "doctor", "She is a renowned doctor and a colleague of your brother's; however, little is known about her personally.");
    	allActors[the_doctor].addAttribute(("She is never without her mask and gloves; a custom-made metallic holster keeps her hand sanitizer spray readily accessible."));
    	allActors[the_doctor].addAttribute("female");
    	allActors[the_doctor].addAttribute("blond");
    	allActors[the_doctor].addAttribute("musky");
    	allActors[the_doctor].addAttribute("large");
    	allActors[the_doctor].setCurrentLocationIndex(area_Clinic);
    	allActors[the_doctor].addDialog("You said hello to Dr. Pekka. She responded: Please don't touch me and she walk away from you.");
        
        player = new Player(area_Lobby);
        liveActors = new Actor[num_TheActors];
        suspects = new Actor[num_TheActors];        
    }

    /**
     * The setupMystery method randomizes and selects a certain storyline/mystery for the game to play.
     */
    
    private static void setupMystery() 
    {  
    	// These clues changes at the start of the game depending which Storyline the randomizer result.   	
    	// Initialize the variables below every start of game.
    	witnessGenderID = -1;
    	witnessColorID = -1;
    	witnessOdorID = -1;
    	witnessFrameID = -1;
    	hasFoundGender = false;
    	hasFoundColor = false;
    	hasFoundOdor = false;
    	hasFoundFrame = false;
    	
    	// These lines setup the suspects and identifies the mastermind.
    	liveActors = allActors;                         // Copy allActors array to liveActors for the new game. [CLASS ARRAY]
    	shuffleActors(liveActors);                      // Randomize the list in the liveActors array. [CLASS ARRAY]
    	suspects = liveActors;                          // Pick suspects from liveActors. For now, pick all of the liveActors. [CLASS ARRAY]    	
    	suspects[0].setIsCulprit(true);                 // Marked the suspect as the mastermind. [CLASS ARRAY]
    	mastermind = suspects[0];                       // Pick the first suspect to be the mastermind. [CLASS ARRAY]
    	culpritTrait = suspects[0].getAttribute(0);     // Assign mastermind's unique trait. [STRING]
    	culpritGender = suspects[0].getAttribute(1);    // Assign mastermind's gender. [STRING]
    	culpritHair = suspects[0].getAttribute(2);      // Assign mastermind's hair color. [STRING]
    	culpritOdor = suspects[0].getAttribute(3);      // Assign mastermind's odor. [STRING]
    	culpritFrame = suspects[0].getAttribute(4);     // Assign mastermind's body frame. [STRING]
    	suspects = findSuspects(mastermind, suspects);  // Cut number of suspects to total of 6 (including mastermind) that has the same attribute with mastermind. [CLASS ARRAY]
    	witnessGender = liveActors[11];                   // Assign suspect number 11 to be the witness of the gender of the culprit.
    	witnessColor = liveActors[12];                    // Assign suspect number 12 to be the witness of the hair color of the culprit.
    	witnessOdor = liveActors[13];                     // Assign suspect number 13 to be the witness of the smell of the culprit.
    	witnessFrame = liveActors[14];                    // Assign suspect number 14 to be the witness of the culprit's body frame.
    	witnessGenderID = liveActors[11].getActorID();
    	witnessColorID = liveActors[12].getActorID();
    	witnessOdorID = liveActors[13].getActorID();
    	witnessFrameID = liveActors[14].getActorID();
    	
    	// Setup storylines.
    	storylineID = getRandomInt(1, maxStorylines);  // Set which storyline via randomizer.
    	storyClues = new Clue[maxClues];                 // Identifies storyClues as Clue array. List of clues in a storyline.
    	
    	if (storylineID == 1) 
    	{  // STORYLINE: REVENGE PLOT
    		storyClues[0] = new Clue("Old Newspaper Article", "An article from fifteen years ago details a tragic event at another casino involving guest and hints at a vengeful relative's vow for retribution.");
    		storyClues[0].addLocation(area_Lobby, "On one of the tables in the lobby had a couple of old and new newspapers piled onto it. Looking at it closer showed an article of some sort of tragedy onto it.");
    		storyClues[0].addLocation(area_FrontDesk, "On top of the desk had a newspaper piled on it. Looking at it closer showed an article of some sort of tragedy onto it.");
    		  		
            storyClues[1] = new Clue("Single Cufflink", "A single, expensive cufflink found and identified as belonging to a businessman who vanished a few weeks ago.");
            storyClues[1].addLocation(area_Pool, "While walking at the pool, you see something shining.");
            storyClues[1].addLocation(area_Shore, "While watching the waves, you see a small object shining by the shore.");
            
            storyClues[2] = new Clue("Red Stain Silver Locket", "A silver locket had a red stain, possibly blood. It appears it belongs to a missing wealthy restaurant owner.");
            storyClues[2].addLocation(area_Spa, "You found the locket at the washing room of the Spa.");
            storyClues[2].addLocation(area_Bar, "You found the locket under the bar piano.");            
            
            storyClues[3] = new Clue("List of Names", "A list of names with the missing person crossed off.");
    		storyClues[3].addLocation(area_Cafe, "You looked around the cafe and saw something that seemed a little hidden. You took it out and saw a list of characters with some of them crossed out. The ones that were crossed out were those that were killed. This must've been left behind by the person responsible for all these murders.");
    		storyClues[3].addLocation(area_Jungle, "As you took a little venture into the jungle, you saw a piece of paper stuck on a branch. You took it out and saw a list of characters with some of them crossed out. The ones that were crossed out were those that were killed. This must've been left behind by the person responsible for all of these murders.");
    		
    		storyClues[4] = new Clue("Victim's Diary", "The victim's diary mentions an argument with one of the hotel guests.");
        	storyClues[4].addLocation(area_Steakhouse,  "As you walk in the restaurant you trip and found a diary on the ground.");
        	storyClues[4].addLocation(area_Asian, "As you walk in the noodlehouse you trip and found a diary on the ground.");
        	storyClues[4].addLocation(area_Casino, "As you walk in the casino floor you trip and found a diary on the ground.");
        	
        	// Place Clues in Locations
            // Clue indices: 0=newspaper, 1=cufflink, 2=locket, 3=thelist 4=diary
        	if (getRandomInt(0,1) == 0) 
        	{ 
        		hotelMap[area_Lobby].setClueIndex(0);
        		storyClueLoc1 = area_Lobby;
        	} 
        	else 
        	{ 
        		hotelMap[area_FrontDesk].setClueIndex(0);
        		storyClueLoc1 = area_FrontDesk;
        	}
        	if (getRandomInt(0,1) == 0) 
        	{
        		hotelMap[area_Pool].setClueIndex(1);
        		storyClueLoc2 = area_Pool;
        	}
        	else 
        	{
        		hotelMap[area_Shore].setClueIndex(1);
        		storyClueLoc2 = area_Shore;
        	}
            if (getRandomInt(0,1) == 0)
            {
            	hotelMap[area_Spa].setClueIndex(2);
            	storyClueLoc3 = area_Spa;
            } 
            else 
            {
            	hotelMap[area_Bar].setClueIndex(2);
            	storyClueLoc3 = area_Bar;
            }
            if (getRandomInt(0,1) == 0)
            {
            	hotelMap[area_Cafe].setClueIndex(3);
            	storyClueLoc4 = area_Cafe;
            } 
            else
            {
            	hotelMap[area_Jungle].setClueIndex(3);
            	storyClueLoc4 = area_Jungle;
            }
            int random = getRandomInt(0, 2);
            if (random == 0) {
            	hotelMap[area_Steakhouse].setClueIndex(4);
            	storyClueLoc5 = area_Steakhouse;
            }
            else if (random == 1)
            {
            	hotelMap[area_Asian].setClueIndex(4);
            	storyClueLoc5 = area_Asian;
            }
            else
            {
            	hotelMap[area_Casino].setClueIndex(4);
            	storyClueLoc5 = area_Casino;
            }
    		
    		winEndingsPart1[0] = "You have sensed that the scent of revenge was fragrant in the hotel, and have figured out that the "
    		                   + "motive behind these murders was out of vengeance. You have accused " + mastermind.getName() + " for being "
    				           + "responsible for these murders."
    				           + "\"What!? No! It couldn’t have been me! The suspect doesn’t even match my descriptions! I’m innocent, I swear!\" "
    				           + "They were arrested and sentenced to jail for their wrongdoings. Now, you could rest peacefully, knowing that "
    				           + "although you weren’t able to save your brother, the person responsible was served the cold hard fist of justice, "
    				           + "right?";
    		winEndingsPart2[0] = "You woke up the next day from a very peaceful slumber. It feels good to wake up knowing that your brother can "
    				           + "rest peacefully. You checked the news and everything seemed just fine. You made yourself breakfast and continued "
    				           + "your regular day. That time at the hotel was definitely something, but at least you made it out alive.  "
    				           + "You have accused the right suspect and the serial killer has been arrested. Congratulations! You have beaten the game!";
    		winEndingsPart1[1] = "You identified the culprit but tried to escape. The security stop the culprit and got arrested.";
        	winEndingsPart2[1] = "You were hired back as a detective again. You eventually found the dead body of your brother. The brother's wife\n"
    		                   + "thanked you. The case is closed. The hotel is safe once more.";
    		failEndingsPart1[0] = "You have sensed that the scent of revenge was fragrant in the hotel, and have figured out that the motive behind "
    				            + "these murders was out of vengeance. You have accused " + mastermind.getName() + " for being responsible for these murders. "
    				            + "\"What!? No! It couldn’t have been me! The suspect doesn’t even match my descriptions! I’m innocent, I swear!\" "
    				            + "They were arrested and sentenced to jail for their wrongdoings. Now, you could rest peacefully, knowing that although\n"
    				            + "you weren’t able to save your brother, the person responsible was served the cold hard fist of justice, right?";
    		failEndingsPart2[0] = "Light footsteps approached you in your sleep. You didn’t live with anyone, right? It couldn’t have been a family member or\n"
    				            + "a friend! Suddenly, a knife punctures your heart and you instantly die in your sleep. You were supposed to wake up the next\n"
    				            + "day rejuvenated, but it looks like you won’t be waking up at all.\n"
    				            + "“You guessed wrong, pal.” \n"
    				            + "A familiar voice was heard before you passed. You couldn’t make out the face, but all the clues that you picked up were\n"
    				            + "beginning to match that person’s description. Before you could recognize them, you passed away.\n"
    				            + "You have accused the wrong suspect and the serial killer roams freely, continuing to murder more wealthy people… ";
    		failEndingsPart1[1] = "The real culprit frames you for the crimes, and you are arrested by the local authorities";
        	failEndingsPart2[1] = "The culprit went to another hotel and continued his grim business. The mystery goes on while you rot in jail.";
    		winEndCount = 2;
    		failEndCount = 2;
    		
    	} 
    	else if (storylineID == 2) 
    	{  // STORYLINE: HOTEL IS AN ALIEN ABDUCTION SITE
    		storyClues[0] = new Clue("Unusual Guest Behavior", "One hotel guest exhibits odd mannerisms, avoids eye contact, and speaks in a stilted, unfamiliar accent.");
    		storyClues[0].addLocation(area_Lobby, "AREA LOBBY");
    		storyClues[0].addLocation(area_Casino, "AREA CASINO FLOOR");
    		  		
            storyClues[1] = new Clue("Strange Burn Marks", "Circular scorch marks are found on the hotel grounds, as if left by an otherworldly craft.");
            storyClues[1].addLocation(area_Jungle, "While walking at the jungle, you see an opening as big as the size of a football field.");
            storyClues[1].addLocation(area_Beach, "While watching the waves, you see a wide opening of lawn.");
            
            storyClues[2] = new Clue("Mysterious Metallic Object", "A small, intricate device not resembling any known technology is discovered.");
            storyClues[2].addLocation(area_Spa, "You found the metallic object at the washing room of the Spa.");
            storyClues[2].addLocation(area_Bar, "You found the metallic object under the bar piano.");            
            
            storyClues[3] = new Clue("Strange Mark Behind Ear", "Guests are found to have a strange circular mark behind their ear and speak an unknown language.");
    		storyClues[3].addLocation(area_Cafe, "You looked around the cafe and hotel guests talking in strange language.");
    		storyClues[3].addLocation(area_Gym, "You saw some hotel guests who speak in strange language have superhuman strength.");
    		storyClues[3].addLocation(area_Steakhouse, "A number of hotel guests who speak in strange language, eats their steak very rare.");
    		
    		storyClues[4] = new Clue("Strange Green Goo", "You've seen this strange green goo usually near a body of water.");
        	storyClues[4].addLocation(area_Pool,  "As you walk in the restaurant you trip and found a diary on the ground.");
        	storyClues[4].addLocation(area_Shore, "As you walk in the noodlehouse you trip and found a diary on the ground.");
        	
        	// These lines place the Clues in their Locations
            // Clue indices: 0=behavior, 1=burnmarks, 2=metallic, 3=earmarks 4=goo
        	if (getRandomInt(0,1) == 0)
        	{ 
        		hotelMap[area_Lobby].setClueIndex(0);
        		storyClueLoc1 = area_Lobby;
        	} else
        	{ 
        		hotelMap[area_Casino].setClueIndex(0);
        		storyClueLoc1 = area_FrontDesk;
        	}
        	if (getRandomInt(0,1) == 0)
        	{
        		hotelMap[area_Jungle].setClueIndex(1);
        		storyClueLoc2 = area_Pool;
        	}  
        	else
        	{
        		hotelMap[area_Beach].setClueIndex(1);
        		storyClueLoc2 = area_Shore;
        	}
            if (getRandomInt(0,1) == 0)
            {
            	hotelMap[area_Spa].setClueIndex(2);
            	storyClueLoc3 = area_Spa;
            } 
            else
            {
            	hotelMap[area_Bar].setClueIndex(2);
            	storyClueLoc3 = area_Bar;
            }
            int random = getRandomInt(0, 2);
            if (random == 0) {
            	hotelMap[area_Steakhouse].setClueIndex(4);
            	storyClueLoc4 = area_Cafe;
            }
            else if (random == 1)
            {
            	hotelMap[area_Asian].setClueIndex(4);
            	storyClueLoc4 = area_Gym;
            }
            else
            {
            	hotelMap[area_Casino].setClueIndex(4);
            	storyClueLoc4 = area_Steakhouse;
            }
            if (getRandomInt(0,1) == 0)
            {
            	hotelMap[area_Cafe].setClueIndex(3);
            	storyClueLoc5 = area_Pool;
            }
            else
            {
            	hotelMap[area_Gym].setClueIndex(3);
            	storyClueLoc5 = area_Shore;
            }
            
    		
    		winEndingsPart1[0] = "With the clues you’ve discovered, you’ve come to the conclusion that the hotel you’re staying in is the ground for alien abductions. "
    						   + "On paper, it sounds very unusual and crazy, but that’s what all the signs pointed to. "
    						   + "You couldn’t say it out loud as the staff members could hear you through the cameras. "
    						   + "You felt like you knew who was the mastermind behind this staging ground, so you just had to stop them for this entire operation to fall apart.\n\n"
    						   + "You found the culprit and were able to catch them when they had an open spot and killed them. Now, all of the aliens would have to disappear as well, right?";
    		winEndingsPart2[0] = "As you waited for the culprit to die, their body began shifting. "
    						   + "It was a weird adjustment and certainly a sight to see as you saw a human turn into some weird species. "
    						   + "It was clear that it wasn’t a regular human. It seems like you found a real life alien. What truly mattered, though, was if the alien was the mastermind behind it all.\n\n"
    						   + "You ran across the hotel to look for other staff members. You couldn’t find any of them. "
    						   + "All that was left were their attires, but no other traces of them. You then heard screaming from somewhere. You followed the screams to find your missing brother."
    						   + "He looked traumatized.\n\n"
    						   + "There were so many feelings and so many words to say. You and your brother left the hotel and returned home safely.\n\n"
    						   + "You have killed the right suspect and the aliens have disappeared. Congratulations! You have beaten the game!";

    		winEndingsPart1[1] = "With the clues pieced together and the mounting evidence impossible to ignore, the player finally confronts the guest whose identity and appearance seem to shift each day. "
    						   + "In a tense showdown in the casino’s private lounge, the player catches the suspect communicating into a concealed wrist device. "
    						   + "As security closes in, the guest’s disguise flickers and reveals the true form of the alien leader, responsible for orchestrating the abductions and manipulating the memories of those who vanished.";
        	winEndingsPart2[1] = "Using the mysterious metallic device found earlier, the player disables the alien’s technology, saving the remaining guests and exposing the extraterrestrial plot. "
        					   + "The island is safe once more, and the abducted guests slowly recover, leaving the player celebrated as a hero who stopped an out-of-this-world threat hiding in plain sight.";
    		failEndingsPart1[0] = "With the clues you’ve discovered, you’ve come to the conclusion that the hotel you’re staying in is the ground for alien abductions. "
    							+ "On paper, it sounds very unusual and crazy, but that’s what all the signs pointed to. You couldn’t say it out loud as the staff members could hear you through the cameras. "
    							+ "You felt like you knew who was the mastermind behind this staging ground, so you just had to stop them for this entire operation to fall apart.\n\n"
    							+ "You found the culprit and were able to catch them when they had an open spot and killed them. Now, all of the aliens would have to disappear as well, right?";
    		failEndingsPart2[0] = "Once it was clear that the culprit was dead, you heard a gasp behind you. You turned around and saw a staff member in shock, seeing a dead body on the ground. "
    							+ "The staff member began running away and quickly contacted the police. You were arrested and found guilty for first-degree murder. You were sentenced to the death penalty.\n\n"
    							+ "It was so confusing. Were there no aliens? Was [Character Name] an actual human? There were so many questions that wouldn’t be answered. "
    							+ "As you were lethally injected, all of the memories of you and your brother ran through your head. The mystery behind your brother’s disappearance wasn’t solved and you murdered an innocent person. Disgusting…\n\n"
    							+ "You have killed the wrong suspect and the hotel continues to run with more people disappearing into thin air.";
    		failEndingsPart1[1] = "Despite gathering the clues and growing ever more suspicious, the player fails to pinpoint the alien leader among the shifting identities and unexplainable phenomena. The trail goes cold as another guest vanishes, and the mysterious marks and strange objects remain unresolved. One final night, the casino's lights flicker and a hush falls over the hotel; the disguised alien quietly slips away, undetected.";
        	failEndingsPart2[1] = "When authorities arrive, the player can only recount what little evidence remains. The abducted guests are never found, and the hotel’s registry continues to show ever-changing names with no faces attached. The island slips into fearful isolation, haunted by stories of missing travelers and unexplained events. The alien leader’s technology remains hidden, ready for future victims, while the player is left with the chilling knowledge that the abductions will never truly end.";
    		winEndCount = 2;
    		failEndCount = 2;
    	} 
    }
    /**
     * The gameEngine method prompts the User with the option to play again.
     */
    private static void gameEngine() 
    {
    	boolean playAgain = true;
    	    	
    	while(playAgain)
    	{
    		System.out.println("\n          Starting a new game...");
    		System.out.println();
    		if (isNewCharacter) createAPlayer();
    		
    		startGame();
    		playAgain = isItYes("Do you want to play again?");  // Ask the player if they want to play again.
    		if (playAgain)
    		{ 
    			isNewCharacter = isItYes("Do you want to change your character?");
    		}
    	}
    	System.out.println("\n                  🕵️‍♀️ Thanks for playing ! 🕵️‍♂️");
    	System.out.println();
    	System.out.println();
    	scanner.close();
    }
    
    /**
     * The startGame method uses the setupMystery method to identify the storyline and begins the game.
     */
    
    private static void startGame() 
    {
    	setupMystery();
    	
    	daysPassed = 1;            // Start with day 1.
    	cluesFoundCount = 0;       // No clues found yet.
    	
    	if (runIntro)
    	{ 
    		displayIntro();
    	}  // This will skip the long story introduction for quick debugging. 
    	gameLoop();
    	
    	// Storyline ending Part 1 and Part 2.
    	sopDivider();
    	System.out.println();
    	sopTrim(endingMsgPart1, charPerLn);
    	System.out.println();
    	sopDivider();
    	System.out.println();
    	
    	enterToContinue();
    	
    	sopDivider();
    	System.out.println();
    	sopTrim(endingMsgPart2, charPerLn);
    	System.out.println();
    	sopDivider();
    	System.out.println();
    	sopFound("*** GAME OVER ***");
    }
    
    /**
     * The the gameLoop method ends the day when the amount of time spent in a day
     * goes over the time when the User is forced to sleep to create an accurate
     * environment.
     */
    
    private static void gameLoop() 
    {
        gameOver = false;  // Not yet game over.
        while (!gameOver)
        {
        	minsPassed = wakeUpTime;  
            Location currentLocation = hotelMap[player.getCurrentLocationIndex()];            
            
            while (minsPassed < sleepTime)
            {  // The day goes on until it reached the value of sleepTime constant.
            	currentLocation = hotelMap[player.getCurrentLocationIndex()]; 
            	displayStatus(currentLocation);
                displayCommands(currentLocation);
                minsPassed += 102;  // Time penalty per move. (STILL NEED TO FIX THIS FEATURE)
            }            
            
            if (player.hasFoundAllClues())
            {
                endGameWin();
                gameOver = true;
            }
            
            endDay();
        }
    }

    /**
     * The movePlayer method helps track the location of the User and what locations they have access to.
     * This method checks if the User has the necessary items to access restricted areas such as the
     * security room and jungle and stops them from visiting if they lack the materials.
     */
    
    private static void movePlayer(int numChoice, Location currentLocation) 
    {
    	int destinationIndex = currentLocation.getExitChoice(numChoice, 1);
    	if (destinationIndex != -1)
    	{
            Location Destination = hotelMap[destinationIndex];
            
            if (!Destination.isPublicAccess())
            {
                // Handle restricted access areas with simple 'keys' (flags on the player object)
                if (destinationIndex == area_Security && !player.hasSecurityKey())
                {
                	sopDivider();
                    System.out.println("\n"+textCenter("A 'STAFF ONLY' sign is posted. You need a keycard or a disguise to enter this area.")+"\n");
                    sopDivider();
                    enterToContinue();
                    player.setHasSeenSecurity(true);
                    return;
                }
                if (destinationIndex == area_Room224 && !player.hasRm224Keycard())
                {
                	sopDivider();
                    System.out.println("\n"+textCenter("The door is locked. It requires a guest room keycard.")+"\n");
                    sopDivider();
                    enterToContinue();
                    player.setHasSeenRm224(true);
                    return;
                }
                if (destinationIndex == area_Penthouse && !player.hasPenthouseKeycard())
                {
                	sopDivider();
                    System.out.println("\n"+textCenter("The door is locked. It requires a guest room keycard.")+"\n");
                    sopDivider();
                    enterToContinue();
                    return;
                }
                if (destinationIndex == area_Jungle && !player.hasJungleAccess())
                {
                	sopDivider();
                	System.out.println("\n"+textCenter("The security stop you from entering the jungle. You need authorization from the hotel manager.")+"\n");
                    sopDivider();
                    enterToContinue();
                    player.setHasSeenJungle(true);
                    return;
                }
            }
            player.setCurrentLocationIndex(destinationIndex);
            sopDivider();
            System.out.println("\n"+textCenter("You're heading towards " + Destination.getName() + ".")+"\n");
            sopDivider();
            enterToContinue();
        }
    	else
    	{
        	sopDivider();
            System.out.println("\n"+textCenter("You can't go that way.")+"\n");
            sopDivider();
        }
    }
    
    /**
     * The examineArea method contains clues and materials that can be found in certain locations
     * to either aid with the mystery or provide access to locked rooms.
     */
    
    private static void examineArea(Location currentLocation) 
    {
    	if (!player.hasSecurityKey() && player.hasSeenSecurity() && currentLocation==hotelMap[area_PokerTable])
    	{
    		sopDivider();
   			System.out.println("\nWhile you're at the poker table, you stumble upon a Security Key under the table.");
   			System.out.println("You can now access the Security Room.");
   			sopDivider();
   			player.setHasSecurityKey(true);
   			enterToContinue();
    	}
    	else if (!player.hasRm224Keycard() && player.hasSeenRm224() && currentLocation==hotelMap[area_Lobby])
    	{
    		sopDivider();
   			System.out.println("\nWhile you're at the hotel lobby. You trip and found a Hotel Guest Room Key on the floor.");
   			System.out.println("You can now access the Guest Room.");
   			sopDivider();
   			player.setHasRm224Keycard(true);
   			enterToContinue();
    	} 
    	else if (!player.hasJungleAccess() && player.hasSeenJungle() && currentLocation==hotelMap[area_Dining])
    	{
    		sopDivider();
   			System.out.println("\nWhile you were walking at the Dining area, you found a letter from a hotel manager.");
   			System.out.println("The letter grants access to the Jungle.");
   			sopDivider();
   			player.setHasJungleAccess(true);
   			enterToContinue();
    	}
        int clueIndex = currentLocation.getClueIndex();
        if (clueIndex != -1)
        {
            if (!player.hasClue(clueIndex))
            {
                player.setClueFound(clueIndex, true);
                
                sopDivider();
            	System.out.println("\n"+textCenter("CLUES FOUND!")+"\n");
                
                // Specific clue descriptions and effects
                if (clueIndex == 0)
                {
                    System.out.println(textCenter(storyClues[0].getClueDesc())+"\n");
                    //player.setHasSecurityKey(true);
                } 
                else if (clueIndex == 1)
                {
                    System.out.println(textCenter(storyClues[1].getClueDesc())+"\n");
                } 
                else if (clueIndex == 2)
                {
                	System.out.println(textCenter(storyClues[2].getClueDesc())+"\n");
                    //("You found a letter from a hotel manager granting you access to the jungle.");
                    //player.setHasJungleAccess(true);
                } 
                else if (clueIndex == 3)
                {
                	System.out.println(textCenter(storyClues[3].getClueDesc())+"\n");
                } 
                else if (clueIndex == 4)
                {
                    System.out.println(textCenter(storyClues[4].getClueDesc())+"\n");
                    //("The ID badge has a magnetic strip that acts as a keycard!");
                    //player.setHasRm224Keycard(true);
                }
                sopDivider();
                
                // Remove clue from room after finding it
                currentLocation.setClueIndex(-1);
                
            } 
            else 
            {
            	sopDivider();
                System.out.println("\n"+textCenter("You already found the clue here. Nothing more to see.")+"\n");
                sopDivider();
            }
        } 
        else 
        {
        	sopDivider();
            System.out.println("\n"+textCenter("You search the area, but find no relevant clues.")+"\n");
            sopDivider();
        }
        enterToContinue();
    }

    /**
     * The talkToPeople method tracks which characters have been interacted with and stores
     * the dialogue that they can provide. This alters depending on clues and storylines.
     */
    
    private static void talkToPeople(int actorID, Location currentLocation) 
    {
    	int newID = matchID(liveActors, actorID);  // Get the correct index for liveActors.
    	actorID = newID;
    	if (!liveActors[actorID].getHasMeet()) 
    	{
    		sopDivider();
    		System.out.println(textCenter("NEW CHARACTER ENCOUNTERED!"));
    		System.out.println("\t\tName " + liveActors[actorID].getName());
    		System.out.println("\t\tAlias: " + liveActors[actorID].getAlias());
    		System.out.println("\t\tGender: " + liveActors[actorID].getGender());
    		System.out.println("\t\tHair Color: " + liveActors[actorID].getHairColor());
    		System.out.println("\t\tKnown body smell: " + liveActors[actorID].getOdor());
    		System.out.println("\t\tBody Size/Frame: " + liveActors[actorID].getBodyFrame());
    		sopTrim("\t\tBackground: " + liveActors[actorID].getDescription() + " " + liveActors[actorID].getAttribute(0), charPerLn);
    		sopDivider();
    		enterToContinue();
    		liveActors[actorID].setHasMeet(true);
    	}
    	if (actorID == witnessGenderID && currentLocation == hotelMap[witnessGender.getCurrentLocationIndex()]) 
    	{
    		String gender = witnessGender.getGender();
			sopDivider();
			System.out.println("\n\t\tYou're talking to " + witnessGender.getAlias() + ".");
			System.out.println("\t\tYou ask " + txHimHer(gender) + " if " + txHeShe(gender) + " was able to get any sense whether the possible suspect " + txHeShe(gender) + " found was a man, a woman, or perhaps someone whose gender wasn't obvious?");
			System.out.println("\t\t" + txHeShe2(gender) + " replied that " + txHeShe(gender) + "'s confident that the person " + txHeShe(gender) + " saw was a " + mastermind.getGender() + ".");
			System.out.println("\t\tThat's all " + txHeShe(gender) + " can remember.\n");
			System.out.println("\t\tCLUES FOUND!  Gender: " + mastermind.getGender());
			System.out.println(textCenter("CLUES FOUND!  Gender: " + mastermind.getGender()));
			sopDivider();
			hasFoundGender = true;
			enterToContinue();
		} 
    	else if (actorID == witnessColorID && currentLocation == hotelMap[witnessColor.getCurrentLocationIndex()]) 
		{
			String gender = witnessColor.getGender();
			sopDivider();
			System.out.println("\n\t\tYou're talking to " + witnessGender.getAlias() + ".");
			System.out.println("\t\tYou ask " + txHimHer(gender) + " if " + txHeShe(gender) + " can describe anything about the suspect " + txHeShe(gender) + " saw before the victim disappeared.");
			System.out.println("\t\t" + txHeShe2(gender) + " replied that what stood out to " + txHimHer(gender) + " was the color of their hair \u2014 it was " + mastermind.getHairColor() + ".");
			System.out.println("\t\tThat's all " + txHeShe(gender) + " can remember.\n");
			System.out.println(textCenter("CLUES FOUND!  Hair Color: " + mastermind.getHairColor()));
			sopDivider();
			hasFoundColor = true;
			enterToContinue();
		} 
		else if (actorID == witnessOdorID && currentLocation == hotelMap[witnessOdor.getCurrentLocationIndex()]) 
		{
			String gender = witnessOdor.getGender();
			sopDivider();
			System.out.println("\n\t\tYou're talking to " + witnessGender.getAlias() + ".");
			System.out.println("\t\tYou ask " + txHimHer(gender) + " if there is anything " + txHeShe(gender) + " can remember about the suspect?");
			System.out.println("\t\t" + txHeShe2(gender) + " replied that there was this faint scent in the air as " + txHeShe(gender) + " passed by, like " + mastermind.getOdor() + ". " + txHeShe2(gender) + " added that " + txHeShe(gender) + "is sure of it.");
			System.out.println("\t\tThat's all " + txHeShe(gender) + " can remember.\n");
			System.out.println(textCenter("CLUES FOUND!  Odor: " + mastermind.getOdor()));
			sopDivider();
			hasFoundOdor = true;
			enterToContinue();
		}  
		else if (actorID == witnessFrameID && currentLocation == hotelMap[witnessFrame.getCurrentLocationIndex()]) 
		{
			String gender = witnessFrame.getGender();
			sopDivider();
			System.out.println("\n\t\tYou're talking to " + witnessGender.getAlias() + ".");
			System.out.println("\t\tYou ask " + txHimHer(gender) + " if " + txHeShe(gender) + " was able to get any sense whether the possible suspect " + txHeShe(gender) + " found was a man, a woman, or perhaps someone whose gender wasn't obvious?");
			System.out.println("\t\t" + txHeShe2(gender) + " replied that it was sure hard to tell the gender, but " + txHeShe(gender) + " recalled the frame was " + mastermind.getBodyFrame() + ". ");
			System.out.println("\t\tThat's all " + txHeShe(gender) + " can remember.\n");
			System.out.println(textCenter("CLUES FOUND!  Body Frame: " + mastermind.getBodyFrame()));
			sopDivider();
			hasFoundFrame = true;
			enterToContinue();
		}
		else 
		{
   			sopDivider();
   			System.out.println("\n"+textCenter(liveActors[actorID].getDialog(0))+"\n");
   			sopDivider();
   			enterToContinue();
		}
    }
    
    /**
     * The solveTheMystery method contains the User's action to solve the hotel's mystery. The User must
     * find at least 5 clues to solve the mystery to prevent random guesses to be made. 
     */
    
    private static void solveTheMystery() 
    {
    	cluesFoundCount = player.getNumCluesFound();
    	if (cluesFoundCount < minCluesRequired) 
    	{  // FOR TESTING PURPOSE, '-3' was done to minCluesRequired so don't have to find all clues.
    		sopDivider();
    		System.out.println("\n"+textCenter("You don't have enough evidence yet! You need to explore the hotel more.")+"\n");
    		sopDivider();
    		enterToContinue();
    		return;
    	} 
    	else 
    	{
    		if (storylineID == 1) 
    		{
    			System.out.println("You are convince that the reason why people are missing is because somebody is killing them.");
    		} 
    		else if (storylineID == 2) 
    		{
    			System.out.println("You are convince that the reason why people are missing is because they've been abducted by aliens. You suspect the leader of the alien is nearby and is the mastermind.");
    		}
    		System.out.println();
    		//System.out.println("NOTE: "+textItalic+"For DEMO purpose, the program needs you find at least 2 clues and now able to guess the culprit."+textNormal);
    		
    		suspects = filterSuspects(mastermind, suspects, 1); // Filter out same attributes once first clue is found.
    		shuffleActors(suspects);
    		
    		displaySuspects(suspects);
    		
    		System.out.println();
    		//System.out.println("HINT: The mastermind is " + mastermind.getName());
    		//System.out.println("The hint above will disappear when the final version of the game is released.");
        	
    		int rightChoice = getCulpritFromChoice(suspects);
    		int choice = getIntInput(1, 6);
    		hasSolved = true;
    		
    		//suspects[choice - 1].introduce();
    		
    		if (choice == rightChoice) 
    		{
    			int random = getRandomInt(0, winEndCount - 1);
    			endingMsgPart1 =  winEndingsPart1[random];
    			endingMsgPart2 =  winEndingsPart2[random];
    		} else {
    			int random = getRandomInt(0, failEndCount - 1);
    			endingMsgPart1 = failEndingsPart1[random];
    			endingMsgPart2 = failEndingsPart2[random];
    		}
    		
    	}    	
    	gameOver = true;
    	minsPassed = sleepTime;  // Jump time to the end of the day.
    }
    
    /**
     * The createAPlayer method contains the prompts for the character creation section before the game starts
     * and stores attributes of the User's character.
     */
    
    public static void createAPlayer() 
    {
		boolean nameAgain = true;
		boolean genderAgain = true;
		
		while (nameAgain) 
		{
			// Prompt the player for their first name
			System.out.print("Enter your character's first name: ");
			firstName = scanner.next(); // Reads the first word
			scanner.nextLine();
		
			// Prompt the player for their last name
			System.out.print("Enter your character's last name : ");
			lastName = scanner.next(); // Reads the next word
			scanner.nextLine();
			
			// Display the full name
			System.out.println("Your character's full name is " + firstName + " " + lastName);
			// Ask the player to confirm the name
			nameAgain = isItYes("Do you want to change that name");
			System.out.println();
		}
		
		while (genderAgain)
		{
			// Prompt the player for their first name
			System.out.print("Enter your gender (male/female): ");
			userGender = scanner.next().toLowerCase();
			scanner.nextLine();
			
			if (areStringsMatch(userGender, "male", false, false)) 
			{
				userGender = "male";
				genderAgain = false;
			} 
			else if (areStringsMatch(userGender, "female", false, false)) 
			{
				userGender = "female";
				genderAgain = false;
			} 
			else 
			{
				System.out.println("Invalid input. Please enter 'Male', or 'Female' to continue the game.");
			}	
			
			if (!genderAgain) 
			{  // Ask the player to confirm the name			
				System.out.println("You entered " + userGender);
				genderAgain = isItYes("Do you want to change the gender?");
			}
		}
		
		String prefix = "Mr.";
		String baseName = lastName;
		if (lastName == null && firstName!=null) 
		{ 
			baseName = firstName;
		} 
 		if (userGender == "female") 
 		{ 
 			prefix = "Ms.";
 		}
		playerShortName = prefix + " " + baseName;
	}
    
    /**
     * The displayIntro method prints out the intro/prologue of the game.
     */
    
    public static void displayIntro() 
    {				
		System.out.println();
        System.out.println();
        sopTrim("The gentle hum of the yatch's engines blends with the rhythmic slap of waves against the hull as you glide over deep, sapphire waters...", charPerLn);
        System.out.println();
        sopTrim("The JTK Hotel and Casino resort rises in the distance, perched atop a private island shrouded in exclusivity and mystery - a retreat for society's wealthiest.  "
        	  + "Three days have passed since your brother, a renowned doctor and hospital director, checked in and disappeared without a trace.  "
        	  + "His wife, desperate for answers, sought help from the local authorities, but their investigation stalled, leaving only uncertainty and fear.  "
        	  + "Now, she handed the task to you - a former detective - along with a generous fee to uncover the truth.  "
        	  + "As the island's silhouette sharpens on the horizon, your instincts sharpen too.  "
        	  + "All leads point to the hotel; its opulent facade hides secrets that you must unravel before time slips away.", charPerLn);
        System.out.println();
		enterToContinue();
		sopTrim("As you step off the yatch, the salty breeze still lingering in your hair, a group of hotel staff greets you with warm smiles.  "
			  + "They direct you toward a sleek, colorful tram waiting by the dock, its polished silver frame gleaming in the sunlight. "
			  + "The staff usher you and your companions - Rihanna, Ariel, Nicole, the Maritan Luber Queen, Charles Klank, and Bubba - into the tram, making sure everyone feels welcome.  "
			  + "Ariel gazes dreamily at the sea, convinced she's returned to her mermaid roots, while Nicole clutches her stomach, grateful for the promise of comfort ahead.  "
			  + "Bubba, slightly awkward, stands close by, his thoughts masked behind a stoic expression.  "
			  + "The tram proceeds smoothly along the palm-lined path, carrying you all toward the grand hotel, where new adventures and unexpected encounters await.", charPerLn);
		System.out.println();
		enterToContinue();		
		sopTrim("After you checked in at the front desk, the manager, Mr.Sterling, greeted you in the lobby. His smile was as cold as the champagne he offered.", charPerLn);
		sopTrim("\"Welcome to the JTK Hotel and Casino Resort, " + playerShortName + ",\" he said, gesturing around at the luxurious decor.  \"Your sister-in-law, mentioned your ...specialized background.  "
			  + "We value discretion here.  Rest assured, there's nothing out of place.\"  You acknowledged his statement without further comment.  "
			  + "Sterling then explained that you could inspect your brother Marcus' Penthouse Suite over the next three days, as all arrangements had been settled in advance.  "
			  + "With the key to your room in hand, you proceeded directly to your accommodation to rest.", charPerLn);
		System.out.println();
		sopFound("You acquired an access badge to your guest room.");
		System.out.println();
		enterToContinue();
	}
    
    /**
     * The displayStatus method provides basic information to the user about their whereabouts and the time.
     */
    
    public static void displayStatus(Location currentLocation) 
    {
    	if (minsPassed == wakeUpTime) {
    		System.out.println();
    		System.out.println(lineDivider);
    		sopTrim("The next morning arrived.  You went to the lobby.  A hotel staff greeted you, \"Good morning, " + playerShortName + "!\"", charPerLn);
    		System.out.println();
    	}
    	System.out.println("==========================[ DAY " + daysPassed + ", TIME " + clock(minsPassed) + " ]==");
    	System.out.println("You are currently in: " + textBold + currentLocation.getName() + textNormal + ".");
        System.out.println(textItalic + currentLocation.getDescription() + textNormal);
        System.out.println("Place/s to visit: " + currentLocation.getPlacesToVisit());
        // displayStats(currentLocation);  // DEBUGGING TIP: Remove comment remark before displayStats() to show game info. Almost like a cheat.
        System.out.println(lineDivider);
    }
    
    /**
     * The displayStats method is ONLY used for debugging and testing. This does not affect the game at all and is used like a 
     * developer build. This reveals everything that is needed to solve the mystery and where to get them as well as who is
     * responsible and what storyline is being played out.
     */
    
    public static void displayStats(Location currentLocation) 
    {
    	System.out.println("Storyline Number: " + storylineID +  ", The main culprit is :" + mastermind.getName());
    	System.out.println("Number of Clues Found: " + player.getClueCount() + " out of " + NUM_CLUES);
    	System.out.println("Clue locations: " + hotelMap[storyClueLoc1].getName() + ", " + hotelMap[storyClueLoc2].getName() + ", " + hotelMap[storyClueLoc3].getName() + ", " + hotelMap[storyClueLoc4].getName() + ", " + hotelMap[storyClueLoc5].getName());
    	System.out.println("Witness Gender: " + witnessGender.getName() + " is at the " + hotelMap[witnessGender.getCurrentLocationIndex()].getName());
    	System.out.println("Witness Color: " + witnessColor.getName() + " is at the " + hotelMap[witnessColor.getCurrentLocationIndex()].getName());
    	System.out.println("Witness Odor: " + witnessOdor.getName() + " is at the " + hotelMap[witnessOdor.getCurrentLocationIndex()].getName());
    	System.out.println("Witness Frame: " + witnessFrame.getName() + " is at the " + hotelMap[witnessFrame.getCurrentLocationIndex()].getName());
    }
    
    /**
     * The displayCommands method prints out the options for the User
     * and activates certain methods when a choice is made.
     */
    
    public static void displayCommands(Location currentLocation) 
    {   	
    	System.out.println("What do you want to do?");
        System.out.println("[1] Go somewhere, [2] Examine the area, [3] Talk to someone, [4] Solve the mystery, [5] I Quit!");
        
        int choice = getIntInput(1, 5);
        
        if (choice == 5) {                  // CHOICE: I Quit!
        	gameOver = true;                        // Marked gameOver as TRUE
        	minsPassed = sleepTime;                 // Jump time to the end of the day.
        } else if (choice == 1) {           // CHOICE: Go somewhere
        	letsGo(currentLocation);                // Takes the player to the Traveling interface
        } else if (choice == 2) {           // CHOICE: Examine the area     	        	
        	examineArea(currentLocation);           // Takes the player to the Examining interface
        } else if (choice == 3) {           // CHOICE: Talk to someone
        	letsTalk(currentLocation);          // Takes the player to the Inquiring interface        	
        } else if (choice == 4) {           // CHOICE: Solve the mystery
        	solveTheMystery();                      // Takes the player to the Solving interface
        } else {
        	System.out.println("Invalid user input. This should not be happening.");
        }
    }
    
    /**
     * The letsGo method prompts the user to travel to a certain location when they chose to go somewhere.
     */
    
    public static void letsGo(Location currentLocation) 
    {
    	int maxChoiceCount = currentLocation.getExitCount(); // Returns Integer as maximum number of choices in the current location list.
    	
    	System.out.println(lineDivider);
    	System.out.println("Where do you want to go, " + playerShortName + "?");
    	currentLocation.displayExitChoices(1);
    	System.out.println("[" + (maxChoiceCount + 1) + "] Waaah! I want to go home. I Quit!");
    	
    	int choice = getIntInput(1, maxChoiceCount + 1);
        
        if (choice <= maxChoiceCount) {
        	movePlayer(choice, currentLocation);    // The player moves to choice location.
        } else if (choice == maxChoiceCount + 1) {
        	gameOver = true;                        // Marked gameOver as TRUE
        	minsPassed = sleepTime;
        	return;                                 // Cancelled. Go back to displayCommands()
        }
        else {
        	System.out.println("ERROR! Invalid user input. This should not happened.");
        }
    }
    
    /**
     * The letsTalk method activates when the User chooses the action to talk to someone within their location.
     * The method checks which actors are assigned to this location and gives the User the option to talk to them.
     * Otherwise, if there aren't any actors in the location, the User will not be allowed to talk to any actor.
     */
    
    public static void letsTalk(Location currentLocation) 
    {
    	// 'actorID1 to actorID6' [INTEGERS] are the number of choices in the letsTalk menu. Assumes that available actors to talk to are 6 only.
    	// Starting from 'actorID1', an ActorID (INTEGER) will be assigned to each choice if an actor is found at the current location. 
    	// If no more actor is found at the current location, the 'choice#' will have a value of -1.
    	// I use ActorID value since each actor is assigned to have one, so it's easy to manage.
    	int actorID1 = -1;
    	int actorID2 = -1;
    	int actorID3 = -1;
    	int actorID4 = -1;
    	int actorID5 = -1;
    	int actorID6 = -1;
    	// The choiceIdx_ is to assign the series of choices of actors/actions.
    	int choiceIdx01 = -1;
    	int choiceIdx02 = -1;
    	int choiceIdx03 = -1;
    	int choiceIdx04 = -1;
    	int choiceIdx05 = -1;
    	int choiceIdx06 = -1;
    	int choiceIdx07 = -1;  // Use for Gender witness actor
    	int choiceIdx08 = -1;  // Use for Hair color witness actor
    	int choiceIdx09 = -1;  // Use for Odor witness actor
    	int choiceIdx10 = -1;  // Use for Body frame witness actor
    	int maxChoiceCount = 1;     // Count the number of choices available. [INTEGER]
    	    	
    	// I need to assign the actorID [INTEGER] into the 'choice#' if the actor is at the current location.
    	// And then if so, count how many choices which updates the value of maxChoiceCount [INTEGER].     	
    	for (int index = 0; index < num_TheActors; index++) {     // The for-loop will test all the actors one at a time.
    		if (currentLocation == hotelMap[liveActors[index].getCurrentLocationIndex()]) {     // If an actor is found at the current location...
    			if (actorID1==-1 && actorID2==-1 && actorID3==-1 && actorID4==-1 && actorID5==-1 && actorID6==-1) {            // If these are met, assign the ActorID value to actorID1.
    				actorID1 = index;
    				choiceIdx01 = maxChoiceCount;
    				maxChoiceCount++;
    			} else if (actorID1!=-1 && actorID2==-1 && actorID3==-1 && actorID4==-1 && actorID5==-1 && actorID6==-1) {     // If these are met, assign the ActorID value to actorID2.
    				actorID2 = index;
    				choiceIdx02 = maxChoiceCount;
    				maxChoiceCount++;
    			} else if (actorID1!=-1 && actorID2!=-1 && actorID3==-1 && actorID4==-1 && actorID5==-1 && actorID6==-1) {     // If these are met, assign the ActorID value to actorID3.
    				actorID3 = index;
    				choiceIdx03 = maxChoiceCount;
    				maxChoiceCount++;
    			} else if (actorID1!=-1 && actorID2!=-1 && actorID3!=-1 && actorID4==-1 && actorID5==-1 && actorID6==-1) {     // If these are met, assign the ActorID value to actorID4.
    				actorID4 = index;
    				choiceIdx04 = maxChoiceCount;
    				maxChoiceCount++;
    			} else if (actorID1!=-1 && actorID2!=-1 && actorID3!=-1 && actorID4!=-1 && actorID5==-1 && actorID6==-1) {     // If these are met, assign the ActorID value to actorID5.
    				actorID5 = index;
    				choiceIdx05 = maxChoiceCount;
    				maxChoiceCount++;
    			} else if (actorID1!=-1 && actorID2!=-1 && actorID3!=-1 && actorID4!=-1 && actorID5!=-1 && actorID6==-1) {     // If these are met, assign the ActorID value to actorID6.
    				actorID6 = index;
    				choiceIdx06 = maxChoiceCount;
    				maxChoiceCount++;
    			}    			    			
    		}
    	}
    	   	
    	if (maxChoiceCount==1) {     // Oops! Looks like we did NOT found any actor in this location.
    		sopDivider();
    		System.out.println("\n"+textCenter("There are currently no people who would like talk to you at this location.")+"\n");
    		sopDivider();
    		enterToContinue();
    	} else {                     // Well, we found at least 1 people that we can talk, so display the talk menu.
    		System.out.println(lineDivider);
    		System.out.println("Who do you want to talk to, " + playerShortName + "?");
    		if (choiceIdx01!=-1) { System.out.println("[" + choiceIdx01 + "] Talk to the " + liveActors[actorID1].getOccupation() + ", " + liveActors[actorID1].getAlias()); }
    		if (choiceIdx02!=-1) { System.out.println("[" + choiceIdx02 + "] Talk to the " + liveActors[actorID2].getOccupation() + ", " + liveActors[actorID2].getAlias()); }
    		if (choiceIdx03!=-1) { System.out.println("[" + choiceIdx03 + "] Talk to the " + liveActors[actorID3].getOccupation() + ", " + liveActors[actorID3].getAlias()); }
    		if (choiceIdx04!=-1) { System.out.println("[" + choiceIdx04 + "] Talk to the " + liveActors[actorID4].getOccupation() + ", " + liveActors[actorID4].getAlias()); }
    		if (choiceIdx05!=-1) { System.out.println("[" + choiceIdx05 + "] Talk to the " + liveActors[actorID5].getOccupation() + ", " + liveActors[actorID5].getAlias()); }
    		if (choiceIdx06!=-1) { System.out.println("[" + choiceIdx06 + "] Talk to the " + liveActors[actorID6].getOccupation() + ", " + liveActors[actorID6].getAlias()); }
    		
        	if (player.getClueCount()>=3) {  // Active only if the clues found are 3 or more.
        		if (choiceIdx07==-1 && currentLocation==hotelMap[witnessGender.getCurrentLocationIndex()] && !hasFoundGender) {
        			System.out.println("[" + maxChoiceCount + "] Talk to the " + witnessGender.getOccupation() + ", " + witnessGender.getAlias());
        			choiceIdx07 = maxChoiceCount;
        			maxChoiceCount++;
        		}
        		if (choiceIdx08==-1 && currentLocation==hotelMap[witnessColor.getCurrentLocationIndex()] && !hasFoundColor) {
        			System.out.println("[" + maxChoiceCount + "] Talk to the " + witnessColor.getOccupation() + ", " + witnessColor.getAlias());
        			choiceIdx08 = maxChoiceCount;
        			maxChoiceCount++;
        		}
        		if (choiceIdx09==-1 && currentLocation==hotelMap[witnessOdor.getCurrentLocationIndex()] && !hasFoundOdor) {
        			System.out.println("[" + maxChoiceCount + "] Talk to the " + witnessOdor.getOccupation() + ", " + witnessOdor.getAlias());
        			choiceIdx09 = maxChoiceCount;
        			maxChoiceCount++;
        		}
        		if (choiceIdx10==-1 && currentLocation==hotelMap[witnessFrame.getCurrentLocationIndex()] && !hasFoundFrame) {
        			System.out.println("[" + maxChoiceCount + "] Talk to the " + witnessFrame.getOccupation() + ", " + witnessFrame.getAlias());
        			choiceIdx10 = maxChoiceCount;
        			maxChoiceCount++;
        		}
        	}
    		
    		System.out.println("[" + maxChoiceCount + "] I change my mind. I don't want to talk.");
        	maxChoiceCount++;
        	System.out.println("[" + maxChoiceCount + "] Waaah! I want to go home. I Quit!");
        	
        	int choice = getIntInput(1, maxChoiceCount);
        	
        	if (choice == maxChoiceCount) {  // Force quit the game.
        		gameOver = true;
        		minsPassed = sleepTime;
        		return;
        	} else if (choice <= maxChoiceCount - 2) {
        		if (player.getClueCount()>=3) {  // Active only if the clues found are 3 or more.
        			if      (choice==choiceIdx07) { talkToPeople(witnessGenderID, currentLocation); }
            		else if (choice==choiceIdx08) { talkToPeople(witnessColorID, currentLocation); }
            		else if (choice==choiceIdx09) { talkToPeople(witnessOdorID, currentLocation); }
            		else if (choice==choiceIdx10) { talkToPeople(witnessFrameID, currentLocation); }
        		}        		
        		if      (choice==choiceIdx01) { talkToPeople(liveActors[actorID1].getActorID(), currentLocation); }
        		else if (choice==choiceIdx02) { talkToPeople(liveActors[actorID2].getActorID(), currentLocation); }
        		else if (choice==choiceIdx03) { talkToPeople(liveActors[actorID3].getActorID(), currentLocation); }
        		else if (choice==choiceIdx04) { talkToPeople(liveActors[actorID4].getActorID(), currentLocation); }
        		else if (choice==choiceIdx05) { talkToPeople(liveActors[actorID5].getActorID(), currentLocation); }
        		else if (choice==choiceIdx06) { talkToPeople(liveActors[actorID6].getActorID(), currentLocation); }
        	}
    	}
    }
    
    /**
     * The endDay method concludes the run of the game. This can be happen when the User solves the mystery,
     * fails to solve the mystery, goes over the time limit, or simply chooses to quit mid-game.
     */
    
    private static void endDay() 
    {	
		if (gameOver && !hasSolved) {
			endingMsgPart1 = "Overwhelmed by the mounting pressure, you chose to leave the hotel behind, unable to ravel the mystery that lingered within its walls.";
			endingMsgPart2 = "As the days slipped by, the unsettling pattern continued \u2014guests vanished without a trace, and the hotel's secrets remained shrouded in darkness.";
			return;
		} else if (gameOver && hasSolved) { return; }
		if (daysPassed >= 4) {
			player.setHasPenthouseKeycard(false);
			sopDivider();
			System.out.println("\n"+textCenter("Three days has passed. The hotel manager took out your privilege to access the Penthouse Suite where your missing brother Marcus stayed, to save for other hotel guests.")+"\n");
			sopDivider();
		}
		if (daysPassed >= maxDaysPassed) {  // Game stops on whatever value set in maxDaysPassed constant.			
			System.out.println("Day " + maxDaysPassed + " arrives...");
			gameOver = true;
			endingMsgPart1 = "Time ran out. The mystery was not solved in time.";
			endingMsgPart2 = "The guests are lost forever.";
		} else {
			if (!gameOver) {
				sopDivider();
				System.out.println("\n"+textCenter("Day " + daysPassed + " ends. You are tired and return to your room.")+"\n");
				sopDivider();
				enterToContinue();
				daysPassed++;
				player.setCurrentLocationIndex(area_Lobby);
				//canUndo = true; //FUTURE feature UNDO
			}			
		}
	}
    
    /**
     * The endGameWin method provides a celebratory prompt to the User if they win.
     */
    
    private static void endGameWin() 
    {
        System.out.println("\n*** MYSTERY SOLVED ***");
        System.out.println("You have gathered all the clues: The Journal, the Syringe, the Cult Symbol, and your Brother's ID.");
        System.out.println("It's a conspiracy! The hotel is a front for a secret cult led by the hotel director.");
        System.out.println("They kidnap wealthy guests for gruesome 'medical' rituals, likely funded by the casino profits.");
        System.out.println("Your brother was likely trying to expose them as the hospital director, which is why he disappeared.");
        System.out.println("You call the authorities from the rooftop garden and expose the operation.");
        System.out.println("YOU WIN!");
    }
    
    /**
     * The displaySuspects method provides the user with a list of suspicious Actors
     * who could be accused for the storyline.
     */
    
    public static void displaySuspects(Actor[] array) 
    {
    	System.out.println("Who do you believe is the mastermind?");
    	for (int i = 0; i < array.length; i++) {
    		System.out.println("[" + (i + 1) + "] " + array[i].getName());
    	}
 	}

    /**
     * The shuffleActors method mixes up the order of Actors in an array.
     */
    
    public static void shuffleActors(Actor[] array) 
    {
 		// Start from the last element and go to the second element (index 1)
 		for (int i = array.length - 1; i > 0; i--) {
 			// Pick a random index 'j' from 0 to i (inclusive)
 			int j = getRandomInt(0, i);
 			
 			// Swap the element at i with the element at the random index j
 			Actor temp = array[i];
 			array[i] = array[j];
 			array[j] = temp;
 		}
 	}
    
    /**
     * The findSuspects method identifies which actors share attributes of the mastermind
     * using clues that the User found.
     */
    
    public static Actor[] findSuspects(Actor culprit, Actor[] array) 
    {  // Return a new list of suspects that has at least same attribute with the mastermind's attributes.
    	int newSize = 0;  // Using this integer to count the length of the newArray.    		
    	// First, count how many elements will remain.
    	for (int i = 1, j = 0; i < array.length; i++) {  // Since culprit index is 0, the loop will start the index (i) to 1.
    		if (culprit.getAttribute(1)==array[i].getAttribute(1) || culprit.getAttribute(2)==array[i].getAttribute(2) || culprit.getAttribute(3)==array[i].getAttribute(3) || culprit.getAttribute(4)==array[i].getAttribute(4)) {
    			j++;          // This will count the new Size.
    			newSize = j;  // Assign the value of j to the new Size.
    		}
    	}
    	Actor[] newArray = new Actor[newSize];  // Create an array to store a new array from temporary array with the right size.
    	
    	// Iterate through the original array and copy only the elements to keep.
    	for (int i = 1, j = 0; i < array.length; i++) {
    		if (culprit.getAttribute(1)==array[i].getAttribute(1) || culprit.getAttribute(2)==array[i].getAttribute(2) || culprit.getAttribute(3)==array[i].getAttribute(3) || culprit.getAttribute(4)==array[i].getAttribute(4)) {
    			newArray[j] = array[i];
    			j++;  // This will count for newArray index starting from 0.
    		}
    	}
    	return newArray;
    }    
    
    /**
     * The filterSuspects method filters out Actors that don't fit the clues obtained by the User
     * to provide convenience when the user chooses to accuse an actor and solve the mystery.
     */
    
    public static Actor[] filterSuspects(Actor culprit, Actor[] array, int attributeIndex) 
    {
    	int newCount = 0;                                // Using this integer to count the length of the newArray. 
    	Actor[] tempArray = new Actor[maxSuspectList];  // Create an array to store leftover suspects. 
    	// First, count how many elements will remain.
    	for (int i = 0, j = 0, k = 0; i < array.length - 1; i++) {
    		if (culprit.getAttribute(1)==array[i].getAttribute(attributeIndex)) 
    		{
    			j++;           // This will count how many elements in the newArray.
    			newCount = j;  // Assign the value of j to newCount.
    		} else {  // Saved these suspects if suspect list is not enough.
    			tempArray[k] = array[i];
    			k++;
    		}
    	}    	
    	Actor[] newArray = new Actor[maxSuspectList];  // Create an array to store a new array from temporary array with the right size.
    	// Iterate through the original array and copy only the elements to keep.
    	for (int i = 0, j = 0; i < array.length - 1; i++) {
    		if (culprit.getAttribute(attributeIndex)==array[i].getAttribute(attributeIndex)) 
    		{
    			if (j < maxSuspectList - 1) {
    				newArray[j] = array[i];
    			} else i = array.length;    			
    			j++;
    		}
    	}
    	int index = 0;
    	while (newCount <= maxSuspectList - 1) 
    	{ // If suspect list is not enough, get from tempArray.
    		newArray[newCount] = tempArray[index];
    		newCount++;
    		index++;
    	}    	
    	newArray[maxSuspectList - 1] = culprit; 
    	return newArray;
    }     
    
    /**
     * The getCulpritFromChoice method identifies who's the culprit of the game. 
     */
    
    public static int getCulpritFromChoice(Actor[] array) 
    {
    	for (int i = 0; i < maxSuspectList; i++) 
    	{
    		if (array[i].getIsCulprit()) {
    			return i + 1;  // Plus 1 because the choice will start with 1.
    		}
    	}
    	return -1;
    }    
    
    /**
     * The ActorID method converts the label name of actor to an actor ID. Example: the_manager converts to 0
     */
    
    public static int ActorID(String label) 
    {
		int result = -1;
		for (int i = 0; i < num_TheActors - 1; i++) {
			if (label == liveActors[i].getLabelID()) {
				result = i;
			}
		}
		return result;
	}
    
    /**
     * The matchID method returns the index of an element that matches the actorID.
     */
    
    public static int matchID(Actor[] element, int actorID) 
    {
    	for (int index = 0; index < element.length; index++) {
			if (actorID == element[index].getActorID()) {
				return index; }
		}
		return -1;
    }
    //
    //
    // ********** USEFUL HELPER METHODS ****
 	//
    
    /**\
     * The getRandomInt method will generate random integer within a specified range min to max.
     */

 	public static int getRandomInt(int min, int max) {
 		return (int) (Math.random() * (max - min + 1) + min);
 	}
 	
 	/**
 	 * The areStringsMatch method returns a boolean value if the value of two Strings are matched.
 	 */
 	
 	public static boolean areStringsMatch(String str1, String str2, boolean isCaseSensitive, boolean isExact)
 	{
 		String mainStr = str1;
 		String subStr = str2;
 		
 		if (subStr.length() > 0) 
 		{
 			// First, check if the lengths are equal. If not, they cannot be a match.
 			if (isExact){
 				if (mainStr.length() != subStr.length()){
 					return false;
 				}
 			}
 			// Next step. Convert the 2 strings to lowercase to compare not case sensitive.
 			if (!isCaseSensitive) 
 			{
 				mainStr = str1.toLowerCase();
 				subStr = str2.toLowerCase();
 			}
 			// Next step, comparing characters individually.
 			for (int i = 0; i < mainStr.length(); i++)
 			{
 				if (i < subStr.length()){
 					if (mainStr.charAt(i) != subStr.charAt(i)){
 						// If any character mismatch is found, the strings are not a match.
 						return false;
 					}
 				}				
 			}			
 			// If the loop completes without finding any mismatches, the strings are a match.
 			return true;
 		} else return false;		
 	}	
 	
 	/**
 	 * The isItYes method prompts the user for yes or no. The method returns true if the User inputs yes or false if no.
 	 */
 	
 	public static boolean isItYes(String text) 
 	{
 		System.out.print("\n" + text);
 		System.out.print(" (Enter " + textBold + "[Y]" + textNormal+ " for yes.): ");
 		
 		String userInput = scanner.next().toLowerCase();
 		scanner.nextLine();
 		boolean theAnswerIs = true;
 		if (areStringsMatch(userInput, "no", false, false)) {
 			theAnswerIs = false;  // Since user input is 'no' then it returns false.
 		} else if (!areStringsMatch(userInput, "y", false, false)) {
 			System.out.println("Invalid input. Assuming your respond is 'no'.");
 			theAnswerIs = false;  // Invalid input causes to return false. 
 		}
 		return theAnswerIs;
 	}
 	
 	/**
 	 * The getIntInput obtains the int input of the user and confirms if the User's input is in the form of an int.
 	 */
 	
 	public static int getIntInput(int min, int max)
 	{	
 		boolean isValid = false;
 		int numInput = 0;
 		
         while(!isValid)
         {
         	numInput = 0;
         	System.out.print("Enter your choice (" + min + "-" + max + "): ");
         	
         	// scanner.hasNextInt() verifies if the user's input is an integer before scanner.nextInt()
         	// attempts to read it. It returns value of true if the input is an integer. It returns false
         	// otherwise.
         	// scanner.nextInt() returns the integer value of the user's input instead of String value.
         	if (scanner.hasNextInt()) {
         		numInput = scanner.nextInt();
         		scanner.nextLine(); // Consume the leftover newLine character
         		if (numInput >= min && numInput <= max) {
         			isValid = true;
         		} else {
         			System.out.println("Invalid input. Please enter a number from " + min + " to " + max + ".");
         		}
         	} else {
         		System.out.println("Invalid input. Please enter a number from " + min + " to " + max + ".");
         		scanner.next(); // Consumes the non-integer token
         	}
         }
         System.out.println();
         return numInput;
 	}
 	
 	/**
 	 * The enterToContinue method prompts the user to press enter to continue, which is useful for separating long strings of information
 	 * to not overwhelm the user all at once and allow them to read any important information.
 	 */
 	
 	public static void enterToContinue() 
 	{
 		String str = ">>> "+textItalic+"Press "+textNormal+textBold+"[Enter]"+textNormal+textItalic+" to continue..."+textNormal+" <<<";
 		// This next step will center the String by adding space Space on its left side.
 		if (str.length() < (charPerLn + 24)) {  // NOTE: Since textItalic, textNormal, textBold are counted in the string, +24 is added to charPerLn.
			int totalSpace = (charPerLn + 24) - str.length();
			int leftSpace = totalSpace / 2;
			for (int i = 0; i < leftSpace; i++) {
				str = " " + str;
			}
		}
 		System.out.println(str);
 		scanner.nextLine();
 	}
 	
 	/**
 	 * The nameMrMrs returns the value of Mr. or Ms. depending on the User's gender attribute to correctly address them in-game.
 	 */
 	
 	public static String nameMrMs(String gender) 
 	{
 		String prefix = "Mr. ";
 		if (gender=="female") {
 			prefix = "Ms. ";
 		}
 		return prefix;
 	}
 	
 	/**
 	 * The sopTrim method uses the System.out.println code and cuts the string when it reaches the maximum amount of characters per line
 	 * And enters a new line when it gets too long to provide convenience to the User for reading.
 	 */
 	
 	public static void sopTrim(String str, int maxChar) 
 	{
 		if (str == null || maxChar <= 0) 
 		{ // if parameter invalid. return str value.
 			System.out.println(str);
 			return;
 		}
 		int currentLineLength = 0;   // Sets the value of current line length at 0.
 		int lastSpaceIndex = -1;     // Sets the value of last space index at -1.
 		int lineStartIndex = 0;      // Sets the value of starting index of the line at 0;
 		
 		for (int i = 0; i < str.length(); i++) 
 		{
 			char currentChar = str.charAt(i);   // Set the value of current char at index i.
 			
 			if (currentChar == '\\' && i + 1 < str.length() && str.charAt(i+1) == 'n') 
 			{  // if current char has an escape newline character '\n'...
 				System.out.print("\n");
 				i++; 				
 				currentLineLength++;
 			}
 			
 			if (currentChar == '\\' && i + 1 < str.length() && str.charAt(i+1) == '"') 
 			{  // if current char has an escape quoation mark,...
 				i++;                         // skip to the next char since we don't want to print the backslash character. 				
 				currentChar = str.charAt(i); // assign the quotation mark to the current char.
 				currentLineLength++;         // skip the current line length.
 			}
 			
 			if (currentChar=='\\' && i+5<str.length() && str.charAt(i+1)=='u' && str.charAt(i+2)=='2' && str.charAt(i+3)=='0' && str.charAt(i+4)=='1' && str.charAt(i+5)=='4') 
 			{  // if current char has an escape em dash code,...
 				i = i + 5;                                  // skip to the next char since we don't want to print the backslash character. 				
 				currentChar = str.charAt('\u2014');         // assign the quotation mark to the current char.
 				currentLineLength = currentLineLength + 5;  // skip the current line length.
 			}
 			
 			if (currentChar == ' ') 
 			{
 				lastSpaceIndex = i;         // Marks index of the last space before it reached the end of the line. This is where the string breaks before it prints to the next line.
 			}
 			currentLineLength++;            // Adds 1 to current line length
 			if (currentLineLength == maxChar) 
 			{
 				if (lastSpaceIndex != -1 && lastSpaceIndex > lineStartIndex) 
 				{
 					printCharInRange(str, lineStartIndex, lastSpaceIndex);  // Break at the last space found.
 					System.out.println();                                   // Start a new line.
 					lineStartIndex = lastSpaceIndex + 1;
 					currentLineLength = i - lastSpaceIndex;                 // Recalculate length base on where we are now.
 					lastSpaceIndex = -1;                                    // resets the value of last space index to -1.
 				} 
 				else 
 				{
 					printCharInRange(str, lineStartIndex, i + 1);           // Hard break if no space was found.
 					System.out.println();                                   // Start a new line.
 					lineStartIndex = i + 1;
 					currentLineLength = 0;                                  // Current length base return to 0.
 					lastSpaceIndex = -1; 					                // resets the value of last space index to -1.
 				}
 			}		
 		}
 		if (lineStartIndex < str.length()) 
 		{                                // Print any remaining characters on the last line.
				printCharInRange(str, lineStartIndex, str.length());
				System.out.println();
 		}
 	}
 	
 	/**
 	 * This method works alongside the sopTrim method to help grab whatever characters were cut out in a single line
 	 * and print them out in a new line.
 	 */
 	
 	private static void printCharInRange(String str, int start, int end) 
 	{ 
 		for (int j = start; j < end; j++) { System.out.print(str.charAt(j)); }
 	}
 	
 	/**
 	 * The textCenter method adds a space to the left side of the string to make it appear like it's in the center of the line when print.
 	 */
 	
 	public static String textCenter(String str) 
 	{ 
 		if (str.length() < charPerLn) 
 		{
			int totalSpace = charPerLn - str.length();
			int leftSpace = totalSpace / 2;
			for (int i = 0; i < leftSpace; i++) {
				str = " " + str;
			}
		} 
 		return str;
 	}
 	//
 	//  THIS METHODS WILL HELP CONVERT THE PRONOUN DEPENDING ON THE GENDER.
 	//
 	
 	/**
 	 * The txHisHer methods return the strings of his or her in uppercase or lowercase values depending on the
 	 * User's gender attribute.
 	 */
 	
 	public static String txHisHer(String gender) 
 	{
 		String result = "his";
 		if (gender=="female") 
 		{
 			result = "her"; 
 		}
 		return result;
 	}
 	public static String txHisHer2(String gender) 
 	{
 		String result = "His";
 		if (gender=="female") 
 		{
 			result = "Her"; 
 		}
 		return result;
 	}
 	public static String txHimHer(String gender) 
 	{
 		String result = "him";
 		if (gender=="female") 
 		{ 
 			result = "her";
 		}
 		return result;
 	}
 	public static String txHeShe(String gender) 
 	{ 
 		String result = "he";
 		if (gender=="female") 
 		{
 			result = "she"; 
 		}
 		return result;
 	}
 	public static String txHeShe2(String gender) 
 	{
 		String result = "He";
 		if (gender=="female") 
 		{
 			result = "She";
 		}
 		return result;
 	}
 	
 	/**
 	 * The sopFound method adds fancy decor to the string before centering them.
 	 */
 	
 	private static void sopFound(String str) {
 		str = "==[[ "+ textBold + str +textNormal+ " ]]==";  
 		if (str.length() < charPerLn+8) {                   // 8 is the total number of characters textBold & textNormal combined.
			int totalSpace = charPerLn+8 - str.length();
			int leftSpace = totalSpace / 2;
			for (int i = 0; i < leftSpace; i++) {
				str = " " + str;
			}
		}
 		System.out.println(str);
 	}
 	
 	/**
 	 * Just like sopFound, sopDivider fancies up the printed text by adding decor between text.
 	 */
 	
 	private static void sopDivider() 
 	{
 		String str = "-~=~-~=~-~=~-~=~-~=~-~=~-~=~-~=~-~=~-~=~-~=~-";
 		// This next step will center the String by adding space Space on its left side.
 		if (str.length() < charPerLn) 
 		{
			int totalSpace = charPerLn - str.length();
			int leftSpace = totalSpace / 2;
			for (int i = 0; i < leftSpace; i++) {
				str = " " + str;
			}
		}
 		System.out.println(str);
 	}
 	
 	/**
 	 * The clock method tracks the time in-game and translates ints into values of minutes and hours.
 	 * The result returned is a String in the time format ##:## converted from totalMinutes.
 	 */
 	
  	public static String clock(int totalMinutes)
 	{
 		String hourStr = "";
 		String minuteStr = "";
 		
 		// Calculate hours using integer division
 		int hours = totalMinutes / 60;
 		
 		// Calculate remaining minutes using the modulo operator "%"
 		int minutes = totalMinutes % 60;
 		
 		if (minutes < 0 || minutes > 59) {
 			// Minutes out of range (0 - 59)
 			hours += minutes /60;
 			minutes %= 60;
 			if (minutes < 0) minutes += 60; // Handle negative remainder.
 		}
 		if (hours < 0) {
 			// Hours cannot be negative. Setting to 0.
 			hours = 0;
 		}	
 		hours = hours % 24; // Ensure hours are within 0-23
 		
 		hourStr = String.valueOf(hours);
 		if (hourStr.length() == 1) {
 			hourStr = "0" + hourStr;
 		}
 		minuteStr = String.valueOf(minutes);
 		if (minuteStr.length() == 1) {
 			minuteStr = "0" + minuteStr;
 		}
 		
 		return hourStr + ":" + minuteStr;
 	}
}
