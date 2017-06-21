package blatt08;

public class BuchContainer {

	private static BuchContainer unique = null;
	private List<Buch> alleBuecher;
	
	private BuchContainer() {
		alleBuecher = new ArrayList<>();
	}
	
	public static BuchContainer instance() {
		if (unique == null) {
			unique = new BuchContainer();
		}
		return unique;
	}
}
