package is.vinnsla;

import javafx.beans.property.SimpleStringProperty;

/**
 * Gagnaklasi sem lýsir einni ferð í ferðaplani.
 * Ferð geymir heiti, áfangastað og dagsetningu sem JavaFX-eiginleika.
 *
 * @author Kristinn Óskarsson
 */
public class Ferd {
	SimpleStringProperty heitiFerdar = new SimpleStringProperty("");
	SimpleStringProperty afangastadur = new SimpleStringProperty("");
	SimpleStringProperty dagsetning = new SimpleStringProperty("");
	
	/**
     * Býr til ferð með uppgefnu heiti, áfangastað og dagsetningu.
     *
     * @param heitiFerdar heiti ferðar
     * @param afangastadur áfangastaður ferðar
     * @param dagsetning dagsetning ferðar
     */
	public Ferd(String heitiFerdar, String afangastadur, String dagsetning) {
		this.heitiFerdar.set(heitiFerdar);
		this.afangastadur.set(afangastadur);
		this.dagsetning.set(dagsetning);
	}
	
	public Ferd() {}

	@Override
	public String toString() {
		return heitiFerdar.get() + ":" + afangastadur.get() + ":" + dagsetning.get();
	}
	public String getHeiti() {
		return this.heitiFerdar.get();
	}

	public String getAfangastadur() {
		return this.afangastadur.get();
	}

	public String getDagsetning() {
		return this.dagsetning.get();
	}
	public SimpleStringProperty heitiProperty() {
		return heitiFerdar;
	}
	public SimpleStringProperty afangastadurProperty() {
		return afangastadur;
	}
	public SimpleStringProperty dagsetningProperty() {
		return dagsetning;
	}
	/**
	 * Athugar hvort einhver field sé tómur
	 * @return false ef það vantar einhvert property, annars true
	 */
	public boolean erValid() {
		return
				heitiProperty().get() != null && !heitiProperty().get().isBlank()
				&& afangastadurProperty().get() != null && !afangastadurProperty().get().isBlank()
				&& dagsetningProperty().get() != null && !dagsetningProperty().get().isBlank();
	}
}
