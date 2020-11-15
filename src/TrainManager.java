
//name: Kevin Mathew
//id number: 112167040
//recitation: 02

import java.util.Scanner;

/**
 * This class hold the static void main function 
 * @author Kevin Mathew
 *
 */
public class TrainManager {
	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);
		boolean running = true;
		TrainLinkedList trainLink = new TrainLinkedList();

		while (running) {
			startMenu();
			System.out.print("Enter a selection: ");
			String input = stdin.nextLine();
			input = input.toUpperCase();
			System.out.println();

			switch (input) {
			case "F": // Cursor Forward
				trainLink.cursorForward();
				break;

			case "B": // Cursor Backward
				trainLink.cursorBackward();
				break;

			case "I": // Insert Car After Cursor
				try {
					System.out.println("Enter car length in meters: ");
					double length = stdin.nextDouble();
					System.out.println("Enter weight in tons: ");
					double weight = stdin.nextDouble();
					TrainCar car = new TrainCar(length, weight);
					trainLink.insertAfterCursor(car);
					trainLink.emptySetCursorData(car);
					System.out.println();
					System.out.println("New Train car " + car.getCarLength() + " meters " + car.getCarWeight()
							+ " tons inserted into train");
					System.out.println();
					stdin.nextLine(); // clears buffer
					break;
				} catch (IllegalArgumentException error) {
					System.out.println("Invalid Entries for new train car. Try again.");
					stdin.nextLine(); // clears buffer
					break;
				}
			case "R": // Remove Car At Cursor
				try {
					TrainCar removedCar = trainLink.removeCursor();
					System.out.println("Car successfully unlinked. The following load has been removed from the train:");
					System.out.println();
					System.out.printf("%-10s%-14s%-16s%-16s%-16s", " ", "Name", "Weight(t)", "Values($)", "Dangerous");
					System.out.println();
					System.out.printf("%-10s%-1s", " ",
							"=================================================================");
					System.out.println();
					String danger1;
					if (removedCar.getLoad().isDangerous()) {
						danger1 = "YES";
					} else {
						danger1 = "NO";
					}
					System.out.printf("%-10s%-14s%-16s%-16s%-16s", " ", removedCar.getLoad().getName(),
							removedCar.getLoad().getWeight(), removedCar.getLoad().getValue(), danger1);
					System.out.println();
					System.out.println();
					break;
				} catch (NullPointerException error) {
					System.out.print("No load was found on the train");
					System.out.println();
					break;
				}

			case "L": // Set Product Load
				try {
					System.out.println("Enter product name: ");
					String product = stdin.nextLine();
					System.out.println("Enter product weight in tons: ");
					double weightP = stdin.nextDouble();
					System.out.println("Enter product value in dollars: ");
					double value = stdin.nextDouble();
					stdin.nextLine(); // clears buffer
					System.out.println("Enter is product dangerous? (y/n): ");
					String danger = stdin.nextLine();
					boolean isDangerous = false;
					String s1 = "Y";
					String s2 = "y";
					String s3 = "N";
					String s4 = "n";
					if (danger.equals(s1) || danger.equals(s2)) {
						isDangerous = true;
					} else if (danger.equals(s3) || danger.equals(s4)) {
						isDangerous = false;
					}
					ProductLoad newLoad = new ProductLoad(product, weightP, value, isDangerous);
					TrainCar newCar = trainLink.getCursorData();

					newCar.setLoad(newLoad);
					trainLink.setCursorData(newCar);
					System.out.print("\n" + newCar.getLoad().getWeight() + " tons of " + newCar.getLoad().getName()
							+ " added to the current car" + "\n");
					System.out.println();
					break;
				}

				catch (IllegalArgumentException error) {
					System.out.println("Invalid Entries for product entered. Try again.");
					stdin.nextLine(); // clears buffer
					break;
				}

			case "S": // Search For Product
				System.out.println("Enter product name: ");
				String productD = stdin.nextLine();
				trainLink.findProduct(productD);
				break;

			case "T": // Display Train
				System.out.println(trainLink);
				System.out.println();
				break;

			case "M": // Display Manifest
				trainLink.printManifest();
				System.out.println();
				break;

			case "D": // Remove Dangerous Cars
				try {
					trainLink.removeDangerousCars();
					break;
				}

				catch (NullPointerException error) {
						System.out.println("Error with cursor == null");
						System.out.println();
				}

			case "Q": // Quit
				System.out.print("Program terminating successfully.....");
				running = false;
				break;
			}
		}
		stdin.close(); // closes scanner
	}

	/**
	 *
	 * Function creates the main menu for the program
	 * @author Kevin Mathew
	 * 
	 */
	public static void startMenu() {
		System.out.println("(F) Cursor Forward");
		System.out.println("(B) Cursor Backward");
		System.out.println("(I) Insert Car After Cursor");
		System.out.println("(R) Remove Car At Cursor");
		System.out.println("(L) Set Product Load");
		System.out.println("(S) Search For Product");
		System.out.println("(T) Display Train");
		System.out.println("(M) Display Manifest");
		System.out.println("(D) Remove Dangerous Cars");
		System.out.println("(Q) Quit");
		System.out.println();
	}
}
