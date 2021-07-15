package com;

/**
 *
 * @author Sameh A. Fakhouri
 *
 */
public class TestTimes implements TestTimesInterface {

	private long[] testTimes = new long[10];
	private int position = -1;

	@Override
	public long getLastTestTime() {
		if (position != -1) {
			return this.testTimes[position];
		} else {
			return -1;
		}
	}

	@Override
	public long[] getTestTimes() {
		long[] list = new long[10];
		for (int x = 0; x < this.testTimes.length; x++) {
			list[x] = this.testTimes[x];
		}
		return list;
	}

	@Override
	public void resetTestTimes() {
		for (int x = 0; x < this.testTimes.length; x++) {
			this.testTimes[x] = 0;
		}

		this.position = 0;

	}

	@Override
	public void addTestTime(long testTime) {
		if (position == 9) {
			for (int x = 0; x < (this.testTimes.length - 1); x++) {
				this.testTimes[x] = this.testTimes[x + 1];
			}
			testTimes[9] = testTime;
		} else {
			testTimes[++position] = testTime;
		}
	}

	@Override
	public double getAverageTestTime() {
		if (this.position != -1) {
			double total = 0;
			for (int x = 0; x <= this.position; x++) {
				total += this.testTimes[x];
			}
			double avg = total / (this.position + 1);
			return avg;
		} else {
			return 0.0;
		}
	}

}