package is.vidmot.controller;

import java.io.IOException;
import java.util.Optional;

import is.vinnsla.Ferd;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Window;

public class FerdDialogWrapper {
	
	public static Optional<Ferd> birtaDialog(Window owner) {
		
		// setur upp FXML loader
		FXMLLoader fxmlLoader = new FXMLLoader(FerdDialogWrapper.class.getResource("/is/vidmot/nyFerd-dialog.fxml"));
        try {
        	
        	// Lesa inn .fxml fyrir DialogPane með loader og sækja controller úr loader 
        	DialogPane dp = fxmlLoader.load();
        	
        	// Búa til nýja ferð og setja gögn í controler
        	Ferd f = new Ferd();
        	FerdDialogController ferdControl = (FerdDialogController) fxmlLoader.getController();
        	ferdControl.setGogn(f);
        	
        	// Búa til dialog og tengja við pane og owner
        	Dialog<Ferd> d = new Dialog<>();
        	d.setTitle("Bæta við ferð");
        	d.setDialogPane(dp);
        	d.initOwner(owner);
        	
        	// Skrifa resultConverter sem skilar Ferd og tengja við dialog
        	d.setResultConverter(b  ->  {
        				if(b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
        					return ferdControl.getFerd();
        				} else {
        					return null;
        				}
        			}
        			);
        	// Sýna dialog (showAndWait) og skila niðurstöðu
        	return d.showAndWait();
        	
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
		
	}
	
}
