//name: Kevin Mathew
//id number: 112167040
//recitation: 02

/**
 * This class implements the train-linkedlist
 * @author Kevin Mathew
 *
 */
public class TrainLinkedList {
	private TrainCarNode head = new TrainCarNode();
	private TrainCarNode tail = new TrainCarNode();
	private TrainCarNode cursor = new TrainCarNode();

	// Variables to calculate total size,length,weight,value and danger
	private int totalSize;
	private double totalLength;
	private double totalWeight;
	private double totalValue;
	private int dangerousCars;
	
	/**
	 * Constructor that initializes members to null
	 * 
	 */
	public TrainLinkedList() {
		head = null; // head,tail,cursor initlized to null
		tail = null;
		cursor = null;
	}
	
	/**
	 * 
	 * @return
	 * values of the train car at the cursor position
	 */
	public TrainCar getCursorData() {
		if (cursor != null) {
			return cursor.getCar();
		} else {
			return null;
		}

	}
	/**
	 * 
	 * @param car
	 * contains TrainCar object 
	 */
	public void setCursorData(TrainCar car) {
		if (cursor != null) {
			this.cursor.setCar(car);
			totalValue += car.getLoad().getValue();
			totalWeight += car.getLoad().getWeight();
			if (car.getLoad().isDangerous()) {
				dangerousCars++;
			}
		}
	}

	/**
	 * Custom function to account for total load properties
	 * @param car
	 * contains TrainCar objecs
	 */
	public void emptySetCursorData(TrainCar car) {
		this.cursor.setCar(car);
		totalSize++;
		totalLength += car.getCarLength();
		totalWeight += car.getCarWeight();
	}

	/**
	 * Moves cursor forward
	 */
	public void cursorForward() {
		if (cursor.getNext() != null) {
			TrainCarNode temp = cursor;
			cursor = cursor.getNext();
			cursor.setPrev(temp);
			System.out.println("Cursor moved forward");
			System.out.println();
		} else {
			System.out.println("No next car, cannot move cursor forward.");
			System.out.println();
		}
	}

	/**
	 * Moves cursor backward
	 */
	public void cursorBackward() {
		if (cursor.getPrev() != null) {
			TrainCarNode temp = cursor;
			cursor = cursor.getPrev();
			cursor.setNext(temp);
			System.out.println("Cursor moved backward");
			System.out.println();
		} else {
			System.out.println("No previous car, cannot move cursor backward.");
			System.out.println();
		}
	}

	/**
	 * 
	 * @param newCar
	 * implements TrainCar object 
	 * 
	 * @throws IllegalArgumentException
	 * exception thrown when newCar is equal to null
	 */
	public void insertAfterCursor(TrainCar newCar) throws IllegalArgumentException {
		if (newCar == null) { // indicated newCar is null
			throw new IllegalArgumentException("New Train Car is null");
		}

		TrainCarNode newCarNode = new TrainCarNode();
		if (cursor != null) {
			newCarNode = cursor.getNext();
		} else { // inserting first car
			newCarNode = null;
		}
		TrainCarNode trainCarNode = new TrainCarNode();
		trainCarNode.setCar(newCar);
		trainCarNode.setNext(newCarNode);
		trainCarNode.setPrev(cursor);

		if (cursor != null) {
			cursor.setNext(trainCarNode);
			cursor = cursor.getNext();
			if (cursor.getNext() == null) { // no train car after inserted car
				tail = cursor;
			}
		} else { // inserting first car
			cursor = trainCarNode;
			head = cursor;
			tail = cursor;
		}
	}

