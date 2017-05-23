package blatt04.aufgabe15d;

public abstract class AbstractFile {

	private String name;
	
	protected AbstractFile(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name is empty");
		}
		this.name = name;
	}
	
	public abstract int getSize();
}
