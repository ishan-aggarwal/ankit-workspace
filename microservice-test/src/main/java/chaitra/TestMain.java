package chaitra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain {

    //filter
    public void filter(List<Employee> employeesList) {

        for(Employee employee: employeesList) {
            if(employee.getSalary()>20000) {
                //add in a list
            }
        }

        return;
    }

    public static void main(String[] args) {
//
////        Employee e1 = new Employee(1,"test1", 10000);
////        Employee e2 = new Employee(2,"test2", 20000);
////        Employee e3 = new Employee(3,"test3", 30000);
////        Employee e4 = new Employee(4,"test4", 40000);
//
//        ArrayList<Employee> employees = new ArrayList<>(Arrays.asList(e1, e2, e3, e4));
//
//
//
////        List<Double> collect = employees
////                .stream()
////                .filter(employee -> {
////
////                    return employee.getSalary() > 20000;
////                })
////                .map(emp -> emp.getSalary()).collect(Collectors.toList());
//
//        // employeeStream.collect(Collectors.toList());
//
//      //  List<String> collect = employees.stream()
////                .map(employee -> employee.getName())
////                .collect(Collectors.toList());
////
////
////        employees.stream()
////                .map(employee -> new EmployeeDTO(employee))
////                .forEach(employeeDTO -> System.out.println(employeeDTO.toString()));
//
//        List<List<String>> listOfList = new ArrayList<>();
//
//        List<String> list = new ArrayList<>();
//        list.add("test1");
//
//        List<String> list2 = new ArrayList<>();
//        list2.add("test2");
//        list2.add("test3");
//
//        listOfList.add(list);
//        listOfList.add(list2);
//
//        System.out.println(listOfList);
//
//        String[] strings = listOfList.stream()
//                .flatMap(list3 -> list3.stream())
//                .toArray(String[]::new);
//
//        //System.out.println(collect);
//
//
//        Employee[] employeesArr = new Employee[5];
//        employeesArr[0] = new Employee(1,"test",2);
////
////        List<Double> collect = Arrays.stream(employeesArr)
////                .filter(employee -> employee != null)
////                .map(employee -> employee.getSalary()).fi
//                //.collect(Collectors.toList());
//
//
//        employees.stream()
//                .filter(employee -> employee.getSalary() < 0)
//                .findAny().orElse(new Employee(1,"",23));
//
//
//
//        //countries -> country(country name, continent, population)
//        //count number of countries, population > x
//        //sum of population of all countries of Europe
//
//       // countries().stream().filter(country->country.getContinent.equals("Europe")).map(country->country.getpopulation).sum();


        EmployeeBuilder employeeBuilder = EmployeeBuilder.builder.setAddressDetails("", "", 2, "")
                .setPersonalDetails("")
                .setOtherDetails(1, "", 44);
        employeeBuilder
                .build();





    }
}
////creational
//        builder
//        singleton
//        factory, abstract factory
//        prototype(cloning)
//
////structural
//adapter
//decorator
//
//
////behavioural
//observer











