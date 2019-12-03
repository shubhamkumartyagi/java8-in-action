package domain;

public class Insurance {

	// if insurance is there, company name is mandatory so we don't need optional
	// here, if it is null check the main problem why it is null.
	private String name;

	public String getName() {
		return name;
	}
}
