package com;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sameh A. Fakhouri
 *
 */
public class Driver implements DriverInterface {

	private static final long MEGABYTE = 1024L * 1024L;

	public static double bytesToMegabytes(double bytes) {
		return bytes / MEGABYTE;
	}

	public static List<String> prepareHeaderRow1() {
		List<String> list = new ArrayList<>();

		list.add("");
		for (int i = 1; i <= 10; i++) {
			list.add("Run " + i);
		}
		list.add("Average");
		list.add("Memory Usage");
		return list;
	}

	public static List<String> prepareHeaderRow2() {
		List<String> list = new ArrayList<>();

		list.add("");
		for (int i = 1; i <= 10; i++) {
			list.add("nano sec");
		}
		list.add("nano sec");
		list.add("Mega Bytes");
		return list;
	}

	public static List<String> prepareHeaderRow3() {
		List<String> list = new ArrayList<>();

		list.add("");
		for (int i = 1; i <= 10; i++) {
			list.add("------------");
		}
		list.add("------------");
		list.add("------------");
		return list;
	}

	public static String formatAsTable(List<List<String>> rows) {
		int[] maxLengths = new int[rows.get(0).size()];
		for (List<String> row : rows) {
			for (int i = 0; i < row.size(); i++) {
				maxLengths[i] = Math.max(maxLengths[i], row.get(i).length());
			}
		}

		StringBuilder formatBuilder = new StringBuilder();
		for (int maxLength : maxLengths) {
			formatBuilder.append("%-").append(maxLength + 2).append("s");
		}
		String format = formatBuilder.toString();

		StringBuilder result = new StringBuilder();
		for (List<String> row : rows) {
			result.append(String.format(format, row.toArray(new String[0]))).append("\n");
		}
		return result.toString();
	}

	public static void main(String[] args) {

		Driver driver = new Driver();

		// Use case 1 - AddSortedOdd
		printUsecase1(driver);

		// Use case 2 - AddSortedEven
		printUsecase2(driver);

		// Use case 3 - AddAll
		printUsecase3(driver);

		// Use case 4 - AddAllAtIndexZero
		printUsecase4(driver);

		// Use case 5 - RemoveAllEven
		printUsecase5(driver);

		// Use case 6 - RemoveAllOdd
		printUsecase6(driver);

	}

	private static void printUsecase6(Driver driver) {

		// Use case 6 - RemoveAllOdd

		List<List<String>> listOfListRemoveAllOdd = new ArrayList<>();

		listOfListRemoveAllOdd.add(prepareHeaderRow1());
		listOfListRemoveAllOdd.add(prepareHeaderRow2());
		listOfListRemoveAllOdd.add(prepareHeaderRow3());

		System.out.println("Running Test: " + TestType.RemoveAllOdd.toString());
		List<String> arrayListRemoveAllOdd = new ArrayList<>();
		arrayListRemoveAllOdd.add(ListType.ArrayBasedList.toString());

		TestTimes arrayListRemoveAllOddTestTimes = driver.runTestCase(ListType.ArrayBasedList, TestType.RemoveAllOdd,
				10);
		long[] arrayListRemoveAllOddTestTimesArray = arrayListRemoveAllOddTestTimes.getTestTimes();
		for (long elapsedTime : arrayListRemoveAllOddTestTimesArray) {
			arrayListRemoveAllOdd.add(String.valueOf(elapsedTime));
		}
		arrayListRemoveAllOdd.add(String.valueOf(arrayListRemoveAllOddTestTimes.getAverageTestTime()));
		arrayListRemoveAllOdd.add(String.valueOf(bytesToMegabytes(driver.memoryUsage())));
		
		listOfListRemoveAllOdd.add(arrayListRemoveAllOdd);
		
		List<String> linkedListRemoveAllOdd = new ArrayList<>();
		linkedListRemoveAllOdd.add(ListType.LinkedList.toString());

		TestTimes linkedListRemoveAllOddTestTimes = driver.runTestCase(ListType.LinkedList, TestType.RemoveAllOdd, 10);
		long[] linkedListRemoveAllOddTestTimesArray = linkedListRemoveAllOddTestTimes.getTestTimes();
		for (long elapsedTime : linkedListRemoveAllOddTestTimesArray) {
			linkedListRemoveAllOdd.add(String.valueOf(elapsedTime));
		}
		linkedListRemoveAllOdd.add(String.valueOf(linkedListRemoveAllOddTestTimes.getAverageTestTime()));
		linkedListRemoveAllOdd.add(String.valueOf(bytesToMegabytes(driver.memoryUsage())));

		listOfListRemoveAllOdd.add(linkedListRemoveAllOdd);
		System.out.println(formatAsTable(listOfListRemoveAllOdd));
	}

