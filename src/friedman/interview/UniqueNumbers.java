package friedman.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueNumbers {
	public static void main(String[] args) {
		System.out.println("Enter 10 numbers: ");
		int[] array = new int[10];
		int num;
		Scanner read = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		/*
		 * A Hashset holds unique elements
		 */
		for (int i = 0; i < 10; i++) {
			num = read.nextInt();
			if (!map.containsKey(num)) {
				map.put(num, 1);

			}else{
				map.put(num, map.get(num)+1);
			}

		}
		System.out.println(map.toString());
	}
}
