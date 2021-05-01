import java.io.File;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.zip.DataFormatException;
import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage; 
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;

public class ImportGardenScreen extends Screen {
	
	public void updatePage(){}
	
	Button fileOpenerButton;
	
	/**
	 * Constructor for ImportGardenScreen. Used to create the scene for import garden screen
	 * 
	 * @param v takes in the instance of View accessed in Screen
	 * @author Kush Patel
	 */
	public ImportGardenScreen(View v) {
		super(v, PagesEnum.ImportScreen);
		fileOpenerButton = new Button("Open File");
		
   		layout = new StackPane();
    	layout.setStyle(theme);
    	layout.getChildren().addAll(fileOpenerButton);	
    	scene = new Scene(layout, canvasWidth, canvasHeight);
    	fileOpenerButton.setOnAction(e -> view.switchPage(PagesEnum.IntroScreen));
	}
}