	private static void printUsecase5(Driver driver) {
		// Use case 5 - RemoveAllEven
		List<List<String>> listOfListRemoveAllEven = new ArrayList<>();

		listOfListRemoveAllEven.add(prepareHeaderRow1());
		listOfListRemoveAllEven.add(prepareHeaderRow2());
		listOfListRemoveAllEven.add(prepareHeaderRow3());

		System.out.println("Running Test: " + TestType.RemoveAllEven.toString());
		List<String> arrayListRemoveAllEven = new ArrayList<>();
		arrayListRemoveAllEven.add(ListType.ArrayBasedList.toString());

		TestTimes arrayListRemoveAllEvenTestTimes = driver.runTestCase(ListType.ArrayBasedList, TestType.RemoveAllEven,
				10);
		long[] arrayListRemoveAllEvenTestTimesArray = arrayListRemoveAllEvenTestTimes.getTestTimes();
		for (long elapsedTime : arrayListRemoveAllEvenTestTimesArray) {
			arrayListRemoveAllEven.add(String.valueOf(elapsedTime));
		}
		arrayListRemoveAllEven.add(String.valueOf(arrayListRemoveAllEvenTestTimes.getAverageTestTime()));
		arrayListRemoveAllEven.add(String.valueOf(bytesToMegabytes(driver.memoryUsage())));

		listOfListRemoveAllEven.add(arrayListRemoveAllEven);

		List<String> linkedListRemoveAllEven = new ArrayList<>();
		linkedListRemoveAllEven.add(ListType.LinkedList.toString());

		TestTimes linkedListRemoveAllEvenTestTimes = driver.runTestCase(ListType.LinkedList, TestType.RemoveAllEven,
				10);
		long[] linkedListRemoveAllEvenTestTimesArray = linkedListRemoveAllEvenTestTimes.getTestTimes();
		for (long elapsedTime : linkedListRemoveAllEvenTestTimesArray) {
			linkedListRemoveAllEven.add(String.valueOf(elapsedTime));
		}
		linkedListRemoveAllEven.add(String.valueOf(linkedListRemoveAllEvenTestTimes.getAverageTestTime()));
		linkedListRemoveAllEven.add(String.valueOf(bytesToMegabytes(driver.memoryUsage())));

		listOfListRemoveAllEven.add(linkedListRemoveAllEven);
		System.out.println(formatAsTable(listOfListRemoveAllEven));
	}

	private static void printUsecase4(Driver driver) {

		// Use case 4 - AddAllAtIndexZero
		List<List<String>> listOfListAddAllAtIndexZero = new ArrayList<>();

		listOfListAddAllAtIndexZero.add(prepareHeaderRow1());
		listOfListAddAllAtIndexZero.add(prepareHeaderRow2());
		listOfListAddAllAtIndexZero.add(prepareHeaderRow3());

		System.out.println("Running Test: " + TestType.AddAllAtIndexZero.toString());

		List<String> arrayListAddAllAtIndexZero = new ArrayList<>();
		arrayListAddAllAtIndexZero.add(ListType.ArrayBasedList.toString());

		TestTimes arrayListAddAllAtIndexZeroTestTimes = driver.runTestCase(ListType.ArrayBasedList,
				TestType.AddAllAtIndexZero, 10);
		long[] arrayListAddAllAtIndexZeroTestTimesArray = arrayListAddAllAtIndexZeroTestTimes.getTestTimes();
		for (long elapsedTime : arrayListAddAllAtIndexZeroTestTimesArray) {
			arrayListAddAllAtIndexZero.add(String.valueOf(elapsedTime));
		}
		arrayListAddAllAtIndexZero.add(String.valueOf(arrayListAddAllAtIndexZeroTestTimes.getAverageTestTime()));
		arrayListAddAllAtIndexZero.add(String.valueOf(bytesToMegabytes(driver.memoryUsage())));

		listOfListAddAllAtIndexZero.add(arrayListAddAllAtIndexZero);

		List<String> linkedListAddAllAtIndexZero = new ArrayList<>();
		linkedListAddAllAtIndexZero.add(ListType.LinkedList.toString());

		TestTimes linkedListAddAllAtIndexZeroTestTimes = driver.runTestCase(ListType.LinkedList,
				TestType.AddAllAtIndexZero, 10);
		long[] linkedListAddAllAtIndexZeroTestTimesArray = linkedListAddAllAtIndexZeroTestTimes.getTestTimes();
		for (long elapsedTime : linkedListAddAllAtIndexZeroTestTimesArray) {
			linkedListAddAllAtIndexZero.add(String.valueOf(elapsedTime));
		}
		linkedListAddAllAtIndexZero.add(String.valueOf(linkedListAddAllAtIndexZeroTestTimes.getAverageTestTime()));
		linkedListAddAllAtIndexZero.add(String.valueOf(bytesToMegabytes(driver.memoryUsage())));

		listOfListAddAllAtIndexZero.add(linkedListAddAllAtIndexZero);
		System.out.println(formatAsTable(listOfListAddAllAtIndexZero));
	}

