import java.util.Optional;

import domain.Car;
import domain.Insurance;
import domain.Person;

public class MainOptional {

	public static void main(String[] args) {
		Person person1 = new Person();
		Optional<Person> person = Optional.ofNullable(person1);
		String insuraneName = getInsurance(person);
		System.out.println(insuraneName);
	}

	/**
	 * How it would look like without optional
	 */
//	public String nullChecksGetInsurance(Person person) {
//		if (person != null) {
//			Car car = person.getCar();
//			if (car != null) {
//				Insurance insurance = car.getInsurance();
//				if (insurance != null) {
//					return insurance.getName();
//				}
//			}
//		}
//		return "Unknown";
//	}

	public static String getInsurance(Optional<Person> person) {
		return person.flatMap(Person::getCar)
				.flatMap(Car::getInsurance)
				.map(Insurance::getName)
				.orElse("Unknown");
	}

}
