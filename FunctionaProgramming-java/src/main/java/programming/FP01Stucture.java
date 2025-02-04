package programming;

import java.util.List;

public class FP01Stucture {
	public static void main(String[] args) {

		printAllnumbersInList(List.of(12, 9, 12, 3, 4, 52, 1, 31));
		System.out.println("Hello");
	}
	
	private static void printAllnumbersInList(List<Integer> numbers) {
		
		//list into stream
//		numbers.stream()
//		.filter(n-> n%2!=0)
//		.forEach(System.out::println);
				
		numbers.stream()
		.map(n->n*n)
		.forEach(System.out::println);


	}

}
