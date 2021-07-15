package person;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.chrono.IsoChronology;
import java.util.concurrent.ExecutorService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("javadoc")
public class PersonTest
{
    ExecutorService
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private Person fred;
    private Person jane;

    @Before
    public void setUp() throws Exception
    {
        System.setOut(new PrintStream(outContent));
        fred = new Person(
            "Fred",
            IsoChronology.INSTANCE.date(1980, 6, 20),
            Person.Sex.MALE,
            "fred@example.com");
        jane = new Person(
            "Jane",
            IsoChronology.INSTANCE.date(1990, 7, 15),
            Person.Sex.FEMALE,
            "jane@example.com");
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorNameIsNull() {
        fred = new Person(
                null,
                IsoChronology.INSTANCE.date(1980, 6, 20),
                Person.Sex.MALE,
                "fred@example.com");
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorBirthdayIsNull() {
        fred = new Person(
                "Fred",
                null,
                Person.Sex.MALE,
                "fred@example.com");
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorGenderIsNull() {
        fred = new Person(
                "Fred",
                IsoChronology.INSTANCE.date(1980, 6, 20),
                null,
                "fred@example.com");
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorEmailIsNull() {
        fred = new Person(
                "Fred",
                IsoChronology.INSTANCE.date(1980, 6, 20),
                Person.Sex.MALE,
                null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNameIsInvalid() {
        fred = new Person(
                "",
                IsoChronology.INSTANCE.date(1980, 6, 20),
                Person.Sex.MALE,
                "fred@example.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorBirthdayIsEarly() {
        fred = new Person(
                "Fred",
                IsoChronology.INSTANCE.date(1799, 6, 20),
                Person.Sex.MALE,
                "fred@example.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorBirthdayIsLate() {
        fred = new Person(
                "Fred",
                IsoChronology.INSTANCE.date(2500, 6, 20),
                Person.Sex.MALE,
                "fred@example.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorEmailIsEmpty() {
        fred = new Person(
                "Fred",
                IsoChronology.INSTANCE.date(1980, 6, 20),
                Person.Sex.MALE,
                "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorEmailNoAt() {
        fred = new Person(
                "Fred",
                IsoChronology.INSTANCE.date(1980, 6, 20),
                Person.Sex.MALE,
                "fredexample.com");
    }

    @Test
    public void testToString() {
        System.out.println(fred);
    }


    @Test
    public void testGetName() {
        assertEquals("Fred", fred.getName());
        assertEquals("Jane", jane.getName());
    }

    @Test
    public void testGetBirthday() {
        assertEquals(IsoChronology.INSTANCE.date(1980, 6, 20), fred.getBirthday());
        assertEquals(IsoChronology.INSTANCE.date(1990, 7, 15), jane.getBirthday());
    }

    @Test
    public void testGetGender() {
        assertEquals(Person.Sex.MALE, fred.getGender());
        assertEquals(Person.Sex.FEMALE, jane.getGender());
    }

    @Test
    public void testGetEmail() {
        assertEquals("fred@example.com", fred.getEmailAddress());
        assertEquals("jane@example.com", jane.getEmailAddress());
    }

    @Test
    public void testGetAge() {
        assertTrue(fred.getAge() >= 35);
        assertTrue(jane.getAge() >= 25);
    }

    @Test
    public void testEnumSex() {
        assertEquals(Person.Sex.MALE, Person.Sex.valueOf("MALE"));
        assertEquals(2, Person.Sex.values().length);
    }

}
