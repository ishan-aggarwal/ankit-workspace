package readexcel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadInputFile {

    public final static List<String> VALID_SUPPLIES = Arrays.asList("food","raft","axe");
    public final static List<String> VALID_OBSTACLES = Arrays.asList("tree","river");

    public static void main(String[] args) throws IOException {

        String input = "D:\\ide-code-workspace\\microservice-test\\src\\main\\java\\readexcel\\input.txt";
        File file = new File(input);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            String tokens[] = st.split(" ");
            List<String> supplies = new ArrayList<>();

            int counter = 0;

            for(String token : tokens) {
                if(counter == 0) {
                    if(token.length() != 1) {
                        throw new IllegalArgumentException("Invalid label");
                    }
                    counter++;
                }

                if(token.equals("river") || token.equals("fallen")) {
                    break;
                }

                if(VALID_SUPPLIES.contains(token)) {
                    supplies.add(token);
                }

            }
        }
    }

}
