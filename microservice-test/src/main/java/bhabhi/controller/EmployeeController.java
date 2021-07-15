//package bhabhi.controller;
//
//import bhabhi.dto.EmployeeDTO;
//import bhabhi.service.EmployeeService;
//import dewansh.Employee;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.logging.Logger;
//
//@RestController
//@RequestMapping("employees")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService service;
//    Logger logger = LoggerFactory.getLogger(EmployeeController.class);
//
//    @GetMapping
//    public ResponseEntity<List<Employee>> getEmployees() {
//        List<bhabhi.entity.Employee> allEmplyees = service.findAllEmplyees();
//        return new ResponseEntity(allEmplyees, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
//        service.saveEmployee(employeeDTO);
//        return new ResponseEntity<>("employee saved", HttpStatus.OK);
//    }
//
//}
