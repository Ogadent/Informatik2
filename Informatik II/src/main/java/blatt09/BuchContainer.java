import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuchContainer {
	private static BuchContainer unique = null;
	private List<Buch> alleBuecher;
	private Datenbank store;
	
	private BuchContainer() {
		alleBuecher = new ArrayList<>();
		try {
			store.connect();
			store.load();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void linkAlleBuecher(Buch buch) {
		alleBuecher.add(buch);
		store.add(buch);
	}
}