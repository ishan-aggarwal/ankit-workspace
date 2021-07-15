package bhabhi;

public class Test {

    public static void main(String[] args) {
        String str = "715K 2009-09-23 system.zip~\n"+
                    "179M 2013-08-14 to-do-list.xml~\n"+
                    "179 2013-08-14 to-do-list.xml~";
        String[] split = str.split("\n");
        for(String s : split) {
            String[] s1 = s.split(" ");
            String size = s1[0];
            int totalSize = 0;
            if(isNumeric(size)) {
                System.out.println("byte");
                totalSize = Integer.valueOf(size);
            } else if(size.toLowerCase().contains("k")) {
                String newStr = size.toLowerCase().replace("k", "");
                Integer integer = Integer.valueOf(newStr);
                totalSize = integer*1024;

                System.out.println("kb");
            } else if(size.toLowerCase().contains("m")) {
                String newStr = size.toLowerCase().replace("m", "");
                Integer integer = Integer.valueOf(newStr);
                totalSize = integer*1024*1024;
                System.out.println("mb");
            }
            int threshold = 14 * (2 ^ 20);
            if(totalSize > threshold) {
                System.out.println();
                //return
            }

        }

    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
