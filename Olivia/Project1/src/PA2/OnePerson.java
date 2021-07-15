package PA2;

public class OnePerson {

    private String firstName;
    private String lastName;
    private String major;
    private String gpa;

    public OnePerson() {
    }

    public OnePerson(String fName, String lName, String pMajor, String pGpa) {
        firstName = fName;
        lastName = lName;
        major = pMajor;
        gpa = pGpa;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String fName) {
        firstName = fName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lName) {
        lastName = lName;
    }

    public final String getMajor() {
        return major;
    }

    public final void setMajor(String pMajor) {
        major = pMajor;
    }

    public final String getGpa() {
        return gpa;
    }

    public final void setGpa(String pGpa) {
        gpa = pGpa;
    }
}
