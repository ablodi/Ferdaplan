package is.vinnsla;

import javafx.beans.property.SimpleStringProperty;

public class Ferd {
	SimpleStringProperty heitiFerdar = new SimpleStringProperty();
	SimpleStringProperty afangastadur = new SimpleStringProperty();
	SimpleStringProperty dagsetning = new SimpleStringProperty();
	
	public Ferd(String heitiFerdar, String afangastadur, String dagsetning) {
		this.heitiFerdar.set(heitiFerdar);
		this.afangastadur.set(afangastadur);
		this.dagsetning.set(dagsetning);
	}
	
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
	
}
