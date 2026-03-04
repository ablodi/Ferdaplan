package is.vidmot.controller;

import java.util.Optional;

import is.vidmot.view.FerdSpjald;
import is.vinnsla.Ferd;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.Window;

public class FerdDialogController implements GognInterface<Ferd> {
	
	@FXML
	private FerdSpjald fxFerdSpjald;
	
	SimpleStringProperty heiti = new SimpleStringProperty();
	SimpleStringProperty afangastadur = new SimpleStringProperty();
	SimpleStringProperty dagsetning = new SimpleStringProperty();
	
	@Override
	public void setGogn(Ferd f) {
		fxFerdSpjald.heitiProperty().bind(f.heitiProperty());
		fxFerdSpjald.afangastadurProperty().bind(f.afangastadurProperty());
		fxFerdSpjald.dagsetningProperty().bind(f.dagsetningProperty());
	}

}
