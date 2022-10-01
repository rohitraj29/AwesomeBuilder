package dev.aws.awesomebuilder.repositories;

import dev.aws.awesomebuilder.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
