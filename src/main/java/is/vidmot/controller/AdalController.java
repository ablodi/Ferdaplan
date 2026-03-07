package is.vidmot.controller;

import java.util.Optional;

import is.vidmot.switcher.View;
import is.vidmot.switcher.ViewSwitcher;
import is.vinnsla.Ferd;
import is.vinnsla.Ferdaplan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * Controller fyrir aðalviðmót forritsins.
 * Sér um að birta lista af ferðum, skoða valda ferð, bæta við ferð og eyða ferð.
 *
 * @author Kristinn Óskarsson
 */
public class AdalController {
	
    @FXML
    private ListView<Ferd> fxFerdalisti;
    @FXML
    private Button fxSkoda;
	@FXML
	private Button fxBaeta;
	@FXML
	private Button fxEyda;
	
	private static final Ferdaplan ferdaplan = new Ferdaplan();
	
	
	/**
     * Frumstillir controllerinn, tengir ferðalistann við viðmótið
     * og virkjar/óvirkjar hnappa eftir vali notanda.
     */
	public void initialize() {
		fxFerdalisti.setItems(ferdaplan.getListi());
		fxSkoda.disableProperty().bind(
				fxFerdalisti.getSelectionModel().selectedItemProperty().isNull());
		fxEyda.disableProperty().bind(
				fxFerdalisti.getSelectionModel().selectedItemProperty().isNull());
	}
	
	/**
     * Opnar sýn fyrir valda ferð.
     *
     * @param e atburður frá hnappi
     */
	@FXML
	private void onSkoda(ActionEvent e) {
		Ferd f = fxFerdalisti.getSelectionModel().getSelectedItem();
		System.out.println(f + "\n" + View.FERD.getFileName());
		Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		stage.setTitle("Ferð");
		ViewSwitcher.switchTo(View.FERD, false, f);;
		
		// Breyti stærðinni á glugganum eftir að ég ýti á skoða
		stage.setHeight(185.0); stage.setWidth(310.0); stage.centerOnScreen();
	}
	
	/**
     * Birtir glugga til að bæta nýrri ferð við listann.
     *
     * @param e atburður frá hnappi
     */
	@FXML
	private void onBaetaVid(ActionEvent e) {
		Optional<Ferd> result = FerdDialogWrapper.birtaDialog(
				((Node) e.getSource()).getScene().getWindow());
		result.ifPresent(f -> {
			if(f.erValid()) ferdaplan.getListi().add(f);
		});
	}
	
	/**
     * Eyðir valinni ferð eftir staðfestingu frá notanda.
     *
     * @param e atburður frá hnappi
     */
	@FXML
	private void onEyda(ActionEvent e) {
		Optional<ButtonType> result = StadfestingEydaDialogController.birtaGlugga();
		if(result.isPresent() && result.get() == ButtonType.OK) {
			fxFerdalisti.getItems().remove(
					fxFerdalisti.getSelectionModel().getSelectedIndex());
		}
	}
}