	/**
	 * 
	 * @return
	 * TrainCar object that was removed from the linkedlist
	 * 
	 * @throws NullPointerException
	 * Exception thrown when cursor is set to null unexpectadly 
	 */
	public TrainCar removeCursor() throws NullPointerException {
		if (cursor != null) {
			if (cursor.getNext() != null) {
				cursor.getNext().setPrev(cursor.getPrev()); // joining two cars that once had removed car in between
			}
			if (cursor.getPrev() != null) {
				cursor.getPrev().setNext(cursor.getNext()); // joining two cars that once had removed car in between
			}

			TrainCarNode removedCar = cursor; // cursor position at where the removed car is

			cursor = (cursor.getNext() != null) ? cursor.getNext() : cursor.getPrev(); // true : false

			if (head == removedCar) { //if removed car was the first of the list 
				head = cursor;
			}
			if (tail == removedCar) { //if removed car was the last of the list 
				tail = cursor;
			}

			// Decrement the values that were initially added from the removed car
			TrainCar removeCar = removedCar.getCar();
			totalSize--;
			totalLength -= removeCar.getCarLength();
			totalWeight -= removeCar.getCarWeight();
			totalValue -= removeCar.getLoad().getValue();

			if (removeCar.getLoad().isDangerous()) {
				dangerousCars--;
			}
			return removeCar;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @return
	 * total size of the linkedList
	 */
	public int size() { // completed in O(1) time
		return totalSize;
	}

	/**
	 * 
	 * @return
	 * total length of the linkedList
	 */
	public double getLength() { // completed in O(1) time
		return totalLength;
	}
	
	/**
	 * 
	 * @return
	 * total value of the linkedList
	 */
	public double getValue() { // completed in O(1) time
		return totalValue;
	}
	
	/**
	 * 
	 * @return
	 * total weight of the linkedList
	 */
	public double getWeight() { // completed in O(1) time
		return totalWeight;
	}
	
	/**
	 * 
	 * @return
	 * danger of the linkedList
	 */
	public boolean isDangerous() { // completed in O(1) time
		return (dangerousCars > 0);
	}

	/**
	 * 
	 * @param name
	 * String value representing product you want to find
	 */
	public void findProduct(String name) {
		TrainCarNode finder = head;
		double itemWeight = 0.0;
		double itemValue = 0.0;
		boolean foundItem = false;
		boolean isDanger = false;
		int carCounter = 0;
		String danger;

		while (finder != null) {
			if (finder.getCar().getLoad().getName().equals(name)) {
				carCounter++;
				foundItem = true;
				itemWeight += finder.getCar().getLoad().getWeight();
				itemValue += finder.getCar().getLoad().getValue();

				if (finder.getCar().getLoad().isDangerous()) {
					isDanger = true;
				}
			}
			finder = finder.getNext();
		}

		if (isDanger) {
			danger = "YES";
		} else {
			danger = "NO";
		}
		if (foundItem) {
			System.out.println("The following products were found on " + carCounter + " car(s)");
			System.out.println();
			System.out.printf("%-10s%-14s%-16s%-16s%-16s", " ", "Name", "Weight(t)", "Value($)", "Dangerous");
			System.out.println();
			System.out.printf("%-10s%-1s", " ", "=================================================================");
			System.out.println();
			System.out.printf("%-10s%-14s%-16s%-16s%-16s", " ", name, itemWeight, itemValue, danger);
			System.out.println();
			System.out.println();
		} else {
			System.out.println();
			System.out.println("No record of " + name + " on board train");
			System.out.println();
		}
	}

	/**
	 * prints a neatly formatted train manifest 
	 */
	public void printManifest() {
		System.out.printf("%-50s%-60s", "CAR:", "LOAD:");
		System.out.println();
		System.out.printf("%-5s%-8s%-22s%-14s%-10s%-14s%-16s%-16s%-16s", " ", "Num", "Length (m)", "Weight(t)", "|",
				"Name", "Weight(t)", "Value($)", "Dangerous");
		System.out.println();
		System.out.println(
				"=================================================+====================================================================");

		TrainCarNode printer = head; // first car
		int i = 1;
		String danger;
		while (printer != null) {
			if (printer.getCar().getLoad() == null) {
				if (printer == cursor) {
					System.out.printf("%-5s%-8d%-22s%-14s%-10s%-14s%-16s%-16s%-16s", "->", i,
							printer.getCar().getCarLength(), printer.getCar().getCarWeight(), "|", "Empty", "0.0",
							"0.00", "NO");
					System.out.println();
				} else {
					System.out.printf("%-5s%-8d%-22s%-14s%-10s%-14s%-16s%-16s%-16s", "  ", i,
							printer.getCar().getCarLength(), printer.getCar().getCarWeight(), "|", "Empty", "0.0",
							"0.00", "NO");
					System.out.println();
				}
			} else {
				if (printer.getCar().getLoad().isDangerous()) {
					danger = "YES";
				} else {
					danger = "NO";
				}

				if (printer == cursor) {
					System.out.printf("%-5s%-8d%-22s%-14s%-10s%-14s%-16s%-16s%-16s", "=>", i,
							printer.getCar().getCarLength(), printer.getCar().getCarWeight(), "|",
							printer.getCar().getLoad().getName(), printer.getCar().getLoad().getWeight(),
							printer.getCar().getLoad().getValue(), danger);
					System.out.println();
				} else {
					System.out.printf("%-5s%-8d%-22s%-14s%-10s%-14s%-16s%-16s%-16s", "  ", i,
							printer.getCar().getCarLength(), printer.getCar().getCarWeight(), "|",
							printer.getCar().getLoad().getName(), printer.getCar().getLoad().getWeight(),
							printer.getCar().getLoad().getValue(), danger);
					System.out.println();
				}
			}
			i++;
			printer = printer.getNext();
		}

	}

	/**
	 * removes all dangerous cars from manifest
	 */
	public void removeDangerousCars() {
		// TrainCarNode originalCursor = cursor;
		cursor = head;
		boolean dangerRemoved = false;
		while (cursor != null) {
			if (cursor.getCar().getLoad().isDangerous()) {
				removeCursor();
				dangerRemoved = true;
			}
			cursor = cursor.getNext();
		}
		cursor = tail; // move cursor to the bottom of the list
		if (dangerRemoved) {
			System.out.println("Dangerous cars successfully removed from the train.");
			System.out.println();
		} else {
			System.out.println("No dangerous cars on the train");
			System.out.println();
		}
	}
	
	/**
	 * toString method for manifest, returns total values 
	 */
	public String toString() {
		String danger = "";
		if (this.isDangerous()) {
			danger = "DANGEROUS";
		} else {
			danger = "not dangerous";
		}
		return "Train: " + size() + " cars, " + getLength() + " meters, " + getWeight() + " tons, " + "$"
				+ this.getValue() + " value, " + danger;
	}
}
