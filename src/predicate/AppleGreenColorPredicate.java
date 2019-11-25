package predicate;

import domain.Apple;

public class AppleGreenColorPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "green".equalsIgnoreCase(apple.getColor());
	}

}
