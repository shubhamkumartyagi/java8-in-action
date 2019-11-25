import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import domain.Apple;
import formatter.AppleFancyFormatter;
import formatter.AppleFormatter;
import predicate.ApplePredicate;
import predicate.AppleRedAndHeavyPredicate;

public class Main {

	public static void main(String[] args) {
		List<Apple> inventory = sampleApples();
		List<Apple> result = filterGreenApples(inventory);
		System.out.println(result.toString());
		List<Apple> redApplesWithLessThan150 = filterApples(inventory, new AppleRedAndHeavyPredicate());
		System.out.println(redApplesWithLessThan150);
		appleFormatter(inventory, new AppleFancyFormatter());
		List<Apple> filteredBlueApples = filterApples(inventory,
				(Apple apple) -> "blue".equalsIgnoreCase(apple.getColor()));
		System.out.println(filteredBlueApples);

	}

	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if ("green".equalsIgnoreCase(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public static <T> List<T> filterApples(List<T> inventory, Predicate<T> predicate) {
		List<T> result = new ArrayList<T>();
		for (T element : inventory) {
			if (predicate.test(element)) {
				result.add(element);
			}
		}
		return result;
	}

	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (predicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static void appleFormatter(List<Apple> inventory, AppleFormatter formatter) {
		for (Apple apple : inventory) {
			String result = formatter.accept(apple);
			System.out.println(result);
		}
	}

	public static List<Apple> sampleApples() {
		Apple apple1 = new Apple();
		apple1.setColor("green");
		apple1.setWeight(180);
		Apple apple2 = new Apple();
		apple2.setColor("red");
		apple2.setWeight(200);
		Apple apple3 = new Apple();
		apple3.setColor("blue");
		apple3.setWeight(180);
		Apple apple4 = new Apple();
		apple4.setColor("green");
		apple4.setWeight(140);
		Apple apple5 = new Apple();
		apple5.setColor("red");
		apple5.setWeight(180);
		Apple apple6 = new Apple();
		apple6.setColor("red");
		apple6.setWeight(140);
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(apple1);
		apples.add(apple2);
		apples.add(apple3);
		apples.add(apple4);
		apples.add(apple5);
		apples.add(apple6);
		return apples;
	}

}
