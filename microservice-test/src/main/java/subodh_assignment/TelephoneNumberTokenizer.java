package subodh_assignment;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneNumberTokenizer {

    private static List<String> validCountryCodes = List.of("+1", "+380", "+81", "+86", "+248", "+238","+91");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        String splitTokens1[], splitTokens2[];
        String areaCode, firstThreeDigits, lastFourDigits;
        try {
            do {
                System.out.println("Enter telephone number in format '(XXX) XXX-XXXX' or enter 'exit' to exit: ");
                userInput = scanner.nextLine();

                if ("exit".equalsIgnoreCase(userInput)) {
                    System.out.println("Bye..");
                    break;
                }
                //Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
                Pattern pattern = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
                Matcher matcher = pattern.matcher(userInput.trim());

                if(!matcher.matches()) {
                    System.out.println("Invalid Number. Please enter number in valid format '(XXX) XXX-XXXX'");
                    continue;
                }

                //spliting by space
                splitTokens1 = userInput.split(" ");

                String countryCode = splitTokens1[0];

                if(!validCountryCodes.contains(countryCode.trim())) {
                    System.out.println("Invalid country code. Allowed country codes: " +
                            "US (+1), Ukraine (+380), Japan (+81), China (+86), Seychelles (+248), Cape Verde (+238), India (+91)");
                    continue;
                }

                //area code
                areaCode = splitTokens1[1].substring(1, 4);

                splitTokens2 = splitTokens1[2].split("-");

                //first three digits
                firstThreeDigits = splitTokens2[0];

                // getting the last four digits
                lastFourDigits = splitTokens2[1];

                //printing output on console
                System.out.println("Country code : " + countryCode);
                System.out.println("Area code : " + areaCode);
                System.out.println("Phone number : " + firstThreeDigits + lastFourDigits);
                System.out.println("Complete Phone number (Area code + Phone number) : "
                        + areaCode + " " + firstThreeDigits + lastFourDigits);
            } while (true);
        } finally {
            scanner.close();
        }
    }
}