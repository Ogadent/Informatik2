package blatt04.aufgabe15d;

public class File extends AbstractFile {

	private int size = 0;
	
	public File(String name) {
		super(name);
	}

	@Override
	public int getSize() {
		return size;
	}
}
