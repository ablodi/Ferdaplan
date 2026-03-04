package is.vidmot.view;

import java.io.IOException;

import is.vinnsla.Ferd;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FerdSpjald extends AnchorPane {
	
	private Ferd ferd;
	private final SimpleStringProperty heiti = new SimpleStringProperty();
	private final SimpleStringProperty afangastadur = new SimpleStringProperty();
	private final SimpleStringProperty dagsetning = new SimpleStringProperty();
	
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
	@FXML
	public void initialize() {
		fxHeiti.textProperty().bind(heiti);
		fxAfangastadur.textProperty().bind(afangastadur);
		fxDagsetning.textProperty().bind(dagsetning);
	}
	
	public void setFerd(Ferd ferd) {
		heiti.set(ferd.getHeiti());
		afangastadur.set(ferd.getAfangastadur());
		dagsetning.set(ferd.getDagsetning());
	}
	
	public SimpleStringProperty heitiProperty() {
		return heiti;
	}
	public SimpleStringProperty afangastadurProperty() {
		return afangastadur;
	}
	public SimpleStringProperty dagsetningProperty() {
		return dagsetning;
	}
}
