//package yomi;
//
//import java.util.Scanner;
//
//public class Hash {
//
//    public static void main(String[] args) {
//        System.out.print("Enter a string : ");
//        Scanner scanner = new Scanner(System.in);
//        String markdown = scanner.nextLine();   //read string
//        int k = markdown.lastIndexOf('#'), count = 0;//find last occurence of # then take the next part
//        String s2 = "", s3 = "";
//        for (int i = 0; i < markdown.length(); i++) {
//            if (markdown.charAt(i) == '#')
//                count++;//count the occurence of # of level of heading h1,h2,h3,....
//        }
//        for (int j = k + 1; j < markdown.length(); j++) {
//            s2 += markdown.charAt(j);//take the remainging string after #
//        }
//// System.out.println(k);
//
////System.out.println(count);
//        if (count <= 6)//if it is valid heading
//        {
//            s3 = "<h" + count + ">" + s2 + "</h" + count + ">";
//            s3.la
//            System.out.println(s3);
//        } else
//
//            System.out.println("Invalid header");
//
//    }
//}