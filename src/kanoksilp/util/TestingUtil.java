package kanoksilp.util;

/**
 * Useful codes for testing purposes.
 *
 * @author Kanoksilp
 */
public class TestingUtil {

	/**
	 * Equivalent to: System.out.println(message);
	 *
	 * @param message
	 */
	public static void out(Object message) {
		System.out.println(message);
	}

	/**
	 * Equivalent to: System.out.printf(format, args);
	 *
	 * @param format
	 * @param args
	 */
	public static void out(String format, Object... args) {
		System.out.printf(format, args);
	}

	/**
	 * Equivalent to: System.out.println(message); with leading tabs
	 *
	 * @param indent Number of leading tabs.
	 * @param message
	 */
	public static synchronized void out(int indent, Object message) {
		for (int i = 0; i < indent; i++) {
			System.out.print("\t");
		}
		System.out.println(message);
	}

	/**
	 * Equivalent to: System.err.println(message);
	 *
	 * @param message
	 */
	public static void err(Object message) {
		System.err.println(message);
	}

	/**
	 * Equivalent to: System.err.printf(format, args);
	 *
	 * @param format
	 * @param args
	 */
	public static void err(String format, Object... args) {
		System.err.printf(format, args);
	}

	/**
	 * Class containing methods for measuring time used for a code to run.
	 */
	public static class TimingUtil {

		private static final int DEFAULT_ITERATION = 10;

		/**
		 * Measure time used for a code to run.
		 *
		 * @param testCase a code to run.
		 * @return average time (in nanoseconds) used by the code.
		 */
		public static synchronized int measureTestCase(TestCase testCase) {
			return measureTestCase("", DEFAULT_ITERATION, testCase);
		}

		/**
		 * Measure time used for a code to run.
		 *
		 * @param title a title for this test, just for displaying result only.
		 * @param testCase a code to run.
		 * @return average time (in nanoseconds) used by the code.
		 */
		public static synchronized int measureTestCase(String title, TestCase testCase) {
			return measureTestCase(title, DEFAULT_ITERATION, testCase);
		}

		/**
		 * Measure time used for a code to run.
		 *
		 * @param title a title for this test, just for displaying result only.
		 * @param iteration testing iteration.
		 * @param testCase a code to run.
		 * @return average time (in nanoseconds) used by the code.
		 */
		public static synchronized int measureTestCase(String title, int iteration, TestCase testCase) {
			//ArrayList<Integer> dts = new ArrayList<>();
			long dt_sum = 0;

			System.out.println("Measuring test case: " + title);
			System.out.println("Iteration: " + iteration);

			for (int i = 0; i < iteration; i++) {
				long dt = System.nanoTime();
				testCase.perform();
				dt = System.nanoTime() - dt;

				//dts.add((int) dt);
				dt_sum += dt;
			}
			long dt_avg = dt_sum / iteration;

			//System.out.println("Time used (ns): " + dts);
			System.out.println("Average time used (ns): " + dt_avg);

			return (int) dt_avg;
		}

		/**
		 * Functional interface for measureTestCase method.
		 */
		public static interface TestCase {

			/**
			 * The codes to be measured are put here.
			 */
			void perform();
		}

	}

}
