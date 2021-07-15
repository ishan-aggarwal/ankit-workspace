package abhimanyu;

import java.io.*;

public class FileIO {

    public static void main(String[] args) throws IOException {



        final String fileName = "file1.txt";
        DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream(fileName));
        for(int i=0;i<10;i++) {
            dataOutput.writeInt(i);
        }
        DataInputStream dataInput = new DataInputStream(new FileInputStream(fileName));

        try {
        while (true) {
            System.out.println(dataInput.readInt());
        }
        } catch (EOFException ex) {
            // reach end of file
        }
    }
}
