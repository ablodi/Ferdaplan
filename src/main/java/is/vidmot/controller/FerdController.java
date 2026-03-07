package is.vidmot.controller;

import is.vidmot.switcher.View;
import is.vidmot.switcher.ViewSwitcher;
import is.vidmot.view.FerdSpjald;
import is.vinnsla.Ferd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Controller fyrir ferðasýnina.
 * Tekur við ferðargögnum og birtir þau í FerdSpjald viðmótshlutanum.
 *
 * @author Kristinn Óskarsson
 */
public class FerdController implements GognInterface<Ferd> {
	@FXML
	private FerdSpjald fxFerdSpjald;
	private Ferd ferd;
   
	 /**
     * Setur ferðargögn inn í viðmótið.
     *
     * @param f ferðin sem á að birta
     */
	@Override
	public void setGogn(Ferd f) {
		
		this.ferd = f;
		fxFerdSpjald.heitiProperty().bind(f.heitiProperty());
		fxFerdSpjald.afangastadurProperty().bind(f.afangastadurProperty());
		fxFerdSpjald.dagsetningProperty().bind(f.dagsetningProperty());
	}
	
	/**
     * Skiptir aftur yfir í aðalviðmótið.
     *
     * @param e atburður frá hnappi
     */
	@FXML
	private void onAdal(ActionEvent e) {
		Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		ViewSwitcher.switchTo(View.ADAL);
		// Breyti stærðinni á glugganum eftir að ég ýti á skoða
		stage.setHeight(400.0); stage.setWidth(400.0); stage.centerOnScreen();
	}
}
	