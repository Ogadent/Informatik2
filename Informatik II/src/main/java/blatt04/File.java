package blatt04;

public class File extends AbstractFile {

	private int size;
	
	public File(String name) {
		super(name);
	}

	@Override
	public int getSize() {
		return size;
	}
}
