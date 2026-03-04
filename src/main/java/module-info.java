/******************************************************************************
 *  Nafn    :
 *  T-póstur:
 *  Lýsing  : er module skrá sem skilgreinir hvaða forritasöfn eru nauðsynleg og hver eru
 *  aðgengileg forritasöfnum  *
 *
 *****************************************************************************/
module ModuleNafn {
    requires javafx.fxml;
    requires javafx.controls;
	requires javafx.graphics;
    opens is.vidmot to javafx.fxml;
    opens is.vidmot.view to javafx.fxml;
    opens is.vidmot.controller to javafx.fxml;
    opens is.vidmot.switcher to javafx.fxml;
    
    exports is.vidmot.controller;
    exports is.vidmot.switcher;
    exports is.vidmot;
    exports is.vinnsla;
}