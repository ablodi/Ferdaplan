package is.vidmot.view;

import java.io.IOException;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FerdSpjald extends AnchorPane {

	@FXML
	private TextField fxHeiti;
	
	@FXML
	private TextField fxAfangastadur;
	
	@FXML
	private TextField fxDagsetning;
	
	
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
