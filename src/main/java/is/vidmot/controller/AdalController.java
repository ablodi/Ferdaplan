package is.vidmot.controller;

import is.vidmot.switcher.View;
import is.vidmot.switcher.ViewSwitcher;
import is.vinnsla.Ferd;
import is.vinnsla.Ferdaplan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

/******************************************************************************
 *  Nafn    :
 *  T-póstur:
 *  Lýsing  : Controller eða stýring fyrir notendaviðmótið
 *
 *
 *****************************************************************************/
public class AdalController {
	
    @FXML
    private ListView<Ferd> fxFerdalisti;
    @FXML
    private Button fxSkoda;
	@FXML
	private Button fxBaeta;
	@FXML
	private Button fxEyda;
	
	private Ferdaplan ferdaplan = new Ferdaplan();
	
	
	public void initialize() {
		fxFerdalisti.setItems(ferdaplan.getListi());
		fxSkoda.disableProperty().bind(
				fxFerdalisti.getSelectionModel().selectedItemProperty().isNull());
		fxEyda.disableProperty().bind(
				fxFerdalisti.getSelectionModel().selectedItemProperty().isNull());
	}
	@FXML
	private void onSkoda(ActionEvent e) {
		Ferd f = fxFerdalisti.getSelectionModel().getSelectedItem();
		System.out.println(f + "\n" + View.FERD.getFileName());
		ViewSwitcher.switchTo(View.FERD, false, f);;
	}
}