	private static void printUsecase3(Driver driver) {
		// Use case 3 - AddAll

		List<List<String>> listOfListAddAll = new ArrayList<>();

		listOfListAddAll.add(prepareHeaderRow1());
		listOfListAddAll.add(prepareHeaderRow2());
		listOfListAddAll.add(prepareHeaderRow3());

		System.out.println("Running Test: " + TestType.AddAll.toString());

		List<String> arrayListAddAll = new ArrayList<>();
		arrayListAddAll.add(ListType.ArrayBasedList.toString());

		TestTimes arrayListAddAllTestTimes = driver.runTestCase(ListType.ArrayBasedList, TestType.AddAll, 10);
		long[] arrayListAddAllTestTimesArray = arrayListAddAllTestTimes.getTestTimes();
		for (long elapsedTime : arrayListAddAllTestTimesArray) {
			arrayListAddAll.add(String.valueOf(elapsedTime));
		}
		arrayListAddAll.add(String.valueOf(arrayListAddAllTestTimes.getAverageTestTime()));
		arrayListAddAll.add(String.valueOf(bytesToMegabytes(driver.memoryUsage())));

		listOfListAddAll.add(arrayListAddAll);

		TestTimes linkedListAddAllTestTimes = driver.runTestCase(ListType.LinkedList, TestType.AddAll, 10);

		List<String> linkedListAddAll = new ArrayList<>();
		linkedListAddAll.add(ListType.LinkedList.toString());

		long[] linkedListAddAllTestTimesArray = linkedListAddAllTestTimes.getTestTimes();
		for (long elapsedTime : linkedListAddAllTestTimesArray) {
			linkedListAddAll.add(String.valueOf(elapsedTime));
		}
		linkedListAddAll.add(String.valueOf(linkedListAddAllTestTimes.getAverageTestTime()));
		linkedListAddAll.add(String.valueOf(bytesToMegabytes(driver.memoryUsage())));

		listOfListAddAll.add(linkedListAddAll);
		System.out.println(formatAsTable(listOfListAddAll));
	}

	private static void printUsecase2(Driver driver) {
		// Use case 2 - AddSortedEven

		List<List<String>> listOfListAddSortedEven = new ArrayList<>();

		listOfListAddSortedEven.add(prepareHeaderRow1());
		listOfListAddSortedEven.add(prepareHeaderRow2());
		listOfListAddSortedEven.add(prepareHeaderRow3());

		System.out.println("Running Test: " + TestType.AddSortedEven.toString());
		List<String> arrayListAddSortedEven = new ArrayList<>();
		arrayListAddSortedEven.add(ListType.ArrayBasedList.toString());
		TestTimes arrayListAddSortedEvenTestTimes = driver.runTestCase(ListType.ArrayBasedList, TestType.AddSortedEven,
				10);
		long[] arrayListAddSortedEvenTestTimesArray = arrayListAddSortedEvenTestTimes.getTestTimes();
		for (long elapsedTime : arrayListAddSortedEvenTestTimesArray) {
			arrayListAddSortedEven.add(String.valueOf(elapsedTime));
		}
		arrayListAddSortedEven.add(String.valueOf(arrayListAddSortedEvenTestTimes.getAverageTestTime()));
		arrayListAddSortedEven.add(String.valueOf(bytesToMegabytes(driver.memoryUsage())));

		listOfListAddSortedEven.add(arrayListAddSortedEven);

		List<String> linkedListAddSortedEven = new ArrayList<>();
		linkedListAddSortedEven.add(ListType.LinkedList.toString());

		TestTimes linkedListAddSortedEvenTestTimes = driver.runTestCase(ListType.LinkedList, TestType.AddSortedEven,
				10);
		long[] linkedListAddSortedEvenTestTimesArray = linkedListAddSortedEvenTestTimes.getTestTimes();
		for (long elapsedTime : linkedListAddSortedEvenTestTimesArray) {
			linkedListAddSortedEven.add(String.valueOf(elapsedTime));
		}
		linkedListAddSortedEven.add(String.valueOf(linkedListAddSortedEvenTestTimes.getAverageTestTime()));
		linkedListAddSortedEven.add(String.valueOf(bytesToMegabytes(driver.memoryUsage())));

		listOfListAddSortedEven.add(linkedListAddSortedEven);
		System.out.println(formatAsTable(listOfListAddSortedEven));
	}

