/*
 * @Description: Indiana Jones and the Java Adventure is a point and click adventure game, a genre of games popularized in the late 80s to 90s. 
 * The idea of the game is to solve various challenges, whether it be escaping from a killer boulder, or simply thinking strategically in order to solve puzzles.
 * The ultimate goal of the game is to escape the temple to live another day, all while finding important archaeological relics. 
 * This game uses the functionality of a GUI through various menus, and all visual background labels, etc. 
 * It is very extensive in terms of using timers, variables, arrays, action listeners, key listeners, mouse listeners, if statements, switch cases, 
 * various methods, audio streams, and much more. 
 * @Author: AdrianFagarasanu
 * @Version: 1.0
 * @Date: 6/17/16
 */	
package fagarasanuIndianaJonesJavaAdventure;

import java.awt.EventQueue;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class fagarasanuIndianaJonesJavaAdventure {

	private JFrame frame;
	//Hard coded image icons to prevent code parse error
	
		//START Menu Related Icons
	private ImageIcon Background = new ImageIcon (getClass().getResource("/images/GameMainMenu.png")); //Main menu background
	private ImageIcon SettingsBackground = new ImageIcon (getClass().getResource("/images/GameSettingsMenu.png")); //Settings screen background
	private ImageIcon ControlsScreen = new ImageIcon (getClass().getResource("/images/ControlsScreen.png")); //Controls screen background
	private ImageIcon PlayButton = new ImageIcon (getClass().getResource("/images/btnPlay.png"));
	private ImageIcon QuitButton = new ImageIcon (getClass().getResource("/images/btnQuit.png"));
	private ImageIcon SettingsButton = new ImageIcon (getClass().getResource("/images/btnSettings.png"));
	private ImageIcon QuitPanel = new ImageIcon (getClass().getResource("/images/QuitPanel.png")); //Quit screen panel
	private ImageIcon QuitBackground = new ImageIcon (getClass().getResource("/images/QuitBackground.png")); //Quit screen background
	private ImageIcon YesButton = new ImageIcon (getClass().getResource("/images/btnYes.png"));
	private ImageIcon NoButton = new ImageIcon (getClass().getResource("/images/btnNo.png"));
	private ImageIcon ControlsButton = new ImageIcon (getClass().getResource("/images/btnControls.png"));
	private ImageIcon AudioButton = new ImageIcon (getClass().getResource("/images/btnAudio.png"));
	private ImageIcon BackButton = new ImageIcon (getClass().getResource("/images/btnBack.png"));
	private ImageIcon ResumeButton = new ImageIcon (getClass().getResource("/images/btnResume.png"));
	private ImageIcon MusicSlider = new ImageIcon (getClass().getResource("/images/lblMusicVolume.png")); //Music Volume Control
	private ImageIcon SFXSlider = new ImageIcon (getClass().getResource("/images/lblSFXVolume.png")); //Sound Effects Volume Control
	private ImageIcon InGameMenuBackground = new ImageIcon (getClass().getResource("/images/InGameMenuBackground.png")); //The background for the menu within the game
	private ImageIcon InventoryBackground = new ImageIcon (getClass().getResource("/images/InventoryPanel.png")); //Background for the inventory screen
	private ImageIcon InventoryIdol = new ImageIcon (getClass().getResource("/images/InventoryItem.png")); //Item Idol Button
	private ImageIcon InventoryWhip = new ImageIcon (getClass().getResource("/images/InventoryItemWhip.png")); //Item Whip Button
	private ImageIcon InventoryGoldBar = new ImageIcon (getClass().getResource("/images/InventoryGoldBar.png")); //Item Gold Bar Button
	private ImageIcon InventoryRopeLadder = new ImageIcon (getClass().getResource("/images/InventoryRopeLadder.png")); //Item Rope Ladder Button
		//END Menu Related Icons
	
		//START IntroMovie Related Icons
	private ImageIcon IntroText = new ImageIcon (getClass().getResource("/images/IntroTxt.png")); //"IceLand, 1939.."
	private ImageIcon Test1 = new ImageIcon (getClass().getResource("/images/Test1.png")); //Idol Image
	private ImageIcon Test2 = new ImageIcon (getClass().getResource("/images/Test2.png")); //Indiana stares at idol
	private ImageIcon Test3 = new ImageIcon (getClass().getResource("/images/Test3.png")); //Indiana sand in hand
	private ImageIcon Test4 = new ImageIcon (getClass().getResource("/images/Test.png")); //Indiana replaces idol with sand
	private ImageIcon Test4half = new ImageIcon (getClass().getResource("/images/Test4.5.png")); //Sand bag presses down button
	private ImageIcon Test5 = new ImageIcon (getClass().getResource("/images/Test5.png")); //Boulder chasing Indiana
		//END IntroMovie Related Icons
	
		//START Game Level One Related Icons
	private ImageIcon LevelOneBoulder = new ImageIcon (getClass().getResource("/images/LevelOneBoulder.png"));
	private ImageIcon LevelOneTemple = new ImageIcon (getClass().getResource("/images/LevelOneTemple.png"));
	private ImageIcon LevelOneTemple2 = new ImageIcon (getClass().getResource("/images/LevelOneTemple2.png")); //Screen without gold bar (after item is clicked)
	private ImageIcon LevelOneTemple2Gold = new ImageIcon (getClass().getResource("/images/LevelOneTemple2Gold.png")); //Screen with gold bar 
	private ImageIcon LevelOneTempleDoorways = new ImageIcon (getClass().getResource("/images/Doorways.png")); //Character moves underneath
	private ImageIcon LevelOneTemple3 = new ImageIcon (getClass().getResource("/images/LevelOneTemple3.png"));
	private ImageIcon LevelOneTemple3RopeLadder = new ImageIcon (getClass().getResource("/images/LevelOneTemple3RopeLadder.png")); //Screen with ladder over hole
	private ImageIcon LevelOneTemple4 = new ImageIcon (getClass().getResource("/images/LevelOneTemple4.png"));
	private ImageIcon LevelOneTemple4Pillars = new ImageIcon (getClass().getResource("/images/LevelOneTemple4Pillars.png")); //Character moves underneath
	private ImageIcon LevelOneTemple5 = new ImageIcon (getClass().getResource("/images/LevelOneTemple5.png"));
	private ImageIcon LevelOneTempleExit = new ImageIcon (getClass().getResource("/images/LevelOneTempleExit.png")); //Cave entrance
	private ImageIcon LevelOneTempleRocks = new ImageIcon (getClass().getResource("/images/LevelOneTempleRocks.png")); //Character moves underneath
	private ImageIcon LevelOneIceland = new ImageIcon (getClass().getResource("/images/LevelOneIceland.png"));
	private ImageIcon EndScreen = new ImageIcon (getClass().getResource("/images/EndScreen.png")); //"To Be Continued..."
		//END Game Level One Related Icons
	
		//START Boulder Animation Related Icons
	private ImageIcon BoulderRock = new ImageIcon (getClass().getResource("/images/Boulder.png"));
	private ImageIcon BoulderRock1 = new ImageIcon (getClass().getResource("/images/Boulder1.png"));
	private ImageIcon BoulderRock2 = new ImageIcon (getClass().getResource("/images/Boulder2.png"));
	private ImageIcon BoulderRock3 = new ImageIcon (getClass().getResource("/images/Boulder3.png"));
	private ImageIcon BoulderRock4 = new ImageIcon (getClass().getResource("/images/Boulder4.png"));
	private ImageIcon BoulderRock5 = new ImageIcon (getClass().getResource("/images/Boulder5.png"));
	private ImageIcon BoulderRock6 = new ImageIcon (getClass().getResource("/images/Boulder6.png"));
	private ImageIcon BoulderRock7 = new ImageIcon (getClass().getResource("/images/Boulder7.png"));
	private ImageIcon BoulderRock8 = new ImageIcon (getClass().getResource("/images/Boulder8.png"));
	private ImageIcon BoulderRock9 = new ImageIcon (getClass().getResource("/images/Boulder9.png"));
	private ImageIcon BoulderRock10 = new ImageIcon (getClass().getResource("/images/Boulder10.png"));
	private ImageIcon BoulderRock11 = new ImageIcon (getClass().getResource("/images/Boulder11.png"));
	private ImageIcon BoulderRock12 = new ImageIcon (getClass().getResource("/images/Boulder12.png"));
	private ImageIcon BoulderRock13 = new ImageIcon (getClass().getResource("/images/Boulder13.png"));
	private ImageIcon BoulderRock14 = new ImageIcon (getClass().getResource("/images/Boulder14.png"));
	private ImageIcon BoulderRock15 = new ImageIcon (getClass().getResource("/images/Boulder15.png"));
	private ImageIcon BoulderRock16 = new ImageIcon (getClass().getResource("/images/Boulder16.png"));
	private ImageIcon BoulderRock17 = new ImageIcon (getClass().getResource("/images/Boulder17.png"));
	private ImageIcon BoulderRock18 = new ImageIcon (getClass().getResource("/images/Boulder18.png"));
	private ImageIcon BoulderRock19 = new ImageIcon (getClass().getResource("/images/Boulder19.png"));
	private ImageIcon BoulderRock20 = new ImageIcon (getClass().getResource("/images/Boulder20.png"));
	private ImageIcon BoulderRock21 = new ImageIcon (getClass().getResource("/images/Boulder21.png"));
	private ImageIcon BoulderRock22 = new ImageIcon (getClass().getResource("/images/Boulder22.png"));
	private ImageIcon BoulderRock23 = new ImageIcon (getClass().getResource("/images/Boulder23.png"));
	private ImageIcon BoulderRock24 = new ImageIcon (getClass().getResource("/images/Boulder24.png"));
	private ImageIcon BoulderRock25 = new ImageIcon (getClass().getResource("/images/Boulder25.png"));
	private ImageIcon BoulderRock26 = new ImageIcon (getClass().getResource("/images/Boulder26.png"));
	private ImageIcon BoulderRock27 = new ImageIcon (getClass().getResource("/images/Boulder27.png"));
	private ImageIcon BoulderRock28 = new ImageIcon (getClass().getResource("/images/Boulder28.png"));
	private ImageIcon BoulderRock29 = new ImageIcon (getClass().getResource("/images/Boulder29.png"));
	private ImageIcon BoulderRock30 = new ImageIcon (getClass().getResource("/images/Boulder30.png"));
	private ImageIcon BoulderRock31 = new ImageIcon (getClass().getResource("/images/Boulder31.png"));
	private ImageIcon BoulderRock32 = new ImageIcon (getClass().getResource("/images/Boulder32.png"));
	private ImageIcon BoulderRock33 = new ImageIcon (getClass().getResource("/images/Boulder33.png"));
	private ImageIcon BoulderRock34 = new ImageIcon (getClass().getResource("/images/Boulder34.png"));
	private ImageIcon BoulderRock35 = new ImageIcon (getClass().getResource("/images/Boulder35.png"));
		//END Boulder Animation Related Icons
	
		//START Character Walk Animation Icons
	private ImageIcon IndyStandingLeft = new ImageIcon (getClass().getResource("/images/IndyStandingLeft.png"));
	private ImageIcon IndyWalkingOneLeft = new ImageIcon (getClass().getResource("/images/IndyWalkOneLeft.png"));
	private ImageIcon IndyWalkingTwoLeft = new ImageIcon (getClass().getResource("/images/IndyWalkingTwoLeft.png"));
	private ImageIcon IndyWalkingThreeLeft = new ImageIcon (getClass().getResource("/images/IndyWalkingThreeLeft.png"));
	private ImageIcon IndyWalkingFourLeft = new ImageIcon (getClass().getResource("/images/IndyWalkingFourLeft.png"));
	private ImageIcon IndyWalkingFiveLeft = new ImageIcon (getClass().getResource("/images/IndyWalkingFiveLeft.png"));
	private ImageIcon IndyWalkingSixLeft = new ImageIcon (getClass().getResource("/images/IndyWalkingSixLeft.png"));
	private ImageIcon IndyWalkingSevenLeft = new ImageIcon (getClass().getResource("/images/IndyWalkingSevenLeftt.png"));
	private ImageIcon IndyWalkingOneRight = new ImageIcon (getClass().getResource("/images/IndyWalkingOneRight.png"));
	private ImageIcon IndyWalkingTwoRight = new ImageIcon (getClass().getResource("/images/IndyWalkingTwoRight.png"));
	private ImageIcon IndyWalkingThreeRight = new ImageIcon (getClass().getResource("/images/IndyWalkingThreeRight.png"));
	private ImageIcon IndyWalkingFourRight = new ImageIcon (getClass().getResource("/images/IndyWalkingFourRight.png"));
	private ImageIcon IndyWalkingFiveRight = new ImageIcon (getClass().getResource("/images/IndyWalkingFiveRight.png"));
	private ImageIcon IndyWalkingSixRight = new ImageIcon (getClass().getResource("/images/IndyWalkingSixRight.png"));
	private ImageIcon IndyWalkingSevenRight = new ImageIcon (getClass().getResource("/images/IndyWalkingSevenRight.png"));
		//END Character Walk Animation Icons
	
		//START Character Whip Animation Icons
	private ImageIcon IndyWhipOneRight = new ImageIcon (getClass().getResource("/images/IndyWhipOneRight.png"));
	private ImageIcon IndyWhipTwoRight = new ImageIcon (getClass().getResource("/images/IndyWhipTwoRightt.png"));
	private ImageIcon IndyWhipThreeRight = new ImageIcon (getClass().getResource("/images/IndyWhipThreeRight.png"));
	private ImageIcon IndyWhipFourRight = new ImageIcon (getClass().getResource("/images/IndyWhipFourRight.png"));
	private ImageIcon IndyWhipFiveRight = new ImageIcon (getClass().getResource("/images/IndyWhipFiveRight.png"));
	private ImageIcon IndyWhipSixRight = new ImageIcon (getClass().getResource("/images/IndyWhipSixRight.png"));
	private ImageIcon IndyWhipSevenRight = new ImageIcon (getClass().getResource("/images/IndyWhipSevenRight.png"));
	private ImageIcon IndyWhipEightRight = new ImageIcon (getClass().getResource("/images/IndyWhipEightRight.png"));
	private ImageIcon IndyWhipNineRight = new ImageIcon (getClass().getResource("/images/IndyWhipNineRight.png"));
	private ImageIcon IndyWhipTenRight = new ImageIcon (getClass().getResource("/images/IndyWhipTenRight.png"));
	private ImageIcon IndyWhipElevenRight = new ImageIcon (getClass().getResource("/images/IndyWhipElevenRight.png"));
	private ImageIcon IndyWhipTwelveRight = new ImageIcon (getClass().getResource("/images/IndyWhipTwelveRight.png"));
	private ImageIcon IndyWhipThirteenRight = new ImageIcon (getClass().getResource("/images/IndyWhipThirteenRight.png"));
	private ImageIcon IndyWhipFourteenRight = new ImageIcon (getClass().getResource("/images/IndyWhipFourteenRight.png"));
	private ImageIcon IndyWhipFifteenRight = new ImageIcon (getClass().getResource("/images/IndyWhipFifteenRight.png"));
	private ImageIcon IndyWhipSixteenRight = new ImageIcon (getClass().getResource("/images/IndyWhipSixteenRight.png"));
	private ImageIcon IndyWhipSeventeenRight = new ImageIcon (getClass().getResource("/images/IndyWhipSeventeenRight.png"));
	private ImageIcon IndyWhipEighteenRight = new ImageIcon (getClass().getResource("/images/IndyWhipEighteenRight.png"));
	private ImageIcon IndyWhipNineteenRight = new ImageIcon (getClass().getResource("/images/IndyWhipNineteenRight.png"));
	private ImageIcon IndyWhipTwentyRight = new ImageIcon (getClass().getResource("/images/IndyWhipTwentyRight.png"));
	private ImageIcon IndyWhipTwentyOneRight = new ImageIcon (getClass().getResource("/images/IndyWhipTwentyOneRight.png"));
	private ImageIcon IndyWhipTwentyTwoRight = new ImageIcon (getClass().getResource("/images/IndyWhipTwentyTwoRight.png"));
	private ImageIcon IndyWhipTwentyThreeRight = new ImageIcon (getClass().getResource("/images/IndyWhipTwentyThreeRight.png"));
	private ImageIcon IndyWhipTwentyFourRight = new ImageIcon (getClass().getResource("/images/IndyWhipTwentyFourRight.png"));
		//End Character Whip Animation Icons
	
		//Integer Variables
	private int gainMusic; //volume of music (directly linked to music slider in menu)
	private int gainSFX; //volume of sound effects (directly linked to sfx slider in menu)
	private int x; //x coordinate of boulder 
	private int y; //y coordinate of boulder
	private int xIndy; //x coordinate of Indiana
	private int yIndy; //y coordinate of Indiana
	private int mouseX; //x coordinate of mouse
	private int mouseY; //y coordinate of mouse
		//JPanels
	private JPanel panelMenu = new JPanel(); //Panel for the main menu
	private JPanel panelLevelOne = new JPanel(); //panel for the entire first level
	private JPanel panelIntro = new JPanel(); //panel for intro movie
	private JPanel panelInventory = new JPanel(); //panel for inventory screen
		//JSliders
	private JSlider sliderMusic = new JSlider(); //slider for music volume
	private JSlider sliderSound = new JSlider(); //slider for sfx volume
		//JLabels
    private JLabel lblMusicVolume = new JLabel(); //text labeling music slider
    private JLabel lblSFXVolume = new JLabel(); //text labeling sfx slider
	private JLabel lblInGameMenu = new JLabel(); //label for menu within game
	private JLabel lblControlsScreen = new JLabel(); //controls screen menu
	private JLabel lblControlsScreenInGame = new JLabel(); //controls screen in game menu
	private JPanel panelGameOver = new JPanel(); //panel for when the boulder kills Indiana
	private JLabel lblLevelOneBackground = new JLabel(); //label for backgrounds of level one
	private JLabel lblLevelOneDoorways = new JLabel(); //character goes underneath
	private JLabel lblLevelOnePillars = new JLabel(); //character goes underneath
	private JLabel lblLevelOneRopeLadder = new JLabel(); //Ladder  on screen
	private JLabel lblLevelOneTempleRocks = new JLabel(); //Character goes underneath
	private JLabel lblIndy = new JLabel(); //Character label
	private JLabel lblGameIntro = new JLabel(); //label for all pictures for movie slideshow
	private JLabel IntroTxt = new JLabel(); //"IceLand, 1939.."
	private JLabel lblBoulder = new JLabel(); //Boulder chasing Indiana
	private JLabel lblInventoryBackground = new JLabel(""); //background for inventory panel
	private JLabel lblPrompt = new JLabel("Press ENTER to Continue"); //Game over prompt to continue
	private JLabel lblItem = new JLabel(""); //world object names 
	private JLabel lblMotionChasm = new JLabel(""); //motion rectangle for world object chasm
	private JLabel lblMotionAncientStatue = new JLabel(""); //motion rectangle for world object ancient statue
	private JLabel lblMotionGoldBar = new JLabel(""); //motion rectangle for world object gold bar
	private JLabel lblMotionMinotaur = new JLabel(""); //motion rectangle for world object minotaur statue 
	private JLabel lblMotionHole = new JLabel(""); //motion rectangle for world object hole
	private JLabel lblMotionSkeleton = new JLabel(""); //motion rectangle for world object skeleton
	private JLabel lblMotionWaterfall = new JLabel(""); //motion rectangle for world object waterfall
	private JLabel lblMotionExit = new JLabel(""); //motion rectangle for world object exit
	private JLabel lblMotionCar = new JLabel(""); //motion rectangle for world object truck
	private JLabel lblDialogue = new JLabel(""); //label for all character dialogue
	private JLabel lblGameOver = new JLabel("GAME OVER"); //label letting the player know that the game is over when boulder hits you
		//JButtons
	private JButton btnSettings = new JButton("");
	private JButton btnPlay = new JButton("");
	private JButton btnQuit = new JButton("");
	private JButton btnQuitInGame = new JButton(""); //Same button but within game menu
	private JButton btnControls = new JButton("");
	private JButton btnControlsInGame = new JButton(""); //same button but within game menu
	private JButton btnAudio = new JButton("");
	private JButton btnBack = new JButton("");
	private JButton btnBackInGame = new JButton(""); //same button but within game menu
	private JButton btnResume = new JButton("");
	private JButton[] btnItemArray = new JButton[4]; //Array for all item buttons in inventory screen
		//String Variables
	private String[] ObjectName = new String[]{"CHASM", "ANCIENT STATUE", "GOLD BAR", "MINOTAUR STATUE", "HOLE", "SKELETON", "WATERFALL", "EXIT", "TRUCK"}; //array for all world object names
		//Boolean Variables
	boolean InGameMenu = false; //used to dictate whether in game menu is running or not
	boolean running = false; //used for stopping character during movement
	boolean ItemIdol = false; //dictate whether item button has been clicked
	boolean ItemWhip = false; //dictate whether item button has been clicked
	boolean ItemGoldBar = false; //dictate whether item button has been clicked
	boolean ItemRopeLadder = false; //dictate whether item button has been clicked
	boolean WhipAnimation = false; //used for making sure whip animation is done before player tries to try to move character
	boolean ExitClick = false; //used for distinguishing between two different background, but the same world object
	boolean MusicPlayingBoulder = false; //used to stop method music
	boolean MusicPlayingLevelOne = false; //used to stop method music
		//Timers
	private Timer Intro0; //IntroMovie image
	private Timer Intro1; //IntroMovie image
	private Timer Intro2; //IntroMovie image
	private Timer Intro3; //IntroMovie image
	private Timer Intro4; //IntroMovie image
	private Timer Intro5; //IntroMovie image
	private Timer Intro6; //IntroMovie image
	private Timer Intro7; //IntroMovie image
	private Timer IntroEnd; //Shuts off all previous timers, to start level one
	private Timer timerBoulderMove; //timer for boulder movement
	private Timer timerBoulderMoveRoll; //timer for boulder animation
	private Timer timerIndyWalk; //timer for character walk animation
	private Timer timerIndyWhip; //timer for character whip animation
	private Timer timerGameStop; //timer for ending the game at the end screen
	private Timer timerIndyMove; //timer for moving character
	
	URL Boulder = new URL (fagarasanuIndianaJonesJavaAdventure.class.getResource("/images/"), "IndyBoulder.wav");
	Clip BoulderSound = AudioSystem.getClip();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fagarasanuIndianaJonesJavaAdventure window = new fagarasanuIndianaJonesJavaAdventure();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//End of Main Method

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public fagarasanuIndianaJonesJavaAdventure() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 816, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.repaint();
		
		JPanel panelQuit = new JPanel();
		panelQuit.setBounds(190, 190, 449, 306);
		frame.getContentPane().add(panelQuit);
		panelQuit.setLayout(null);
		panelQuit.setVisible(false);
		
		JButton btnYes = new JButton("");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Thank you very much for playing\nIndiana Jones and the Java Adventure.\n\nBest Regards,\nAdrian Fagarasanu\n\nJune 17, 2016");
				System.exit(0);
				try {
					playButton();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); //End of Action Listener
		btnYes.setBounds(229, 245, 89, 34);
		panelQuit.add(btnYes);
		btnYes.setFont(new Font("SF Fedora Shadow", Font.BOLD, 13));
		btnYes.setIcon(YesButton);
		btnYes.setFocusable(false);
		
		JLabel lblMenuBackground = new JLabel("");
		
		JButton btnNo = new JButton("");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelQuit.setVisible(false);
				lblMenuBackground.setIcon(Background);
				btnPlay.setVisible(true);
				btnPlay.setEnabled(true);
				btnSettings.setVisible(true);
				btnSettings.setEnabled(true);
				btnQuit.setVisible(true);
				btnQuit.setEnabled(true);
				try {
					playButton();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); //End of Action Listener
		btnNo.setFont(new Font("SF Fedora Shadow", Font.BOLD, 13));
		btnNo.setBounds(328, 245, 89, 34);
		panelQuit.add(btnNo);
		btnNo.setIcon(NoButton);
		btnNo.setFocusable(false);
		
		JLabel lblQuitBackground = new JLabel("");
		lblQuitBackground.setBounds(0, 0, 449, 306);
		panelQuit.add(lblQuitBackground);
		lblQuitBackground.setIcon(QuitPanel);
		
		panelMenu.setBackground(Color.LIGHT_GRAY);
		panelMenu.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		//Main theme music for the main menu
		URL BackgroundMusic = new URL (fagarasanuIndianaJonesJavaAdventure.class.getResource("/images/"), "IndyTheme.wav"); 
		Clip Sound = AudioSystem.getClip();
		AudioInputStream ais = AudioSystem.getAudioInputStream(BackgroundMusic);
		Sound.open(ais);
		Sound.loop(Clip.LOOP_CONTINUOUSLY);
		FloatControl gainControl = (FloatControl) Sound.getControl(FloatControl.Type.MASTER_GAIN);
		//
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					playButton();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Sound.close();
				panelMenu.setVisible(false);
				panelIntro.setVisible(true);
				IntroTxt.setVisible(true);
				try {
					playIntro();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); //End of Action Listener
		btnPlay.setFont(new Font("SF Fedora Shadow", Font.BOLD, 13));
		btnPlay.setBounds(38, 495, 89, 34);
		panelMenu.add(btnPlay);
		btnPlay.setIcon(PlayButton);
		btnPlay.setFocusable(false);
		
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelQuit.setVisible(true);
				lblMenuBackground.setIcon(QuitBackground);
				btnPlay.setVisible(false);
				btnPlay.setEnabled(false);
				btnSettings.setVisible(false);
				btnSettings.setEnabled(false);
				btnQuit.setVisible(false);
				btnQuit.setEnabled(false);
				try {
					playButton();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); //End of Action Listener
		
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMenuBackground.setIcon(SettingsBackground);
				btnQuit.setVisible(false);
				btnQuit.setEnabled(false);
				btnControls.setVisible(true);
				btnControls.setEnabled(true);
				btnAudio.setVisible(true);
				btnAudio.setEnabled(true);
				btnBack.setVisible(true);
				btnBack.setEnabled(true);
				btnPlay.setVisible(false);
				btnPlay.setEnabled(false);
				btnSettings.setVisible(false);
				btnSettings.setEnabled(false);
				try {
					playButton();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); //End of Action Listener
		btnSettings.setFont(new Font("SF Fedora Shadow", Font.BOLD, 13));
		btnSettings.setBounds(38, 540, 160, 34);
		panelMenu.add(btnSettings);
		btnSettings.setIcon(SettingsButton);
		btnSettings.setFocusable(false);
		
		btnQuit.setFont(new Font("SF Fedora Shadow", Font.BOLD, 13));
		btnQuit.setBounds(676, 539, 89, 34);
		panelMenu.add(btnQuit);
		btnQuit.setIcon(QuitButton);
		btnQuit.setFocusable(false);
		
		btnQuitInGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelQuit.setVisible(true);
				try {
					playButton();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); //End of Action Listener
		
		sliderMusic.setBounds(350, 290, 420, 50);
		panelMenu.add(sliderMusic);
		sliderMusic.setMajorTickSpacing(10);
		sliderMusic.setPaintTicks(true);
		sliderMusic.setPaintLabels(true);
		sliderMusic.setFont(new Font ("SF Fedora Titles", Font.BOLD,9));
		sliderMusic.setBackground(new Color(210, 180, 140));
		sliderMusic.setValue(100);
		sliderMusic.setVisible(false);
		sliderMusic.setEnabled(false);
		sliderMusic.setFocusable(false);
		
		sliderMusic.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e){
				JSlider source = (JSlider) e.getSource();
				  
				//volume reduces when slider value changes
				
				if (source.getValue()==0){
					gainMusic = -80;
				}else if (source.getValue()<=10){
					gainMusic = -36;
				}else if (source.getValue()<=20){
					gainMusic = -32;
				}else if (source.getValue()<=30){
					gainMusic = -28;
				}else if (source.getValue()<=40){
					gainMusic = -24;
				}else if (source.getValue()<=50){
					gainMusic = -20;
				}else if (source.getValue()<=60){
					gainMusic = -16;
				}else if (source.getValue()<=70){
					gainMusic = -12;
				}else if (source.getValue()<=80){
					gainMusic = -8;
				}else if (source.getValue()<=90){
					gainMusic = -4;
				}else if (source.getValue()==100){
					gainMusic = 0;
				} //End of if else statement
					
				gainControl.setValue(gainMusic); // Reduce music volume by slider volume (in decibels).
				
			}
		}); //End of Change Listener
		
		sliderSound.setBounds(350, 400, 420, 50);
		panelMenu.add(sliderSound);
		sliderSound.setMajorTickSpacing(10);
		sliderSound.setPaintTicks(true);
		sliderSound.setPaintLabels(true);
		sliderSound.setFont(new Font ("SF Fedora Titles", Font.BOLD,9));
		sliderSound.setBackground(new Color(210, 180, 140));
		sliderSound.setValue(100);
		sliderSound.setVisible(false);
		sliderSound.setEnabled(false);
		sliderSound.setFocusable(false);
		
		sliderSound.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e){
				JSlider source = (JSlider) e.getSource();

				//volume reduces when slider value changes
				
				if (source.getValue()==0){
					gainSFX = -80;
				}else if (source.getValue()<=10){
					gainSFX = -45;
				}else if (source.getValue()<=20){
					gainSFX = -40;
				}else if (source.getValue()<=30){
					gainSFX = -35;
				}else if (source.getValue()<=40){
					gainSFX = -30;
				}else if (source.getValue()<=50){
					gainSFX = -25;
				}else if (source.getValue()<=60){
					gainSFX = -20;
				}else if (source.getValue()<=70){
					gainSFX = -15;
				}else if (source.getValue()<=80){
					gainSFX = -10;
				}else if (source.getValue()<=90){
					gainSFX = -5;
				}else if (source.getValue()==100){
					gainSFX = 0;
				} //End of if else statement
				
			}
		}); //End of Change Listener
		
		lblMusicVolume.setBounds(84, 296, 340, 34);
		panelMenu.add(lblMusicVolume);
		lblMusicVolume.setIcon(MusicSlider);
		lblMusicVolume.setVisible(false);
		
		lblSFXVolume.setBounds(67, 407, 340, 34);
		panelMenu.add(lblSFXVolume);
		lblSFXVolume.setIcon(SFXSlider);
		lblSFXVolume.setVisible(false);
		
		btnQuitInGame.setFont(new Font("SF Fedora Shadow", Font.BOLD, 13));
		btnQuitInGame.setBounds(38, 539, 89, 34);
		panelLevelOne.add(btnQuitInGame);
		btnQuitInGame.setIcon(QuitButton);
		btnQuitInGame.setVisible(false);
		btnQuitInGame.setEnabled(false);
		btnQuitInGame.setFocusable(false);
		
		btnControls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					playButton();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblMenuBackground.setIcon(QuitBackground);
				lblControlsScreen.setVisible(true);
				btnControls.setVisible(false);
				btnControls.setEnabled(false);
				btnAudio.setVisible(false);
				btnAudio.setEnabled(false);
			}
		}); //End of Action Listener
		btnControls.setBounds(38, 451, 160, 34);
		panelMenu.add(btnControls);
		btnControls.setIcon(ControlsButton);
		btnControls.setVisible(false);
		btnControls.setEnabled(false);
		btnControls.setFocusable(false);
		
		btnControlsInGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					playButton();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblControlsScreenInGame.setVisible(true);
				btnBackInGame.setVisible(true);
				btnBackInGame.setEnabled(true);
				btnControlsInGame.setVisible(false);
				btnControlsInGame.setEnabled(false);
				btnQuitInGame.setVisible(false);
				btnQuitInGame.setEnabled(false);
				btnResume.setVisible(false);
				btnResume.setEnabled(false);
				}
			}); //End of Action Listener
			btnControlsInGame.setBounds(38, 496, 160, 34);
			panelLevelOne.add(btnControlsInGame);
			btnControlsInGame.setIcon(ControlsButton);
			btnControlsInGame.setVisible(false);
			btnControlsInGame.setEnabled(false);
			btnControlsInGame.setFocusable(false);

		btnAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					playButton();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblMenuBackground.setIcon(QuitBackground);
				btnControls.setVisible(false);
				btnControls.setEnabled(false);
				btnAudio.setVisible(false);
				btnAudio.setEnabled(false);
				sliderMusic.setVisible(true);
				sliderMusic.setEnabled(true);
				sliderSound.setVisible(true);
		        sliderSound.setEnabled(true);
		        lblMusicVolume.setVisible(true);
		        lblSFXVolume.setVisible(true);
			}
		}); //End of Action Listener
		btnAudio.setBounds(38, 496, 98, 34);
		panelMenu.add(btnAudio);
		btnAudio.setIcon(AudioButton);
		btnAudio.setVisible(false);
		btnAudio.setEnabled(false);
		btnAudio.setFocusable(false);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblMenuBackground.getIcon()==QuitBackground){
					lblMenuBackground.setIcon(SettingsBackground);
					btnQuit.setVisible(false);
					btnControls.setVisible(true);
					btnControls.setEnabled(true);
					btnAudio.setVisible(true);
					btnAudio.setEnabled(true);
					btnBack.setVisible(true);
					btnBack.setEnabled(true);
					btnPlay.setVisible(false);
					btnPlay.setEnabled(false);
					btnSettings.setVisible(false);
					btnSettings.setEnabled(false);
			        sliderMusic.setVisible(false);
			        sliderMusic.setEnabled(false);
			        sliderSound.setVisible(false);
			        sliderSound.setEnabled(false);
			        lblMusicVolume.setVisible(false);
			        lblSFXVolume.setVisible(false);
			        lblControlsScreen.setVisible(false);
				}else{
					panelQuit.setVisible(false);
					lblMenuBackground.setIcon(Background);
					btnPlay.setVisible(true);
					btnPlay.setEnabled(true);
					btnSettings.setVisible(true);
					btnSettings.setEnabled(true);
					btnQuit.setVisible(true);
					btnQuit.setEnabled(true);
					btnControls.setVisible(false);
					btnControls.setEnabled(false);
					btnBack.setVisible(false);
					btnBack.setEnabled(false);
					btnAudio.setVisible(false);
					btnAudio.setEnabled(false);
				} //End of if else statement

				try {
					playButton();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); //End of Action Listener
		btnBack.setBounds(38, 539, 89, 34);
		panelMenu.add(btnBack);
		btnBack.setIcon(BackButton);
		btnBack.setVisible(false);
		btnBack.setEnabled(false);
		btnBack.setFocusable(false);
		
		btnBackInGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblControlsScreenInGame.setVisible(false);
				btnBackInGame.setVisible(false);
				btnBackInGame.setEnabled(false);
				btnControlsInGame.setVisible(true);
				btnControlsInGame.setEnabled(true);
				btnQuitInGame.setVisible(true);
				btnQuitInGame.setEnabled(true);
				btnResume.setVisible(true);
				btnResume.setEnabled(true);

				try {
					playButton();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); //End of Action Listener
		btnBackInGame.setBounds(38, 539, 89, 34);
		panelLevelOne.add(btnBackInGame);
		btnBackInGame.setIcon(BackButton);
		btnBackInGame.setVisible(false);
		btnBackInGame.setEnabled(false);
		btnBackInGame.setFocusable(false);
		
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResume.setVisible(false);
				btnResume.setEnabled(false);
				btnControlsInGame.setVisible(false);
				btnControlsInGame.setEnabled(false);
				btnQuitInGame.setVisible(false);
				btnQuitInGame.setEnabled(false);
				btnBackInGame.setVisible(false);
				btnBackInGame.setEnabled(false);
				lblControlsScreenInGame.setVisible(false);
					//sets default cursor image
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image PointandClickCursor = toolkit.getImage(getClass().getResource("/images/MainCursor.png"));
				Cursor c = toolkit.createCustomCursor(PointandClickCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
				panelLevelOne.setCursor (c);
				panelInventory.setCursor (c);
					//
				lblInGameMenu.setVisible(false);
				if (lblLevelOneBackground.getIcon()==LevelOneBoulder){
					timerBoulderMove.start();
					timerBoulderMoveRoll.start();
				}
				InGameMenu = false;
				try {
					playMenuClick();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); //End of Action Listener
		btnResume.setBounds(38, 451, 160, 34);
		panelLevelOne.add(btnResume);
		btnResume.setIcon(ResumeButton);
		btnResume.setVisible(false);
		btnResume.setEnabled(false);
		btnResume.setFocusable(false);
		
		lblControlsScreen.setBounds(0, 0, 800, 600);
		panelMenu.add(lblControlsScreen);
		lblControlsScreen.setIcon(ControlsScreen);
		lblControlsScreen.setVisible(false);
		
		lblControlsScreenInGame.setBounds(0, 0, 800, 600);
		panelLevelOne.add(lblControlsScreenInGame);
		lblControlsScreenInGame.setIcon(ControlsScreen);
		lblControlsScreenInGame.setVisible(false);
		
		lblMenuBackground.setBounds(0, 0, 800, 600);
		panelMenu.add(lblMenuBackground);
		lblMenuBackground.setIcon(Background);
		
		panelIntro.setBackground(Color.BLACK);
		panelIntro.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(panelIntro);
		panelIntro.setLayout(null);
		panelIntro.setVisible(false);
		
		IntroTxt.setBounds(38, 539, 240, 34);
		panelIntro.add(IntroTxt);
		IntroTxt.setIcon(IntroText);
		IntroTxt.setVisible(false);
		
		lblGameIntro.setBounds(0, 0, 800, 600);
		panelIntro.add(lblGameIntro);
		lblGameIntro.setVisible(true);
		lblGameIntro.setFocusable(true);
		
		panelInventory.setBounds(190, 100, 449, 306);
		panelInventory.setLayout(null);
		frame.getContentPane().add(panelInventory);
		panelInventory.setVisible(false);
		
		for(int i = 0 ; i <  btnItemArray.length; i++){ //creates all the proper inventory buttons using an array
			btnItemArray[i] = new JButton("Button" + i);
		    panelInventory.add(btnItemArray[i]);
		} //End of Array
		
		btnItemArray[0].setBounds(30, 28, 65, 60); //Idol inventory item
		btnItemArray[0].setText("");
		btnItemArray[0].setIcon(InventoryIdol);
		btnItemArray[0].setFocusable(false);
		btnItemArray[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image PointandClickIdolCursor = toolkit.getImage(getClass().getResource("/images/IdolCursor.png"));
				Cursor a = toolkit.createCustomCursor(PointandClickIdolCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
				panelLevelOne.setCursor (a);
				panelInventory.setCursor (a);
				
				panelInventory.setVisible(false);
				ItemIdol=true;
				ItemWhip=false;
				ItemGoldBar=false;
			}
		}); //End of Action Listener
		
		
		btnItemArray[1].setBounds(103, 28, 65, 60); //whip inventory item
		btnItemArray[1].setText("");
		btnItemArray[1].setIcon(InventoryWhip);
		btnItemArray[1].setFocusable(false);
		btnItemArray[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//sets default cursor
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image PointandClickWhipCursor = toolkit.getImage(getClass().getResource("/images/WhipCursor.png"));
				Cursor b = toolkit.createCustomCursor(PointandClickWhipCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
				panelLevelOne.setCursor (b);
				panelInventory.setCursor (b);
					//
				panelInventory.setVisible(false);
				ItemWhip=true;
				ItemIdol=false;
				ItemGoldBar=false;
			}
		}); //End of Action Listener
		
		btnItemArray[2].setBounds(176, 28, 65, 60); //gold bar inventory item
		btnItemArray[2].setText("");
		btnItemArray[2].setIcon(InventoryGoldBar);
		btnItemArray[2].setFocusable(false);
		btnItemArray[2].setVisible(false);
		btnItemArray[2].setEnabled(false);
		btnItemArray[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//sets default cursor
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image PointandClickWhipCursor = toolkit.getImage(getClass().getResource("/images/GoldBarCursor.png"));
				Cursor b = toolkit.createCustomCursor(PointandClickWhipCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
				panelLevelOne.setCursor (b);
				panelInventory.setCursor (b);
					//
				panelInventory.setVisible(false);
				ItemWhip=false;
				ItemIdol=false;
				ItemRopeLadder=false;
				ItemGoldBar=true;
			}
		}); //End of Action Listener
		
		btnItemArray[3].setBounds(249, 28, 65, 60); //rope ladder inventory item
		btnItemArray[3].setText("");
		btnItemArray[3].setIcon(InventoryRopeLadder);
		btnItemArray[3].setFocusable(false);
		btnItemArray[3].setVisible(false);
		btnItemArray[3].setEnabled(false);
		btnItemArray[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//sets default cursor
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image PointandClickWhipCursor = toolkit.getImage(getClass().getResource("/images/RopeLadderCursor.png"));
				Cursor b = toolkit.createCustomCursor(PointandClickWhipCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
				panelLevelOne.setCursor (b);
				panelInventory.setCursor (b);
					//
				panelInventory.setVisible(false);
				ItemWhip=false;
				ItemIdol=false;
				ItemGoldBar=false;
				ItemRopeLadder=true;
			}
		}); //End of Action Listener
		
		panelInventory.add(lblInventoryBackground);
		lblInventoryBackground.setBounds(0, 0, 449, 306);
		lblInventoryBackground.setIcon(InventoryBackground);
		lblLevelOneBackground.setFocusable(false);
		
		panelLevelOne.setBackground(Color.BLACK);
		panelLevelOne.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(panelLevelOne);
		panelLevelOne.setLayout(null);
		panelLevelOne.setVisible(false);
		
		lblInGameMenu.setBounds(0, 0, 800, 600);
		panelLevelOne.add(lblInGameMenu);
		lblInGameMenu.setIcon(InGameMenuBackground);
		lblInGameMenu.setVisible(false);
		lblDialogue.setBounds(67, 200, 661, 34);
		panelLevelOne.add(lblDialogue);
		lblDialogue.setForeground(new Color(255, 255, 255));
		lblDialogue.setFont(new Font("SF Fedora Titles", Font.BOLD, 13));
		lblDialogue.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblItem.setBounds(235, 575, 340, 34);
		panelLevelOne.add(lblItem);
		lblItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblItem.setForeground(new Color(255, 255, 255));
		lblItem.setFont(new Font("SF Fedora Titles", Font.BOLD, 13));
		lblItem.setText("");
		
		lblBoulder.setBounds(700, 335, 250, 250);
		panelLevelOne.add(lblBoulder);
		lblBoulder.setIcon(BoulderRock);
		lblBoulder.setVisible(true);
		
		lblLevelOneDoorways.setBounds(0, 0, 800, 600);
		panelLevelOne.add(lblLevelOneDoorways);
		lblLevelOneDoorways.setIcon(LevelOneTempleDoorways);
		lblLevelOneDoorways.setVisible(false);
		
		lblLevelOnePillars.setBounds(0, 0, 800, 600);
		panelLevelOne.add(lblLevelOnePillars);
		lblLevelOnePillars.setIcon(LevelOneTemple4Pillars);
		lblLevelOnePillars.setVisible(false);
		
		lblLevelOneTempleRocks.setBounds(0, 0, 800, 600);
		panelLevelOne.add(lblLevelOneTempleRocks);
		lblLevelOneTempleRocks.setIcon(LevelOneTempleRocks);
		lblLevelOneTempleRocks.setVisible(false);
		
		lblIndy.setBounds(504, 420, 100, 200);
		panelLevelOne.add(lblIndy);
		lblIndy.setIcon(IndyStandingLeft);
		
		//START OF TIMER CODE WHIP ANIMATION
		ActionListener IndyWhip = new ActionListener(){
			//The actions that will play out for the created timer

			@Override
			public void actionPerformed(ActionEvent arg0) {
					//Whip animation
				WhipAnimation=true;
				if (lblIndy.getIcon()==IndyStandingLeft){
					lblIndy.setIcon(IndyWhipOneRight);
					lblIndy.setBounds(180, 300, 934, 420);
				} else if (lblIndy.getIcon()==IndyWhipOneRight){
					lblIndy.setIcon(IndyWhipTwoRight);
				} else if (lblIndy.getIcon()==IndyWhipTwoRight){
					lblIndy.setIcon(IndyWhipThreeRight);
				} else if (lblIndy.getIcon()==IndyWhipThreeRight){
					lblIndy.setIcon(IndyWhipFourRight);
				} else if (lblIndy.getIcon()==IndyWhipFourRight){
					lblIndy.setIcon(IndyWhipFiveRight);
				} else if (lblIndy.getIcon()==IndyWhipFiveRight){
					lblIndy.setIcon(IndyWhipSixRight);
				} else if (lblIndy.getIcon()==IndyWhipSixRight){
					lblIndy.setIcon(IndyWhipSevenRight);
				} else if (lblIndy.getIcon()==IndyWhipSevenRight){
					lblIndy.setIcon(IndyWhipEightRight);
				} else if (lblIndy.getIcon()==IndyWhipEightRight){
					lblIndy.setIcon(IndyWhipNineRight);
				} else if (lblIndy.getIcon()==IndyWhipNineRight){
					lblIndy.setIcon(IndyWhipTenRight);
				} else if (lblIndy.getIcon()==IndyWhipTenRight){
					lblIndy.setIcon(IndyWhipElevenRight);
				} else if (lblIndy.getIcon()==IndyWhipElevenRight){
					lblIndy.setIcon(IndyWhipTwelveRight);
				}  else if (lblIndy.getIcon()==IndyWhipTwelveRight){
					lblIndy.setIcon(IndyWhipThirteenRight);
				}  else if (lblIndy.getIcon()==IndyWhipThirteenRight){
					lblIndy.setIcon(IndyWhipFourteenRight);
				}  else if (lblIndy.getIcon()==IndyWhipFourteenRight){
					lblIndy.setIcon(IndyWhipFifteenRight);
				} else if (lblIndy.getIcon()==IndyWhipFifteenRight){
					lblIndy.setIcon(IndyWhipSixteenRight);
				} else if (lblIndy.getIcon()==IndyWhipSixteenRight){
					lblIndy.setIcon(IndyWhipSeventeenRight);
				} else if (lblIndy.getIcon()==IndyWhipSeventeenRight){
					lblIndy.setIcon(IndyWhipEighteenRight);
				} else if (lblIndy.getIcon()==IndyWhipEighteenRight){
					lblIndy.setIcon(IndyWhipNineteenRight);
				} else if (lblIndy.getIcon()==IndyWhipNineteenRight){
					lblIndy.setIcon(IndyWhipTwentyRight);
				} else if (lblIndy.getIcon()==IndyWhipTwentyRight){
					lblIndy.setIcon(IndyWhipTwentyOneRight);
				} else if (lblIndy.getIcon()==IndyWhipTwentyOneRight){
					lblIndy.setIcon(IndyWhipTwentyTwoRight);
				} else if (lblIndy.getIcon()==IndyWhipTwentyTwoRight){
					lblIndy.setIcon(IndyWhipTwentyThreeRight);
				} else if (lblIndy.getIcon()==IndyWhipTwentyThreeRight){
					lblIndy.setIcon(IndyWhipTwentyFourRight);
				} else if (lblIndy.getIcon()==IndyWhipTwentyFourRight){
						//resets character back to walking animation
					lblIndy.setIcon(IndyStandingLeft); 
					lblIndy.setBounds(260, 425, 100, 200);
					xIndy = 260;
					yIndy = 425;
					lblIndy.setLocation(xIndy, yIndy);
					timerIndyWhip.stop();
					WhipAnimation=false;
						//
				} 
			}

		}; //End of Action Listener

		timerIndyWhip = new Timer(160, (IndyWhip));
		//END OF TIMER CODE WHIP ANIMATION
		
		lblLevelOneRopeLadder.setBounds(0, 0, 800, 600);
		panelLevelOne.add(lblLevelOneRopeLadder);
		lblLevelOneRopeLadder.setIcon(LevelOneTemple3RopeLadder);
		lblLevelOneRopeLadder.setVisible(false);
		
		//START KEY/MOUSE LISTENER CHASM
		lblMotionChasm.addMouseListener(new MouseAdapter() {
			//For each motion lbl listener, there is a function of displaying text when hovered over and performing various tasks. Such as changing background, etc.
			@Override
			public void mouseEntered(MouseEvent e) {
					//mouse hovers over
				if (lblLevelOneBackground.getIcon()==LevelOneTemple){
					lblItem.setText(ObjectName[0]);
				}//End of if else statement 
			}
			@Override
			public void mouseExited(MouseEvent e) {
					//mouse hovers off
				if (lblLevelOneBackground.getIcon()==LevelOneTemple){
					lblItem.setText("");
				}//End of if else statement
			}
			@Override
			public void mousePressed (MouseEvent e) {
				switch(e.getButton()){
				case MouseEvent.BUTTON1 :
						//left mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple){
							//gets the mouse location only when clicked
						mouseX = (MouseInfo.getPointerInfo().getLocation().x) - (panelLevelOne.getLocationOnScreen().x) - (36);	
						mouseY = (MouseInfo.getPointerInfo().getLocation().y) - (panelLevelOne.getLocationOnScreen().y) - (36);
							//
						timerIndyMove.start();
						timerIndyWalk.start();
						if (lblIndy.getLocation().x>=500){
							xIndy += 5;
						}//End of if statement
						if (lblIndy.getLocation().x<=260){
							xIndy -= 5;
						}//End of if statement 
						if (ItemWhip && lblIndy.getLocation().x >= 500){
							lblDialogue.setText("");
							timerIndyWhip.start();
							try {
								WhipSFX();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ItemWhip = false;
						} else if (ItemIdol && lblIndy.getLocation().x>=500){
							lblDialogue.setText("That won't work.");
							ItemIdol = false;
						} else if (lblIndy.getLocation().x>=500){
							lblDialogue.setText("I have to find a way to get across.");
						}//End of if else statement
							//sets default cursor
						Toolkit toolkit = Toolkit.getDefaultToolkit();
						Image PointandClickCursor = toolkit.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor z = toolkit.createCustomCursor(PointandClickCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (z);
						panelInventory.setCursor (z);
							//
					}//End of If else statement
					break;
				case MouseEvent.BUTTON3 :
						//right mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple){
						Toolkit toolkit2 = Toolkit.getDefaultToolkit();
						Image PointandClickCursor2 = toolkit2.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor x = toolkit2.createCustomCursor(PointandClickCursor2 , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (x);
						panelInventory.setCursor (x);
						ItemIdol=false;
        				ItemWhip=false;
					}
					break;
				}//End of switch case
			}
		}); 
		lblMotionChasm.setBounds(336, 550, 186, 105);
		panelLevelOne.add(lblMotionChasm);
		//END KEY/MOUSE LISTENER CHASM
		
		//START KEY/MOUSE LISTENER ANCIENT STATUE
		lblMotionAncientStatue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
					//mouse hovers over
				if (lblLevelOneBackground.getIcon()==LevelOneTemple2 || lblLevelOneBackground.getIcon()==LevelOneTemple2Gold){
					lblItem.setText(ObjectName[1]);
				}//End of if else statement
			}
			@Override
			public void mouseExited(MouseEvent e) {
					//mouse hovers off
				if (lblLevelOneBackground.getIcon()==LevelOneTemple2 || lblLevelOneBackground.getIcon()==LevelOneTemple2Gold){
					lblItem.setText("");
				}//End of if else statement
			}
			@Override
			public void mousePressed (MouseEvent e) {
				switch(e.getButton()){
				case MouseEvent.BUTTON1 :
						//left mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple2 || lblLevelOneBackground.getIcon()==LevelOneTemple2Gold){
						mouseX = (MouseInfo.getPointerInfo().getLocation().x) - (panelLevelOne.getLocationOnScreen().x) - (36);	
						mouseY = (MouseInfo.getPointerInfo().getLocation().y) - (panelLevelOne.getLocationOnScreen().y) - (36);
						timerIndyMove.start();
						timerIndyWalk.start();
						if (ItemWhip){
							lblDialogue.setText("Why would I do that?");
							ItemWhip = false;
						} else if (ItemIdol){
							lblDialogue.setText("That won't work.");
							ItemIdol = false;
						} else if (ItemGoldBar){
							lblDialogue.setText("There's no reason to do that.");
							ItemGoldBar = false;
						} else if (ItemRopeLadder){
							lblDialogue.setText("Nope.");
							ItemRopeLadder = false;
						} else{
							lblDialogue.setText("Uhhh. That thing is ugly.");
						}
					
						Toolkit toolkit = Toolkit.getDefaultToolkit();
						Image PointandClickCursor = toolkit.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor z = toolkit.createCustomCursor(PointandClickCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (z);
						panelInventory.setCursor (z);
					}
					break;
				case MouseEvent.BUTTON3 :
						//right mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple2 || lblLevelOneBackground.getIcon()==LevelOneTemple2Gold){
						Toolkit toolkit2 = Toolkit.getDefaultToolkit();
						Image PointandClickCursor2 = toolkit2.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor x = toolkit2.createCustomCursor(PointandClickCursor2 , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (x);
						panelInventory.setCursor (x);
						ItemIdol=false;
        				ItemWhip=false;
					}//End of if statement 
      				break;
				}//End of switch case
			}
		});
		//END KEY/MOUSE LISTENER ANCIENT STATUE
		
		//START KEY/MOUSE LISTENER EXIT
		lblMotionExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
					//mouse hovers over
				if (lblLevelOneBackground.getIcon()==LevelOneTemple5 || lblLevelOneBackground.getIcon()==LevelOneTempleExit){
					lblItem.setText(ObjectName[7]);
				}//end of if statement
			}
			@Override
			public void mouseExited(MouseEvent e) {
					//mouse hovers off
				if (lblLevelOneBackground.getIcon()==LevelOneTemple5 || lblLevelOneBackground.getIcon()==LevelOneTempleExit){
					lblItem.setText("");
				}//end of if statement
			}
			@Override
			public void mousePressed (MouseEvent e) {
				switch(e.getButton()){
				case MouseEvent.BUTTON1 :
						//left mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple5 || lblLevelOneBackground.getIcon()==LevelOneTempleExit){
						mouseX = (MouseInfo.getPointerInfo().getLocation().x) - (panelLevelOne.getLocationOnScreen().x) - (36);	
						mouseY = (MouseInfo.getPointerInfo().getLocation().y) - (panelLevelOne.getLocationOnScreen().y) - (36);
						if (ItemWhip){
							lblDialogue.setText("Why would I do that?");
							ItemWhip = false;
						} else if (ItemIdol){
							lblDialogue.setText("That won't work.");
							ItemIdol = false;
						} else if (ItemGoldBar){
							lblDialogue.setText("There's no reason to do that.");
							ItemGoldBar = false;
						} else if (ItemRopeLadder){
							lblDialogue.setText("Nope.");
							ItemRopeLadder = false;
						} else {
							if (lblLevelOneBackground.getIcon()==LevelOneTemple5){
								lblLevelOneBackground.setIcon(LevelOneTempleExit);
								lblLevelOneTempleRocks.setVisible(true);
								lblDialogue.setText("");
								lblItem.setText("");
								lblMotionExit.setBounds(580, 300, 120, 100);
								timerIndyMove.stop();
								timerIndyWalk.stop();
								lblIndy.setIcon(IndyStandingLeft);
								xIndy = 100;
								yIndy = 420;
								lblIndy.setLocation(xIndy, yIndy);
								ExitClick = false;
							}//end of if statement
							if (lblLevelOneBackground.getIcon()==LevelOneTempleExit && ExitClick){
								lblLevelOneBackground.setIcon(LevelOneIceland);
								lblLevelOneTempleRocks.setVisible(false);
								lblDialogue.setText("");
								lblItem.setText("");
								timerIndyMove.stop();
								timerIndyWalk.stop();
								lblIndy.setIcon(IndyStandingLeft);
								xIndy = 100;
								yIndy = 420;
								lblIndy.setLocation(xIndy, yIndy);
							}//end of if statement
						}//end of if else statement 
					
						Toolkit toolkit = Toolkit.getDefaultToolkit();
						Image PointandClickCursor = toolkit.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor z = toolkit.createCustomCursor(PointandClickCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (z);
						panelInventory.setCursor (z);
						
						ExitClick = true;
					}//end of if statement
					break;
				case MouseEvent.BUTTON3 :
						//right mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple5 || lblLevelOneBackground.getIcon()==LevelOneTempleExit){
						Toolkit toolkit2 = Toolkit.getDefaultToolkit();
						Image PointandClickCursor2 = toolkit2.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor x = toolkit2.createCustomCursor(PointandClickCursor2 , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (x);
						panelInventory.setCursor (x);
						ItemIdol=false;
        				ItemWhip=false;
        				ItemGoldBar=false;
					}//end of if statement
					break;
				}//End of switch case
			}
		});
		//END KEY/MOUSE LISTENER EXIT
		
		//START KEY/MOUSE LISTENER CAR
		lblMotionCar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
					//mouse hovers over
				if (lblLevelOneBackground.getIcon()==LevelOneIceland){
					lblItem.setText(ObjectName[8]);
				}//end of if statement
			}
			@Override
			public void mouseExited(MouseEvent e) {
					//mouse hovers off
				if (lblLevelOneBackground.getIcon()==LevelOneIceland){
					lblItem.setText("");
				}//end of if statement
			}
			@Override
			public void mousePressed (MouseEvent e) {
				switch(e.getButton()){
				case MouseEvent.BUTTON1 :
						//left mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneIceland){
						mouseX = (MouseInfo.getPointerInfo().getLocation().x) - (panelLevelOne.getLocationOnScreen().x) - (36);	
						mouseY = (MouseInfo.getPointerInfo().getLocation().y) - (panelLevelOne.getLocationOnScreen().y) - (36);
						MusicPlayingLevelOne=true;
						if (ItemWhip){
							lblDialogue.setText("Why would I do that?");
							ItemWhip = false;
						} else if (ItemIdol){
							lblDialogue.setText("That won't work.");
							ItemIdol = false;
						} else if (ItemGoldBar){
							lblDialogue.setText("There's no reason to do that.");
							ItemGoldBar = false;
						} else if (ItemRopeLadder){
							lblDialogue.setText("Nope.");
							ItemRopeLadder = false;
						} else {
							lblLevelOneBackground.setIcon(EndScreen);
							lblIndy.setVisible(false);
							lblItem.setText("");
							try {
								playTheme();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}//end of if else statement
					
						Toolkit toolkit = Toolkit.getDefaultToolkit();
						Image PointandClickCursor = toolkit.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor z = toolkit.createCustomCursor(PointandClickCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (z);
						panelInventory.setCursor (z);
						break;
					}
				case MouseEvent.BUTTON3 :
						//right mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneIceland){
						Toolkit toolkit2 = Toolkit.getDefaultToolkit();
						Image PointandClickCursor2 = toolkit2.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor x = toolkit2.createCustomCursor(PointandClickCursor2 , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (x);
						panelInventory.setCursor (x);
						ItemIdol=false;
        				ItemWhip=false;
        				ItemGoldBar=false;
					}//end of if statement
					break;
				}//end of switch case
			}
		});
		lblMotionCar.setBounds(500, 360, 100, 100);
		panelLevelOne.add(lblMotionCar);
		lblMotionExit.setBounds(580, 420, 120, 100);
		panelLevelOne.add(lblMotionExit);
		lblMotionAncientStatue.setBounds(280, 320, 60, 50);
		panelLevelOne.add(lblMotionAncientStatue);
		//END KEY/MOUSE LISTENER CAR
		
		//START KEY/MOUSE LISTENER GOLD BAR
		lblMotionGoldBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
					//mouse hovers over
				if (lblLevelOneBackground.getIcon()==LevelOneTemple2Gold){
					lblItem.setText(ObjectName[2]);
				} //end of if statement
			}
			@Override
			public void mouseExited(MouseEvent e) {
					//mouse hovers off
				if (lblLevelOneBackground.getIcon()==LevelOneTemple2Gold){
					lblItem.setText("");
				} //end of if statement
			}
			@Override
			public void mousePressed (MouseEvent e) {
				switch(e.getButton()){
				case MouseEvent.BUTTON1 :
						//left mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple2Gold){
						mouseX = (MouseInfo.getPointerInfo().getLocation().x) - (panelLevelOne.getLocationOnScreen().x) - (36);	
						mouseY = (MouseInfo.getPointerInfo().getLocation().y) - (panelLevelOne.getLocationOnScreen().y) - (36);
						timerIndyMove.start();
						timerIndyWalk.start();
						if (ItemWhip){
							lblDialogue.setText("Why would I do that?");
							ItemWhip = false;
						} else if (ItemIdol){
							lblDialogue.setText("That won't work.");
							ItemIdol = false;
						} else if (ItemRopeLadder){
							lblDialogue.setText("Nope.");
							ItemRopeLadder = false;
						} //end of if else statement
					
						Toolkit toolkit = Toolkit.getDefaultToolkit();
						Image PointandClickCursor = toolkit.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor z = toolkit.createCustomCursor(PointandClickCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (z);
						panelInventory.setCursor (z);
						
						lblDialogue.setText("");
						
						lblMotionGoldBar.grabFocus();
					}//end of if statement 
					break;
				case MouseEvent.BUTTON3 :
						//right mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple2 || lblLevelOneBackground.getIcon()==LevelOneTemple2Gold){
						Toolkit toolkit2 = Toolkit.getDefaultToolkit();
						Image PointandClickCursor2 = toolkit2.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor x = toolkit2.createCustomCursor(PointandClickCursor2 , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (x);
						panelInventory.setCursor (x);
						ItemIdol=false;
        				ItemWhip=false;
					}//end of if statement
					break;
				}//end of switch case
			}
		});
		lblMotionGoldBar.setBounds(480, 465, 60, 30);
		panelLevelOne.add(lblMotionGoldBar);
		//END KEY/MOUSE LISTENER GOLD BAR
		
		//START KEY/MOUSE LISTENER MINOTAUR
		lblMotionMinotaur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
					//mouse hovers over
				if (lblLevelOneBackground.getIcon()==LevelOneTemple3){
					lblItem.setText(ObjectName[3]);
				}//end of if statement
			}
			@Override
			public void mouseExited(MouseEvent e) {
					//mouse hovers off
				if (lblLevelOneBackground.getIcon()==LevelOneTemple3){
					lblItem.setText("");
				}//end of if statement
			}
			@Override
			public void mousePressed (MouseEvent e) {
				switch(e.getButton()){
				case MouseEvent.BUTTON1 :
						//left mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple3){
						mouseX = (MouseInfo.getPointerInfo().getLocation().x) - (panelLevelOne.getLocationOnScreen().x) - (36);	
						mouseY = (MouseInfo.getPointerInfo().getLocation().y) - (panelLevelOne.getLocationOnScreen().y) - (36);
						timerIndyMove.start();
						timerIndyWalk.start();
						if (ItemWhip){
							lblDialogue.setText("Why would I do that?");
							ItemWhip = false;
						} else if (ItemIdol){
							lblDialogue.setText("That won't work.");
							ItemIdol = false;
						} else if (ItemGoldBar){
							lblDialogue.setText("There's no reason to do that.");
							ItemGoldBar = false;
						} else if (ItemRopeLadder){
							lblDialogue.setText("Nope.");
							ItemRopeLadder = false;
						} else {
							lblDialogue.setText("Hmm.. Someone's been hitting the gym.");
						}//end of if else statement
					
						Toolkit toolkit = Toolkit.getDefaultToolkit();
						Image PointandClickCursor = toolkit.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor z = toolkit.createCustomCursor(PointandClickCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (z);
						panelInventory.setCursor (z);
					}//end of if statement
					break;
				case MouseEvent.BUTTON3 :
						//right mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple3){
						Toolkit toolkit2 = Toolkit.getDefaultToolkit();
						Image PointandClickCursor2 = toolkit2.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor x = toolkit2.createCustomCursor(PointandClickCursor2 , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (x);
						panelInventory.setCursor (x);
						ItemIdol=false;
        				ItemWhip=false;
        				ItemGoldBar=false;
					}//end of if statement
					break;
				}//end of switch case
			}
		});
		lblMotionMinotaur.setBounds(230, 310, 120, 210);
		panelLevelOne.add(lblMotionMinotaur);
		//END KEY/MOUSE LISTENER MINOTAUR
		
		//START KEY/MOUSE LISTENER HOLE
		lblMotionHole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
					//mouse hovers over
				if (lblLevelOneBackground.getIcon()==LevelOneTemple3){
					lblItem.setText(ObjectName[4]);
				}//end of if statement
			}
			@Override
			public void mouseExited(MouseEvent e) {
					//mouse hovers off
				if (lblLevelOneBackground.getIcon()==LevelOneTemple3){
					lblItem.setText("");
				}//end of if statement
			}
			@Override
			public void mousePressed (MouseEvent e) {
				switch(e.getButton()){
				case MouseEvent.BUTTON1 :
					if (lblLevelOneBackground.getIcon()==LevelOneTemple3){
							//left mouse button
						mouseX = (MouseInfo.getPointerInfo().getLocation().x) - (panelLevelOne.getLocationOnScreen().x) - (36);	
						mouseY = (MouseInfo.getPointerInfo().getLocation().y) - (panelLevelOne.getLocationOnScreen().y) - (36);
						timerIndyMove.start();
						timerIndyWalk.start();
						if (ItemWhip){
							lblDialogue.setText("Why would I do that?");
							ItemWhip = false;
						} else if (ItemIdol){
							lblDialogue.setText("That won't work.");
							ItemIdol = false;
						} else if (ItemGoldBar){
							lblDialogue.setText("There's no reason to do that.");
							ItemGoldBar = false;
						} else if (ItemRopeLadder){
							lblDialogue.setText("Good idea.");
							lblLevelOneRopeLadder.setVisible(true);
							ItemRopeLadder = false;
						} else if (lblLevelOneRopeLadder.isVisible()){
							lblDialogue.setText("");
							lblLevelOneBackground.setIcon(LevelOneTemple5);
							lblLevelOneRopeLadder.setVisible(false);
							lblItem.setText("");
							lblDialogue.setText("Will you look at that, I came in through here.");
							lblIndy.setIcon(IndyStandingLeft);
							xIndy = 620;
							yIndy = 420;
							lblIndy.setLocation(xIndy, yIndy);
						} else {
							lblDialogue.setText("It leads somewhere beyond the wall. I can hear an echo.");
						}//end of if else statement
					
						Toolkit toolkit = Toolkit.getDefaultToolkit();
						Image PointandClickCursor = toolkit.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor z = toolkit.createCustomCursor(PointandClickCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (z);
						panelInventory.setCursor (z);
					}//end of if statement
					break;
				case MouseEvent.BUTTON3 :
						//right mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple3){
						Toolkit toolkit2 = Toolkit.getDefaultToolkit();
						Image PointandClickCursor2 = toolkit2.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor x = toolkit2.createCustomCursor(PointandClickCursor2 , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (x);
						panelInventory.setCursor (x);
						ItemIdol=false;
        				ItemWhip=false;
        				ItemGoldBar=false;
					}//end of if statement
					break;
				}//end of switch case
			}
		});
		lblMotionHole.setBounds(500, 270, 120, 100);
		panelLevelOne.add(lblMotionHole);
		//END KEY/MOUSE LISTENER HOLE
		
		//START KEY/MOUSE LISTENER SKELETON
		lblMotionSkeleton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
					//mouse hovers over
				if (lblLevelOneBackground.getIcon()==LevelOneTemple4){
					lblItem.setText(ObjectName[5]);
				}//end of if statement
			}
			@Override
			public void mouseExited(MouseEvent e) {
					//mouse hovers off
				if (lblLevelOneBackground.getIcon()==LevelOneTemple4){
					lblItem.setText("");
				}//end of if statement
			}
			@Override
			public void mousePressed (MouseEvent e) {
				switch(e.getButton()){
				case MouseEvent.BUTTON1 :
						//left mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple4){
						mouseX = (MouseInfo.getPointerInfo().getLocation().x) - (panelLevelOne.getLocationOnScreen().x) - (36);	
						mouseY = (MouseInfo.getPointerInfo().getLocation().y) - (panelLevelOne.getLocationOnScreen().y) - (36);
						if (ItemWhip){
							lblDialogue.setText("Why would I do that?");
							ItemWhip = false;
						} else if (ItemIdol){
							lblDialogue.setText("That won't work.");
							ItemIdol = false;
						} else if (ItemGoldBar){
							lblDialogue.setText("There's no reason to do that.");
							ItemGoldBar = false;
						} else if (ItemRopeLadder){
							lblDialogue.setText("Yeah, right. It's mine now.");
							ItemRopeLadder = false;
						} else {
							lblDialogue.setText("Oops, must of gotten lost. Hey, a rope ladder! This may come in handy.");
						}//end of if else statement
					
						Toolkit toolkit = Toolkit.getDefaultToolkit();
						Image PointandClickCursor = toolkit.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor z = toolkit.createCustomCursor(PointandClickCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (z);
						panelInventory.setCursor (z);
						
						btnItemArray[3].setVisible(true);
						btnItemArray[3].setEnabled(true);
					}//end of if statement
					break;
				case MouseEvent.BUTTON3 :
						//right mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple4){
						Toolkit toolkit2 = Toolkit.getDefaultToolkit();
						Image PointandClickCursor2 = toolkit2.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor x = toolkit2.createCustomCursor(PointandClickCursor2 , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (x);
						panelInventory.setCursor (x);
						ItemIdol=false;
        				ItemWhip=false;
        				ItemGoldBar=false;
					}//end of if statement
					break;
				}//end of switch case
			}
		});
		lblMotionSkeleton.setBounds(120, 470, 120, 70);
		panelLevelOne.add(lblMotionSkeleton);
		//END KEY/MOUSE LISTENER SKELETON
		
		//START KEY/MOUSE LISTENER WATERFALL
		lblMotionWaterfall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
					//mouse hovers over
				if (lblLevelOneBackground.getIcon()==LevelOneTemple4){
					lblItem.setText(ObjectName[6]);
				}//end of if statement
			}
			@Override
			public void mouseExited(MouseEvent e) {
					//mouse hovers off
				if (lblLevelOneBackground.getIcon()==LevelOneTemple4){
					lblItem.setText("");
				}//end of if statement
			}
			@Override
			public void mousePressed (MouseEvent e) {
				switch(e.getButton()){
				case MouseEvent.BUTTON1 :
						//left mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple4){
						mouseX = (MouseInfo.getPointerInfo().getLocation().x) - (panelLevelOne.getLocationOnScreen().x) - (36);	
						mouseY = (MouseInfo.getPointerInfo().getLocation().y) - (panelLevelOne.getLocationOnScreen().y) - (36);
						if (lblIndy.getLocation().x >= 550){
							xIndy -= 5;
						}
						if (ItemWhip){
							lblDialogue.setText("Why would I do that?");
							ItemWhip = false;
						} else if (ItemIdol){
							lblDialogue.setText("That won't work.");
							ItemIdol = false;
						} else if (ItemGoldBar){
							lblDialogue.setText("There's no reason to do that.");
							ItemGoldBar = false;
						} else if (ItemRopeLadder){
							lblDialogue.setText("Nope.");
							ItemRopeLadder = false;
						} else {
							lblDialogue.setText("Pretty.");
						}//end of if else statement
					
						Toolkit toolkit = Toolkit.getDefaultToolkit();
						Image PointandClickCursor = toolkit.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor z = toolkit.createCustomCursor(PointandClickCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (z);
						panelInventory.setCursor (z);
					}//end of if statement
					break;
				case MouseEvent.BUTTON3 :
						//right mouse button
					if (lblLevelOneBackground.getIcon()==LevelOneTemple4){
						Toolkit toolkit2 = Toolkit.getDefaultToolkit();
						Image PointandClickCursor2 = toolkit2.getImage(getClass().getResource("/images/MainCursor.png"));
						Cursor x = toolkit2.createCustomCursor(PointandClickCursor2 , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
						panelLevelOne.setCursor (x);
						panelInventory.setCursor (x);
						ItemIdol=false;
        				ItemWhip=false;
        				ItemGoldBar=false;
					}//end of if statement
					break;
				}//end of switch case
			}
		});
		lblMotionWaterfall.setBounds(580, 300, 120, 240);
		panelLevelOne.add(lblMotionWaterfall);
		//END KEY/MOUSE LISTENER WATERFALL
		
		lblLevelOneBackground.setBounds(0, 0, 800, 600);
		panelLevelOne.add(lblLevelOneBackground);
		lblLevelOneBackground.setIcon(LevelOneBoulder);
		
		panelGameOver.setBackground(new Color(0, 0, 0));
		panelGameOver.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(panelGameOver);
		panelGameOver.setLayout(null);
		panelGameOver.setVisible(false);
		panelGameOver.setFocusable(false);
		
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setForeground(new Color(255, 255, 0));
		lblGameOver.setFont(new Font("SF Fedora Shadow", Font.BOLD, 40));
		lblGameOver.setBounds(235, 169, 317, 73);
		panelGameOver.add(lblGameOver);
		lblGameOver.setFocusable(false);
		
		lblPrompt.setFont(new Font("SF Fedora Titles", Font.BOLD, 14));
		lblPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrompt.setForeground(Color.WHITE);
		lblPrompt.setBounds(211, 457, 347, 94);
		panelGameOver.add(lblPrompt);

		lblLevelOneBackground.grabFocus();
		
		lblLevelOneBackground.setVisible(false);
		lblGameIntro.requestFocusInWindow();
		
	}//End of Method
	
		public void playButton() throws Exception {
			//sound effect for button clicks
			URL ButtonSound = new URL (fagarasanuIndianaJonesJavaAdventure.class.getResource("/images/"), "thunkSwitch.wav");
			Clip Sound = AudioSystem.getClip();
			AudioInputStream aisButton = AudioSystem.getAudioInputStream(ButtonSound);
			Sound.open(aisButton);
			Sound.loop(0);
			FloatControl gainSFXControl = (FloatControl) Sound.getControl(FloatControl.Type.MASTER_GAIN);
			gainSFXControl.setValue(gainSFX); // Reduce sfx volume by slider volume (in decibel's).
	}//End of Method
		
		public void playIntro() throws Exception {
				//music for intro
			URL IntroMusic = new URL (fagarasanuIndianaJonesJavaAdventure.class.getResource("/images/"), "IndyIntro.wav");
			Clip SoundIntro = AudioSystem.getClip();
			AudioInputStream aisIntro = AudioSystem.getAudioInputStream(IntroMusic);
			SoundIntro.open(aisIntro);
			SoundIntro.loop(0);
			FloatControl gainControlIntro = (FloatControl) SoundIntro.getControl(FloatControl.Type.MASTER_GAIN);
			gainControlIntro.setValue(gainMusic); // Reduce music volume by slider volume (in decibels).
				//
			
			lblGameIntro.setFocusable(true); //sets the proper focus for the enter key in order to skip intro
			lblGameIntro.requestFocusInWindow(); //sets the proper focus for the enter key in order to skip intro
			lblGameIntro.requestFocus(); //sets the proper focus for the enter key in order to skip intro
			lblLevelOneBackground.setFocusable(false); //ensure correct focus is set
			
			//START OF KEY LISTENER
			lblGameIntro.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e){
			
						switch (e.getKeyCode()){
							case KeyEvent.VK_ENTER : //Skips intro movie and starts the first level
							
							try {
								LevelOne();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
								panelIntro.setVisible(false);
								SoundIntro.close(); //music for intro movie
								Intro0.stop();
								Intro1.stop();
								Intro2.stop();
								Intro3.stop();
								Intro4.stop();
								Intro5.stop();
								Intro6.stop();
								Intro7.stop();
								IntroEnd.stop();
								break;
						}
					}
				});
				//END OF KEY LISTENER
			
				//START TIMER CODE 0
				ActionListener ITime0 = new ActionListener(){
					//The actions that will play out for the created timer

					@Override
					public void actionPerformed(ActionEvent arg0) {
						//Do Something just to show black panel
					}
		
				};
		
				Intro0 = new Timer(1000, (ITime0));
				//END TIMER CODE 0
				
				//START TIMER CODE 1
				ActionListener ITime1 = new ActionListener(){
					//The actions that will play out for the created timer

					@Override
					public void actionPerformed(ActionEvent arg0) {
						lblGameIntro.setIcon(Test1);
					}
			
				};
			
				Intro1 = new Timer(4000, (ITime1));
				//END TIMER CODE 1
				
				//START TIMER CODE 2
				ActionListener ITime2 = new ActionListener(){
					//The actions that will play out for the created timer

					@Override
					public void actionPerformed(ActionEvent arg0) {
						lblGameIntro.setIcon(Test2);
						Intro1.stop();
						IntroTxt.setVisible(false);
					}
			
				};
			
				Intro2 = new Timer(7000, (ITime2));
				//END TIMER CODE 2
				
				//START TIMER CODE 3
				ActionListener ITime3 = new ActionListener(){
					//The actions that will play out for the created timer

					@Override
					public void actionPerformed(ActionEvent arg0) {
						lblGameIntro.setIcon(Test3);
						Intro2.stop();
					}
			
				};
			
				Intro3 = new Timer(10000, (ITime3));
				//END TIMER CODE 3
				
				//START TIMER CODE 4
				ActionListener ITime4 = new ActionListener(){
					//The actions that will play out for the created timer

					@Override
					public void actionPerformed(ActionEvent arg0) {
						lblGameIntro.setIcon(Test4);
						Intro3.stop();
					}
			
				};
			
				Intro4 = new Timer(13000, (ITime4));
				//END OF TIMER CODE 4
				
				//START OF TIMER CODE 5
				ActionListener ITime5 = new ActionListener(){
					//The actions that will play out for the created timer

					@Override
					public void actionPerformed(ActionEvent arg0) {
						lblGameIntro.setIcon(Test4half);
						Intro4.stop();
					}
			
				};
			
				Intro5 = new Timer(16000, (ITime5));
				//END OF TIMER CODE 5
				
				//START OF TIMER CODE 6
				ActionListener ITime6 = new ActionListener(){
					//The actions that will play out for the created timer

					@Override
					public void actionPerformed(ActionEvent arg0) {
						lblGameIntro.setIcon(Test5);
						Intro5.stop();
					}
			
				};
			
				Intro6 = new Timer(19000, (ITime6));
				//END OF TIMER CODE 6
				
				//START OF TIMER CODE 7
				ActionListener ITime7 = new ActionListener(){
					//The actions that will play out for the created timer

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							playBoulder();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			
				};
			
				Intro7 = new Timer(17000, (ITime7));
				//END OF TIMER CODE 7
				
				//START OF TIMER CODE End
				ActionListener ITimeEnd = new ActionListener(){
					//The actions that will play out for the created timer

					@Override
					public void actionPerformed(ActionEvent arg0) {
						SoundIntro.stop();
						Intro7.stop();
						BoulderSound.close();
						panelIntro.setVisible(false);
						try {
							LevelOne();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			
				};
			
				IntroEnd = new Timer(24000, (ITimeEnd));
				//END OF TIMER CODE End
				
				Intro0.start();
				Intro1.start();
				Intro2.start();
				Intro3.start();
				Intro4.start();
				Intro5.start();
				Intro6.start();
				Intro7.start();
				IntroEnd.start();
	}//End of Method
		
		public void playBoulder() throws Exception {
			//music for when boulder is chasing Indiana but only duing intro
			AudioInputStream aisBoulder = AudioSystem.getAudioInputStream(Boulder);
			BoulderSound.open(aisBoulder);
			BoulderSound.loop(0);
			FloatControl gainBoulderControl = (FloatControl) BoulderSound.getControl(FloatControl.Type.MASTER_GAIN);
			gainBoulderControl.setValue(gainMusic); // Reduce music volume by slider volume (in decibel's).

	}//End of Method
		
		public void WhipSFX() throws Exception {
			//Sound effect for when Indiana uses whip to get accross chasm
			URL WhipSFX = new URL (fagarasanuIndianaJonesJavaAdventure.class.getResource("/images/"), "WhipSFX.wav");
			Clip WhipSFXSound = AudioSystem.getClip();
			AudioInputStream aisWhipSFX = AudioSystem.getAudioInputStream(WhipSFX);
			WhipSFXSound.open(aisWhipSFX);
			WhipSFXSound.loop(0);
			FloatControl gainWhipSFXControl = (FloatControl) WhipSFXSound.getControl(FloatControl.Type.MASTER_GAIN);
			gainWhipSFXControl.setValue(gainSFX); // Reduce SFX volume by slider volume (in decibel's).
			
	}//End of Method 
		
		public void playMenuClick() throws Exception {
			//Sound effect for when the escape key pressed for the in game menu
			URL MenuClick = new URL (fagarasanuIndianaJonesJavaAdventure.class.getResource("/images/"), "MenuClick.wav");
			Clip MenuClickSound = AudioSystem.getClip();
			AudioInputStream aisMenuClick = AudioSystem.getAudioInputStream(MenuClick);
			MenuClickSound.open(aisMenuClick);
			MenuClickSound.loop(0);
			FloatControl gainMenuClickControl = (FloatControl) MenuClickSound.getControl(FloatControl.Type.MASTER_GAIN);
			gainMenuClickControl.setValue(gainSFX); // Reduce SFX volume by slider volume (in decibel's).

	}//End of Method
		public void playTheme() throws Exception {
			//Music for when the end screen appears, and the game ends (main Indiana Jones theme song)
			URL BackgroundMusic = new URL (fagarasanuIndianaJonesJavaAdventure.class.getResource("/images/"), "IndyTheme.wav");
			Clip Sound = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(BackgroundMusic);
			Sound.open(ais);
			Sound.loop(Clip.LOOP_CONTINUOUSLY);
			FloatControl gainControl = (FloatControl) Sound.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(gainMusic); // Reduce music volume by slider volume (in decibels).
			
			//START OF TIMER CODE GAME STOP
			ActionListener GameStop = new ActionListener(){
				//The actions that will play out for the created timer

				@Override
				public void actionPerformed(ActionEvent arg0) {
					//exist the game after printing a nice message to console
					System.out.println("Thank you very much for playing\nIndiana Jones and the Java Adventure.\n\nBest Regards,\nAdrian Fagarasanu\n\nJune 17, 2016");
					System.exit(0);
				}
	
			};
	
			timerGameStop = new Timer(10000, (GameStop));
			timerGameStop.start();
			//END OF TIMER CODE GAME STOP
			
	}//End of Method
		
		public void playBoulderMusic() throws Exception {
			//music for level one when boulder is chasing Indiana
			URL LevelOneMusicBoulder = new URL (fagarasanuIndianaJonesJavaAdventure.class.getResource("/images/"), "IndyBoulderGame.wav");
			Clip LevelOneBoulderSoundMethod = AudioSystem.getClip();
			AudioInputStream aisLevelOneBoulder = AudioSystem.getAudioInputStream(LevelOneMusicBoulder);
			LevelOneBoulderSoundMethod.open(aisLevelOneBoulder);
			LevelOneBoulderSoundMethod.loop(0);
			FloatControl gainLevelOneBoulderControl = (FloatControl) LevelOneBoulderSoundMethod.getControl(FloatControl.Type.MASTER_GAIN);
			gainLevelOneBoulderControl.setValue(gainMusic); // Reduce SFX volume by slider volume (in decibel's).
			
			//START OF TIMER CODE MUSICPLAYTEST
			ActionListener MusicPlayingTest = new ActionListener(){
				//The actions that will play out for the created timer

				@Override
				public void actionPerformed(ActionEvent arg0) {
					//if boolean is equal to true, music stops
					if (MusicPlayingBoulder){
						LevelOneBoulderSoundMethod.close();
					}//End of If Statement
				}
			};
	
			Timer timerMusicPlaying = new Timer(100, (MusicPlayingTest));
			timerMusicPlaying.start();
			//END OF TIMER CODE MUSICPLAYTEST
			
		}//End of Method
		
		public void MusicLevelOne() throws Exception {
				//Main ambient music for all of level one (after boulder music)
			URL LevelOneMusic = new URL (fagarasanuIndianaJonesJavaAdventure.class.getResource("/images/"), "IndyAmbient.wav");
			Clip LevelOneMusicSound = AudioSystem.getClip();
			AudioInputStream aisLevelOneMusic = AudioSystem.getAudioInputStream(LevelOneMusic);
			LevelOneMusicSound.open(aisLevelOneMusic);
			LevelOneMusicSound.loop(Clip.LOOP_CONTINUOUSLY);
			FloatControl gainLevelOneMusicControl = (FloatControl) LevelOneMusicSound.getControl(FloatControl.Type.MASTER_GAIN);
			gainLevelOneMusicControl.setValue(gainMusic); // Reduce Muic volume by slider volume (in decibel's).
			
			//START OF TIMER CODE MUSICPLAYTEST
			ActionListener MusicPlayingTest = new ActionListener(){
				//The actions that will play out for the created timer

				@Override
				public void actionPerformed(ActionEvent arg0) {
					//if boolean is equal to true, music stops
					if (MusicPlayingLevelOne){
						LevelOneMusicSound.close();
					}
				}
	
			};
	
			Timer timerMusicPlaying = new Timer(100, (MusicPlayingTest));
			timerMusicPlaying.start();
			//END OF TIMER CODER MUSICPLAYTEST

		}//End of Method
		
		public void LevelOne() throws Exception {
			
			IntroEnd.stop();//Music at the end of intro method stops
			
				//Music for level one boulder scene (plays only if character has not been hit by boulder, afterwards, this music is replaced by music in method)
			URL LevelOneMusicBoulder = new URL (fagarasanuIndianaJonesJavaAdventure.class.getResource("/images/"), "IndyBoulderGame.wav");
			Clip LevelOneBoulderSound = AudioSystem.getClip();
			AudioInputStream aisLevelOneBoulder = AudioSystem.getAudioInputStream(LevelOneMusicBoulder);
			LevelOneBoulderSound.open(aisLevelOneBoulder);
			LevelOneBoulderSound.loop(0);
			FloatControl gainLevelOneBoulderControl = (FloatControl) LevelOneBoulderSound.getControl(FloatControl.Type.MASTER_GAIN);
			gainLevelOneBoulderControl.setValue(gainMusic); // Reduce SFX volume by slider volume (in decibel's).
				//
			
				//sets all proper focuses
			panelLevelOne.setVisible(true);	
			panelGameOver.setFocusable(false);
			lblGameOver.setFocusable(false);
			lblPrompt.setFocusable(false);
			lblLevelOneBackground.setVisible(true);
			lblLevelOneBackground.setFocusable(true);
			lblLevelOneBackground.requestFocusInWindow();
			lblLevelOneBackground.grabFocus();
				//
				
				//sets default cursor image
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image PointandClickCursor = toolkit.getImage(getClass().getResource("/images/MainCursor.png"));
			Cursor c = toolkit.createCustomCursor(PointandClickCursor , new Point(panelLevelOne.getX(), panelLevelOne.getY()), "img");
			panelLevelOne.setCursor (c);
			panelInventory.setCursor (c);
				//
			
			xIndy = lblIndy.getX();//x coordinate moves with character
			yIndy = lblIndy.getY();//y coordinate moves with character
			
			lblIndy.setVisible(true);//character appears
			
			//START OF TIMER CODE INDY MOVE
			ActionListener moveIndy = new ActionListener(){
				//Action performed when timer is started

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(lblIndy.getLocation().x > mouseX && mouseY >= 400){
						xIndy -= 5; //moves character
					}//end of if statement
					if(lblIndy.getLocation().x < mouseX && mouseY >= 400){
						xIndy += 5; //moves character
					}//end of if statement
					
					lblIndy.setLocation(xIndy, yIndy); //Update lblImage location


					if (lblIndy.getLocation().x <= (mouseX + 2 ) && lblIndy.getLocation().x >= (mouseX - 2 )){
					//stops character where mouse was clicked
						timerIndyMove.stop();
					}//end of if statement
					
					if (lblLevelOneBackground.getIcon()==LevelOneBoulder && lblIndy.getLocation().x < -20){
						//changes to next area of level one
						timerIndyMove.stop();
						lblLevelOneBackground.setIcon(LevelOneTemple);
						lblLevelOneDoorways.setVisible(true);
						timerBoulderMove.stop();
						timerBoulderMoveRoll.stop();
						lblBoulder.setVisible(false);
						LevelOneBoulderSound.close();
						try {
							MusicLevelOne();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						MusicPlayingBoulder = true;
						lblIndy.setLocation(690, 420);
						xIndy = 690;
						yIndy = 420;
						lblIndy.setLocation(xIndy, yIndy);
						timerIndyWalk.stop();
						lblIndy.setIcon(IndyStandingLeft);
						lblDialogue.setText("I can't believe that happened to me for a second time.");
					}//end of if statement
					if (lblLevelOneBackground.getIcon()==LevelOneTemple && lblIndy.getLocation().x<=500 && lblIndy.getLocation().x>=260){
						//stops character from moving past chasm
						timerIndyMove.stop();
						timerIndyWalk.stop();
						lblIndy.setIcon(IndyStandingLeft);
					}//end of if statement
					if (lblLevelOneBackground.getIcon()==LevelOneTemple && lblIndy.getLocation().x < -20){
						//changes to next area of level one
						timerIndyMove.stop();
						lblLevelOneBackground.setIcon(LevelOneTemple2Gold);
						lblIndy.setLocation(130, 390);
						xIndy = 130;
						yIndy = 390;
						lblIndy.setLocation(xIndy, yIndy);
						timerIndyWalk.stop();
						lblIndy.setIcon(IndyStandingLeft);
					}//end of if statement
					if ((lblLevelOneBackground.getIcon()==LevelOneTemple2 || lblLevelOneBackground.getIcon()==LevelOneTemple2Gold)){
						//changes to next area of level one
						if (lblIndy.getLocation().x > 720){
							timerIndyMove.stop();
							lblLevelOneBackground.setIcon(LevelOneTemple3);
							xIndy = 0;
							yIndy = 420;
							lblIndy.setLocation(xIndy, yIndy);
							timerIndyWalk.stop();
							lblIndy.setIcon(IndyStandingLeft);
							lblDialogue.setText("");
						}//end of if statement
						if (lblIndy.getLocation().x < -20){
							//changes back to previous area of level one
							timerIndyMove.stop();
							timerIndyWalk.stop();
							lblLevelOneBackground.setIcon(LevelOneTemple);
							xIndy=0;
							yIndy=420;
							lblIndy.setLocation(xIndy, yIndy);
							lblIndy.setIcon(IndyStandingLeft);
							lblDialogue.setText("");
						}//end of if statement
					}//end of if statement
					
					if (lblLevelOneBackground.getIcon()==LevelOneTemple2Gold && lblIndy.getLocation().x > 400 && lblMotionGoldBar.hasFocus()){
						//Stops character in order to pick up item gold bar, and changes background to image without gold bar
						timerIndyMove.stop();
						timerIndyWalk.stop();
						lblIndy.setIcon(IndyStandingLeft);
						lblLevelOneBackground.setIcon(LevelOneTemple2);
						lblItem.setText("");
						lblDialogue.setText("Interesting carvings. This belongs in a museum.");
						lblLevelOneBackground.grabFocus();
						btnItemArray[2].setVisible(true);
						btnItemArray[2].setEnabled(true);
					}//end of if statement
					if (lblLevelOneBackground.getIcon()==LevelOneTemple3){
						if (lblIndy.getLocation().x >= 550){
							//stops character from moving past rock ledge
							timerIndyMove.stop();
							timerIndyWalk.stop();
							lblIndy.setIcon(IndyStandingLeft);
							if (mouseX >= 680){
								//changes to next area of level one
								lblLevelOneDoorways.setVisible(false);
								lblLevelOneBackground.setIcon(LevelOneTemple4);
								lblLevelOnePillars.setVisible(true);
								lblDialogue.setText("");
								xIndy = 0;
								yIndy = 420;
								lblIndy.setLocation(xIndy, yIndy);
							}//end of if statement
						}//end of if statement
						if (lblIndy.getLocation().x < -20){
							//changes back to previous area of level one
							timerIndyMove.stop();
							timerIndyWalk.stop();
							lblIndy.setIcon(IndyStandingLeft);
							lblDialogue.setText("");
							xIndy = 690;
							yIndy = 390;
							lblIndy.setLocation(xIndy, yIndy);
								//what background area appears depends on wether or not character picked up item
							if (btnItemArray[2].isVisible()){
								lblLevelOneBackground.setIcon(LevelOneTemple2);
							} else if (btnItemArray[2].isVisible()==false){
								lblLevelOneBackground.setIcon(LevelOneTemple2Gold);
							}//end of if else statement
								//
						}//end of if statement
					}//end of if statement
					if (lblLevelOneBackground.getIcon()==LevelOneTemple4){
						if (lblIndy.getLocation().x < -20){
							//changes back to previous area of level one
							timerIndyMove.stop();
							timerIndyWalk.stop();
							lblIndy.setIcon(IndyStandingLeft);
							lblDialogue.setText("");
							lblLevelOneBackground.setIcon(LevelOneTemple3);
							lblLevelOnePillars.setVisible(false);
							xIndy = 550;
							yIndy = 420;
							lblIndy.setLocation(xIndy, yIndy);
						}//end of if statement
						if (lblIndy.getLocation().x >= 550){
							//prevents character from moving past waterfall
							timerIndyMove.stop();
							timerIndyWalk.stop();
							lblIndy.setIcon(IndyStandingLeft);
						}//end of if statement
					}//end of if statement
				}
			};
			
			 timerIndyMove = new Timer(50, moveIndy);
			 //END OF TIMER CODE INDY MOVE
			 
			//START INDY ANIMATION TIMER CODE
				ActionListener IndyWalk = new ActionListener(){
					//Action performed when timer is started

					@Override
					public void actionPerformed(ActionEvent arg0) {
							//based upon whether mouse is clicked in front of the character or behind, left or right animation plays
						if (lblIndy.getLocation().x > mouseX && mouseY >= 400){
								//left walking animation
							if (lblIndy.getIcon() == IndyStandingLeft){
								lblIndy.setIcon(IndyWalkingOneLeft);
							} else if (lblIndy.getIcon()==IndyWalkingOneLeft || lblIndy.getIcon()==IndyWalkingOneRight){
								lblIndy.setIcon(IndyWalkingTwoLeft);
							} else if (lblIndy.getIcon()==IndyWalkingTwoLeft || lblIndy.getIcon()==IndyWalkingTwoRight){
								lblIndy.setIcon(IndyWalkingThreeLeft);
							} else if (lblIndy.getIcon()==IndyWalkingThreeLeft || lblIndy.getIcon()==IndyWalkingThreeRight){
								lblIndy.setIcon(IndyWalkingFourLeft);
							} else if (lblIndy.getIcon()==IndyWalkingFourLeft || lblIndy.getIcon()==IndyWalkingFourRight){
								lblIndy.setIcon(IndyWalkingFiveLeft);
							} else if (lblIndy.getIcon()==IndyWalkingFiveLeft || lblIndy.getIcon()==IndyWalkingFiveRight){
								lblIndy.setIcon(IndyWalkingSixLeft);
							} else if (lblIndy.getIcon()==IndyWalkingSixLeft || lblIndy.getIcon()==IndyWalkingSixRight){
								lblIndy.setIcon(IndyWalkingSevenLeft);
							} else if (lblIndy.getIcon()==IndyWalkingSevenLeft || lblIndy.getIcon()==IndyWalkingSevenRight){
								lblIndy.setIcon(IndyWalkingOneLeft);
							}//end of if else statement
						}//end of if statement
						
						if (lblIndy.getLocation().x < mouseX && mouseY >= 400){
								//right walking animation
							if (lblIndy.getIcon() == IndyStandingLeft){
								lblIndy.setIcon(IndyWalkingOneRight);
							} else if (lblIndy.getIcon()==IndyWalkingOneRight || lblIndy.getIcon()==IndyWalkingOneLeft){
								lblIndy.setIcon(IndyWalkingTwoRight);
							} else if (lblIndy.getIcon()==IndyWalkingTwoRight || lblIndy.getIcon()==IndyWalkingTwoLeft){
								lblIndy.setIcon(IndyWalkingThreeRight);
							} else if (lblIndy.getIcon()==IndyWalkingThreeRight || lblIndy.getIcon()==IndyWalkingThreeLeft){
								lblIndy.setIcon(IndyWalkingFourRight);
							} else if (lblIndy.getIcon()==IndyWalkingFourRight || lblIndy.getIcon()==IndyWalkingFourLeft){
								lblIndy.setIcon(IndyWalkingFiveRight);
							} else if (lblIndy.getIcon()==IndyWalkingFiveRight || lblIndy.getIcon()==IndyWalkingFiveLeft){
								lblIndy.setIcon(IndyWalkingSixRight);
							} else if (lblIndy.getIcon()==IndyWalkingSixRight || lblIndy.getIcon()==IndyWalkingSixLeft){
								lblIndy.setIcon(IndyWalkingSevenRight);
							} else if (lblIndy.getIcon()==IndyWalkingSevenRight || lblIndy.getIcon()==IndyWalkingSevenLeft){
								lblIndy.setIcon(IndyWalkingOneRight);
							}
						}
						
						if (mouseY < 400){
							//prevents character from being moved (or animated) unless mouse is clicked on the ground section of background
							lblIndy.setIcon(IndyStandingLeft);
						}
						
						if (lblIndy.getLocation().x <= (mouseX + 2 ) && lblIndy.getLocation().x >= (mouseX - 2 )){
							//stops animation if character reaches where mouse was clicked
							timerIndyWalk.stop();
							running = true;
						}
						
						if (running){
							//sets the default non-movement image of the character as idle, instead of setting it as whatever image it was when clicked
							lblIndy.setIcon(IndyStandingLeft);
							running = false;
						}
					}
				};
				
				timerIndyWalk = new Timer(100, IndyWalk);//Timer delay dictates how fast Indy walks (animates)
				//END INDY ANIMATION TIMER CODE
			
				//START MOUSE LISTENER
			panelLevelOne.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
			        
					switch(e.getButton()) {
		            	case MouseEvent.BUTTON1 :
		            			//left mouse button
		            		mouseX = (MouseInfo.getPointerInfo().getLocation().x) - (panelLevelOne.getLocationOnScreen().x) - (36);	//gets the x coordinate based on when clicked
		            		mouseY = (MouseInfo.getPointerInfo().getLocation().y) - (panelLevelOne.getLocationOnScreen().y) - (36); //gets the y coordinate based on when clicked
		            		if (!(WhipAnimation)){
		            				//only move character if whip animation isn't playing
		            			timerIndyMove.start();
		            			timerIndyWalk.start();
		            		}//end of if statement
			    			if (lblLevelOneBackground.getIcon()==LevelOneTemple){
			    					//prevents character from sliding across chasm
			    				if (lblIndy.getLocation().x>=500){
			    					xIndy += 5;
			    				}//end of if statement
			    				if (lblIndy.getLocation().x<=260){
			    					xIndy -= 5;
			    				}//end of if statement
			    					//
			    			}//end of if statement
			    			if (lblLevelOneBackground.getIcon()==LevelOneTemple3){
			    					//prevents character from sliding across area
			    				if (lblIndy.getLocation().x >= 550){
			    					xIndy -= 5;
			    				}//end of if statement
			    			}//end of if statement
			    			if (lblLevelOneBackground.getIcon()==LevelOneTemple4){
			    					//prevents character from sliding across area
			    				if (lblIndy.getLocation().x >= 550){
			    					xIndy -= 5;
			    				}//end of if statement
			    			}//end of if statement 
			    			
			    				//ensures proper focus
			    			panelGameOver.setFocusable(false);
			    			lblLevelOneBackground.setFocusable(true);
			    			lblLevelOneBackground.requestFocusInWindow();
			    			lblLevelOneBackground.grabFocus();
			    				//
		            		break;
		            	case MouseEvent.BUTTON3 :
		            			//right mouse button
		        			panelLevelOne.setCursor (c); //set default cursor image
		        			panelInventory.setCursor (c); //set default cursor image
		        			ItemIdol=false;
		        			ItemWhip=false;
		        			ItemGoldBar=false;
		        			break;
			        }
				}
			});
			//END MOUSE LISTENER
			
				//ensures proper focus
			lblLevelOneBackground.setFocusable(true);
			lblLevelOneBackground.requestFocusInWindow();
			lblGameIntro.setFocusable(false);
			lblGameOver.setFocusable(false);
			lblLevelOneBackground.grabFocus();
				//
			
			//START OF KEY LISTENER
			lblLevelOneBackground.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e){
			
						switch (e.getKeyCode()){
							case KeyEvent.VK_I :
									//inventory screen
								if (panelInventory.isVisible()==false){
									panelInventory.setVisible(true);
								}else if (panelInventory.isVisible()){
									panelInventory.setVisible(false);
								}//end of if else statement
								break;
							case KeyEvent.VK_ESCAPE :
									//in game menu
								if (lblInGameMenu.isVisible()==false){
									//if background of menu cannot be seen, then menu appears with all buttons, etc.
									lblInGameMenu.setVisible(true);
									timerBoulderMove.stop();
									timerBoulderMoveRoll.stop();
									timerIndyMove.stop();
									timerIndyWalk.stop();
									lblIndy.setIcon(IndyStandingLeft);
									InGameMenu = true;
									btnResume.setVisible(true);
									btnResume.setEnabled(true);
									btnControlsInGame.setVisible(true);
									btnControlsInGame.setEnabled(true);
									btnQuitInGame.setVisible(true);
									btnQuitInGame.setEnabled(true);
									panelLevelOne.setCursor(Cursor.getDefaultCursor());
								}else if (lblInGameMenu.isVisible()){
									//if the menu is already appeared then, it closes (everything goes back to game)
									btnResume.setVisible(false);
									btnResume.setEnabled(false);
									btnControlsInGame.setVisible(false);
									btnControlsInGame.setEnabled(false);
									btnQuitInGame.setVisible(false);
									btnQuitInGame.setEnabled(false);
									btnBackInGame.setVisible(false);
									btnBackInGame.setEnabled(false);
									lblControlsScreenInGame.setVisible(false);
									panelLevelOne.setCursor (c);
									lblInGameMenu.setVisible(false);
									if (lblLevelOneBackground.getIcon()==LevelOneBoulder){
										timerBoulderMove.start();
										timerBoulderMoveRoll.start();
									}//end of if statement
									InGameMenu = false;
								}//end of if else statement
							try {
								playMenuClick();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
								break;
						}//end of switch case
					}
				});
				//END OF KEY LISTENER
			
				//START OF KEY LISTENER
			panelGameOver.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e){	
					switch(e.getKeyCode()){
					
						case KeyEvent.VK_ENTER :
								//resets the level when boulder hits character, and game is over
							if (panelGameOver.isVisible()){
								panelGameOver.setVisible(false);
								panelLevelOne.setVisible(true);
								lblBoulder.setLocation(700, 335);
								//resets character and boulder to desired location 
								x=700;
								y=335;
								lblIndy.setLocation(504, 420);
								xIndy=504;
								yIndy=420;
								//
								lblIndy.setIcon(IndyStandingLeft);
								lblBoulder.setIcon(BoulderRock);
								timerBoulderMove.start();
								timerBoulderMoveRoll.start();
								MusicPlayingBoulder = false;
								lblLevelOneBackground.grabFocus();
								try {
									playButton();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								try {
									playBoulderMusic();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}//end of if statement
						break;
					}//end of switch case
				}
			});
			//END OF KEY LISTENER
			
			x = lblBoulder.getX(); //follows the x coordinate of the moving boulder
			y = lblBoulder.getY(); //follows the x coordinate of the moving boulder
			
			//START TIMER CODE MOVE BOULDER
			ActionListener moveBoulder = new ActionListener(){
				//Action performed when timer is started

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					lblBoulder.setLocation(x, y); //Update lblImage location
					x-=4;//moves the boulder

				}
			};
			
			timerBoulderMove = new Timer(40, moveBoulder);
			timerBoulderMove.start();
			//END TIMER CODE MOVE BOUDLER
			
			
			Rectangle IndyRect = new Rectangle(xIndy, yIndy, 100, 200);//Rectangle Surrounding character
		    Rectangle RectBoulder = new Rectangle(x, y, 250, 250);//Rectangle Surrounding Boulder
			
				//START BOULDER ROLL TIMER CODE
				ActionListener moveBoulderRoll = new ActionListener(){
					//Action performed when timer is started

					@Override
					public void actionPerformed(ActionEvent arg0) {
							//many images used to attempt better animation (each image was rotated only 10 degrees)
						if (lblBoulder.getIcon() == BoulderRock){
							lblBoulder.setIcon(BoulderRock1);
						} else if (lblBoulder.getIcon()==BoulderRock1){
							lblBoulder.setIcon(BoulderRock2);
						} else if (lblBoulder.getIcon()==BoulderRock2){
							lblBoulder.setIcon(BoulderRock3);
						} else if (lblBoulder.getIcon()==BoulderRock3){
							lblBoulder.setIcon(BoulderRock4);
						} else if (lblBoulder.getIcon()==BoulderRock4){
							lblBoulder.setIcon(BoulderRock5);
						} else if (lblBoulder.getIcon()==BoulderRock5){
							lblBoulder.setIcon(BoulderRock6);
						} else if (lblBoulder.getIcon()==BoulderRock6){
							lblBoulder.setIcon(BoulderRock7);
						} else if (lblBoulder.getIcon()==BoulderRock7){
							lblBoulder.setIcon(BoulderRock8);
						} else if (lblBoulder.getIcon()==BoulderRock8){
							lblBoulder.setIcon(BoulderRock9);
						} else if (lblBoulder.getIcon()==BoulderRock9){
							lblBoulder.setIcon(BoulderRock10);
						} else if (lblBoulder.getIcon()==BoulderRock10){
							lblBoulder.setIcon(BoulderRock11);
						} else if (lblBoulder.getIcon()==BoulderRock11){
							lblBoulder.setIcon(BoulderRock12);
						} else if (lblBoulder.getIcon()==BoulderRock12){
							lblBoulder.setIcon(BoulderRock13);
						} else if (lblBoulder.getIcon()==BoulderRock13){
							lblBoulder.setIcon(BoulderRock14);
						} else if (lblBoulder.getIcon()==BoulderRock14){
							lblBoulder.setIcon(BoulderRock15);
						} else if (lblBoulder.getIcon()==BoulderRock15){
							lblBoulder.setIcon(BoulderRock16);
						} else if (lblBoulder.getIcon()==BoulderRock16){
							lblBoulder.setIcon(BoulderRock17);
						} else if (lblBoulder.getIcon()==BoulderRock17){
							lblBoulder.setIcon(BoulderRock18);
						} else if (lblBoulder.getIcon()==BoulderRock18){
							lblBoulder.setIcon(BoulderRock19);
						} else if (lblBoulder.getIcon()==BoulderRock19){
							lblBoulder.setIcon(BoulderRock20);
						} else if (lblBoulder.getIcon()==BoulderRock20){
							lblBoulder.setIcon(BoulderRock21);
						} else if (lblBoulder.getIcon()==BoulderRock21){
							lblBoulder.setIcon(BoulderRock22);
						} else if (lblBoulder.getIcon()==BoulderRock22){
							lblBoulder.setIcon(BoulderRock23);
						} else if (lblBoulder.getIcon()==BoulderRock23){
							lblBoulder.setIcon(BoulderRock24);
						} else if (lblBoulder.getIcon()==BoulderRock24){
							lblBoulder.setIcon(BoulderRock25);
						} else if (lblBoulder.getIcon()==BoulderRock25){
							lblBoulder.setIcon(BoulderRock26);
						} else if (lblBoulder.getIcon()==BoulderRock26){
							lblBoulder.setIcon(BoulderRock27);
						} else if (lblBoulder.getIcon()==BoulderRock27){
							lblBoulder.setIcon(BoulderRock28);
						} else if (lblBoulder.getIcon()==BoulderRock28){
							lblBoulder.setIcon(BoulderRock29);
						} else if (lblBoulder.getIcon()==BoulderRock29){
							lblBoulder.setIcon(BoulderRock30);
						} else if (lblBoulder.getIcon()==BoulderRock30){
							lblBoulder.setIcon(BoulderRock31);
						} else if (lblBoulder.getIcon()==BoulderRock31){
							lblBoulder.setIcon(BoulderRock32);
						} else if (lblBoulder.getIcon()==BoulderRock32){
							lblBoulder.setIcon(BoulderRock33);
						} else if (lblBoulder.getIcon()==BoulderRock33){
							lblBoulder.setIcon(BoulderRock34);
						}  else if (lblBoulder.getIcon()==BoulderRock34){
							lblBoulder.setIcon(BoulderRock35);
						} else if (lblBoulder.getIcon()==BoulderRock35){
							lblBoulder.setIcon(BoulderRock);
						}//end of if else statement
						
						IndyRect.setLocation(xIndy - 30, yIndy); //sets the location of intersection rectangle following character
						RectBoulder.setLocation(x + 30, y); //sets the location of intersection rectangle following boulder
						
					    if (IndyRect.intersects(RectBoulder)){
					    		//game over screen appears if character rectangle intersects boulder rectangle
					    	panelLevelOne.setVisible(false);
					    	panelGameOver.setVisible(true);
					    	LevelOneBoulderSound.close();
							timerBoulderMoveRoll.stop();
							timerBoulderMove.stop();
							timerIndyMove.stop();
							timerIndyWalk.stop();
							MusicPlayingBoulder = true;
							panelGameOver.setFocusable(true);
							panelGameOver.requestFocusInWindow();
							panelGameOver.grabFocus();
					    }//end of if statement
					}
				};
				
				timerBoulderMoveRoll = new Timer(100, moveBoulderRoll);//Timer delay dictates how fast boulder rolls
				timerBoulderMoveRoll.start();	
				//END BOULDER ROLL1 TIMER CODE
				
	}//End of Method
}//End of fagarasanuIndianaJonesJavaAdventure
