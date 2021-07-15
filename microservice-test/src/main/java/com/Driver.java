//package com;
//
///**
// *
// * @author Sameh A. Fakhouri
// *
// */
//public class Driver implements DriverInterface {
//
//	private static final long MEGABYTE = 1024L * 1024L;
//
//	public static double bytesToMegabytes(double bytes) {
//		return bytes / MEGABYTE;
//	}
//
//	public static void main(String[] args) {
//
//		Driver driver = new Driver();
//		TestTimes testTimes = driver.runTestCase(ListType.ArrayBasedList, TestType.AddSortedOdd, 10);
//		long[] allArrayTestTimes = testTimes.getTestTimes();
//		System.out.println("Testcase: " + TestType.AddSortedOdd.toString());
//		for (long elapsedTime : allArrayTestTimes) {
////			System.out.println(TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS));
//			System.out.println(elapsedTime);
//		}
//		System.out.println(testTimes.getAverageTestTime());
//		System.out.println(bytesToMegabytes(driver.memoryUsage()));
//
//		testTimes = driver.runTestCase(ListType.ArrayBasedList, TestType.AddSortedEven, 10);
//		allArrayTestTimes = testTimes.getTestTimes();
//		System.out.println("Testcase: " + TestType.AddSortedEven.toString());
//		for (long elapsedTime : allArrayTestTimes) {
////			System.out.println(TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS));
//			System.out.println(elapsedTime);
//		}
//		System.out.println(testTimes.getAverageTestTime());
//		System.out.println(bytesToMegabytes(driver.memoryUsage()));
//
//	}
//
//	@Override
//	public ListInterface<Integer> createList(ListType listType, TestType forTestType) {
//		ListInterface<Integer> list = null;
//		if (listType == ListType.ArrayBasedList) {
//			list = new ArrayBasedList<Integer>();
//			switch (forTestType) {
//				case AddSortedOdd:
//					list = this.initializeList(list, 1, 9999, 2);
//					break;
//
//				case AddSortedEven:
//					list = this.initializeList(list, 2, 10000, 2);
//					break;
//
//				case AddAll:
//					list = this.initializeList(list, 1, 10000, 1);
//					break;
//
//				case AddAllAtIndexZero:
//					for (int i = 1; i <= 10000; i += 1) {
//						list.add(new Integer(i), 0);
//					}
//					break;
//
//				default:
//					break;
//			}
//
//		} else if (listType == ListType.LinkedList) {
//			list = new LinkedList<Integer>();
//			switch (forTestType) {
//				case AddSortedOdd:
//					list = this.initializeList(list, 1, 9999, 2);
//					break;
//
//				case AddSortedEven:
//					list = this.initializeList(list, 2, 10000, 2);
//					break;
//
//				case AddAll:
//					list = this.initializeList(list, 1, 10000, 1);
//					break;
//
//				case AddAllAtIndexZero:
//					for (int i = 1; i <= 10000; i += 1) {
//						list.add(new Integer(i), 0);
//					}
//					break;
//
//				default:
//					break;
//			}
//		}
//		return list;
//	}
//
//	@Override
//	public ListInterface<Integer> initializeList(ListInterface<Integer> list, int firstNumber, int lastNumber,
//												 int increment) {
//		for (int i = firstNumber; i <= lastNumber; i += increment) {
//			list.add(new Integer(i));
//		}
//		return list;
//	}
//
//	@Override
//	public double memoryUsage() {
//
//		Runtime runtime = Runtime.getRuntime();
//		// Run the garbage collector
//		runtime.gc();
//		// Calculate the used memory
//		long memory = runtime.totalMemory() - runtime.freeMemory();
//		return memory;
//	}
//
//	@Override
//	public TestTimes runTestCase(ListType listType, TestType testType, int numberOfTimes) {
//
//		long startTime = 0;
//		ListInterface<Integer> myList = null;
//		TestTimes testTimes = new TestTimes();
//		testTimes.resetTestTimes();
//		for (int i = 0; i < numberOfTimes; i++) {
//			switch (listType) {
//				case ArrayBasedList:
//					switch (testType) {
//						case AddSortedOdd:
//							startTime = System.nanoTime();
//							myList = this.createList(ListType.ArrayBasedList, TestType.AddSortedOdd);
//							testTimes.addTestTime(System.nanoTime() - startTime);
//							break;
//
//						case AddSortedEven:
//							startTime = System.nanoTime();
//							myList = this.createList(ListType.ArrayBasedList, TestType.AddSortedEven);
//							testTimes.addTestTime(System.nanoTime() - startTime);
//							break;
//
//						case AddAll:
//							startTime = System.nanoTime();
//							myList = this.createList(ListType.ArrayBasedList, TestType.AddAll);
//							testTimes.addTestTime(System.nanoTime() - startTime);
//							break;
//
//						case AddAllAtIndexZero:
//							startTime = System.nanoTime();
//							myList = this.createList(ListType.ArrayBasedList, TestType.AddAllAtIndexZero);
//							testTimes.addTestTime(System.nanoTime() - startTime);
//							break;
//
//						default:
//							break;
//					}
//
//					break;
//
//				case LinkedList:
//
//					switch (testType) {
//						case AddSortedOdd:
//							startTime = System.nanoTime();
//							myList = this.createList(ListType.ArrayBasedList, TestType.AddSortedOdd);
//							testTimes.addTestTime(System.nanoTime() - startTime);
//							break;
//
//						case AddSortedEven:
//							startTime = System.nanoTime();
//							myList = this.createList(ListType.ArrayBasedList, TestType.AddSortedEven);
//							testTimes.addTestTime(System.nanoTime() - startTime);
//							break;
//
//						case AddAll:
//							startTime = System.nanoTime();
//							myList = this.createList(ListType.ArrayBasedList, TestType.AddAll);
//							testTimes.addTestTime(System.nanoTime() - startTime);
//							break;
//
//						case AddAllAtIndexZero:
//							startTime = System.nanoTime();
//							myList = this.createList(ListType.ArrayBasedList, TestType.AddAllAtIndexZero);
//							testTimes.addTestTime(System.nanoTime() - startTime);
//							break;
//
//						default:
//							break;
//					}
//
//					break;
//				default:
//					break;
//			}
//		}
//		return testTimes;
//	}
//}