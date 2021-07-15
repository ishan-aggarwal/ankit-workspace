package isaiah.project3;

public class Word
{
    /**
     Tests whether a letter is a vowel
     @param letter a string of length 1
     @return true if letter is a vowel
     */
    public boolean isVowel (String letter)
    {
        //setting the flag to default value of false.
        boolean isVowel = false;

        //check whether the input is valid or not
        //checking if the input string is not null and is of length 1
        if(letter != null && letter.length() == 1){
            //converting the input letter to lower case
            letter = letter.toLowerCase();
            //applying switch case to check if the letter is vowel
            switch(letter)
            {
                case "a" :
                case "e" :
                case "i" :
                case "o" :
                case "u" :
                case "y" : isVowel = true; //setting the flag to true if the letter is vowel
            }
        }
        return isVowel;
    }

    //checking if the letter is vowel using the string function-contains
    public boolean isVowelUsingContainsMethod (String letter)
    {
        //creating a string having all the vowels
        String vowels = "aeiouy";

        //setting the flag to default value of false.
        boolean isVowel = false;

        //check whether the input is valid or not
        //checking if the input string is not null and is of length 1
        if(letter != null && letter.length() == 1){
            //converting the input letter to lower case
            letter = letter.toLowerCase();

            if(vowels.contains(letter)) {
                isVowel = true;
            }
        }
        return isVowel;
    }
}
