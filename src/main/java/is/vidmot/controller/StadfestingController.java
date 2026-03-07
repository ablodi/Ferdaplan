package is.vidmot.controller;

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;

/**
 * Hjálparklasi sem birtir staðfestingarglugga áður en ferð er eytt.
 *
 * @author Kristinn Óskarsson
 */
public class StadfestingController {
	
	/**
	 * Nota Alert fyrir staðfestingu á því að eyða
	 * Hleð dialog fxml skránni inn í Alert
	 * @return Skila Optional með ButtonType sem segir val notanda
	 */
	public static Optional<ButtonType> birtaGlugga() {
		try {
			FXMLLoader loader = new FXMLLoader(StadfestingController.class.getResource("/is/vidmot/stadfestingEyda-dialog.fxml"));
			DialogPane dialogPane = loader.load();
			Alert stadfesta = new Alert(AlertType.CONFIRMATION);
			stadfesta.setDialogPane(dialogPane);
			stadfesta.setTitle("Staðfesting");
			
			return stadfesta.showAndWait();
			
		} catch(IOException exception) {
			throw new RuntimeException(exception);
		}
	}

}
