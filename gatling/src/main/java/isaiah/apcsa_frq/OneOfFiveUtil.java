package isaiah.apcsa_frq;

//problem 2b.
public class OneOfFiveUtil {

    /**
     * @param str is a String
     *            Precondition: Length of str is at least 5 characters.
     * @return String consisting of one of the last 5 characters in
     * str.
     * Postcondition: str is unchanged
     */
    public static String getOneOfFive(String str) {

        //finding length of the string
        int strLength = str.length();

        //finding first and last -> range for finding the random number
        int last = strLength;
        int first = strLength-5;


        //finding the random number using the method created in problem 2a.
        int randomIndex = RandomIntegerGeneratorUtil.getRandomInteger(first,last);

        //returning the character at the random index
        return String.valueOf(str.charAt(randomIndex));
    }

    public static void main(String[] args) {

        System.out.println("getOneOfFive(“Boilers”) Result: "+getOneOfFive("Boilers"));
        System.out.println("getOneOfFive(“Boilers”) Result: "+getOneOfFive("Boilers"));
        System.out.println("getOneOfFive(“Boilers”) Result: "+getOneOfFive("Boilers"));

        System.out.println("getOneOfFive(“I win”) Result: "+getOneOfFive("I win"));
        System.out.println("getOneOfFive(“I win”) Result: "+getOneOfFive("I win"));
        System.out.println("getOneOfFive(“I win”) Result: "+getOneOfFive("I win"));

        System.out.println("getOneOfFive(“bcdefghijklm”) Result: "+getOneOfFive("bcdefghijklm"));
        System.out.println("getOneOfFive(“bcdefghijklm”) Result: "+getOneOfFive("bcdefghijklm"));
        System.out.println("getOneOfFive(“bcdefghijklm”) Result: "+getOneOfFive("bcdefghijklm"));

    }

}
