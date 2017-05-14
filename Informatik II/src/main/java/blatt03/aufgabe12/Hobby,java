package blatt03.aufgabe12;

public class Hobby {

	private String name;
	private int priority;
	
	public Hobby(final String name) {
		this(name, 1);
	}
	
	public Hobby(final String name, final int priority) {
		if (!setName(name)) {
			throw new IllegalArgumentException("name mustnt be empty");
		}
		setPriority(priority);
	}
	
	private boolean setName(final String name) {
		if (checkName(name)) {
			this.name = name;
			return true;
		}
		return false;
	}
	
	public void setPriority(final int priority) {
		if (!checkPriority(priority)) {
			throw new IllegalArgumentException("0 < priority < 6");
		}
		this.priority = priority;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPriority() {
		return priority;
	}
	
	private static boolean checkName(final String name) {
		return (name != null && !name.isEmpty());
	}
	
	private static boolean checkPriority(final int priority) {
		return priority > 0 && priority < 6;
	}
}
