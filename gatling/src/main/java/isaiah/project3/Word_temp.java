package isaiah.project3;

public class Word_temp
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
        if(letter != null
                && letter.length() == 1){
            char letterTocCheck = letter.charAt(0);
            //applying switch case to check if the letter is vowel
            switch(letterTocCheck)
            {
                case 'a' :
                case 'e' :
                case 'i' :
                case 'o' :
                case 'u' :
                case 'y' :
                case 'A' :
                case 'E' :
                case 'I' :
                case 'O' :
                case 'U' :
                case 'Y' : isVowel = true; //setting the flag to true if the letter is vowel
            }
        }
        return isVowel;
    }
}
