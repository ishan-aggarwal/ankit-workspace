package edu.ncsu.csc216.service_wolf.model.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RecordReaderTest {

    public static void main(String[] args) throws IOException {
        String input = "ts-test-files/" +"parse_invalid.txt";
        File file = new File(input);
        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        String st;
        int counter = 0;
        while ((st = br.readLine()) != null) {
            if(counter == 0) {
                if(!st.contains("SENDER")) {
                    throw new IllegalArgumentException("Invalid File.");
                }
            } else if(counter == 1) {
                if(!st.contains("FILEOPENDATE")) {
                    throw new IllegalArgumentException("Invalid File.");
                }
            } else {
                sb.append(st).append("\n");
            }
            counter++;
        }
        System.out.println(sb.toString());

    }

}
