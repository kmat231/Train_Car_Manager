//name: Kevin Mathew
//id number: 112167040
//recitation: 02

/**
 * Contains what would be nodes for the traincars on linkedlist
 * 
 * @author Kevin Mathew
 *
 */
public class TrainCarNode {
	private TrainCarNode prev;
	private TrainCarNode next;
	private TrainCar car;

	public TrainCarNode() {
	}

	/**
	 * 
	 * @param car
	 * set TrainCar object
	 */
	public TrainCarNode(TrainCar car) {
		this.car = car;
	}

	/**
	 * 
	 * @return
	 * reference value for previous train car object
	 */
	public TrainCarNode getPrev() {
		return prev;
	}

	/**
	 * 
	 * @param prev
	 * set the previous car reference
	 */
	public void setPrev(TrainCarNode prev) {
		this.prev = prev;
	}

	/**
	 * 
	 * @return
	 * reference value for next train car object
	 */
	public TrainCarNode getNext() {
		return next;
	}
	
	/**
	 * 
	 * @param next
	 * set reference for next train car object
	 */
	public void setNext(TrainCarNode next) {
		this.next = next;
	}

	/**
	 * 
	 * @return
	 * get reference of train car at node
	 */
	public TrainCar getCar() {
		return car;
	}

	/**
	 * 
	 * @param car
	 * sets TrainCar for the node point
	 */
	public void setCar(TrainCar car) {
		this.car = car;
	}

	/**
	 * toString method for the train car nodes 
	 */
	public String toString() {
		return "TrainCarNode [prev=" + prev + ", next=" + next + ", car=" + car + "]";
	}

}
