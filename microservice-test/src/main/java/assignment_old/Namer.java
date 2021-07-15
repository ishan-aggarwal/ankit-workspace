package assignment_old;

public class Namer {
    final private String firstName, lastName;
    public Namer(String fn,String ln) {
        firstName = fn;
        lastName = ln;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

