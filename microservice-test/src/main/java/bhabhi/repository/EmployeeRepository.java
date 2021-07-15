package bhabhi.repository;

import bhabhi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//it is an interface
//first parameter is the entity class. second is the ID data type of that entity
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