	private static void printUsecase1(Driver driver) {
		// Use case 1 - AddSortedOdd
		List<List<String>> listOfListAddSortedOdd = new ArrayList<>();

		listOfListAddSortedOdd.add(prepareHeaderRow1());
		listOfListAddSortedOdd.add(prepareHeaderRow2());
		listOfListAddSortedOdd.add(prepareHeaderRow3());

		System.out.println("Running Test: " + TestType.AddSortedOdd.toString());
		TestTimes arrayListAddSortedOddTestTimes = driver.runTestCase(ListType.ArrayBasedList, TestType.AddSortedOdd,
				10);
		long[] arrayListAddSortedOddTestTimesArray = arrayListAddSortedOddTestTimes.getTestTimes();

		List<String> arrayListAddSortedOdd = new ArrayList<>();

		arrayListAddSortedOdd.add(ListType.ArrayBasedList.toString());

		for (long elapsedTime : arrayListAddSortedOddTestTimesArray) {
			arrayListAddSortedOdd.add(String.valueOf(elapsedTime));
		}

		arrayListAddSortedOdd.add(String.valueOf(arrayListAddSortedOddTestTimes.getAverageTestTime()));
		arrayListAddSortedOdd.add(String.valueOf(bytesToMegabytes(driver.memoryUsage())));

		listOfListAddSortedOdd.add(arrayListAddSortedOdd);

		TestTimes linkedListAddSortedOddTestTimes = driver.runTestCase(ListType.LinkedList, TestType.AddSortedOdd, 10);
		List<String> linkedListAddSortedOdd = new ArrayList<>();
		linkedListAddSortedOdd.add(ListType.LinkedList.toString());

		long[] linkedListAddSortedOddAddSortedOddTestTimesArray = linkedListAddSortedOddTestTimes.getTestTimes();
		for (long elapsedTime : linkedListAddSortedOddAddSortedOddTestTimesArray) {
			linkedListAddSortedOdd.add(String.valueOf(elapsedTime));
		}
		linkedListAddSortedOdd.add(String.valueOf(linkedListAddSortedOddTestTimes.getAverageTestTime()));
		linkedListAddSortedOdd.add(String.valueOf(bytesToMegabytes(driver.memoryUsage())));
		listOfListAddSortedOdd.add(linkedListAddSortedOdd);
		System.out.println(formatAsTable(listOfListAddSortedOdd));
	}

	@Override
	public ListInterface<Integer> createList(ListType listType, TestType forTestType) {
		ListInterface<Integer> list = null;
		if (listType == ListType.ArrayBasedList) {
			list = new ArrayBasedList<Integer>();
			switch (forTestType) {
			case AddSortedOdd:
				list = this.initializeList(list, 1, 9999, 2);
				break;

			case AddSortedEven:
				list = this.initializeList(list, 2, 10000, 2);
				break;

			case AddAll:
				list = this.initializeList(list, 1, 10000, 1);
				break;

			case AddAllAtIndexZero:
				for (int i = 1; i <= 10000; i += 1) {
					list.add(new Integer(i), 0);
				}
				break;

			case RemoveAllEven:
				list = this.initializeList(list, 1, 10000, 1);
				break;

			case RemoveAllOdd:
				list = this.initializeList(list, 1, 10000, 1);
				break;

			default:
				break;
			}

		} else if (listType == ListType.LinkedList) {
			list = new LinkedList<Integer>();
			switch (forTestType) {
			case AddSortedOdd:
				list = this.initializeList(list, 1, 9999, 2);
				break;

			case AddSortedEven:
				list = this.initializeList(list, 2, 10000, 2);
				break;

			case AddAll:
				list = this.initializeList(list, 1, 10000, 1);
				break;

			case AddAllAtIndexZero:
				for (int i = 1; i <= 10000; i += 1) {
					list.add(new Integer(i), 0);
				}
				break;

			case RemoveAllEven:
				list = this.initializeList(list, 1, 10000, 1);
				break;

			case RemoveAllOdd:
				list = this.initializeList(list, 1, 10000, 1);
				break;

			default:
				break;
			}
		}
		return list;
	}

