import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class settingsScreen extends Screen {
	
	public void updatePage(){}
	
	BorderPane borderPane;
	StackPane hstackPane;	
	StackPane vstackPane;
	
	VBox vbox;
	HBox hbox;
	
	Button exitButton;
	Button dchangeThemebutton;
    Button lchangeThemebutton;
    Button returnToMenuButton;
	
	/**
	 * Constructor for settingsScreen. Used to create the scene for settings screen
	 * 
	 * @param v takes in the instance of View accessed in Screen
	 * @author Kush Patel
	 */
    public settingsScreen(View v) {
        super(v, PagesEnum.SettingsScreen);	
    	
		borderPane = new BorderPane();	
    	hstackPane = new StackPane();	
    	vstackPane = new StackPane();	

    	borderPane.setTop(hstackPane);
    	borderPane.setCenter(vstackPane);
    	
    	vbox = new VBox(10);
    	hbox = new HBox();
        
        exitButton();
        changeTheme();
        returnToMenuButton();
        
		hbox.setAlignment(Pos.TOP_RIGHT);
		hbox.setPadding(new Insets(10, 10, 0, 0));
		hbox.getChildren().addAll(exitButton);
		
		vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(dchangeThemebutton, lchangeThemebutton, returnToMenuButton);
        
		hstackPane.getChildren().addAll(hbox);
		vstackPane.getChildren().addAll(vbox);
		
		borderPane.setMaxHeight(canvasHeight);
		borderPane.setMaxWidth(canvasHeight);
		borderPane.setStyle(theme);
		
        layout = borderPane;
        scene = new Scene(layout, canvasWidth, canvasHeight);
    }
    
	/**
	 * Assigns the exitButton a value and assigns the screen to swap to upon button press
	 * @author Kush Patel
	 */
    public void exitButton() {
    	exitButton = new Button("Exit");
        exitButton.setOnAction(e -> view.switchPage(view.previouspage));
    }
    
	/**
	 * Assigns values to the dark and light mode button as well as changing the theme
	 * on the appropriate button press
	 * @author Kush Patel
	 */
    public void changeTheme() {
        dchangeThemebutton = new Button("Dark");
        lchangeThemebutton = new Button("Light");
        dchangeThemebutton.setOnAction(e -> applyTheme("dark"));
        lchangeThemebutton.setOnAction(e -> applyTheme("light"));
    }
    
	/**
	 * Assigns the returnToMenuButton a value and assigns the screen to swap to upon button press
	 * @param s changes the theme of every screen in the program by access the HashMap of every screen and setting
	 * their layout theme to the new theme
	 * @author Kush Patel
	 */
    public void applyTheme(String s) {
    	view.nameToScreenMap.forEach((name, screen) -> {
    		screen.changeTheme(s);
    	});
    }
    
	/**
	 * Assigns the returnToMenuButton a value and assigns the screen to swap to upon button press
	 * @author Kush Patel
	 */
    public void returnToMenuButton() {
    	returnToMenuButton = new Button("Return To Menu");
    	returnToMenuButton.setOnAction(e -> view.switchPage(PagesEnum.IntroScreen));
    } 
}