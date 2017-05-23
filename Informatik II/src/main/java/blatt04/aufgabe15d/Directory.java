package blatt04.aufgabe15d;

import java.util.List;

public class Directory extends AbstractFile {

	private List<AbstractFile> element;
	
	public Directory(String name) {
		super(name);
		element = new ArrayList<>();
	}

	@Override
	public int getSize() {
		return element.stream().mapToInt(AbstractFile::getSize).sum();
	}
}
