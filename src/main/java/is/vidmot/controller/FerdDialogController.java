package is.vidmot.controller;

import java.util.Optional;

import is.vidmot.view.FerdSpjald;
import is.vinnsla.Ferd;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Window;

public class FerdDialogController implements GognInterface<Ferd> {
	
	@FXML
	private FerdSpjald fxFerdSpjald;
	@FXML
	private DialogPane fxDialog;
	
	Ferd ferd;
	
	/**
	 * hef hér bind á Bæta Við hnappinn til að gera hann óvirkan ef
	 * það vantar inn í einhvern textfield
	 * Einnig bæti ég við íslenskum texta á takkana
	 */
	@FXML
	public void initialize() {
		
		Button okButton = (Button) fxDialog.lookupButton(ButtonType.OK);
		okButton.setText("Bæta Við");
		
		Button cancelButton = (Button) fxDialog.lookupButton(ButtonType.CANCEL);
		cancelButton.setText("Hætta Við");
		
		okButton.disableProperty().bind(
				Bindings.createBooleanBinding(() ->
				  // Skilyrðið fyrir binding, ef reitur er tómur
				  fxFerdSpjald.heitiProperty().get().isBlank() ||
				  fxFerdSpjald.afangastadurProperty().get().isBlank() ||
				  fxFerdSpjald.dagsetningProperty().get().isBlank(),
				  // dependency sem er fylgst með, binding endurmetið ef eitthvað breytist
				  fxFerdSpjald.heitiProperty(),
				  fxFerdSpjald.afangastadurProperty(),
				  fxFerdSpjald.dagsetningProperty()
				)
		);
	}
	
	
	@Override
	public void setGogn(Ferd f) {
		
		this.ferd = f;
		fxFerdSpjald.heitiProperty().bindBidirectional(f.heitiProperty());
		fxFerdSpjald.afangastadurProperty().bindBidirectional(f.afangastadurProperty());
		fxFerdSpjald.dagsetningProperty().bindBidirectional(f.dagsetningProperty());
		
	}
	
	public Ferd getFerd() {
		return ferd;
	}

}
