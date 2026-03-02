package is.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ferdaplan {
	
	private final ObservableList<Ferd> ferdalisti;
	
	public Ferdaplan () {
			this.ferdalisti = FXCollections.observableArrayList();
			this.ferdalisti.add((new Ferd("SK195","London","15 Janúar")));
			this.ferdalisti.add((new Ferd("AW102","Paris","5 September")));
			this.ferdalisti.add((new Ferd("RK217","Frankfurt","28 Febrúar")));
	}
	
	public ObservableList<Ferd> getListi () {
		return ferdalisti;
	}
	

}
