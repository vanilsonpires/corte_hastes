package core;

public class CorteHartes {

	public static int divideRod(int[] values, int[] answers, int n) {
		if (n == 0)
			return 0;
		if (answers[n] != -1)
			return answers[n];
		int max = -1, ans;
		for (int i = 1; i <= n; i++) {
			ans = values[i] + divideRod(values, answers, n - i);
			if (ans > max)
				max = ans;

		}
		answers[n] = max;
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] values = { 0, 1, 5, 8, 9, 10, 17, 17, 20 };
		int n = values.length - 1;
		int[] answers = new int[values.length];
		for (int i = 0; i < answers.length; i++)
			answers[i] = -1;
		System.out.println(divideRod(values, answers, n));
	}

}