	@Override
	public ListInterface<Integer> initializeList(ListInterface<Integer> list, int firstNumber, int lastNumber,
			int increment) {
		for (int i = firstNumber; i <= lastNumber; i += increment) {
			list.add(new Integer(i));
		}
		return list;
	}

	@Override
	public double memoryUsage() {
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		return runtime.totalMemory() - runtime.freeMemory();
	}

	@Override
	public TestTimes runTestCase(ListType listType, TestType testType, int numberOfTimes) {

		long startTime = 0;
		ListInterface<Integer> myList = null;
		TestTimes testTimes = new TestTimes();
		testTimes.resetTestTimes();
		for (int i = 0; i < numberOfTimes; i++) {
			switch (listType) {
			case ArrayBasedList:
				switch (testType) {
				case AddSortedOdd:
					startTime = System.nanoTime();
					myList = this.createList(ListType.ArrayBasedList, TestType.AddSortedOdd);
					testTimes.addTestTime(System.nanoTime() - startTime);
					break;

				case AddSortedEven:
					startTime = System.nanoTime();
					myList = this.createList(ListType.ArrayBasedList, TestType.AddSortedEven);
					testTimes.addTestTime(System.nanoTime() - startTime);
					break;

				case AddAll:
					startTime = System.nanoTime();
					myList = this.createList(ListType.ArrayBasedList, TestType.AddAll);
					testTimes.addTestTime(System.nanoTime() - startTime);
					break;

				case AddAllAtIndexZero:
					startTime = System.nanoTime();
					myList = this.createList(ListType.ArrayBasedList, TestType.AddAllAtIndexZero);
					testTimes.addTestTime(System.nanoTime() - startTime);
					break;

				case RemoveAllEven:
					startTime = System.nanoTime();
					myList = this.createList(ListType.ArrayBasedList, TestType.RemoveAllEven);
					for (int j = 2; j <= 10000; j += 2) {
						myList.remove(j);
					}
					testTimes.addTestTime(System.nanoTime() - startTime);
					break;

				case RemoveAllOdd:
					startTime = System.nanoTime();
					myList = this.createList(ListType.ArrayBasedList, TestType.RemoveAllOdd);
					for (int j = 9999; j >= 1; j -= 2) {
						myList.remove(j);
					}
					testTimes.addTestTime(System.nanoTime() - startTime);
					break;

				default:
					break;
				}

				break;

			case LinkedList:

				switch (testType) {
				case AddSortedOdd:
					startTime = System.nanoTime();
					myList = this.createList(ListType.LinkedList, TestType.AddSortedOdd);
					testTimes.addTestTime(System.nanoTime() - startTime);
					break;

				case AddSortedEven:
					startTime = System.nanoTime();
					myList = this.createList(ListType.LinkedList, TestType.AddSortedEven);
					testTimes.addTestTime(System.nanoTime() - startTime);
					break;

				case AddAll:
					startTime = System.nanoTime();
					myList = this.createList(ListType.LinkedList, TestType.AddAll);
					testTimes.addTestTime(System.nanoTime() - startTime);
					break;

				case AddAllAtIndexZero:
					startTime = System.nanoTime();
					myList = this.createList(ListType.LinkedList, TestType.AddAllAtIndexZero);
					testTimes.addTestTime(System.nanoTime() - startTime);
					break;

				case RemoveAllEven:
					startTime = System.nanoTime();
					myList = this.createList(ListType.LinkedList, TestType.RemoveAllEven);
					for (int j = 1; j < 5000; j += 1) {
						boolean remove = myList.remove(j);
					}
					testTimes.addTestTime(System.nanoTime() - startTime);
					break;

				case RemoveAllOdd:
					startTime = System.nanoTime();
					myList = this.createList(ListType.LinkedList, TestType.RemoveAllOdd);
					for (int j = 10000; j > 1; j -= 2) {
						myList.remove(j);
					}
					testTimes.addTestTime(System.nanoTime() - startTime);
					break;

				default:
					break;
				}
				break;

			default:
				break;
			}
		}
		return testTimes;
	}
}