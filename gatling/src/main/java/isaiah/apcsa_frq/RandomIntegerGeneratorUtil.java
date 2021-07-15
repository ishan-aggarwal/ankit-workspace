package isaiah.apcsa_frq;

import java.util.Random;

//problem 2a.
public class RandomIntegerGeneratorUtil {

    /**
     * @param first is an integer, last is an integer
     *              Precondition: first < last
     * @return random integer x in the range [first,last]
     * Postcondition: first ≤ x ≤ last
     */
    public static int getRandomInteger(int first, int last) {
        Random r = new Random();
        return r.nextInt(last-first) + first;
    }

    public static void main(String[] args) {
        System.out.println(" getRandomInteger(4,5) Result:  "+ getRandomInteger(4,5));
        System.out.println(" getRandomInteger(4,5) Result:  "+ getRandomInteger(4,5));

        System.out.println(" getRandomInteger(10,20) Result:  "+ getRandomInteger(10,20));
        System.out.println(" getRandomInteger(10,20) Result:  "+ getRandomInteger(10,20));
        System.out.println(" getRandomInteger(10,20) Result:  "+ getRandomInteger(10,20));

        System.out.println(" getRandomInteger(-10,5) Result:  "+ getRandomInteger(-10,5));

    }

}
