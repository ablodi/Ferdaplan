package is.vidmot;

import is.vidmot.switcher.ViewSwitcher;
import is.vidmot.view.FerdSpjald;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/******************************************************************************
 *  Nafn    :
 *  T-póstur:
 *  Lýsing  : Beinagreind að Application klasa
 *
 *
 *****************************************************************************/
public class FerdaplanApp extends javafx.application.Application {
    /**
     * Ræsir appið
     *
     * @param stage glugginn
     * @throws Exception undnantekning sem verður ef villla
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Smíða loader fyrir notendaviðmótið sem er geymt í skránni utlit-view.fxml
        // Gætið þess að .fxml skráin sé undir resources/is/vidmot
           FXMLLoader fxmlLoader = new FXMLLoader(FerdaplanApp.class.getResource("adal-view.fxml"));
        // Smíða senuna með notendaviðmótinu sem er núna lesið inn af resources
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        // Setja titilinn á gluggann
        stage.setTitle("Titill");
        // Tengja senuna við glugggann
        stage.setScene(scene);
        ViewSwitcher.setScene(scene);
        // Birta gluggann
        stage.show();
    }

    /**
     * Aðalforritið sem ræsir appið
     *
     * @param args ónotað
     */
    public static void main(String[] args) {
        // Ræsa forritið
        launch();
    }
}
