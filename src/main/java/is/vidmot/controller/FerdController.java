package is.vidmot.controller;

import is.vinnsla.Ferd;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FerdController implements GognInterface<Ferd> {
	@FXML
	private Label fxHeiti;
	@FXML
	private Label fxAfangastadur;
	@FXML
	private Label fxDagsetning;
	@FXML
	private Button fxTilBaka;
	
	private Scene sena;
    /**
     * Frumstillir controllerinn
     */
    public void initialize() {
        // Búa til nýja senu með rótinni af viðmótstrénu
    //    sena = new Scene (fxHeiti.getParent().getParent().getParent());
    }

	@Override
	public void setGogn(Ferd f) {
		// TODO Auto-generated method stub
		
	}
    /**
     * Birtir gluggann með námskeiði í
     * @param namskeid námskeiðið
     */
    public void birtaGluggi(Ferd f) {
        // setja gögn í viðmótshlutina í tilviksbreytunum
        fxHeiti.setText(f.getHeiti());
        fxAfangastadur.setText(f.getAfangastadur());
        fxDagsetning.setText(f.getDagsetning());

        // Búa til glugga
        Stage gluggi = new Stage();
        // tengja senu við glugga - hér er senan geymd en ekki búin til í hvert skipti
        gluggi.setScene(sena);
        // sýna glugga - non-modal
        gluggi.show();
    }
}
	