package is.vidmot.view;

import java.io.IOException;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * Sérsniðinn JavaFX-viðmótshluti fyrir gögn einnar ferðar.
 * Inniheldur textasvið fyrir heiti, áfangastað og dagsetningu.
 *
 * @author Kristinn Óskarsson
 */
public class FerdSpjald extends AnchorPane {

	@FXML
	private TextField fxHeiti;
	
	@FXML
	private TextField fxAfangastadur;
	
	@FXML
	private TextField fxDagsetning;
	
	/**
     * Býr til nýtt ferðaspjald og hleður inn tilheyrandi FXML-skrá.
     */
	public FerdSpjald() {
		FXMLLoader fxmlLoader = new FXMLLoader(FerdSpjald.class.getResource("/is/vidmot/view/ferdSpjald-view.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public StringProperty heitiProperty() {
		return fxHeiti.textProperty();
	}
	public StringProperty afangastadurProperty() {
		return fxAfangastadur.textProperty();
	}
	public StringProperty dagsetningProperty() {
		return fxDagsetning.textProperty();
	}
}
