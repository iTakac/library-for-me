package src.algorithm.fibonacci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {

	private static final Map<Integer,Long> FIB_MAP = new HashMap<>();
	static {
		FIB_MAP.put(0, 0L);
		FIB_MAP.put(1, 1L);
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		long start = System.currentTimeMillis();
		long answer = fib(num);
		long end = System.currentTimeMillis();
		System.out.println("answer_memo =" + answer);
		System.out.println("process_time =" + (end - start));


	}

	private static long fib(int num) {

		long sum;

		if (FIB_MAP.get(num) != null) {
			sum = FIB_MAP.get(num);
		} else {
			sum = fib(num - 1) + fib(num - 2);
			FIB_MAP.put(num, sum);

		}

		return sum;
	}
}
