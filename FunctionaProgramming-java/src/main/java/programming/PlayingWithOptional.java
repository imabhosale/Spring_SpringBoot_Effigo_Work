package programming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlayingWithOptional {
	
	public static void main(String[] args) {
		List<String> fruits=List.of("apple","banana","mango");
		
		Predicate<? super String> predicate = fruit-> fruit.startsWith("c");
		Optional<String> optinal = fruits.stream()
		.filter(predicate)
		.findFirst();
		
		System.out.println(optinal);
		System.out.println(optinal.isEmpty());
		System.out.println(optinal.isPresent());
		System.out.println(optinal.get());
		
		
		//instead of using null for empty values 
		//we can go for optional
		
	}

}
