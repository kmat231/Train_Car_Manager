//name: Kevin Mathew
//id number: 112167040
//recitation: 02
/**
 * Implementation of Product Load Class
 */
public class ProductLoad {
	private String name;
	private double weight;
	private double value;
	private boolean isDangerous;

	public ProductLoad(String name, double weight, double value, boolean isDangerous) {
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.isDangerous = isDangerous;
	}
/**
 * 
 * @return 
 * name of product
 */
	public String getName() {
		return name;
	}
/**
 * 
 * @param name
 * The name of the product load
 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 * weight of the product load
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * 
	 * @param weight
	 * set the weight of the product load
	 * 
	 * @throws IllegalArgumentException
	 * when weight is negative 
	 * 
	 */
	public void setWeight(double weight) {
		if (weight < 0) {
			throw new IllegalArgumentException("Weight cannot be a negative number");
		}
		this.weight = weight;
	}

	/**
	 * 
	 * @return
	 * value of the product load
	 */
	public double getValue() {
		return value;
	}

	/**
	 * 
	 * @param value
	 * set value of the product load
	 * 
	 * @throws IllegalArgumentException
	 * Value cannot be negative
	 */
	public void setValue(double value) {
		if (value < 0) {
			throw new IllegalArgumentException("Value cannot be a negative number");
		}
		this.value = value;
	}

	/**
	 * 
	 * @return
	 * whether load is dangerous or not
	 */
	public boolean isDangerous() {
		return isDangerous;
	}

	/**
	 * 
	 * @param isDangerous
	 * set product load is dangerous
	 */
	public void setDangerous(boolean isDangerous) {
		this.isDangerous = isDangerous;
	}

}
