package aron;

import assignment_old.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class InputStreamTest {

    public static int foo(String fileName) throws IOException {
        int b = 0;
        try(InputStream is = new FileInputStream(fileName)){
            b = is.read()+5;
        }
        return b;
    }



    public static void main(String[] args) throws IOException {
        ArrayList<Test> objs = new ArrayList<>();
        HashMap map;
        Object a = new Object();
        for (int i=1; i<10; i++){
            Object b = new Object();
            //objs.add(b);
        }
    }

}
