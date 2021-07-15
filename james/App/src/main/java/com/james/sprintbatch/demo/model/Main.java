package com.james.sprintbatch.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.james.sprintbatch.demo.model.Employee");
        Employee emp = (Employee) aClass.newInstance();
        emp.setFirstName("ankit");
        System.out.println(emp.getFirstName());
    }
}
