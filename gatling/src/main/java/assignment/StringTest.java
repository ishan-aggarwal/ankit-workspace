package assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringTest {

    public static void main(String args[])throws IOException {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name,age,gender");
        String str=in.readLine();
        StringTokenizer st=new StringTokenizer(str," ");
        String s1=st.nextToken();
        String s2=st.nextToken();
        String s3=st.nextToken();
        s1=s1.trim();
        s2=s2.trim();
        s3=s3.trim();
        String name=s1;
        int age=Integer.parseInt(s2);
        char gender=s3.charAt(0);
        System.out.println("age " +age);
        System.out.println("gender " +gender);
        System.out.println("name " +name);
    }
}
