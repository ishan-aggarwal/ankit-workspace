package person;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public final class Person implements Comparable<Person> {

	public enum Sex {
		MALE, FEMALE
	}

	private final String name;
	private final LocalDate birthday;
	private final Sex gender;
	private final String emailAddress;

	public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {

		if (anyAreNull(name, birthday, gender, emailAddress)) {
			throw new NullPointerException();
		}

		if (anyAreInvalid(name, birthday, emailAddress)) {
			throw new IllegalArgumentException();
		}

		this.name = name;
		this.birthday = LocalDate.from(birthday);
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "(" + name + ", " + birthday + ", " + gender + ", " + emailAddress + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + birthday.hashCode();
		result = prime * result + emailAddress.hashCode();
		result = prime * result + gender.hashCode();
		result = prime * result + name.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person that = (Person) obj;
		if (!this.name.equals(that.name))
			return false;
		if (!this.birthday.equals(that.birthday))
			return false;
		if (this.gender != that.gender)
			return false;
		if (!this.emailAddress.equals(that.emailAddress))
			return false;
		return true;
	}

	private boolean anyAreInvalid(String name, LocalDate birthday, String emailAddress) {
		return name.equals("") || birthday.compareTo(IsoChronology.INSTANCE.date(1800, 1, 1)) < 0
				|| birthday.compareTo(IsoChronology.INSTANCE.dateNow()) > 0 || emailAddress.equals("")
				|| !emailAddress.contains("@");
	}

	private boolean anyAreNull(String name, LocalDate birthday, Sex gender, String emailAddress) {
		return name == null || birthday == null || gender == null || emailAddress == null;
	}

	public int getAge() {
		return birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
	}

	public void printPerson() {
		System.out.println(name + ", " + this.getAge());
	}

	public Sex getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public LocalDate getBirthday() {
		return LocalDate.from(birthday);
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	public static List<Person> createRoster() {

		List<Person> roster = new ArrayList<>();
		roster.add(new Person("Fred", IsoChronology.INSTANCE.date(1980, 6, 20), Sex.MALE, "fred@example.com"));
		roster.add(new Person("Jane", IsoChronology.INSTANCE.date(1990, 7, 15), Sex.FEMALE, "jane@example.com"));
		roster.add(new Person("George", IsoChronology.INSTANCE.date(1991, 8, 13), Sex.MALE, "george@example.com"));
		roster.add(new Person("Bob", IsoChronology.INSTANCE.date(2000, 9, 12), Sex.MALE, "bob@example.com"));

		return roster;
	}

	@Override
	public int compareTo(Person that) {
		if (!this.name.equals(that.name)) {
			return this.name.compareTo(that.name);
		}
		if (!this.birthday.equals(that.birthday)) {
			return this.birthday.compareTo(that.birthday);
		}
		if (this.gender != that.gender) {
			return this.gender.compareTo(that.gender);
		}
		if (!this.emailAddress.equals(that.emailAddress)) {
			return this.emailAddress.compareTo(that.emailAddress);
		}
		return 0;
	}
}