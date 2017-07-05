package blatt2.aufgabe7;

public class Article {
	
	private String name;
	private double discount;
	private double price;
	
	public Article(String name, double discount, double price) throws IllegalArgumentException {
		setName(name);
		setPrice(price);
		setDiscount(discount);
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public double getDiscount() {
		return this.discount;
	}
	
	public void print() {
		System.out.println(getName());
		System.out.println("Preis: " + getPrice());
		System.out.println("Rabatt: " + getDiscount());
		System.out.println();
	}
	
	private static boolean checkName(String name) {
		return true;
	}
	
	public void setName(String name) throws IllegalArgumentException {
		if (!checkName(name))
			throw new IllegalArgumentException("Name ungültig");
		this.name = name;
	}

	private static boolean checkPrice(double price) {
		return (price > 0);
	}
	
	public void setPrice(double price) throws IllegalArgumentException {
		if (!checkPrice(price))
			throw new IllegalArgumentException("Preis ungültig");
		this.price = price;
	}

	private static boolean checkDiscount(double discount) {
		return (discount >= 0) && (discount < 10.0);
	}
	
	public void setDiscount(double discount) throws IllegalArgumentException {
		if (!checkDiscount(discount))
			throw new IllegalArgumentException("Rabatt ungÃ¼ltig");
		this.discount = discount;
	}
}
