package is.vidmot.controller;

import java.io.IOException;

import is.vinnsla.Ferd;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class FerdDialogWrapper {
	
	public FerdDialogWrapper() {
		Dialog<Ferd> dialogFerd = new Dialog<>();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/is/vidmot/nyFerd-dialog.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(FerdDialogController.class);
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			
		}
	}
}
