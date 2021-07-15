package isaiah.apcsa_frq;

//problem 1
public class FixNameUtil {

    /* @param fullName is a String in the format “lastName, firstName”
     * Precondition: fullName will contain at least one character before the
     * String “, ” and at least one character after.
     * @return String in the format “firstName lastName”
     * Postcondition: a fixed String version of fullName
     * */
    public static String fixName(String fullName) {

        //find the index of the seperator - ',' (comma)
        int indexOfDelimiter = fullName.indexOf(",");

        //finding last name from the string using the index value of comma.
        //last name wil be from 0 to the index of comma
        String lastName = fullName.substring(0, indexOfDelimiter).trim();

        //first name wil be from the index of comma to the length of the string
        String firstName = fullName.substring(indexOfDelimiter+1, fullName.length()).trim();

        //returning the string with first name and last name with space in between them
        return firstName + " " + lastName;
    }

    public static void main(String[] args) {
        String input1 = "Hampton, Mark";
        System.out.println("Input1: "+input1);
        System.out.println("Output1: "+fixName(input1));

        String input2 = "Trump, Donald";
        System.out.println("Input2: "+input2);
        System.out.println("Output2: "+fixName(input2));
    }

}
