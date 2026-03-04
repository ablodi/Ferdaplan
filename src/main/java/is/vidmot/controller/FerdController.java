package is.vidmot.controller;

import is.vidmot.FerdaplanApp;
import is.vidmot.switcher.View;
import is.vidmot.switcher.ViewSwitcher;
import is.vidmot.view.FerdSpjald;
import is.vinnsla.Ferd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FerdController implements GognInterface<Ferd> {
	@FXML
	private FerdSpjald fxFerdSpjald;
	@FXML
	private Label fxHeiti;
	@FXML
	private Label fxAfangastadur;
	@FXML
	private Label fxDagsetning;
	@FXML
	private Button fxTilBaka;
	
    /**
     * Frumstillir controllerinn
     */
    public void initialize() {
        // Búa til nýja senu með rótinni af viðmótstrénu
    //    sena = new Scene (fxHeiti.getParent().getParent().getParent());
    }

	@Override
	public void setGogn(Ferd f) {
		fxFerdSpjald.heitiProperty().bind(f.heitiProperty());
		fxFerdSpjald.afangastadurProperty().bind(f.afangastadurProperty());
		fxFerdSpjald.dagsetningProperty().bind(f.dagsetningProperty());
	}
	
	@FXML
	private void onAdal(ActionEvent e) {
		ViewSwitcher.switchTo(View.ADAL);
	}
}
	