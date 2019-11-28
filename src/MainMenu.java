import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import domain.Dish;

public class MainMenu {

	public static void main(String[] args) {

		List<String> threeHighCaloricDishNames = getMenu().stream().filter((Dish dish) -> dish.getCalories() > 300)
				.map(Dish::getName).limit(3).collect(Collectors.toList());
		System.out.println(threeHighCaloricDishNames);

		List<String> sortedBasedOnCalories = getMenu().stream().sorted(Comparator.comparing(Dish::getCalories))
				.map(Dish::getName).collect(Collectors.toList());
		System.out.println(sortedBasedOnCalories);

		List<Dish> vegetarianDishes = getMenu().stream().filter(Dish::isVegetarian).collect(Collectors.toList());
		System.out.println(vegetarianDishes);

		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

		List<String> dishNames = getMenu().stream().map(Dish::getName).collect(Collectors.toList());
		dishNames.stream().forEach(System.out::println);

		getMenu().stream().map(dish -> dish.getName().length()).forEach(System.out::println);

		List<String> uniqueCharacters = getWords().stream().map(s -> s.split("")).flatMap(Arrays::stream).distinct()
				.collect(Collectors.toList());
		uniqueCharacters.stream().forEach(System.out::println);

	}

	public static List<Dish> getMenu() {
		return Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER), new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER), new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));
	}

	public static List<String> getWords() {
		String[] arrayOfWords = { "Goodbye", "World", "Hello", "World", "Again" };
		return Arrays.asList(arrayOfWords);
	}

}
