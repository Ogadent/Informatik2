package blatt04;

import java.util.List;

public class Directory extends AbstractFile {

	private List<AbstractFile> element;
	
	public Directory(String name) {
		super(name);
	}

	@Override
	public int getSize() {
		int size = 0;
		for (AbstractFile f : element) {
			size += f.getSize();
		}
		return size;
	}
}
