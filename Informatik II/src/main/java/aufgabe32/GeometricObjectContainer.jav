package blatt08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public enum GeometricObjectContainer implements Iterable<GeometricObject>{
	
	INSTANCE;
	
	private List<GeometricObject> data;
	
	private GeometricObjectContainer() {
		data = new ArrayList<>();
	}

	@Override
	public Iterator<GeometricObject> iterator() {
		return data.iterator();
	}
	
	public void link(final GeometricObject geo) {
		data.add(geo);
	}
	
	public void unlink(final GeometricObject geo) {
		data.remove(geo);
	}
}
