package blatt2.aufgabe8;

public class Student {

	private String matnr;
	private String name;
	
	public Student(String name, String matnr) {
		setName(name);
		setMatnr(matnr);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getMatnr() {
		return this.matnr;
	}
	
	private static boolean checkName(String name) {
		return (name.length() <= 20);
	}
	
	public void setName(final String name) {
		if (name == null) {
			throw new IllegalArgumentException("name == null");
		}
		if (!checkName(name)) {
			throw new IllegalArgumentException("name (" + name + ") must be <= 20 characters long");
		}
		this.name = name;
	}
	
	private static boolean checkMatr(final String matnr) {
		return matnr.matches("[0-9]{10}");
	}

	public void setMatnr(final String matrikelNumber) {
		if (matrikelNumber == null) {
			throw new IllegalArgumentException("matnr == null");
		}
		if (!checkMatr(matrikelNumber)) {
			throw new IllegalArgumentException("matnr (" + matrikelNumber + ") must consist of 10 digits");
		}
		this.matnr = matrikelNumber;
	}
}
