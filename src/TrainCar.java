//name: Kevin Mathew
//id number: 112167040
//recitation: 02

/**
 * Class type contains information about the TrainCar object used
 * 
 * @author Kevin Mathew
 *
 */
public class TrainCar {
	private double carLength;
	private double carWeight;
	private ProductLoad load;

	/**
	 * 
	 * @param carLength
	 * length of the train car
	 * 
	 * @param carWeight
	 * weight of the train car
	 */
	public TrainCar(double carLength, double carWeight) {
		this.carLength = carLength;
		this.carWeight = carWeight;
	}

	/**
	 * 
	 * @return
	 * gets train car length
	 */
	public double getCarLength() {
		return carLength;
	}

	/**
	 * 
	 * @return
	 * gets train car weight
	 */
	public double getCarWeight() {
		return carWeight;
	}
	
	/**
	 * 
	 * @return
	 * gets train car product load
	 */
	public ProductLoad getLoad() {
		return load;
	}
	
	/**
	 * 
	 * @param load
	 * sets product load of the traincar object
	 */
	public void setLoad(ProductLoad load) {
		this.load = load;
	}

	/**
	 * 
	 * @return
	 * whether the product load is empty
	 */
	public boolean isEmpty() {
		if (this.load == null) {
			return true;
		} else {
			return false;
		}
	}

}
